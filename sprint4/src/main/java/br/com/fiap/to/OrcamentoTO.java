package br.com.fiap.to;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrcamentoTO {
    private Map<String, Float> precosProcedimentos;
    private Map<String, Float> precosPecas;

    public OrcamentoTO() {
        precosProcedimentos = new HashMap<>();
        precosPecas = new HashMap<>();
        inicializarPrecos();
    }

    private void inicializarPrecos() {
        // Preços de procedimentos
        precosProcedimentos.put("Inspecionar e testar o sistema de ignição.", 250.0f);
        precosProcedimentos.put("Avaliar o motor quanto a folgas ou desgaste nos componentes.", 450.0f);
        precosProcedimentos.put("Checar o sistema de arrefecimento.", 200.0f);
        precosProcedimentos.put("Inspecionar pastilhas de freio e discos para desgaste excessivo.", 120.0f);
        precosProcedimentos.put("Verificar o nível e a qualidade do fluido de freio e inspecionar o sistema hidráulico.", 100.0f);
        precosProcedimentos.put("Realizar alinhamento e verificar desgaste das peças de suspensão.", 90.0f);
        precosProcedimentos.put("Inspecionar o sistema de injeção.", 300.0f);
        precosProcedimentos.put("Inspecionar o sistema de sensores e verificar as pastilhas.", 80.0f);
        precosProcedimentos.put("Verificar nível e qualidade do fluido de freio.", 120.0f);
        precosProcedimentos.put("Checar alinhamento e balanceamento.", 120.0f);
        precosProcedimentos.put("Inspecionar o sensor de freio.", 150.0f);
        precosProcedimentos.put("Verificar conexões e fiação das luzes.", 85.0f);
        precosProcedimentos.put("Testar a bateria e alternador.", 100.0f);
        precosProcedimentos.put("Verificar motor de partida e conexões elétricas.", 150.0f);
        precosProcedimentos.put("Inspecionar o sistema de fusíveis e relés.", 100.0f);
        precosProcedimentos.put("Inspecionar amortecedores e componentes de suspensão.", 100.0f);
        precosProcedimentos.put("Realizar balanceamento e alinhamento, inspecionar a suspensão.", 250.0f);
        precosProcedimentos.put("Checar alinhamento e componentes de suspensão.", 300.0f);
        precosProcedimentos.put("Inspecionar a barra estabilizadora e peças relacionadas.", 150.0f);
        precosProcedimentos.put("Verificar o sistema de transmissão e embreagem.", 300.0f);
        precosProcedimentos.put("Identificar e reparar vazamentos na transmissão.", 370.0f);
        precosProcedimentos.put("Inspecionar o sistema de embreagem e eixos de transmissão.", 250.0f);
        precosProcedimentos.put("Checar o painel e sensores de transmissão.", 300.0f);
        precosProcedimentos.put("Verificar compressor e válvulas do sistema de ventilação.", 300.0f);
        precosProcedimentos.put("Inspecionar as mangueiras e peças móveis do ar condicionado.", 200.0f);
        precosProcedimentos.put("Identificar vazamento no sistema e reabastecer o gás refrigerante.", 110.0f);
        precosProcedimentos.put("Checar o sistema de refrigeração e termostato.", 90.0f);

        // Preços de peças
        precosPecas.put("Bateria ou bobina de ignição", 400.0f);
        precosPecas.put("Peças de motor específicas", 600.0f);
        precosPecas.put("Radiador ou bomba de água", 500.0f);
        precosPecas.put("Injetores de combustível", 600.0f);
        precosPecas.put("Pastilhas de freio", 150.0f);
        precosPecas.put("Fluido de freio", 50.0f);
        precosPecas.put("Componentes de alinhamento", 300.0f);
        precosPecas.put("Peças de alinhamento", 130.0f);
        precosPecas.put("Sensor de freio", 250.0f);
        precosPecas.put("Lâmpadas e fusíveis", 20.0f);
        precosPecas.put("Bateria nova", 200.0f);
        precosPecas.put("Bateria ou alternador", 600.0f);
        precosPecas.put("Motor de partida", 700.0f);
        precosPecas.put("Fusíveis", 20.0f);
        precosPecas.put("Amortecedores novos", 160.0f);
        precosPecas.put("Peças de suspensão", 600.0f);
        precosPecas.put("Barra estabilizadora nova", 450.0f);
        precosPecas.put("Peças de transmissão", 900.0f);
        precosPecas.put("Fluido de transmissão", 150.0f);
        precosPecas.put("Embreagem nova", 1000.0f);
        precosPecas.put("Peças do painel", 250.0f);
        precosPecas.put("Compressor novo", 1700.0f);
        precosPecas.put("Mangueiras novas", 100.0f);
        precosPecas.put("Gás refrigerante", 100.0f);
        precosPecas.put("Peças do sistema de refrigeração", 450.0f);

    }

    public float calcularOrcamento(List<String> procedimentos, List<String> pecas) {
        float total = 0.0f;

        for (String procedimento : procedimentos) {
            total += obterPrecoProcedimento(procedimento);
        }

        for (String peca : pecas) {
            total += obterPrecoPeca(peca);
        }

        return total;
    }

    public Map<String, Float> calcularOrcamentoDetalhado(List<String> procedimentos, List<String> pecas) {
        Map<String, Float> detalhes = new HashMap<>();

        for (String procedimento : procedimentos) {
            detalhes.put(procedimento, obterPrecoProcedimento(procedimento));
        }

        for (String peca : pecas) {
            detalhes.put(peca, obterPrecoPeca(peca));
        }

        return detalhes;
    }

    private float obterPrecoProcedimento(String procedimento) {
        return precosProcedimentos.getOrDefault(procedimento, 0.0f);
    }

    private float obterPrecoPeca(String peca) {
        return precosPecas.getOrDefault(peca, 0.0f);
    }
}
