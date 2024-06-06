package tech.atetheone.sb_online_shop.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "Customers")
@Getter
@Setter @ToString
@NoArgsConstructor
@SuperBuilder
public class Customer {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String fullname;
  private String password;
  private String role;
  private double balance;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;

  @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "customer")
  private List<Order> orders;


  public Customer(String fullname, String password, String role, double balance) {
    this.fullname = fullname;
    this.password = password;
    this.role = role;
    this.balance = balance;
    this.createdAt = LocalDateTime.now();
    this.updatedAt = LocalDateTime.now();
  }

  @PrePersist
  protected void onCreate() {
    this.createdAt = LocalDateTime.now();
    this.updatedAt = LocalDateTime.now();
  }

  @PreUpdate
  protected void onUpdate() {
    this.updatedAt = LocalDateTime.now();
  }

}
