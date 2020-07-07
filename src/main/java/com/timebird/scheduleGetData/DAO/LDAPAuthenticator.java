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
    private LDAPConnector connector;
    @Autowired
    private Environment environment;


    public AuthenObj<String> authenticate(String username, String password){
        DirContext context=null;
        DirContext userContext=null;
        boolean isFailed=false;
        String errorText="";
        try {
            userContext=connector.getConnection(username, password);
        }catch (AuthenticationNotSupportedException ex) {
            System.out.println("a");
            isFailed=true;
            errorText="The authentication is not supported by the server";
        } catch (AuthenticationException ex) {
            System.out.println("b");
            isFailed=true;
            errorText="incorrect password or username";
        } catch (NamingException ex) {
            System.out.println("c");
            isFailed=true;
            errorText="error when trying to create the context";
        }
        finally {
            try {
                if(userContext!=null){
                    userContext.close();
                }
            } catch (NamingException e) {
                e.printStackTrace();
            }
        }
        try {
            context = connector.getConnection(environment.getProperty("ldap.username"),
                    environment.getProperty("ldap.password"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                if(context!=null){
                    context.close();
                }
            } catch (NamingException e) {
                e.printStackTrace();
            }
        }
        if(isFailed){
            return new AuthenObj<String>(false, errorText);
        }
        else{
            return new AuthenObj<String>(true, username);
        }
    }
}
