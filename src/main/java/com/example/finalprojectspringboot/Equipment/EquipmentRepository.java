package com.example.finalprojectspringboot.Equipment;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
List<Equipment> findAllByItemId(Long itemId);
}
