package com.codingblackfemales;

public class BasicCurrencyConverter implements CurrencyConverter {
private Currencies currencies;

public BasicCurrencyConverter(Currencies currencies){
this.currencies = currencies;
}
    
    @Override
    public double convertCurrency(String sourceCurrencyCode, String destinationCurrencyCode, double amount) throws IllegalArgumentException, NullPointerException{
          // Implementation: 
        // 1. need to get the sourceCurrency
        // 2. need to get the destinationCurrency
        // 3. sourceCurrency / destinationCurrency * amount
        // 4. return destinationCurrency 
        // 5. don't forget to implement exception handling
        
        
        // QUESTION: I would need some guidance in implmenting this Illegal Argument exception
        //if source or destination currencyCode aren't in the keys of the hashmap
        //"Invalid currency code entered. Please provide a currency code from the list available " + getCurrencyCodes())
        // QUESTION: Am i better off implementing a try with resources blok instead of multiple if statments?
        
        
        if (sourceCurrencyCode == null ){
            throw new NullPointerException("No currency code entered. Please use currency codes from the list provided " + getCurrencyCodes());
        }

        if (destinationCurrencyCode == null ){
            throw new NullPointerException("No currency code entered. Please use currency codes from the list provided " + getCurrencyCodes());
        }
        
        if (amount < 0) {
                throw new IllegalArgumentException(" Unable to convert from a negative number. Please enter an amount greater than 0");
            }

        if (amount == 0) {
                throw new NullPointerException(" Unable to convert from 0. Please enter an amount greater than 0");
            } 
       
       double convertedAmount = getExchangeRate(sourceCurrencyCode, destinationCurrencyCode) * amount;
       return convertedAmount; 
    
}

    @Override
    public String[] getCurrencyCodes() {
        //Implementation:
        // 1. use keySet() and toArray() method
        // QUESTION: Is currencies the correct implementation of this code?
        
     return currencies.getAllExchangeRates().keySet().toArray(new String [0]);
        
    }

    @Override
    public double getExchangeRate(String sourceCurrencyCode, String destinationCurrencyCode) throws IllegalArgumentException, NullPointerException{
         
// 1. in this implementation we want to get the exchange rate linked to the value from the HasMap
// 2. Then we want to divide the destination by the source to give an exchange rate value
// QUESTION: Would this be the correct implentation?
     if (sourceCurrencyCode == null ){
            throw new NullPointerException("No currency code entered. Please use currency codes from the list provided " + getCurrencyCodes());
        }

        if (destinationCurrencyCode == null ){
            throw new NullPointerException("No currency code entered. Please use currency codes from the list provided " + getCurrencyCodes());
        }

    double exchangeRateValue = currencies.getAllExchangeRates().get(sourceCurrencyCode) / currencies.getAllExchangeRates().get(destinationCurrencyCode);
    
    return exchangeRateValue;

//         Example plugging in actual values: 
//        

//         1 EUR = 1.16 GBP (EUR to GBP)
//         1 GBP = 1.31 USD (GBP to USD)

//         Divide the exchange rate from GBP to USD by the exchange rate from EUR to GBP:
//         Exchange rate EUR to USD = (Exchange rate GBP to USD) / (Exchange rate EUR to GBP) = 1.31 / 1.16 = 1.1293
//         QUESTION: So does that mean the method can only do the exhcange in a one step process similar to the example above?
//         QUESTION: How would this method become a multi step process in that case?

    }
}

// QUESTION/DISCUSS: Please can we discuss the error in the basiccurrencyconverter tests file, how would I amend error appearing on line 186 & 25?

  

//     Method 1 
//         Feedback 
//         need to modify exception handling for these methods
//          if (!currencies.getAllExchangeRates().containsKey(sourceCurrencyCode)
//             || !currencies.getAllExchangeRates().containsKey(destinationCurrencyCode)) {
//             throw new IllegalArgumentException("Invalid currency code entered. Please select from the currency codes available " + getCurrencyCodes());
//         }

//     
//     Method 2 
//         This method will return the exchange rate between the 
//         provided currencies.

//         Implementation:
//         1. currency code must be in the specified list 
//         2. return value of the desitnationCurrencyCode?
//         if (!currencies.getAllExchangeRates().containsKey(sourceCurrencyCode)
//             || !currencies.getAllExchangeRates().containsKey(destinationCurrencyCode)) {
//             throw new IllegalArgumentException("Invalid currency code entered. Please select from the currency codes available " + getCurrencyCodes());
//         }
        
//     Method 3
//         using a formula to determine this 
//         for example if I added values to the hasmap, it would always be able to give the exchange rate 


//         
//         FEEDBACK
//         What is the best way to verify that the data is correct? what is the best way/ place to put all of this?
//         this exception shouldnt be within this method --> use the method name to determine which ecxceptions I should implement in the method
//         documentation: what types of comments/documentation - clarfiy with teaching staff! 
//         can leave it till the end and make it look like this
//         /** * @param sourceCurrencyCode * @param destinationCurrencyCode * @param amount * @return */ 
//         //@Override public double convertCurrency(String sourceCurrencyCode, String destinationCurrencyCode, double amount) {
//         //return double 
//    

// //Exception handling 
// // research the best way to implement exception handling in my code 
// //a - source currency code 
// //invalid = not in the list:  if key !"GBP", "EUR", "USD", "JPY"
// // missing = null amount

// //b desitnation currency code
// //invalid = not in the list if key !"GBP", "EUR", "USD", "JPY"
// // missing = null amount

// //c amount entered 
// // invalid = less than 0 
// // null - nothing entered
