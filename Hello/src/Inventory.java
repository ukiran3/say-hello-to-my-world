
public class Inventory {
 
 private int itemCode;
 private String itemDesc;
 private double unitPrice;
 private int taxCode;
 private int quantityLevel;
 private int reOrderLevel;
 
 
 public Inventory( )
 {
  this.itemCode=0;
  this.itemDesc="";
  this.unitPrice=0;
  this.taxCode=0;
  this.quantityLevel=0;
  this.reOrderLevel=0;
  
 }
 public Inventory(int itemCode, String itemDesc, double unitPrice, int taxCode, int quantityLevel, int reOrderLevel )
 {
  this.itemCode=itemCode;
  this.itemDesc=itemDesc;
  this.unitPrice=unitPrice;
  this.taxCode=taxCode;
  this.quantityLevel=quantityLevel;
  this.reOrderLevel=reOrderLevel;
  
 }

 public int getItemCode() {
  return itemCode;
 }


 public String getItemName() {
  return itemDesc;
 }


 public double getUnitPriceOfItem() {
  return unitPrice;
 }


 public int getTaxCode() {
  return taxCode;
 }


 public int getQtyLeft() {
  return quantityLevel;
 }


 public int getReorderLevel() {
  return reOrderLevel;
 }


 public void setItemCode(int itemCode) {
  this.itemCode = itemCode;
 }


 public void setItemName(String itemDesc) {
  this.itemDesc = itemDesc;
 }


 public void setUnitPriceItem(double unitPrice) {
  this.unitPrice = unitPrice;
 }


 public void setTaxCode(int taxCode) {
  this.taxCode = taxCode;
 }


 public void setQtyLeft(int quantityLevel) {
  this.quantityLevel = quantityLevel;
 }


 public void setReorderLevel(int reOrderLevel) {
  this.reOrderLevel = reOrderLevel;
 }
 
 
}
