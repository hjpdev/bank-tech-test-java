# bank-tech-test-java

Makers week 10 tech test

Simple project intended to emulate the fucntionality of a bank account.
First ever project in Java.

## How to Use

Make sure you have Java SE downloaded (& Java 9 or above required), which can be found [here](https://www.oracle.com/technetwork/java/javase/downloads/index.html)

```
  git clone https://github.com/hjpugh/bank-tech-test-java.git
  jshell --class-path D:/bank-tech-test-java/src/bin
  Then, within JShell:
  import main.java.Account;
  Account account = new Account();
  account.deposit(100.50);
  account.withdraw(50.25);
  And then, to print the statement:
  account.returnStatement().printStatement();
```

These are the main methods for interacting with the Account class, further info can be found in src/main/java.Account.java

## User Stories

```
  As a customer,
  so I know how much money I have,
  I want to be able to see my balance.

  As a customer,
  so I can increase my balance,
  I want to be able to make deposits.

  As a customer,
  so I can spend my money,
  I want to be able to make withdrawals.

  As a customer,
  so I can see previous transactions,
  I want to be able to view my statement.
```
