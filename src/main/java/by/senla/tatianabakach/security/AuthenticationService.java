//package by.senla.tatianabakach.security;
//
//import by.senla.tatianabakach.entity.Credentials;
//import by.senla.tatianabakach.entity.Employee;
//import by.senla.tatianabakach.entity.Role;
//import by.senla.tatianabakach.enums.DepartmentType;
//import by.senla.tatianabakach.repository.CredentialsRepository;
//import by.senla.tatianabakach.repository.EmployeeRepository;
//import by.senla.tatianabakach.repository.RoleRepository;
//import by.senla.tatianabakach.service.EmployeeService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.HashSet;
//import java.util.Set;
//
//@Service
//@RequiredArgsConstructor
//public class AuthenticationService {
//    private final CredentialsRepository credentialsRepository;
//
//    private final EmployeeRepository employeeRepository;
//
//    private final RoleRepository roleRepository;
//    private final CustomUserDetailsService customUserDetailsService;
//    private final JwtService jwtService;
//    private final PasswordEncoder passwordEncoder;
//    private final AuthenticationManager authenticationManager;
//
//
//    /**
//     * Регистрация пользователя
//     *
//     * @param request данные пользователя
//     * @return токен
//     */
//    @Transactional
//    // добавить сотрудника
//    public JwtAuthenticationResponse signUp(SignUpRequest request) {
//
//        Credentials credentials = Credentials.builder()
//                .username(request.getUsername())
//                .password(passwordEncoder.encode(request.getPassword()))
//                .role(roleRepository.getReferenceById(1))
//                .build();
//
//        credentialsRepository.save(credentials);
//
//        Employee employee = Employee.builder()
//                .firstName("Alex")
//                .lastName("Popov")
//                .department(DepartmentType.ECONOMIC_DEPARTMENT)
//                .position("economist")
//                .email("alexpopov@gmail.com")
//                .phone("+375331112233")
//                .credentials(credentials)
//                .orders(null)
//                .build();
//
//        employeeRepository.save(employee);
//
//        String jwt = jwtService.generateToken(credentials);
//        return new JwtAuthenticationResponse(jwt);
//    }
//
//    /**
//     * Аутентификация пользователя
//     *
//     * @param request данные пользователя
//     * @return токен
//     */
//    public JwtAuthenticationResponse signIn(SignInRequest request) {
//        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
//                request.getUsername(),
//                request.getPassword()
//        ));
//
//        UserDetails credentials = customUserDetailsService
//                .loadUserByUsername(request.getUsername());
//
//        String jwt = jwtService.generateToken(credentials);
//        return new JwtAuthenticationResponse(jwt);
//    }
//}