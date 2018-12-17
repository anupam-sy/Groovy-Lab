// Script Information
println "\n ---> Percentage Calculator Utility <---"
println "[Subjects]: Hindi English Math Science SocialScience \n"

def GetStudentsData()
{
def StudentData = [:]

print "Enter the number of Students: "
def StudentCount = System.console().readLine() as Integer

while(StudentCount >= 1)
{
    print "Enter the name of Student: "
    def StudentName = System.console().readLine()
    
    print "Enter the marks in the above order with space delimiter: "
    def StudentMarks = System.console().readLine()
    def StudentMarksList = StudentMarks.tokenize()
    
    StudentData[StudentName.trim()] = StudentMarksList

    StudentCount--
}
return StudentData
}

def DataValidation(StudentData)
{
    def StudentsFinalData = [:]

    for(Item in StudentData)
    {
        if(Item.value.size() == 5)
        {
            int flag = 1
            for(marks in Item.value)
            {
                if(marks.toInteger() > 100 || marks.toInteger() < 0)
                {
                    flag++
                    break
                }
            }
            if(flag == 1)
            {
                StudentsFinalData[(Item.key)] = (Item.value)
            }
            else
            {
                println "Data incorrect for student, " + Item.key + ". [REASON]: Incorrect marks value found."
            } 
        }
        else
        {
            println "Data incorrect for student, " + Item.key + ". [REASON]: Subject marks are more or less than 5."
        }

    }
return StudentsFinalData
}

def DivisonCalculator(StudentsFinalData)
{   
    def HonoursStudentsList = []
    def FirstDivisonStudentsList = []
    def SecondDivisonStudentsList = []
    def ThirdDivisonStudentsList = []
    
    for(Item in StudentsFinalData)
    {
        int sum = 0
        for(marks in Item.value)
        {
            sum += marks.toInteger()
        }
        StudentPercentage = ((sum/500)*100)
        
        switch(StudentPercentage.toInteger())
        {
        case 75..100:
            HonoursStudentsList.push(Item.key);
            break;
        case 60..74:
            FirstDivisonStudentsList.push(Item.key);
            break;
        case 45..60:
            SecondDivisonStudentsList.push(Item.key);
            break;
        default:
            ThirdDivisonStudentsList.push(Item.key);
            break;
        }

    }
    
    // Printing the output
    println "\n\nCalculated Data:"
    println "Honors Students: " + HonoursStudentsList
    println "FirstDivison Students: " + FirstDivisonStudentsList
    println "SecondDivison Students: " + SecondDivisonStudentsList
    println "ThirdDivison Students: " + ThirdDivisonStudentsList
    
}

// function calling
def StudentData = GetStudentsData()
def StudentsFinalData = DataValidation(StudentData)
DivisonCalculator(StudentsFinalData)