package com.example.clinica_odonto.controller;

import com.example.clinica_odonto.model.Paciente;
import com.example.clinica_odonto.service.impl.PacienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/pacientes")
public class PacienteController {


    //o spring cria uma instancia do objeto automaticamente (não preciso mais usar o new)
    //Autorired serve para informar que desejo usar a instancia criada na varíavel abaixo
    @Autowired
    private PacienteServiceImpl pacienteService;


    //método POST - enviar dados
    @PostMapping
    public ResponseEntity<Paciente> salvarPaciente(@RequestBody Paciente paciente){
        return ResponseEntity.ok(pacienteService.salvar(paciente));
    }


    //método GET - recuperar dados pelo ID
    @GetMapping("/{id}")
    //tirou o <Paciente> do ResponseEntity para tbm poder retornar o body com uma msg, ou o body não funciona
    public ResponseEntity buscarPacientePorId(@PathVariable Integer id) {
        Paciente paciente = pacienteService.buscarPorId(id);

        if(paciente != null)
            return ResponseEntity.ok(pacienteService.buscarPorId(id));

        return ResponseEntity.badRequest().body("Paciente não encontrado");
    }


   // GET - recuperar todos
    @GetMapping
    public Map<Integer, Paciente> buscarTodos(){
        return pacienteService.buscarTodos();
    }


    //método PUT - atualizar dados
    @PutMapping
        public ResponseEntity<Paciente> atualizar(@RequestBody Paciente paciente) {
        ResponseEntity<Paciente> response = null;

        if (paciente.getId() != null && paciente.getEndereco().getId() != null) {
            response = ResponseEntity.ok(pacienteService.atualizar(paciente));
            return response;
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            return response;
        }
    }


    //método DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable Integer id){
        ResponseEntity<String> response = null;

        if(pacienteService.buscarPorId(id) != null){
            pacienteService.deletar(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Paciente deletado");
        }else{
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).body("Paciente não encontrado");
        }
        return response;
    }







}
