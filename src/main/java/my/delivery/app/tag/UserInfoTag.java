package my.delivery.app.tag;

import org.apache.log4j.Logger;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class UserInfoTag extends TagSupport {
    public static Logger consLogger = Logger.getLogger("CONS");
    private String firstName;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public int doStartTag() throws JspTagException {

        try {
            pageContext.getOut().write("Hello " + firstName);
        } catch (IOException e) {
            consLogger.error(e);
            throw new JspTagException(e);
        }
        return SKIP_BODY;
    }
}