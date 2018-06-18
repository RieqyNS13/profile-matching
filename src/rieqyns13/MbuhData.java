package rieqyns13;

public class MbuhData {
	private Object key;
	private Object value;
	public void setKey(Object key) {
		this.key=key;
	}
	public void setValue(Object value) {
		this.value=value;
	}
	public Object getKey() {
		return this.key;
	}
	public Object getValue() {
		return this.value;
	}
	public MbuhData(Object key, Object value) {
		setKey(key);
		setValue(value);
	}
	@Override
	public String toString() {
		return (String)this.getValue();
	}
}
