package tech.atetheone.sb_online_shop.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Item {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  private int quantity;
  private double price;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;

  @ManyToOne
  @JoinColumn(name = "order_id")
  private Order order;

  @ManyToOne
  @JoinColumn(name = "product_id")
  private Product product;

  public Item() {
  }

  public Item(int quantity, double price, LocalDateTime createdAt, LocalDateTime updatedAt, Order order, Product product) {
    this.quantity = quantity;
    this.price = price;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.order = order;
    this.product = product;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public LocalDateTime getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }

  public Order getOrder() {
    return order;
  }

  public void setOrder(Order order) {
    this.order = order;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  @Override
  public String toString() {
    return "Item{" +
      "id=" + id +
      ", quantity=" + quantity +
      ", price=" + price +
      ", createdAt=" + createdAt +
      ", updatedAt=" + updatedAt +
      ", order=" + order +
      ", product=" + product +
      '}';
  }
}
