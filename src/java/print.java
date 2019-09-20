/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.S3Object;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Rohith
 */
@WebServlet(urlPatterns = {"/print"})
public class print extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public static BasicAWSCredentials creds=null; 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        File file = new File("C:\\Users\\Rohith\\Documents\\nanba.txt");
         
        if(file.delete())
        {
            System.out.println("File deleted successfully");
        }
        creds = new BasicAWSCredentials("AKIAJMGJV2N46U6CYYBQ", "zOqOvLicbsaV9+Y/x1igdI8faiaRGVMoidToIGhe");
        String bucketName = "summaorubucket";
        String path="C:\\sample\\semanticweb\\sample.rdf";
      String foldername="summa.txt";
      AmazonS3 s3 = AmazonS3Client.builder().withRegion(Regions.US_EAST_1).withCredentials(new AWSStaticCredentialsProvider(creds)).build();
      S3Object s3object = s3.getObject(bucketName, foldername);
        try (InputStream inputStream = s3object.getObjectContent()) {
            Files.copy(inputStream, Paths.get("C:\\Users\\Rohith\\Documents\\nanba.txt"));
        }
        String fileName = "C:\\Users\\Rohith\\Documents\\nanba.txt";
        String line = null;
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet print</title>"); 
            out.println("<link rel='stylesheet' type='text/css' href='styles.css' />");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1 align='center'>Registered Details</h1>");
            try {
            FileReader fileReader = 
                new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);
            out.println("<table align='center'>");
            out.println("<thead>");
            out.println("<tr>");
            out.println("<th>District</th>");
            out.println("<th>Location</th>");
            out.println("<th>Name</th>");
            out.println("<th>Phone</th>");
            out.println("<th>Items</th>");
            out.println("<th>Date</th>");
            out.println("</tr>");
            out.println("</thead>");
            out.println("<tbody>");
            int i;
            while((line = bufferedReader.readLine()) != null) {
                String[] output = line.split("\\|");
                out.println("<tr>");
                for(i=0;i<output.length;i++)
                {
                    if(!output[i].equals("null")){
                out.println("<td>"+output[i]+"</td>");
                }
                
                }
                out.println("</tr>");
            }   

            // Always close files.
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }
            out.println("<a href=\"/floods/index.html\">Home Page</a>");
            out.println("</body>");
            out.println("</html>");
        }
        
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
