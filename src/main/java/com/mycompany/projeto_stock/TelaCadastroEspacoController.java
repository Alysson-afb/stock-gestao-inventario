package com.mycompany.projeto_stock;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.exceptions.ValidacaoException;
import model.classes.Espacos;
import model.services.EspacosService;

public class TelaCadastroEspacoController implements Initializable {

    private Espacos espaco;

    @FXML
    private Button btnCadastroEspacoSair;

    @FXML
    private Button btnCadastroEspacoSalvar;

    @FXML
    private Label lblErroCodEspaco;

    @FXML
    private Label lblErroDescricaoEspaco;

    @FXML
    private Label lblErroNomeEspaco;

    @FXML
    private Label lblErroNumeroEspaco;

    @FXML
    private TextField txtCadastroEspacoCodigo;

    @FXML
    private TextField txtCadastroEspacoDescricao;

    @FXML
    private TextField txtCadastroEspacoNome;

    @FXML
    private TextField txtCadastroEspacoNumero;

    public void setEspaco(Espacos espacos) {
        this.espaco = espacos;
        txtCadastroEspacoCodigo.setText(String.valueOf(espacos.getCodEspaco()));
        txtCadastroEspacoNome.setText(espacos.getNome());
        txtCadastroEspacoDescricao.setText(espacos.getDescricao());
        txtCadastroEspacoNumero.setText(String.valueOf(espacos.getNumero()));
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        btnCadastroEspacoSalvar.setOnAction(
                (t) -> {
                    boolean inserindo = false;
                    try {
                        ValidacaoException exc = new ValidacaoException("Erro Validação de nome!");
                        if (espaco == null) {
                            inserindo = true;
                            espaco = new Espacos();
                        }

                        if (txtCadastroEspacoCodigo.getText() == null || txtCadastroEspacoCodigo.getText().equals("")) {
                            exc.adicionarErro("Código do Espaço", "O campo não pode ser vazio ou duplicado!");
                        } else {
                            int numero = Integer.valueOf((txtCadastroEspacoCodigo.getText()));
                            espaco.setCodEspaco(numero);
                        }
                        if (txtCadastroEspacoNome.getText() == null || txtCadastroEspacoNome.getText().equals("")) {
                            exc.adicionarErro("Nome do Espaço", "O campo não pode ser vazio ou duplicado!");
                        } else {
                            espaco.setNome(txtCadastroEspacoNome.getText());
                        }

                        if (txtCadastroEspacoDescricao.getText() == null || txtCadastroEspacoDescricao.getText().equals("")) {
                            exc.adicionarErro("Descrição do Espaço", "O campo não pode ser vazio ou duplicado!");
                        } else {
                            espaco.setDescricao(txtCadastroEspacoDescricao.getText());
                        }

                        if (txtCadastroEspacoNumero.getText() == null || txtCadastroEspacoNumero.getText().equals("")) {
                            exc.adicionarErro("Numero do Espaço", "O campo não pode ser vazio ou duplicado!");
                        } else {
                            int numero = Integer.valueOf((txtCadastroEspacoNumero.getText()));
                            espaco.setNumero(numero);
                        }

                        if (!exc.getErrors().isEmpty()) {
                            throw exc;
                        }
                        boolean result;
                        if (inserindo) {
                            result = new EspacosService().inserir(espaco);
                        } else {
                            result = new EspacosService().editar(espaco);
                        }

                        if (result) {
                            Stage stage = (Stage) btnCadastroEspacoSair.getScene().getWindow();
                            stage.close();
                        } else {
                            Alert al = new Alert(Alert.AlertType.ERROR);
                            al.setTitle("ERRO");
                            al.setHeaderText(null);
                            al.setContentText("Ocorreu um erro ao salvar!");
                            al.showAndWait();
                        }
                    } catch (ValidacaoException ev) {
                        setErrorMessages(ev.getErrors());
                    }
                }
        );

        btnCadastroEspacoSair.setOnAction(
                (t) -> {
                    ((Stage) btnCadastroEspacoSair.getScene().getWindow()).close();
                }
        );

    }

    private void setErrorMessages(Map<String, String> errors) {
        Set<String> fields = errors.keySet();
        lblErroCodEspaco.setText(fields.contains("Código do Espaço") ? errors.get("Código do Espaço") : "");
        lblErroNomeEspaco.setText(fields.contains("Nome do Espaço") ? errors.get("Nome do Espaço") : "");
        lblErroDescricaoEspaco.setText(fields.contains("Descrição do Espaço") ? errors.get("Descrição do Espaço") : "");
        lblErroNumeroEspaco.setText(fields.contains("Numero do Espaço") ? errors.get("Numero do Espaço") : "");
    }

}
