import java.util.*;
public class Main{

    static Scanner input = new Scanner(System.in);
    static String validUserName = "ahasna";
    static String validPassWord = "1234";
  
   /* static String [][] suppliers = new String [0][2];   //create 2d array to store new suppliers 
    static int supplierCount = 0;
    
    static String[] itemCategories = new String[0];	//create array to store new item categories
    static int itemCategoryCount = 0;
    
    static String[][] items = new String[0][6]; 	//create 2d array to store new items 
    static int itemCount = 0;
   */   
    
    static int supplierCount = 4;
    static String[][] suppliers = {
        {"S001", "Nethul"},
        {"S002", "Nethmi "},
        {"S003", "Thilini"},
	{"S004", "Aveesha"}
    };
    
    static String[] itemCategories = new String[] {"FOOD", "MEDICINE", "GIFT", "ELECTRONICS"};
    static int itemCategoryCount = 4;
    
    static String[][] items = {
        {"I001", "Bread",   "50", "2", "S001" ,"FOOD"    },
        {"I002", "Asprin","40", "12","S002" ,"MEDICINE"},
	{"I003", "Mug", "52", "23","S002" ,"GIFT"    },
	{"I004", "Smart Phone",   "10", "32","S004" ,"ELECTORONICS"     }
    };
    static int itemCount = 4;
    
   

    public static void loginPage(){	//print login page
	clearConsole();
	System.out.println("+-------------------------------------------------------+");
	System.out.println("|" +     "\t\t\t " + "LOGIN PAGE" + "\t\t\t" +         "|");
	System.out.println("+-------------------------------------------------------+");
    } 
    
    public static void logIntoSystem(){	//verifying credentials
	loginPage();
	
	String userName;
	String passWord;
	
    L1:	while (true) {
            // Prompt for username
            System.out.print("User Name: ");
            userName = input.next();

            // Check if the username is valid
            if (!userName.equals(validUserName)) {
                System.out.println("User name is invalid. Please try again!\n");
               continue L1;
            }

	L2: while (true) {
		// Prompt for password
		System.out.print("Password: ");
		passWord = input.next();

		// Check if the password is valid
		if (!passWord.equals(validPassWord)) {
		    System.out.println("Password is incorrect. Please try again!\n");
		    continue L2;
		}
 
		break L1;  // If both username and password are correct, exit the loop L1.
	    }
	   
        }
	    System.out.println("Login successful!");
	    homeMenu();
    }
    
    private final static void clearConsole() {  //Clear Console
	final String os = System.getProperty("os.name");
	try {
	    if (os.equals("Linux")) {
	    System.out.print("\033\143");
	} else if (os.equals("Windows")) {
	    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	} else {
	    System.out.print("\033[H\033[2J");
	    System.out.flush();
	}
	} catch (final Exception e) {
	    //handle the exception
	    System.err.println(e.getMessage());
	}
    }
    
    public static void homeMenu(){
	clearConsole();
	System.out.println("+-------------------------------------------------------+");
	System.out.println("|" +     "\t " + "WELCOME TO IJSE STOCK MANAGEMENT SYSTEM" + "\t" +         "|");
	System.out.println("+-------------------------------------------------------+");
	
	System.out.println("[1] Change the Credentials \t\t" + "[2] Supplier Manage");
	System.out.println("[3] Stock Manage \t\t\t" + "[4] Log out");
	System.out.println("[5] Exit the system");
	while(true){
	    System.out.print("Enter an option to continue > ");
	    String option =input.next();
	    
	    switch (option)
	    {
		case "1":
		    changePassword();
		    break;
		case "2":
		    supplierManage();
		    break;
		case "3":
		    stockManage();
		    break;
		case "4":
		    logOut();
		    break;
		case "5":
		    System.exit(0);
		    break;
		default:
		    System.out.println("Invalid option.. ");
	    }
	}
    }
    
