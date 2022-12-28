package com.dealsandcouponsfinder.profilemanagement.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import com.dealsandcouponsfinder.profilemanagement.exception.ProfileRequestException;
import com.dealsandcouponsfinder.profilemanagement.model.Credentials;
import com.dealsandcouponsfinder.profilemanagement.model.Profile;
import com.dealsandcouponsfinder.profilemanagement.repository.CredentialsRepository;
import com.dealsandcouponsfinder.profilemanagement.repository.ProfileRepository;

@SpringBootTest
public class ProfileServiceTest {

	@Autowired
	ProfileService profileService;

	@MockBean
	private ProfileRepository profileRepository;
	@MockBean
	private CredentialsRepository credentialsRepository;

	@Test
	void saveTest() {
		Profile pro = new Profile("cvk4031@gmail.com", "keerthana", "6303990331", "Beverage1");
		when(profileRepository.save(pro)).thenReturn(pro);
		assertEquals(pro, profileService.save(pro));
	}
	@Test
	public void findAllTest() {
		Profile c1=new Profile("cvk4031@gmail.com", "keerthana", "6303990331", "Beverage1");
		Profile c2=new Profile("cvk4031@gmail.com", "keerthana", "6303990331", "Beverage1");
		Profile c3=new Profile("cvk4031@gmail.com", "keerthana", "6303990331", "Beverage1");
		Profile c4=new Profile("cvk4031@gmail.com", "keerthana", "6303990331", "Beverage1");
		List<Profile> cou= new ArrayList<>();
		cou.add(c1);
		cou.add(c2);
		cou.add(c3);
		cou.add(c4);
		
		when(profileRepository.findAll()).thenReturn(cou);
		assertEquals(profileService.findAll().size(),4);
	}
	@Test 
	 public void deleteByIdTest() throws ProfileRequestException {
		when (profileRepository.findById("cvk403@gmail.com")).thenReturn(Optional.of(new Profile("cvk403@gmail.com", "keerthana", "6303990336", "Beverage")));
		doNothing().when(profileRepository).deleteById("cvk403@gmail.com");
		assertEquals(profileService.deleteById("cvk403@gmail.com"), "Id cvk403@gmail.com deleted!");
	}	
	
	@Test
	public void findByIdTest() throws ProfileRequestException {
		when (profileRepository.findById("cvk403@gmail.com")).thenReturn(Optional.of(new Profile("cvk403@gmail.com", "keerthana", "6303990336", "Beverage")));
		Optional<Profile> profile = profileService.findById("cvk403@gmail.com");
		assertEquals("cvk403@gmail.com",profile.get().getEmailId());
		assertEquals("keerthana",profile.get().getFullName());
		assertEquals("6303990336",profile.get().getMobileNo());
		
		
	}

	
}
