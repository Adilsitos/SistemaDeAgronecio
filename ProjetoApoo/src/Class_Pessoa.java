/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author carlos
 */
public class Class_Pessoa{
      int senha;
         String login;
         String nome;
         int idade;
         String sexo;
         String end;
         String tipo;
         int telefone;
          int cpf;
           int cnpj;

    public int getCpf() {
        return cpf;
    }

    public int getCnpj() {
        return cnpj;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public void setCnpj(int cnpj) {
        this.cnpj = cnpj;
    }
           
         
    public String getEnd() {
       return end;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public int getSenha() {
        return senha;
    }

    public String getLogin() {
        return login;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getSexo() {
        return sexo;
    }

    public String getTipo() {
        return tipo;
    }

    public int getTelefone() {
        return telefone;
    }
           
    
}
