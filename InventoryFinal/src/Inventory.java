

public class Inventory 
{
	private int code;
	private String description;
	private double unitPrice;
	private int taxCode;
	private int quantity;
	private int reOrderLevel;
	private boolean flag;
	
	public Inventory() throws Exception
	{
		code = 1;
		description = "";
		unitPrice = 0;
		taxCode = 0;
		quantity = 0;
		reOrderLevel = 0;
		
	}
	public Inventory(int code, String description, double unitPrice, int taxCode, int quantity, int reOrderLevel) throws Exception
	{
		this.code = code;
		this.description = description;
		this.unitPrice = unitPrice;
		this.taxCode = taxCode;
		this.quantity = quantity;
		this.reOrderLevel = reOrderLevel;
		
	}
	
	public boolean getFlag()
	{
		return this.flag;
	}
	public void setFlag(boolean flag)
	{
		this.flag = flag;
	}
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getTaxCode() {
		return taxCode;
	}

	public void setTaxCode(int taxCode) {
		this.taxCode = taxCode;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getReOrderLevel() {
		return reOrderLevel;
	}

	public void setReOrderLevel(int reOrderLevel) {
		this.reOrderLevel = reOrderLevel;
	}
	
	
}
