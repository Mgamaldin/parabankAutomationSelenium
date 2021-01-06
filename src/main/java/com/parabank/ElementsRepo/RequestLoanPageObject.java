package com.parabank.ElementsRepo;

public class RequestLoanPageObject {

    public static final String APPROVED_MSG = "(.//div[@ng-if='loanResponse.approved']/p)[1]";
    public static final String AMOUNT_FIELD = ".//input[@id='amount']";
    public static final String DOWNPAYMENT_FIELD = ".//input[@id='downPayment']";
    public static final String FROMACCOUNT_DROPDOWN = ".//select[@id='fromAccountId']";
    public static final String TITLE_HEADER = ".//h1[@class='title']";
    public static final String APPLY_BUTTON = ".//input[@type='submit']";
    public static final String ERROR_MSG = ".//p[@class='error']";
    public static final String LOAN_STATUS_MSG = ".//td[@id='loanStatus']";
    public static final String INSUFICIENT_FUND_MSG = ".//p[@class='error ng-scope']";

}
