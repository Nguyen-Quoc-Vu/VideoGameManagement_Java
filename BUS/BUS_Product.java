    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BUS;
import DAO.DAO_Product;
import DTO.DTO_Product; 
import java.sql.SQLException;
import java.util.ArrayList; 
public class BUS_Product {

    public static ArrayList<DTO.DTO_Product> array;
    public BUS_Product() throws SQLException, ClassNotFoundException 
    {
        DAO_Product products = new DAO_Product();
        array = products.getAll(); 
    } 
     public void delete(String id) throws SQLException, ClassNotFoundException { 
         DAO_Product products = new DAO_Product();
         products.delete(id);
    } 
     
     public DTO_Product findItem(String id)
     {
         for(DTO_Product product : array)
         {
            if(product.getId().equalsIgnoreCase(id))
                return product;
         }
         return null;
     }
     
     public void add(DTO_Product product) throws SQLException, ClassNotFoundException
     {
             DAO_Product productDAO = new DAO_Product();
             productDAO.add(product);
     }
        
     public void update(DTO_Product product) throws SQLException, ClassNotFoundException
     {
             DAO_Product productDAO = new DAO_Product();
             productDAO.update(product);
     }
     
     public ArrayList<DTO_Product> search(String content) throws ClassNotFoundException, SQLException
     {
         DAO_Product productDAO = new DAO_Product();
         ArrayList<DTO_Product> array = productDAO.search(content);
         return array;     
     }
     
     public ArrayList<DTO_Product> sortBy(String content,Boolean isSelected) throws ClassNotFoundException, SQLException
     {
         DAO_Product productDAO = new DAO_Product();
         ArrayList<DTO_Product> array = productDAO.sortBy(content, isSelected);
         return array;     
     }
     public String getGenreName(String id) throws SQLException, ClassNotFoundException
     {
         DAO_Product productDAO = new DAO_Product();
         return productDAO.getGenreName(id);
     }
     public String getGenreID(String name) throws SQLException, ClassNotFoundException
     {
         DAO_Product productDAO = new DAO_Product();
         return productDAO.getGenreID(name);
     }
}

