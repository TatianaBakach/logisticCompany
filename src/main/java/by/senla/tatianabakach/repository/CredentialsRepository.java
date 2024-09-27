package by.senla.tatianabakach.repository;

import by.senla.tatianabakach.entity.Credentials;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface CredentialsRepository extends BaseRepository<Credentials>{
    Optional<Credentials> findByUsername(String username);
}
