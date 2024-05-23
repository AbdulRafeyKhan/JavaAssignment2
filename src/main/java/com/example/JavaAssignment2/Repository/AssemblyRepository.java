package com.example.JavaAssignment2.Repository;

import com.example.JavaAssignment2.Entity.Program;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssemblyRepository extends JpaRepository<Program,Integer> {

}
