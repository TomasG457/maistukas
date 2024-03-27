package vartotojas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VartotojasDAO {
    public static void kurtiVartotoja(Vartotojas vartotojas){
        String query = "INSERT INTO vartotojai (`vardas`, `elpastas`, `role`, `slaptazodis`) " + "VALUES(?,?,?,?)";
        String URL = "jdbc:mysql://localhost:3306/maistukas";
        try {
            // sukuriamas prisijungimas prie duomenų bazės:
            Connection connection = DriverManager.getConnection(URL, "root", "");
            // sukuriama užklausa:
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            // siekiant išvengti SQL injekcijų,
            preparedStatement.setString(1, vartotojas.getVardas());
            preparedStatement.setString(2, vartotojas.getElPastoAdresas());
            preparedStatement.setInt(3, vartotojas.getRole());
            preparedStatement.setString(4, vartotojas.getSlaptazodis());
            // įvykdoma užklausa (executeUpdate() metodas naudojamas, kai norime sukurti naują įrašą, redaguoti ir trinti esamą):
            // įrašo paieškai naudojame executeQuerry() metodą.
            preparedStatement.executeUpdate();
            System.out.println("Naujas vartotojas sukurtas!");

            preparedStatement.close();
            connection.close();

        } catch (SQLException a) {
            System.out.println("Vartotojo sukurti nepavyko! Plačiau: " + a.getMessage());
        }
    }

}
