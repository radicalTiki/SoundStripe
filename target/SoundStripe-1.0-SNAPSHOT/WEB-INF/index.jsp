<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="stripes" uri="http://stripes.sourceforge.net/stripes.tld"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head><title>SoundStripe</title></head>
<body>
<h1>SoundStripe</h1>
 
Type in what percentage of the book has been read. This will be sent to spotify
with the static playlist maps.
</br>
</br>
 
<stripes:form beanclass="com.soundstripe.SoundStripeXmlReader" focus="">
    <table>
        <tr>
            <td>Percentage of book:</td>
            <td><stripes:text name="bookPerc">10</stripes:text></td>
        </tr>
        <tr>
            <td colspan="2">
                <stripes:submit name="spotify" value="Send"/>
            </td>
        </tr>
    </table>
</stripes:form>
</body>
</html>