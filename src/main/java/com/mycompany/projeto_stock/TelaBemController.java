package com.mycompany.projeto_stock;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.classes.Bem;
import model.services.BemServices;

public class TelaBemController implements Initializable {

    @FXML
    private Button btnExcluirBem;

    @FXML
    private Button btnNovoBem;

    @FXML
    private Button btnTelaEspacos;

    @FXML
    private TableView<Bem> tableViewBem;

    @FXML
    private TableColumn<Bem, String> tableColumnCategoriaBem;

    @FXML
    private TableColumn<Bem, Integer> tableColumnCodBem;

    @FXML
    private TableColumn<Bem, Integer> tableColumnConservacaoBem;

    @FXML
    private TableColumn<Bem, LocalDate> tableColumnDataAquisicaoBem;

    @FXML
    private TableColumn<Bem, String> tableColumnDescricaoBem;

    @FXML
    private TableColumn<Bem, String> tableColumnNomeBem;

    @FXML
    private TableColumn<Bem, Float> tableColumnValorBem;

    @FXML
    private ImageView imgTelaBem;

    private ObservableList<Bem> listaTabela;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        tableColumnCodBem.setCellValueFactory(new PropertyValueFactory<>("codBem"));
        tableColumnCategoriaBem.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        tableColumnNomeBem.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tableColumnDescricaoBem.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        tableColumnValorBem.setCellValueFactory(new PropertyValueFactory<>("valor"));
        tableColumnDataAquisicaoBem.setCellValueFactory(new PropertyValueFactory<>("dataAquisicao"));
        tableColumnConservacaoBem.setCellValueFactory(new PropertyValueFactory<>("estadoConservacao"));
        tableColumnConservacaoBem.setCellFactory(column -> {return new TableCell<Bem, Integer>() { 
                @Override
                protected void updateItem(Integer item, boolean empty) {
                    super.updateItem(item, empty);
                    if (item == null || empty) {
                        setText(null);
                    } else {
                        if (item == 1) {
                            setText("Bom");
                        } else if (item == 2) {
                            setText("Ruim");
                        } else {
                            setText("");
                        }
                    }
                }
            };
        });
        atualizarTabela();

        btnNovoBem.setOnAction((t) -> {
            try {
                Parent parent = FXMLLoader.load(getClass().getResource("TelaCadastroBem.fxml"));
                Scene scene = new Scene(parent);

                Stage stage = new Stage();
                stage.setTitle("Tela de Cadastro de Novo Bem");
                stage.setScene(scene);
                stage.initOwner(btnNovoBem.getScene().getWindow());
                stage.initModality(Modality.WINDOW_MODAL);
                stage.showAndWait();
                atualizarTabela();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        btnExcluirBem.setOnAction((t) -> {
            if (tableViewBem.getSelectionModel().getSelectedItem() != null) {
                Bem bem = tableViewBem.getSelectionModel().getSelectedItem();
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmação");
                alert.setHeaderText(null);
                alert.setContentText(bem.getNome() + " será excluido! Tem certeza?");
                if (alert.showAndWait().get() == ButtonType.OK) {
                    if (new BemServices().excluir(bem)) {
                        Alert mens = new Alert(Alert.AlertType.INFORMATION);
                        mens.setTitle("Excluído");
                        mens.setHeaderText(null);
                        mens.setContentText("Registro excluído!");
                        mens.showAndWait();
                        atualizarTabela();
                    }
                }
            }
        });

        EventHandler<MouseEvent> cliqueMouse = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                if (t.getButton().equals(MouseButton.PRIMARY)) {
                    if (t.getClickCount() == 2 && tableViewBem.getSelectionModel().getSelectedItem() != null) {
                        Bem bem = tableViewBem.getSelectionModel().getSelectedItem();
                        System.out.println(bem.toString());
                        try {
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("TelaCadastroBem.fxml"));
                            Scene scene = new Scene(loader.load());

                            Stage stage = new Stage();
                            stage.setTitle("Cadastro de Departamento");
                            stage.setScene(scene);
                            stage.initOwner(tableViewBem.getScene().getWindow());
                            stage.initModality(Modality.WINDOW_MODAL);
                            TelaCadastroBemController cont = loader.getController();
                            cont.setBem(bem);
                            stage.showAndWait();
                            atualizarTabela();

                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            }
        };
        tableViewBem.setOnMouseClicked(cliqueMouse);

        btnTelaEspacos.setOnAction((t) -> {
            try {
                Parent parent = FXMLLoader.load(getClass().getResource("TelaEspaco.fxml"));
                Scene scene = new Scene(parent);
                Stage stage = new Stage();
                stage.setTitle("Tela de Visualização de Espaços");
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }

    public void atualizarTabela() {
        listaTabela = FXCollections.observableArrayList(new BemServices().getAll());
        tableViewBem.setItems(listaTabela);
    }
}
