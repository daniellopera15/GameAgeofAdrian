package com.juegos.ageofadrian.backsrv;

import org.beanio.BeanReader;
import org.beanio.BeanWriter;
import org.beanio.StreamFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BeanIO {

    public List<LegionHandler> lecturaCSV(String nombreFileCsv) {
        StreamFactory factory = StreamFactory.newInstance();
        factory.loadResource("legion.xml", null);

        //read it from the classpath : src/main/resources
        InputStream in = this.getClass().getResourceAsStream("/static/" + nombreFileCsv + ".csv");
        BeanReader reader = factory.createReader("legiones", new InputStreamReader(in));
        Object record = null;
        List<LegionHandler> legionHandlers = new ArrayList<>();

        // read records from "input.csv"
        while ((record = reader.read()) != null) {
            LegionHandler legionHandler = (LegionHandler) record;
            legionHandlers.add(legionHandler);
        }

        try {
            in.close();
        } catch (IOException e) {
            System.out.println("Problemas al leer el archivo " + nombreFileCsv);
        }
        //System.out.println(legionHandlers);
        return legionHandlers;
    }

    public void escrituraCSV(String nombreFileCsv, List<LegionHandler> legionHandlers) {
        StreamFactory factory = StreamFactory.newInstance();
        factory.loadResource("legion.xml", null);

        String userDir = System.getProperty("user.dir");

        BeanWriter writer = factory.createWriter("legiones",
                new File(userDir + "/AoA/src/main/resources/static/"+nombreFileCsv + ".csv"));

        for (LegionHandler legionHandler : legionHandlers) {
            writer.write(legionHandler);
        }

        writer.close();
    }
}
