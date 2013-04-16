package blog;
public class Author {

	private String name;
	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void PrintAuthor(){
		System.out.println("Author: " + getName());
	}
	
	public String returnAuthor() {
		return getName();
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
