//package by.senla.tatianabakach.security;
//
//import by.senla.tatianabakach.entity.Credentials;
//import by.senla.tatianabakach.entity.Role;
//import by.senla.tatianabakach.repository.CredentialsRepository;
//import by.senla.tatianabakach.repository.RoleRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDate;
//import java.util.List;
//import java.util.Objects;
//import java.util.Optional;
//
//@Service
//@RequiredArgsConstructor
//public class CustomUserDetailsService implements UserDetailsService {
//
//    private final CredentialsRepository credentialsRepository;
//
//    private final RoleRepository roleRepository;
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return credentialsRepository.findByUsername(username)
//                .orElseThrow(()-> new UsernameNotFoundException(username));
//    }
//}
