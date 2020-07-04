package com.timebird.scheduleGetData.DAO;

import com.timebird.scheduleGetData.Connector.LDAPConnector;
import com.timebird.scheduleGetData.helper.AuthenObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;

import javax.naming.AuthenticationException;
import javax.naming.AuthenticationNotSupportedException;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;

@Repository
@PropertySource("classpath:application.properties")
public class LDAPAuthenticator {
    @Autowired
    private Environment environment;
    @Autowired
    private LDAPConnector connector;
    public AuthenObj authenticate(String username, String password){
        DirContext context;
        try {
            context = connector.getConnection(environment.getProperty("ldap.username"),
                    environment.getProperty("ldap.password"));
            connector.getConnection(username, password);
            return new AuthenObj(true, username);

        }catch (AuthenticationNotSupportedException ex) {
            return new AuthenObj(false,"The authentication is not supported by the server");
        } catch (AuthenticationException ex) {
            return new AuthenObj(false,"incorrect password or username");
        } catch (NamingException ex) {
            return new AuthenObj(false,"error when trying to create the context");
        }
    }
}
