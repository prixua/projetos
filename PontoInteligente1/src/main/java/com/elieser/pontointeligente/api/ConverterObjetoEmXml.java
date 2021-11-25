package com.elieser.pontointeligente.api;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.naming.NoNameCoder;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class ConverterObjetoEmXml {
    public static void main(String[] args) {
        Pessoa p = new Pessoa("Elieser", "Prichua");
        System.out.println(XStreamBuilder.construirXML(p));
    }

}

class Pessoa {
    String primeiro_nome;
    String sobrenome;

    Pessoa(String nome, String sobrenome) {
        this.primeiro_nome = nome;
        this.sobrenome = sobrenome;
    }
}

class XStreamBuilder {
    static final String ENCODING = "UTF_8";

    public static String construirXML(Object object) {
        XStream xStream = new XStream(new DomDriver(ENCODING, new NoNameCoder()));
        return xStream.toXML(object);
    }
}

