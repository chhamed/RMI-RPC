package com.example.server;

import com.example.service.CalculatriceInterface;

public class CalculatriceServiceImpl implements CalculatriceInterface {
  @Override
  public double addition(double a, double b) {
    return a + b;
  }

  @Override
  public double multiplication(double a, double b) {
    return a * b;
  }

  @Override
  public double soustraction(double a, double b) {
    return a - b;
  }

  @Override
  public double division(double a, double b) {
    if (b == 0)
      throw new ArithmeticException("Division par zéro !");
    return a / b;
  }
}
