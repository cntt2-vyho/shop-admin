package com.justcoffeeshop.securities;

import com.justcoffeeshop.models.RoleModel;
import com.justcoffeeshop.models.UserModel;
import com.justcoffeeshop.repositories.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel userModel = userRepository.findByUsername(username).orElse(null);
        if (userModel == null) {
            throw new UsernameNotFoundException("not_found");
        }
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (RoleModel role : userModel.getRoleModels()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return new User(userModel.getUsername(), userModel.getPassword(), grantedAuthorities);
    }
}
