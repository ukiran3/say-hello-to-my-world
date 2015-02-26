
public class Transactions {

 
 private int  code;
 private int quantity;
 
 public Transactions()
 {
  this.code=0;
  this.quantity=0;
  
 }
 
 public Transactions(int code, int quantity)
 {
  this.code= code;
  this.quantity= quantity;
  
 }

 public int getCode() {
  return code;
 }

 public void setCode(int code) {
  this.code = code;
 }

 public int getQty() {
  return quantity;
 }

 public void setQty(int quantity) {
  this.quantity = quantity;
 }
 

}
