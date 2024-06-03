package tech.atetheone.sb_online_shop.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.List;


@Entity(name = "Orders")
@Getter @Setter
@NoArgsConstructor @ToString
@SuperBuilder
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

  @OneToMany(fetch = FetchType.EAGER, mappedBy = "order", cascade = CascadeType.ALL)
  private List<Item> items;

  public double getTotal() {
    total = 0.0;
    for (Item item : items) {
      total += item.getPrice() * item.getQuantity();
    }
    return total;
  }
}
