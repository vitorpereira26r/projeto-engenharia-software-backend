package com.trabalhoengsw.revi.services;


import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import com.trabalhoengsw.revi.exceptions.ResourceNotFoundException;
import com.trabalhoengsw.revi.model.Ocorrencia;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class PdfServices {

    public byte[] generatePdf(Ocorrencia ocorrencia){
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            Document document = new Document();
            PdfWriter.getInstance(document, baos);

            document.open();
            System.out.println("Document opened");

            Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18);
            Paragraph title = new Paragraph("Relatório de Ocorrência", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);

            document.add(new Paragraph("\n"));

            Font subtitleFont = FontFactory.getFont(FontFactory.TIMES_BOLD, 14);
            document.add(new Paragraph(
                    "Informações da ocorrencia",
                    subtitleFont
            ));

            document.add(new Paragraph(
                    "Descrição da ocorrência: " + ocorrencia.getDescription()
            ));

            document.add(new Paragraph(
                    "Horário da ocorrência: " + ocorrencia.getData()
            ));

            document.add(new Paragraph("\n"));

            document.add(new Paragraph(
                    "Informações do Cliente",
                    subtitleFont
            ));

            document.add(new Paragraph(
                    "Nome do cliente: "
                            + ocorrencia.getCliente().getName()
            ));

            System.out.println(ocorrencia.getCliente());

            document.add(new Paragraph(
                    "Cpf do cliente: "
                            + ocorrencia.getCliente().getCpf()
            ));

            document.add(new Paragraph(
                    "Email do cliente: "
                            + ocorrencia.getCliente().getEmail()
            ));

            document.add(new Paragraph("\n"));

            document.add(new Paragraph(
                    "Informações do Veículo",
                    subtitleFont
            ));

            document.add(new Paragraph(
                    "Placa do Carro: "
                            + ocorrencia.getVeiculo().getPlaca()
            ));

            document.add(new Paragraph(
                    "Modelo do veiculo: "
                            + ocorrencia.getVeiculo().getModelo()
            ));

            document.add(new Paragraph(
                    "Ano do Carro: "
                            + ocorrencia.getVeiculo().getAno()
            ));

            document.close();

            return baos.toByteArray();

        }
        catch (DocumentException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
