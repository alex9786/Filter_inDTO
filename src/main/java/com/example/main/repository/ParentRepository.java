package com.example.main.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.main.entity.Parent;

@Repository
public interface ParentRepository extends JpaRepository<Parent, Integer>{

	Optional<Parent> findByName(String name);
	
//	@Query(value="SELECT * FROM mapping.players_details AS p "
//			+ "WHERE p.id = :key OR p.name = :key OR p.age = :key OR p.height = :key OR p.weight = :key"
//			,nativeQuery=true) 
	@Query(value = "SELECT p FROM Player p " +
            "WHERE CAST(p.id As String) LIKE %:key% OR " +
            "p.name LIKE %:key% OR " +
            "CAST(p.age As String) LIKE %:key% OR " +
            "CAST(p.height As String) LIKE %:key% OR " +
            "CAST(p.weight As String) LIKE %:key%",nativeQuery=true)
	
	List<Object> findAnyKey(Object key);
	
}
