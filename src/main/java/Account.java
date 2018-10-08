class Account {

  private double balance;

  public Account() {
    double balance = 0.00;
  }

  public double currentBalance() {
    return balance;
  }

  public void deposit(double amount) {
    balance += amount;
  }
}
