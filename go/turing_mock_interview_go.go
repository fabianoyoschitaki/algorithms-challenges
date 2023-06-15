package main

import (
	"fmt"
	"reflect"
)

// Turing - Golang Mock Interview - https://www.youtube.com/watch?v=5NA35Cuo35k
func main() {
	getObjectTypes()
}

// ========================================
// Ways to get types of objects?
// ========================================
func getObjectTypes() {
	var integer int
	type MyInt int
	var myInteger MyInt

	// 1. Using the fmt.Printf function with the %T verb:
	fmt.Printf("Type integer via fmt is: %T\n", integer)     // int
	fmt.Printf("Type myInteger via fmt is: %T\n", myInteger) // main.MyInt

	// 2. Using the reflect.TypeOf function:
	fmt.Printf("Type integer via reflection is: %s\n", reflect.TypeOf(integer))     // int
	fmt.Printf("Type myInteger via reflection is: %s\n", reflect.TypeOf(myInteger)) // main.MyInt

	// 3. Using type assertion to check the type of an interface value:
	var i interface{} = 42 // i is an integer
	// var i interface{} = MyInt(52) // i is an MyInt
	if _, ok := i.(int); ok {
		fmt.Println("i is an integer")
	}
	if _, ok := i.(MyInt); ok {
		fmt.Println("i is an MyInt")
	}

}
