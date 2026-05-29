package com.mycompany.projeto_stock;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.classes.Bem;
import model.exceptions.ValidacaoException;
import model.services.BemServices;

public class TelaCadastroBemController implements Initializable {

    private Bem bem;

    @FXML
    private Button btnCadastroBemSair;

    @FXML
    private Button btnCadastroBemSalvar;

    @FXML
    private Label lblErroCategoriaBem;

    @FXML
    private Label lblErroCodBem;

    @FXML
    private Label lblErroDataBem;

    @FXML
    private Label lblErroDescricaoBem;

    @FXML
    private Label lblErroEstadoBem;

    @FXML
    private Label lblErroNomeBem;

    @FXML
    private Label lblErroValorBem;

    @FXML
    private TextField txtCadastroBemCategoria;

    @FXML
    private TextField txtCadastroBemCodigo;

    @FXML
    private DatePicker txtCadastroBemData;

    @FXML
    private TextField txtCadastroBemDescricao;

    @FXML
    private TextField txtCadastroBemNome;

    @FXML
    private TextField txtCadastroBemValor;

    @FXML
    private RadioButton radioBom;

    @FXML
    private RadioButton radioRuim;

    public void setBem(Bem bem) {
        this.bem = bem;
        txtCadastroBemCodigo.setText(String.valueOf(bem.getCodBem()));
        txtCadastroBemCategoria.setText(String.valueOf(bem.getCategoria()));
        txtCadastroBemNome.setText(String.valueOf(bem.getNome()));
        txtCadastroBemDescricao.setText(String.valueOf(bem.getDescricao()));
        txtCadastroBemValor.setText(String.valueOf(bem.getValor()));
        txtCadastroBemData.setValue(bem.getDataAquisicao());
        if (bem.getEstadoConservacao() == 0) {
            radioBom.setSelected(true);
        } else {
            radioRuim.setSelected(true);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        btnCadastroBemSalvar.setOnAction((t) -> {
            boolean inserindo = false;
            try {
                ValidacaoException exc = new ValidacaoException("Erro Validação de nome!");
                if (bem == null) {
                    inserindo = true;
                    bem = new Bem();
                }

                if (txtCadastroBemCodigo.getText() == null || txtCadastroBemCodigo.getText().equals("")) {
                    exc.adicionarErro("Código do Bem", "O campo não pode ser vazio ou duplicado!");
                } else {
                    int numero = Integer.valueOf((txtCadastroBemCodigo.getText()));
                    bem.setCodBem(numero);
                }

                if (txtCadastroBemCategoria.getText() == null || txtCadastroBemCategoria.getText().equals("")) {
                    exc.adicionarErro("Categoria do Bem", "O campo não pode ser vazio ou duplicado!");
                } else {
                    bem.setCategoria(txtCadastroBemCategoria.getText());
                }

                if (txtCadastroBemNome.getText() == null || txtCadastroBemNome.getText().equals("")) {
                    exc.adicionarErro("Nome do Bem", "O campo não pode ser vazio ou duplicado!");
                } else {
                    bem.setNome(txtCadastroBemNome.getText());
                }

                if (txtCadastroBemDescricao.getText() == null || txtCadastroBemDescricao.getText().equals("")) {
                    exc.adicionarErro("Descrição do Bem", "O campo não pode ser vazio ou duplicado!");
                } else {
                    bem.setDescricao(txtCadastroBemDescricao.getText());
                }

                if (txtCadastroBemValor.getText() == null || txtCadastroBemValor.getText().equals("")) {
                    exc.adicionarErro("Valor R$", "O campo não pode ser vazio ou duplicado!");
                } else {
                    bem.setNome(txtCadastroBemValor.getText());
                }

                if (txtCadastroBemData.getValue() == null) {
                    exc.adicionarErro("Data Aquisição", "O campo não pode ser vazio ou duplicado!");
                } else {
                    bem.setDataAquisicao(txtCadastroBemData.getValue());
                }

                if (radioBom.isSelected()) {
                    bem.setEstadoConservacao(0);
                } else {
                    bem.setEstadoConservacao(1);
                }

                if (!exc.getErrors().isEmpty()) {
                    throw exc;
                }
                boolean result;
                if (inserindo) {
                    result = new BemServices().inserir(bem);
                } else {
                    result = new BemServices().editar(bem);
                }

                if (result) {
                    Stage stage = (Stage) btnCadastroBemSair.getScene().getWindow();
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
        });

        btnCadastroBemSair.setOnAction((t) -> {
            ((Stage) btnCadastroBemSair.getScene().getWindow()).close();
        });
    }

    private void setErrorMessages(Map<String, String> errors) {
        Set<String> fields = errors.keySet();
        lblErroCodBem.setText(fields.contains("Código do Bem") ? errors.get("Código do Bem") : "");
        lblErroCategoriaBem.setText(fields.contains("Categoria do Bem") ? errors.get("Categoria do Bem") : "");
        lblErroNomeBem.setText(fields.contains("Nome do Bem") ? errors.get("Nome do Bem") : "");
        lblErroDescricaoBem.setText(fields.contains("Descrição do Bem") ? errors.get("Descrição do Bem") : "");
        lblErroValorBem.setText(fields.contains("Valor R$") ? errors.get("Valor R$") : "");
        lblErroDataBem.setText(fields.contains("Data Aquisição") ? errors.get("Data Aquisição") : "");
        lblErroEstadoBem.setText(fields.contains("Conservação do Bem") ? errors.get("Conservação do Bem") : "");
    }
}
