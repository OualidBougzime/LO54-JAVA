package fr.utbm.ecole.core;

import fr.utbm.ecole.core.controller.DefaultCourseController;

/**
 *
 * @author
 */
public class CourseSession {

    public static void main(String[] args) {
        DefaultCourseController dfc = new DefaultCourseController();
        dfc.registerCourseFromConsoleInput();
    }
}
