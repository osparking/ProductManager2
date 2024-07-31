package space.bum.social.entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Product {
  @Id
  @GeneratedValue
  private Long id;
  private String name;
  private String brand;
  private String madein;
  private BigDecimal price;
}
