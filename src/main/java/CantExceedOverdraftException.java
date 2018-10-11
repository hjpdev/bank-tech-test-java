package main.java;

public class CantExceedOverdraftException extends RuntimeException {
  public CantExceedOverdraftException(String errorMessage) {
    super(errorMessage);
  }
}
