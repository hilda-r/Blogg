package blog;
public class Category {
	
	private String category;
	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	void PrintCategory(){
		System.out.println("Category: " + category);
	}
	
	String returnCategory() {
		return "Category: " + category;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}
