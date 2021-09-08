package com.example.the3bits.persistence.house;

import com.example.the3bits.persistence.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HouseRepository extends JpaRepository<House,Long> {
    List<House> findAllByUser(User user);
}
