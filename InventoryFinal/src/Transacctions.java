
public class Transacctions
{
	private int icode;
	private int quan;
	public Transacctions()
	{
		this(0, 0);
	}
	public Transacctions(int icode, int quan)
	{
		this.icode = icode;
		this.quan = quan;
	}
	public int getIcode() {
		return icode;
	}
	public void setIcode(int icode) {
		this.icode = icode;
	}
	public int getQuan() {
		return quan;
	}
	public void setQuan(int quan) {
		this.quan = quan;
	}
	
}
