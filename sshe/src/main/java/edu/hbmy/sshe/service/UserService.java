package edu.hbmy.sshe.service;

import java.io.Serializable;

import edu.hbmy.sshe.model.User;

public interface UserService {
	public Serializable save(User user);
	
	public boolean isUsernameExists(User user);
}
