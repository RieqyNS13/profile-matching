package rieqyns13;

public class ComboItem
{
	private Object id;
    private String key;
    private String value;

    public ComboItem(Object id,String key, String value)
    {
    	this.id=id;
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString()
    {
        return key+" - "+value;
    }
    public Object getId() {
    	return id;
    }
    public String getKey()
    {
        return key;
    }

    public String getValue()
    {
        return value;
    }
}