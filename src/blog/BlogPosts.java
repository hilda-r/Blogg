package blog;
import java.util.ArrayList;
import java.util.List;


public class BlogPosts {
	
	public List<Post> items = new ArrayList<Post>();
	
	public void PrintList(){
		for(int i = 0; i < items.size(); i++){
			items.get(i).PrintPost();	
		}
	}


}
