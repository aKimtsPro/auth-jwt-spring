package be.technifutur.bartholomiche.service;

import java.util.List;
import java.util.*;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import be.technifutur.bartholomiche.JWT.JwtProvider;
import be.technifutur.bartholomiche.form.LoginForm;
import be.technifutur.bartholomiche.form.UserInsertForm;
import be.technifutur.bartholomiche.model.DTO.JwtHolderDTO;
import be.technifutur.bartholomiche.model.entities.Panier;
import be.technifutur.bartholomiche.model.entities.Shipping;
import be.technifutur.bartholomiche.model.entities.User;
import be.technifutur.bartholomiche.repository.UserRepository;

@Service

public class UserServiceImpl  implements UserService{
private final UserRepository userRepository;
private final AuthenticationManager authenticationManager;
private final JwtProvider jwtProvider;
private final PasswordEncoder passwordEncoder;
public UserServiceImpl(PasswordEncoder passwordEncoder, UserRepository userRepository, AuthenticationManager authenticationManager, JwtProvider jwtProvider){
    this.userRepository = userRepository;
    this.authenticationManager = authenticationManager;
    this.jwtProvider = jwtProvider;
    this.passwordEncoder = passwordEncoder;
}
    @Override
    public void create(UserInsertForm form) {
       User user = form.toEntity();
       Panier panier = new Panier();
//       this.userRepository.save(user);
//       panier.setUser(this.userRepository.findById(user.getId()).get());
    // plus efficace de cette manière:
       user = this.userRepository.save(user);
       panier.setUser(user);

       user.setPassword(passwordEncoder.encode(user.getPassword()));
       userRepository.save(user);
        
    }

    @Override
    public void update(long id, UserInsertForm form) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public User getOne(long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<User> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void delete(long id, boolean disabled) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public JwtHolderDTO login(LoginForm form) {
        Authentication auth =  new UsernamePasswordAuthenticationToken(form.getUsername(), form.getPassword());
        auth = authenticationManager.authenticate(auth);
        String token = jwtProvider.createToken(auth);
        return new JwtHolderDTO(token);
    }
    
}
