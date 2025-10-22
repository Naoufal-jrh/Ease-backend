package com.demo.trellolite.Service;

import com.demo.trellolite.securityUtils.MemberUserDetails;
import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

public interface JwtService {

    String extractUsername(String token);

    <T> T extractClaim(String token, Function<Claims, T> claimsResolver); // extract all the claims from the token and fetch the exact one based on the resolver function

    String generateToken(UserDetails userDetails);

    String generateToken(Map<String, Object> extraClaims, UserDetails userDetails);

    long getExpirationTime();

    boolean isTokenValid(String token, UserDetails userDetails);

}