    public static void changePassword(){
	clearConsole();
	String userName ,passWord;
	    L1:	while (true) {
            // Prompt for username
            System.out.print("Please enter the user name to verify it's you: ");
            userName = input.next();

            // Check if the username is valid
            if (!userName.equals(validUserName)) {
                System.out.println("User name is invalid. Please try again!\n");
               continue L1;
            }else{
		System.out.println("Hey "+ validUserName);
	    }

	L2: while (true) {
		// Prompt for password
		System.out.print("Enter your current password: ");
		passWord = input.next();

		// Check if the password is valid
		if (!passWord.equals(validPassWord)) {
		    System.out.println("Password is incorrect. Please try again!\n");
		    continue L2;
		}
 
		break L1;  // If both username and password are correct, exit the loop L1.
	    }
	   
        }
	    System.out.print("Enter your new password : ");
	    String newPassword = input.next();
	    validPassWord = newPassword;
	    
	    System.out.println("Password changed successfully ! ");
	    goToHome();
    }
	
    public static void goToHome(){
	while (true) {
		System.out.print("Do you want to go home page (Y/N)");
		String answer = input.next();

            if (answer.equalsIgnoreCase("Y")) {
                System.out.println("Navigating to home...");
		homeMenu(); //navigate home
		break;
	    }else if(answer.equalsIgnoreCase("N")){
		System.exit(0);
	    }else{
		System.out.println("Invalid Input !! Please Enter (Y/N)\n");
	    }
	}
    }
	
    public static void logOut(){
	clearConsole();
	System.out.print("Are you sure you want to log out? (Y/N)");
        String choice = input.next();
	   if (choice.equalsIgnoreCase("Y")) {
		System.out.println("You are logged out!");
		logIntoSystem(); //redirecting login page
		
	    }else if (choice.equalsIgnoreCase("N")){
		System.out.println("Logout cancelled !");
		homeMenu();
	    }
    }
    
    public static void supplierManage(){
	clearConsole();
	System.out.println("+---------------------------------------------------------------+");
	System.out.println("|" +     "\t\t\t " + "SUPPLIER MANAGE" + "\t\t\t" +         "|");
	System.out.println("+---------------------------------------------------------------+");
	
	System.out.println("\n[1] Add Supplier \t\t\t" + "[2] Update Supplier");
	System.out.println("[3] Delete Supplier \t\t\t" + "[4] View Suppliers");
	System.out.println("[5] Search Supplier \t\t\t" + "[6] Home Page\n");
	
	while(true){
	    System.out.print("Enter an option to continue > ");
	    String option =input.next();
	    
	    switch (option)
	    {
		case "1":
		    addNewSupplier();
		    break;
		case "2":
		    updateSupplier();
		    break;
		case "3":
		    deleteSupplier();
		    break;
		case "4":
		    viewSuppliers();
		    break;
		case "5":
		    searchSupplier();
		    break;
		case "6":
		    homeMenu();
		    break;
		default:
		    System.out.println("Invalid option.. ");
	    }
	}
    }
    
    public static void addNewSupplier(){
	clearConsole();
	System.out.println("+-------------------------------------------------------+");
	System.out.println("|" +     "\t\t\t " + "ADD SUPPLIER" + "\t\t\t" +         "|");
	System.out.println("+-------------------------------------------------------+");
       
    L1:	while (true){
	    System.out.print("Supplier ID: ");
	    String id = input.next();// Get supplier ID and name from the user
	
	if(!check(id, suppliers)){ // check id  is already exist ?
		suppliers = growSupplier(suppliers);
		System.out.print("Supplier Name: ");
		String name = input.next();
		
		suppliers[suppliers.length-1][0]=id;
		suppliers[suppliers.length-1][1]=name;
		supplierCount++;
		System.out.println("added Successfully !");
	L2: while (true) {
			System.out.print("Do you want to add another supplier (Y/N) : ");
			String answer = input.next();

		    if (answer.equalsIgnoreCase("Y")) {
			addNewSupplier();
		    }else if(answer.equalsIgnoreCase("N")){
			    supplierManage();
			    break L1; //jumping out from loop L1
		    }else{
			System.out.println("Invalid Input !! Please Enter (Y/N)\n");
		    }
		}
	}else{
		System.out.println("Already exits. try another supplier id !");
	    }
	}
    }
    
    public static String[][] growSupplier(String [][] oldArray ){
	String [][] newArray = new String[oldArray.length + 1][2];
	
	for (int i = 0; i < oldArray.length ; i++){
	    newArray[i][0] = oldArray[i][0];
	    newArray[i][1] = oldArray[i][1];
	}
	return newArray;
	 
    }
    
