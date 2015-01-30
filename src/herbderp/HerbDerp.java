/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herbderp;

import BO.Productcategory;
import BO.Taxrate;
import Services.ProdCatService;
import Services.ProductService;
import Services.TaxrateService;
import UI.FrmMain;
import java.util.List;

/**
 *
 * @author Temp
 */
public class HerbDerp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TaxrateService ts = new TaxrateService();
        ProductService ps = new ProductService();
        ProdCatService prodcat = new ProdCatService();
        
        
        List<Taxrate> taxrates;
        taxrates = ts.getAllTaxrates();
        
        List<Productcategory> prodcats;
        prodcats = prodcat.getAllCategories();
        
//        List<Product> producten;
//        producten = ps.GetAllProducts();
        
        for (Taxrate tax : taxrates) {
                System.out.println(tax.getTaxrate());
            }
        for (Productcategory prodcat1 : prodcats) {
            System.out.println(prodcat1.getProductcategoryname());
            
        }
        
//        for (Product p : producten) {
//            System.out.println(p.getProductname());
//        }
        
//        FrmLogon loginScreen = new FrmLogon();
//        loginScreen.setVisible(true);
        
        FrmMain mainScreen = new FrmMain();
        mainScreen.setVisible(true);
    }
    
}
