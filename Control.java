import java.util.*;

public class Control {


    public static void main(String[] args) {
        Restaurant BigChill = new Authentic("BigChill", "GK2", 0, "Authentic");
        Restaurant BigWong = new Authentic("BigWong", "Epicuria", 0, "Authentic");
        Restaurant PizzaHut = new NormalRestaurant("PizzaHut", "CHD", 0, "Regular");
        Restaurant McDonalds = new FastFood("McDonalds", "Sector26", 0, "Fast Food");
        Restaurant Subway = new FastFood("Subway", "Sector 35", 0, "Fast Food1");

        EliteCustomer Dhairya = new EliteCustomer("Dhairya", "Delhi","Elite");
        EliteCustomer Jishnu = new EliteCustomer("Jishnu", "Assam","Elite");
        SpecialCustomer Rishit = new SpecialCustomer("Rishit", "Chandigarh","Special");
        SpecialCustomer Krish = new SpecialCustomer("Krish", "Chandigarh","Special");
        NormalCustomer Utkarsh = new NormalCustomer("Utkarsh", "Kanpur","Regular");
        Scanner input = new Scanner(System.in);
        while (true) {
            Menu printmenu = new Menu();
            printmenu.introMenu();
            int i = input.nextInt();
            if (i == 1) {
                printmenu.resMenu();
                int res_no = input.nextInt();
                while (true) {
                    printmenu.OwnerFirstMenu(res_no);
                    int owner_fn = input.nextInt();
                    Owner owner=new Owner();
                    if (owner_fn == 1) {
                            System.out.println("Enter food item details");
                            System.out.println("Food name:");
                            String food=input.next();
                            System.out.println("item price");
                            int p=input.nextInt();
                            System.out.println("item quantity");
                            int q=input.nextInt();
                             System.out.println("item category");
                            String category=input.next();
                            System.out.println("Offer");
                            int offer=input.nextInt();
                            String Restaurant_name=Restaurant.getRestaurantArrayList().get(res_no-1).getName();
                            owner.addItem(food,p,q,category,offer,res_no,Restaurant_name);

                    }
                    if (owner_fn == 2) {
                        System.out.println("Choose item by code");
                        Restaurant rest1= Restaurant.getRestaurantArrayList().get(res_no-1);
                        for(int j=0;j<rest1.cart.size();j++){
                            System.out.println(rest1.cart.get(j).getRego_id()+" "+rest1.cart.get(j).getName() +" "+rest1.cart.get(j).getPrice()+" "+ rest1.cart.get(j).getQuantity()+" "+ rest1.cart.get(j).getOffer()+"% off "+ rest1.cart.get(j).getCategory());
                        }
                        int item_no= input.nextInt();
                        System.out.println("Choose an attribute to edit:");
                        System.out.println("1) Name");
                        System.out.println("2) Price");
                        System.out.println("3) Quantity");
                        System.out.println("4) Category");
                        System.out.println("5) Offer");
                        int atr_no=input.nextInt();
                        if(atr_no==1){
                            System.out.println("Enter the new name - ");
                            String na1=input.next();
                            rest1.cart_hash.get(item_no).setName(na1);
                        }
                        if(atr_no==2){
                            System.out.println("Enter the new price - ");
                            int pri=input.nextInt();
                            rest1.cart_hash.get(item_no).setPrice(pri);

                        }
                        if(atr_no==3){
                            System.out.println("Enter the new quantity - ");
                            int quan=input.nextInt();
                            rest1.cart_hash.get(item_no).setQuantity(quan);
                        }
                        if(atr_no==4){
                            System.out.println("Enter the new category - ");
                            String na2=input.next();
                            rest1.cart_hash.get(item_no).setCategory(na2);
                        }
                        if(atr_no==5){
                            System.out.println("Enter the new offer - ");
                            int off=input.nextInt();
                            rest1.cart_hash.get(item_no).setOffer(off);
                        }
                        System.out.println(rest1.cart_hash.get(item_no).getRego_id()+" "+rest1.cart_hash.get(item_no).getName() +" "+rest1.cart_hash.get(item_no).getPrice()+" "+ rest1.cart_hash.get(item_no).getQuantity()+" "+ rest1.cart_hash.get(item_no).getOffer()+"% off "+ rest1.cart_hash.get(item_no).getCategory());
//                        owner.editItem(item_no,atr_no);
                    }
                    if (owner_fn == 3) {
                        Restaurant rest1=Restaurant.getRestaurantArrayList().get(res_no-1);
                        System.out.println("Reward Points: "+(int)rest1.getResRewards());
//                        owner.printrewards();
                    }
                    if (owner_fn == 4) {
                        System.out.println("Offer on bill value - ");
                        Restaurant rest1=Restaurant.getRestaurantArrayList().get(res_no-1);
                        int billvalue=input.nextInt();
                        rest1.setTotalBillDiscount(billvalue);
                        owner.discountOnBill();
                    }
                    if (owner_fn == 5) {
                            break;
                    }
                }
            }

            if (i == 2) {
                printmenu.cusList();
                int cus_no=input.nextInt();
                   int cafeno=-1;
                while(true) {
                        printmenu.CustomerMenu(cus_no);
//                        int a3resno=-2;
                        int customer_fn=input.nextInt();
                        if(customer_fn==1){
                            printmenu.resMenu();
                            int a3=input.nextInt();
                            cafeno=a3;
                             Customer.getCustomerArrayList().get(cus_no-1).selectRestaurant(printmenu,cus_no,a3);
                        }
                        if(customer_fn==2){
                            Customer.getCustomerArrayList().get(cus_no-1).checkoutCart(cus_no,cafeno);
                        }
                        if(customer_fn==3){
                            Customer.getCustomerArrayList().get(cus_no-1).printrewards(cus_no);
                        }
                        if(customer_fn==4){
                            Customer.getCustomerArrayList().get(cus_no-1).printRecents();
                        }
                        if(customer_fn==5){
                            break;
                        }



                }
            }

            if(i == 3){
                printmenu.UserDetailsMenu();
                int r=input.nextInt();
                if(r==1){
                    printmenu.cusList();
                    int cus_no=input.nextInt();
                    System.out.println(Customer.getCustomerArrayList().get(cus_no-1).getName()+"("+Customer.getCustomerArrayList().get(cus_no-1).getType()+") ,"+Customer.getCustomerArrayList().get(cus_no-1).getAddress()+", "+Customer.getCustomerArrayList().get(cus_no-1).getWallet()+"/-");
                }
                else{
                    printmenu.resMenu();
                    int res_no=input.nextInt();
                    System.out.println(Restaurant.getRestaurantArrayList().get(res_no-1).getName()+", "+Restaurant.getRestaurantArrayList().get(res_no-1).getAddress()+", "+Restaurant.getRestaurantArrayList().get(res_no-1).getNumOfOrders());

                }

            }

            if (i == 4) {
                System.out.println("Total Company balance - INR "+ Restaurant.getAllResRewards()/100+"/-");
                System.out.println("Totatl Delivery Charges Collected - INR "+Customer.getCustomerArrayList().get(0).getTotalDeliveryCharge()+"/-");

            }

            if (i == 5) {
                break;
            }

        }
    }
}
abstract interface User{
    abstract void printrewards(int cus_no);
    abstract void search();
}