    public static void viewSuppliers(){ 
	clearConsole();
	 // Print the header
        System.out.println("+-------------+-----------------+");
        System.out.println("| SUPPLIER ID |  SUPPLIER NAME  |");
        System.out.println("+-------------+-----------------+");
	
	for (int i = 0; i < suppliers.length; i++){
	   System.out.printf("| %-11s | %-15s |\n", suppliers[i][0], suppliers[i][1]);
	}
	 System.out.println("+-------------+-----------------+");
	
	while (true) {
		System.out.print("Do you want to go supplier manage page (Y/N) ? : ");
		String answer = input.next();

	    if (answer.equalsIgnoreCase("Y")) {
		supplierManage();
		
	    }else if(answer.equalsIgnoreCase("N")){
		goToHome();
	    }else{
		System.out.println("Invalid Input !! Please Enter (Y/N)\n");
	    }
	} 
    }
    
    public static boolean check( String Id, String [][] array){ //check id

	if(array.length>=0){
	    for (int i = 0; i < array.length; i++){
		if(array[i][0].equals(Id)){
		    return true;
		}
	    }
	}
	return false;
    }
    
    public static void updateSupplier(){
	clearConsole();
        System.out.println("+---------------------------------------------------------------+");
        System.out.println("|"   +     "\t\t\t " + "UPDATE SUPPLIER" + "\t\t\t" +      	"|");
        System.out.println("+---------------------------------------------------------------+");

        L1: while (true) {
            System.out.print("Supplier ID: ");
            String id = input.next();

            boolean found = false;
            for (int i = 0; i < suppliers.length; i++) {
                if (suppliers[i][0].equals(id)) {
                    found = true;
                    String currentName = suppliers[i][1];
                    System.out.print("Supplier Current Name: " + currentName);
                    System.out.print("\nEnter the New Supplier Name: ");
                    String newName = input.next();
                    suppliers[i][1] = newName;
                    System.out.println("Updated Successfully !!");

                    L2: while (true) {
                        System.out.print("Do you want to update another supplier (Y/N): ");
                        String answer = input.next();

                        if (answer.equalsIgnoreCase("Y")) {
                            updateSupplier();
                        } else if (answer.equalsIgnoreCase("N")) {
                            supplierManage();
                        } else {
                            System.out.println("Invalid Input !! Please Enter (Y/N)\n");
                        }
                    }
                }
            }

            if (!found) {
                System.out.println("Can't find Supplier ID. Try again!");
            }
        }
    }
   
   public static void deleteSupplier() {
        clearConsole();
        System.out.println("+-------------------------------------------------------+");
        System.out.println("|" + "\t\t\t " + "DELETE SUPPLIER" + "\t\t\t" + "|");
        System.out.println("+-------------------------------------------------------+");

        L1:
        while (true) {
            System.out.print("Supplier Id: ");
            String id = input.next();

            if (check(id, suppliers)) {
                String[][] updatedSuppliers = new String[suppliers.length - 1][2];
                int index = 0;

                for (int i = 0; i < suppliers.length; i++) {
                    if (!suppliers[i][0].equals(id)) {
                        updatedSuppliers[index][0] = suppliers[i][0];
                        updatedSuppliers[index][1] = suppliers[i][1];
                        index++;
                    }
                }
                suppliers = updatedSuppliers;
                System.out.println("Deleted successfully!");

                L2:
                while (true) {
                    System.out.print("Do you want to delete another? (Y/N): ");
                    String answer = input.next();

                    if (answer.equalsIgnoreCase("Y")) {
                        deleteSupplier();
                        break L2;
                    } else if (answer.equalsIgnoreCase("N")) {
                        supplierManage();
                        break L2;
                    } else {
                        System.out.println("Invalid Input! Please Enter (Y/N)\n");
                    }
                }
                break L1;
            } else {
                System.out.println("Can't find supplier id. Try again!");
            }
        }
    }
    
