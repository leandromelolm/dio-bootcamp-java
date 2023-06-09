package me.dio.academia.digital.controller;

import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.dto.AvaliacaoFisicaDTO;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaForm;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaUpdateForm;
import me.dio.academia.digital.service.IAvaliacaoFisicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/avaliacoes")
public class AvaliacaoFisicaController {

    @Autowired
    private IAvaliacaoFisicaService service;

    @PostMapping
    public AvaliacaoFisica create(@Valid @RequestBody AvaliacaoFisicaForm form){
        return service.create(form);
    }

    @GetMapping("/{id}")
    public AvaliacaoFisica getById(@PathVariable Long id){
        return service.get(id);
    }

    @GetMapping
    public List<AvaliacaoFisica> getAll(){
        return service.getAll();
    }

    @GetMapping("/user/{userId}")
    public List<AvaliacaoFisicaDTO> getByUserId(@PathVariable Long userId){
        return service.getAllByUser(userId);
    }

    @PutMapping("/{id}")
    public AvaliacaoFisica update(
            @PathVariable Long id,
            @Valid @RequestBody AvaliacaoFisicaUpdateForm updateForm){
        return service.update(id, updateForm);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
