package tech.atetheone.sb_online_shop.domain;

import jakarta.persistence.*;

@Entity(name = "Orders")
public class Order {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private double total;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "customer_id")
  private Customer customer;

  public Order() {
  }

  public Order(Long id, double total, Customer customer) {
    this.id = id;
    this.total = total;
    this.customer = customer;
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

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }
}
