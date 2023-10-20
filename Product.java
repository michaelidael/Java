 //making life easier w these sick libs thanks to tutorialspoint.

import java.text.SimpleDateFormat;

import java.util.Date;


//Product class for project

public class Product {


//var dec

SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

Manufacturer manufacture;

String productName;

int quantity;

double unitPrice;

Date productCreated;

//productConstructor initializing to zero

public Product() {

this.productName = "";

this.quantity = 0;

this.unitPrice = 0.0;

this.productCreated = null;

this.manufacture = null;

}

//prodContstructwParam.

public Product(String prodName, int quantity, double unitPrice, Date productCreated, Manufacturer manufact)

{

this.productName = prodName;

this.quantity = quantity;

this.unitPrice = unitPrice;

this.productCreated = productCreated;

this.manufacture = manufact;

}

//prodManufactDateGetter

public Date getProductCreated() {

return productCreated;

}

//prodManufactDateSetter

public void setProductCreated(Date productCreated) {

this.productCreated = productCreated;

}

//manufactObjGetter

public Manufacturer getManufacture() {

return manufacture;

}


//manufactObjSetter

public void setManufacture(Manufacturer manufacture) {

this.manufacture = manufacture;

}

//prodNameGetter

public String getProductName() {

return productName;

}

//prodNameSetter

public void setProductName(String prodName) {

this.productName = prodName;

}

//prodQuantGetter

public int getQuantity()

{

return quantity;

}

//prodQuantSetter

public void setQuantity(int quantity) {

this.quantity = quantity;

}

//unitPriceGetter

public double getUnitPrice() {

return unitPrice;

}

//unitPriceSetter

public void setUnitPrice(double unitPrice) {

this.unitPrice = unitPrice;

}

//quantityUpdater

public void updateQuantity(int quantity_update) {

quantity += quantity_update;

}

//prodpriceUpdater

public void updatePrice(double price_update) {

this.unitPrice = price_update;

}

//productInfoGetter

public String getProductInformation() {

String result = "";

result += String.format("%-30s", productName);

String dateForm = sdf.format(productCreated);

result += String.format("\t %s", dateForm);

result += String.format("%10d", quantity);

result += String.format("\t%15.2f", unitPrice);

result += String.format("\t%15s", manufacture.getCompanyName());

result += String.format("\t%20s", manufacture.getCompanyAddress().getState());

return result;

}

//concludes ungodly product class

}