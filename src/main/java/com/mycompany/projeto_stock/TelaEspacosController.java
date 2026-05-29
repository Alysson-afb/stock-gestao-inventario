package com.mycompany.projeto_stock;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.classes.Espacos;
import model.services.EspacosService;

public class TelaEspacosController implements Initializable {

    @FXML
    private Button btnExcluirEspaco;

    @FXML
    private Button btnListarEspaco;

    @FXML
    private Button btnNovoEspaco;

    @FXML
    private Button btnTelaBens;

    @FXML
    private TableView<Espacos> tableViewEspacos;

    @FXML
    private TableColumn<Espacos, Integer> tableColumnCodEspaco;

    @FXML
    private TableColumn<Espacos, String> tableColumnDescricaoEspaco;

    @FXML
    private TableColumn<Espacos, String> tableColumnNomeEspaco;

    @FXML
    private TableColumn<Espacos, Integer> tableColumnNumeroEspaco;

    @FXML
    private ImageView imgTelaEspaco;

    private ObservableList<Espacos> listaTabela;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        tableColumnCodEspaco.setCellValueFactory(new PropertyValueFactory<>("codEspaco"));
        tableColumnNomeEspaco.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tableColumnDescricaoEspaco.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        tableColumnNumeroEspaco.setCellValueFactory(new PropertyValueFactory<>("numero"));
        atualizarTabela();

        btnListarEspaco.setOnAction((t) -> {
            Espacos espacoSelecionado = tableViewEspacos.getSelectionModel().getSelectedItem();
            if (espacoSelecionado != null) {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("TelaListarEspacos.fxml"));
                    Parent parent = loader.load();

                    TelaListarEspacosController controller = loader.getController();
                    controller.setEspaco(espacoSelecionado);

                    Stage stage = new Stage();
                    stage.setTitle("Bens no Espaço: " + espacoSelecionado.getNome());
                    stage.setScene(new Scene(parent));
                    stage.initModality(Modality.WINDOW_MODAL);
                    stage.initOwner(btnListarEspaco.getScene().getWindow());
                    stage.showAndWait();

                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Nenhum Espaço Selecionado");
                alert.setHeaderText(null);
                alert.setContentText("Por favor, selecione um espaço na tabela para listar os bens do espaço.");
                alert.showAndWait();
            }
        });

        EventHandler<MouseEvent> cliqueMouse = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                if (t.getButton().equals(MouseButton.PRIMARY)) {
                    if (t.getClickCount() == 2 && tableViewEspacos.getSelectionModel().getSelectedItem() != null) {
                        Espacos espaco = tableViewEspacos.getSelectionModel().getSelectedItem();
                        System.out.println(espaco.toString());
                        try {
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("TelaCadastroEspaco.fxml"));
                            Scene scene = new Scene(loader.load());

                            Stage stage = new Stage();
                            stage.setTitle("Cadastro de Departamento");
                            stage.setScene(scene);
                            stage.initOwner(tableViewEspacos.getScene().getWindow());
                            stage.initModality(Modality.WINDOW_MODAL);
                            TelaCadastroEspacoController cont = loader.getController();
                            cont.setEspaco(espaco);
                            stage.showAndWait();
                            atualizarTabela();

                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            }
        };
        tableViewEspacos.setOnMouseClicked(cliqueMouse);

        btnNovoEspaco.setOnAction((t) -> {
            try {
                Parent parent = FXMLLoader.load(getClass().getResource("TelaCadastroEspaco.fxml"));
                Scene scene = new Scene(parent);

                Stage stage = new Stage();
                stage.setTitle("Tela de Cadastro de Novo Espaço");
                stage.setScene(scene);
                stage.initOwner(btnNovoEspaco.getScene().getWindow());
                stage.initModality(Modality.WINDOW_MODAL);
                stage.showAndWait();
                atualizarTabela();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        btnExcluirEspaco.setOnAction((t) -> {
            if (tableViewEspacos.getSelectionModel().getSelectedItem() != null) {
                Espacos espacos = tableViewEspacos.getSelectionModel().getSelectedItem();
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmação");
                alert.setHeaderText(null);
                alert.setContentText(espacos.getNome() + " será excluido! Tem certeza?");
                if (alert.showAndWait().get() == ButtonType.OK) {
                    if (new EspacosService().excluir(espacos)) {
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

        btnTelaBens.setOnAction((t) -> {
            try {
                Parent parent = FXMLLoader.load(getClass().getResource("TelaBem.fxml"));
                Scene scene = new Scene(parent);
                Stage stage = new Stage();
                stage.setTitle("Tela de Visualização de Bens");
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

    }

    public void atualizarTabela() {
        listaTabela = FXCollections.observableArrayList(new EspacosService().getAll());
        tableViewEspacos.setItems(listaTabela);
    }

    private void setcodEspaco(Espacos espacos) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
