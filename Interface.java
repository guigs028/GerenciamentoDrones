import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interface extends JFrame {
    private JTextField codigoField;
    private JTextField capacidadePessoasField;
    private JTextField custoFixoField;
    private JTextField autonomiaField;
    private JTextArea mensagemArea;
    private App app; 

    public Interface() {
        app = new App(); 

        setTitle("Cadastro de Drone Pessoal");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 5, 5));
        inputPanel.add(new JLabel("Código do Drone:"));
        codigoField = new JTextField();
        inputPanel.add(codigoField);

        inputPanel.add(new JLabel("Capacidade de Pessoas:"));
        capacidadePessoasField = new JTextField();
        inputPanel.add(capacidadePessoasField);

        inputPanel.add(new JLabel("Custo Fixo:"));
        custoFixoField = new JTextField();
        inputPanel.add(custoFixoField);

        inputPanel.add(new JLabel("Autonomia do Drone:"));
        autonomiaField = new JTextField();
        inputPanel.add(autonomiaField);

        mensagemArea = new JTextArea(6, 30);
        mensagemArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(mensagemArea);

        JPanel buttonPanel = new JPanel(new GridLayout(1,4));
        JButton botaoCadastrar = new JButton("Cadastrar");
        JButton botaoLimpar = new JButton("Limpar Campos");
        JButton botaoListar = new JButton("Mostrar Drones");
        JButton botaoSair = new JButton("Encerrar Programa");

        botaoCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int codigo = Integer.parseInt(codigoField.getText());
                    double custoFixo = Double.parseDouble(custoFixoField.getText().replace(",", "."));
                    double autonomia = Double.parseDouble(autonomiaField.getText().replace(",", "."));
                    int capacidade = Integer.parseInt(capacidadePessoasField.getText());
        
                    String resultado = app.cadastrarDronePessoal(codigo, custoFixo, autonomia, capacidade);
                    mensagemArea.setText(resultado);
        
                } catch (NumberFormatException ex) {
                    mensagemArea.setText("Erro: Verifique se todos os campos estão preenchidos corretamente.");
                }
            }
        });
        
        botaoLimpar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                codigoField.setText("");
                custoFixoField.setText("");
                autonomiaField.setText("");
                capacidadePessoasField.setText("");
                mensagemArea.setText("");
            }
        });

        botaoListar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String dronesCadastrados = app.listarDrones();
                mensagemArea.setText(dronesCadastrados);
            }
        });

        botaoSair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        buttonPanel.add(botaoCadastrar);
        buttonPanel.add(botaoLimpar);
        buttonPanel.add(botaoListar);
        buttonPanel.add(botaoSair);

        setLayout(new BorderLayout());
        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }
}

