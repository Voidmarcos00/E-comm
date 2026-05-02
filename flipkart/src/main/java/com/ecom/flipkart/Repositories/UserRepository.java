package com.ecom.flipkart.Repositories;

import com.ecom.flipkart.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>  //<Entity, PK>
{}
