/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package antique.system;

/**
 *
 * @author Lapcom Store
 */
import java.sql.*;
import javax.swing.JOptionPane;

public class Database {
    
        double price ;
	private Connection conn = null;
	private Statement stmt = null;
	private PreparedStatement pstmt;
	private ResultSet rs = null;
	
	public Connection connect() {
		try {
	           Class.forName("org.sqlite.JDBC");
		   conn=DriverManager.getConnection("jdbc:sqlite:C:/Users/Lapcom Store/Documents/NetBeansProjects/Antique System/antiqueDatabase.sql");
	        //   JOptionPane.showMessageDialog(null, "connection to database was successfully established ");
                 //  this.createTable();
                  // this.insertTable();
		}catch(ClassNotFoundException e) {
	           JOptionPane.showMessageDialog(null, "class not found exception error found in connecting to db");
		}catch(SQLException c) {
		   JOptionPane.showMessageDialog(null, "sql exception error found in connecting to db");
		   java.lang.System.out.println(c.getMessage());
		}catch(Exception e) {
		  JOptionPane.showMessageDialog(null,  "Exception error found in connecting to db");
		}
		return null;
	}
 /////-----------------------------------------------------------------
    
 /////-------------------------------------------------------------
        public double getPrice(String name) throws SQLException{	
            try {
    	        this.connect();
                String sql = "select price from prices where name = ? ";
                PreparedStatement pstmt=conn.prepareStatement(sql);  
                pstmt.setString(1,name);//1 specifies the first parameter in the query  
    		rs = ((java.sql.PreparedStatement) pstmt).executeQuery();
              //  JOptionPane.showMessageDialog(null, "get price established");
                
                 if (rs.next() == false) {
                     System.out.println("ResultSet in empty in Java");
                 } else {

                 do {
                    this.setVar(rs.getDouble("price"));
                    // System.out.println(price);
                    // System.out.println("theees is my priiiiiiiiice"+price);
                   //  JOptionPane.showMessageDialog(null, "entered while");
                 } while (rs.next());
                 }
               // return rs.wasNull() ? null : price;
    	} catch (SQLException e) {
    		JOptionPane.showMessageDialog(null, "sql exception foundin getPrice");
                System.out.println(e);
                e.printStackTrace();
        }catch(Exception e) {
    	        JOptionPane.showMessageDialog(null, "Exception error found in getPrice");
                System.out.println(e);
                e.printStackTrace();
        }
          // System.out.println("i'm before price");
           return price;
      }
     
        
  ///------------------------------------------------------------------------
       public void setPrice(double price, String name ) {
		String sql = "update prices set price='"+price+"' where name = '"+name+"'";
	try {
		this.connect();
		stmt = (Statement) conn.createStatement();
		((java.sql.Statement) stmt).executeUpdate(sql);
		JOptionPane.showMessageDialog(null, "تم تغيير السعر بنجاح");
                
	} catch (SQLException e) {
		JOptionPane.showMessageDialog(null, "sql exception found in updatePrice");
                e.printStackTrace();
        }catch(Exception e) {
	        JOptionPane.showMessageDialog(null, "Exception error found in updatePrice");
                e.printStackTrace();
        }	
		
	}  
             
    


 ////------------------------------------------------------------
       public void setVar(Double val){
     //  System.out.println("i'm here insede setVar");
       this.price = val;
      // System.out.println("his is getVar price"+this.price );
       }
       
       public Double getVar(){
       return this.price;
       }
       
