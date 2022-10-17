package com.example.AdmCR.Repository;

import com.example.AdmCR.Entities.Apartamentos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApartamentosRepository extends JpaRepository <Apartamentos, Integer>{
}
