package co.taller2.grupo12.grupo12.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.taller2.grupo12.grupo12.ApplicationRepository.CelularRepository;
import co.taller2.grupo12.grupo12.DTOS.CelularDTO;
import co.taller2.grupo12.grupo12.entity.Celular;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CelularService {
        
    @Autowired
    private  CelularRepository celularRepository;
   
    @Autowired
    private final ModelMapper modelMapper;
    

    public CelularService(CelularRepository celularRepository, ModelMapper modelMapper) {
        this.celularRepository = celularRepository;
        this.modelMapper = modelMapper;
    }

    public List<CelularDTO> getAllCelulares() {
        Iterable<Celular> celulares = celularRepository.findAll();
        return StreamSupport.stream(celulares.spliterator(), false)
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public CelularDTO getCelularById(Long id) {
        Optional<Celular> celularOptional = celularRepository.findById(id);
        if (celularOptional.isPresent()) {
            return convertToDTO(celularOptional.get());
        } else {
            return null;
        }
    }

    public CelularDTO createCelular(CelularDTO celularDTO) {
            Celular celular = convertToEntity(celularDTO);
            System.out.println("Datos de la entidad Celular antes del guardado:");
            System.out.println(celular);
            Celular savedCelular = celularRepository.save(celular);
            System.out.println("Datos de la entidad Celular después del guardado:");
            System.out.println(savedCelular);
            return convertToDTO(savedCelular);
    }

    public CelularDTO updateCelular(Long id, CelularDTO celularDTO) {
        Optional<Celular> celularOptional = celularRepository.findById(id);
        if (celularOptional.isPresent()) {
            Celular existingCelular = celularOptional.get();
            existingCelular.setMarca(celularDTO.getMarca());
            existingCelular.setSerial(celularDTO.getSerial());
            existingCelular.setPrecio(celularDTO.getPrecio());
            Celular updatedCelular = celularRepository.save(existingCelular);
            return convertToDTO(updatedCelular);
        } else {
            return null;
        }
    }

    public void deleteCelular(Long id) {
        celularRepository.deleteById(id);
    }

    private CelularDTO convertToDTO(Celular celular) {
        CelularDTO celularDTO = modelMapper.map(celular, CelularDTO.class);    
        return celularDTO;
    }
    

    private Celular convertToEntity(CelularDTO celularDTO) {
        Celular celular = modelMapper.map(celularDTO, Celular.class);
        return celular;
    }
}

