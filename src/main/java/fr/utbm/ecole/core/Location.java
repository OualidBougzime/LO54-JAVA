package fr.utbm.ecole.core;

import fr.utbm.ecole.core.controller.DefaultLocationController;

/**
 *
 * @author
 */
public class  Location  {

    public static void main(String[] args) {
        DefaultLocationController dlc = new DefaultLocationController();
        dlc.registerLocationFromConsoleInput();
        
    }
}