package com.timebird.scheduleGetData.DAO;

import com.timebird.scheduleGetData.Connector.LDAPConnector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;

import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

@Repository
@PropertySource("classpath:application.properties")
public class testLDAP {

    @Autowired
    private LDAPConnector connector;
    @Autowired
    private Environment environment;

    public void test(){
        DirContext ctx=null;
        try {
            ctx= connector.getConnection(environment.getProperty("ldap.username"),
                    environment.getProperty("ldap.password"));
            SearchControls searchControls=new SearchControls();
            searchControls.setSearchScope(SearchControls.SUBTREE_SCOPE);
            NamingEnumeration<SearchResult> answer=ctx.search("ou=employee,dc=timebird,dc=org", "mail=timesheet@timebird.org", searchControls);
            while(answer.hasMore()){
                SearchResult result=answer.next();
                System.out.println(result.getAttributes().get("name").toString());
            }
            ctx.close();
            } catch (NamingException e) {
            e.printStackTrace();
        }
    }
}
