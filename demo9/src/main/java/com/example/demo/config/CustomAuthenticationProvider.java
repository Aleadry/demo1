package com.example.demo.config;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.swing.tree.RowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.example.demo.po.Authorities;
import com.example.demo.po.Users;
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		// TODO Auto-generated method stub
		
		String username=(String)authentication.getPrincipal();
		String password=(String)authentication.getCredentials();
		String sql = "select a.username,a.password,a.enabled" +
                " from users a" +
                " where a.username='" + username + "' and a.password='" + password + "' ";
        Users users = jdbcTemplate.queryForObject(sql,
                new BeanPropertyRowMapper<>(Users.class));
		String authoritiesSql = "select a.username,a.authority from users u " +
                " left join authorities a on u.username=a.username " +
                " where u.username='" + username + "' and u.password='" + password + "' ";

        List<Authorities> authoritiesList
                = jdbcTemplate.query(authoritiesSql, new BeanPropertyRowMapper<>(Authorities.class));
		UsernamePasswordAuthenticationToken result
        = new UsernamePasswordAuthenticationToken(
        users,users.getPassword(),authoritiesList);
		return result;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return true;
	}

}
