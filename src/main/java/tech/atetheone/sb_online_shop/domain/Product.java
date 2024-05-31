package tech.atetheone.sb_online_shop.domain;

import jakarta.persistence.*;

@Entity
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
}
