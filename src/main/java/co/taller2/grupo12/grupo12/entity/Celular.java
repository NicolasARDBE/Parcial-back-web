package co.taller2.grupo12.grupo12.entity;


import java.time.LocalDate;

import org.hibernate.annotations.Where;

import co.taller2.grupo12.grupo12.enums.Gama;
import co.taller2.grupo12.grupo12.enums.SistemaOperativo;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Where(clause="is_active=1")
public class Celular {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String marca;
    private Long serial;
    private LocalDate fechaCompra;
    private LocalDate anioLanzamiento;
    private double precio;
    private SistemaOperativo os;
    private Gama gama;

    // Otros atributos y métodos getter/setter
}