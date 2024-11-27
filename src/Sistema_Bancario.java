import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Sistema_Bancario {
    private JPanel panelMain;
    private JLabel lblValorSaldo;
    private JLabel lblSaque;
    private JLabel lblInfVlSq;
    private JButton btnRealizDep;
    private JButton btnRealzSaq;
    private JLabel lblSaldo;
    private JLabel lblDeps;
    private JLabel lblInfVlDp;
    private JTextArea txtAreaMsgm;
    private JButton btnLimpar;
    private JTextField txtSaque;
    private JTextField txtDeposito;

    private Double saldo = 500.00;
    private Double cleitomLindo;

    public Sistema_Bancario() {
        lblValorSaldo.setText("R$ " + String.format("%.2f", saldo));
        btnRealizDep.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtDeposito.getText().replace(",", ".").isEmpty()) {
                    txtAreaMsgm.setText("Informe um valor!");
                    return;
                }
                try {
                    cleitomLindo = Double.parseDouble(txtDeposito.getText().replace(",", "."));
                    if (cleitomLindo > 1000.00) {
                        txtAreaMsgm.setText("Depósito acima do limite permitido!");
                    } else if (cleitomLindo < 0) {
                        txtAreaMsgm.setText("Valor negativo!");
                    } else {
                        txtAreaMsgm.setText("Depósito realizado com sucesso!");
                        saldo = saldo + cleitomLindo;
                        lblValorSaldo.setText("R$ " + String.format("%.2f", saldo));
                        cleitomLindo = 0.0;
                    }
                } catch (NumberFormatException ex) {
                    txtAreaMsgm.setText("Erro! Insira somente números!");
                }
            }
        });

        btnRealzSaq.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtSaque.getText().replace(",", ".").isEmpty()) {
                    txtAreaMsgm.setText("Informe um valor!");
                    return;
                }
                try {
                    cleitomLindo = Double.parseDouble(txtSaque.getText().replace(",", "."));
                    if (cleitomLindo > saldo) {
                        txtAreaMsgm.setText("Saldo insuficiente!");
                    } else if (cleitomLindo < 0) {
                        txtAreaMsgm.setText("Valor negativo!");
                    } else {
                        txtAreaMsgm.setText("Saque realizado com sucesso!");
                        saldo = saldo - cleitomLindo;
                        lblValorSaldo.setText("R$ " + String.format("%.2f", saldo));
                        cleitomLindo = 0.0;
                    }
                } catch (NumberFormatException ex) {
                    txtAreaMsgm.setText("Erro! Insira somente números!");
                }
            }
        });

        btnLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtSaque.setText("");
                txtDeposito.setText("");
                txtAreaMsgm.setText("");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Sistema Bancario");
        frame.setContentPane(new Sistema_Bancario().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    //Fácil demais professor, eu tava esperando uma cálculadora científica 💀
}
