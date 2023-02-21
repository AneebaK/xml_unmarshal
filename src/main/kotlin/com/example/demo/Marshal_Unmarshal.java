package com.example.demo;

import de.xleitstelle.xbau.kernmodul._1._2.AllgemeinerName;
import de.xleitstelle.xbau.kernmodul._1._2.AmBauBeteiligtePerson;
import de.xleitstelle.xbau.kernmodul._1._2.Anschrift;
import de.xleitstelle.xbau.kernmodul._1._2.NameNatuerlichePerson;
import jakarta.xml.bind.*;
import net.opengis.gml._3.ObjectFactory;
import org.xml.sax.InputSource;

import javax.naming.Context;
import javax.naming.Name;
import javax.xml.namespace.QName;
import java.io.File;
import java.util.Hashtable;


public class Marshal_Unmarshal {
    public static void main(String[] args) {

        de.xleitstelle.xbau.kernmodul._1._2.ObjectFactory obj = new de.xleitstelle.xbau.kernmodul._1._2.ObjectFactory();

        //Antragsteller
        //NameNatuerlichePerson natuerlichePerson = new NameNatuerlichePerson();
        NameNatuerlichePerson natuerlichePerson = obj.createNameNatuerlichePerson();
        AllgemeinerName familyName = new AllgemeinerName();
        AllgemeinerName vorName = new AllgemeinerName();
        familyName.setName("Khan");
        familyName.setNichtVorhanden(false);
        vorName.setName("Ali");
        vorName.setNichtVorhanden(false);
        natuerlichePerson.setAnrede("Herr");
        natuerlichePerson.setTitel("Dr");
        natuerlichePerson.setFamilienname(familyName);
        natuerlichePerson.setVorname(vorName);

        //Bauvorhaben
        AmBauBeteiligtePerson bauBeteiligtePerson = obj.createAmBauBeteiligtePerson();
        NameNatuerlichePerson natuerlichePerson1 = obj.createNameNatuerlichePerson();
        de.xleitstelle.xbau.kernmodul._1._2.Anschrift anschrift = new Anschrift();
        anschrift.setHausnummer("12");
        anschrift.setPostleitzahl("23456");
        anschrift.setStrasse("strasseabv");
        AllgemeinerName familynameBauvor = new AllgemeinerName();
        familynameBauvor.setName("Jhon");
        familynameBauvor.setNichtVorhanden(true);
        AllgemeinerName vornameBauvor = new AllgemeinerName();
        vornameBauvor.setName("Snow");
        vornameBauvor.setNichtVorhanden(false);
        natuerlichePerson1.setVorname(vornameBauvor);
        natuerlichePerson1.setFamilienname(familynameBauvor);
        natuerlichePerson1.setTitel("Prof");
        natuerlichePerson1.setAnrede("Herr");
        bauBeteiligtePerson.setId("Bauvorhaben");
        bauBeteiligtePerson.setIstVertreter(false);
        bauBeteiligtePerson.setName(natuerlichePerson1);
        bauBeteiligtePerson.setAnschrift(anschrift);
        /*try {

            JAXBContext jaxb = JAXBContext.newInstance(de.xleitstelle.xbau.kernmodul._1._2.Anschrift.class);
            Marshaller mar = jaxb.createMarshaller();
            mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            JAXBElement<Anschrift> objEle = new JAXBElement<Anschrift>(new QName("","Anschrift"), Anschrift.class, anschrift);
            mar.marshal(objEle, System.out);
            mar.marshal(objEle, new File("src/data/Anschrift.xml"));

        } catch (JAXBException e) {
            System.out.println("JAXBException" + e);
        }*/
        //Antragsteller
        try {

            JAXBContext jaxb = JAXBContext.newInstance(AmBauBeteiligtePerson.class);
            Marshaller mar = jaxb.createMarshaller();
            mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            //JAXBElement<NameNatuerlichePerson> objEle = new JAXBElement<NameNatuerlichePerson>(new QName("http://www.xleitstelle.de/xbau/kernmodul/2/2","NatuerlichePerson"), NameNatuerlichePerson.class, natuerlichePerson);
            JAXBElement<AmBauBeteiligtePerson> objElement = new JAXBElement<AmBauBeteiligtePerson>(new QName("http://www.xleitstelle.de/xbau/kernmodul/2/2","beteiligte"), AmBauBeteiligtePerson.class, bauBeteiligtePerson);
            //mar.marshal(natuerlichePerson, System.out);
            mar.marshal(objElement,System.out);
            mar.marshal(objElement, new File("src/data/Anschrift.xml"));

        } catch (JAXBException e) {
            System.out.println("JAXBException" + e);
        }

        /*try {

            JAXBContext jaxbBau = JAXBContext.newInstance(NameNatuerlichePerson.class);
            Marshaller mar = jaxbBau.createMarshaller();
            mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            JAXBElement<NameNatuerlichePerson> objElement = new JAXBElement<NameNatuerlichePerson>(new QName("http://www.xleitstelle.de/xbau/kernmodul/2/2","NatuerlichePerson"), NameNatuerlichePerson.class, natuerlichePerson1);
            mar.marshal(objElement, System.out);
            //mar.marshal(objEle, new File("src/data/Anschrift.xml"));

        } catch (JAXBException e) {
            System.out.println("JAXBException" + e);
        }*/

        net.opengis.gml._3.ObjectFactory objGML = new ObjectFactory();
        net.opengis.gml._3.AbstractCurveType gmlabs = null;

        // net.opengis.gml._3.AbstractCurveType absCurv = objGML.createAbstractCurve(gmlabs);


    }


}
