package com.example.vetServiceSystem.services;

import com.example.vetServiceSystem.model.Owner;
import com.example.vetServiceSystem.repositories.OwnerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerService {
    private OwnerRepository ownerRepository;

    public Owner findOwnerById(long ownerId) {
        return ownerRepository.findById(ownerId).get(); //OPTIONAL OGARNAC
    }

    public void deleteById(Long id) {
        ownerRepository.deleteById(id);
    }

    public Owner saveOwner(Owner owner) {
        return ownerRepository.save(owner);
    }

    public List<Owner> findAll() {
        return ownerRepository.findAll();
    }

    public OwnerService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }
}
