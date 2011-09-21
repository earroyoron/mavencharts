package com.xpweek.activation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.xpweek.entities.Usuario;

public class ActivationServiceImpl implements ActivationService, ActionListener {

	
	private HashGenerator hasher; 
	private HashDAO hashdao;
	private Emailer emailer;
		
	public ActivationServiceImpl(HashGenerator hasher, HashDAO hashdao,
			Emailer emailer) {
		super();
		this.hasher = hasher;
		this.hashdao = hashdao;
		this.emailer = emailer;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void registerUser(Usuario user) {
		hasher.generate();
		hashdao.save();
		emailer.send();
	}

}
