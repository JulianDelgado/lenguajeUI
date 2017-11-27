<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Julian</h1>
        <form action="control" method="post">
            <h2>Nueva extensión del lenguaje</h2>
            <input type="hidden" name="idForm" value="0"/>
            <table>            
            <tr>
                <td>
                    <label>Clave, recuerde incluir espacios</label>
                </td>
                <td>
                    <input type="text" name="clave" />        
                </td>
            
            </tr>
            
            <tr>
                <td>
                    <label>Etiqueta html de apertura, ejemplo &lt;h1&gt;</label>
                    
                </td>
                <td>
                    <input type="text" name="valorInicial" />
                </td>
            </tr>
            
            <tr>
                <td>
                    <label>Etiqueta html de cierre, ejemplo &lt;/h1&gt;</label>
                </td>
                <td>
                    <input type="text" name="valorFinal" />
                </td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="Enviar"/>      
                </td>
            </tr>
            
            </table>
        </form>
        <br/>
        <form action="control" method="post">
            <h2>Imprimir texto HTML</h2>
            <input type="hidden" name="idForm" value="1"/>
            <table>
                <tr>
                <td>
                    <label>Valor a convertir</label>
                </td>
                <td>
                    <input type="text" name="cadena" >            
                </td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="Enviar"/>      
                </td>
            </tr>
            </table>
        </form>
    </body>
</html>
