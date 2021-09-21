package com.example.finalprojectspringboot.Equipment;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Primary
@Service
public class JpaEquipmentService implements EquipmentService {
    private final EquipmentRepository equipmentRepository;

    public JpaEquipmentService(EquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
    }

    @Override
    public List<Equipment> getEquipments() {
        return equipmentRepository.findAll();
    }

    @Override
    public Optional<Equipment> get(Long id) {
        return equipmentRepository.findById(id);
    }

    @Override
    public void add(Equipment equipment) {
        equipmentRepository.save(equipment);
    }

    @Override
    public void delete(Long id) {
        equipmentRepository.deleteById(id);
    }

    @Override
    public void update(Equipment equipment) {
        equipmentRepository.save(equipment);
    }

    @Override
    public List<Equipment> findAllByItemId(Long itemId) {
        return equipmentRepository.findAllByItemId(itemId);
    }
}
