def EmpData = ["Name":"Anupam", "EmpID":35]

print "Enter the Key: "
def Key = System.console().readLine()

if(EmpData.containsKey(Key)) 
{
	println "Value is: " + EmpData[Key]
}
else
{
	println "Key is not present."
}

