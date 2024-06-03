package tech.atetheone.sb_online_shop.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "Products")
@Getter @Setter
@NoArgsConstructor @ToString
@SuperBuilder
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String name;
  private String description;
  private String image;
  private double price;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;

  @OneToMany(fetch = FetchType.EAGER, mappedBy = "product", cascade = CascadeType.ALL)
  private List<Item> items;

}
