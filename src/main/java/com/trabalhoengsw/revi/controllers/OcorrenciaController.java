package com.trabalhoengsw.revi.controllers;

import com.trabalhoengsw.revi.exceptions.DatabaseException;
import com.trabalhoengsw.revi.exceptions.ResourceNotFoundException;
import com.trabalhoengsw.revi.model.Ocorrencia;
import com.trabalhoengsw.revi.model.dtos.OcorrenciaDto;
import com.trabalhoengsw.revi.model.dtos.OcorrenciaGetDto;
import com.trabalhoengsw.revi.repositories.OcorrenciaRepository;
import com.trabalhoengsw.revi.services.PdfServices;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/ocorrencia")
public class OcorrenciaController implements Controller<Ocorrencia> {

    @Autowired
    private OcorrenciaRepository repository;

    @Autowired
    private PdfServices pdfServices;

    private static OcorrenciaController instancia;

    public static OcorrenciaController getInstancia(){
        return instancia;
    }

    @GetMapping("/download-relatorio/{id}")
    public ResponseEntity<byte[]> downloadFile(HttpServletRequest request, @PathVariable Integer id) throws IOException {
        try {

            Ocorrencia ocorrencia = repository.getReferenceById(id);
            System.out.println(ocorrencia);

            byte[] pdfBytes = pdfServices.generatePdf(ocorrencia);

            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=GeneratedDocument.pdf");
            headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_PDF_VALUE);

            return ResponseEntity.ok()
                    .headers(headers)
                    .body(pdfBytes);

        }
        catch(EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }
    }

    @PostMapping("/create")
    public Ocorrencia createElement(@RequestBody OcorrenciaDto dto) {
        Ocorrencia ocorrencia = new Ocorrencia(
                dto.getData(),
                dto.getDescription(),
                dto.getCliente(),
                dto.getVeiculo()
        );

        return repository.save(ocorrencia);
    }

    @Override
    public Ocorrencia createElement(Ocorrencia element) {
        return null;
    }

    @Override
    @GetMapping("/get")
    public List<Ocorrencia> getElements() {
        return repository.findAll();
    }

    @Override
    @GetMapping("/get/{id}")
    public Ocorrencia getElementById(@PathVariable Integer id) {
        return repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(id)
        );
    }

    @PostMapping("/get-veiculo")
    public List<Ocorrencia> getByVeiculo(@RequestBody OcorrenciaGetDto dto){
        return repository.findByVeiculo_Placa(dto.getVeiculoPlaca());
    }

    @PostMapping("/get-cliente")
    public List<Ocorrencia> getByCliente(@RequestBody OcorrenciaGetDto dto){
        return repository.findByCliente_Email(dto.getClienteEmail());
    }

    @PostMapping("/get-data")
    public List<Ocorrencia> getByData(@RequestBody OcorrenciaGetDto dto){
        return repository.findByData(dto.getData());
    }

    @Override
    @PutMapping("/update/{id}")
    public Ocorrencia updateElement(@PathVariable Integer id, @RequestBody Ocorrencia element) {
        try{
            Ocorrencia entity = repository.getReferenceById(id);
            entity.setDescription(element.getDescription());
            return repository.save(entity);
        }
        catch(EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public void deleteElement(@PathVariable Integer id) {
        try{
            repository.deleteById(id);
        }
        catch(EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(id);
        }
        catch(DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }
}
