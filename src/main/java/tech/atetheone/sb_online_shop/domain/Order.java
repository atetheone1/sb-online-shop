package tech.atetheone.sb_online_shop.domain;

import jakarta.persistence.*;

@Entity(name = "Orders")
public class Order {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private double total;

  public Order() {
  }

  public Order(Long id, double total) {
    this.id = id;
    this.total = total;
  }

  public double getTotal() {
    return total;
  }

  public void setTotal(double total) {
    this.total = total;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}
