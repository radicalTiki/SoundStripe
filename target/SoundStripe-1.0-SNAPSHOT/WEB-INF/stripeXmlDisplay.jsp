<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="stripes" uri="http://stripes.sourceforge.net/stripes.tld"%>

<!--
stripe xml to display.. basically beginning the parsing process of stripe xml
files and statically displaying

@Author Matt Gleason
-->

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head><title>SoundStripe</title></head>
<body>
<h1>SoundStripe</h1>

Show me the money.
</br>
</br>
 
<stripes:form beanclass="com.soundstripe.SoundStripeXmlReader" focus="">
    <table>
        <tr>
            <td>Book: </td>
            <td><stripes:text name="bookName"></stripes:text></td>
        </tr>
        <tr>
            <td>Author: </td>
            <td><stripes:text name="bookAuthor"></stripes:text></td>
        </tr>
        <tr>
            <td>Cover: </td>
            <td><img width="150" height="150" src="${actionBean.bookImage}"/></td>
        </tr>
        <tr>
            <td>Songs: </td>
            <td><iframe src="https://embed.spotify.com/?uri=spotify:trackset:${actionBean.playlistName}:${actionBean.songs}" frameborder="0" allowtransparency="true"></iframe></td>
        </tr>
        <tr>
            <td colspan="2">
                <stripes:submit name="back" value="Back"/>
            </td>
        </tr>
    </table>
</stripes:form>
</body>
</html>