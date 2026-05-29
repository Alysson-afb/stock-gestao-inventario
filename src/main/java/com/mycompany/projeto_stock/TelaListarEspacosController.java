package com.mycompany.projeto_stock;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.classes.Bem;
import model.classes.Espacos;
import model.services.BemServices;

public class TelaListarEspacosController implements Initializable {

    @FXML
    private TableView<Bem> tableViewBens;
    @FXML
    private TableColumn<Bem, Integer> tableColumnCodBem;
    @FXML
    private TableColumn<Bem, String> tableColumnNomeBem;
    @FXML
    private TableColumn<Bem, String> tableColumnCategoriaBem;
    @FXML
    private TableColumn<Bem, String> tableColumnDescricaoBem;
    @FXML
    private TableColumn<Bem, Float> tableColumnValorBem;
    @FXML
    private TableColumn<Bem, LocalDate> tableColumnDataAquisicaoBem;
    @FXML
    private TableColumn<Bem, Integer> tableColumnConservacaoBem;

    private ObservableList<Bem> listaTabela;
    private Espacos espaco;

    public void setEspaco(Espacos espaco) {
        this.espaco = espaco;
        atualizarTabela();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tableColumnCodBem.setCellValueFactory(new PropertyValueFactory<>("codBem"));
        tableColumnNomeBem.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tableColumnCategoriaBem.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        tableColumnDescricaoBem.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        tableColumnValorBem.setCellValueFactory(new PropertyValueFactory<>("valor"));
        tableColumnDataAquisicaoBem.setCellValueFactory(new PropertyValueFactory<>("dataAquisicao"));
        tableColumnConservacaoBem.setCellValueFactory(new PropertyValueFactory<>("estadoConservacao"));
    }

    public void atualizarTabela() {
        if (espaco != null) {
            listaTabela = FXCollections.observableArrayList(new BemServices().getAll(espaco));
            tableViewBens.setItems(listaTabela);
        }
    }
}