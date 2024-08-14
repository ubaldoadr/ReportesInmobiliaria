package cl.praxis.api;


import cl.praxis.api.dto.AuthenticationRequest;
import cl.praxis.api.dto.AuthenticationResponse;
import cl.praxis.service.JwtService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/auth")
public class AuthRestController {

  private final AuthenticationManager authenticationManager;
  private final UserDetailsService service;
  private final JwtService jwtService;

  public AuthRestController(AuthenticationManager authenticationManager, UserDetailsService service, JwtService jwtService) {
    this.authenticationManager = authenticationManager;
    this.service = service;
    this.jwtService = jwtService;
  }

  @PostMapping
  public ResponseEntity<AuthenticationResponse> createToken(@RequestBody AuthenticationRequest request){
    log.warn("pasando por AuthRestController createToken");
    try {
      authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),
              request.getPassword()));

      UserDetails userDetails = service.loadUserByUsername(request.getUsername());

      String jwt = jwtService.generateToken(userDetails.getUsername());
      return new ResponseEntity<>(new AuthenticationResponse(jwt), HttpStatus.OK);

    } catch (BadCredentialsException e){
      return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }
  }
}
