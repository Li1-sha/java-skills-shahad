public class PayrollCalculator {
    public static double calculateWeeklyPay(String employeeType, double hoursWorked, double hourlyRate){
    double pay = 0.0;
            if (hoursWorked < 0 || hourlyRate <0){
                System.out.println("Invalid.");
                return 0.0;
            }
            switch(employeeType){
                case "FULL_TIME":
                    if (hoursWorked > 40) {
                        pay = (40 * hourlyRate) + ((hoursWorked - 40) * hourlyRate * 1.5);
                    } else {
                        pay = hoursWorked * hourlyRate;
                    }
                    break;
                case "PART_TIME":
                    if(hoursWorked <= 25)
                        pay = hoursWorked * hourlyRate;
                    break;
                case "CONTRACTOR":
                    pay = hoursWorked * hourlyRate;
                    break;
                case "INTERN":
                    if(hoursWorked <=20)
                        pay = hoursWorked*hourlyRate*0.8;
                    break;
                default:
                    System.out.println("Invalid employee type.");
                    break;
            }return pay;
    }

    public static double calculateTaxDeduction(double grossPay, boolean hasHealthInsurance){
        double tax = 0.0;
        if(hasHealthInsurance){
            if (grossPay<=500)
                tax = 0.1;
            else if(grossPay>500 && grossPay<=1000)
                tax=0.15;
            else if (grossPay>1001 && grossPay<=2000)
                tax=0.2;
            else if (grossPay>2000)
                tax=0.25;
           grossPay -= 50;

        }else{
            if (grossPay <= 500)
                tax = 0.1;
            else if (grossPay > 500 && grossPay <= 1000)
                tax = 0.15;
            else if (grossPay > 1001 && grossPay <= 2000)
                tax = 0.2;
            else if (grossPay > 2000)
                tax = 0.25;
        }
        return grossPay * tax;
    }
    public static void processPayroll(String[] employeeTypes, double[] hours, double[] rates, String[] names) {
        int minEmpHrs = Math.min(employeeTypes.length, hours.length);
        int minRateNames = Math.min(rates.length, names.length);
        int count = Math.min(minEmpHrs, minRateNames);

        double totalPay = 0;
        double highestPay = 0;
        double lowestPay = 0;
        String highestPaid = "";
        String lowestPaid = "";
        int overtimeEmployees = 0;

        System.out.println("Name\t\tType\t\t\tPay");

        for (int i = 0; i < count; i++) {
            try {
                double pay = calculateWeeklyPay(employeeTypes[i], hours[i], rates[i]);
                System.out.println(names[i] + "\t\t" + employeeTypes[i] + "\t\t$" + pay);

                totalPay += pay;

                if (pay > highestPay) {
                    highestPay = pay;
                    highestPaid = names[i];
                }

                if (pay < lowestPay) {
                    lowestPay = pay;
                    lowestPaid = names[i];
                }

                if (hours[i] > 40) {
                    overtimeEmployees++;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Skipping employee at index " + i + " due to inconsistent array lengths.");
                continue;
            }
        }
        double avgPay = 0;
        if (count > 0) {
            avgPay = totalPay / count;
        }

        System.out.println("\nSummary:");
        System.out.println("Highest Paid: "+ highestPaid + " ($" + highestPay + ")");
        System.out.println("Lowest Paid: " + lowestPaid + " ($" + lowestPay + ")");
        System.out.println("Average Pay: $" + avgPay);
        System.out.println("Overtime Employees: " + overtimeEmployees);
    }
    public static void main(String[] args){
        String[] employeeTypes = {"FULL_TIME", "PART_TIME", "CONTRACTOR", "INTERN","FULL_TIME"};
        double[] hours = {45, 20, 35, 15, 50};
        double[] rates = {25.0, 18.0, 40.0, 12.0, 30.0};
        String[] names = {"Alice", "Bob  ", "Charlie", "Diana", "Eve  "};

        //Testing individual calc
        double weekly = calculateWeeklyPay(employeeTypes[0],hours[2],rates[1] );
        System.out.println("Weekly pay "+weekly);
        System.out.println("Tax deduction: "+calculateTaxDeduction(weekly, true)+"\n");

        //entire payroll
        processPayroll(employeeTypes,hours,rates,names);
    }

}
