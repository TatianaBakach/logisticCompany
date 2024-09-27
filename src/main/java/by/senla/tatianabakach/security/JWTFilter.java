//package by.senla.tatianabakach.security;
//
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.validation.constraints.NotNull;
//import lombok.NonNull;
//import lombok.RequiredArgsConstructor;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContext;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//
//@Component
//@RequiredArgsConstructor
//public class JWTFilter extends OncePerRequestFilter {
//
//    public static final String BEARER_PREFIX = "Bearer ";
//    public static final String HEADER_NAME = "Authorization";
//    private final JwtService jwtService;
//    private final CustomUserDetailsService userService;
//
//
//    @Override
//    protected void doFilterInternal(@NonNull HttpServletRequest request,
//                                    @NonNull HttpServletResponse response,
//                                    @NotNull FilterChain filterChain)
//            throws ServletException, IOException {
//
//        String header = request.getHeader(HEADER_NAME);
//        if (StringUtils.isEmpty(header) || !StringUtils.startsWith(header, BEARER_PREFIX)) {
//            filterChain.doFilter(request, response);
//            return;
//        }
////        filterChain.doFilter(request, response);
////        String header = request.getHeader("access-token");
////        if (header.isEmpty()) {
////            filterChain.doFilter(request, response);
////            return;
////        }
//        String jwt = header.substring(BEARER_PREFIX.length());
//        String username = jwtService.extractUserName(jwt);
//
//        if (StringUtils.isNotEmpty(username) && SecurityContextHolder.getContext().getAuthentication() == null) {
//            UserDetails userDetails = userService
//                    .loadUserByUsername(username);
//
//            // Если токен валиден, то аутентифицируем пользователя
//            if (jwtService.isTokenValid(jwt, userDetails)) {
//                SecurityContext context = SecurityContextHolder.createEmptyContext();
//
//                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
//                        userDetails,
//                        null,
//                        userDetails.getAuthorities()
//                );
//
//                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//                context.setAuthentication(authToken);
//                SecurityContextHolder.setContext(context);
//            }
//        }
//        filterChain.doFilter(request, response);
//    }
//}
//
