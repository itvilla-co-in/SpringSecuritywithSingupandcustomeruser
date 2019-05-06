package com.itvilla.springdemo.entity;


import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.userfront.domain.security.Authority;
//import com.userfront.domain.security.UserRole;

@Entity
@Table(name="usertemp")
public class UserProfile implements UserDetails{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId", nullable = false, updatable = false)
    private Long userId;
    
    @NotNull(message="Username field is mandatory with size between 5 to 10 chars")
	@Size(min=5, message="Username field is mandatory with size between 5 to 10 chars")
    @Size(max=10, message="is required")
    private String username;
    
    @Pattern(regexp="^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$", message="Minimum eight characters, atleast 1 uppercase, 1 lowercase, one number and 1 special character")
    private String password;
    
    @NotNull(message="firstname field is mandatory with size between 5 to 20 chars")
	@Size(min=5, message="firstname field is mandatory with size between 5 to 20 chars")
    @Size(max=20, message="is required")
    private String firstName;
    @NotNull(message="LastName field is mandatory with size between 5 to 20 chars")
	@Size(min=5, message="LastName field is mandatory with size between 5 to 20 chars")
    @Size(max=20, message="is required")
    private String lastName;

    @Column(name = "email", nullable = false, unique = true)
    @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Please enter a valid email address")
    private String email;
    @Pattern(regexp="\\d{10}|\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}|\\d{3}-\\d{3}-\\d{4}\\s(x|(ext))\\d{3,5}|\\(\\d{3}\\)-\\d{3}-\\d{4}", message="Please enter a valid Phone Number of 10 digits like 1234567890  123-456-7890 (123)-456-7890 123.456.7890")
    private String phone;

    private boolean enabled=true;







    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<UserRole> userRoles = new HashSet<UserRole>();


    public UserProfile() {
		// TODO Auto-generated constructor stub
	}
    
	public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

   

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

   

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    

    
    
    
    public boolean isEnabled() {
		return enabled;
	}
    
    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                //", appointmentList=" + appointmentList +
               // ", recipientList=" + recipientList +
//                ", userRoles=" + userRoles +
                '}';
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new HashSet<>();
        userRoles.forEach(ur -> authorities.add(new Authority(ur.getRole().getName())));
        return authorities;
    }

	
    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }


}
