package br.com.fiap;

import br.com.fiap.to.DiagnosticoTO;

import javax.swing.*;

public class Teste {

    public static void main(String[] args) {
        String[] opcoes = {"Motor", "Freios", "Sistema Elétrico", "Suspensão", "Transmissão", "Ar Condicionado"};
        int escolha = JOptionPane.showOptionDialog(null,
                "Selecione a área do veículo que está apresentando problemas:",
                "Diagnóstico de Veículos",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null, opcoes, opcoes[0]);

        if (escolha == -1) {
            JOptionPane.showMessageDialog(null, "Nenhuma área selecionada.");
            return;
        }

        String areaSelecionada = opcoes[escolha];
        DiagnosticoTO diagnosticoTO = new DiagnosticoTO(areaSelecionada);

        diagnosticoTO.diagnosticar();
    }
}
