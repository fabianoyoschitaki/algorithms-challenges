package main

import "fmt"

// In an alien language they also use English lowercase letters, but possibly in a different order.
// The order of the alphabet is some permutation of lowercase letters. Given a sequence of words written
// in the alien language, and the order of the alphabet, return true if and only if the given words are
// sorted lexicographically in this alien language.

// Input: words = ["hello", "uber"], order = "huabcdefgijklmnopqrstvwxyz"
// Output: true (because h of hello is before u of uber)

// Input: words = ["word", "world", "row"], order = "worldabcefghijkmnpqstuvxyz"
// Output: false (because l in world comes before d in word and word is placed before world)
func main() {
	words := []string{"hello", "uber"}
	order := "huabcdefgijklmnopqrstvwxyz"
	fmt.Printf("Answer is: %t\n\n", isSorted(words, order)) // should be true because 'h'ello comes before 'u'uber

	words2 := []string{"word", "world", "row"}
	order2 := "worldabcefghijkmnpqstuvxyz"
	fmt.Printf("Answer is: %t\n\n", isSorted(words2, order2)) // should be false because wor'd' comes after wor'l'd

	words3 := []string{"word", "word", "word"}
	order3 := "worldabcefghijkmnpqstuvxyz"
	fmt.Printf("Answer is: %t\n\n", isSorted(words3, order3)) // should be true because they're all the same

	words4 := []string{"worda", "word"}
	order4 := "worldabcefghijkmnpqstuvxyz"
	fmt.Printf("Answer is: %t\n\n", isSorted(words4, order4)) // should be false because word'a' is lexicographically bigger than empty
}

func isSorted(words []string, order string) bool {
	orderMap := make(map[rune]int)

	// TODO understand if this is the best way to traverse a string
	// TODO understand rune vs byte relation (how to use chars)
	for i, char := range order {
		orderMap[char] = i
	}

	fmt.Printf("Map order is: %v\n", orderMap)
	for i := 1; i < len(words); i++ {
		// getting strings as runes
		firstWordRunes := []rune(words[i-1])
		secondWordRunes := []rune(words[i])
		smallerSize := len(firstWordRunes)
		if len(secondWordRunes) < smallerSize {
			smallerSize = len(secondWordRunes)
		}

		fmt.Printf("Comparing [%s] with [%s]. Using smaller word size of [%d]\n", string(firstWordRunes), string(secondWordRunes), smallerSize)

		for pos := 0; pos < smallerSize; pos++ {
			fmt.Printf("Comparing char of first word [%s] with char of second word [%s]\n", string(firstWordRunes[pos]), string(secondWordRunes[pos]))
			if orderMap[firstWordRunes[pos]] > orderMap[secondWordRunes[pos]] {
				// if firstWord[pos] > secondWord[pos], then it's not sorted, return false right away
				fmt.Println("Returning false. First word comes after second word.")
				return false
			} else if orderMap[firstWordRunes[pos]] < orderMap[secondWordRunes[pos]] {
				fmt.Println("Breaking to continue to next word comparison since. First word comes before second word.")
				break
			}
		}
		// if loop ended, it means both words are equal. however, if firstWord is bigger then secondWord,
		// it means firstWord has extra characters while second word already finished. this means firstWord comes after secondWord, so should return false
		if len(firstWordRunes) > len(secondWordRunes) {
			fmt.Println("Returning false. First word comes after second word because its bigger although secondWord has the same characters as firstWord.")
			return false
		}
	}
	// if firstWord was always before secondWord, then return true
	return true
}
