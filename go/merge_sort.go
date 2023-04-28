package main

import (
	"fmt"
	"math/rand"
	"strings"
	"time"
)

func main() {
	// initialize random seed
	rand.Seed(time.Now().UnixNano())

	n := make([]int, 4)
	for i := range n {
		n[i] = rand.Intn(100)
	}
	fmt.Printf("initial slice is: %v\n", n)
	mergeSort(0, n)
	fmt.Printf("sorted slice is: %v\n", n)
}

func mergeSort(level int, numbers []int) {
	fmt.Printf("%s[%d] mergeSort called with numbers: %v\n", getSpaces(level), level, numbers)
	// stop dividing when array has only 1 element
	if len(numbers) == 1 {
		return
	}

	// ====================
	// 1. DIVIDE
	// ====================

	// divide array into 2 arrays. get midpoint (inclusive)
	mid := len(numbers) / 2

	// create the halfs of array. if len(numbers) is odd, rightHalf will always have +1 element
	leftHalf := make([]int, mid)
	rightHalf := make([]int, len(numbers)-mid) // this works because division is floor (e.g. 3/2 = 1, so 3 - 1 = 2 positions)

	// populate halfs
	for i := 0; i < mid; i++ {
		leftHalf[i] = numbers[i]
	}
	for i := mid; i < len(numbers); i++ {
		rightHalf[i-mid] = numbers[i]
	}

	mergeSort(level+1, leftHalf)
	mergeSort(level+1, rightHalf)

	// merge sorted arrays
	merge(level, numbers, leftHalf, rightHalf)
}

func merge(level int, numbers, leftHalf, rightHalf []int) {
	originalNumbers := make([]int, len(numbers))
	copy(originalNumbers, numbers)
	i, l, r := 0, 0, 0
	// compare left vs right and get smaller to final array
	for l < len(leftHalf) && r < len(rightHalf) {
		if leftHalf[l] < rightHalf[r] {
			numbers[i] = leftHalf[l]
			l++
		} else {
			numbers[i] = rightHalf[r]
			r++
		}
		i++
	}
	// if there are remaining numbers at leftHalf, put them to final array
	for l < len(leftHalf) {
		numbers[i] = leftHalf[l]
		i++
		l++
	}
	// else if there are remaining numbers at rightHalf, put them to final array
	for r < len(rightHalf) {
		numbers[i] = rightHalf[r]
		i++
		r++
	}
	fmt.Printf("%s[%d] Merge result of numbers: %v, leftHalf: %v and rightHalf: %v is: %v\n", getSpaces(level), level, originalNumbers, leftHalf, rightHalf, numbers)
}

func getSpaces(level int) string {
	var builder strings.Builder
	for i := 0; i < level; i++ {
		builder.WriteString("  ")
	}
	return builder.String()
}
