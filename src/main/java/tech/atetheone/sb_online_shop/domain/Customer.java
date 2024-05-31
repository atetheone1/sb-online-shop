package tech.atetheone.sb_online_shop.domain;

import jakarta.persistence.*;

@Entity
public class Customer {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String fullname, city;
  private double balance;

  public Customer() {
  }

  public Customer(String name, String city, double balance) {
    this.fullname = name;
    this.city = city;
    this.balance = balance;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFullname() {
    return fullname;
  }

  public void setFullname(String name) {
    this.fullname = name;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public double getBalance() {
    return balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }
}
