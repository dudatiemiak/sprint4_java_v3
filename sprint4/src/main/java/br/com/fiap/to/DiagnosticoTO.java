package br.com.fiap.to;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class DiagnosticoTO {
    private String area;

    public DiagnosticoTO(String area) {
        this.area = area;
    }

    public String diagnosticar() {
        List<String> procedimentos = new ArrayList<>();
        List<String> pecas = new ArrayList<>();

        String diagnostico = "";

        switch (area) {
            case "Motor":
                diagnostico = diagnosticarMotor(procedimentos, pecas);
                break;
            case "Freios":
                diagnostico = diagnosticarFreios(procedimentos, pecas);
                break;
            case "Sistema Elétrico":
                diagnostico = diagnosticarSistemaEletrico(procedimentos, pecas);
                break;
            case "Suspensão":
                diagnostico = diagnosticarSuspensao(procedimentos, pecas);
                break;
            case "Transmissão":
                diagnostico = diagnosticarTransmissao(procedimentos, pecas);
                break;
            case "Ar Condicionado":
                diagnostico = diagnosticarArCondicionado(procedimentos, pecas);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Área inválida selecionada.");
                break;
        }

        if (!diagnostico.isEmpty()) {
            OrcamentoTO orcamento = new OrcamentoTO();
            float valorOrcamento = orcamento.calcularOrcamento(procedimentos, pecas);
            JOptionPane.showMessageDialog(null, diagnostico + "\nValor do Orçamento: R$ " + valorOrcamento);
        }

        return diagnostico;
    }

    private String diagnosticarMotor(List<String> procedimentos, List<String> pecas) {
        String resposta = JOptionPane.showInputDialog("Qual o problema com o motor? \n1. Falha de ignição \n2. Barulho excessivo \n3. Superaquecimento \n4. Consumo excessivo de combustível");
        Integer.parseInt(resposta);
        switch (resposta) {
            case "1":
                procedimentos.add("Inspecionar e testar o sistema de ignição.");
                pecas.add("Bateria ou bobina de ignição");
                return "Diagnóstico: Há uma falha de ignição, possivelmente causada por problemas na bateria ou bobina de ignição. Recomendamos verificar a energia e os componentes da ignição.";
            case "2":
                procedimentos.add("Avaliar o motor quanto a folgas ou desgaste nos componentes.");
                pecas.add("Peças de motor específicas");
                return "Diagnóstico: O barulho excessivo no motor indica um possível desgaste em componentes internos. Recomenda-se inspecionar o sistema e realizar reparos.";
            case "3":
                procedimentos.add("Checar o sistema de arrefecimento.");
                pecas.add("Radiador ou bomba de água");
                return "Diagnóstico: O superaquecimento pode ser causado por problemas no sistema de arrefecimento, como vazamentos ou entupimentos no radiador. Verificar componentes de arrefecimento é essencial.";
            case "4":
                procedimentos.add("Inspecionar o sistema de injeção.");
                pecas.add("Injetores de combustível");
                return "Diagnóstico: O consumo excessivo de combustível pode estar relacionado a injetores desgastados ou sujos. Sugere-se a substituição ou limpeza dos injetores para melhorar a eficiência.";
            default:
                return "Problema não reconhecido.";
        }
    }

    private String diagnosticarFreios(List<String> procedimentos, List<String> pecas) {
        String resposta = JOptionPane.showInputDialog("Qual o problema com os freios? \n1. Barulho ao frear \n2. Pedal duro \n3. Desvio na direção ao frear \n4. Luz de freio acesa");
        Integer.parseInt(resposta);
        switch (resposta) {
            case "1":
                procedimentos.add("Inspecionar pastilhas e discos de freio.");
                pecas.add("Pastilhas de freio");
                return "Diagnóstico: Barulhos ao frear sugerem desgaste nas pastilhas de freio, podendo indicar a necessidade de substituição.";
            case "2":
                procedimentos.add("Verificar nível e qualidade do fluido de freio.");
                pecas.add("Fluido de freio");
                return "Diagnóstico: Um pedal de freio rígido pode indicar baixa pressão no fluido, necessitando de verificação e possível troca do fluido.";
            case "3":
                procedimentos.add("Checar alinhamento e balanceamento.");
                pecas.add("Componentes de alinhamento");
                return "Diagnóstico: O desvio ao frear aponta para desalinhamento. Recomenda-se verificar componentes de suspensão e alinhamento.";
            case "4":
                procedimentos.add("Inspecionar o sensor de freio.");
                pecas.add("Sensor de freio");
                return "Diagnóstico: A luz de freio acesa indica um possível problema com o sistema de freios, como desgaste nas pastilhas ou sensor com defeito.";
            default:
                return "Problema não reconhecido.";
        }
    }

    private String diagnosticarSistemaEletrico(List<String> procedimentos, List<String> pecas) {
        String resposta = JOptionPane.showInputDialog("Qual o problema no sistema elétrico? \n1. Luzes piscando \n2. Bateria descarregando \n3. Dificuldade na partida \n4. Acessórios não funcionando");
        Integer.parseInt(resposta);
        switch (resposta) {
            case "1":
                procedimentos.add("Verificar conexões e fiação das luzes.");
                pecas.add("Lâmpadas e fusíveis");
                return "Diagnóstico: Luzes piscando indicam falha na fiação ou nos fusíveis. Sugere-se uma inspeção detalhada.";
            case "2":
                procedimentos.add("Testar a bateria e alternador.");
                pecas.add("Bateria ou alternador");
                return "Diagnóstico: Bateria descarregando pode ser sinal de alternador defeituoso ou bateria fraca. Recomenda-se teste e possível substituição.";
            case "3":
                procedimentos.add("Verificar motor de partida e conexões elétricas.");
                pecas.add("Motor de partida");
                return "Diagnóstico: Dificuldades na partida podem estar relacionadas ao motor de partida ou à bateria.";
            case "4":
                procedimentos.add("Inspecionar o sistema de fusíveis e relés.");
                pecas.add("Fusíveis");
                return "Diagnóstico: Acessórios inoperantes geralmente indicam fusíveis queimados. Substituição é recomendada.";
            default:
                return "Problema não reconhecido.";
        }
    }


    private String diagnosticarSuspensao(List<String> procedimentos, List<String> pecas) {
        String resposta = JOptionPane.showInputDialog("Qual o problema com a suspensão? \n1. Barulho ao passar em buracos \n2. Veículo desequilibrado \n3. Desgaste irregular dos pneus \n4. Dificuldade em manobrar");
        Integer.parseInt(resposta);
        switch (resposta) {
            case "1":
                procedimentos.add("Inspecionar amortecedores e componentes de suspensão.");
                pecas.add("Amortecedores novos");
                return "Diagnóstico: Barulho ao passar em buracos pode indicar desgaste dos amortecedores. Recomenda-se verificar e substituir os amortecedores, se necessário.";
            case "2":
                procedimentos.add("Realizar balanceamento e alinhamento, inspecionar a suspensão.");
                pecas.add("Peças de suspensão");
                return "Diagnóstico: Veículo desequilibrado geralmente indica necessidade de balanceamento ou problemas na suspensão. Recomenda-se balanceamento e inspeção das peças de suspensão.";
            case "3":
                procedimentos.add("Checar alinhamento e componentes de suspensão.");
                pecas.add("Peças de alinhamento");
                return "Diagnóstico: Desgaste irregular dos pneus é um sinal comum de desalinhamento. Realize alinhamento e verifique o estado das peças de suspensão.";
            case "4":
                procedimentos.add("Inspecionar a barra estabilizadora e peças relacionadas.");
                pecas.add("Barra estabilizadora nova");
                return "Diagnóstico: Dificuldade em manobrar pode indicar desgaste na barra estabilizadora. Recomenda-se substituição ou reparo da barra e inspeção de peças relacionadas.";
            default:
                return "Problema não reconhecido. Tente novamente com uma opção válida.";
        }
    }

    private String diagnosticarTransmissao(List<String> procedimentos, List<String> pecas) {
        String resposta = JOptionPane.showInputDialog("Qual o problema com a transmissão? \n1. Troca de marcha difícil \n2. Vazamento de fluido \n3. Barulho ao mudar de marcha \n4. Luz de transmissão acesa");
        Integer.parseInt(resposta);
        switch (resposta) {
            case "1":
                procedimentos.add("Verificar o sistema de transmissão e embreagem.");
                pecas.add("Peças de transmissão");
                return "Diagnóstico: Troca de marcha difícil pode estar ligada a problemas no sistema de embreagem ou desgaste nos componentes da transmissão. Verificação e substituição de peças desgastadas são recomendadas.";
            case "2":
                procedimentos.add("Identificar e reparar vazamentos na transmissão.");
                pecas.add("Fluido de transmissão");
                return "Diagnóstico: Vazamento de fluido é um sinal de vedação comprometida ou rachaduras no sistema. Recomenda-se reparo imediato para evitar danos maiores.";
            case "3":
                procedimentos.add("Inspecionar o sistema de embreagem e eixos de transmissão.");
                pecas.add("Embreagem nova");
                return "Diagnóstico: Barulho ao mudar de marcha indica desgaste em peças da embreagem ou no eixo de transmissão. Inspeção e substituição de componentes desgastados são necessárias.";
            case "4":
                procedimentos.add("Checar o painel e sensores de transmissão.");
                pecas.add("Peças do painel");
                return "Diagnóstico: Luz de transmissão acesa pode indicar falha em sensores ou superaquecimento. Recomenda-se inspeção dos sensores e do sistema.";
            default:
                return "Problema não reconhecido. Tente novamente com uma opção válida.";
        }
    }

    private String diagnosticarArCondicionado(List<String> procedimentos, List<String> pecas) {
        String resposta = JOptionPane.showInputDialog("Qual o problema com o ar condicionado? \n1. Ar quente sai do ventilador \n2. Ruídos estranhos \n3. Vazamento de gás \n4. O ar não está gelando");
        Integer.parseInt(resposta);
        switch (resposta) {
            case "1":
                procedimentos.add("Verificar compressor e válvulas do sistema de ventilação.");
                pecas.add("Compressor novo");
                return "Diagnóstico: Ar quente saindo pode ser um problema no compressor ou na válvula de expansão. Recomenda-se verificação do compressor e substituição, se necessário.";
            case "2":
                procedimentos.add("Inspecionar as mangueiras e peças móveis do ar condicionado.");
                pecas.add("Mangueiras novas");
                return "Diagnóstico: Ruídos estranhos podem indicar desgaste nas mangueiras ou nas peças móveis. Substituição de peças desgastadas é indicada.";
            case "3":
                procedimentos.add("Identificar vazamento no sistema e reabastecer o gás refrigerante.");
                pecas.add("Gás refrigerante");
                return "Diagnóstico: Vazamento de gás pode ocorrer devido a rachaduras em mangueiras ou vedações. Verificação e recarga de gás refrigerante são recomendadas.";
            case "4":
                procedimentos.add("Checar o sistema de refrigeração e termostato.");
                pecas.add("Peças do sistema de refrigeração");
                return "Diagnóstico: Falta de ar gelado pode indicar problema no compressor ou baixo nível de gás. Inspeção e manutenção são recomendadas.";
            default:
                return "Problema não reconhecido. Tente novamente com uma opção válida.";
        }
    }
}
