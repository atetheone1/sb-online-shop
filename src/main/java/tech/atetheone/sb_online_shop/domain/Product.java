package tech.atetheone.sb_online_shop.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "Products")
@Getter @Setter
@NoArgsConstructor @ToString
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


  public Product(String name, String description, String image, double price) {
    this.name = name;
    this.description = description;
    this.image = image;
    this.price = price;
    this.createdAt = LocalDateTime.now();
    this.updatedAt = LocalDateTime.now();
  }
}
