package com.example.service;

import org.apache.olingo.odata2.jpa.processor.api.ODataJPAContext;
import org.apache.olingo.odata2.jpa.processor.api.ODataJPAServiceFactory;
import org.apache.olingo.odata2.jpa.processor.api.exception.ODataJPARuntimeException;
import org.apache.olingo.odata2.jpa.processor.ref.factory.JPAEntityManagerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by charles on 7/7/16.
 */
public class MyODataJPAServiceFactory extends ODataJPAServiceFactory {

    private static final Logger logger = LoggerFactory.getLogger(MyODataJPAServiceFactory.class);

    private static final String PUNIT_NAME = "ESPM";

    @Override
    public ODataJPAContext initializeODataJPAContext() throws ODataJPARuntimeException {
        ODataJPAContext ctx = getODataJPAContext();
        EntityManagerFactory emf = JPAEntityManagerFactory.getEntityManagerFactory(PUNIT_NAME);
        ctx.setEntityManagerFactory(emf);
        ctx.setPersistenceUnitName(PUNIT_NAME);
        return ctx;
    }
}
