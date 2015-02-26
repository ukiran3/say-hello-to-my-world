
public class Inventory {
	
	private int itemCode;
	private String itemName;
	private double unitPriceItem;
	private int taxCode;
	private int quantityLeft;
	private int reorderLevel;
	
	
	public Inventory( )
	{
		this.itemCode=0;
		this.itemName="";
		this.unitPriceItem=0;
		this.taxCode=0;
		this.quantityLeft=0;
		this.reorderLevel=0;
		
	}
	public Inventory(int itemCode, String itemName, double unitPriceItem, int taxCode, int quantityLeft, int reorderLevel )
	{
		this.itemCode=itemCode;
		this.itemName=itemName;
		this.unitPriceItem=unitPriceItem;
		this.taxCode=taxCode;
		this.quantityLeft=quantityLeft;
		this.reorderLevel=reorderLevel;
		
	}

	public int getItemCode() {
		return itemCode;
	}


	public String getItemName() {
		return itemName;
	}


	public double getUnitPriceItem() {
		return unitPriceItem;
	}


	public int getTaxCode() {
		return taxCode;
	}


	public int getQuantityLeft() {
		return quantityLeft;
	}


	public int getReorderLevel() {
		return reorderLevel;
	}


	public void setItemCode(int itemCode) {
		this.itemCode = itemCode;
	}


	public void setItemName(String itemName) {
		this.itemName = itemName;
	}


	public void setUnitPriceItem(double unitPriceItem) {
		this.unitPriceItem = unitPriceItem;
	}


	public void setTaxCode(int taxCode) {
		this.taxCode = taxCode;
	}


	public void setQuantityLeft(int quantityLeft) {
		this.quantityLeft = quantityLeft;
	}


	public void setReorderLevel(int reorderLevel) {
		this.reorderLevel = reorderLevel;
	}
	
	
	
	
	
	


}
