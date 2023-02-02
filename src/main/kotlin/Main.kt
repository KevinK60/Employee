import java.math.BigDecimal
import java.math.RoundingMode
import java.text.DecimalFormat

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
val df = DecimalFormat("#.##")
val decimal = BigDecimal(3.14159265359).setScale(2, RoundingMode.HALF_EVEN)
val firstName = "Joe"
val Surname = "Soap"
val gender = "m"
val employeeId = 6143
val grossSalary = 67543.21
val payePercentage = 38.5
val prsiPercentage = 5.2
val annualBonus = 1450.50
val cycleToWorkScheme = 54.33

fun getFullName() = "$firstName $Surname"

fun getMonthlySalary(): Double {
    return grossSalary / 12
}

fun getMonthlyPAYE(): Double {
    return (grossSalary / 12 * payePercentage / 100)
}

fun getMonthlyPRSI(): Double {
    return grossSalary / 12 * prsiPercentage / 100
}
fun getGrossMonthlyPay(): Double{
    return getMonthlySalary() + (annualBonus / 12)
}
fun getTotalMonthlyDeductions(): Double {
    return getMonthlyPAYE() + getMonthlyPRSI() + cycleToWorkScheme
}
fun getNetMonthlyPay(): Double{
    return getMonthlySalary() - getTotalMonthlyDeductions()
}
fun grosssalary(): Double {
    return (grossSalary / 12) + (annualBonus / 12)
}
 fun getPayslip() = """
  --------------------------------------------------------------------------------
  -                                                                              -
  -                                Monthly Payslip                               -
  --------------------------------------------------------------------------------
  - Employee Name: ${firstName.uppercase()} ${Surname.uppercase()}(${gender.uppercase()}                Employee ID: $employeeId                               
  -                                                                              -
  -------- PAYMENT DETAILS ---------------------DEDUCTION DETAILS-----------------
  -                                                                              -
  -  Salary:${BigDecimal(grossSalary / 12).setScale(2,RoundingMode.HALF_EVEN)}                      PAYE: ${BigDecimal(getMonthlyPAYE()).setScale(2,RoundingMode.HALF_EVEN)}      -")
  -                                                                              -
  -  Bonus: ${BigDecimal(annualBonus / 12).setScale(2,RoundingMode.HALF_EVEN)}                      PRSI: ${BigDecimal(getMonthlyPRSI()).setScale(2,RoundingMode.HALF_EVEN)}           -")
  -                                    Cycle to work: $cycleToWorkScheme          -
  ---------------------------------------------------------------------------------
  - Gross pay:  ${BigDecimal(grosssalary()).setScale(2,RoundingMode.HALF_EVEN)}                         total reductions  ${BigDecimal(getTotalMonthlyDeductions()).setScale(2,RoundingMode.HALF_EVEN)}
  ---------------------------------------------------------------------------------
                                      Net pay:  ${BigDecimal(grosssalary() - getTotalMonthlyDeductions()).setScale(2,RoundingMode.HALF_EVEN)}
  ---------------------------------------------------------------------------------")
"""
