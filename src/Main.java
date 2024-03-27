import istaiga.Istaiga;
import istaiga.IstaigaDAO;
import vartotojas.Vartotojas;
import vartotojas.VartotojasDAO;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        boolean arVeikia = true;
        while (arVeikia) {
            System.out.println("*** Maisto užsakymo programa \"Maistukas\" ***.\n\n" +
                    "Įveskite pasirinktą veiksmą ( 1 arba 2 ):" +
                    "\n >>> 1. REGISTRACIJA" +
                    "\n >>> 2. PRISIJUNGIMAS\n");
            Scanner ivestis1 = new Scanner(System.in);
            int arReg = ivestis1.nextInt();

            if (arReg == 1) {
                System.out.println();
                break;
            } else if (arReg == 2) {
                System.out.println("Administratorius (įveskite 1) ar klientas (įveskite 2)?");
                Scanner ivestis3 = new Scanner(System.in);
                int role = ivestis3.nextInt();

                Vartotojas vartotojas1 = null;
                if (role == 1) {
                    System.out.println("Vardas?");
                    Scanner ivestis4 = new Scanner(System.in);
                    String vardas = ivestis4.nextLine();
                    System.out.println("Pavardė? ");
                    String pavarde = ivestis4.nextLine();
                    System.out.println("El. paštas?");
                    String email = ivestis4.nextLine();
                    System.out.println("Pseudonimas?");
                    String pseudonimas = ivestis4.nextLine();
                    System.out.println("Slaptažodis?");
                    String slaptazodis = ivestis4.nextLine();


                    vartotojas1 = new Vartotojas(vardas, pavarde, email, role, pseudonimas, slaptazodis);
                } else if (role == 2) {
                    System.out.println("Vardas?");
                    Scanner ivestis4 = new Scanner(System.in);
                    String vardas = ivestis4.nextLine();
                    System.out.println("Pavardė? ");
                    String pavarde = ivestis4.nextLine();
                    System.out.println("El. paštas?");
                    String email = ivestis4.nextLine();
                    System.out.println("Pseudonimas?");
                    String pseudonimas = ivestis4.nextLine();
                    System.out.println("Slaptažodis?");
                    String slaptazodis = ivestis4.nextLine();


                    vartotojas1 = new Vartotojas(vardas, pavarde, email, role, pseudonimas, slaptazodis);
                } else {
                    System.out.println("Tokio pasirinkimo nėra");
                }
                kurtiVartotoja(vartotojas1);
                break;
            } else {
                System.out.println("Tokio pasirinkimo nėra");
            }
        }//pradinis while

        while (arVeikia == true) {
            System.out.println("Meniu\n Pridėti maitinimo įstaigą - įveskite 1\n Ieškoti maitinimo įstaigos - įveskite 2");
            Scanner ivestis2 = new Scanner(System.in);
            int admMeniu = ivestis2.nextInt();

            if (admMeniu == 1) {
                kurtiIstaiga();
                break;
            } else if (admMeniu == 2) {
                ieskotiIstaigos();
                break;
            } else {
                System.out.println("Tokio pasirinkimo nėra");
            }
        }//dashboard while



    }//main


    static void ieskotiIstaigos(){
        System.out.println("Įstaigos paieška DB-ėje pagal miestą. \nĮveskite miestą, kuriame norite ieškoti:");
        Scanner ivestis = new Scanner(System.in);
        String miestas = ivestis.nextLine();
        IstaigaDAO.ieskotiIstaigos(miestas);
    }


    static void kurtiIstaiga(){
        System.out.println("Įstaigos pavadinimas?");
        Scanner ivestis1 = new Scanner(System.in);
        String pavadinimas = ivestis1.nextLine();
        System.out.println("Įstaigos kodas? Įveskite skaičių: ");
        Scanner ivestis2 = new Scanner(System.in);
        int kodas = ivestis2.nextInt();
        System.out.println("Įstaigos adresas?");
        String adresas = ivestis1.nextLine();

        Istaiga istaiga1 = new Istaiga(pavadinimas, kodas, adresas);
        IstaigaDAO.kurti(istaiga1);
    }//kurtiIstaiga


    static void kurtiVartotoja(Vartotojas vartotojas){

        VartotojasDAO.kurti(vartotojas);
    }
}