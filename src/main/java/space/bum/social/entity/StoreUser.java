package space.bum.social.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "store_users")
public class StoreUser {
  @Id
  @Column(name="user_id")
  private Long id;
  private String username;
  private String password;
  private String role;
  private boolean enabled;
}
