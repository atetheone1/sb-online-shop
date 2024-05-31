package tech.atetheone.sb_online_shop.domain;

import jakarta.persistence.*;

@Entity
public class Customer {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String name, city;
  private int balance;
}