class Customer implements User{

    Scanner input=new Scanner(System.in);
    private final String name;
    private final String address;

    private float wallet;
    private int deliveryCharge;
    private int discountOnOrders200;
    private static int TotalDeliveryCharge;
    private static ArrayList<Customer> customerArrayList =new ArrayList<Customer>();
    private float rewardWallet;
    private String type;

    public int getTotalDeliveryCharge() {
        return TotalDeliveryCharge;
    }

    public void setTotalDeliveryCharge(int totalDeliveryCharge) {
        TotalDeliveryCharge = totalDeliveryCharge;
    }

    private Queue <MyOrder> queue=new LinkedList<>();

    protected String getName(){
        return name;
    }

    protected float getWallet(){
        return wallet;
    }

    protected void setWallet(float wallet){
        this.wallet=wallet;
    }

    protected float getRewardWallet(){
        return rewardWallet;
    }

    protected void setRewardWallet(float rewardWallet){
        this.rewardWallet=rewardWallet;
    }

    public static ArrayList<Customer> getCustomerArrayList(){
        return customerArrayList;
    }
    public void addElementCustomerArrayList(Customer customer){
        customerArrayList.add(customer);
    }

    protected int getDeliveryCharge() {
        return deliveryCharge;
    }

    protected void setDeliveryCharge(int deliveryCharge) {
        this.deliveryCharge = deliveryCharge;
    }

