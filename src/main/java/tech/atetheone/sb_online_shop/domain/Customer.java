package tech.atetheone.sb_online_shop.domain;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity(name = "Customers")
public class Customer {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String fullname;
  private String password;
  private String role;
  private double balance;
  private LocalDate createdAt;
  private LocalDate updatedAt;

  @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "customer")
  private List<Order> orders;

  public Customer() {
  }

  public Customer(String fullname, String password, String role, double balance, LocalDate createdAt, LocalDate updatedAt) {
    this.fullname = fullname;
    this.password = password;
    this.role = role;
    this.balance = balance;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
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

  public void setFullname(String fullname) {
    this.fullname = fullname;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public double getBalance() {
    return balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }

  public LocalDate getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDate createdAt) {
    this.createdAt = createdAt;
  }

  public LocalDate getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(LocalDate updatedAt) {
    this.updatedAt = updatedAt;
  }

  public List<Order> getOrders() {
    return orders;
  }

  public void setOrders(List<Order> orders) {
    this.orders = orders;
  }

  @Override
  public String toString() {
    return "Customer{" +
            "id=" + id +
            ", fullname='" + fullname + '\'' +
            ", password='" + password + '\'' +
            ", role='" + role + '\'' +
            ", balance=" + balance +
            ", createdAt=" + createdAt +
            ", updatedAt=" + updatedAt +
            ", orders=" + orders +
            '}';
  }
}
