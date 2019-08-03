package TheActandClubs;
public class Contact {
	private String qq;
	private String phone;
	private String mail;
	private String wechat;
	private String web;
	public Contact()
	{
		this.phone="13910241968";
		this.mail="1861191685@qq.com";
		this.web="��Ҳ��֪��";
		this.wechat="��֪��";
		this.qq="��֪��";
	}
	public Contact(String qqnum,String phone,String mail,String wechat,String web)
	{
		this.qq=qqnum;
		this.phone=phone;
		this.web=web;
		this.mail=mail;
		this.wechat=wechat;
	}
	public void setqqnum(String qqnum)
	{
		this.qq=qqnum;
	}
	public void setMail(String qqnum)
	{
		this.mail=qqnum;
	}
	public void setWeb(String qqnum)
	{
		this.web=qqnum;
	}
	public void setWeChat(String qqnum)
	{
		this.wechat=qqnum;
	}
	public void setPhone(String qqnum)
	{
		this.phone=qqnum;
	}
	public String getQQ()
	{
		return this.qq;
	}
	public String getPhone()
	{
		return this.phone;
	}
	public String getWeb()
	{
		return this.web;
	}
	public String getWeChat()
	{
		return this.wechat;
	}
	public String getMail()
	{
		return this.mail;
	}
	public String getContact()
	{
		String message="��ַΪ�� "+this.getWeb()
						+"����Ϊ��"+this.getMail()
						+"΢�ź�Ϊ "+this.getWeChat()
						+"�绰����Ϊ��"+this.getPhone()
						+"QQ����Ϊ"+this.getQQ();
		return message;
	}
}
