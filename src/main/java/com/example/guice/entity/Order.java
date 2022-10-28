package com.example.guice.entity;

public class Order {

  public Order(String cake, String address, Double price) {
    this.setCake(cake);
    this.setAddress(address);
    this.setPrice(price);
  }

  private String cake;

  private String address;

  private Double price;

  public void setAddress(String address) {
    this.address = address;
  }

  public void setCake(String cake) {
    this.cake = cake;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public Double getPrice() {
    return price;
  }

  public String getAddress() {
    return address;
  }

  public String getCake() {
    return cake;
  }
}
