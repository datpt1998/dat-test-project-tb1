package com.timebird.scheduleGetData.Connector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import java.util.Hashtable;

@Component
@PropertySource("classpath:application.properties")
public class LDAPConnector {

    @Autowired
    private Environment environment;

    public DirContext getConnection(String username, String password) throws NamingException {
        String connectionString="ldap://%s:%s";
        Hashtable env = new Hashtable();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, String.format(connectionString,
                environment.getProperty("ldap.host"),
                environment.getProperty("ldap.port")));
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_PRINCIPAL, environment.getProperty("ldap.username"));
        env.put(Context.SECURITY_CREDENTIALS, environment.getProperty("ldap.password"));
        return new InitialDirContext(env);
    }
}