    protected int getDiscountOnOrders200() {
        return discountOnOrders200;
    }

    protected void setDiscountOnOrders200(int discountOnOrders200) {
        this.discountOnOrders200 = discountOnOrders200;
    }

    public String getAddress() {
        return address;
    }

    public String getType() {
        return type;
    }

    public Customer(String name, String address,String type){
        this.name = name;
        this.type=type;
        this.address=address;
        setWallet(1000);
        setRewardWallet(0);
    }


    public void printrewards(int cus_no) {
        System.out.println("Reward won "+(int)Customer.getCustomerArrayList().get(cus_no-1).getRewardWallet());
    }

    @Override
    public void search() {

    }

    public void selectRestaurant(Menu printmenu,int cus_no,int a3){

        System.out.println("Choose item by code");
        Restaurant rest1= Restaurant.getRestaurantArrayList().get(a3-1);
//        System.out.println("HII "+rest1.cart.size());
        for(int j=0;j<rest1.cart.size();j++){

            System.out.println(rest1.cart.get(j).getRego_id()+" "+rest1.cart.get(j).getName() +" "+rest1.cart.get(j).getPrice()+" "+ rest1.cart.get(j).getQuantity()+" "+ rest1.cart.get(j).getOffer()+"% off "+ rest1.cart.get(j).getCategory());
        }
        int item_no=input.nextInt();
        System.out.println("Enter item quantity -");
        int item_quan=input.nextInt();

        if(rest1.cart_hash.get(item_no).getQuantity()>=item_quan){
            rest1.cart_hash.get(item_no).setQuantity(rest1.cart_hash.get(item_no).getQuantity()-item_quan);
            rest1.setCurrenttotal(rest1.cart_hash.get(item_no).getPrice()*item_quan*(100-rest1.cart_hash.get(item_no).getOffer())/100);
            System.out.println("Items added to the cart");
            MyOrder order1=new MyOrder(rest1.cart_hash.get(item_no).getName(),item_quan,rest1.cart_hash.get(item_no).getPrice(),rest1.cart_hash.get(item_no).getRestaurant_name(), Customer.getCustomerArrayList().get(cus_no-1).deliveryCharge,rest1.cart_hash.get(item_no).getRego_id(),rest1.cart_hash.get(item_no).getOffer());
            queue.add(order1);
            if(queue.size()>10){
                queue.poll();
            }
        }
        else{
            System.out.println("Order not available");
        }
    }

