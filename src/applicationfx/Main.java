package applicationfx;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.geometry.Insets;
import javafx.scene.paint.Color;


public class Main extends Application {
    Scene scene;
    VBox panel;
    HBox panel1;
    Button AjouterClient;
    Button ConsulButton;
    Button OperButton;
    Agence agence;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            agence=BaseDonnes.Load();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        panel=new VBox();
        panel1=new HBox(10);
        AjouterClient=new Button("Ajouter Un Client");
        ConsulButton=new Button("Consulter Un Client");
        OperButton=new Button("Operations");
            AjouterClient.setStyle("-fx-font: normal bold 15px 'serif'  ");
            ConsulButton.setStyle("-fx-font: normal bold 15px 'serif'  ");
            OperButton.setStyle("-fx-font: normal bold 15px 'serif'  ");

        panel1.getChildren().addAll(AjouterClient,ConsulButton,OperButton);
        panel1.setAlignment(Pos.CENTER);
        panel.setAlignment(Pos.CENTER);
        panel.getChildren().addAll(panel1);
        panel.setStyle("-fx-background-image: url('image.jpg');-fx-background-size : cover;    ");
        AjouterClient.setOnAction(event -> {
            panel.getChildren().removeAll(panel.getChildren());
            VBox temp=new VBox(5);
            VBox.setMargin(temp, new Insets(10,10,10,10));
            temp.setAlignment(Pos.CENTER);
            Label temp1=new Label("Nom :");
            TextField temp2=new TextField();
            Label temp3=new Label("CIN :");
            TextField temp4=new TextField();
            Label temp5=new Label("Type de compte :");
            ComboBox temp6=new ComboBox();
            temp6.getItems().addAll("Compte Simple","Compte Payant","Compte Epargne");
            Label temp7=new Label("Solde initiale :");
            TextField temp8=new TextField();
            Button temp9=new Button("Ajouter");
            temp9.setOnAction(event1 -> {
                Client tempClient=new Client(temp4.getText(),temp2.getText());
                Compte tempCompte = null;
                if (temp6.getValue().equals("Compte Simple")) {
                    tempCompte = new CompteSimple(Float.parseFloat(temp8.getText()));
                }
                if (temp6.getValue().equals("Compte Payant")) {
                    tempCompte = new ComptePayant(Float.parseFloat(temp8.getText()));
                }
                if (temp6.getValue().equals("Compte Epargne")) {
                    tempCompte = new CompteEpargne(Float.parseFloat(temp8.getText()));
                }
                tempCompte.setProprietaire(tempClient);
                tempClient.setCompte(tempCompte);
                agence.ajouteClient(tempClient);
                agence.ajouteCompte(tempCompte);
                try {
                    BaseDonnes.Save(agence);
                    panel.getChildren().removeAll(panel.getChildren());
                    panel.getChildren().addAll(panel1);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            Button temp10=new Button("Retour");
            temp10.setOnAction(event1 -> {
                panel.getChildren().removeAll(panel.getChildren());
                panel.getChildren().addAll(panel1);
            });
            temp1.setStyle("-fx-text-fill: white;-fx-font: normal bold 20px 'serif'  ");
            temp3.setStyle("-fx-text-fill: white;-fx-font: normal bold 20px 'serif'  ");
            temp5.setStyle("-fx-text-fill: white;-fx-font: normal bold 20px 'serif'  ");
            temp7.setStyle("-fx-text-fill: white;-fx-font: normal bold 20px 'serif'  ");
                        temp10.setStyle("-fx-font: normal bold 15px 'serif'  ");
            temp9.setStyle("-fx-font: normal bold 15px 'serif'  ");

            //temp1.setStyle("-fx-text-fill: white;-fx-font: normal bold 20px 'serif'  ");
            temp.getChildren().addAll(temp1,temp2,temp3,temp4,temp5,temp6,temp7,temp8,temp9,temp10);
            panel.getChildren().addAll(temp);
        });
        ConsulButton.setOnAction(event -> {
            panel.getChildren().removeAll(panel.getChildren());
            VBox temp=new VBox(5);
            temp.setAlignment(Pos.CENTER);
            Label temp1=new Label("Chercher Un Client Par Nom :");
            TextField temp2=new TextField();
            Button temp3=new Button("Chercher");
            temp3.setOnAction(event1 -> {
                Client tempC=null;
                for (int i=0;i<agence.lesClients.size();i++){
                    if(agence.lesClients.elementAt(i).getNom().equals(temp2.getText())){
                        tempC=agence.lesClients.elementAt(i);
                    }
                }
                if (tempC==null){
                    Label temp4=new Label("Aucun Client");
                    panel.getChildren().add(temp4);
                }else{
//                    TextField temp5=new TextField();
//                    temp5.setText(tempC.getNom());
                    TextArea temp5=new TextArea();
                    temp5.setText("Nom : " + tempC.getNom() + "\n CIN : " + tempC.getCin() + "\n Type Compte : " + tempC.getCompte().getClass() + "\n Solde : " + tempC.getCompte().getSolde() );
                    panel.getChildren().add(temp5);
                    temp3.setDisable(true);
                }
            });
            Button temp4=new Button("Retour");
            temp4.setOnAction(event1 -> {
                panel.getChildren().removeAll(panel.getChildren());
                panel.getChildren().addAll(panel1);
            });
            VBox.setMargin(temp, new Insets(10,10,10,10));
            temp1.setStyle("-fx-text-fill: white;-fx-font: normal bold 20px 'serif'  ");
            temp3.setStyle("-fx-font: normal bold 15px 'serif'  ");
            temp4.setStyle("-fx-font: normal bold 15px 'serif'");

            temp.getChildren().addAll(temp1,temp2,temp3,temp4);
            panel.getChildren().addAll(temp);
        });
        OperButton.setOnAction(event -> {
            panel.getChildren().removeAll(panel.getChildren());
            VBox temp=new VBox(5);
            temp.setAlignment(Pos.CENTER);
            Label temp1=new Label("Chercher Un Client Par Nom :");
            TextField temp2=new TextField();
            Label temp3=new Label("Montant a retirer/verser :");
            TextField temp4=new TextField();
            Button temp5=new Button("Retirer");
            Button temp6=new Button("Verser");
            Button temp8=new Button("Retour");
            temp5.setStyle("-fx-font: normal bold 15px 'serif'  ");
            temp6.setStyle("-fx-font: normal bold 15px 'serif'  ");
            temp8.setStyle("-fx-font: normal bold 15px 'serif'  ");

            temp5.setOnAction(event1 -> {
                Client tempC=null;
                for (int i=0;i<agence.lesClients.size();i++){
                    if(agence.lesClients.elementAt(i).getNom().equals(temp2.getText())){
                        tempC=agence.lesClients.elementAt(i);
                    }
                }
                if (tempC==null){
                    Label temp7=new Label("Aucun Client");
                    panel.getChildren().add(temp7);
                }else{
                    if(tempC.getCompte().getSolde()<Float.parseFloat(temp4.getText())){
                        Label temp7=new Label("Pas asser argent");
                        panel.getChildren().add(temp7);
                    }else{
                        tempC.getCompte().retirer(Float.parseFloat(temp4.getText()));
                        Label temp7=new Label("Bien traite");
                        panel.getChildren().add(temp7);
                        try {
                            BaseDonnes.Save(agence);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                }
            });
            temp6.setOnAction(event1 -> {
                Client tempC=null;
                for (int i=0;i<agence.lesClients.size();i++){
                    if(agence.lesClients.elementAt(i).getNom().equals(temp2.getText())){
                        tempC=agence.lesClients.elementAt(i);
                    }
                }
                if (tempC==null){
                    Label temp7=new Label("Aucun Client");
                    panel.getChildren().add(temp7);
                }else{
                        tempC.getCompte().verser(Float.parseFloat(temp4.getText()));
                        Label temp7=new Label("Bien traite");
                        panel.getChildren().add(temp7);
                    try {
                        BaseDonnes.Save(agence);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            temp8.setOnAction(event1 -> {
                panel.getChildren().removeAll(panel.getChildren());
                panel.getChildren().addAll(panel1);
            });
             VBox.setMargin(temp, new Insets(10,10,10,10));

            temp1.setStyle("-fx-text-fill: white;-fx-font: normal bold 20px 'serif'  ");
            temp3.setStyle("-fx-text-fill: white;-fx-font: normal bold 20px 'serif'  ");
            temp.getChildren().addAll(temp1,temp2,temp3,temp4,temp5,temp6,temp8);
            panel.getChildren().addAll(temp);
        });
        scene=new Scene(panel,400,400);
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
