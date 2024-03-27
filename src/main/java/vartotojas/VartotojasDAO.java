package vartotojas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VartotojasDAO {
    public static final String URL = "jdbc:mysql://localhost:3306/maistukas";

    public static void kurti(Vartotojas vartotojas){

        String query = "INSERT INTO vartotojai(`vardas`, `pavarde`, `elpastas`, `role`, `pseudonimas`, `slaptazodis`) " +        "VALUES(?,?,?,?,?,?)";


        try {
            Connection connection = DriverManager.getConnection(URL, "root", "");

            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, vartotojas.getVardas());
            preparedStatement.setString(2, vartotojas.getPavarde());
            preparedStatement.setString(3, vartotojas.getElPastoAdresas());
            preparedStatement.setInt(4, vartotojas.getRole());
            preparedStatement.setString(5, vartotojas.getPseudonimas());
            preparedStatement.setString(6, vartotojas.getSlaptazodis());

            preparedStatement.executeUpdate();

            System.out.println("Pavyko įterpti naują įrašą į DB.");

            preparedStatement.close();
            connection.close();

        } catch (SQLException throwables) {

            System.out.println("Įvyko klaida kuriant naują įrašą DB-ėje. Plačiau: " + throwables.getMessage());
        }
    }
}
