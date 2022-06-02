package com.db.articledirect.Repository;

import com.db.articledirect.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    public boolean existsByEmail(String email);
    public boolean existsUserByName(String name);

}
