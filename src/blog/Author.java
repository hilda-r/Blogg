package blog;
public class Author {

	private String name;
	private String email;
	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void PrintAuthor(){
		System.out.println("Author: " + getName() + "\nEmail: " + email);
	}
	
	public String returnAuthor() {
		return getName();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
