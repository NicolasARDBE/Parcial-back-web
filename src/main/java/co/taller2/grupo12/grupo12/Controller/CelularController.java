package co.taller2.grupo12.grupo12.Controller;

import co.taller2.grupo12.grupo12.DTOS.CelularDTO;
import co.taller2.grupo12.grupo12.services.CelularService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/celulares")
public class CelularController {

    @Autowired
    private CelularService celularService;

    @GetMapping
    public ResponseEntity<List<CelularDTO>> getAllCelulares() {
        List<CelularDTO> celulares = celularService.getAllCelulares();
        return new ResponseEntity<>(celulares, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CelularDTO> getCelularById(@PathVariable Long id) {
        CelularDTO celular = celularService.getCelularById(id);
        if (celular != null) {
            return new ResponseEntity<>(celular, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<CelularDTO> createCelular(@RequestBody CelularDTO celularDTO) {
        CelularDTO createdCelular = celularService.createCelular(celularDTO);
        return new ResponseEntity<>(createdCelular, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CelularDTO> updateCelular(@PathVariable Long id, @RequestBody CelularDTO celularDTO) {
        CelularDTO updatedCelular = celularService.updateCelular(id, celularDTO);
        if (updatedCelular != null) {
            return new ResponseEntity<>(updatedCelular, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCelular(@PathVariable Long id) {
        celularService.deleteCelular(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}