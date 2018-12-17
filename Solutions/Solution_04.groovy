def GetSum(number01, number02)
{
	// Type checking and Addition

	if((number01.getClass() == Integer) && (number02.getClass() == Integer))
	{
		sum = number01 + number02
		return sum
	}
	else
	{
		println "[ERROR]: Unable to add."
	}
}

print "Enter first the number: "
// When we read a value from the standard input it arrives as a string so we need type conversion.
def number01 = System.console().readLine() as Integer
print "Enter second the number: "
def number02 = System.console().readLine() as Integer

// Calling the function
def result = GetSum(number01, number02)
println("Result: " + result)

