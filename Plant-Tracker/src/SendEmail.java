import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.swing.JOptionPane;
import javax.activation.*;
 
 
public class SendEmail
{
 
   public static void main(String [] args)
   {   
	   	String username = "kieranbeirne01@gmail.com";
	    String password = "KBAggie!24";
	    String recipient = "kieranbeirne01@gmail.com";

	    Properties props = new Properties();

	    props.put("mail.smtp.host", "smtp.gmail.com");
	    props.put("mail.from", "myemail@gmail.com");
	    props.put("mail.smtp.starttls.enable", "true");
	    props.put("mail.smtp.port", "587");
	    props.setProperty("mail.debug", "true");

	    Session session = Session.getInstance(props, null);
	    MimeMessage msg = new MimeMessage(session);

	    try {
			msg.setRecipients(Message.RecipientType.TO, recipient);
			msg.setSubject("JavaMail hello world example");
		    msg.setSentDate(new Date());
		    msg.setText("Hello, world!\n");

		    Transport transport = session.getTransport("smtp");

		    transport.connect(username, password, recipient);
		    transport.sendMessage(msg, msg.getAllRecipients());
		    transport.close();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
   }
}