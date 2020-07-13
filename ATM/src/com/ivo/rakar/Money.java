package com.ivo.rakar;

import java.util.Objects;

public final class Money {
    private int tenEurosCount;
    private int twentyEurosCount;
    private int fiftyEurosCount;
    private int hundredEurosCount;

    public static Money none = new Money(0,0,0,0);
    public static Money ten = new Money(1,0,0,0);
    public static Money twenty = new Money(0,1,0,0);
    public static Money fifty = new Money(0,0,1,0);
    public static Money hundred = new Money(0,0,0,1);


    public Money(int tensCount, int twentyCount, int fiftyCount, int hundredCount) {
        if (tensCount < 0)
            throw new IllegalArgumentException();
        if (twentyCount < 0)
            throw new IllegalArgumentException();
        if (fiftyCount < 0)
            throw new IllegalArgumentException();
        if (hundredCount < 0)
            throw new IllegalArgumentException();

        tenEurosCount = tensCount;
        twentyEurosCount = twentyCount;
        fiftyEurosCount = fiftyCount;
        hundredEurosCount = hundredCount;
    }

    public double getAmount() {
        return (tenEurosCount * 10)
                + (twentyEurosCount * 20)
                + (fiftyEurosCount * 50)
                + (hundredEurosCount * 100);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return tenEurosCount == money.tenEurosCount &&
                twentyEurosCount == money.twentyEurosCount &&
                fiftyEurosCount == money.fiftyEurosCount &&
                hundredEurosCount == money.hundredEurosCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tenEurosCount, twentyEurosCount, fiftyEurosCount, hundredEurosCount);
    }

    public Money sum(Money money) {
        return new Money(money.tenEurosCount + tenEurosCount,
                money.twentyEurosCount + twentyEurosCount,
                money.fiftyEurosCount + fiftyEurosCount,
                money.hundredEurosCount + hundredEurosCount);
    }

    public Money subtract(Money money) {
        return new Money(money.tenEurosCount - tenEurosCount,
                money.twentyEurosCount - twentyEurosCount,
                money.fiftyEurosCount - fiftyEurosCount,
                money.hundredEurosCount - hundredEurosCount);
    }

    public Money allocate(double amount) {
        int hundredEurosUsed = Math.min((int)(amount / 100), hundredEurosCount);
        amount -= hundredEurosUsed * 100;

        int fiftyEurosUsed = Math.min((int)(amount / 50), fiftyEurosCount);
        amount -= fiftyEurosUsed * 50;

        int twentyEurosUsed = Math.min((int)(amount / 20), twentyEurosCount);
        amount -= twentyEurosUsed * 20;

        int tenEurosUsed = Math.min((int)(amount / 10), tenEurosCount);
        amount -= tenEurosUsed * 10;

        if(amount != 0) throw new IllegalArgumentException("The requested amount is not valid");

        return new Money(tenEurosUsed, twentyEurosUsed, fiftyEurosUsed, hundredEurosUsed);
    }

}
