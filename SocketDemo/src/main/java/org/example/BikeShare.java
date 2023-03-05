package org.example;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class BikeShare {
    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
        // create URL
        String url = "https://api.mockaroo.com/api/e9cc2e00?count=20&key=e99c5530";
        URL netURL = new URL(url);

        URLConnection conn = netURL.openConnection();
        conn.setDoOutput(false);
        conn.setDoInput(true);

        // load the data using a URLConnection
        InputStream inStream = conn.getInputStream();

        // DocumentBuilder to parse the XML data
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = dbFactory.newDocumentBuilder();
        Document document = docBuilder.parse(inStream);
        document.getDocumentElement().normalize();

        NodeList itemNodes = document.getElementsByTagName("station");

        // iterating over all the stations
        for (int i = 0; i < itemNodes.getLength(); i++) {
            Node itemNode = itemNodes.item(i);
            // retrieve properties for each station
            if (itemNode.getNodeType() == Node.ELEMENT_NODE) {
                Element itemElement = (Element)itemNode;

                // read each individual property
                String name = getTagValue("name", itemElement);
                String lat = getTagValue("lat", itemElement);
                String lon = getTagValue("long", itemElement);
                String num = getTagValue("nbBikes", itemElement);
                String id = getTagValue("id", itemElement);

                // output the formatted date into the console
                System.out.printf("[%s] %s (%s, %s): %s bikes available.\n",
                        id,
                        name,
                        lat,
                        lon,
                        num
                );

            }
        }




    }

    private static String getTagValue(String name, Element itemElement) {
        NodeList tags = itemElement.getElementsByTagName(name);
        if(tags.getLength()>0) {
            return tags.item(0).getTextContent();
        }

        return null;
    }
}
