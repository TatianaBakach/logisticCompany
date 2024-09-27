package by.senla.tatianabakach.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Builder
@Table(name = "role")
public class Role extends BaseEntity implements GrantedAuthority {

    @Column(name = "role_name", nullable = false)
    private String roleName;

    @Override
    public String getAuthority() {
        return roleName;
    }
}
