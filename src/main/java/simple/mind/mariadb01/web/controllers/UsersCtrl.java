package simple.mind.mariadb01.web.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import simple.mind.mariadb01.db.user.dao.model.UserInformation;
import simple.mind.mariadb01.db.user.dao.model.Users;
import simple.mind.mariadb01.db.user.dao.repositories.UserInformationRepository;
import simple.mind.mariadb01.db.user.dao.repositories.UsersRepository;

@RestController
public class UsersCtrl {
	@Autowired
	UsersRepository user;

	@Autowired
	UserInformationRepository cr;

	@GetMapping("/users/")
	public List<UserInformation> getAllUser() {
		return cr.findAll();
	}

	@GetMapping("/user/")
	public UserInformation getUserByAddress(@RequestParam String address) {
		return cr.findByAddress(address);
	}

	@GetMapping("/user/id/{id}")
	public Optional<Users> getUserById(@PathVariable(value = "id") Integer id) {
		return user.findById(id);
	}

}
