package blog;
public class Category {
	
	private String category;
	
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
