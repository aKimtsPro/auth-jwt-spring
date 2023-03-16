package be.technifutur.bartholomiche.service;

import be.technifutur.bartholomiche.form.UserInsertForm;
import java.util.List;

import org.springframework.stereotype.Service;

import be.technifutur.bartholomiche.model.entities.User;
import be.technifutur.bartholomiche.model.DTO.JwtHolderDTO;
import be.technifutur.bartholomiche.model.entities.Panier;
import be.technifutur.bartholomiche.model.entities.Shipping;
import be.technifutur.bartholomiche.form.LoginForm;

@Service

public interface UserService{
  void create(UserInsertForm form);
  JwtHolderDTO login(LoginForm form);
  void update(long id, UserInsertForm form);
  User getOne(long id);
  List<User> getAll();
  void delete(long id, boolean disabled);
}