    public static void searchSupplier(){
	clearConsole();
        System.out.println("+---------------------------------------------------------------+");
        System.out.println("|" + "\t\t\t " + "SEARCH SUPPLIER" + "\t\t\t" + "|");
        System.out.println("+---------------------------------------------------------------+");

        L1: while (true) {
            System.out.print("Supplier ID: ");
            String id = input.next();
            boolean found = false;

            for (int i = 0; i < suppliers.length; i++) {
                if (suppliers[i][0].equals(id)) {
                    found = true;
                    String currentName = suppliers[i][1];
                    System.out.println("Supplier Name: " + currentName);
                    System.out.println("Found successfully!");

                    L2: while (true) {
                        System.out.print("Do you want to search another supplier? (Y/N): ");
                        String answer = input.next();

                        if (answer.equalsIgnoreCase("Y")) {
			    searchSupplier();
                        } else if (answer.equalsIgnoreCase("N")) {
			    supplierManage();
                        } else {
                            System.out.println("Invalid Input !! Please Enter (Y/N)\n");
                        }
                    }
                }
            }

            if (!found) {
                System.out.println("Can't find Supplier ID. Try again!");
            }
        }
    }
    public static void stockManage(){
	while(true){
	    clearConsole();
	    System.out.println("+---------------------------------------------------------------+");
	    System.out.println("|" +     "\t\t\t " + "STOCK MANAGEMENT" + "\t\t\t" +         "|");
	    System.out.println("+---------------------------------------------------------------+");
	    
	    System.out.println("\n[1] Manage Item Categories \t\t\t" + "[2] Add Item");
	    System.out.println("[3] Get Items Supplier Wise \t\t\t" + "[4] View Items");
	    System.out.println("[5] Rank Items Per Unit Price \t\t\t" + "[6] Home Page\n");
	
	    System.out.print("Enter an option to continue > ");
	    String option =input.next();
	    
	    switch (option)
	    {
		case "1":
		    manageItemCategories();
		    break;
		case "2":
		    addItems();
		    break;
		case "3":
		    getItemsSupplierWise();
		    break;
		case "4":
		    viewItems();
		    break;
		case "5":
		    rankItemsPerUnitPrice();
		    break;
		case "6":
		    homeMenu();
		    break;
		default:
		    System.out.println("Invalid option.. ");
	    }
	    break;
	}
    }
    
    public static void manageItemCategories(){
    while(true){
	clearConsole();
	System.out.println("+---------------------------------------------------------------+");
	System.out.println("|" +     "\t\t\t " + " MANAGE ITEM CATEGORY " + "\t\t\t" +         "|");
	System.out.println("+---------------------------------------------------------------+");
	
	System.out.println("\n[1] Add New Item Category \t\t\t" + "[2] Delete Item Category");
	System.out.println("[3] Update Item Category \t\t\t" + "[4] Stock Managment");
	
	
	    System.out.print("Enter an option to continue > ");
	    String option =input.next();
	    
	    switch (option)
	    {
		case "1":
		    addNewItemCategory();
		    break;
		case "2":
		    deleteItemCategory();
		    break;
		case "3":
		    updateItemCategory();
		    break;
		case "4":
		    stockManage();
		    break;
		default:
		    System.out.println("Invalid option.. ");
	    }
	}
    }
    
    public static void addNewItemCategory(){
	while (true) {
	    clearConsole();
	    System.out.println("+---------------------------------------------------------------+");
	    System.out.println("|" +     "\t\t\t " + "ADD ITEM CATEGORY " + "\t\t\t" +         "|");
	    System.out.println("+---------------------------------------------------------------+");
	    
	    itemCategories = growCatagory(itemCategories);
	    System.out.print("Enter the new item category: ");
	    String category = input.next();
	    itemCategories[itemCategoryCount++] = category;
	    System.out.println("Category added successfully!");
    
    
		System.out.print("Do you want add another category (Y/N) ? : ");
		String answer = input.next();

		if (answer.equalsIgnoreCase("Y")) {
		    addNewItemCategory();
		    
		}else if(answer.equalsIgnoreCase("N")){
		    manageItemCategories();
		}else{
		    System.out.println("\nInvalid input. please enter (Y/N) :\n");
		    continue;
		}
	    } 
    }
    
    public static String[] growCatagory(String [] oldArray ){
	String [] newArray = new String[oldArray.length +1]; 
	
	for (int i = 0; i < oldArray.length ; i++){ //old array coppied to the new array
	    newArray[i] = oldArray[i];
	}
	return newArray;
	 
    }
    
