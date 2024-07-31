package space.bum.social.entity;

import java.math.BigDecimal;
import java.text.NumberFormat;

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
  private BigDecimal price;
  @Transient
  private String priceStr;
  public String getPriceStr() {
    NumberFormat currency = NumberFormat.getCurrencyInstance();
    priceStr = currency.format(price);
    return priceStr;
  }
  public long getPriceNum() {
    return price.stripTrailingZeros().longValue();
  }
  
  @Transient
  private long priceNum;
  
  public void setPriceNum(long priceNum) {
    this.priceNum = priceNum;
    this.price = BigDecimal.valueOf(priceNum);
  }
  
}
