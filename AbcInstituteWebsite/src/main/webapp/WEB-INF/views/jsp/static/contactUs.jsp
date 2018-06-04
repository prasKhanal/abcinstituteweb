<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

 
  <div class="mainbody" >
  


<table border=0 cellspacing=0 cellpadding=0 width=800px align=center>
  <tr>
    <td>
      <table border=0 cellspacing=0 cellpadding=0 width=540px height=80>
        <tr>
          <td><img border=0 src="resources/images/AOI_web_page_index.jpg" height=80 width=540px></td>
          <td valign="bottom">
              <c:if test="${principleUser ne null }">
           <div class="greeting">
  <form action="<c:url value='j_spring_security_logout' />" method="post"><p>Welcome,<font size="+0.75">${principleUser}</font>
      <input name="Logout" type="submit"
					value="Logout" /></p>
  </form></div>
  </c:if>
          </td>
        </tr>
      </table>
    </td>
  </tr >
  <tr width=750px>
    <td><img border=0 src="resources/images/AOI_web_page_1_3.jpg" height=284 width=750px></td>
  </tr>
  <tr height=220 width=750px>
    <td bgcolor=#ffffff>
      <table border=0 cellspacing=0 cellpadding=0 width=750px >
        <tr>
          <td>
          <div style="width:500px;" class='main_text' align='left'>
<P><FONT style="BACKGROUND-COLOR: #ffffff" color=black></FONT>&nbsp;</P>
<P><FONT style="BACKGROUND-COLOR: #ffffff" color=black><STRONG>E-mail:</STRONG> <A href="mailto:info@aoi.edu.au">info@aoi.edu.au</A> (general enquiries)</P>
<P>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<A href="mailto:admissions@aoi.edu.au">admissions@aoi.edu.au</A>&nbsp;(admission enquiries)</P>
<P><STRONG>Assistance from Trainers:&nbsp;</STRONG></P>
<P>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <A href="mailto:business@aoi.edu.au">business@aoi.edu.au</A> (assistance with Business courses)</P>
<P>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<A href="mailto:it@aoi.edu.au">it@aoi.edu.au</A> (assistance with&nbsp;Information technology courses)&nbsp;</P>
<P>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <A href="mailto:electro@aoi.edu.au">electro@aoi.edu.au</A> (assistance with Electrotechnology course)</P>
<P>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <A href="mailto:esl@aoi.edu.au">esl@aoi.edu.au</A> (assistance with&nbsp;ESL courses)</P>
<P>&nbsp;</P></FONT></div>
            </td>
            <td>
      
