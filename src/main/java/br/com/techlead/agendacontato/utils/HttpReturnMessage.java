package br.com.techlead.agendacontato.utils;

/**
* Classe de apoio dos serviços rest.
*
* @author  José Aleixo Araujo Porpino Filho
* @version 1.0
* @since   19/01/2018 
*/
public class HttpReturnMessage {
	private int errorCode; // 0 - OK, 1 - Erro, 2 - Exception
	private String message;
	private Object object;
	
	public HttpReturnMessage(int errorCode, String message, Object object) {
		super();
		this.errorCode = errorCode;
		this.message = message;
		this.object = object;
	}
	
	public HttpReturnMessage() {
	}

	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getObject() {
		return object;
	}
	public void setObject(Object object) {
		this.object = object;
	}
	@Override
	public String toString() {
		return "HttpReturnMessage [errorCode=" + errorCode + ", message=" + message + ", object=" + object + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + errorCode;
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + ((object == null) ? 0 : object.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HttpReturnMessage other = (HttpReturnMessage) obj;
		if (errorCode != other.errorCode)
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (object == null) {
			if (other.object != null)
				return false;
		} else if (!object.equals(other.object))
			return false;
		return true;
	}
}
