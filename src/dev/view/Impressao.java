/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.view;

/**
 *
 * @author Wesle
 */
import com.lowagie.text.Document;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;


import java.util.logging.Level;
import java.util.logging.Logger;



public class Impressao {
    
    public Impressao(String fraseAImprimir) {
        Document documentPDF = new Document();

        try {
            PdfWriter.getInstance(documentPDF, new FileOutputStream("C:\\arquivos\\devolucao.pdf"));
            documentPDF.open();
            documentPDF.setPageSize(PageSize.A4);
           
            
        // Criar um parágrafo com a fonte menor
         float tamanhoFonte = 8;  // Replace with the desired font size
         String fraseMaiuscula = fraseAImprimir.toUpperCase();
            com.lowagie.text.Font font = FontFactory.getFont(FontFactory.HELVETICA, tamanhoFonte);
            
        // Create the paragraph with the custom font and add it to the PDF document
       Paragraph paragraph = new Paragraph(fraseMaiuscula, font);
        documentPDF.add(paragraph); 
            
            documentPDF.close();

    
            // Imprimir o PDF
          
openPDF("C:\\arquivos\\devolucao.pdf");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Impressao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Impressao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   public static void openPDF(String filePath) {
    try {
        File file = new File(filePath);
        Desktop desktop = Desktop.getDesktop();
        
        if (file.exists()) {
            desktop.open(file);
        } else {
            System.out.println("O arquivo PDF não foi encontrado");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}

    public static void main(String[] args) {
        TelaPrincipal Cliente = new TelaPrincipal();
        //Cliente
     

     

String frase = "";
        

        Impressao projeto = new Impressao(frase);
    }
}

