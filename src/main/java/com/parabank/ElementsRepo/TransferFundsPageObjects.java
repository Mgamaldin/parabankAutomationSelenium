package com.parabank.ElementsRepo;

public class TransferFundsPageObjects {

    public static final String AMOUNT_FIELD = ".//input[@id='amount']";
    public static final String TRANSFER_BUTTON = ".//input[@type='submit']";
    public static final String TITLE_HEADER = ".//h1[@class='title']";
    public static final String TRANSFER_SUCCESSMSG = "(.//div[@class='ng-scope']/p)[1]";
    public static final String FROMACCOUNT_DROPDOWN = ".//select[@id='fromAccountId']";
    public static final String TOACCOUNT_DROPDOWN = ".//select[@id='toAccountId']";
    public static final String ERROR_AMOUNT_MSG = ".//input[@id='amount.errors']";

}
