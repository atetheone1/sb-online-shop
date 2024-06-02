package tech.atetheone.sb_online_shop.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@Entity(name = "Orders")
public class Order {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private double total;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "customer_id")
  private Customer customer;

  @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
  private List<Item> items;

  public Order() {
  }

  public Order(double total, LocalDateTime createdAt, LocalDateTime updatedAt, Customer customer) {
    this.total = total;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
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
