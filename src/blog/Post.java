package blog;
import java.util.ArrayList;
import java.util.List;


public class Post {
	
	private String title;
	private String content;

	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<Author> getAuthorList() {
		return authorList;
	}

	public void setAuthorList(List<Author> authorList) {
		this.authorList = authorList;
	}

	public List<Category> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(
			List<Category> categoryList) {
		this.categoryList = categoryList;
	}

	public List<Author> authorList = new ArrayList<Author>();
	public List<Category> categoryList = new ArrayList<Category>();
	
		
	public void PrintPost() {
		System.out.println("Title: " + title + "\nContent: " + content);
		for(int i = 0; i < authorList.size(); i++){
			authorList.get(i).PrintAuthor();
		}
		for(int i = 0; i < categoryList.size(); i++){
			categoryList.get(i).PrintCategory();
		}
	}
	
	public String returnPost() {
		for(int i = 0; i < authorList.size(); i++){
			authorList.get(i).returnAuthor();
		}
		for(int i = 0; i < categoryList.size(); i++){
			categoryList.get(i).returnCategory();
		}
		return "Title: " + title + "\nContent: " + content;
		
	}
	
}
