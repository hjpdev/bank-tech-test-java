# bank-tech-test-java

First ever project in Java.
Simple project intended to emulate the basic functionality of a bank account, done as part of the Makers Academy course, the acceptance criteria for this are laid out below:

### Acceptance Criteria

**Given** a client makes a deposit of 1000 on 10-01-2012  
**And** a deposit of 2000 on 13-01-2012  
**And** a withdrawal of 500 on 14-01-2012  
**When** she prints her bank statement  
**Then** she would see

```
date || credit || debit || balance
14/01/2012 || || 500.00 || 2500.00
13/01/2012 || 2000.00 || || 3000.00
10/01/2012 || 1000.00 || || 1000.00
```

## How to Use

Make sure you have Java SE downloaded (& Java 9 or above also required), which can be found [here](https://www.oracle.com/technetwork/java/javase/downloads/index.html)

To interact:

In the command line:

```
  git clone https://github.com/hjpugh/bank-tech-test-java.git
  jshell --class-path D:/bank-tech-test-java/src/bin
```

Then, within JShell:

```
  import main.java.Account;
  Account account = new Account();
```
This will open a default account, with no initial balance & no overdraft. However, if you want to overriden the defaults:

```
	import main.java.Account;
	import main.java.AccountStatement;
	Account account = new Account(100, 500, new AccountStatement);
```
And this would open the account with £100 starting balance, £500 overdraft limit and the default Account Statement class, which could also be overrided if need be.

```
  account.deposit(100.50);
  account.withdraw(50.25);

  And to print the statement:

  account.returnStatement().printStatement();
  ==> "date || credit || debit || balance\n
      10/10/2018 || || 50.25 || 50.25\n
      10/10/2018 || 100.5 || || 100.5\n"
```
These are the main methods for interacting with the Account class, further info can be found in src/main/java.Account.java

Finally, to exit JShell:
  
```
  /exit
```

To run the tests:

In the command line:

```
gradle cleanTest test
```

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
  so I can pay for unpredicted expenditures,
  I want an overdraft to tide me over.
  
  As a customer,
  so I don't exceed my overdraft,
  I want to be stopped withdrawing over this amount

  As a customer,
  so I can see previous transactions,
  I want to be able to view my statement.
  
  As a bank,
  so we can encourage customers to open accounts,
  we want the ability to open them with money already in.
```
