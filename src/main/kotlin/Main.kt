package Employee
import Employee.models.Employee
import controllers.EmployeeAPI
import mu.KotlinLogging
import kotlin.math.round

val logger = KotlinLogging.logger {}


var employees = EmployeeAPI()

fun roundTwoDecimals(number: Double) = round(number * 100) / 100
fun main(args: Array<String>) {
    logger.info { "Launching Employee App" }
    start()
    dummyData()
}

fun menu() : Int {
    print(
        """ 
        
          ┃━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┃ 
          ┃         Employee Menu              ┃ 
          ┃━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┃
          ┃   1. Add Employee                  ┃ 
          ┃   2. List All Employees            ┃ 
          ┃   3. Search Employees              ┃ 
          ┃   4. Print Payslip for Employee    ┃ 
          ┃   5. Delete                        ┃ 
          ┃   6. List all employee information ┃ 
          ┃  -1. Exit                          ┃ 
          ┃━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┃ 
          Enter Option : """.trimMargin()
    )
    return readLine()!!.toInt()
}




fun start() {
    var input: Int

    do {
        input = menu()
        when (input) {
            1 -> add()
            2 -> list()
            3 -> search()
            4 -> paySlip()
            5 -> delete()
            6 -> listAllinfo()
            -99 -> dummyData()
            -1 -> println("Exiting App")
            else -> println("Invalid Option")
        }
        println()
    } while (input != -1)
}
fun dummyData() {
    employees.create(Employee("Joe", "Soap", 'm', 0, 35655.43, 31.0, 7.5, 2000.0, 25.6))
    employees.create(Employee("Joan", "Murphy", 'f', 0, 54255.13, 32.5, 7.0, 1500.0, 55.3))
    employees.create(Employee("Mary", "Quinn", 'f', 0, 75685.41, 40.0, 8.5, 4500.0, 0.0))
}
fun list(){
    employees.findAll()
        .forEach{ println(it.toString()) }
}
fun listAllinfo() {
    if (employees.findAll().isNotEmpty()) {
        employees.findAll()
            .forEach { println("${it.getFullName()} ID: ${it.employeeID}") }


    print("Enter the employee ID you wish to select: ")
    val employeeID = readLine()!!.toInt()
    println()
    employees.findOne(employeeID)
        .let {
            println(
                """${it?.firstName}  ${it?.surname}
            |Gross Salary: ${it?.grossSalary}
            |Annual Bonus: ${it?.annualBonus}
            |Cycle to Work Deduction: ${it?.cycleToWorkMonthlyDeduction}
            |Total Salary: ${it?.getMonthlySalary()}
            |Total Deductions: ${it?.getTotalMonthlyDeductions()}
            |Net Salary: ${it?.getNetMonthlyPay()}
            |employeeID: ${it?.employeeID}
            |
            |""".trimMargin()
            )

        }

}
else {
    println("No employees found")
}

}

fun delete()
{
    val employee = getEmployeeById()
    if (employee != null)
        employees.delete(employee)
}
fun search() {
    val employee = getEmployeeById()
    if (employee == null)
        println("No employee found")
    else
        println(employee)
}
internal fun getEmployeeById(): Employee? {
    print("Enter the employee id ")
    val employeeID = readLine()!!.toInt()
    return employees.findOne(employeeID)
}
fun paySlip() {
    val employee = getEmployeeById()
    if (employee != null)
        println(employee.getPayslip())
}
fun add(){
    print("Enter first name: ")
    val firstName = readLine().toString()
    print("Enter surname: ")
    val surname = readLine().toString()
    print("Enter gender (m/f): ")
    val gender = readLine()!!.toCharArray()[0]
    print("Enter employee ID: ")
    val employeeID = readLine()!!.toInt()
    print("Enter gross salary: ")
    val grossSalary = readLine()!!.toDouble()
    print("Enter PAYE %: ")
    val payePercentage = readLine()!!.toDouble()
    print("Enter PRSI %: ")
    val prsiPercentage = readLine()!!.toDouble()
    print("Enter Annual Bonus: ")
    val annualBonus= readLine()!!.toDouble()
    print("Enter Cycle to Work Deduction: ")
    val cycleToWorkMonthlyDeduction= readLine()!!.toDouble()

    employees.create(Employee(firstName, surname, gender, 0, grossSalary, payePercentage, prsiPercentage, annualBonus, cycleToWorkMonthlyDeduction))
}
