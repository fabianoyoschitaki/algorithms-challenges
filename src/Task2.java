public class Task2 {
    public static void main(String[] args) {
        Task2 s = new Task2();
        System.out.println(s.compress("ABBBCCDDCCC", 3));
        System.out.println(s.compress("AAAAAAAAAAABXXAAAAAAAAAA", 3));
        System.out.println(s.compress("ABCDDEFG", 2));
        System.out.println(s.compress("AAABBCCC", 2));
        System.out.println(s.compress("AAABBDCCC", 3));
        System.out.println(s.compress("AAABBDAAAAAA", 3));
        System.out.println(s.compress("AAABBDAAAAAAA", 3));
    }

    public int getLength(int n) {
        if (n < 2)
            return n;
        int length = 1;

        while (n > 0) {
            length++;
            n /= 10;
        }
        return length;
    }

    public int compress(String S, int K) {
        int len = S.length();
        if (len <= K) {
            return 0;
        }

        int i = 0;
        int startAt = 0;
        int endAt = 0;
        int startCost = 0;
        int endCost = 0;
        int result = len - K;

        for (i = K; i < len && S.charAt(i) == S.charAt(K); i++) {
            endAt++;
        }
        endCost = getLength(endAt);
        while (i < len) {
            int cnt = 0;
            char d = S.charAt(i);
            for (; i < len && d == S.charAt(i); i++)
                cnt++;
            endCost += getLength(cnt);
        }

        result = Math.max(result, endCost);
        if (K == 0) {
            return result;
        }

        for (i = 1; i <= len - K; i++) {
            if (i == 1) {
                startAt = 1;
                startCost = 1;
            } else {
                if (S.charAt(i - 1) == S.charAt(i - 2)) {
                    startCost += getLength(startAt + 1) - getLength(startAt);
                    startAt++;
                } else {
                    startCost++;
                    startAt = 1;
                }
            }

            if (i == len - K) {
                endCost = 0;
                endAt = 0;
            } else if (S.charAt(i + K - 1) == S.charAt(i + K)) {
                endCost += getLength(endAt - 1) - getLength(endAt);
                endAt--;
            } else {
                endCost--;
                endAt = 0;
                for (int j = i + K; j < len && S.charAt(j) == S.charAt(i + K); j++) {
                    endAt++;
                }
            }

            int cost = startCost + endCost;
            if (i != len - K && S.charAt(i - 1) == S.charAt(i + K)) {
                cost += getLength(startAt + endAt) - getLength(startAt) - getLength(endAt);
            }
            result = Math.min(result, cost);
        }

        return result;
    }
}

