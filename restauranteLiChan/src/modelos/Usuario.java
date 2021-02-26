package modelos;

public class Usuario {
	private int idUsuario;
	private String login;
	private String password;
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Usuario(int idUsuario, String login, String password) {
		super();
		this.idUsuario = idUsuario;
		this.login = login;
		this.password = password;
	}
	public Usuario() {
		super();
	}
	
}
