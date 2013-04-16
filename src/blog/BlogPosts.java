package blog;
import java.util.ArrayList;
import java.util.List;


public class BlogPosts {
	
	public List<Post> items = new ArrayList<Post>();
	public List<Tags> tagList = new ArrayList<Tags>();
	public List<Author> authors = new ArrayList<Author>();
	public List<Category> categories = new ArrayList<Category>();
	
	public void PrintList(){
		for(int i = 0; i < items.size(); i++){
			items.get(i).PrintPost();	
		}
	}
	
	public Tags getTag(int id) {
		for (int i = 0; i < tagList.size(); i++) {
			Tags tag = tagList.get(i);
			if (tag.getId() == id) {
				return tag;
			}
		}
		return null;
	}
	
	public Author getAuthor(int id) {
		for (int i = 0; i <authors.size(); i++ ) {
			Author auth = authors.get(i);
			if (auth.getId() == id) {
				return auth;
			}
		}
		return null;
	}
	
	public Category getCategory(int id) {
		for(int i = 0; i < categories.size(); i++ ){	
			Category cat = categories.get(i);
			if (cat.getId() == id) {
				return cat;
			}
		}
		return null;
	}


}
