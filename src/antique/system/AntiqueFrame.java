/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package antique.system;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Thread.sleep;
import java.util.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.*;
import javax.swing.text.Highlighter.HighlightPainter;


/**
 *
 * @author Lapcom Store
 */
public class AntiqueFrame extends javax.swing.JFrame implements ActionListener{

    /**
     * Creates new form AntiqueFrame
     */
    Color cGray = new Color(240,240,240);
    Double totalReciept = 0.00;
    Double todayTotal = 0.00;
    JButton ChangePriceBtn;
    boolean flag = false;
    HashMap<String,Integer> InventoryMap =new HashMap<String,Integer>();
    HashMap<String,Integer> RecieptInventoryMap =new HashMap<String,Integer>();
    HashMap<String,String> ChangePriceMap =new HashMap<String,String>();
    HashMap<String,String> NameMap =new HashMap<String,String>();
    ArrayList<JComboBox> comboboxes = new ArrayList<JComboBox>();
    
    
    
    //playstation btns ----------------------------------------------

    
    //smothie btns ----------------------------------------------
    public AntiqueFrame() {
        initComponents();

                       
            CocktailBtn.setBackground(cGray);
            ColdDrinksBtn.setBackground(cGray);
            DessertBtn.setBackground(cGray);
            FreshBtn.setBackground(cGray);
            HotCoffeeBtn.setBackground(cGray);
            HotDrinksBtn.setBackground(cGray);
            MilkShakeBtn.setBackground(cGray);
            PlayStationBtn.setBackground(cGray);
            ShishaBtn.setBackground(cGray);
            SmothieBtn.setBackground(cGray);
            BackBtn.setBackground(Color.red);    
            clock();
            
            ChangePriceMap.put("سموذي موز","Banana");
            ChangePriceMap.put("سموذي فراولــة","Strawberry");
            ChangePriceMap.put("سموذي كانتالوب","Cantaloup");
            ChangePriceMap.put("سموذي جوافة","Guava");
            ChangePriceMap.put("سموذي أناناس","PineApple");
            ChangePriceMap.put("سموذي خوخ","Peach");
            ChangePriceMap.put("سموذي بطيــخ" ,"WaterMelon");
            ChangePriceMap.put("سموذي كيوــي","Kiwi");
           // ----------------------------
            ChangePriceMap.put("ميلك شيك فراولــة","StrawberryMS");
            ChangePriceMap.put("ميلك شيك فانيليا","VanillaMS");
            ChangePriceMap.put("ميلك شيك مانـجو","MangoMS");
            ChangePriceMap.put("ميلك شيك شوكولاتــة","ChocolateMS");
            ChangePriceMap.put("ميلك شيك أناناس","PineAppleMS");
            ChangePriceMap.put("ميلك شيك خــوخ","PeachMS");
           // ----------------------------
            
            ChangePriceMap.put("إسبريســو سينجل","EspressoS");
            ChangePriceMap.put("إسبريســو دبل","EspressoD");
            ChangePriceMap.put("كابوتشينو","Cappuccino");
            ChangePriceMap.put("أيريش كابوتشينو","IreshCappuccino");
            ChangePriceMap.put("فانيليا كابوتشينو","VanillaCappuccino");
            ChangePriceMap.put("كافيه لاتيــه","CaffeeLate");
            ChangePriceMap.put("كاراميل لاتيـه" ,"CaramelLattee");
            ChangePriceMap.put("أيريش لاتيـه" ,"IrishLattee");
            ChangePriceMap.put("فانيليا لاتيــه","VanillaLattee");
            ChangePriceMap.put("قهوة شوكولاتة","ChocolateCoffee");
            ChangePriceMap.put("قهوة بندق","HazelNutCoffee");
            ChangePriceMap.put("كابوتشينو","Cappuccino");
            ChangePriceMap.put("قهوة لــوز","AlmondsCoffee");
            ChangePriceMap.put("ماكياتــو","Macchiato");
            ChangePriceMap.put("أميريكان كوفي","CoffeeAmericano");
            ChangePriceMap.put("موكا كافية" ,"CoffeeMocha");
            ChangePriceMap.put("قهوة تركي سينجل" ,"TurkishCoffeeS");
            ChangePriceMap.put("قهوة تركي دبل","TurkishCoffeeD");
         //------------------------------------------------------------    
            ChangePriceMap.put("شـــاي","Tea");
            ChangePriceMap.put("شــاي فواكه","FruiteTea");
            ChangePriceMap.put("ينسون/نعناع/قرفة/كركديه","AMCR");
            ChangePriceMap.put("سحلــب" ,"Sahlab");
            ChangePriceMap.put("سحـلـب فواكه" ,"SahlabFruit");
            ChangePriceMap.put("هوت سبايدر" ,"HotSpider");
        //-------------------------------------------------------------
            ChangePriceMap.put("شوكولاتة باردة" ,"ColdChocolate");
            ChangePriceMap.put("إسبريسـو+ ثلج","IceEspresso");
            ChangePriceMap.put("أيس موكا","IceMocha");
            ChangePriceMap.put("ليمــون","ClassicLemon");
            ChangePriceMap.put("زبادي عسـل","HoneyYoughurt");
            ChangePriceMap.put("زبادي فواكــه","BlendedYoughart");
            ChangePriceMap.put("بوريــو","Borio");
            ChangePriceMap.put("بيبســـي" ,"Pepsi");
            ChangePriceMap.put("فيـــروز" ,"Fayrouz");
            ChangePriceMap.put("بيريــل" ,"Birrel");
            ChangePriceMap.put("ميــاه","Water");
        //-----------------------------------------------------------------
            ChangePriceMap.put("تشيز لافر","CheeseLover");
            ChangePriceMap.put("أوريو مادنيس","OreoMadness");
            ChangePriceMap.put("فروت سالاد","FruitSalad");
            ChangePriceMap.put("فروت سالاد بالأيس كريم","FruitSaladIceCream");
            ChangePriceMap.put("شوكلت فادج","ChocolateMousse");
            ChangePriceMap.put("ريتش شوكلت كيك" ,"RichChocolateCake");
            ChangePriceMap.put("بانانا سبليت" ,"BananaSplit");
            ChangePriceMap.put("أوريو أيس كريم" ,"OreoIceCream");
            ChangePriceMap.put("أيس كريم فواكه","FruiteIceCream");
            ChangePriceMap.put("أيس كريم بولة","IceCreamScoopes");
        //-------------------------------------------------------------------
            ChangePriceMap.put("ليمون نعنــاع","LemonMint");
            ChangePriceMap.put("إختر كوكتيلك","YourCocktail");
            ChangePriceMap.put("جـريــن سكاي","GreenSky");
            ChangePriceMap.put("كلاسيــك بيانو","ClassicBiano");
            ChangePriceMap.put("فلــوريدا","Florida");
            ChangePriceMap.put("بارادايـس" ,"Paradise");
            ChangePriceMap.put("فروت زوم","FruitZoom");
            ChangePriceMap.put("صن شايـــن","SunShine");
            ChangePriceMap.put("زبادي فواكه","FruitYoughurt");
            ChangePriceMap.put("بلو هاواي","BlueHawaii");
            ChangePriceMap.put("خوخ أناناس","PeachPineApple");
            ChangePriceMap.put("تروبيكانا","Tropicana");
            ChangePriceMap.put("موز فراولــة" ,"StrawBanana");
            ChangePriceMap.put("باور","Power");
            ChangePriceMap.put("صن شايـن برتقال","SunShineOrange");
            ChangePriceMap.put("تودو أيس","TodeIce");
            ChangePriceMap.put("توينكيـز","Twinkies");
            ChangePriceMap.put("هوهــوز","Hohos");
            ChangePriceMap.put("سنيكرز","Snickers");
            ChangePriceMap.put("بوريو موز","BorioBanana");
            ChangePriceMap.put("ويفـــر","Weafer");
            ChangePriceMap.put("ستروبيري إنيرجي","StrawberryEnergy");
            ChangePriceMap.put("موز كراميل","BananaCaramel");
            ChangePriceMap.put("خوخ أناناس","PeachPineApple");
            ChangePriceMap.put("ديلايت تفاح خوخ","PeachAppleDelight");
            ChangePriceMap.put("شيري كـوك","CherryCoke");
        //------------------------------------------------------------    
            ChangePriceMap.put("برتــقال فريش" ,"OrangeFresh");
            ChangePriceMap.put("ليــمون فريش" ,"LemonFresh");
            ChangePriceMap.put("مانجـــو فريش","MangoFresh");
            ChangePriceMap.put("فراولــة فريش","StrawberryFresh");
            ChangePriceMap.put("جــوافة فريش","GuavaFresh");
            ChangePriceMap.put("بطيــخ فريش","WaterMelonFresh");
            ChangePriceMap.put("كيــوي فريش","KiwiFresh");
            ChangePriceMap.put("أناناس فريش","PinappleFresh");
            ChangePriceMap.put("كانتالــوب فريش" ,"CantaloupeFresh");
            ChangePriceMap.put("مــوز فريش" ,"BananaFresh");
            ChangePriceMap.put("رمــان فريش","PomegranateFresh");
            ChangePriceMap.put("خـــوخ فريش","PeachFresh");
        //--------------------------------------------------------------------    
            ChangePriceMap.put("توباكــو","Topacco");
            ChangePriceMap.put("فاخــر","Fakher");
            ChangePriceMap.put("ريد بول","RedBull");
            ChangePriceMap.put("مــيكس","Mix");
            ChangePriceMap.put("لي طبــي","Hose");
            ChangePriceMap.put("تشيز كيك" ,"CheeseShisha");
            ChangePriceMap.put("شامبان" ,"Champagn");
        //-------------------------------------------------------------------- 
            ChangePriceMap.put("بلايستيشن سينجل" ,"single");
            ChangePriceMap.put("بلايستيشن مالتي" ,"multi");
            InvoiceTxtArea.setEditable(false);
           //InvoiceTxtArea.setLineWrap(true);
          //  InvoiceTxtArea.setWrapStyleWord(true);
            
        
    }
    
    
    
    
     public void clock(){
          Thread clockThread = new Thread(){
           public void run(){
          try{
            for(;;){
            Calendar cal = new GregorianCalendar();
            int day = cal.get(Calendar.DAY_OF_MONTH);
            int month = cal.get(Calendar.MONTH);
            int year = cal.get(Calendar.YEAR);

            int second = cal.get(Calendar.SECOND);
            int minute = cal.get(Calendar.MINUTE);
            int hour = cal.get(Calendar.HOUR);
            
            TimeLbl.setText("Time : "+hour+":"+minute+":"+second+" "+"Date : "+day+":"+month+":"+year);
            sleep(1000);
            }
          }catch(Exception e){
               e.printStackTrace();
            }
         }
       };
      clockThread.start();
}
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        SmothieBtn = new javax.swing.JButton();
        HotCoffeeBtn = new javax.swing.JButton();
        HotDrinksBtn = new javax.swing.JButton();
        ColdDrinksBtn = new javax.swing.JButton();
        MilkShakeBtn = new javax.swing.JButton();
        DessertBtn = new javax.swing.JButton();
        CocktailBtn = new javax.swing.JButton();
        FreshBtn = new javax.swing.JButton();
        ShishaBtn = new javax.swing.JButton();
        PlayStationBtn = new javax.swing.JButton();
        MainPanel = new javax.swing.JPanel();
        MainLabel = new javax.swing.JLabel();
        ChangedCategory = new javax.swing.JComboBox();
        chooseCategoryLbl = new javax.swing.JLabel();
        InventoryBtn = new javax.swing.JButton();
        ChangePriceLbl = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        EightBtn = new javax.swing.JButton();
        SevenBtn = new javax.swing.JButton();
        SixBtn = new javax.swing.JButton();
        FiveBtn = new javax.swing.JButton();
        ThreeBtn = new javax.swing.JButton();
        TwoBtn = new javax.swing.JButton();
        FourBtn = new javax.swing.JButton();
        NineBtn = new javax.swing.JButton();
        TenBtn = new javax.swing.JButton();
        OneBtn = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        InvoiceTxtArea = new javax.swing.JTextArea();
        TotalRecieptLbl = new javax.swing.JLabel();
        TimeLbl = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        ResetBtn = new javax.swing.JButton();
        removeOrderBtn = new javax.swing.JButton();
        PrintBtn1 = new javax.swing.JButton();
        BackBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 659, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel4.setText(" Antique cafe management system");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        SmothieBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        SmothieBtn.setText("سمــوذي");
        SmothieBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        SmothieBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SmothieBtnActionPerformed(evt);
            }
        });

        HotCoffeeBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        HotCoffeeBtn.setText("قهوة ساخنة");
        HotCoffeeBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        HotCoffeeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HotCoffeeBtnActionPerformed(evt);
            }
        });

        HotDrinksBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        HotDrinksBtn.setText("مشروبات ساخنة");
        HotDrinksBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        HotDrinksBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HotDrinksBtnActionPerformed(evt);
            }
        });

        ColdDrinksBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ColdDrinksBtn.setText("مشروبات باردة");
        ColdDrinksBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        ColdDrinksBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ColdDrinksBtnActionPerformed(evt);
            }
        });

        MilkShakeBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        MilkShakeBtn.setText("ميلك شيك");
        MilkShakeBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        MilkShakeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MilkShakeBtnActionPerformed(evt);
            }
        });

        DessertBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        DessertBtn.setText("ديزيـــــــــرت");
        DessertBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        DessertBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DessertBtnActionPerformed(evt);
            }
        });

        CocktailBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        CocktailBtn.setText("كوكتــــيل");
        CocktailBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        CocktailBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CocktailBtnActionPerformed(evt);
            }
        });

        FreshBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        FreshBtn.setText("فريــــــش");
        FreshBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        FreshBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FreshBtnActionPerformed(evt);
            }
        });

        ShishaBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ShishaBtn.setText("شيــــــــشة");
        ShishaBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        ShishaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShishaBtnActionPerformed(evt);
            }
        });

        PlayStationBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        PlayStationBtn.setText("بلايستيشن");
        PlayStationBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        PlayStationBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlayStationBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(PlayStationBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ShishaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(FreshBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CocktailBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(DessertBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(MilkShakeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ColdDrinksBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(HotDrinksBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(HotCoffeeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SmothieBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {CocktailBtn, ColdDrinksBtn, DessertBtn, FreshBtn, HotCoffeeBtn, HotDrinksBtn, MilkShakeBtn, PlayStationBtn, ShishaBtn, SmothieBtn});

        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SmothieBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(HotCoffeeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(HotDrinksBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ColdDrinksBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MilkShakeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DessertBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CocktailBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FreshBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ShishaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PlayStationBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {CocktailBtn, ColdDrinksBtn, DessertBtn, FreshBtn, HotCoffeeBtn, HotDrinksBtn, MilkShakeBtn, PlayStationBtn, ShishaBtn, SmothieBtn});

        MainPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        MainLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        MainLabel.setText("TodayTotal : 0.00");

        ChangedCategory.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ChangedCategory.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "سموذي", "قهوة ساخنة", "مشروبات ساخنة", "مشروبات باردة", "ميلك شيك", "ديــزيرت", "كوكتــيل", "فريــــش", "شيشــة", "بلايستيـشن" }));
        ChangedCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChangedCategoryActionPerformed(evt);
            }
        });

        chooseCategoryLbl.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        chooseCategoryLbl.setText("اختر الصنف");

        InventoryBtn.setBackground(new java.awt.Color(255, 51, 51));
        InventoryBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        InventoryBtn.setText("عرض الجــــرد اليـــومي");
        InventoryBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InventoryBtnActionPerformed(evt);
            }
        });

        ChangePriceLbl.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        ChangePriceLbl.setText("تغيير السعر");

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MainPanelLayout.createSequentialGroup()
                        .addComponent(MainLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90)
                        .addComponent(InventoryBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ChangedCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chooseCategoryLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ChangePriceLbl))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        MainPanelLayout.setVerticalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MainPanelLayout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(MainLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainPanelLayout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(InventoryBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(ChangePriceLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chooseCategoryLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ChangedCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        EightBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        EightBtn.setText("8");
        EightBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        EightBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EightBtnActionPerformed(evt);
            }
        });

        SevenBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        SevenBtn.setText("7");
        SevenBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        SevenBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SevenBtnActionPerformed(evt);
            }
        });

        SixBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        SixBtn.setText("6");
        SixBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        SixBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SixBtnActionPerformed(evt);
            }
        });

        FiveBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        FiveBtn.setText("5");
        FiveBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        FiveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FiveBtnActionPerformed(evt);
            }
        });

        ThreeBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ThreeBtn.setText("3");
        ThreeBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        ThreeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThreeBtnActionPerformed(evt);
            }
        });

        TwoBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TwoBtn.setText("2");
        TwoBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        TwoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TwoBtnActionPerformed(evt);
            }
        });

        FourBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        FourBtn.setText("4");
        FourBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        FourBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FourBtnActionPerformed(evt);
            }
        });

        NineBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        NineBtn.setText("9");
        NineBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        NineBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NineBtnActionPerformed(evt);
            }
        });

        TenBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TenBtn.setText("10");
        TenBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        TenBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TenBtnActionPerformed(evt);
            }
        });

        OneBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        OneBtn.setText("1");
        OneBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        OneBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OneBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(OneBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(FiveBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                            .addComponent(EightBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TwoBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(SixBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                            .addComponent(NineBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ThreeBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TenBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                            .addComponent(SevenBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(FourBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EightBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NineBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TenBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FiveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SixBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SevenBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TwoBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ThreeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FourBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(OneBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {FourBtn, ThreeBtn, TwoBtn});

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        InvoiceTxtArea.setColumns(20);
        InvoiceTxtArea.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        InvoiceTxtArea.setRows(5);
        InvoiceTxtArea.setTabSize(9);
        InvoiceTxtArea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                InvoiceTxtAreaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(InvoiceTxtArea);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                .addContainerGap())
        );

        TotalRecieptLbl.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        TotalRecieptLbl.setText("Total Reciept : ");

        TimeLbl.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        ResetBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ResetBtn.setText("إلغاء فاتورة");
        ResetBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        ResetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetBtnActionPerformed(evt);
            }
        });

        removeOrderBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        removeOrderBtn.setText("إزالة");
        removeOrderBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        removeOrderBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeOrderBtnActionPerformed(evt);
            }
        });

        PrintBtn1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        PrintBtn1.setText("طبـــاعة");
        PrintBtn1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        PrintBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrintBtn1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ResetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(removeOrderBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PrintBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {PrintBtn1, ResetBtn, removeOrderBtn});

        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(removeOrderBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ResetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PrintBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel8Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {PrintBtn1, ResetBtn, removeOrderBtn});

        BackBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        BackBtn.setText("العــــــودة");
        BackBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        BackBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(53, 53, 53)
                                .addComponent(TotalRecieptLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(77, 77, 77)
                                .addComponent(BackBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(292, 292, 292)
                                .addComponent(TimeLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(TimeLbl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BackBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TotalRecieptLbl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EightBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EightBtnActionPerformed
        // TODO add your handling code here:
         colorizeBtn(EightBtn);
         
    }//GEN-LAST:event_EightBtnActionPerformed

    private void NineBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NineBtnActionPerformed
        // TODO add your handling code here:
        colorizeBtn(NineBtn);
    }//GEN-LAST:event_NineBtnActionPerformed

    private void TenBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TenBtnActionPerformed
        // TODO add your handling code here:
        colorizeBtn(TenBtn);
    }//GEN-LAST:event_TenBtnActionPerformed

    private void SmothieBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SmothieBtnActionPerformed
        // TODO add your handling code here:
    JButton BananaBtn ;
    JButton StrawberryBtn ;
    JButton CantaloupBtn ;
    JButton GuavaBtn ;
    JButton PineAppleBtn ;
    JButton PeachBtn ;
    JButton WaterMelonBtn ;
    JButton KiwiBtn ;
                   
            CocktailBtn.setBackground(cGray);
            ColdDrinksBtn.setBackground(cGray);
            DessertBtn.setBackground(cGray);
            FreshBtn.setBackground(cGray);
            HotCoffeeBtn.setBackground(cGray);
            HotDrinksBtn.setBackground(cGray);
            MilkShakeBtn.setBackground(cGray);
            PlayStationBtn.setBackground(cGray);
            ShishaBtn.setBackground(cGray);

         
        SmothieBtn.setBackground(Color.red);
        MainPanel.removeAll();
        MainPanel.invalidate();
        MainPanel.setPreferredSize(new Dimension(1132, 121));
         
        BananaBtn = new JButton("مــــوز");
        BananaBtn.setBackground(Color.red);
        BananaBtn.setForeground(Color.black);
        BananaBtn.setFont(new Font("TimesRoman", Font.BOLD , 20));
        BananaBtn.setBounds(130, 20, 130, 50);
        BananaBtn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
                     addToReceipt("Banana","Smoothie Banana");  
                     
             }
           });
        
        MainPanel.add(BananaBtn);
    //-----------------------------------------------------------   
        StrawberryBtn = new JButton("فراولــة");
        StrawberryBtn.setBackground(Color.yellow);
        StrawberryBtn.setForeground(Color.black);
        StrawberryBtn.setFont(new Font("TimesRoman", Font.BOLD , 20));
        StrawberryBtn.setBounds(290, 20, 130, 50);
        StrawberryBtn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
               
             addToReceipt("Strawberry","Smoothie Strawberry");
             
             }
           });
        MainPanel.add(StrawberryBtn);

        
    //------------------------------------------------------------
        CantaloupBtn = new JButton("كانتالوب");
        CantaloupBtn.setBackground(Color.GREEN);
        CantaloupBtn.setForeground(Color.black);
        CantaloupBtn.setFont(new Font("TimesRoman", Font.BOLD , 20));
        CantaloupBtn.setBounds(450, 20, 130, 50);
        CantaloupBtn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
                   addToReceipt("Cantaloup","Smoothie Cantaloup" );
             }
           });
        MainPanel.add(CantaloupBtn);
    //----------------------------------------------------------
        GuavaBtn = new JButton(" جوافة" );
        GuavaBtn.setBackground(Color.cyan);
        GuavaBtn.setForeground(Color.black);
        GuavaBtn.setFont(new Font("TimesRoman", Font.BOLD , 20));
        GuavaBtn.setBounds(610, 20, 130, 50);
        GuavaBtn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
             addToReceipt("Guava","Smoothie Guava");
             }
           });
        MainPanel.add(GuavaBtn);
        
     //--------------------------------------------------------
        PineAppleBtn = new JButton(" أناناس" );
        PineAppleBtn.setBackground(Color.ORANGE);
        PineAppleBtn.setForeground(Color.black);
        PineAppleBtn.setFont(new Font("TimesRoman", Font.BOLD , 20));
        PineAppleBtn.setBounds(130, 120, 130, 50);
        PineAppleBtn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
            addToReceipt("PineApple","Smoothie PineApple");
    
             }
           });
        MainPanel.add(PineAppleBtn);
      //--------------------------------------------------------
        PeachBtn = new JButton(" خوخ" );
        PeachBtn.setBackground(Color.pink);
        PeachBtn.setForeground(Color.black);
        PeachBtn.setFont(new Font("TimesRoman", Font.BOLD , 20));
        PeachBtn.setBounds(290, 120, 130, 50);
        PeachBtn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
            addToReceipt("Peach","Smoothie Peach");
             }
           });
        MainPanel.add(PeachBtn);
      //-----------------------------------------------------
        WaterMelonBtn = new JButton(" بطيــخ" );
        WaterMelonBtn.setBackground(Color.red);
        WaterMelonBtn.setForeground(Color.black);
        WaterMelonBtn.setFont(new Font("TimesRoman", Font.BOLD , 20));
        WaterMelonBtn.setBounds(450, 120, 130, 50);
        WaterMelonBtn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
            addToReceipt("WaterMelon","Smoothie WaterMelon");
             }
           });
        MainPanel.add(WaterMelonBtn);
      //-----------------------------------------------------
     
           KiwiBtn = new JButton(" كيوــي" );
           KiwiBtn.setBackground(Color.blue);
           KiwiBtn.setForeground(Color.black);
           KiwiBtn.setFont(new Font("TimesRoman", Font.BOLD , 20));
           KiwiBtn.setBounds(610, 120, 130, 50);
           KiwiBtn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
             addToReceipt("Kiwi","Smoothie Kiwi");
             }
           });
        MainPanel.add(KiwiBtn);
        //-----------------------------------------------------
       //-----------------------------------------------------
         MainPanel.revalidate(); // to invoke the layout manager
         MainPanel.repaint();
        
    }//GEN-LAST:event_SmothieBtnActionPerformed

    //------------------------------------------------------------------
    //------------------------------------------------------------------
    
    private void MilkShakeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MilkShakeBtnActionPerformed
        // TODO add your handling code here: 
    JButton StrawberryMSBtn ;
    JButton VanillaMSBtn ;
    JButton MangoMSBtn ;
    JButton ChocolateMSBtn ;
    JButton PineAppleMSBtn ;
    JButton PeachMSBtn ;
    
            CocktailBtn.setBackground(cGray);
            ColdDrinksBtn.setBackground(cGray);
            DessertBtn.setBackground(cGray);
            FreshBtn.setBackground(cGray);
            HotCoffeeBtn.setBackground(cGray);
            HotDrinksBtn.setBackground(cGray);
            PlayStationBtn.setBackground(cGray);
            ShishaBtn.setBackground(cGray);
            SmothieBtn.setBackground(cGray);
            
        MilkShakeBtn.setBackground(Color.red);
        MainPanel.removeAll();
        MainPanel.invalidate();
        MainPanel.setPreferredSize(new Dimension(1132, 121));
         
        StrawberryMSBtn = new JButton("فراولــة");
        StrawberryMSBtn.setBackground(Color.red);
        StrawberryMSBtn.setForeground(Color.black);
        StrawberryMSBtn.setFont(new Font("TimesRoman", Font.BOLD , 20));
        StrawberryMSBtn.setBounds(130, 20, 130, 50);
        StrawberryMSBtn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
            addToReceipt("StrawberryMS","Milkshake Strawberry");
             }
           });
        MainPanel.add(StrawberryMSBtn);
    //-----------------------------------------------------------   
        VanillaMSBtn = new JButton("فانيليا");
        VanillaMSBtn.setBackground(Color.yellow);
        VanillaMSBtn.setForeground(Color.black);
        VanillaMSBtn.setFont(new Font("TimesRoman", Font.BOLD , 20));
        VanillaMSBtn.setBounds(290, 20, 130, 50);
        VanillaMSBtn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
            addToReceipt("VanillaMS","Milkshake Vanilla");
             }
           });
        MainPanel.add(VanillaMSBtn);

        
    //------------------------------------------------------------
        MangoMSBtn = new JButton(" مانـجو" );
        MangoMSBtn.setBackground(Color.cyan);
        MangoMSBtn.setForeground(Color.black);
        MangoMSBtn.setFont(new Font("TimesRoman", Font.BOLD , 20));
        MangoMSBtn.setBounds(450, 20, 130, 50);
        MangoMSBtn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
             addToReceipt("MangoMS","Milkshake Mango");   
             }
           });
        MainPanel.add(MangoMSBtn);
        
     //--------------------------------------------------------
        ChocolateMSBtn = new JButton(" شوكولاتــة" );
        ChocolateMSBtn.setBackground(Color.ORANGE);
        ChocolateMSBtn.setForeground(Color.black);
        ChocolateMSBtn.setFont(new Font("TimesRoman", Font.BOLD , 20));
        ChocolateMSBtn.setBounds(130, 120, 130, 50);
        ChocolateMSBtn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
               {
                addToReceipt("ChocolateMS","Milkshake Chocolate");
               }
           });
        MainPanel.add(ChocolateMSBtn);
      //--------------------------------------------------------
        PineAppleMSBtn = new JButton(" أناناس" );
        PineAppleMSBtn.setBackground(Color.pink);
        PineAppleMSBtn.setForeground(Color.black);
        PineAppleMSBtn.setFont(new Font("TimesRoman", Font.BOLD , 20));
        PineAppleMSBtn.setBounds(290, 120, 130, 50);
        PineAppleMSBtn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
              addToReceipt("PineAppleMS","Milkshake PineApple");
             }
           });
        MainPanel.add(PineAppleMSBtn);
      //-----------------------------------------------------
        PeachMSBtn = new JButton(" خــوخ" );
        PeachMSBtn.setBackground(Color.red);
        PeachMSBtn.setForeground(Color.black);
        PeachMSBtn.setFont(new Font("TimesRoman", Font.BOLD , 20));
        PeachMSBtn.setBounds(450, 120, 130, 50);
        PeachMSBtn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
        addToReceipt("PeachMS","Milkshake Peach");
             }
           });
        MainPanel.add(PeachMSBtn);
      //-----------------------------------------------------
        
         MainPanel.revalidate(); // to invoke the layout manager
         MainPanel.repaint();  
    }//GEN-LAST:event_MilkShakeBtnActionPerformed

    private void HotCoffeeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HotCoffeeBtnActionPerformed
        // TODO add your handling code here:
    JButton EspressoSBtn ;
    JButton EspressoDBtn ;
    JButton CappuccinoBtn ;
    JButton IreshCappuccinoBtn ;
    JButton VanillaCappuccinoBtn ;
    JButton CaffeeLateBtn ;
    JButton CaramelLatteeBtn ;
    JButton IrishLatteeBtn ;
    JButton VanillaLatteeBtn ;
    JButton ChocolateCoffeeBtn ;
    JButton AlmondsCoffeeBtn ;
    JButton HazelNutCoffeeBtn ;
    JButton MacchiatoBtn ;
    JButton CoffeeAmericanoBtn ;
    JButton CoffeeMochaBtn ;
    JButton TurkishCoffeeSBtn ;
    JButton TurkishCoffeeDBtn ;
    
            CocktailBtn.setBackground(cGray);
            ColdDrinksBtn.setBackground(cGray);
            DessertBtn.setBackground(cGray);
            FreshBtn.setBackground(cGray);
            SmothieBtn.setBackground(cGray);
            HotDrinksBtn.setBackground(cGray);
            MilkShakeBtn.setBackground(cGray);
            PlayStationBtn.setBackground(cGray);
            ShishaBtn.setBackground(cGray);

         
        HotCoffeeBtn.setBackground(Color.red);
        MainPanel.removeAll();
        MainPanel.invalidate();
        MainPanel.setPreferredSize(new Dimension(1132, 121));
         
        EspressoSBtn = new JButton("إسبريســو سينجل");
        EspressoSBtn.setBackground(Color.red);
        EspressoSBtn.setForeground(Color.black);
        EspressoSBtn.setFont(new Font("TimesRoman", Font.BOLD , 17));
        EspressoSBtn.setBounds(130, 20, 130, 50);
        EspressoSBtn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
            addToReceipt("EspressoS","Espresso Single");    
             }
           });
        MainPanel.add(EspressoSBtn);
    //-----------------------------------------------------------   
        EspressoDBtn = new JButton("إسبريســو دبل");
        EspressoDBtn.setBackground(Color.yellow);
        EspressoDBtn.setForeground(Color.black);
        EspressoDBtn.setFont(new Font("TimesRoman", Font.BOLD , 20));
        EspressoDBtn.setBounds(290, 20, 130, 50);
        EspressoDBtn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
                  addToReceipt("EspressoD","Espresso Double"); 
             }
           });
        MainPanel.add(EspressoDBtn);

    //------------------------------------------------------------
        CappuccinoBtn = new JButton("كابوتشينو");
        CappuccinoBtn.setBackground(Color.GREEN);
        CappuccinoBtn.setForeground(Color.black);
        CappuccinoBtn.setFont(new Font("TimesRoman", Font.BOLD , 20));
        CappuccinoBtn.setBounds(450, 20, 130, 50);
        CappuccinoBtn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
                    addToReceipt("Cappuccino","Cappoccino");
             }
           });
        MainPanel.add(CappuccinoBtn);
    //----------------------------------------------------------
        IreshCappuccinoBtn = new JButton("أيريش كابوتشينو" );
        IreshCappuccinoBtn.setBackground(Color.cyan);
        IreshCappuccinoBtn.setForeground(Color.black);
        IreshCappuccinoBtn.setFont(new Font("TimesRoman", Font.BOLD , 17));
        IreshCappuccinoBtn.setBounds(610, 20, 130, 50);
        IreshCappuccinoBtn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
                   addToReceipt("IreshCappuccino","Iresh Cappuccino");
             }
           });
        MainPanel.add(IreshCappuccinoBtn);
        
     //--------------------------------------------------------
        VanillaCappuccinoBtn = new JButton(" فانيليا كابوتشينو" );
        VanillaCappuccinoBtn.setBackground(Color.ORANGE);
        VanillaCappuccinoBtn.setForeground(Color.black);
        VanillaCappuccinoBtn.setFont(new Font("TimesRoman", Font.BOLD , 17));
        VanillaCappuccinoBtn.setBounds(130, 100, 130, 50);
        VanillaCappuccinoBtn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
                   addToReceipt("VanillaCappuccino","Vanilla Cappuccino");
             }
           });
        MainPanel.add(VanillaCappuccinoBtn);
      //--------------------------------------------------------
        CaffeeLateBtn = new JButton(" كافيه لاتيــه" );
        CaffeeLateBtn.setBackground(Color.pink);
        CaffeeLateBtn.setForeground(Color.black);
        CaffeeLateBtn.setFont(new Font("TimesRoman", Font.BOLD , 20));
        CaffeeLateBtn.setBounds(290, 100, 130, 50);
        CaffeeLateBtn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
                   addToReceipt("CaffeeLate","Caffee Latte");
             }
           });
        MainPanel.add(CaffeeLateBtn);
      //-----------------------------------------------------
        CaramelLatteeBtn = new JButton(" كاراميل لاتيـه" );
        CaramelLatteeBtn.setBackground(Color.red);
        CaramelLatteeBtn.setForeground(Color.black);
        CaramelLatteeBtn.setFont(new Font("TimesRoman", Font.BOLD , 20));
        CaramelLatteeBtn.setBounds(450, 100, 130, 50);
        CaramelLatteeBtn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
                   addToReceipt("CaramelLattee","Caramel  Latte");
             }
           });
        MainPanel.add(CaramelLatteeBtn);
      //-----------------------------------------------------
     
           IrishLatteeBtn = new JButton(" أيريش لاتيـه" );
           IrishLatteeBtn.setBackground(Color.blue);
           IrishLatteeBtn.setForeground(Color.black);
           IrishLatteeBtn.setFont(new Font("TimesRoman", Font.BOLD , 20));
           IrishLatteeBtn.setBounds(610, 100, 130, 50);
           IrishLatteeBtn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
                addToReceipt("IrishLattee","Iresh Latte");
             }
           });
        MainPanel.add(IrishLatteeBtn);
        
        //-----------------------------------------------------
        VanillaLatteeBtn = new JButton(" فانيليا لاتيــه");
        VanillaLatteeBtn.setBackground(Color.red);
        VanillaLatteeBtn.setForeground(Color.black);
        VanillaLatteeBtn.setFont(new Font("TimesRoman", Font.BOLD , 20));
        VanillaLatteeBtn.setBounds(130, 180, 130, 50);
        VanillaLatteeBtn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
                  addToReceipt("VanillaLattee","Vanilla Latte");
             }
           });
        MainPanel.add(VanillaLatteeBtn);
    //-----------------------------------------------------------   
        ChocolateCoffeeBtn = new JButton(" قهوة شوكولاتة");
        ChocolateCoffeeBtn.setBackground(Color.yellow);
        ChocolateCoffeeBtn.setForeground(Color.black);
        ChocolateCoffeeBtn.setFont(new Font("TimesRoman", Font.BOLD , 19));
        ChocolateCoffeeBtn.setBounds(290, 180, 130, 50);
        ChocolateCoffeeBtn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
                  addToReceipt("ChocolateCoffee","Chocolate Coffee");
             }
           });
        MainPanel.add(ChocolateCoffeeBtn);

        
    //------------------------------------------------------------
        AlmondsCoffeeBtn = new JButton("قهوة لــوز");
        AlmondsCoffeeBtn.setBackground(Color.GREEN);
        AlmondsCoffeeBtn.setForeground(Color.black);
        AlmondsCoffeeBtn.setFont(new Font("TimesRoman", Font.BOLD , 20));
        AlmondsCoffeeBtn.setBounds(450, 180, 130, 50);
        AlmondsCoffeeBtn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
                     addToReceipt("AlmondsCoffee","Almonds Coffee");
             }
           });
        MainPanel.add(AlmondsCoffeeBtn);
    //----------------------------------------------------------
        HazelNutCoffeeBtn = new JButton("قهوة بندق " );
        HazelNutCoffeeBtn.setBackground(Color.cyan);
        HazelNutCoffeeBtn.setForeground(Color.black);
        HazelNutCoffeeBtn.setFont(new Font("TimesRoman", Font.BOLD , 20));
        HazelNutCoffeeBtn.setBounds(610, 180, 130, 50);
        HazelNutCoffeeBtn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
                  addToReceipt("HazelNutCoffee","HazelNut Coffee");
             }
           });
        MainPanel.add(HazelNutCoffeeBtn);
        
     //--------------------------------------------------------
        MacchiatoBtn = new JButton(" ماكياتــو" );
        MacchiatoBtn.setBackground(Color.ORANGE);
        MacchiatoBtn.setForeground(Color.black);
        MacchiatoBtn.setFont(new Font("TimesRoman", Font.BOLD , 20));
        MacchiatoBtn.setBounds(130, 260, 130, 50);
        MacchiatoBtn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
                 addToReceipt("Macchiato","Macchiato");
             }
           });
        MainPanel.add(MacchiatoBtn);
      //--------------------------------------------------------
        CoffeeAmericanoBtn = new JButton("  أميريكان كوفي" );
        CoffeeAmericanoBtn.setBackground(Color.pink);
        CoffeeAmericanoBtn.setForeground(Color.black);
        CoffeeAmericanoBtn.setFont(new Font("TimesRoman", Font.BOLD , 18));
        CoffeeAmericanoBtn.setBounds(290, 260, 130, 50);
        CoffeeAmericanoBtn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
                    addToReceipt("CoffeeAmericano","Coffee Americano");
             }
           });
        MainPanel.add(CoffeeAmericanoBtn);
      //-----------------------------------------------------
        CoffeeMochaBtn = new JButton("  موكا كافية" );
        CoffeeMochaBtn.setBackground(Color.red);
        CoffeeMochaBtn.setForeground(Color.black);
        CoffeeMochaBtn.setFont(new Font("TimesRoman", Font.BOLD , 20));
        CoffeeMochaBtn.setBounds(450, 260, 130, 50);
        CoffeeMochaBtn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
                   addToReceipt("CoffeeMocha","Coffee   Mocha");
             }
           });
        MainPanel.add(CoffeeMochaBtn);
      //-----------------------------------------------------
     
           TurkishCoffeeSBtn = new JButton(" قهوة تركي سينجل" );
           TurkishCoffeeSBtn.setBackground(Color.blue);
           TurkishCoffeeSBtn.setForeground(Color.black);
           TurkishCoffeeSBtn.setFont(new Font("TimesRoman", Font.BOLD , 17));
           TurkishCoffeeSBtn.setBounds(610, 260, 130, 50);
           TurkishCoffeeSBtn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
                  addToReceipt("TurkishCoffeeS","Turkish Coffee Single");
             }
           });
        MainPanel.add(TurkishCoffeeSBtn);
              //-----------------------------------------------------
     
           TurkishCoffeeDBtn = new JButton(" قهوة تركي دبل" );
           TurkishCoffeeDBtn.setBackground(Color.blue);
           TurkishCoffeeDBtn.setForeground(Color.black);
           TurkishCoffeeDBtn.setFont(new Font("TimesRoman", Font.BOLD , 20));
           TurkishCoffeeDBtn.setBounds(450, 340, 130, 50);
           TurkishCoffeeDBtn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
                  addToReceipt("TurkishCoffeeD","Turkish Coffee Double");
             }
           });
        MainPanel.add(TurkishCoffeeDBtn);
        
 //---------------------------------------------------------------------------
         MainPanel.revalidate(); // to invoke the layout manager
         MainPanel.repaint(); 
        
        
    }//GEN-LAST:event_HotCoffeeBtnActionPerformed

    private void HotDrinksBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HotDrinksBtnActionPerformed
        // TODO add your handling code here:
    JButton TeaBtn ;
    JButton FruiteTeaBtn ;
    JButton AMCRBtn ;
    JButton SahlabBtn ;
    JButton SahlabFruitBtn ;
    JButton HotSpiderButton ;
    
       CocktailBtn.setBackground(cGray);
            ColdDrinksBtn.setBackground(cGray);
            DessertBtn.setBackground(cGray);
            FreshBtn.setBackground(cGray);
            HotCoffeeBtn.setBackground(cGray);
            SmothieBtn.setBackground(cGray);
            MilkShakeBtn.setBackground(cGray);
            PlayStationBtn.setBackground(cGray);
            ShishaBtn.setBackground(cGray);

         
        HotDrinksBtn.setBackground(Color.red);
        MainPanel.removeAll();
        MainPanel.invalidate();
        MainPanel.setPreferredSize(new Dimension(1132, 121));
         
        TeaBtn = new JButton("شـــاي");
        TeaBtn.setBackground(Color.red);
        TeaBtn.setForeground(Color.black);
        TeaBtn.setFont(new Font("TimesRoman", Font.BOLD , 20));
        TeaBtn.setBounds(130, 20, 130, 50);
        TeaBtn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
                   addToReceipt("Tea","Tea");
             }
           });
        MainPanel.add(TeaBtn);
    //-----------------------------------------------------------   
        FruiteTeaBtn = new JButton("شــاي فواكه");
        FruiteTeaBtn.setBackground(Color.yellow);
        FruiteTeaBtn.setForeground(Color.black);
        FruiteTeaBtn.setFont(new Font("TimesRoman", Font.BOLD , 20));
        FruiteTeaBtn.setBounds(290, 20, 130, 50);
        FruiteTeaBtn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
                   addToReceipt("FruiteTea","Fruite Tea");
             }
           });
        MainPanel.add(FruiteTeaBtn);

        
    //------------------------------------------------------------
        AMCRBtn = new JButton("ينسون/نعناع/قرفة/كركديه");
        AMCRBtn.setBackground(Color.GREEN);
        AMCRBtn.setForeground(Color.black);
        AMCRBtn.setFont(new Font("TimesRoman", Font.BOLD , 17));
        AMCRBtn.setBounds(450, 20, 170, 50);
        AMCRBtn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
                   addToReceipt("AMCR","Anise/Mint");
             }
           });
        MainPanel.add(AMCRBtn);
    //----------------------------------------------------------
        SahlabBtn = new JButton(" سحلــب" );
        SahlabBtn.setBackground(Color.cyan);
        SahlabBtn.setForeground(Color.black);
        SahlabBtn.setFont(new Font("TimesRoman", Font.BOLD , 20));
        SahlabBtn.setBounds(450, 120, 130, 50);
        SahlabBtn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
                   addToReceipt("Sahlab","Saahlab");
             }
           });
        MainPanel.add(SahlabBtn);
        
     //--------------------------------------------------------
        SahlabFruitBtn = new JButton(" سحـلـب فواكه" );
        SahlabFruitBtn.setBackground(Color.ORANGE);
        SahlabFruitBtn.setForeground(Color.black);
        SahlabFruitBtn.setFont(new Font("TimesRoman", Font.BOLD , 20));
        SahlabFruitBtn.setBounds(130, 120, 130, 50);
        SahlabFruitBtn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
                    addToReceipt("SahlabFruit","Sahlab Fruit");
             }
           });
        MainPanel.add(SahlabFruitBtn);
      //--------------------------------------------------------
        HotSpiderButton = new JButton(" هوت سبايدر" );
        HotSpiderButton.setBackground(Color.pink);
        HotSpiderButton.setForeground(Color.black);
        HotSpiderButton.setFont(new Font("TimesRoman", Font.BOLD , 20));
        HotSpiderButton.setBounds(290, 120, 130, 50);
        HotSpiderButton.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
                    addToReceipt("HotSpider","Hot Spider");
             }
           });
        MainPanel.add(HotSpiderButton);
       
        
       //-----------------------------------------------------
         MainPanel.revalidate(); // to invoke the layout manager
         MainPanel.repaint();
    
    }//GEN-LAST:event_HotDrinksBtnActionPerformed

    private void ColdDrinksBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ColdDrinksBtnActionPerformed
        // TODO add your handling code here:
    JButton ColdChocolateBtn ;
    JButton IceEspressoBtn ;
    JButton IceMochaBtn ;
    JButton ClassicLemonBtn ;
    JButton HoneyYoughurtBtn ;
    JButton BlendedYoughartBtn ;
    JButton BorioBtn ;
    JButton PepsiBtn ;
    JButton FayrouzBtn ;
    JButton BirrelBtn ;
    JButton WaterBtn ;
        
            CocktailBtn.setBackground(cGray);
            MilkShakeBtn.setBackground(cGray);
            DessertBtn.setBackground(cGray);
            FreshBtn.setBackground(cGray);
            HotCoffeeBtn.setBackground(cGray);
            HotDrinksBtn.setBackground(cGray);
            PlayStationBtn.setBackground(cGray);
            ShishaBtn.setBackground(cGray);
            SmothieBtn.setBackground(cGray);
            
        ColdDrinksBtn.setBackground(Color.red);
        
        MainPanel.removeAll();
        MainPanel.invalidate();
        MainPanel.setPreferredSize(new Dimension(1132, 121));
         
        ColdChocolateBtn = new JButton(" شوكولاتة باردة");
        ColdChocolateBtn.setBackground(Color.red);
        ColdChocolateBtn.setForeground(Color.black);
        ColdChocolateBtn.setFont(new Font("TimesRoman", Font.BOLD , 17));
        ColdChocolateBtn.setBounds(130, 20, 130, 50);
        ColdChocolateBtn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
                   addToReceipt("ColdChocolate","Cold Chocolate");
             }
           });
        MainPanel.add(ColdChocolateBtn);
    //-----------------------------------------------------------   
        IceEspressoBtn = new JButton(" إسبريسـو + ثلج");
        IceEspressoBtn.setBackground(Color.yellow);
        IceEspressoBtn.setForeground(Color.black);
        IceEspressoBtn.setFont(new Font("TimesRoman", Font.BOLD , 17));
        IceEspressoBtn.setBounds(290, 20, 130, 50);
        IceEspressoBtn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
                 addToReceipt("IceEspresso","Ice Espresso");
             }
           });
        MainPanel.add(IceEspressoBtn);

    //------------------------------------------------------------
        IceMochaBtn = new JButton("أيس موكا");
        IceMochaBtn.setBackground(Color.GREEN);
        IceMochaBtn.setForeground(Color.black);
        IceMochaBtn.setFont(new Font("TimesRoman", Font.BOLD , 20));
        IceMochaBtn.setBounds(450, 20, 130, 50);
        IceMochaBtn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
                  addToReceipt("IceMocha","Ice Mocha");
             }
           });
        MainPanel.add(IceMochaBtn);
    //----------------------------------------------------------
        ClassicLemonBtn = new JButton("ليمــون " );
        ClassicLemonBtn.setBackground(Color.cyan);
        ClassicLemonBtn.setForeground(Color.black);
        ClassicLemonBtn.setFont(new Font("TimesRoman", Font.BOLD , 17));
        ClassicLemonBtn.setBounds(610, 20, 130, 50);
        ClassicLemonBtn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
                   addToReceipt("ClassicLemon","Cold Lemon");
             }
           });
        MainPanel.add(ClassicLemonBtn);
        
     //--------------------------------------------------------
        HoneyYoughurtBtn = new JButton(" زبادي عسـل" );
        HoneyYoughurtBtn.setBackground(Color.ORANGE);
        HoneyYoughurtBtn.setForeground(Color.black);
        HoneyYoughurtBtn.setFont(new Font("TimesRoman", Font.BOLD , 17));
        HoneyYoughurtBtn.setBounds(130, 100, 130, 50);
        HoneyYoughurtBtn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
                    addToReceipt("HoneyYoughurt","Honey Youghurt");
             }
           });
        MainPanel.add(HoneyYoughurtBtn);
      //--------------------------------------------------------
        BlendedYoughartBtn = new JButton(" زبادي فواكــه" );
        BlendedYoughartBtn.setBackground(Color.pink);
        BlendedYoughartBtn.setForeground(Color.black);
        BlendedYoughartBtn.setFont(new Font("TimesRoman", Font.BOLD , 20));
        BlendedYoughartBtn.setBounds(290, 100, 130, 50);
        BlendedYoughartBtn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
                  addToReceipt("BlendedYoughart","Blended Youghart");
             }
           });
        MainPanel.add(BlendedYoughartBtn);
      //-----------------------------------------------------
        BorioBtn = new JButton("  بوريــو" );
        BorioBtn.setBackground(Color.red);
        BorioBtn.setForeground(Color.black);
        BorioBtn.setFont(new Font("TimesRoman", Font.BOLD , 20));
        BorioBtn.setBounds(450, 100, 130, 50);
        BorioBtn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
                   addToReceipt("Borio","Cold Borio");
             }
           });
        MainPanel.add(BorioBtn);
      //-----------------------------------------------------
     
           PepsiBtn = new JButton("  بيبســـي" );
           PepsiBtn.setBackground(Color.blue);
           PepsiBtn.setForeground(Color.black);
           PepsiBtn.setFont(new Font("TimesRoman", Font.BOLD , 20));
           PepsiBtn.setBounds(610, 100, 130, 50);
           PepsiBtn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
                   addToReceipt("Pepsi","Pepsi");
             }
           });
        MainPanel.add(PepsiBtn);
        
        //-----------------------------------------------------
        FayrouzBtn = new JButton("  فيـــروز");
        FayrouzBtn.setBackground(Color.red);
        FayrouzBtn.setForeground(Color.black);
        FayrouzBtn.setFont(new Font("TimesRoman", Font.BOLD , 20));
        FayrouzBtn.setBounds(130, 180, 130, 50);
        FayrouzBtn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
                   addToReceipt("Fayrouz","Fayrouz");
             }
           });
        MainPanel.add(FayrouzBtn);
    //-----------------------------------------------------------   
        BirrelBtn = new JButton("  بيريــل");
        BirrelBtn.setBackground(Color.yellow);
        BirrelBtn.setForeground(Color.black);
        BirrelBtn.setFont(new Font("TimesRoman", Font.BOLD , 19));
        BirrelBtn.setBounds(290, 180, 130, 50);
        BirrelBtn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
                  addToReceipt("Birrel","Birrel");
             }
           });
        MainPanel.add(BirrelBtn);

        
    //------------------------------------------------------------
        WaterBtn = new JButton(" ميــاه");
        WaterBtn.setBackground(Color.GREEN);
        WaterBtn.setForeground(Color.black);
        WaterBtn.setFont(new Font("TimesRoman", Font.BOLD , 20));
        WaterBtn.setBounds(450, 180, 130, 50);
        WaterBtn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
                    addToReceipt("Water","Cold Water");
             }
           });
        MainPanel.add(WaterBtn);
        
 //---------------------------------------------------------------------------
         MainPanel.revalidate(); // to invoke the layout manager
         MainPanel.repaint(); 
 
    }//GEN-LAST:event_ColdDrinksBtnActionPerformed

    private void DessertBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DessertBtnActionPerformed
        // TODO add your handling code here:
    JButton CheeseLoverBtn ;
    JButton OreoMadnessBtn ;
    JButton FruitSaladBtn ;
    JButton FruitSaladIceCreamBtn ;
    JButton ChocolateMousseBtn ;
    JButton RichChocolateCakeBtn ;
    JButton ChocolateCakeBtn ;
    JButton BananaSplitBtn ;
    JButton OreoIceCreamBtn ;
    JButton FruiteIceCreamBtn ;
    JButton IceCreamScoopesBtn ;
    
            CocktailBtn.setBackground(cGray);
            MilkShakeBtn.setBackground(cGray);
            ColdDrinksBtn.setBackground(cGray);
            FreshBtn.setBackground(cGray);
            HotCoffeeBtn.setBackground(cGray);
            HotDrinksBtn.setBackground(cGray);
            PlayStationBtn.setBackground(cGray);
            ShishaBtn.setBackground(cGray);
            SmothieBtn.setBackground(cGray);
            
        DessertBtn.setBackground(Color.red);
        
        MainPanel.removeAll();
        MainPanel.invalidate();
        MainPanel.setPreferredSize(new Dimension(1132, 121));
         
        CheeseLoverBtn = new JButton("  تشيز لافر");
        CheeseLoverBtn.setBackground(Color.red);
        CheeseLoverBtn.setForeground(Color.black);
        CheeseLoverBtn.setFont(new Font("TimesRoman", Font.BOLD , 17));
        CheeseLoverBtn.setBounds(130, 20, 130, 50);
        CheeseLoverBtn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
                    addToReceipt("CheeseLover","Cheese   Lover");
             }
           });
        MainPanel.add(CheeseLoverBtn);
    //-----------------------------------------------------------   
        OreoMadnessBtn = new JButton("  أوريو مادنيس ");
        OreoMadnessBtn.setBackground(Color.yellow);
        OreoMadnessBtn.setForeground(Color.black);
        OreoMadnessBtn.setFont(new Font("TimesRoman", Font.BOLD , 17));
        OreoMadnessBtn.setBounds(290, 20, 130, 50);
        OreoMadnessBtn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
                   addToReceipt("OreoMadness","Oreo   Madness");
             }
           });
        MainPanel.add(OreoMadnessBtn);

    //------------------------------------------------------------
        FruitSaladBtn = new JButton("  فروت سالاد");
        FruitSaladBtn.setBackground(Color.GREEN);
        FruitSaladBtn.setForeground(Color.black);
        FruitSaladBtn.setFont(new Font("TimesRoman", Font.BOLD , 20));
        FruitSaladBtn.setBounds(450, 20, 130, 50);
        FruitSaladBtn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
                  addToReceipt("FruitSalad","Fruit Salad");
             }
           });
        MainPanel.add(FruitSaladBtn);
    //----------------------------------------------------------
        FruitSaladIceCreamBtn = new JButton("فروت سالاد بالأيس كريم " );
        FruitSaladIceCreamBtn.setBackground(Color.cyan);
        FruitSaladIceCreamBtn.setForeground(Color.black);
        FruitSaladIceCreamBtn.setFont(new Font("TimesRoman", Font.BOLD , 17));
        FruitSaladIceCreamBtn.setBounds(610, 20, 180, 50);
        FruitSaladIceCreamBtn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
                   addToReceipt("FruitSaladIceCream","Fruit Salad Ice Cream");
             }
           });
        MainPanel.add(FruitSaladIceCreamBtn);
        
     //--------------------------------------------------------
        ChocolateMousseBtn = new JButton("  شوكلت فادج" );
        ChocolateMousseBtn.setBackground(Color.ORANGE);
        ChocolateMousseBtn.setForeground(Color.black);
        ChocolateMousseBtn.setFont(new Font("TimesRoman", Font.BOLD , 17));
        ChocolateMousseBtn.setBounds(130, 100, 130, 50);
        ChocolateMousseBtn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
                  addToReceipt("ChocolateMousse","Chocolate Mousse");
             }
           });
        MainPanel.add(ChocolateMousseBtn);
      //--------------------------------------------------------
        RichChocolateCakeBtn = new JButton("  ريتش شوكلت كيك" );
        RichChocolateCakeBtn.setBackground(Color.pink);
        RichChocolateCakeBtn.setForeground(Color.black);
        RichChocolateCakeBtn.setFont(new Font("TimesRoman", Font.BOLD , 16));
        RichChocolateCakeBtn.setBounds(290, 100, 130, 50);
        RichChocolateCakeBtn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
                   addToReceipt("RichChocolateCake","Rich Chocolate Cake");
             }
           });
        MainPanel.add(RichChocolateCakeBtn);
      //-----------------------------------------------------
        BananaSplitBtn = new JButton("  بانانا سبليت" );
        BananaSplitBtn.setBackground(Color.red);
        BananaSplitBtn.setForeground(Color.black);
        BananaSplitBtn.setFont(new Font("TimesRoman", Font.BOLD , 20));
        BananaSplitBtn.setBounds(450, 100, 130, 50);
        BananaSplitBtn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
                  addToReceipt("BananaSplit","Banana Split");
             }
           });
        MainPanel.add(BananaSplitBtn);
      //-----------------------------------------------------
     
           OreoIceCreamBtn = new JButton("   أوريو أيس كريم" );
           OreoIceCreamBtn.setBackground(Color.blue);
           OreoIceCreamBtn.setForeground(Color.black);
           OreoIceCreamBtn.setFont(new Font("TimesRoman", Font.BOLD , 17));
           OreoIceCreamBtn.setBounds(610, 100, 180, 50);
           OreoIceCreamBtn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
                   addToReceipt("OreoIceCream","Oreo Ice Cream");
             }
           });
        MainPanel.add(OreoIceCreamBtn);
        
        //-----------------------------------------------------
        FruiteIceCreamBtn = new JButton("  أيس كريم فواكه");
        FruiteIceCreamBtn.setBackground(Color.red);
        FruiteIceCreamBtn.setForeground(Color.black);
        FruiteIceCreamBtn.setFont(new Font("TimesRoman", Font.BOLD , 17));
        FruiteIceCreamBtn.setBounds(130, 180, 130, 50);
        FruiteIceCreamBtn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
                   addToReceipt("FruiteIceCream","Fruite Ice Cream");
             }
           });
        MainPanel.add(FruiteIceCreamBtn);
    //-----------------------------------------------------------   
        IceCreamScoopesBtn = new JButton("أيس كريم بولة ");
        IceCreamScoopesBtn.setBackground(Color.yellow);
        IceCreamScoopesBtn.setForeground(Color.black);
        IceCreamScoopesBtn.setFont(new Font("TimesRoman", Font.BOLD , 19));
        IceCreamScoopesBtn.setBounds(290, 180, 130, 50);
        IceCreamScoopesBtn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
                 addToReceipt("IceCreamScoopes","Ice Cream Scoopes");
             }
           });
        MainPanel.add(IceCreamScoopesBtn);

        
 //---------------------------------------------------------------------------
         MainPanel.revalidate(); // to invoke the layout manager
         MainPanel.repaint(); 
    
    }//GEN-LAST:event_DessertBtnActionPerformed

    private void CocktailBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CocktailBtnActionPerformed
        // TODO add your handling code here:
    JButton LemonMintBtn ;
    JButton YourCocktailBtn ;
    JButton GreenSkyBtn ;
    JButton ClassicBianoBtn ;
    JButton FloridaBtn ;
    JButton ParadiseBtn  ;
    JButton FruitZoomBtn ;
    JButton SunShineBtn ;
    JButton FruitYoughurtBtn ;
    JButton BlueHawaiiBtn ;
    JButton PeachPineAppleBtn ;
    JButton TropicanaBtn ;
    JButton StrawBananaBtn ;
    JButton PowerBtn ;
    JButton SunShineOrangeBtn ;
    JButton TodeIceBtn ;
    JButton TwinkiesBtn ;
    JButton HohosBtn ;
    JButton SnickersBtn ;
    JButton BorioBananaBtn ;
    JButton WeaferBtn ;
    JButton StrawberryEnergyBtn ;
    JButton BananaCaramelBtn ;
    JButton PeachAppleDelight ;
    JButton CherryCokeBtn ;
    
            DessertBtn.setBackground(cGray);
            MilkShakeBtn.setBackground(cGray);
            ColdDrinksBtn.setBackground(cGray);
            FreshBtn.setBackground(cGray);
            HotCoffeeBtn.setBackground(cGray);
            HotDrinksBtn.setBackground(cGray);
            PlayStationBtn.setBackground(cGray);
            ShishaBtn.setBackground(cGray);
            SmothieBtn.setBackground(cGray);
            
        CocktailBtn.setBackground(Color.red);
        
        MainPanel.removeAll();
        MainPanel.invalidate();
        MainPanel.setPreferredSize(new Dimension(1132, 121));
         
        LemonMintBtn = new JButton("   ليمون نعنــاع");
        LemonMintBtn.setBackground(Color.red);
        LemonMintBtn.setForeground(Color.black);
        LemonMintBtn.setFont(new Font("TimesRoman", Font.BOLD , 17));
        LemonMintBtn.setBounds(130, 20, 130, 50);
        LemonMintBtn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
                  addToReceipt("LemonMint","Lemon Mint");
             }
           });
        MainPanel.add(LemonMintBtn);
    //-----------------------------------------------------------   
        YourCocktailBtn = new JButton("  إختر كوكتيلك  ");
        YourCocktailBtn.setBackground(Color.yellow);
        YourCocktailBtn.setForeground(Color.black);
        YourCocktailBtn.setFont(new Font("TimesRoman", Font.BOLD , 17));
        YourCocktailBtn.setBounds(290, 20, 130, 50);
        YourCocktailBtn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
                    addToReceipt("YourCocktail","Your Cocktail");
             }
           });
        MainPanel.add(YourCocktailBtn);

    //------------------------------------------------------------
        GreenSkyBtn = new JButton("  جـريــن سكاي ");
        GreenSkyBtn.setBackground(Color.GREEN);
        GreenSkyBtn.setForeground(Color.black);
        GreenSkyBtn.setFont(new Font("TimesRoman", Font.BOLD , 17));
        GreenSkyBtn.setBounds(450, 20, 130, 50);
        GreenSkyBtn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
                  addToReceipt("GreenSky","Green Sky");
             }
           });
        MainPanel.add(GreenSkyBtn);
    //----------------------------------------------------------
        ClassicBianoBtn = new JButton("   كلاسيــك بيانو " );
        ClassicBianoBtn.setBackground(Color.cyan);
        ClassicBianoBtn.setForeground(Color.black);
        ClassicBianoBtn.setFont(new Font("TimesRoman", Font.BOLD , 17));
        ClassicBianoBtn.setBounds(820, 340, 130, 50);
        ClassicBianoBtn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
                  addToReceipt("ClassicBiano","Classic Biano");
             }
           });
        MainPanel.add(ClassicBianoBtn);
        
     //--------------------------------------------------------
        FloridaBtn = new JButton("   فلــوريدا" );
        FloridaBtn.setBackground(Color.ORANGE);
        FloridaBtn.setForeground(Color.black);
        FloridaBtn.setFont(new Font("TimesRoman", Font.BOLD , 17));
        FloridaBtn.setBounds(820, 20, 130, 50);
        FloridaBtn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
                  addToReceipt("Florida","Florida");
             }
           });
        MainPanel.add(FloridaBtn);
      //--------------------------------------------------------
        ParadiseBtn = new JButton("    بارادايـس" );
        ParadiseBtn.setBackground(Color.pink);
        ParadiseBtn.setForeground(Color.black);
        ParadiseBtn.setFont(new Font("TimesRoman", Font.BOLD , 16));
        ParadiseBtn.setBounds(130, 100, 130, 50);
        ParadiseBtn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
                  addToReceipt("Paradise","Paradise");
             }
           });
        MainPanel.add(ParadiseBtn);
      //-----------------------------------------------------
        FruitZoomBtn = new JButton("   فروت زوم" );
        FruitZoomBtn.setBackground(Color.red);
        FruitZoomBtn.setForeground(Color.black);
        FruitZoomBtn.setFont(new Font("TimesRoman", Font.BOLD , 20));
        FruitZoomBtn.setBounds(290, 100, 130, 50);
        FruitZoomBtn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
                   addToReceipt("FruitZoom","Fruit Zoom");
             }
           });
        MainPanel.add(FruitZoomBtn);
      //-----------------------------------------------------
     
           SunShineBtn = new JButton(" صن شايـــن " );
           SunShineBtn.setBackground(Color.blue);
           SunShineBtn.setForeground(Color.black);
           SunShineBtn.setFont(new Font("TimesRoman", Font.BOLD , 17));
           SunShineBtn.setBounds(290, 340, 130, 50);
           SunShineBtn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
                    addToReceipt("SunShine","Sun Shine");
             }
           });
        MainPanel.add(SunShineBtn);
        
        //-----------------------------------------------------
        FruitYoughurtBtn = new JButton("    زبادي فواكه");
        FruitYoughurtBtn.setBackground(Color.red);
        FruitYoughurtBtn.setForeground(Color.black);
        FruitYoughurtBtn.setFont(new Font("TimesRoman", Font.BOLD , 17));
        FruitYoughurtBtn.setBounds(450, 100, 130, 50);
        FruitYoughurtBtn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
                 addToReceipt("FruitYoughurt","Fruit   Youghurt");
             }
           });
        MainPanel.add(FruitYoughurtBtn);
    //-----------------------------------------------------------   
        BlueHawaiiBtn = new JButton("   بلو هاواي ");
        BlueHawaiiBtn.setBackground(Color.yellow);
        BlueHawaiiBtn.setForeground(Color.black);
        BlueHawaiiBtn.setFont(new Font("TimesRoman", Font.BOLD , 19));
        BlueHawaiiBtn.setBounds(820, 100, 130, 50);
        BlueHawaiiBtn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
                  addToReceipt("BlueHawaii","Blue Hawaii");
             }
           });
        MainPanel.add(BlueHawaiiBtn);
    //----------------------------------------------------------------
        PeachPineAppleBtn = new JButton("خوخ أناناس");
        PeachPineAppleBtn.setBackground(Color.red);
        PeachPineAppleBtn.setForeground(Color.black);
        PeachPineAppleBtn.setFont(new Font("TimesRoman", Font.BOLD , 20));
        PeachPineAppleBtn.setBounds(130, 180, 130, 50);
        PeachPineAppleBtn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
                  addToReceipt("PeachPineApple","Peach PineApple");
             }
           });
        MainPanel.add(PeachPineAppleBtn);
    //-----------------------------------------------------------   
        TropicanaBtn = new JButton(" تروبيكانا");
        TropicanaBtn.setBackground(Color.yellow);
        TropicanaBtn.setForeground(Color.black);
        TropicanaBtn.setFont(new Font("TimesRoman", Font.BOLD , 20));
        TropicanaBtn.setBounds(290, 180, 130, 50);
        TropicanaBtn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
                    addToReceipt("Tropicana","Tropicana");
             }
           });
        MainPanel.add(TropicanaBtn);

        
    //------------------------------------------------------------
        StrawBananaBtn = new JButton("موز فراولــة");
        StrawBananaBtn.setBackground(Color.GREEN);
        StrawBananaBtn.setForeground(Color.black);
        StrawBananaBtn.setFont(new Font("TimesRoman", Font.BOLD , 17));
        StrawBananaBtn.setBounds(450, 180, 130, 50);
        StrawBananaBtn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
                    addToReceipt("StrawBanana","Straw   Banana");
             }
           });
        MainPanel.add(StrawBananaBtn );
    //----------------------------------------------------------
        PowerBtn = new JButton(" باور" );
        PowerBtn.setBackground(Color.cyan);
        PowerBtn.setForeground(Color.black);
        PowerBtn.setFont(new Font("TimesRoman", Font.BOLD , 20));
        PowerBtn.setBounds(820, 180, 130, 50);
        PowerBtn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
                  addToReceipt("Power","Power");
             }
           });
        MainPanel.add(PowerBtn );
        
     //--------------------------------------------------------
        SunShineOrangeBtn = new JButton("  صن شايـن برتقال" );
        SunShineOrangeBtn.setBackground(Color.ORANGE);
        SunShineOrangeBtn.setForeground(Color.black);
        SunShineOrangeBtn.setFont(new Font("TimesRoman", Font.BOLD , 17));
        SunShineOrangeBtn.setBounds(610, 180, 180, 50);
        SunShineOrangeBtn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
                   addToReceipt("SunShineOrange","SunShine Orange");
             }
           });
        MainPanel.add(SunShineOrangeBtn );
      //--------------------------------------------------------
        TodeIceBtn = new JButton(" تودو أيس " );
        TodeIceBtn.setBackground(Color.pink);
        TodeIceBtn.setForeground(Color.black);
        TodeIceBtn.setFont(new Font("TimesRoman", Font.BOLD , 20));
        TodeIceBtn.setBounds(130, 260, 130, 50);
        TodeIceBtn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
                  addToReceipt("TodeIce","Tode Ice");
             }
           });
        MainPanel.add(TodeIceBtn );
        //----------------------------------------------------------
        TwinkiesBtn = new JButton("توينكيـز " );
        TwinkiesBtn.setBackground(Color.cyan);
        TwinkiesBtn.setForeground(Color.black);
        TwinkiesBtn.setFont(new Font("TimesRoman", Font.BOLD , 17));
        TwinkiesBtn.setBounds(290, 260, 130, 50);
        TwinkiesBtn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
                  addToReceipt("Twinkies","Twinkies");
             }
           });
        MainPanel.add(TwinkiesBtn );
        
     //--------------------------------------------------------
        HohosBtn = new JButton("   هوهــوز" );
        HohosBtn.setBackground(Color.ORANGE);
        HohosBtn.setForeground(Color.black);
        HohosBtn.setFont(new Font("TimesRoman", Font.BOLD , 17));
        HohosBtn.setBounds(450, 260, 130, 50);
        HohosBtn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
                  addToReceipt("Hohos","Hohos");
             }
           });
        MainPanel.add(HohosBtn );
      //--------------------------------------------------------
        SnickersBtn = new JButton("  سنيكرز" );
        SnickersBtn.setBackground(Color.pink);
        SnickersBtn.setForeground(Color.black);
        SnickersBtn.setFont(new Font("TimesRoman", Font.BOLD , 16));
        SnickersBtn.setBounds(610, 260, 130, 50);
        SnickersBtn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
                   addToReceipt("Snickers","Snickers");
             }
           });
        MainPanel.add(SnickersBtn );
      //-----------------------------------------------------
        BorioBananaBtn = new JButton("بوريو موز" );
        BorioBananaBtn.setBackground(Color.red);
        BorioBananaBtn.setForeground(Color.black);
        BorioBananaBtn.setFont(new Font("TimesRoman", Font.BOLD , 20));
        BorioBananaBtn.setBounds(820, 260, 130, 50);
        BorioBananaBtn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
                   addToReceipt("BorioBanana","Borio Banana");
             }
           });
        MainPanel.add(BorioBananaBtn );
      //-----------------------------------------------------
     
           WeaferBtn = new JButton(" ويفـــر  " );
           WeaferBtn.setBackground(Color.blue);
           WeaferBtn.setForeground(Color.black);
           WeaferBtn.setFont(new Font("TimesRoman", Font.BOLD , 20));
           WeaferBtn.setBounds(130, 340, 130, 50);
           WeaferBtn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
                    addToReceipt("Weafer","Weafer");
             }
           });
        MainPanel.add(WeaferBtn );
        
        //-----------------------------------------------------
        StrawberryEnergyBtn = new JButton("ستروبيري إنيرجي ");
        StrawberryEnergyBtn.setBackground(Color.red);
        StrawberryEnergyBtn.setForeground(Color.black);
        StrawberryEnergyBtn.setFont(new Font("TimesRoman", Font.BOLD , 17));
        StrawberryEnergyBtn.setBounds(610, 100, 180, 50);
        StrawberryEnergyBtn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
                   addToReceipt("StrawberryEnergy","Strawberry Energy");
             }
           });
        MainPanel.add(StrawberryEnergyBtn );
    //-----------------------------------------------------------   
        BananaCaramelBtn = new JButton("   موز كراميل ");
        BananaCaramelBtn.setBackground(Color.yellow);
        BananaCaramelBtn.setForeground(Color.black);
        BananaCaramelBtn.setFont(new Font("TimesRoman", Font.BOLD , 19));
        BananaCaramelBtn.setBounds(450, 340, 130, 50);
        BananaCaramelBtn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
                     addToReceipt("BananaCaramel","Banana Caramel");
             }
           });
        MainPanel.add(BananaCaramelBtn );
    //----------------------------------------------------------------
        PeachPineAppleBtn = new JButton("خوخ أناناس");
        PeachPineAppleBtn.setBackground(Color.red);
        PeachPineAppleBtn.setForeground(Color.black);
        PeachPineAppleBtn.setFont(new Font("TimesRoman", Font.BOLD , 20));
        PeachPineAppleBtn.setBounds(610, 340, 130, 50);
        PeachPineAppleBtn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
                   addToReceipt("PeachPineApple","Peach PineApple");
             }
           });
        MainPanel.add(PeachPineAppleBtn);
    //-----------------------------------------------------------   
        PeachAppleDelight = new JButton(" ديلايت تفاح خوخ");
        PeachAppleDelight.setBackground(Color.yellow);
        PeachAppleDelight.setForeground(Color.black);
        PeachAppleDelight.setFont(new Font("TimesRoman", Font.BOLD , 17));
        PeachAppleDelight.setBounds(610, 20, 180, 50);
        PeachAppleDelight.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
                 addToReceipt("PeachAppleDelight","Peach Apple Delight");
             }
           });
        MainPanel.add(PeachAppleDelight );

        
    //------------------------------------------------------------
        CherryCokeBtn = new JButton("شيري كـوك ");
        CherryCokeBtn.setBackground(Color.GREEN);
        CherryCokeBtn.setForeground(Color.black);
        CherryCokeBtn.setFont(new Font("TimesRoman", Font.BOLD , 17));
        CherryCokeBtn.setBounds(450, 100, 130, 50);
        CherryCokeBtn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
                   addToReceipt("CherryCoke","Cherry Coke");
             }
           });
        MainPanel.add(CherryCokeBtn  );
    //----------------------------------------------------------
       
        
       //-----------------------------------------------------
         MainPanel.revalidate(); // to invoke the layout manager
         MainPanel.repaint();
            
    }//GEN-LAST:event_CocktailBtnActionPerformed

    private void FreshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FreshBtnActionPerformed
        // TODO add your handling code here:
            CocktailBtn.setBackground(cGray);
            ColdDrinksBtn.setBackground(cGray);
            DessertBtn.setBackground(cGray);
            HotCoffeeBtn.setBackground(cGray);
            SmothieBtn.setBackground(cGray);
            HotDrinksBtn.setBackground(cGray);
            MilkShakeBtn.setBackground(cGray);
            PlayStationBtn.setBackground(cGray);
            ShishaBtn.setBackground(cGray);
    JButton OrangeFreshBtn ;
    JButton LemonFreshBtn ;
    JButton MangoFreshBtn ;
    JButton StrawberryFreshBtn ;
    JButton GuavaFreshBtn ;
    JButton WaterMelonFreshBtn ;
    JButton KiwiFreshBtn ;
    JButton PinappleFreshBtn ;
    JButton CantaloupeFreshBtn ;
    JButton BananaFreshBtn ;
    JButton PomegranateFreshBtn ;
    JButton PeachFreshBtn ;

         
        FreshBtn.setBackground(Color.red);
        MainPanel.removeAll();
        MainPanel.invalidate();
        MainPanel.setPreferredSize(new Dimension(1132, 121));
         
        OrangeFreshBtn = new JButton(" برتــقال");
        OrangeFreshBtn.setBackground(Color.red);
        OrangeFreshBtn.setForeground(Color.black);
        OrangeFreshBtn.setFont(new Font("TimesRoman", Font.BOLD , 17));
        OrangeFreshBtn.setBounds(130, 20, 130, 50);
        OrangeFreshBtn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
                  addToReceipt("OrangeFresh","Fresh Orange");
             }
           });
        MainPanel.add(OrangeFreshBtn);
    //-----------------------------------------------------------   
        LemonFreshBtn = new JButton(" ليــمون");
        LemonFreshBtn.setBackground(Color.yellow);
        LemonFreshBtn.setForeground(Color.black);
        LemonFreshBtn.setFont(new Font("TimesRoman", Font.BOLD , 20));
        LemonFreshBtn.setBounds(290, 20, 130, 50);
        LemonFreshBtn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
                  addToReceipt("LemonFresh","Fresh Lemon");
             }
           });
        MainPanel.add(LemonFreshBtn);

    //------------------------------------------------------------
        MangoFreshBtn = new JButton("مانجـــو");
        MangoFreshBtn.setBackground(Color.GREEN);
        MangoFreshBtn.setForeground(Color.black);
        MangoFreshBtn.setFont(new Font("TimesRoman", Font.BOLD , 20));
        MangoFreshBtn.setBounds(450, 20, 130, 50);
        MangoFreshBtn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
                  addToReceipt("MangoFresh","Fresh Mango");
             }
           });
        MainPanel.add(MangoFreshBtn);
    //----------------------------------------------------------
        StrawberryFreshBtn  = new JButton("فراولــة " );
        StrawberryFreshBtn.setBackground(Color.cyan);
        StrawberryFreshBtn.setForeground(Color.black);
        StrawberryFreshBtn.setFont(new Font("TimesRoman", Font.BOLD , 17));
        StrawberryFreshBtn.setBounds(610, 20, 130, 50);
        StrawberryFreshBtn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
                  addToReceipt("StrawberryFresh","Fresh Strawberry");
             }
           });
        MainPanel.add(StrawberryFreshBtn );
        
     //--------------------------------------------------------
        GuavaFreshBtn = new JButton("  جــوافة" );
        GuavaFreshBtn.setBackground(Color.ORANGE);
        GuavaFreshBtn.setForeground(Color.black);
        GuavaFreshBtn.setFont(new Font("TimesRoman", Font.BOLD , 17));
        GuavaFreshBtn.setBounds(130, 100, 130, 50);
        GuavaFreshBtn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
                  addToReceipt("GuavaFresh","Fresh Guava");
             }
           });
        MainPanel.add(GuavaFreshBtn );
      //--------------------------------------------------------
        WaterMelonFreshBtn  = new JButton("بطيــخ" );
        WaterMelonFreshBtn.setBackground(Color.pink);
        WaterMelonFreshBtn.setForeground(Color.black);
        WaterMelonFreshBtn.setFont(new Font("TimesRoman", Font.BOLD , 20));
        WaterMelonFreshBtn.setBounds(290, 100, 130, 50);
        WaterMelonFreshBtn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
                   addToReceipt("WaterMelonFresh","Fresh WaterMelon");
             }
           });
        MainPanel.add(WaterMelonFreshBtn );
      //-----------------------------------------------------
        KiwiFreshBtn  = new JButton("  كيــوي" );
        KiwiFreshBtn.setBackground(Color.red);
        KiwiFreshBtn.setForeground(Color.black);
        KiwiFreshBtn.setFont(new Font("TimesRoman", Font.BOLD , 20));
        KiwiFreshBtn.setBounds(450, 100, 130, 50);
        KiwiFreshBtn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
                   addToReceipt("KiwiFresh","Fresh Kiwi");
             }
           });
        MainPanel.add(KiwiFreshBtn);
      //-----------------------------------------------------
     
           PinappleFreshBtn  = new JButton("  أناناس" );
           PinappleFreshBtn.setBackground(Color.blue);
           PinappleFreshBtn.setForeground(Color.black);
           PinappleFreshBtn.setFont(new Font("TimesRoman", Font.BOLD , 20));
           PinappleFreshBtn.setBounds(610, 100, 130, 50);
           PinappleFreshBtn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
                  addToReceipt("PinappleFresh","Fresh Pinapple");
             }
           });
        MainPanel.add(PinappleFreshBtn );
        
        //-----------------------------------------------------
        CantaloupeFreshBtn  = new JButton("  كانتالــوب");
        CantaloupeFreshBtn.setBackground(Color.red);
        CantaloupeFreshBtn.setForeground(Color.black);
        CantaloupeFreshBtn.setFont(new Font("TimesRoman", Font.BOLD , 20));
        CantaloupeFreshBtn.setBounds(130, 180, 130, 50);
        CantaloupeFreshBtn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
                    addToReceipt("CantaloupeFresh","Fresh Cantaloupe");
             }
           });
        MainPanel.add( CantaloupeFreshBtn);
    //-----------------------------------------------------------   
        BananaFreshBtn = new JButton(" مــوز ");
        BananaFreshBtn.setBackground(Color.yellow);
        BananaFreshBtn.setForeground(Color.black);
        BananaFreshBtn.setFont(new Font("TimesRoman", Font.BOLD , 19));
        BananaFreshBtn.setBounds(290, 180, 130, 50);
        BananaFreshBtn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
                   addToReceipt("BananaFresh","Fresh   Banana");
             }
           });
        MainPanel.add(BananaFreshBtn);

        
    //------------------------------------------------------------
        PomegranateFreshBtn = new JButton(" رمــان");
        PomegranateFreshBtn.setBackground(Color.GREEN);
        PomegranateFreshBtn.setForeground(Color.black);
        PomegranateFreshBtn.setFont(new Font("TimesRoman", Font.BOLD , 20));
        PomegranateFreshBtn.setBounds(450, 180, 130, 50);
        PomegranateFreshBtn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
                  addToReceipt("PomegranateFresh","Fresh Pomegranate");
             }
           });
        MainPanel.add(PomegranateFreshBtn);
    //----------------------------------------------------------
        PeachFreshBtn = new JButton("خـــوخ  " );
        PeachFreshBtn.setBackground(Color.cyan);
        PeachFreshBtn.setForeground(Color.black);
        PeachFreshBtn.setFont(new Font("TimesRoman", Font.BOLD , 20));
        PeachFreshBtn.setBounds(610, 180, 130, 50);
        PeachFreshBtn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
                   addToReceipt("PeachFresh","Fresh Peach");
             }
           });
        MainPanel.add(PeachFreshBtn);
      
        
 //---------------------------------------------------------------------------
         MainPanel.revalidate(); // to invoke the layout manager
         MainPanel.repaint(); 
        
    }//GEN-LAST:event_FreshBtnActionPerformed

    private void ShishaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShishaBtnActionPerformed
        // TODO add your handling code here:
    JButton TopaccoBtn ;
    JButton FakherBtn ;
    JButton RedBullBtn ;
    JButton MixBtn ;
    JButton HoseBtn ;
    JButton CheeseShishaBtn ;
    JButton ChampagnBtn ;
            CocktailBtn.setBackground(cGray);
            ColdDrinksBtn.setBackground(cGray);
            DessertBtn.setBackground(cGray);
            HotCoffeeBtn.setBackground(cGray);
            SmothieBtn.setBackground(cGray);
            HotDrinksBtn.setBackground(cGray);
            MilkShakeBtn.setBackground(cGray);
            PlayStationBtn.setBackground(cGray);
            FreshBtn.setBackground(cGray);

         
        ShishaBtn.setBackground(Color.red);
        MainPanel.removeAll();
        MainPanel.invalidate();
        MainPanel.setPreferredSize(new Dimension(1132, 121));
         
        TopaccoBtn = new JButton(" توباكــو");
        TopaccoBtn.setBackground(Color.red);
        TopaccoBtn.setForeground(Color.black);
        TopaccoBtn.setFont(new Font("TimesRoman", Font.BOLD , 17));
        TopaccoBtn.setBounds(130, 20, 130, 50);
        TopaccoBtn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
                 addToReceipt("Topacco","Shisha Topacco");
             }
           });
        MainPanel.add(TopaccoBtn);
    //-----------------------------------------------------------   
        FakherBtn = new JButton(" فاخــر");
        FakherBtn.setBackground(Color.yellow);
        FakherBtn.setForeground(Color.black);
        FakherBtn.setFont(new Font("TimesRoman", Font.BOLD , 20));
        FakherBtn.setBounds(290, 20, 130, 50);
        FakherBtn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
                   addToReceipt("Fakher","Shisha  Fakher");
             }
           });
        MainPanel.add(FakherBtn);

    //------------------------------------------------------------
        RedBullBtn = new JButton("ريد بول");
        RedBullBtn.setBackground(Color.GREEN);
        RedBullBtn.setForeground(Color.black);
        RedBullBtn.setFont(new Font("TimesRoman", Font.BOLD , 20));
        RedBullBtn.setBounds(450, 20, 130, 50);
        RedBullBtn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
                   addToReceipt("RedBull","Shisha RedBull");
             }
           });
        MainPanel.add(RedBullBtn);
    //----------------------------------------------------------
        MixBtn = new JButton("مــيكس " );
        MixBtn.setBackground(Color.cyan);
        MixBtn.setForeground(Color.black);
        MixBtn.setFont(new Font("TimesRoman", Font.BOLD , 17));
        MixBtn.setBounds(610, 20, 130, 50);
        MixBtn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
                  addToReceipt("Mix","Shisha Mix");
             }
           });
        MainPanel.add(MixBtn );
        
     //--------------------------------------------------------
        HoseBtn   = new JButton("  لي طبــي" );
        HoseBtn.setBackground(Color.ORANGE);
        HoseBtn.setForeground(Color.black);
        HoseBtn.setFont(new Font("TimesRoman", Font.BOLD , 17));
        HoseBtn.setBounds(130, 100, 130, 50);
        HoseBtn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
                     addToReceipt("Hose","Hose");
             }
           });
        MainPanel.add(HoseBtn );
      //--------------------------------------------------------
        CheeseShishaBtn  = new JButton("تشيز كيك" );
        CheeseShishaBtn.setBackground(Color.pink);
        CheeseShishaBtn.setForeground(Color.black);
        CheeseShishaBtn.setFont(new Font("TimesRoman", Font.BOLD , 20));
        CheeseShishaBtn.setBounds(290, 100, 130, 50);
        CheeseShishaBtn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
                   addToReceipt("CheeseShisha","Shisha Cheese cake");
             }
           });
        MainPanel.add(CheeseShishaBtn );
      //-----------------------------------------------------
        ChampagnBtn  = new JButton("  شامبان" );
        ChampagnBtn.setBackground(Color.red);
        ChampagnBtn.setForeground(Color.black);
        ChampagnBtn.setFont(new Font("TimesRoman", Font.BOLD , 20));
        ChampagnBtn.setBounds(450, 100, 130, 50);
        ChampagnBtn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
                  addToReceipt("Champagn","Champagn");
             }
           });
        MainPanel.add(ChampagnBtn);
     
 //---------------------------------------------------------------------------
         MainPanel.revalidate(); // to invoke the layout manager
         MainPanel.repaint();  
    }//GEN-LAST:event_ShishaBtnActionPerformed

    private void PlayStationBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlayStationBtnActionPerformed
        // TODO add your handling code here:
   JButton Single1Btn ;
   JButton Multi1Btn ;
   
    
            DessertBtn.setBackground(cGray);
            MilkShakeBtn.setBackground(cGray);
            ColdDrinksBtn.setBackground(cGray);
            FreshBtn.setBackground(cGray);
            HotCoffeeBtn.setBackground(cGray);
            HotDrinksBtn.setBackground(cGray);
            CocktailBtn.setBackground(cGray);
            ShishaBtn.setBackground(cGray);
            SmothieBtn.setBackground(cGray);
            
            PlayStationBtn.setBackground(Color.red);
        
        MainPanel.removeAll();
        MainPanel.invalidate();
        MainPanel.setPreferredSize(new Dimension(1132, 121));
         
        Single1Btn = new JButton(" Single Player ");
        Single1Btn.setBackground(Color.red);
        Single1Btn.setForeground(Color.black);
        Single1Btn.setFont(new Font("TimesRoman", Font.BOLD , 20));
        Single1Btn.setBounds(130, 20, 200, 50);
        Single1Btn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
                   addToReceipt("single","Playstation Single");
    
             }
           });
         MainPanel.add(Single1Btn);
         
        //------------------------------------------------------------
        Multi1Btn = new JButton(" MultiPlayer ");
        Multi1Btn.setBackground(Color.yellow);
        Multi1Btn.setForeground(Color.black);
        Multi1Btn.setFont(new Font("TimesRoman", Font.BOLD , 20));
        Multi1Btn.setBounds(340, 20, 200, 50);
        Multi1Btn.addActionListener(new ActionListener()
          {
                 public void actionPerformed(ActionEvent e)
             {
                   addToReceipt("multi","Playstation Multi");
    
             }
           });
         MainPanel.add(Multi1Btn);
        //---------------------------------------------------------------------------
         MainPanel.revalidate(); // to invoke the layout manager
         MainPanel.repaint();  
    }//GEN-LAST:event_PlayStationBtnActionPerformed
 
    public boolean searchTxt(String str){
            int strStartPos = InvoiceTxtArea.getText().indexOf(str);
            if(strStartPos != -1)
                    return true;
            else{
                    return false;
        }    
    }
    
     public void replaceTxt(String str, int newHowMany, double price){
         try {
             
            int counter = -1;
            int counter2 = 0;
            char bracket = ')';
            char endOfLine = '\n';
            char tab = '\t';
            int charCount=0;
            int strStartPos = InvoiceTxtArea.getText().indexOf(str);
            int strLineNumber = InvoiceTxtArea.getLineOfOffset(strStartPos);
            int strLineEndNumber = InvoiceTxtArea.getLineEndOffset(strLineNumber);
            int howManyPos = InvoiceTxtArea.getLineStartOffset(strLineNumber)+1;
            String wholeTxt = InvoiceTxtArea.getText(howManyPos-1, strLineEndNumber-howManyPos);
            int amountPricePos = strLineEndNumber-6 , amountPricePosEnd ;
            Character bracket1 = new Character(bracket);
            Character endOfLine1 = new Character(endOfLine);
            Character tab1 = new Character(tab);
             
            for(int i = 0; i < wholeTxt.length() ; i++){
                Character wholeTxtChar = new Character(wholeTxt.charAt(i));
                if(wholeTxtChar.equals(bracket1)){
                  break;
                }else{
                  counter++;  
                }
            }
                      
            for(int i = howManyPos-1; i < strLineEndNumber  ; i++,charCount++){
             //   System.out.println("inside first for loope");
                if(charCount == wholeTxt.length()-1){
               //   System.out.println("inside first if condition");
              //    System.out.println("this is char 0 : "+wholeTxt.charAt(charCount));
                  for(int j = i; j > strLineNumber  ; j--,charCount--){
                 //    System.out.println("inside second for loope");
                     Character wholeTxtChar3 = new Character(wholeTxt.charAt(charCount));
               //      System.out.println(wholeTxt.charAt(charCount));
                         if(wholeTxtChar3.equals(tab1)){
                      //   System.out.println("inside second if condition");
                      //   System.out.println("this is start price : "+wholeTxt.charAt(charCount+1));
                         amountPricePos = j+1;
                     //    System.out.println("this is amount price position " + amountPricePos);
                         break;
                         }
                    }
                  // System.out.println("---------------------");
                   break;
            }
         }
            
            String howManyNumStr = InvoiceTxtArea.getText(howManyPos, counter);
            int howManyNum = Integer.parseInt(howManyNumStr);
            int newAmountNum = newHowMany+howManyNum;
            String newAmountStr = Integer.toString(newAmountNum);
                         //------------------------
            double newAmountPriceNum = newAmountNum*price;
            String newAmountPriceNumStr = Double.toString(newAmountPriceNum);
             
             
             //  System.out.println("------------");
            int  endAmountPricePos = amountPricePos+(strLineEndNumber-(amountPricePos)-1) ;
           
             InvoiceTxtArea.replaceRange(newAmountPriceNumStr, amountPricePos,endAmountPricePos );
            // System.out.println(endAmountPricePos);
            // System.out.println("this is amount price pos end : " + endAmountPricePos);
            // InvoiceTxtArea.replaceRange(newAmountPriceNumStr, amountPricePos, amountPricePos+5);
            // System.out.println("this is amount price pos end : " + amountPricePos+4);
             InvoiceTxtArea.replaceRange(newAmountStr, howManyPos, howManyPos+counter);
           
            
        } catch (BadLocationException ex) {
            Logger.getLogger(AntiqueFrame.class.getName()).log(Level.SEVERE, null, ex);
             ex.printStackTrace();
        }catch (Exception ez) {
               ez.printStackTrace();
        }
     }
 
    
    public void writeReciept(String receiptString, int HowMany, double price ){
           boolean textFound = searchTxt(receiptString);
           if(textFound == false){
               if(InvoiceTxtArea.getText().trim().equals("")){
                    Calendar cal = new GregorianCalendar();
                    int day = cal.get(Calendar.DAY_OF_MONTH);
                    int month = cal.get(Calendar.MONTH);
                    int year = cal.get(Calendar.YEAR);
                    DateFormat dateFormat = new SimpleDateFormat("hh:mm:aa");
    	            String dateString = dateFormat.format(new Date()).toString();
                    
                  InvoiceTxtArea.append("***---------------------------------------------------***\n");
                  InvoiceTxtArea.append("\tANTIQUE CAFE\n");
                  InvoiceTxtArea.append("Omar Bin Abdelaziz street\t" +day+"/"+month+"/"+ year+"\n");
                  InvoiceTxtArea.append("1064826660\t\t" + dateString+"\n");
                  InvoiceTxtArea.append("***---------------------------------------------------***\n");
                 // System.out.println("this is string length : "+receiptString.length());
                  if(receiptString.length() < 14){
                    InvoiceTxtArea.append("("+HowMany+")"+receiptString+"\t\t"+price*HowMany+"\n");
                  }else{ 
                    InvoiceTxtArea.append("("+HowMany+")"+receiptString+"\t"+price*HowMany+"\n");
                  }
                }else{
                  if(receiptString.length() < 14){
                    InvoiceTxtArea.append("("+HowMany+")"+receiptString+"\t\t"+price*HowMany+"\n");
                  }else{ 
                    InvoiceTxtArea.append("("+HowMany+")"+receiptString+"\t"+price*HowMany+"\n");
                  }
           }
        }else{
            replaceTxt(receiptString, HowMany, price);   
       }
           removeHighlights(InvoiceTxtArea);
    }
    
    
    
    
 public void addToReceipt(String item, String receiptString){
    try {
        JButton[] btns = {OneBtn, TwoBtn,ThreeBtn,FourBtn,FiveBtn,SixBtn,SevenBtn,EightBtn,NineBtn,TenBtn};
        Database database = new Database();
        database.getPrice(item);
        Double price = database.getVar(); 
        int HowMany = 1;
        int flag = 0;
          for(int i = 0; i <= 9; i++){
             if (btns[i].getBackground() == Color.red){
                  HowMany = i+1 ;
                  flag = 1;
                  writeReciept(receiptString,HowMany,price);
                    }        
                }if(flag == 0){
                       HowMany = 1 ;
                   writeReciept(receiptString,HowMany,price);
                    }
                
        totalReciept += price*HowMany;
        TotalRecieptLbl.setText("Total Reciept: " + totalReciept);
        addToInventory(item,HowMany);  
        addToNameMap(receiptString,item);
                            
        } catch (SQLException ex) {
             Logger.getLogger(AntiqueFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
 }    
 
 public void addToNameMap(String receiptString, String  item){
      if(NameMap.isEmpty() || !(NameMap.containsKey(item)) ){
          NameMap.put(receiptString, item);
      }
 }   
    
 public void addToInventory(String item, int HowMany){
      if(InventoryMap.isEmpty() || !(InventoryMap.containsKey(item)) ){
          InventoryMap.put(item, HowMany );
      }else{
          int newVal = InventoryMap.get(item);
          InventoryMap.replace(item, HowMany+newVal);
           }
 }   
 

 

 public void colorizeBtn(JButton btn){
   JButton[] btns = {OneBtn, TwoBtn,ThreeBtn,FourBtn,FiveBtn,SixBtn,SevenBtn,EightBtn,NineBtn,TenBtn};
   for(int i =0; i < btns.length; i++){   
      if(btns[i] == btn){
         btns[i].setBackground(Color.red);
      }else{
         btns[i].setBackground(cGray);
      }
   }
 }
    
    private void TwoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TwoBtnActionPerformed

        colorizeBtn(TwoBtn);
    }//GEN-LAST:event_TwoBtnActionPerformed

    private void ThreeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThreeBtnActionPerformed
        // TODO add your handling code here:
          colorizeBtn(ThreeBtn);
    }//GEN-LAST:event_ThreeBtnActionPerformed

    private void FourBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FourBtnActionPerformed
        // TODO add your handling code here:
          colorizeBtn(FourBtn);
    }//GEN-LAST:event_FourBtnActionPerformed

    private void SevenBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SevenBtnActionPerformed
        // TODO add your handling code here:
         colorizeBtn(SevenBtn);
    }//GEN-LAST:event_SevenBtnActionPerformed

    private void FiveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FiveBtnActionPerformed
        // TODO add your handling code here:
         colorizeBtn(FiveBtn); 
    }//GEN-LAST:event_FiveBtnActionPerformed

    private void SixBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SixBtnActionPerformed
        // TODO add your handling code here:
        colorizeBtn(SixBtn);
    }//GEN-LAST:event_SixBtnActionPerformed

    private void OneBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OneBtnActionPerformed
        // TODO add your handling code here:EightBtn.setBackground(cGray);
        colorizeBtn(OneBtn);
        
    }//GEN-LAST:event_OneBtnActionPerformed

    public void disableNumberBtns(){
        JButton[] btns = {OneBtn, TwoBtn,ThreeBtn,FourBtn,FiveBtn,SixBtn,SevenBtn,EightBtn,NineBtn,TenBtn};
         for(int i =0; i <= btns.length; i++){ 
          btns[i].setBackground(cGray);
         }   
    }
    
    
    private void ResetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetBtnActionPerformed
        // TODO add your handling code here:
        System.out.println(InvoiceTxtArea.getText());
        InvoiceTxtArea.setText(" ");
        totalReciept = 0.0;
        TotalRecieptLbl.setText("Total Reciept: " + totalReciept);
        InventoryMap.clear();
    }//GEN-LAST:event_ResetBtnActionPerformed

    private void BackBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackBtnActionPerformed
        // TODO add your handling code here:
            CocktailBtn.setBackground(cGray);
            ColdDrinksBtn.setBackground(cGray);
            DessertBtn.setBackground(cGray);
            HotCoffeeBtn.setBackground(cGray);
            SmothieBtn.setBackground(cGray);
            HotDrinksBtn.setBackground(cGray);
            MilkShakeBtn.setBackground(cGray);
            PlayStationBtn.setBackground(cGray);
            FreshBtn.setBackground(cGray);
            ShishaBtn.setBackground(cGray);
            
        MainPanel.removeAll();
        MainPanel.invalidate();
        MainPanel.setPreferredSize(new Dimension(1132, 121));
         //------------------------------------------------------------
          InventoryBtn.setVisible(true);
          MainPanel.add(InventoryBtn);
         //------------------------------------------------------------
          ChangedCategory.setVisible(true);
          MainPanel.add(ChangedCategory);
         //------------------------------------------------------------
          chooseCategoryLbl.setVisible(true);
          MainPanel.add(chooseCategoryLbl);
         //------------------------------------------------------------
          ChangePriceLbl.setVisible(true);
          MainPanel.add(ChangePriceLbl);
         //------------------------------------------------------------
          MainLabel.setText("TODAY TOTAL : "+ todayTotal);
          MainLabel.setVisible(true);
          MainPanel.add(MainLabel);
        
        //------------------------------------------------------------------
         MainPanel.revalidate(); // to invoke the layout manager
         MainPanel.repaint();     
    }//GEN-LAST:event_BackBtnActionPerformed

    private void InventoryBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InventoryBtnActionPerformed
        // TODO add your handling code here:
        MainPanel.removeAll();
        MainPanel.invalidate();
        MainPanel.setPreferredSize(new Dimension(1132, 121));
        
        double InventoryTotalPrice = 0.0 ;
        
        JLabel InventoryLbl = new JLabel("الجــرد اليومــي");
        InventoryLbl.setFont(new Font("Times Roman", Font.BOLD, 44));
        InventoryLbl.setBounds(380, 10, 400, 80);
        InventoryLbl.setForeground(Color.BLACK);
        MainPanel.add(InventoryLbl);

        Database database = new Database();
        String[] columns = {"الصنف","العدد","سعر فردي","سعر كلي"};
        int counter1=0, rows = RecieptInventoryMap.size();
        String data[][] = new String[rows][4];  
        
        for (Map.Entry<String, Integer> entry : RecieptInventoryMap.entrySet()) {
          try{
          String item = entry.getKey();
          int number = entry.getValue();
          database.getPrice(item);
          Double price = database.getVar(); 
          Double totalPrice = price*number;
          InventoryTotalPrice += totalPrice;
                  
          for (Map.Entry<String, String> entry2 : ChangePriceMap.entrySet()) {
              if (entry2.getValue().equals(item)) {
                item = entry2.getKey();
            }
          }
          //-----------------
          String strNumber = Integer.toString(number);
          String strPrice = Double.toString(price);
          String strTotalPrice = Double.toString(totalPrice);
          data[counter1][0] = item;
          data[counter1][1] = strNumber;
          data[counter1][2] = strPrice;
          data[counter1][3] = strTotalPrice;
          counter1++;
          }catch(Exception e){
          e.printStackTrace();
          }
        }
        
        JTable InventoryTable = new JTable(data,columns);  
        InventoryTable.setFont(new Font("Times Roman", Font.BOLD, 12));
        JScrollPane sp = new JScrollPane();
        sp.setViewportView( InventoryTable );
        sp.setBounds(100,100,800,300);
        MainPanel.add(sp);
        
        JLabel InventoryTotalPriceLbl = new JLabel();
        InventoryTotalPriceLbl.setFont(new Font("Times Roman", Font.BOLD, 20));
        InventoryTotalPriceLbl.setBounds(100, 370, 200, 80);
        InventoryTotalPriceLbl.setForeground(Color.BLACK);
        InventoryTotalPriceLbl.setText("Total Price : " + InventoryTotalPrice);
        MainPanel.add(InventoryTotalPriceLbl);

        //----------------------------------------------------------
        MainPanel.revalidate(); // to invoke the layout manager
        MainPanel.repaint();     
    }//GEN-LAST:event_InventoryBtnActionPerformed

    
    
    
    public void changePrice(JComboBox cmb){
        
         Database db = new Database();
         String chosenTxt = (String)cmb.getSelectedItem().toString();
         int input = JOptionPane.showConfirmDialog(null,"هل تريد تغيير سعر "+chosenTxt+ "؟"); 
         if(input==0){
         String newPrice = JOptionPane.showInputDialog(null, "من فضلك أدخل رقم عشري");
         double newPriceDouble = Double.parseDouble(newPrice);
         String DBName = ChangePriceMap.get(chosenTxt);
         db.setPrice(newPriceDouble, DBName);  
       }
    }
    
    public void disappearCMB(JComboBox cmb){
    if(!(comboboxes.isEmpty())){
      for(JComboBox cmbBox : comboboxes){
            if(cmbBox == cmb ){
                //System.out.println("2");
                //continue;
            }else{
               //System.out.println("3");
               cmbBox.setVisible(false);
            }
         }
      }
   }
    
    public void addToComboboxesList(JComboBox cmb){
        if(comboboxes.isEmpty() || !(comboboxes.contains(cmb))){
                    comboboxes.add(cmb);
                    System.out.println("1");
         }
    }
                       
    private void ChangedCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChangedCategoryActionPerformed
        // TODO add your handling code here:
        String chosenTxt = (String)ChangedCategory.getSelectedItem().toString();
        Database db = new Database();
        JComboBox smothieCMB,hotCoffeCMB,hotDrinkCMB,coldDrinkCMB,milkShakeCMB,dessertCMB,cocktailCMB,
                                   freshCMB,shishaCMB,playStationCMB; 
        switch(chosenTxt){ 
            
            case "ديــزيرت":
                 String[] dessertArr = {"تشيز لافر","أوريو مادنيس","فروت سالاد","فروت سالاد بالأيس كريم","شوكلت فادج","ريتش شوكلت كيك",
                                         "بانانا سبليت","أوريو أيس كريم","أيس كريم فواكه","أيس كريم بولة"};
                dessertCMB = new JComboBox(dessertArr);
                dessertCMB.setBounds(50, 250, 210, 40);
                dessertCMB.setFont(new Font("Tahoma", Font.BOLD, 12));
                addToComboboxesList(dessertCMB);
                disappearCMB(dessertCMB);
                dessertCMB.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                   /* if(comboboxes.isEmpty() || !(comboboxes.contains(dessertCMB))){
                    comboboxes.add(dessertCMB);
                     System.out.println("5");
                    }
                    */
                       changePrice(dessertCMB);
                    }
                });
                MainPanel.add(dessertCMB);
                break;
                
            case "سموذي":
                String[] smothieArr = {"سموذي موز","سموذي فراولــة","سموذي كانتالوب","سموذي جوافة","سموذي أناناس","سموذي خوخ",
                                       "سموذي بطيــخ" ,"سموذي كيوــي"};
                smothieCMB = new JComboBox(smothieArr);
                smothieCMB.setBounds(50, 250, 210, 40);
                smothieCMB.setFont(new Font("Tahoma", Font.BOLD, 12));
                addToComboboxesList(smothieCMB);
                disappearCMB(smothieCMB);
                smothieCMB.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    changePrice(smothieCMB);
                    }
                });
                MainPanel.add(smothieCMB);
                break;
                
            case "قهوة ساخنة":
                String[] hotCoffeArr = {"إسبريســو سينجل","إسبريســو دبل","كابوتشينو","أيريش كابوتشينو","فانيليا كابوتشينو",
                                         "كافيه لاتيــه","كاراميل لاتيـه","أيريش لاتيـه","فانيليا لاتيــه","قهوة شوكولاتة","قهوة لــوز",
                                         "قهوة بندق","ماكياتــو","أميريكان كوفي","موكا كافية","قهوة تركي سينجل","قهوة تركي دبل"};
                hotCoffeCMB = new JComboBox(hotCoffeArr);
                hotCoffeCMB.setBounds(50, 250, 210, 40);
                hotCoffeCMB.setFont(new Font("Tahoma", Font.BOLD, 12));
                addToComboboxesList(hotCoffeCMB);
                disappearCMB(hotCoffeCMB);
                hotCoffeCMB.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                       changePrice(hotCoffeCMB);
                    }
                });
                MainPanel.add(hotCoffeCMB);
                break;
               
            case "مشروبات ساخنة":
                String[] hotDrinkArr = { "شـــاي","شــاي فواكه","ينسون/نعناع/قرفة/كركديه","سحلــب",
                                           "سحـلـب فواكه" ,"هوت سبايدر"};
                hotDrinkCMB = new JComboBox(hotDrinkArr);
                hotDrinkCMB.setBounds(50, 250, 210, 40);
                hotDrinkCMB.setFont(new Font("Tahoma", Font.BOLD, 12));
                addToComboboxesList(hotDrinkCMB);
                disappearCMB(hotDrinkCMB);
                hotDrinkCMB.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                        changePrice(hotDrinkCMB);
                    }
                });
                MainPanel.add(hotDrinkCMB);
                break;
                
            case "مشروبات باردة":
                 String[] coldDrinkArr = {"شوكولاتة باردة","إسبريسـو+ ثلج","أيس موكا","ليمــون","زبادي عسـل","زبادي فواكــه",
                                          "بوريــو","بيبســـي","فيـــروز","بيريــل","ميــاه"};
                 
                 
                coldDrinkCMB = new JComboBox(coldDrinkArr);
                coldDrinkCMB.setBounds(50, 250, 210, 40);
                coldDrinkCMB.setFont(new Font("Tahoma", Font.BOLD, 12));
                addToComboboxesList(coldDrinkCMB);
                disappearCMB(coldDrinkCMB);
                coldDrinkCMB.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                            changePrice(coldDrinkCMB);
                    }
                });
                MainPanel.add(coldDrinkCMB);
                break;
               
            case "ميلك شيك":
                String[] milkShakeArr = {"ميلك شيك فراولــة","ميلك شيك فانيليا","ميلك شيك مانـجو","ميلك شيك شوكولاتــة",
                                           "ميلك شيك أناناس", "ميلك شيك خــوخ"};
                milkShakeCMB = new JComboBox(milkShakeArr);
                milkShakeCMB.setBounds(50, 250, 210, 40);
                milkShakeCMB.setFont(new Font("Tahoma", Font.BOLD, 12));
                addToComboboxesList(milkShakeCMB);
                disappearCMB(milkShakeCMB);
                milkShakeCMB.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                          changePrice(milkShakeCMB);  
                          
                    }
                });
                MainPanel.add(milkShakeCMB);
                break;
                
                
            case "كوكتــيل":
                String[] cocktailArr = {"ليمون نعنــاع","إختر كوكتيلك","جـريــن سكاي","كلاسيــك بيانو","فلــوريدا","بارادايـس",
                                         "فروت زوم","صن شايـــن","زبادي فواكه","بلو هاواي","خوخ أناناس","تروبيكانا","موز فراولــة",
                                          "باور","صن شايـن برتقال","تودو أيس","توينكيـز","هوهــوز","سنيكرز","بوريو موز","ويفـــر",
                                          "ستروبيري إنيرجي","موز كراميل","خوخ أناناس","ديلايت تفاح خوخ","شيري كـوك"};
                cocktailCMB = new JComboBox(cocktailArr);
                cocktailCMB.setBounds(50, 250, 210, 40);
                cocktailCMB.setFont(new Font("Tahoma", Font.BOLD, 12));
                addToComboboxesList(cocktailCMB);
                disappearCMB(cocktailCMB);
                cocktailCMB.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                       changePrice(cocktailCMB);
                    }
                });
                MainPanel.add(cocktailCMB);
                break;
                
            case "فريــــش":
                  String[] freshArr = {"برتــقال فريش","ليــمون فريش","مانجـــو فريش","فراولــة فريش","جــوافة فريش","بطيــخ فريش",
                                       "كيــوي فريش","أناناس فريش","كانتالــوب فريش","مــوز فريش","رمــان فريش","خـــوخ فريش"};
                freshCMB = new JComboBox( freshArr);
                freshCMB.setBounds(50, 250, 210, 40);
                freshCMB.setFont(new Font("Tahoma", Font.BOLD, 12));
                addToComboboxesList(freshCMB);
                disappearCMB(freshCMB);
                freshCMB.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                          changePrice(freshCMB);
                    }
                });
                MainPanel.add(freshCMB);
                break;
                
            case "شيشــة":
                String[] shishaArr = {"توباكــو","فاخــر","ريد بول","مــيكس","لي طبــي","تشيز كيك","شامبان"};
                shishaCMB = new JComboBox(shishaArr);
                shishaCMB.setBounds(50, 250, 210, 40);
                shishaCMB.setFont(new Font("Tahoma", Font.BOLD, 12));
                addToComboboxesList(shishaCMB);
                disappearCMB(shishaCMB);
                shishaCMB.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                         changePrice(shishaCMB);
                    }
                });
                MainPanel.add(shishaCMB);
                break;
                
            case "بلايستيـشن":
                String[] playStationArr = { "بلايستيشن سينجل", "بلايستيشن مالتي" };
                playStationCMB = new JComboBox(playStationArr);
                playStationCMB.setBounds(50, 250, 210, 40);
                playStationCMB.setFont(new Font("Tahoma", Font.BOLD, 12));
                addToComboboxesList(playStationCMB);
                disappearCMB(playStationCMB);
                playStationCMB.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                         changePrice(playStationCMB);
                    }
                });
                MainPanel.add(playStationCMB);
                break;
            default:

        }    
    }//GEN-LAST:event_ChangedCategoryActionPerformed

    public void decreaseOrder(String string){
     try {
            int counter = -1;
            int counter2 = 0;
            char bracket = ')';
            char endOfLine = '\n';
            char tab = '\t';
            int charCount=0;
            int stringStartIndex = InvoiceTxtArea.getText().indexOf(string);
            int stringLineNumber = InvoiceTxtArea.getLineOfOffset(stringStartIndex);
            int stringLineEndNumber = InvoiceTxtArea.getLineEndOffset(stringLineNumber);
            
            int howManyOrders = InvoiceTxtArea.getLineStartOffset(stringLineNumber)+1;
            int amountPricePos = stringLineEndNumber-6 , amountPricePosEnd ;
        
            System.out.println("this is end line position : " + stringLineEndNumber);
           // System.out.println("this is end line position : " + stringLineEndNumber);
            
            Character bracket2 = new Character(bracket);
            Character endOfLine2 = new Character(endOfLine);
            Character tab2 = new Character(tab);
            
            
            for(int i = 0; i < string.length() ; i++){
                Character wholeTxtChar = new Character(string.charAt(i));
                if(wholeTxtChar.equals(bracket2)){
                  break;
                }else{
                  counter++;  
                }
            }
             
             
             int loopVar = stringStartIndex+2+counter;
             int counter3 = stringStartIndex+1+counter;
             
             for(int i =0 ; counter3  < stringLineEndNumber ; i++,counter3++){
                 Character currentChar = new Character(string.charAt(i));
                 if(currentChar.equals(tab2)){
                     break;
                 }
              }
             String itemName = InvoiceTxtArea.getText(loopVar,counter3-loopVar-2);
             System.out.println("this is item name : "+"H"+itemName+"H");
          //   System.out.println("this is item name :" +itemName+"hello");
                      
            for(int i = stringStartIndex; i < stringLineEndNumber  ; i++,charCount++){
                if(charCount == string.length()-1){
                  for(int j = i; j > stringLineNumber  ; j--,charCount--){
                     Character wholeTxtChar3 = new Character(string.charAt(charCount));
                         if(wholeTxtChar3.equals(tab2)){
                         amountPricePos = j+1;
                         break;
                         }
                    }
                   break;
            }
         }
            
            String howManyNumStr = InvoiceTxtArea.getText(howManyOrders, counter);
            System.out.println("this is original how many : " + howManyNumStr);
            int howManyNum = Integer.parseInt(howManyNumStr);
            
            if(howManyNum != 1 && howManyNum > 0){
                
            int newAmountNum = howManyNum-1;
            String newAmountStr = Integer.toString(newAmountNum);
            InvoiceTxtArea.replaceRange(newAmountStr, howManyOrders, howManyOrders+counter);
                         //------------------------
            System.out.println("this is new how many : " + newAmountNum);
            System.out.println("this is amount position : " + amountPricePos);
             
            int  endAmountPricePos = amountPricePos+(stringLineEndNumber-(amountPricePos)-1) ;
            System.out.println("this is end amount position : " + endAmountPricePos);
            
            String priceNum = InvoiceTxtArea.getText(amountPricePos, endAmountPricePos-amountPricePos);
            System.out.println("this is original price number : " + priceNum);
            double priceNumDouble = Double.parseDouble(priceNum);
            priceNumDouble = (priceNumDouble/howManyNum);
            priceNumDouble *= newAmountNum;
            System.out.println("this is new price number : " + priceNumDouble);
            String newPriceNum = Double.toString(priceNumDouble);
            
            String DBName = NameMap.get(itemName);
            System.out.println(DBName) ;
            System.out.println(InventoryMap.get(DBName)) ;
           // int OldValue = InventoryMap.get(DBName);
            InventoryMap.replace(DBName, newAmountNum);
          //  addToInventory(DBName, newAmountNum);
            System.out.println(InventoryMap.get(DBName)) ;
            
            InvoiceTxtArea.replaceRange(newPriceNum, amountPricePos,endAmountPricePos );
            
            priceNumDouble /= newAmountNum;
            System.out.println(totalReciept);
            totalReciept = totalReciept-priceNumDouble;
            System.out.println(totalReciept);
            TotalRecieptLbl.setText("Total Reciept: " + totalReciept);
        
            }else{
               JOptionPane.showMessageDialog(null, "لا يمكن إلغاء طلب واحد فقط");
            }
            
        } catch (BadLocationException ex) {
            Logger.getLogger(AntiqueFrame.class.getName()).log(Level.SEVERE, null, ex);
             ex.printStackTrace();
        }catch (Exception ez) {
               ez.printStackTrace();
        }

    }
    
    
    private void removeOrderBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeOrderBtnActionPerformed
        // TODO add your handling code here:
       try{
       Highlighter hilite = InvoiceTxtArea.getHighlighter();
       Highlighter.Highlight[] hilites = hilite.getHighlights();
          if(hilites != null && hilites.length > 0){
            System.out.println("im in highlight");
            for(int i =0; i<hilites.length;i++){
              Highlighter.Highlight h = hilites[i] ;
              int textStartOffset = h.getStartOffset();
              int textEndOffset = h.getEndOffset();
              System.out.println(textStartOffset+"\n"+textEndOffset+"\n");
              String text = InvoiceTxtArea.getText(textStartOffset,textEndOffset-textStartOffset);
               System.out.println(text);
               decreaseOrder(text);
            }
          }else{
            System.out.println("text is null");
            }
         }catch(BadLocationException ble) { 
        System.out.println(ble);
       }
    }//GEN-LAST:event_removeOrderBtnActionPerformed
    
    
    private void PrintBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrintBtn1ActionPerformed
        // TODO add your handling code here:
        
        try{
        todayTotal += totalReciept;
        totalReciept = 0.00;
        MainLabel.setText("TODAY TOTAL : "+ todayTotal);
        TotalRecieptLbl.setText("Total Reciept: " + totalReciept);
        
        for(Map.Entry<String, Integer>entry :InventoryMap.entrySet() ){
        // RecieptInventoryMap.putAll(InventoryMap);
            if(RecieptInventoryMap.containsKey(entry.getKey())){
               int oldVal =  RecieptInventoryMap.get(entry.getKey());
               RecieptInventoryMap.replace(entry.getKey(),entry.getValue()+oldVal);
            }else{
               RecieptInventoryMap.put(entry.getKey(), entry.getValue());
            }
        }
        
        InventoryMap.clear();
        
        PrintReceipt printerOrder = new PrintReceipt();
        System.out.println(printerOrder.getPrinters());		
	//print some stuff "EPSON-TM-T20II"
	printerOrder.printString("Microsoft XPS Document Writer", InvoiceTxtArea.getText());
        InvoiceTxtArea.setText("");
        
        }catch(NumberFormatException e){
        e.printStackTrace();
        }
 
    }//GEN-LAST:event_PrintBtn1ActionPerformed
 
    public static void removeHighlights(JTextComponent textComp) {
    Highlighter hilite = textComp.getHighlighter();
    Highlighter.Highlight[] hilites = hilite.getHighlights();

    for (int i = 0; i < hilites.length; i++) {
      if (hilites[i].getPainter() instanceof HighlightPainter) {
        hilite.removeHighlight(hilites[i]);
      }
    }
  } 
    
    
    private void InvoiceTxtAreaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InvoiceTxtAreaMouseClicked

    try{
        removeHighlights(InvoiceTxtArea);
        int offset = InvoiceTxtArea.getCaretPosition();
        int line = InvoiceTxtArea.getLineOfOffset(offset);
        int lineStart = InvoiceTxtArea.getLineStartOffset(line);
        int lineEnd = InvoiceTxtArea.getLineEndOffset(line);

        Highlighter.HighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter( Color.cyan );
        InvoiceTxtArea.getHighlighter().addHighlight(lineStart, lineEnd, painter);
 
    }catch(BadLocationException ble) { 
        System.out.println(ble);
       }
  
    }//GEN-LAST:event_InvoiceTxtAreaMouseClicked

 //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------  
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AntiqueFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AntiqueFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AntiqueFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AntiqueFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AntiqueFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackBtn;
    private javax.swing.JLabel ChangePriceLbl;
    private javax.swing.JComboBox ChangedCategory;
    private javax.swing.JButton CocktailBtn;
    private javax.swing.JButton ColdDrinksBtn;
    private javax.swing.JButton DessertBtn;
    private javax.swing.JButton EightBtn;
    private javax.swing.JButton FiveBtn;
    private javax.swing.JButton FourBtn;
    private javax.swing.JButton FreshBtn;
    private javax.swing.JButton HotCoffeeBtn;
    private javax.swing.JButton HotDrinksBtn;
    private javax.swing.JButton InventoryBtn;
    private javax.swing.JTextArea InvoiceTxtArea;
    private javax.swing.JLabel MainLabel;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JButton MilkShakeBtn;
    private javax.swing.JButton NineBtn;
    private javax.swing.JButton OneBtn;
    private javax.swing.JButton PlayStationBtn;
    private javax.swing.JButton PrintBtn1;
    private javax.swing.JButton ResetBtn;
    private javax.swing.JButton SevenBtn;
    private javax.swing.JButton ShishaBtn;
    private javax.swing.JButton SixBtn;
    private javax.swing.JButton SmothieBtn;
    private javax.swing.JButton TenBtn;
    private javax.swing.JButton ThreeBtn;
    private javax.swing.JLabel TimeLbl;
    private javax.swing.JLabel TotalRecieptLbl;
    private javax.swing.JButton TwoBtn;
    private javax.swing.JLabel chooseCategoryLbl;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton removeOrderBtn;
    // End of variables declaration//GEN-END:variables
   
   
                            


    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
