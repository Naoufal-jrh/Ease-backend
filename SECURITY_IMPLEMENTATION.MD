### 1. Add dependencies
```xml
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-security</artifactId>
        </dependency>

        <!-- Optional for JWT-based auth -->
        <dependency>
            <groupId>io.jsonwebtoken</groupId>
            <artifactId>jjwt-api</artifactId>
            <version>0.11.5</version>
        </dependency>
        <dependency>
            <groupId>io.jsonwebtoken</groupId>
            <artifactId>jjwt-impl</artifactId>
            <version>0.11.5</version>
            <scope>runtime</scope>
        </dependency>
        <dependency>
            <groupId>io.jsonwebtoken</groupId>
            <artifactId>jjwt-jackson</artifactId>
            <version>0.11.5</version>
            <scope>runtime</scope>
        </dependency>
```

### 2. Define and Create User 
in our case i will add a simple user with an id, full name, email, password, created at, updated at and finally a list of boards.

### 3. UserDetails Class and UserDetailsService class
Create a custom UserDetails class that wraps the user class you created earlier.

### 4. Password Encoder
Create the bean of the password encoder with the algorithm you want it will be used to hash the password

### 5. Authentication Provider
The Authentication provider defines how you are going to authenticated the user, i will start with a simple DoaAuthenticationProviders that authenticates the user based on credentials saved in a db.

### 6. Authentication Manager
We use the Spring Security configuration class AuthenticationConfiguration.

Spring Boot automatically configures your AuthenticationManager based on all registered AuthenticationProvider beans (e.g., DaoAuthenticationProvider, JwtAuthenticationProvider, etc.), and exposes it through AuthenticationConfiguration.

Spring does the following behind the scenes:

- Looks at all beans that implement AuthenticationProvider (e.g., your DaoAuthenticationProvider, LdapAuthenticationProvider, etc.)

- Combines them into a single ProviderManager, which is the actual implementation of AuthenticationManager.

- Returns that fully configured instance to you.

It is initialized using the singleton pattern

### 7. Implement Security Configuration
In this step we need to define the Security Filter Chain Bean, basically this is where we define the authentication and authorization flow.

for now this is our config :
- no csrf check
- all routes are authenticated except the /auth routes
- no sessions are used since we will be using jwt
- disable the form login

### 8. JWT service
The end goal of this service is to build the token to return it to the client and to take the token and extract the claims.

A JWT consists of three parts, separated by dots (.)

Header. Payload. Signature

https://www.geeksforgeeks.org/web-tech/json-web-token-jwt/

### 9. Authentication Service
in the authenticate function we use the authentication manager to see if the user credentials are correct.

🛠 Under the hood:

Spring Security looks for an implementation of UserDetailsService.

It calls your custom method:

loadUserByUsername(email)


to retrieve user details (like hashed password, roles, etc.).

Then it compares the provided password (user.getPassword()) with the stored hashed password using your configured PasswordEncoder (e.g. BCrypt).

If the password is correct, authentication succeeds.

If not, it throws an exception like BadCredentialsException.

### 10. Authentication Controller

registration endpoint

login endpoint


