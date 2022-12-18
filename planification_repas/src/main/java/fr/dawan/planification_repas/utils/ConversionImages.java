package fr.dawan.planification_repas.utils;

import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.time.Clock;
import java.util.Base64;

import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;

@Component
public class ConversionImages {

    public static byte[] ImageToByte(String pathName) {
        byte[] fileContent= null;
        File file = new File(pathName);
        FileInputStream fis = null;
        try {
            fileContent = Files.readAllBytes(file.toPath());
            fis = new FileInputStream(file);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        try {
            for (int readNum; (readNum = fis.read(buf)) != -1;) {
                bos.write(buf, 0, readNum);
                System.out.println("read " + readNum + " bytes,");
            }
        } catch (IOException ex) {

        }
        byte[] bytes = bos.toByteArray();
        System.out.println("********tableu de bytes créer******");
        return fileContent;

    }

    public static byte[] BytesToImage(String pathName) throws IOException {
        BufferedImage bImage = null;
        try {
            bImage = ImageIO.read(new File(pathName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageIO.write(bImage, "jpg", bos);
        byte[] data = bos.toByteArray();
        ByteArrayInputStream bis = new ByteArrayInputStream(data);
        BufferedImage bImage2 = ImageIO.read(bis);
        ImageIO.write(bImage2, "png", new File("output.png"));
        System.out.println("image created");
        return data;


    }

    // autres alternatives a la coversion images

    public static String encodeImage(String imgPath, String savePath) throws IOException {
        FileInputStream imageStream = new FileInputStream(imgPath);
        byte[] data= new byte[0];
        try {
            data = imageStream.readAllBytes();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String imageString = Base64.getEncoder().encodeToString(data);
        //on peut enregistrer en BBD
        // set image dans objet jourPeriode
        //ecrire dans un fichier
        FileWriter fileWriter = new FileWriter(savePath);
        fileWriter.write(imageString );

        fileWriter.close();
        imageStream.close();

        return imageString;
    }
    //decode image et creer un nveau fichier
    public static void decodeImage(String txtPath,String savePath) throws IOException {
        FileInputStream inputStream = new FileInputStream(txtPath);

        byte[] data = Base64.getDecoder().decode(inputStream.readAllBytes());
        //on copie img dans un fichier
        //on pourrais envoyer l'img dans le vue
        FileOutputStream fileOutputStream = new FileOutputStream(savePath);
        fileOutputStream.write(data);

        fileOutputStream.close();
        inputStream.close();
    }

}
