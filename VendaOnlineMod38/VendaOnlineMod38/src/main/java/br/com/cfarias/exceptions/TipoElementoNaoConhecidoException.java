package br.com.cfarias.exceptions;

public class TipoElementoNaoConhecidoException extends Exception {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5646701081050834350L;

	public TipoElementoNaoConhecidoException(String msg) {
        this(msg, null);
    }

    public TipoElementoNaoConhecidoException(String msg, Throwable e) {
        super(msg, e);
    }
}
