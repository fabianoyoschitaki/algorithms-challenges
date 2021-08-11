import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;
import java.util.stream.Collectors;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class MainFindTheOutput {

    private static String BASE_URL = "https://jsonmock.hackerrank.com/api/transactions/search?userId=%d&page=%d";
    private static JSONParser PARSER = new JSONParser();
    
    /*
     * Complete the 'getUserTransaction' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER uid
     *  2. STRING txnType
     *  3. STRING monthYear
     *
     *  https://jsonmock.hackerrank.com/api/transactions/search?userId=
     */
    public static List<Integer> getUserTransaction(int uid, String txnType, String monthYear) {
        List<JSONObject> userTransactions = fetchAllUserTransactionsForMonth(uid, monthYear);
        BigDecimal monthlySpendingAverage = calculateMonthlySpendingAverage(userTransactions);
        System.out.println("monthlySpendingAverage: " + monthlySpendingAverage);
        System.out.println("uid: " + uid);
        System.out.println("txnType: " + txnType);
        System.out.println("monthYear: " + monthYear);
        List<Integer> result = userTransactions.stream()
                .filter(transaction -> transaction.get("txnType").equals(txnType))
                .filter(transaction -> parseToBigDecimal((String)transaction.get("amount")).compareTo(monthlySpendingAverage) > 0)
                .map(transaction -> ((Long) transaction.get("id")).intValue())
                .collect(Collectors.toList());
        if (result.isEmpty()){
            return Arrays.asList(-1);
        }
        return result;
    }

    private static BigDecimal calculateMonthlySpendingAverage(List<JSONObject> userTransactions) {
        BigDecimal debitSum = new BigDecimal(0);
        int debitTransactions = 0;
        for (JSONObject userTransaction : userTransactions) {
            if (userTransaction.get("txnType").equals("debit")){
                System.out.println("Found amount " + (String)userTransaction.get("amount") + " for transaction " + (Long)userTransaction.get("id") + " with timestamp " + (Long)userTransaction.get("timestamp") + " with txnType " + (String)userTransaction.get("txnType"));
                debitSum = debitSum.add(parseToBigDecimal((String)userTransaction.get("amount")));
                debitTransactions++;
            }
        }
        System.out.println("Total debit sum before dividing is: " + debitSum);
        System.out.println("Debit transactions: " + debitTransactions);
        return debitSum.divide(new BigDecimal(debitTransactions), 2, RoundingMode.UP);
    }

    private static BigDecimal parseToBigDecimal(String amountStr) {
        return new BigDecimal(amountStr.replaceAll("[$,]", ""));
    }

    private static List<JSONObject> fetchAllUserTransactionsForMonth(int uid, String monthYear) {
        JSONObject firstPage = fetchPaginatedUserTransactions(uid, 1);
        Long totalPages = (Long) firstPage.get("total_pages");

        List<JSONObject> userTransactions = new ArrayList<>();
        addUserTransactions(firstPage, userTransactions);
        for (int page = 2; page <= totalPages; page++) {
            JSONObject nPage = fetchPaginatedUserTransactions(uid, page);
            addUserTransactions(nPage, userTransactions);
        }
        int month = Integer.valueOf(monthYear.substring(0,2));
        int year = Integer.valueOf(monthYear.substring(3));
        return userTransactions.stream()
                .filter(transaction -> {
                    LocalDateTime transactionDateTime = LocalDateTime.ofInstant(
                            Instant.ofEpochMilli((Long)transaction.get("timestamp")), TimeZone.getDefault().toZoneId());
                    return transactionDateTime.getMonthValue() == month && transactionDateTime.getYear() == year;
                }).collect(Collectors.toList());
    }

    private static void addUserTransactions(JSONObject result, List<JSONObject> userTransactions) {
        ((JSONArray) result.get("data")).forEach(jObj -> {
            userTransactions.add((JSONObject) jObj);
        });
    }

    private static JSONObject fetchPaginatedUserTransactions(int uid, int page) {
        StringBuffer response = new StringBuffer();
        try {
            URL url = new URL(String.format(BASE_URL, uid, page));
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            if (HttpURLConnection.HTTP_OK != conn.getResponseCode()) {
                throw new RuntimeException("HTTP response is: " + conn.getResponseMessage());
            }
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            while (reader.ready()) {
                response.append(reader.readLine());
            }
            return (JSONObject) PARSER.parse(response.toString());
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error when forming URL: " + e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException("Error when opening connection: " + e.getMessage());
        } catch (ParseException e) {
            throw new RuntimeException("Response is an invalid JSON: " + e.getMessage());
        }
    }
}
