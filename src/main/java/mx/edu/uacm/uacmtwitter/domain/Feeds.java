package mx.edu.uacm.uacmtwitter.domain;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class Feeds {
	public void desplegarFeeds() throws ParserConfigurationException, IOException, SAXException, XPathExpressionException{
		//Clase de xml
		DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = domFactory.newDocumentBuilder();
		URL urlxml2 = new URL("https://twitrss.me/twitter_user_to_rss/?user=uacm");
		
		URLConnection uc = urlxml2.openConnection();
		uc.addRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");
		uc.connect();
		
		//una vez conectada, obtenemos el flujo de información para regresar xml y procesarlo
		InputStream inputStream = uc.getInputStream();
		Reader reader = new InputStreamReader(inputStream);
		InputSource inputsource = new InputSource(reader);
		//Documento en forma de xml
		Document doc = builder.parse(inputsource);
		
		//Parte de xpath
		XPath xpath = XPathFactory.newInstance().newXPath();
		//Aqui se utilizan las expresiones de XPath
		XPathExpression expr = xpath.compile("//rss/channel/item/title/text()");
		XPathExpression expr2 = xpath.compile("//rss/channel/item/description/text()");
		NodeList nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
		NodeList nodes2 = (NodeList) expr2.evaluate(doc, XPathConstants.NODESET);
		
		//Recorre todos los nodos imprimiendo los titulos
		for (int i=0; i< nodes.getLength(); i++){
			String title = nodes.item(i).getNodeValue();
			String description = nodes2.item(i).getNodeValue();
			//String img = nodes3.item(i).getNodeValue();
			System.out.println("TITULO:   " + title + "\n" + "DESCRIPCION: " + description + "\n\n\n\n");			
		}
	}
	

}