    public static void deleteItemCategory(){
	clearConsole();
    L1: while(true){
	System.out.println("+---------------------------------------------------------------+");
	System.out.println("|" +     "\t\t\t " + "DELETE ITEM CATEGORY " + "\t\t\t" +         "|");
	System.out.println("+---------------------------------------------------------------+");
    
	System.out.print("Enter the item category to delete: ");
        String category = input.next();
        for (int i = 0; i < itemCategoryCount; i++) {
            if (itemCategories[i].equals(category)) {  //check current category match category enter by user
                itemCategories[i] = itemCategories[itemCategoryCount - 1];
                itemCategoryCount--;
                System.out.println("Category deleted successfully!");
                break L1 ;
            }
	}
	    System.out.println("Category not found!");
	    

    while (true) {
		System.out.print("\nDo you want delete another category (Y/N) ? : ");
		String answer = input.next();

		if (answer.equalsIgnoreCase("Y")) {
		    deleteItemCategory();
		    
		}else if(answer.equalsIgnoreCase("N")){
		    manageItemCategories();
		}else{
		    System.out.println("Invalid Input !! Please Enter (Y/N)\n");
		    continue;
		}
	    } 
	}
    }
    
    public static void updateItemCategory(){
	clearConsole();
    L1: while(true){
	System.out.println("+---------------------------------------------------------------+");
	System.out.println("|" +     "\t\t\t " + "UPDATE ITEM CATEGORY " + "\t\t\t" +         "|");
	System.out.println("+---------------------------------------------------------------+");

	System.out.print("\nEnter the item category to update: ");
        String oldCategory = input.next();
        for (int i = 0; i < itemCategoryCount; i++) {
            if (itemCategories[i].equals(oldCategory)) {  //checks current category (itemCategories[i]) matches the oldCategory entered by the user
                System.out.print("Enter the new category name: ");
                String newCategory = input.next();
                itemCategories[i] = newCategory;
                System.out.println("Category updated successfully!");
                break L1;
            }
          }
		System.out.println("Category not found!");
		
        
    while (true) {
		System.out.print("\nDo you want update another category (Y/N) ? : ");
		String answer = input.next();

		if (answer.equalsIgnoreCase("Y")) {
		    updateItemCategory();
		    
		}else if(answer.equalsIgnoreCase("N")){
		    manageItemCategories();
		}else{
		    System.out.println("Invalid Input !! Please Enter (Y/N)\n");
		    continue;
		}
	    } 
	}
    }
    
    public static void addItems(){
	clearConsole();
	System.out.println("+-----------------------------------------------------------------------+");
	System.out.println("|" +       "\t\t\t\t " + " ADD ITEM " + "\t\t\t\t" +           "|");
	System.out.println("+-----------------------------------------------------------------------+");
	
	if (itemCategoryCount == 0) {
            System.out.println("OOPS! It seems that you don't have any item categories in the system.");
            System.out.print("Do you want to add a new item category?(Y/N) ");
	    String answer = input.next();
            if (answer.equalsIgnoreCase("Y")) {
                addNewItemCategory();
            } else {
                return;
            }
        }
        
        if (supplierCount == 0) {
            System.out.println("OOPS! It seems that you don't have any suppliers in the system.");
            System.out.print("Do you want to add a new supplier?(Y/N) ");
            String answer = input.next();
	    if (answer.equalsIgnoreCase("Y")) {
                addNewSupplier();
            } else {
                return;
            }
        }
	while(true){
	if(itemCategoryCount>0 && supplierCount >0){
	   
	    System.out.print("Enter item code: ");
	    String itemCode = input.next();
	    if(check(itemCode, items)){
		System.out.println("Already exits. try another Item Code !");
		continue;
	    }

		items= growItems(items);  // increase the size of the items array by one row
		items[itemCount][0] = itemCode;
		
		System.out.println("+-------------+-------------+-----------------+");
		System.out.println("|      #      | SUPPLIER ID |  SUPPLIER NAME  |");
		System.out.println("+-------------+-------------+-----------------+");
	    
	    for (int i = 0; i < suppliers.length; i++){  //printing each supplier's number, ID, and name
	       System.out.printf("| %-11s | %-11s | %-15s |\n", (i+1), suppliers[i][0], suppliers[i][1]);
	    }
	      System.out.println("+-------------+-------------+-----------------+");
		
		System.out.print("Enter supplier number: ");
		int supplierIndex = input.nextInt() - 1;
		items[itemCount][4] = suppliers[supplierIndex][0];
		
		System.out.println("+-------------+-----------------+");
		System.out.println("|      #      |  CATEGORY NAME  |");
		System.out.println("+-------------+-----------------+");
	    
	    for (int i = 0; i < itemCategories.length; i++){ //printing each category's number and name
		System.out.printf("| %-11s | %-15s |\n", (i+1), itemCategories[i]);
	    }
		System.out.println("+-------------+-----------------+");
	     
		System.out.print("Enter category number: ");
		int categoryIndex = input.nextInt() - 1;
		items[itemCount][5] = itemCategories[categoryIndex];
		
		System.out.print("Enter item description: ");
		String description = input.next();
		items[itemCount][1] = description;
		
		System.out.print("Enter unit price: ");
		String unitPrice = input.next();
		items[itemCount][2] = unitPrice;
		
		System.out.print("Enter quantity on hand: ");
		String quantity = input.next();
		items[itemCount][3] = quantity;
		
		itemCount++;
		System.out.println("Item added successfully!");
		 
		L1: while (true) {
			    System.out.print("Do you want add another Item (Y/N) ? : ");
			    String answer = input.next();

			if (answer.equalsIgnoreCase("Y")) {
			    addItems();
			    
			}else if(answer.equalsIgnoreCase("N")){
				stockManage();
			}else{
			    System.out.println("Invalid Input !! Please Enter (Y/N)\n");
			    continue L1;
			}
		    }
	    }
	}
    }
    