 ///-------------------------------------------------------------
   /*     public void insertTable(){
       String sql = "INSERT INTO prices (name,price)\n" +
"VALUES (\"Banana\",28.00),\n" +
"       (\"Strawberry\",28.00),\n" +
"       (\"Cantaloup\",28.00),\n" +
"       (\"Guava\",28.00),\n" +
"       (\"PineApple\",28.00),\n" +
"       (\"Peach\",28.00),\n" +
"       (\"WaterMelon\",28.00),\n" +
"       (\"Kiwi\",28.00) ,\n" +
"       (\"StrawberryMS\",25.00),\n" +
"       (\"VanillaMS\",25.00),\n" +
"       (\"MangoMS\",25.00),\n" +
"       (\"ChocolateMS\",25.00),\n" +
"       (\"PineAppleMS\",25.00),\n" +
"       (\"PeachMS\",25.00),\n" +
"       (\"EspressoS\",17.00),\n" +
"       (\"EspressoD\",21.00),\n" +
"       (\"Cappuccino\",17.00),\n" +
"       (\"IreshCappuccino\",20.00),\n" +
"       (\"VanillaCappuccino\",20.00),\n" +
"       (\"CaffeeLate\",20.00),\n" +
"       (\"CaramelLattee\",20.00),\n" +
"       (\"IrishLattee\",20.00),\n" +
"       (\"VanillaLattee\",20.00),\n" +
"       (\"ChocolateCoffee\",20.00),\n" +
"       (\"AlmondsCoffee\",20.00),\n" +
"       (\"HazelNutCoffee\",20.00),\n" +
"       (\"Macchiato\",22.00),\n" +
"       (\"CoffeeAmericano\",20.00),\n" +
"       (\"CoffeeMocha\",22.00),\n" +
"       (\"TurkishCoffeeS\",11.00),\n" +
"       (\"TurkishCoffeeD\",15.00),\n" +
"       (\"Tea\",9.00),\n" +
"       (\"FruiteTea\",12.00),\n" +
"       (\"AMCR\",12.00),\n" +
"       (\"Sahlab\",15.00),\n" +
"       (\"SahlabFruit\",22.00),\n" +
"       (\"HotSpider\",20.00),\n" +
"       (\"ColdChocolate\",20.00),\n" +
"       (\"IceEspresso\",20.00),\n" +
"       (\"IceMocha\",20.00),\n" +
"       (\"ClassicLemon\",18.00),\n" +
"       (\"HoneyYoughurt\",20.00),\n" +
"       (\"BlendedYoughart\",23.00),\n" +
"       (\"Borio\",24.00),\n" +
"       (\"Pepsi\",13.00),\n" +
"       (\"Fayrouz\",16.00),\n" +
"       (\"Birrel\",16.00),\n" +
"       (\"Water\",4.00),\n" +
"       (\"CheeseLover\",35.00),\n" +
"       (\"OreoMadness\",35.00),\n" +
"       (\"FruitSalad\",25.00),\n" +
"       (\"FruitSaladIceCream\",35.00),\n" +
"       (\"ChocolateMousse\",30.00),\n" +
"       (\"RichChocolateCake\",30.00),\n" +
"       (\"ChocolateCake\",30.00),\n" +
"       (\"BananaSplit\",28.00),\n" +
"       (\"OreoIceCream\",28.00),\n" +
"       (\"FruiteIceCream\",25.00),\n" +
"       (\"IceCreamScoopes\",25.00),\n" +
"       (\"LemonMint\",22.00),\n" +
"       (\"YourCocktail\",27.00),\n" +
"       (\"GreenSky\",25.00),\n" +
"       (\"ClassicBiano\",23.00),\n" +
"       (\"Florida\",23.00),\n" +
"       (\"Paradise\",23.00),\n" +
"       (\"FruitZoom\",23.00),\n" +
"       (\"SunShine\",22.00),\n" +
"       (\"FruitYoughurt\",23.00),\n" +
"       (\"BlueHawaii\",23.00),\n" +
"       (\"PeachPineApple\",25.00),\n" +
"       (\"Tropicana\",25.00),\n" +
"       (\"StrawBanana\",23.00),\n" +
"       (\"Power\",25.00),\n" +
"       (\"SunShineOrange\",23.00),\n" +
"       (\"TodeIce\",25.00),\n" +
"       (\"Twinkies\",25.00),\n" +
"       (\"Hohos\",25.00),\n" +
"       (\"Snickers\",25.00),\n" +
"       (\"BorioBanana\",25.00),\n" +
"       (\"Weafer\",25.00),\n" +
"       (\"StrawberryEnergy\",23.00),\n" +
"       (\"BananaCaramel\",25.00),\n" +
"       (\"PeachAppleDelight\",25.00),\n" +
"       (\"CherryCoke\",22.00),\n" +
"       (\"OrangeFresh\",19.00),\n" +
"       (\"LemonFresh\",18.00),\n" +
"       (\"MangoFresh\",22.00),\n" +
"       (\"StrawberryFresh\",19.00),\n" +
"       (\"GuavaFresh\",19.00),\n" +
"       (\"WaterMelonFresh\",20.00),\n" +
"       (\"KiwiFresh\",20.00),\n" +
"       (\"PinappleFresh\",20.00),\n" +
"       (\"CantaloupeFresh\",20.00),\n" +
"       (\"BananaFresh\",19.00),\n" +
"       (\"PomegranateFresh\",20.00),\n" +
"       (\"PeachFresh\",20.00),\n" +
"       (\"Topacco\",7.00),\n" +
"       (\"Fakher\",19.00),\n" +
"       (\"RedBull\",23.00),\n" +
"       (\"Mix\",21.00),\n" +
"       (\"Hose\",3.00),\n" +
"       (\"CheeseShisha\",25.00),\n" +
"       (\"Champagn\",25.00),\n" +
"       (\"single\", 25.00),\n" +
"       (\"multi\", 30.00);\n" +
"    \n" +
" ";
         try {
		stmt = (Statement) conn.createStatement();
		((java.sql.Statement) stmt).execute(sql);
		JOptionPane.showMessageDialog(null, "table inserted successfully");
	} catch (SQLException e) {
		JOptionPane.showMessageDialog(null, "sql exception found in insertTable");
                e.printStackTrace();
        }catch(Exception e) {
	        JOptionPane.showMessageDialog(null, "Exception error found in insertTable");
        }	

        }
        */
}