    public void checkoutCart(int cus_no,int res_no){
        Restaurant rest1=Restaurant.getRestaurantArrayList().get(res_no-1);
        rest1.setNumOfOrders(rest1.getNumOfOrders()+1);
        System.out.println("Items in Cart -");
        int quantity=0;
        for(MyOrder item:queue){
            quantity+=item.getItemQuantity();
            System.out.println(item.getFood_id()+" "+item.getRestaurantName()+" - "+item.getItemName()+" - "+item.getItemPrice()+" - "+item.getItemQuantity()+" - "+ item.getFood_discount()+"% off");
        }
            quantity=queue.element().getItemQuantity();
        System.out.println("Delivery Charge - "+ Customer.getCustomerArrayList().get(cus_no-1).getDeliveryCharge()+"/-");
       Customer.getCustomerArrayList().get(cus_no-1).setTotalDeliveryCharge(Customer.getCustomerArrayList().get(cus_no-1).getTotalDeliveryCharge()+Customer.getCustomerArrayList().get(cus_no-1).getDeliveryCharge());

        float ct=rest1.getCurrenttotal();
        float bill1=ct*(100-rest1.getTotalBillDiscount())/100;
        if(rest1.getResType()=="Authentic"){
           if(bill1>100){
               bill1=bill1-50;
           }
        }

        if(Customer.getCustomerArrayList().get(cus_no-1).getType().equals("Elite")){
            if(bill1>200){
                bill1=bill1-50;
            }
        }
        if(Customer.getCustomerArrayList().get(cus_no-1).getType().equals("Special")){
            if(bill1>200){
                bill1=bill1-25;
            }
            bill1=bill1+20;
        }
        if(Customer.getCustomerArrayList().get(cus_no-1).getType().equals("Regular")){
            bill1=bill1+40;
        }

        System.out.println("Total order value - "+ bill1);
        float rewardwallet=Customer.getCustomerArrayList().get(cus_no-1).getRewardWallet();
        float wallet=Customer.getCustomerArrayList().get(cus_no-1).getWallet();
        if(rewardwallet>=bill1){
            Customer.getCustomerArrayList().get(cus_no-1).setRewardWallet(rewardwallet-bill1);
        }
        else{
            float pay=bill1-Customer.getCustomerArrayList().get(cus_no-1).getRewardWallet();
            Customer.getCustomerArrayList().get(cus_no-1).setRewardWallet(0);
            Customer.getCustomerArrayList().get(cus_no-1).setWallet(wallet-pay);
        }
        int ratio=0;
        float rewardPts=0;
        if(rest1.getResType().equals("Authentic")){
             ratio=(int)bill1/200;
             rewardPts=ratio*25;
        }
        if(rest1.getResType().equals("Fast Food")){
            ratio=(int)bill1/150;
            rewardPts=ratio*10;
        }
        if(rest1.getResType().equals("Regular")){
            ratio=(int)bill1/100;
            rewardPts=ratio*5;
        }

        Customer.getCustomerArrayList().get(cus_no-1).setRewardWallet((Customer.getCustomerArrayList().get(cus_no-1).getRewardWallet())+(rewardPts));
        rest1.setResRewards(rest1.getResRewards()+rewardPts);
        System.out.println("    1)Proceed to checkout");
        int in=input.nextInt();
        System.out.println(quantity+ " items successfully bought for INR "+bill1+"/-");
        Restaurant.setAllResRewards(Restaurant.getAllResRewards()+bill1);
    }

    public void printRecents(){
        for(MyOrder item:queue){
            System.out.println("Bought item: "+item.getItemName()+", "+"quantity: "+item.getItemQuantity()+", "+"Rs "+item.getItemPrice()+" from Restaurant "+item.getRestaurantName()+" and Delivery Charge: "+item.getDeliveryCharge());
        }
    }


}

class Owner implements User{
    Scanner input=new Scanner(System.in);

    public void addItem(String name,int price,int quantity,String category,int offer,int res_no,String Restaurant_name){
            FoodItem food=new FoodItem(name,price,quantity,category,offer,Restaurant_name);
            Restaurant rest= Restaurant.getRestaurantArrayList().get(res_no-1);
            rest.cart.add(food);
            rest.cart_hash.put(food.getRego_id(),food);
            System.out.println(food.getRego_id()+" "+food.getName() +" "+food.getPrice()+" "+ food.getQuantity()+" "+ food.getOffer()+"% off "+ food.getCategory());

    }

    public void editItem(int item_no,int atr_no){

    }

    public void discountOnBill(){
    }

    @Override
    public void printrewards(int cus_no) {
        System.out.println("Reward won "+(int)Customer.getCustomerArrayList().get(cus_no-1).getRewardWallet());
    }

    @Override
    public void search() {

    }
}



class EliteCustomer extends Customer{

    public EliteCustomer(String name,String address,String type){
            super(name, address,type);
            setDeliveryCharge(0);
            setDiscountOnOrders200(50);
            addElementCustomerArrayList(this);
    }


    @Override
    public void printrewards(int cus_no) {
        System.out.println("Reward won "+(int)Customer.getCustomerArrayList().get(cus_no-1).getRewardWallet());
    }

