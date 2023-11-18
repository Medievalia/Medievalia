package com.example.myapplication.database;

import android.os.AsyncTask;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLConnection {
    //criar atributos
    public static String bancoDados, usuario, senha, servidor;
    public static int porta;

    //variavel de conexao
    //public static Connection conexao;
    public static Connection conexao = null;

    //define valores padrão
    static {
        //mysql e mariaDB
        bancoDados = "hystera";
        usuario = "root";
        senha = "";
        servidor = "localhost";
        porta = 3306;
    }

    //métodos
    public static void conectar() throws SQLException, ClassNotFoundException {
        //Class.forName("org.mariadb.jdbc.Driver");
        System.out.println("funciona pfvr");

        //MariaDB xampp
        String url = "jdbc:mariadb://" + servidor + ":" + porta + "/" + bancoDados;

        conexao = DriverManager.getConnection(url, usuario, senha);
        System.out.println("funciona pfvr2222S2");
    }

    public static void desconectar() throws SQLException {
        conexao.close();
    }

    public static java.sql.Connection obterConexao()
            throws SQLException {
        if (conexao == null) {
            throw new SQLException("Conexão está fechada..");
        } else {
            return conexao;
        }
    }

}