<div style="width:250;" class='main_text' align='left'>
<STRONG>Phone Number:</STRONG>
<P><SPAN style="FONT-FAMILY: 'Calibri','sans-serif'; FONT-SIZE: 11pt; mso-fareast-font-family: 'Times New Roman'; mso-fareast-theme-font: minor-fareast; mso-ansi-language: EN-AU; mso-fareast-language: EN-AU; mso-bidi-language: AR-SA; mso-ascii-theme-font: minor-latin; mso-hansi-theme-font: minor-latin; mso-bidi-font-family: 'Times New Roman'; mso-bidi-theme-font: minor-bidi; mso-no-proof: yes"><SPAN style="FONT-FAMILY: 'Calibri','sans-serif'; FONT-SIZE: 11pt; mso-fareast-font-family: 'Times New Roman'; mso-fareast-theme-font: minor-fareast; mso-ansi-language: EN-AU; mso-fareast-language: EN-AU; mso-bidi-language: AR-SA; mso-ascii-theme-font: minor-latin; mso-hansi-theme-font: minor-latin; mso-bidi-font-family: 'Times New Roman'; mso-bidi-theme-font: minor-bidi; mso-no-proof: yes">T: 1300 309 240 (within Australia)</SPAN></SPAN></P>
<P><SPAN style="FONT-FAMILY: 'Calibri','sans-serif'; FONT-SIZE: 11pt; mso-fareast-font-family: 'Times New Roman'; mso-fareast-theme-font: minor-fareast; mso-ansi-language: EN-AU; mso-fareast-language: EN-AU; mso-bidi-language: AR-SA; mso-ascii-theme-font: minor-latin; mso-hansi-theme-font: minor-latin; mso-bidi-font-family: 'Times New Roman'; mso-bidi-theme-font: minor-bidi; mso-no-proof: yes"><SPAN style="FONT-FAMILY: 'Calibri','sans-serif'; FONT-SIZE: 11pt; mso-fareast-font-family: 'Times New Roman'; mso-fareast-theme-font: minor-fareast; mso-ansi-language: EN-AU; mso-fareast-language: EN-AU; mso-bidi-language: AR-SA; mso-ascii-theme-font: minor-latin; mso-hansi-theme-font: minor-latin; mso-bidi-font-family: 'Times New Roman'; mso-bidi-theme-font: minor-bidi; mso-no-proof: yes">T: (+61) 3 9662 1401 (from overseas)</SPAN></SPAN></P>
<P><SPAN style="FONT-FAMILY: 'Calibri','sans-serif'; FONT-SIZE: 11pt; mso-fareast-font-family: 'Times New Roman'; mso-fareast-theme-font: minor-fareast; mso-ansi-language: EN-AU; mso-fareast-language: EN-AU; mso-bidi-language: AR-SA; mso-ascii-theme-font: minor-latin; mso-hansi-theme-font: minor-latin; mso-bidi-font-family: 'Times New Roman'; mso-bidi-theme-font: minor-bidi; mso-no-proof: yes"><SPAN style="FONT-FAMILY: 'Calibri','sans-serif'; FONT-SIZE: 11pt; mso-fareast-font-family: 'Times New Roman'; mso-fareast-theme-font: minor-fareast; mso-ansi-language: EN-AU; mso-fareast-language: EN-AU; mso-bidi-language: AR-SA; mso-ascii-theme-font: minor-latin; mso-hansi-theme-font: minor-latin; mso-bidi-font-family: 'Times New Roman'; mso-bidi-theme-font: minor-bidi; mso-no-proof: yes"><SPAN style="FONT-FAMILY: 'Calibri','sans-serif'; FONT-SIZE: 11pt; mso-fareast-font-family: 'Times New Roman'; mso-fareast-theme-font: minor-fareast; mso-ansi-language: EN-AU; mso-fareast-language: EN-AU; mso-bidi-language: AR-SA; mso-ascii-theme-font: minor-latin; mso-hansi-theme-font: minor-latin; mso-bidi-font-family: 'Times New Roman'; mso-bidi-theme-font: minor-bidi; mso-no-proof: yes">F: (+61) 3 &nbsp;9662 4472</SPAN></SPAN></SPAN></P>
<P><SPAN style="FONT-FAMILY: 'Calibri','sans-serif'; FONT-SIZE: 11pt; mso-fareast-font-family: 'Times New Roman'; mso-fareast-theme-font: minor-fareast; mso-ansi-language: EN-AU; mso-fareast-language: EN-AU; mso-bidi-language: AR-SA; mso-ascii-theme-font: minor-latin; mso-hansi-theme-font: minor-latin; mso-bidi-font-family: 'Times New Roman'; mso-bidi-theme-font: minor-bidi; mso-no-proof: yes"><SPAN style="FONT-FAMILY: 'Calibri','sans-serif'; FONT-SIZE: 11pt; mso-fareast-font-family: 'Times New Roman'; mso-fareast-theme-font: minor-fareast; mso-ansi-language: EN-AU; mso-fareast-language: EN-AU; mso-bidi-language: AR-SA; mso-ascii-theme-font: minor-latin; mso-hansi-theme-font: minor-latin; mso-bidi-font-family: 'Times New Roman'; mso-bidi-theme-font: minor-bidi; mso-no-proof: yes"><SPAN style="FONT-FAMILY: 'Calibri','sans-serif'; FONT-SIZE: 11pt; mso-fareast-font-family: 'Times New Roman'; mso-fareast-theme-font: minor-fareast; mso-ansi-language: EN-AU; mso-fareast-language: EN-AU; mso-bidi-language: AR-SA; mso-ascii-theme-font: minor-latin; mso-hansi-theme-font: minor-latin; mso-bidi-font-family: 'Times New Roman'; mso-bidi-theme-font: minor-bidi; mso-no-proof: yes">Mob: <SPAN style="FONT-FAMILY: 'Calibri','sans-serif'; FONT-SIZE: 11pt; mso-fareast-font-family: 'Times New Roman'; mso-fareast-theme-font: minor-fareast; mso-ansi-language: EN-AU; mso-fareast-language: EN-AU; mso-bidi-language: AR-SA; mso-ascii-theme-font: minor-latin; mso-hansi-theme-font: minor-latin; mso-bidi-font-family: 'Times New Roman'; mso-bidi-theme-font: minor-bidi; mso-no-proof: yes">0424 159 767</SPAN></SPAN></SPAN></SPAN></P>
<P><SPAN style="FONT-FAMILY: 'Calibri','sans-serif'; FONT-SIZE: 11pt; mso-fareast-font-family: 'Times New Roman'; mso-fareast-theme-font: minor-fareast; mso-ansi-language: EN-AU; mso-fareast-language: EN-AU; mso-bidi-language: AR-SA; mso-ascii-theme-font: minor-latin; mso-hansi-theme-font: minor-latin; mso-bidi-font-family: 'Times New Roman'; mso-bidi-theme-font: minor-bidi; mso-no-proof: yes"><SPAN style="FONT-FAMILY: 'Calibri','sans-serif'; FONT-SIZE: 11pt; mso-fareast-font-family: 'Times New Roman'; mso-fareast-theme-font: minor-fareast; mso-ansi-language: EN-AU; mso-fareast-language: EN-AU; mso-bidi-language: AR-SA; mso-ascii-theme-font: minor-latin; mso-hansi-theme-font: minor-latin; mso-bidi-font-family: 'Times New Roman'; mso-bidi-theme-font: minor-bidi; mso-no-proof: yes"><SPAN style="FONT-FAMILY: 'Calibri','sans-serif'; FONT-SIZE: 11pt; mso-fareast-font-family: 'Times New Roman'; mso-fareast-theme-font: minor-fareast; mso-ansi-language: EN-AU; mso-fareast-language: EN-AU; mso-bidi-language: AR-SA; mso-ascii-theme-font: minor-latin; mso-hansi-theme-font: minor-latin; mso-bidi-font-family: 'Times New Roman'; mso-bidi-theme-font: minor-bidi; mso-no-proof: yes"><SPAN style="FONT-FAMILY: 'Calibri','sans-serif'; FONT-SIZE: 11pt; mso-fareast-font-family: 'Times New Roman'; mso-fareast-theme-font: minor-fareast; mso-ansi-language: EN-AU; mso-fareast-language: EN-AU; mso-bidi-language: AR-SA; mso-ascii-theme-font: minor-latin; mso-hansi-theme-font: minor-latin; mso-bidi-font-family: 'Times New Roman'; mso-bidi-theme-font: minor-bidi; mso-no-proof: yes">
</SPAN>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 0430 274 471</SPAN></SPAN></SPAN></P></div>
<P><SPAN style="FONT-FAMILY: 'Calibri','sans-serif'; FONT-SIZE: 11pt; mso-fareast-font-family: 'Times New Roman'; mso-fareast-theme-font: minor-fareast; mso-ansi-language: EN-AU; mso-fareast-language: EN-AU; mso-bidi-language: AR-SA; mso-ascii-theme-font: minor-latin; mso-hansi-theme-font: minor-latin; mso-bidi-font-family: 'Times New Roman'; mso-bidi-theme-font: minor-bidi; mso-no-proof: yes"><SPAN style="FONT-FAMILY: 'Calibri','sans-serif'; FONT-SIZE: 11pt; mso-fareast-font-family: 'Times New Roman'; mso-fareast-theme-font: minor-fareast; mso-ansi-language: EN-AU; mso-fareast-language: EN-AU; mso-bidi-language: AR-SA; mso-ascii-theme-font: minor-latin; mso-hansi-theme-font: minor-latin; mso-bidi-font-family: 'Times New Roman'; mso-bidi-theme-font: minor-bidi; mso-no-proof: yes"><SPAN style="FONT-FAMILY: 'Calibri','sans-serif'; FONT-SIZE: 11pt; mso-fareast-font-family: 'Times New Roman'; mso-fareast-theme-font: minor-fareast; mso-ansi-language: EN-AU; mso-fareast-language: EN-AU; mso-bidi-language: AR-SA; mso-ascii-theme-font: minor-latin; mso-hansi-theme-font: minor-latin; mso-bidi-font-family: 'Times New Roman'; mso-bidi-theme-font: minor-bidi; mso-no-proof: yes"></SPAN></SPAN></SPAN>&nbsp;</P></div>
</td>
        </tr>
      </table>
    </td>
  </tr>
</table>

  
  </div>

 