    @Override
    public void search() {

    }
}
class SpecialCustomer extends Customer{

    public SpecialCustomer(String name,String address,String type){
        super(name, address,type);
        setDeliveryCharge(20);
        setDiscountOnOrders200(25);
        addElementCustomerArrayList(this);
    }
    @Override
    public void printrewards(int cus_no) {
        System.out.println("Reward won "+(int)Customer.getCustomerArrayList().get(cus_no-1).getRewardWallet());
    }

    @Override
    public void search() {
        int a12=0;
    }
}

class NormalCustomer extends Customer{

    public NormalCustomer(String name,String address,String type){
        super(name, address,type);
        setDeliveryCharge(40);
        setDiscountOnOrders200(0);
        addElementCustomerArrayList(this);
    }
    @Override
    public void printrewards(int cus_no) {
        System.out.println("Reward won "+(int)Customer.getCustomerArrayList().get(cus_no-1).getRewardWallet());
    }

    @Override
    public void search() {
    //selects a restaurant using name
        int a32=0;
    }
}






class FoodItem{

    private String name;
    private int price;
    private int quantity;
    private String category;
    private int offer;
    private static int reg_counter;
    private int food_id;
    private int rego_id;
    private String Restaurant_name;

    {
        rego_id=++reg_counter;
    }

    public FoodItem(String name,int price,int quantity,String category,int offer,String Restaurant_name) {
        this.name=name;
        this.price=price;
        this.quantity=quantity;
        this.category=category;
        this.rego_id=rego_id;
        this.offer=offer;
        this.Restaurant_name=Restaurant_name;
    }

