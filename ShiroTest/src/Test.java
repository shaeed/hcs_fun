import org.apache.shiro.SecurityUtils;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory; 

public class Test {
	public static void main(String[] args) {
		
		// The easiest way to create a Shiro SecurityManager with configured
        // realms, users, roles and permissions is to use the simple INI config.
        // We'll do that by using a factory that can ingest a .ini file and
        // return a SecurityManager instance:
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
		SecurityManager securityManager = factory.getInstance();
		
        // for this simple example quickstart, make the SecurityManager
        // accessible as a JVM singleton.  Most applications wouldn't do this
        // and instead rely on their container configuration or web.xml for
        // webapps.
		SecurityUtils.setSecurityManager(securityManager);
		
		// Now that a simple Shiro environment is set up
		
		//Get the currently executing Subject (User)
		Subject currentSubject = SecurityUtils.getSubject();
		//Get the Session (Its not a WEB session)
		Session session = currentSubject.getSession();
		
		//Hello
		//Khan
	}
}
