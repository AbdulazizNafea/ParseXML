package com.example.parse_xml.service;

import com.example.parse_xml.pojo.DemoModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


@Service
public class DemoService {

    private final Logger logger = LoggerFactory.getLogger(DemoService.class);

    public DemoModel parseCourse() {
        DemoModel demoModel = null;

        try {
            //Endpoint that returns XML response
            String URL = "file:///C:/Users/matar/Desktop/test.xml";

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(URL);

            // normalize XML response
            doc.getDocumentElement().normalize();




            //read details from XML
            demoModel = new DemoModel(
                    Integer.parseInt(doc.getElementsByTagName("transactionReferenceNumber").item(0).getTextContent()),
                    doc.getElementsByTagName("status").item(0).getTextContent(),
                   doc.getElementsByTagName("requestDate").item(0).getTextContent()
            );

            //Set Data
            demoModel.setStatus(demoModel.getStatus());
            demoModel.setTransactionReferenceNumber(demoModel.getTransactionReferenceNumber());
            demoModel.setRequestDate(demoModel.getRequestDate());


        }catch (Exception e) {
            logger.error(e.getMessage());
        }
        return demoModel;
    }
}
