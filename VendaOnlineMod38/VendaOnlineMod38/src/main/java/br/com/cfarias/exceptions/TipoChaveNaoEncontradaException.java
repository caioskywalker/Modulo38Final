package br.com.cfarias.exceptions;

public class TipoChaveNaoEncontradaException extends Exception {

	private static final long serialVersionUID = 6626214212115912338L;

	
	public TipoChaveNaoEncontradaException(String msg) {
        this(msg,null);
    }

    public TipoChaveNaoEncontradaException(String msg, Throwable e) {
        super(msg, e);
    }
}