     public static String[][] growItems(String [][] oldArray ){
	String [][] newArray = new String[oldArray.length + 1][6];//same as the oldArray.
	
	for (int i = 0; i < oldArray.length ; i++){  //used to copy elements from oldArray to newArray
	    for (int j = 0; j < oldArray[i].length; j++){
		newArray[i][j] = oldArray[i][j];
	    }
	}
	return newArray;
	 
    }
    
    public static void getItemsSupplierWise(){
	clearConsole();
	System.out.println("+---------------------------------------------------------------+");
	System.out.println("|" +     "\t\t\t " + "SEARCH SUPPLIER" + "\t\t\t" +         "|");
	System.out.println("+---------------------------------------------------------------+");
	
      
	L1: while (true) {    //while (true) loop run indefinitely until valid supplier ID is found or the user decides to exit
            System.out.print(" Enter Supplier ID: ");
            String id = input.next();
            boolean found = false; //used to track whether the supplier ID is found

            for (int i = 0; i < suppliers.length; i++) {  //Check for Valid Supplier ID
                if (suppliers[i][0].equals(id)) {
                    found = true;
                    String supplierName = suppliers[i][1];
                    System.out.println("Supplier Name: " + supplierName);
		    
		    System.out.println("+-------------+-----------------+-----------------+-----------------+-----------------+");
		    System.out.println("|  ITEM CODE  |   DESCRIPTION   |    UNIT PRICE   |   QTY ON HAND   |     CATEGORY    |");
		    System.out.println("+-------------+-----------------+-----------------+-----------------+-----------------+");
		    
		    for (int j = 0; j < itemCount; j++) {   //item details are printed in a formatted table row using System.out.printf.
			if (items[j][4].equals(id)) {
		
			
			System.out.printf("| %-11s | %-15s | %-15s | %-15s | %-15s |\n",items[j][0] ,items[j][1] ,items[j][2] ,items[j][3] ,items[j][5]);
			}
		    }
		    System.out.println("+-------------+-----------------+-----------------+-----------------+-----------------+");
		    System.out.println();
		    System.out.println("Search successfully ! ");
		}
            }

            if (!found) {
                System.out.println("Can't find Supplier ID. Try again!");
		continue L1;  // prompting the user to enter a supplier ID again
            }
        
    L2: while (true) {
		    System.out.print("Do you want to another search ? (Y/N) : ");
		    String answer = input.next();

		if (answer.equalsIgnoreCase("Y")) {
		    getItemsSupplierWise();
		    
		}else if(answer.equalsIgnoreCase("N")){
		    stockManage();
		}else{
		    System.out.println("Invalid Input !! Please Enter (Y/N)\n");
		    continue L2;
		}
	    } 
    
	}
    }
    
    
    public static void viewItems(){
	clearConsole();
	System.out.println("+-------------------------------------------------------+");
	System.out.println("|" +     "\t\t\t " + "VIEW ITEMS" + "\t\t\t" +         "|");
	System.out.println("+-------------------------------------------------------+");
	
        for (int i = 0; i < itemCategoryCount; i++) {  //for loop iterates through each item category
            System.out.println("Category: " + itemCategories[i]);  // loop runs from 0 to itemCategoryCount - 1  
	    
		    System.out.println("+-------------+--------------+-----------------+--------------+-------------+");
		    System.out.println("|     SID     |     CODE     |      DESC       |    PRICE     |     QTY     |");
		    System.out.println("+-------------+--------------+-----------------+--------------+-------------+");
		    
            for (int j = 0; j < itemCount; j++) {   // checks  category of the current item (items[j][5]) matches the current category (itemCategories[i])
                if (items[j][5].equals(itemCategories[i])) {
                    System.out.printf("| %-11s | %-12s | %-15s | %-12s | %-11s |\n",items[j][4] ,items[j][0] ,items[j][1] ,items[j][2] ,items[j][3]);
                }
            }
	       System.out.println("+-------------+--------------+-----------------+--------------+-------------+");
	      System.out.println();
	while (true) {
		System.out.print("\nDo you want to go Stock Manage page (Y/N) ? : ");
		String answer = input.next();

		if (answer.equalsIgnoreCase("Y")) {
		    stockManage();
		    
		}else if(answer.equalsIgnoreCase("N")){
		    viewItems();
		}else{
		    System.out.println("Invalid Input !! Please Enter (Y/N)\n");
		    continue;
		}
	    } 
        }
    }
    public static void rankItemsPerUnitPrice(){
	clearConsole();
	System.out.println("+---------------------------------------------------------------+");
	System.out.println("|" +     "\t\t\t " + "RANKED UNIT PRICE" + "\t\t\t" +         "|");
	System.out.println("+---------------------------------------------------------------+");
	
	double [] unitPrice = new double [items.length]; // double array is initialized to store the unit prices of items.
		
		for (int i = 0; i < items.length; i++){  //nested for loop uses the bubble sort algorithm to sort the unitPrice array in ascending order.
			unitPrice[i]=Double.parseDouble(items[i][2]); //String ---->>> Double value
			
		}
		for (int i = 0; i < unitPrice.length; i++){
			for (int j = 0; j < unitPrice.length-1; j++){
				if (unitPrice[j]>unitPrice[j+1]){
					double temp = unitPrice[j];
					unitPrice[j] = unitPrice[j+1];
					unitPrice[j+1] = temp;
				}
			}
		}
		
		System.out.println(Arrays.toString(unitPrice)); // sorted temp array is printed to the console.
	
	
	System.out.println("+--------------+--------------+----------------------+--------------+--------------+-----------------+");
	System.out.println("|     SID      |     CODE     |         DESC         |    PRICE     |      QTY     |       CAT       |");
	System.out.println("+--------------+--------------+----------------------+--------------+--------------+-----------------+");
	
	for (int i = 0; i < unitPrice.length; i++){    //If the unit price in temp[i] matches the unit price in items[j][2], the item details are printed in a formatted table row using System.out.printf
			for (int j = 0; j < items.length; j++){
				if (unitPrice[i]==Double.parseDouble(items[j][2])){
				    System.out.printf("| %-12s | %-12s | %-20s | %-12s | %-12s | %-15s |\n",items[j][4] ,items[j][0] ,items[j][1] ,unitPrice[i] ,items[j][3],items[j][5]);
				}
			}
			
		}
	System.out.println("+--------------+--------------+----------------------+--------------+--------------+-----------------+");
	// while loop prompts the user to decide whether to go to the stock manage page	
	while (true) {
		System.out.print("Do you want to go stock manage page (Y/N) ? : ");
		String answer = input.next();

	    if (answer.equalsIgnoreCase("Y")) {
		stockManage();
		
	    }else if(answer.equalsIgnoreCase("N")){
		rankItemsPerUnitPrice();
	    }else{
		System.out.println("Invalid Input !! Please Enter (Y/N)\n");
		
	    }
	} 
    }
    public static void main(String [] args){
	logIntoSystem();
    }
}
