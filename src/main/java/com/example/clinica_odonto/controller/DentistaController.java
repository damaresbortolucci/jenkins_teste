package com.example.clinica_odonto.controller;

import com.example.clinica_odonto.model.Dentista;
import com.example.clinica_odonto.service.impl.DentistaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/dentistas")
public class DentistaController {

    @Autowired
    private DentistaServiceImpl dentistaService;


    //SALVAR
    @PostMapping
    public ResponseEntity<Dentista> salvarDentista(@RequestBody Dentista dentista) {
        return ResponseEntity.ok(dentistaService.salvar(dentista));
    }


    //BUSCAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity buscarDentistaPorId(@PathVariable Integer id) {
        Dentista dentista = dentistaService.buscarPorId(id);

        if(dentista != null)
            return ResponseEntity.ok(dentistaService.buscarPorId(id));

        return ResponseEntity.badRequest().body("Dentista não encontrado");
    }



    // BUSCAR TODOS
    @GetMapping
    public Map<Integer, Dentista> buscarTodos(){
        return dentistaService.buscarTodos();
    }



    //ATUALIZAR
    @PutMapping
    public ResponseEntity<Dentista> atualizar(@RequestBody Dentista dentista) {
        ResponseEntity<Dentista> response = null;

        if (dentista.getId() != null) {
            response = ResponseEntity.ok(dentistaService.atualizar(dentista));
            return response;
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            return response;
        }
    }


    //DELETAR
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable Integer id){
        ResponseEntity<String> response = null;

        if(dentistaService.buscarPorId(id) != null){
            dentistaService.deletar(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Dentista deletado");
        }else{
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).body("Dentista não encontrado");
        }
        return response;
    }
}
