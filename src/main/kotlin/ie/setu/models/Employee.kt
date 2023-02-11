package Employee.ie.setu.models
import Employee.roundTwoDecimals

class Employee(
    var firstName: String,
    var surname: String,
    var gender: Char,
    var employeeID: Int,
    var grossSalary: Double,
    var payePercentage: Double,
    var prsiPercentage: Double,
    var annualBonus: Double,
    var cycleToWorkMonthlyDeduction: Double

) {
    fun getFullName() = when (gender) {
        'm', 'M' -> "Mr. ${firstName} ${surname}"
        'f', 'F' -> "Ms.  ${firstName} ${surname}"
        else -> "${firstName} ${surname}"
    }

    fun getMonthlySalary() = roundTwoDecimals(grossSalary / 12)

    fun getMonthlyPRSI() = roundTwoDecimals(getMonthlySalary() * (prsiPercentage / 100))
    fun getMonthlyPAYE() = roundTwoDecimals(getMonthlySalary() * (payePercentage / 100))

    fun getGrossMonthlyPay() = roundTwoDecimals(getMonthlySalary() + (annualBonus / 12))
    fun getTotalMonthlyDeductions() = roundTwoDecimals((getMonthlyPRSI() + getMonthlyPAYE() + cycleToWorkMonthlyDeduction))
    fun getNetMonthlyPay() = roundTwoDecimals(roundTwoDecimals(getGrossMonthlyPay() - getTotalMonthlyDeductions()))
    fun getPayslip() {

    println("""
  --------------------------------------------------------------------------------
  -                                                                              -
  -                                Monthly Payslip                               -
  --------------------------------------------------------------------------------
  - Employee Name: ${getFullName()}                Employee ID: $employeeID                               
  -                                                                              -
  -------- PAYMENT DETAILS ---------------------DEDUCTION DETAILS-----------------
  -                                                                              -
  -  Salary:${getMonthlySalary()}                      PAYE: ${getMonthlyPAYE()} -
  -                                                                              -
  -  Bonus: ${annualBonus}                      PRSI: ${getMonthlyPRSI()}         -
  -                                    Cycle to work: $cycleToWorkMonthlyDeduction -
  ---------------------------------------------------------------------------------
  - Gross pay:  ${getMonthlySalary()}                         total reductions  ${getTotalMonthlyDeductions()}
  ---------------------------------------------------------------------------------
                                      Net pay:  ${getNetMonthlyPay()}
  ---------------------------------------------------------------------------------""")
    }

    override fun toString(): String {
        return """Employee ID: $employeeID
                  ${firstName}
                  $surname 
                  Gender ${gender.uppercaseChar()}
                  Gross salary $grossSalary"""

    }

}