package edu.hbmy.sshe.dao;

import java.io.Serializable;

import edu.hbmy.sshe.model.User;

public interface UserDao {
	public Serializable save(User user);
}
