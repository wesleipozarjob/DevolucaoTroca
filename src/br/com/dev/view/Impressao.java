/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.dev.view;

/**
 *
 * @author Wesle
 */
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Impressao {
    public Impressao(String fraseAImprimir) {
        Document documentPDF = new Document();

        try {
            PdfWriter.getInstance(documentPDF, new FileOutputStream("C:\\arquivos\\devolucao.pdf"));
            documentPDF.open();
            documentPDF.setPageSize(PageSize.A4);

            // Criar um parágrafo com a fonte menor
            Font font = new Font(Font.FontFamily.TIMES_ROMAN, 8); // Define o tamanho da fonte como 10
            Paragraph paragraph = new Paragraph(fraseAImprimir.toUpperCase(), font);
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
//openPdf
    public static void openPDF(String filePath) {
        try {
            File file = new File(filePath);
            Desktop desktop = Desktop.getDesktop();

            if (file.exists()) {
                desktop.open(file);
            } else {
                System.out.println("O arquivo PDF não foi encontrado.");
            }
           } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao gerar o PDF: arquivo não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Impressao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao gerar o PDF: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Impressao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