    public int getRego_id() {
        return rego_id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getCategory() {
        return category;
    }

    public int getOffer() {
        return offer;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setOffer(int offer) {
        this.offer = offer;
    }

    public String getRestaurant_name() {
        return Restaurant_name;
    }

    public void setRestaurant_name(String restaurant_name) {
        Restaurant_name = restaurant_name;
    }
}




class Restaurant {

    Scanner input=new Scanner(System.in);

    private final String name;
    private float currenttotal;
    private final String address;
    private int numOfOrders;
    private static ArrayList<Restaurant> restaurantArrayList=new ArrayList<Restaurant>();
    private float resRewards;
    private String resType;
    private static float companyMoney=0;
    private static float AllResRewards=0;
    private int totalBillDiscount=0;
  public HashMap<Integer,FoodItem> cart_hash=new HashMap<Integer, FoodItem>();
  public ArrayList<FoodItem> cart=new ArrayList<FoodItem>();

    Restaurant(String name, String address, int numOfOrders,String resType) {
        this.name = name;
        this.resType=resType;
        this.address = address;
        this.numOfOrders = numOfOrders;
        setResRewards(0);
        setTotalBillDiscount(0);
    }

    public static void setAllResRewards(float allResRewards) {
        AllResRewards = allResRewards;
    }

    public static ArrayList<Restaurant> getRestaurantArrayList() {
        return restaurantArrayList;
    }

    public void addElementRestaurantArrayList(Restaurant restaurant1){
        restaurantArrayList.add(restaurant1);
    }

    public String getName() {
        return name;
    }

    public float getResRewards() {
        return resRewards;
    }

    public void setResRewards(float resRewards) {
        this.resRewards = resRewards;
    }

    public int getTotalBillDiscount() {
        return totalBillDiscount;
    }

    public void setTotalBillDiscount(int totalBillDiscount) {
        this.totalBillDiscount = totalBillDiscount;
    }

    public String getAddress() {
        return address;
    }

    public int getNumOfOrders() {
        return numOfOrders;
    }

    public static float getCompanyMoney() {
        return companyMoney;
    }

    public static float getAllResRewards() {
        return AllResRewards;
    }

    public String getResType() {
        return resType;
    }

    public float getCurrenttotal() {
        return currenttotal;
    }

    public void setCurrenttotal(float currenttotal) {
        this.currenttotal = currenttotal;
    }

    public void setNumOfOrders(int numOfOrders) {
        this.numOfOrders = numOfOrders;
    }
}



class FastFood extends Restaurant{
    private final int rewardPoints150=10;
    public FastFood(String name,String address,int numOfOrders,String resType){
        super(name, address, numOfOrders,resType);

        addElementRestaurantArrayList(this);

    }

    public int getRewardPoints150() {
        return rewardPoints150;
    }
}
class Authentic extends Restaurant{
    private final int rewardPoints200=25;
    private static final int AuthenticDiscountIfGreaterThan100=50;
    public Authentic(String name,String address,int numOfOrders,String resType){
        super(name, address, numOfOrders,resType);
        addElementRestaurantArrayList(this);
    }

    public int getRewardPoints200() {
        return rewardPoints200;
    }
}
class NormalRestaurant extends Restaurant{
//    private int totalDiscount=0;
    private final int rewardPoints100=5;
    public NormalRestaurant(String name,String address,int numOfOrders,String resType){
        super(name, address, numOfOrders,resType);
        addElementRestaurantArrayList(this);
    }

    public int getRewardPoints100() {
        return rewardPoints100;
    }
}

class Menu{
    public void introMenu(){
        System.out.println("Welcome to Zotato:");
        System.out.println("1) Enter as Restaurant Owner");
        System.out.println("2) Enter as Customer");
        System.out.println("3) Check User Details");
        System.out.println("4) Company Account details");
        System.out.println("5) Exit");
    }

    public void resMenu(){
        System.out.println("Choose Restaurant");
        for(int i=0;i<Restaurant.getRestaurantArrayList().size();i++){
            System.out.println((i+1)+") "+Restaurant.getRestaurantArrayList().get(i).getName()+" ("+Restaurant.getRestaurantArrayList().get(i).getResType()+")");
        }
    }

    public void cusList(){
        for (int j = 0; j < Customer.getCustomerArrayList().size(); j++) {
            System.out.println(j + 1 + ". " + Customer.getCustomerArrayList().get(j).getName() + " (" + Customer.getCustomerArrayList().get(j).getType() + ")");
        }
    }

    public void OwnerFirstMenu(int i){
        System.out.println("Welcome "+ Restaurant.getRestaurantArrayList().get(i-1).getName());
        System.out.println("1) Add Item");
        System.out.println("2) Edit Item");
        System.out.println("3) Print Rewards");
        System.out.println("4) Discount on bill value");
        System.out.println("5) Exit");
    }

    public void CustomerMenu(int i){
        System.out.println("Welcome "+ Customer.getCustomerArrayList().get(i-1).getName());
        System.out.println("Customer Menu");
        System.out.println("1) Select Restaurant");
        System.out.println("2) checkout cart");
        System.out.println("3) Reward won");
        System.out.println("4) print the recent orders");
        System.out.println("5) Exit");
    }

    public void UserDetailsMenu(){
        System.out.println("1) Customer List");
        System.out.println("2) Restaurant List");

    }
}

class MyOrder{

    private String itemName;
    private int itemQuantity;
    private float itemPrice;
    private String restaurantName;
    private int deliveryCharge;
    private int food_id;
    private int food_discount;

    public MyOrder(String itemName, int itemQuantity, float itemPrice, String restaurantName, int deliveryCharge,int food_id,int food_discount) {
        this.itemName = itemName;
        this.itemQuantity = itemQuantity;
        this.itemPrice = itemPrice;
        this.restaurantName = restaurantName;
        this.deliveryCharge = deliveryCharge;
        this.food_id=food_id;
        this.food_discount=food_discount;
    }

    public int getFood_discount() {
        return food_discount;
    }

    public void setFood_discount(int food_discount) {
        this.food_discount = food_discount;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public float getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(float itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public int getDeliveryCharge() {
        return deliveryCharge;
    }

    public void setDeliveryCharge(int deliveryCharge) {
        this.deliveryCharge = deliveryCharge;
    }

    public int getFood_id() {
        return food_id;
    }

    public void setFood_id(int food_id) {
        this.food_id = food_id;
    }
}
