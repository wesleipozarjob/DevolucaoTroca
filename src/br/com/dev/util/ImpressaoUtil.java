package br.com.dev.util;

import br.com.dev.model.ImpressaoDTO;
import br.com.dev.model.Produto;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ImpressaoUtil {

    public static String gerarConteudoImpressao(ImpressaoDTO dto) {
        StringBuilder fraseBuilder = new StringBuilder();
        String linhaC = "-".repeat(70); // Caractere Unicode para um traço contínuo (—)
        String dataValidadeFormatada = gerarDataValidadeFormatada(dto.nota().data());
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        
        fraseBuilder.append(linhaC)
                .append("\n               Atakarejo - Loja 01 Iguatemi\n")
                .append(linhaC)
                .append("\n             Comprovante de devolucao\n")
                .append(linhaC)
                .append("\n");

        fraseBuilder.append("Cliente  : ")
                .append(dto.cliente().nome())
                .append("\n");

        fraseBuilder.append("CPF     : ")
                .append(dto.cliente().cpf())
                .append("\n");

        fraseBuilder.append("CEP     : ")
                .append(dto.cliente().endereco().cep())
                .append("     ");

        fraseBuilder.append("N° : ")
                .append(dto.cliente().endereco().numero())
                .append("\n");

        fraseBuilder.append("Telefone: ")
                .append(dto.cliente().telefone())
                .append("\n");

        fraseBuilder.append("Data   : ")
                .append(dto.nota().data())
                .append("   ");

        fraseBuilder.append("PDV : ")
                .append(dto.nota().pdv())
                .append("   ");

        fraseBuilder.append("Cupom : ")
                .append(dto.nota().cupom())
                .append("\n");

        fraseBuilder.append(linhaC)
                .append("\nCod     Produto\n")
                .append("                     Qtd     Valor Uni     Total\n")
                .append("--").append(linhaC).append("\n")
                .append(dataValidadeFormatada).append("\n");

        for (Produto prod : dto.produtos()) {
            String resultadoTotal = decimalFormat.format(prod.calcular());
            fraseBuilder.append(prod.getDescricao()).append("\nC:").append(prod.getCodigo())
                    .append("\n                      ").append(prod.getPesoQuantidade())
                    .append("          R$").append(decimalFormat.format(prod.getValor()))
                    .append("      R$").append(resultadoTotal).append("\n");
        } 
        
        //calcular valor total de devolucao
         double resultadoFinal = dto.produtos().stream().mapToDouble(p -> p.calcular()).sum();
         String resultadoFormatado = decimalFormat.format(resultadoFinal);

        fraseBuilder.append(linhaC)
                .append("\nTOTAL DA DEVOLUCAO: R$").append(resultadoFormatado).append("\n")
                .append(linhaC)
                .append("\n")
                .append("\n")
                .append(linhaC)
                .append("\n ATENDENTE SAC\n")
                .append("\n")
                .append(linhaC)
                .append("\n LIDER DE ATENDIMENTO\n")
                .append("\n")
                .append(linhaC)
                .append("\n PREVENCAO DE PERDAS\n")
                .append("\n")
                .append(linhaC)
                .append("\n CLIENTE\n")
                .append("\n")
                .append("\n Validade:\n")
                .append(dataValidadeFormatada).append("\n")
                .append("\n******Devolucao Manual******");

        return fraseBuilder.toString();
    }

    public static String gerarDataValidadeFormatada(String dataInput) {
        // Adicionando um mês à data atual
        // Obtendo a data do campo jData como LocalDate
        String dataTexto = dataInput;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate data = LocalDate.parse(dataTexto, formatter);

        // Adicionando um mês à data atual
        LocalDate dataValidade = data.plusMonths(1);

        // Formatando a data para exibição
        String dataValidadeFormatada = dataValidade.format(formatter);
        System.out.println(dataValidadeFormatada);
        return dataValidadeFormatada;
    }

}
