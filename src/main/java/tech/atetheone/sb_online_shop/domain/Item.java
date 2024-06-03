package tech.atetheone.sb_online_shop.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Entity(name = "Items")
@Getter @Setter
@NoArgsConstructor @ToString
@SuperBuilder
public class Item {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private int quantity;
  private double price;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "order_id")
  private Order order;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "product_id")
  private Product product;
}
