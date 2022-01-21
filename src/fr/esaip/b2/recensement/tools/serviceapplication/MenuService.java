package fr.esaip.b2.recensement.tools.serviceapplication;

import fr.esaip.b2.recensement.entities.Recensement;

import java.util.Scanner;

public abstract class MenuService {

    public abstract void traiter(Recensement recensement, Scanner scanner);
}
