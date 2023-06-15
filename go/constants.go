package main

import "fmt"

// Working with Constants in Golang
// https://www.callicoder.com/golang-typed-untyped-constants/
func main() {

	// Literals are constants, we can specify without a type
	const integerConst1, integerConst2 = 1000, 67413
	const floatPointConst1, floatPointConst2 = 4.56, 128.372
	const booleanConst1, booleanConst2 = true, false
	const runeConst1, runeConst2 = 'C', 'ä'           // println and printf %v = 67 228
	const complexConst1, complexConst2 = 2.7i, 3 + 5i // println and printf %v (0+2.7i) (3+5i)
	const stringConst1, stringConst2 = "Hello", "World"

	// we can also specify with type
	const stringConst3, stringConst4 string = "Hello1", "World1"

	// multiple declarations in a single statement is also possible
	const country, code = "India", 91
	const (
		country1 string = "India"
		code1    int    = 91
	)

	// consts cannot be changed
	const cannotChange = true
	// cannotChange = false // cannot assign to cannotChange (untyped bool constant true)compilerUnassignableOperand

	var float_1 float64 = 21.54
	var int_1 int = 562
	var int64_1 int64 = 120

	// var res1 = float_1 + int_1 // Not Allowed (Compiler Error)
	// var res2 = int_1 + int64_1 // Not Allowed (Compiler Error)
	var res1 = float_1 + float64(int_1)
	var res2 = int_1 + int(int64_1)
	fmt.Println("It only works when casting: ", res1, res2) // 583.54 682

	// If you’ve worked with other statically typed languages like C, C++ or Java, then you must be aware that they
	// automatically convert smaller types to larger types whenever you mix them in any operation.
	// For example, int can be automatically converted to long, float or double.
	// So the obvious question is that - why doesn’t Go do the same? why doesn’t it perform implicit type conversions like C, C++ or Java?
	// https://golang.org/doc/faq#conversions

	// The convenience of automatic conversion between numeric types in C is outweighed by the confusion it causes. When is an expression unsigned?
	// How big is the value? Does it overflow? Is the result portable, independent of the machine on which it executes?
	// It also complicates the compiler; “the usual arithmetic conversions” are not easy to implement and inconsistent across architectures.
	// For reasons of portability, we decided to make things clear and straightforward at the cost of some explicit conversions in the code.
	// (Excerpt from Golang’s official doc)

	// ===============================================================
	// Untyped Constants
	// ===============================================================

	// Any constant in golang, named or unnamed, is untyped unless given a type explicitly. For example, all of the following constants are untyped -
	// 1       // untyped integer constant
	// 4.5     // untyped floating-point constant
	// true    // untyped boolean constant
	// "Hello" // untyped string constant

	// They are untyped even after you give them a name -
	const a = 1
	const f = 4.5
	const b = true
	const s = "Hello"

	// The fact that the value 1 is untyped allows us to assign it to any variable whose type is compatible with integers.
	// Note that, Although the value 1 is untyped, it is an untyped integer.
	// So it can only be used where an integer is allowed. You cannot assign it to a string or a boolean variable for example.
	var myInt int = 1
	var myFloat float64 = 1
	var myComplex complex64 = 1
	fmt.Println("number 1 as int, float and complex: ", myInt, myFloat, myComplex) // 1 1 (1+0i)

	// Similarly, an untyped floating-point constant like 4.5 can be used anywhere a floating-point value is allowed -
	var myFloat32 float32 = 4.5
	var myComplex64 complex64 = 4.5
	fmt.Println("number 4.5 as float32, complex64: ", myFloat32, myComplex64) // 4.5 (4.5+0i)

	// ===============================================================
	// Untyped string constant
	// ===============================================================

	// Let’s now see an example of an untyped string constant-
	// In Golang, you can create a type alias using the type keyword like so-
	type RichString string // type alias of string

	// Given the strongly typed nature of Golang, you can’t assign a string variable to a RichString variable-
	var myString string = "Hello"
	// var myRichString RichString = myString // Given the strongly typed nature of Golang, you can’t assign a string variable to a RichString variable-

	var myRichString RichString = RichString(myString) // this works
	fmt.Println("myRichString value from var myString only works with casting:", myRichString)

	// But, you can assign an untyped string constant to a RichString variable because it is compatible with strings -
	const myUntypedString = "Hello"
	var myRichString2 = myUntypedString
	fmt.Println("myRichString2 value from const myUntypedString works without casting:", myRichString2)

	// ===============================================================
	// Constants and Type inference: Default Type
	// ===============================================================
	var inferencedTypeInt = 5                                           // Go compiler automatically infers the type of the variable `inferencedTypeInt` to int
	fmt.Printf("type of inferencedTypeInt is: %T\n", inferencedTypeInt) // int

}
