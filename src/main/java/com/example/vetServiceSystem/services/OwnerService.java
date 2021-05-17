package com.example.vetServiceSystem.services;

import com.example.vetServiceSystem.model.Owner;
import com.example.vetServiceSystem.repositories.OwnerRepository;
import org.springframework.stereotype.Service;

@Service
public class OwnerService {
    private OwnerRepository ownerRepository;

    public Owner findOwnerById(long ownerId){
        return ownerRepository.findById(ownerId).get();
    }

    public OwnerService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }
}
