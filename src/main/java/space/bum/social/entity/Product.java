package space.bum.social.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
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
  private float price;  
  public String getPriceStr() {
    return String.format("%,.0f\n", price);
  }
  
  @Transient
  private String priceStr;
  public void setPriceStr(String priceStr) {
    price = Float.parseFloat(priceStr);
  }
}
