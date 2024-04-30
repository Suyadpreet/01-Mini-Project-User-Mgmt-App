package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.UserAccount;
import com.example.repository.UserAccountRepo;

@Service
public class UserAccountServiceImpl implements UserAccountService 
{
	@Autowired
	private UserAccountRepo userAccRepo;
	@Override
	public String saveOrUpdateUserAcc(UserAccount userAcc)
	{
		if(userAcc.getUserId()==null)
		{
			userAcc.setActiveSw("Y");
		}
		Integer userId = userAcc.getUserId();
		userAccRepo.save(userAcc);
		if(userId==null)
		{
			return "User Record Saved";
		}
		else
		{
			return "User Record Updated";
		}
	}

	@Override
	public List<UserAccount> getAllUserAccounts() 
	{
		
		return userAccRepo.findAll();
	}

	@Override
	public UserAccount getUserAcc(Integer userId) 
	{
		Optional<UserAccount> findById = userAccRepo.findById(userId);
		if(findById.isPresent())
		{
			return findById.get();
		}
		else
		{
			return null;
		}
	}

	@Override
	public boolean deleteUserAcc(Integer userId) 
	{
		boolean existsById = userAccRepo.existsById(userId);
		if(existsById)
		{
			userAccRepo.deleteById(userId);
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean updateUserAccStatus(Integer userId, String status) 
	{
		try
		{
			userAccRepo.updateUserAccStatus(userId, status);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
}
