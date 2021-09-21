package com.example.finalprojectspringboot.Equipment;



import java.util.List;
import java.util.Optional;

public interface EquipmentService {
    List<Equipment> getEquipments();
    Optional<Equipment> get(Long id);
    void add(Equipment equipment);
    void delete(Long id);
    void update(Equipment equipment);
    List<Equipment> findAllByItemId(Long itemId);
}
