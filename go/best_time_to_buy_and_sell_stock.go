package main

import (
	"fmt"
	"math"
)

// input
var prices []int = []int{10, 20, 5, -15, 0, -30, 50, 60, 55, 40, 90, -31, 90}

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
func main() {
	answer := maxProfit(prices)
	fmt.Println(answer)
}

func maxProfit(prices []int) int {
	min := math.MaxInt

	maxProfit := 0

	for i := 0; i < len(prices); i++ {
		// get the min of prices
		if prices[i] < min {
			min = prices[i]
			fmt.Println("Min is now ", min)
		}
		if prices[i]-min > maxProfit {
			maxProfit = prices[i] - min
			fmt.Println("Maxprofit is now ", min)
		}
	}
	return maxProfit
}
