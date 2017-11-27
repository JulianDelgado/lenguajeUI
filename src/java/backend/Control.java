package backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JULIAN
 */
public class Control extends HttpServlet {  
    
    private ArrayList<String[]> cadenaConfiguracion;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Página de respuesta</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Código para Tech and Solve</h1>");
                        
            if(request.getParameter("idForm").equals("0")){    
                String clave = request.getParameter("clave");
                String valorInicial = request.getParameter("valorInicial");
                String valorFinal = request.getParameter("valorFinal");                
                
                if(agregarConversion(clave, valorInicial, valorFinal)){                    
                    out.println("<h2>"+"Extensión del lenguaje almacenada exitosamente"+"</h2>");
                    
                }else{
                    out.println("<h2>"+"No se ha podido almacenar la Extensión del lenguaje"+"</h2>");
                }
            }else if(request.getParameter("idForm").equals("1")){                
                String cadena = request.getParameter("cadena");                
                out.println(imprimirHtml(cadena));                
            }else{                
                out.println("<h2>"+"Opción seleccionada invalida"+"</h2>");
            }
            
            out.println("<button type=\"button\" onclick=\"alert('Hello world!')\">Volver</button>");
            out.println("</body>");
            out.println("</html>");
            
        }
    }
    
    public Control() {
        String[] nuevaConfiguracion = new String[3];
        cadenaConfiguracion = new ArrayList();
        
        nuevaConfiguracion[0] = "# ";
        nuevaConfiguracion[1] = "<h1>";
        nuevaConfiguracion[2] = "</h1>";
        cadenaConfiguracion.add(nuevaConfiguracion);

        nuevaConfiguracion = new String[3];
        nuevaConfiguracion[0] = "## ";
        nuevaConfiguracion[1] = "<h2>";
        nuevaConfiguracion[2] = "</h2>";
        cadenaConfiguracion.add(nuevaConfiguracion);

        nuevaConfiguracion = new String[3];
        nuevaConfiguracion[0] = "### ";
        nuevaConfiguracion[1] = "<h3>";
        nuevaConfiguracion[2] = "</h3>";
        cadenaConfiguracion.add(nuevaConfiguracion);

        nuevaConfiguracion = new String[3];
        nuevaConfiguracion[0] = "#### ";
        nuevaConfiguracion[1] = "<h4>";
        nuevaConfiguracion[2] = "</h4>";
        cadenaConfiguracion.add(nuevaConfiguracion);

        nuevaConfiguracion = new String[3];
        nuevaConfiguracion[0] = "##### ";
        nuevaConfiguracion[1] = "<h5>";
        nuevaConfiguracion[2] = "</h5>";
        cadenaConfiguracion.add(nuevaConfiguracion);

        nuevaConfiguracion = new String[3];
        nuevaConfiguracion[0] = "###### ";
        nuevaConfiguracion[1] = "<h6>";
        nuevaConfiguracion[2] = "</h6>";
        cadenaConfiguracion.add(nuevaConfiguracion);
    }

    public boolean agregarConversion(String clave, String valorInicial, String valorFinal) {        
        try {
            String[] nuevaConfiguracion = new String[3];
            nuevaConfiguracion[0] = clave;
            nuevaConfiguracion[1] = valorInicial;
            nuevaConfiguracion[2] = valorFinal;
            this.cadenaConfiguracion.add(nuevaConfiguracion);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    public String imprimirHtml(String cadena){
        String[] arrayTemporal = new String[3];       
        String clave = cadena.substring(0, cadena.indexOf(" ")+" ".length());
        String valor = cadena.substring(cadena.indexOf(" ")+" ".length(), cadena.length());
        System.out.println("Clave: "+clave);
        System.out.println("Valor: "+valor);
        String salida= null;
        
        for(int i=0; this.cadenaConfiguracion.size() > i ;i++){
            arrayTemporal = this.cadenaConfiguracion.get(i);
            if(arrayTemporal[0].equals(clave)){
                salida = arrayTemporal[1]+valor+arrayTemporal[2];
                continue;
            }
        } 
        if(salida == null){
            salida = cadena;
        }
        return salida;
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
