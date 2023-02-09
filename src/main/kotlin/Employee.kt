package Employee
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
    fun getFullName() = when (employee.gender) {
        'm', 'M' -> "Mr. ${employee.firstName} ${employee.surname}"
        'f', 'F' -> "Ms.  ${employee.firstName} ${employee.surname}"
        else -> "${employee.firstName} ${employee.surname}"
    }

    fun getMonthlySalary() = roundTwoDecimals(grossSalary / 12)

    fun getMonthlyPRSI() = roundTwoDecimals(getMonthlySalary() * (prsiPercentage / 100))
    fun getMonthlyPAYE() = roundTwoDecimals(getMonthlySalary() * (payePercentage / 100))

    fun getGrossMonthlyPay() = roundTwoDecimals(getMonthlySalary() + (annualBonus / 12))
    fun getTotalMonthlyDeductions() = roundTwoDecimals((getMonthlyPRSI() + getMonthlyPAYE() + cycleToWorkScheme))
    fun getNetMonthlyPay() = roundTwoDecimals(roundTwoDecimals(getGrossMonthlyPay() - getTotalMonthlyDeductions()))
    fun getPayslip() {

    println("""
  --------------------------------------------------------------------------------
  -                                                                              -
  -                                Monthly Payslip                               -
  --------------------------------------------------------------------------------
  - Employee Name: ${getFullName()}                Employee ID: $employeeId                               
  -                                                                              -
  -------- PAYMENT DETAILS ---------------------DEDUCTION DETAILS-----------------
  -                                                                              -
  -  Salary:${getMonthlySalary()}                      PAYE: ${getMonthlyPAYE()}      -")
  -                                                                              -
  -  Bonus: ${annualBonus}                      PRSI: ${getMonthlyPRSI()}           -")
  -                                    Cycle to work: $cycleToWorkScheme          -
  ---------------------------------------------------------------------------------
  - Gross pay:  ${getMonthlySalary()}                         total reductions  ${getTotalMonthlyDeductions()}
  ---------------------------------------------------------------------------------
                                      Net pay:  ${getNetMonthlyPay()}
  ---------------------------------------------------------------------------------""")
    }

    override fun toString(): String {
        return "Employee(firstName='$firstName', surname='$surname', gender=$gender, employeeID=$employeeID, grossSalary=$grossSalary, payePercentage=$payePercentage, prsiPercentage=$prsiPercentage, annualBonus=$annualBonus, cycleToWorkMonthlyDeduction=$cycleToWorkMonthlyDeduction)"
    }

}

