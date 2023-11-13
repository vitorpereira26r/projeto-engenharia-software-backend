package com.trabalhoengsw.revi.controllers;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.trabalhoengsw.revi.config.FileStorageProperties;
import com.trabalhoengsw.revi.model.Ocorrencia;
import com.trabalhoengsw.revi.model.dtos.OcorrenciaDto;
import com.trabalhoengsw.revi.repositories.OcorrenciaRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ocorrencia")
public class OcorrenciaController implements Controller<Ocorrencia> {

    @Autowired
    private OcorrenciaRepository repository;
    private static OcorrenciaController instancia;

    public static OcorrenciaController getInstancia(){
        return instancia;
    }

    @GetMapping("/download-relatorio/{id}")
    public ResponseEntity<byte[]> downloadFile(HttpServletRequest request, @PathVariable Integer id) throws IOException {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            Document document = new Document();
            PdfWriter.getInstance(document, baos);

            Ocorrencia ocorrencia = repository.getReferenceById(id);

            document.open();
            document.add(new Paragraph("Relatório ocorrencia do veiculo " + ocorrencia.getVeiculo().getPlaca() + " e do cliente " + ocorrencia.getCliente().getName()));
            document.add(new Paragraph("Informações da ocorrência: "));
            document.add(new Paragraph("Cliente da ocorrencia: "+ocorrencia.getCliente().getName()));
            document.add(new Paragraph("Veiculo da ocorrencia: "+ocorrencia.getVeiculo().getPlaca()));
            document.add(new Paragraph("Horario ocorrencia: "+ocorrencia.getData()));
            document.add(new Paragraph("Descrição ocorrencia: "+ocorrencia.getDescription()));
            document.close();

            byte[] pdfBytes = baos.toByteArray();

            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=GeneratedDocument.pdf");
            headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_PDF_VALUE);

            return ResponseEntity.ok()
                    .headers(headers)
                    .body(pdfBytes);

        } catch (DocumentException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
    }

    @PostMapping("/create")
    public Ocorrencia createElement(@RequestBody OcorrenciaDto dto) {
        Ocorrencia ocorrencia = new Ocorrencia(
                Instant.now(),
                dto.getDescription(),
                dto.getCliente(),
                dto.getVeiculo()
        );

        Ocorrencia newOcorrencia = repository.save(ocorrencia);
        return newOcorrencia;
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
        Optional<Ocorrencia> obj = repository.findById(id);
        return obj.get();
    }

    @Override
    @PutMapping("/update/{id}")
    public Ocorrencia updateElement(@PathVariable Integer id, @RequestBody Ocorrencia element) {
        Ocorrencia entity = repository.getReferenceById(id);
        entity.setDescription(element.getDescription());
        return repository.save(entity);
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public void deleteElement(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}
