package org.example.refactor.openclosed.after;

import org.example.refactor.openclosed.before.Employee;

import java.util.List;

public class TaxCalculator {

    // We do not want to change the API which can be used by clients.
    // Other that, we will add additional method and this one will be marked as deprecated.
    @Deprecated
    public double calculateTotalTaxes(List<Employee> employees) {
        var taxes = 0.0;

        for (var e : employees) {
            var tax =  calculateTaxForEmployee(e);
            taxes += tax;
        }

        return taxes;
    }

    public double calculateTotalTaxesWithNationalityDetails(List<Employee> employees) {
        var taxes = 0.0;

        for (var e : employees) {
            var tax =  calculateTaxForEmployee(e);
            if (e.getNationality().equalsIgnoreCase("usa")){
                tax += e.getIncome()*0.1;
            }
            taxes += tax;
        }

        return taxes;
    }

    private double calculateTaxForEmployee(Employee e) {
        double employeeTaxes = 0;
        if (e.getIncome() < 10000) {
            // 10% taxes
            employeeTaxes = e.getIncome() * 0.1;
        } else if (e.getIncome() >= 10000 && e.getIncome() < 50000) {
            // 20% taxes
            employeeTaxes= e.getIncome() * 0.25;
        } else if (e.getIncome() >= 50000) {
            // 30% taxes
            employeeTaxes= e.getIncome() * 0.35;
        }

        return employeeTaxes;
    }
}

