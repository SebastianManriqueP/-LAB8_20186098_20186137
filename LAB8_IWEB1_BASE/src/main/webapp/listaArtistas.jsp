<%@ page import="Beans.Artista" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean type="java.util.ArrayList<Beans.Artista>" scope="request" id="listaArtistas"/>
<html>
    <jsp:include page="/static/head.jsp">
        <jsp:param name="title" value="Lista de Artistas"/>
    </jsp:include>
    <body>
        <div class='container'>
            <jsp:include page="/includes/navbar.jsp">
                <jsp:param name="page" value="artistas"/>
            </jsp:include>
            <div class="pb-5 pt-4 px-3 titlecolor">
                <div class="col-lg-6">
                    <h1 class='text-light'>Lista de Artistas</h1>
                </div>
            </div>
            <div class="tabla">
                <table class="table table-dark table-transparent table-hover">
                    <thead>
                        <th>ID</th>
                        <th>NOMBRE</th>
                        <th>BANDA</th>
                        <th>INSTRUMENTO</th>
                    </thead>
                    <%
                        for (Artista artista : listaArtistas) {
                    %>
                    <tr>
                        <td><%=artista.getIdArtista()%>
                        </td>
                        <td><%=artista.getNombre_artista()%>
                        </td>
                        <td><%=artista.getIdbanda()%>
                        </td>
                        <td><%=artista.getIdInstrumento()%>
                        </td>
                    </tr>
                    <%
                        }
                    %>
                </table>
            </div>

        </div>
        <jsp:include page="/static/scripts.jsp"/>
    </body>
</html>
