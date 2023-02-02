import java.math.BigDecimal
import java.math.RoundingMode
import java.text.DecimalFormat

fun main(args: Array<String>) {


    println("Payslip Printer")

    println(printPaySlip1())

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



fun culculatePaye(): Double {
    return (grossSalary / 12 * payePercentage / 100)
}

fun culculateprsi(): Double {
    return grossSalary / 12 * prsiPercentage / 100
}

fun totalreduction(): Double {
    return culculateprsi() + culculateprsi() + cycleToWorkScheme
}

fun grosssalary(): Double {
    return (grossSalary / 12) + (annualBonus / 12)
}
 fun printPaySlip1() = """
  --------------------------------------------------------------------------------
  -                                                                              -
  -                                Monthly Payslip                               -
  --------------------------------------------------------------------------------
  - Employee Name: ${firstName.uppercase()} ${Surname.uppercase()}(${gender.uppercase()}                Employee ID: $employeeId                               
  -                                                                              -
  -------- PAYMENT DETAILS ---------------------DEDUCTION DETAILS-----------------
  -                                                                              -
  -  Salary:${BigDecimal(grossSalary / 12).setScale(2,RoundingMode.HALF_EVEN)}                      PAYE: ${BigDecimal(culculatePaye()).setScale(2,RoundingMode.HALF_EVEN)}      -")
  -                                                                              -
  -  Bonus: ${BigDecimal(annualBonus / 12).setScale(2,RoundingMode.HALF_EVEN)}                      PRSI: ${BigDecimal(culculateprsi()).setScale(2,RoundingMode.HALF_EVEN)}           -")
  -                                    Cycle to work: $cycleToWorkScheme          -
  ---------------------------------------------------------------------------------
  - Gross pay:  ${BigDecimal(grosssalary()).setScale(2,RoundingMode.HALF_EVEN)}                         total reductions  ${BigDecimal(totalreduction()).setScale(2,RoundingMode.HALF_EVEN)}
  ---------------------------------------------------------------------------------
                                      Net pay:  ${BigDecimal(grosssalary() - totalreduction()).setScale(2,RoundingMode.HALF_EVEN)}
  ---------------------------------------------------------------------------------")
"""
