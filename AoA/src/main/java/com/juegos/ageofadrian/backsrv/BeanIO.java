package com.juegos.ageofadrian.backsrv;

import org.beanio.BeanReader;
import org.beanio.StreamFactory;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BeanIO {
    private final String FILE_NAME = "legion.xml";

    public void lecturaCSV(String nombreFileCsv){
        StreamFactory factory = StreamFactory.newInstance();
        factory.load(FILE_NAME);

        //read it from the classpath : src/main/resources
        InputStream in = this.getClass().getResourceAsStream("/static/"+ nombreFileCsv + ".csv");
        BeanReader reader = factory.createReader("legiones", new InputStreamReader(in));
        Object record = null;
        List<EjercitoHandler> ejercitoHandlers = new ArrayList<>();

        // read records from "input.csv"
        while ((record = reader.read()) != null) {
            if ("header".equals(reader.getRecordName()))
            {

                @SuppressWarnings("unchecked")
                Map<String, Object> header = (Map<String, Object>) record;
                System.out.println(header.get("fileDate"));
            }
            else if ("detail".equals(reader.getRecordName())){
                EjercitoHandler ejercitoHandler = (EjercitoHandler) record;
                ejercitoHandlers.add(ejercitoHandler);
            }
        }

        System.out.println(ejercitoHandlers);
    }
}
