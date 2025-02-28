import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;

public class RelogioDigital extends JFrame {

    private JLabel labelHora;
    private JLabel labelData;

    public RelogioDigital() {
        // Configurações da janela
        setTitle("Relógio Digital com Data");
        setSize(400, 200); // Aumentei a altura para acomodar a data
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centraliza a janela na tela
        setResizable(false); // Impede o redimensionamento da janela

        // Configurações do painel principal
        JPanel painel = new JPanel();
        painel.setBackground(Color.BLACK); // Fundo preto
        painel.setLayout(new BorderLayout());
        add(painel);

        // Configurações do label que exibirá a hora
        labelHora = new JLabel();
        labelHora.setFont(new Font("DS-Digital", Font.PLAIN, 100)); // Fonte digital
        labelHora.setForeground(new Color(0, 255, 0)); // Cor verde neon
        labelHora.setHorizontalAlignment(JLabel.CENTER);
        painel.add(labelHora, BorderLayout.CENTER);

        // Configurações do label que exibirá a data
        labelData = new JLabel();
        labelData.setFont(new Font("DS-Digital", Font.PLAIN, 30)); // Fonte menor para a data
        labelData.setForeground(new Color(0, 127, 255)); // Cor verde neon
        labelData.setHorizontalAlignment(JLabel.CENTER);
        painel.add(labelData, BorderLayout.SOUTH); // Adiciona a data na parte inferior

        // Atualiza a hora e a data a cada segundo
        Timer timer = new Timer(1000, e -> atualizarHoraEData());
        timer.start();

        // Exibe a janela
        setVisible(true);
    }

    private void atualizarHoraEData() {
        // Formata a hora atual
        SimpleDateFormat sdfHora = new SimpleDateFormat("HH:mm:ss");
        String horaAtual = sdfHora.format(new Date());
        labelHora.setText(horaAtual);

        // Formata a data atual
        SimpleDateFormat sdfData = new SimpleDateFormat("dd/MMM/yyyy");
        String dataAtual = sdfData.format(new Date());
        labelData.setText(dataAtual);
    }

    public static void main(String[] args) {
        // Executa a aplicação na thread de eventos do Swing
        SwingUtilities.invokeLater(RelogioDigital::new);
    }
}