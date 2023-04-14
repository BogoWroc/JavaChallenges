Context
In this checkpoint you will look at a violation of the OCP. Let's start by opening the TaxCalculator.java class. This class is responsible for computing the taxes for all the employees of a company. The taxes increase with the income of an employee

If the employee earns less than $10000, the taxes are 10%
If the employee earns between $10000 - $50000, the taxes are 25%
Else, the taxes are 35%

As a developer, you need to implement a new business rule. For some reporting situations, 
you also need to take into account the nationality of the employee. 
If the employee is not a US citizen, another 10% need to be withdrawn from their income. 
Eventually, this will be the standard way to do taxes.
