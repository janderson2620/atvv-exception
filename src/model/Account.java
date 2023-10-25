

package model;

import exceptions.DomainException;

public class Account {

    Integer number;
    String holder;
    Double balance;
    Double withdrawLimit;

    public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Double getBalance() {
        return balance;
    }

    public Double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void setWithdrawLimit(Double withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }

    public void deposit(Double amount){
        balance += amount;
    }

    public void withdraw(Double amount){
        validadeWithdraw(amount);
        balance = balance - amount;
    }

    public void validadeWithdraw(Double amount){
        if(amount <= 0){
            throw new DomainException("There is no balance in the account");
        }
        if(amount > getBalance()){
            throw new DomainException("Not enough balance");
        }
        if(amount > getWithdrawLimit()){
            throw new DomainException("The amount exceeds withdraw limit");
        }
    }

    @Override
    public String toString() {
        return "New balance: " + balance;
    }
}
