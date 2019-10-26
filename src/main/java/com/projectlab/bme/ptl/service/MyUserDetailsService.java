package com.projectlab.bme.ptl.service;

import com.projectlab.bme.ptl.entity.MyUserDetails;
import com.projectlab.bme.ptl.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.projectlab.bme.ptl.entity.User;
import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException{
        Optional<User> user = userRepository.findByUserName(userName);

        user.orElseThrow(() ->new UsernameNotFoundException("Not found: "+ userName));
        return user.map(MyUserDetails::new).get();
    }

}
