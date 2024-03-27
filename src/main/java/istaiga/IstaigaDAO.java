package istaiga;

import java.sql.*;
import java.util.ArrayList;

public class IstaigaDAO {
    public static final String URL = "jdbc:mysql://localhost:3306/maistukas";
    public static void kurtiIstaiga(Istaiga istaiga){

        String query = "INSERT INTO istaigos(`pavadinimas`, `kodas`, `adresas`) " + "VALUES(?,?,?)";
        try {
            Connection connection = DriverManager.getConnection(URL, "root", "");

            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, istaiga.getPavadinimas());
            preparedStatement.setInt(2, istaiga.getKodas());
            preparedStatement.setString(3, istaiga.getAdresas());


            preparedStatement.executeUpdate();

            System.out.println("Pavyko įterpti naują įrašą į DB.");

            preparedStatement.close();
            connection.close();

        } catch (SQLException throwables) {

            System.out.println("Įvyko klaida kuriant naują įrašą DB-ėje. Plačiau: " + throwables.getMessage());
        }
    } //čia create metodo galas



    public static void ieskotiIstaigos(String adresas) {
        String uzklausa = "SELECT * FROM `istaigos` WHERE `adresas` LIKE '%" + adresas + "%'";

        try {
            Connection connection = DriverManager.getConnection(URL, "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement(uzklausa);

            ResultSet resultSet = preparedStatement.executeQuery(uzklausa);

            ArrayList<Istaiga> istaigos = new ArrayList<>();

            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String pavadinimas = resultSet.getString("pavadinimas");
                int kodas = resultSet.getInt("kodas");
                adresas = resultSet.getString("adresas");

                istaigos.add(new Istaiga(id, pavadinimas, kodas, adresas));
            }

            if (istaigos.isEmpty()){
                System.out.println("Įstaigų iš šio miesto: " + adresas + " DB-ėje rasti nepavyko.");
            }
            else {
                System.out.println("Rastos tokios įstaigos: \n");
                System.out.println(istaigos);
            }
            preparedStatement.close();
            connection.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
