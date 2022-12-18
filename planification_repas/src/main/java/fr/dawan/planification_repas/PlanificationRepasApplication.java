package fr.dawan.planification_repas;

import fr.dawan.planification_repas.model.Jour;
import fr.dawan.planification_repas.model.JourPeriode;
import fr.dawan.planification_repas.model.Periode;
import fr.dawan.planification_repas.service.JourPeriodeService;
import fr.dawan.planification_repas.service.JourService;
import fr.dawan.planification_repas.service.PeriodeService;
import fr.dawan.planification_repas.utils.ConversionImages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.imageio.ImageIO;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.awt.image.BufferedImage;
import java.util.Base64;

@SpringBootApplication
public class PlanificationRepasApplication implements CommandLineRunner {

    @Autowired
    private JourService jourService;

    @Autowired
    private PeriodeService periodeService;

    @Autowired
    private JourPeriodeService jourPeriodeService;

    public static void main(String[] args) {
        SpringApplication.run(PlanificationRepasApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Jour lundi = new Jour("Lundi");
        lundi.setId(1);
        Jour mercredi = new Jour("Mercredi");
        mercredi.setId(3);

        Periode dejeuner = new Periode("dejeuner");
        dejeuner.setId(1);

        Periode dinner = new Periode("dinner");
        dinner.setId(2);

        JourPeriode jourPeriode1 = new JourPeriode(lundi, dejeuner, "poulet Champignons", null);
        JourPeriode jourPeriode2 = new JourPeriode(lundi, dinner, "poulet basquaise", null);
        lundi.ajouterJourPeriode(jourPeriode1);
        lundi.ajouterJourPeriode(jourPeriode2);
        //mercredi.ajouterJourPeriode(jourPeriode1);
        //mercredi.ajouterJourPeriode(jourPeriode2);
       // System.out.println("lundi periodes: " + lundi.getJourPeriodes());

        // jourPeriodeService.AjouterJourPeriode(jourPeriode);
        periodeService.ajouterJourPeriode(dejeuner);
        periodeService.ajouterJourPeriode(dinner);
        jourService.ajouterJour(lundi);
        jourService.ajouterJour(mercredi);

//        System.out.println(jourService.rechercherTousLesJours());
//        System.out.println();
//        System.out.println(periodeService.rechercherToutesLesPeriodes());
//        System.out.println();
//        System.out.println(jourPeriodeService.rechercherTousLesJoursPeriodes());

       // byte[] result = ConversionImages.ImageToByte("C:/Users/Admin Stagiaire/2022-12-05-html-css-rwd-main/2022-12-05-html-css-rwd-main/images/pip-boy-boy.png");
        System.out.println(ConversionImages.encodeImage("C:\\Users\\Admin Stagiaire\\2022-12-05-html-css-rwd-main\\2022-12-05-html-css-rwd-main\\images\\pip-boy-boy.png",
                "C:\\Users\\Admin Stagiaire\\Desktop\\image.txt"));

        System.out.println();
    ConversionImages.decodeImage("C:\\Users\\Admin Stagiaire\\Desktop\\image.txt",
            "C:\\Users\\Admin Stagiaire\\Desktop\\image1.jpg");

    //jourPeriodeService.effacerToutesLesRecettesPlanning();
    }




}
