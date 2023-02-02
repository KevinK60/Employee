
import java.math.BigDecimal
import java.math.RoundingMode


import kotlin.math.round

val decimal = BigDecimal(3.14159265359).setScale(2, RoundingMode.HALF_EVEN)
val firstName = "Joe"
val Surname = "Soap"
val gender: Char = 'm'
val employeeId = 6143
val grossSalary = 67543.21
val payePercentage = 38.5
val prsiPercentage = 5.2
val annualBonus = 1450.50
val cycleToWorkScheme = 54.33
var employee =  Employee("Joe", "Soap", 'm', 6143, 67543.21, 38.5, 5.2, 1450.50, 54.33)

fun roundTwoDecimals(number: Double) = round(number * 100) / 100
fun main(args: Array<String>){

    var input : Int

    do {
        input = menu()
        when(input) {
            1 -> println("Monthly Salary: ${getMonthlySalary()}")
            2 -> println("Monthly PRSI: ${getMonthlyPRSI()}")
            3 ->println("Monthly PAYE: ${getMonthlyPAYE()}")
            4 -> println("Monthly Gross Pay: ${getGrossMonthlyPay()}")
            5 -> println("Monthly Total Deductions: ${getTotalMonthlyDeductions()}")
            6 -> println("Monthly Net Pay: ${getNetMonthlyPay()}")
            7 -> println(getPayslip())
            -1 -> println("Exiting App")
            else -> println("Invalid Option")
        }
        println()
    } while (input != -1)
}

fun menu() : Int {
    print("""
         Employee Menu for ${getFullName()}
           1. Monthly Salary
           2. Monthly PRSI
           3. Monthly PAYE
           4. Monthly Gross Pay
           5. Monthly Total Deductions
           6. Monthly Net Pay
           7. Full Payslip
          -1. Exit
         Enter Option : """)
    return readLine()!!.toInt()
}

fun getFullName() = when (employee.gender){
    'm', 'M' -> "Mr. ${employee.firstName} ${employee.surname}"
    'f', 'F' -> "Ms.  ${employee.firstName} ${employee.surname}"
    else ->  "${employee.firstName} ${employee.surname}"
}


fun getMonthlySalary() = roundTwoDecimals(grossSalary / 12)

fun getMonthlyPRSI() = roundTwoDecimals(getMonthlySalary() * (prsiPercentage / 100))
fun getMonthlyPAYE() = roundTwoDecimals(getMonthlySalary() * (payePercentage / 100))

fun getGrossMonthlyPay() = roundTwoDecimals(getMonthlySalary() + (annualBonus / 12))
fun getTotalMonthlyDeductions() = roundTwoDecimals((getMonthlyPRSI() + getMonthlyPAYE() + cycleToWorkScheme))
fun getNetMonthlyPay() = roundTwoDecimals(roundTwoDecimals(getGrossMonthlyPay() - getTotalMonthlyDeductions()))
 fun getPayslip() = """
  --------------------------------------------------------------------------------
  -                                                                              -
  -                                Monthly Payslip                               -
  --------------------------------------------------------------------------------
  - Employee Name: ${firstName.uppercase()} ${Surname.uppercase()}(${gender.uppercase()}                Employee ID: $employeeId                               
  -                                                                              -
  -------- PAYMENT DETAILS ---------------------DEDUCTION DETAILS-----------------
  -                                                                              -
  -  Salary:${getMonthlySalary()}                      PAYE: ${getMonthlyPAYE()}      -")
  -                                                                              -
  -  Bonus: ${annualBonus}                      PRSI: ${ getMonthlyPRSI() }           -")
  -                                    Cycle to work: $cycleToWorkScheme          -
  ---------------------------------------------------------------------------------
  - Gross pay:  ${getMonthlySalary()}                         total reductions  ${getTotalMonthlyDeductions()}
  ---------------------------------------------------------------------------------
                                      Net pay:  ${getNetMonthlyPay()}
  ---------------------------------------------------------------------------------")
"""
