package blog;
import java.util.ArrayList;
import java.util.List;


public class BlogPosts {
	
	public List<Post> items = new ArrayList<Post>();
	public List<Tags> tagList = new ArrayList<Tags>();
	
	public void PrintList(){
		for(int i = 0; i < items.size(); i++){
			items.get(i).PrintPost();	
		}
	}
	
	public Tags getTag(int id)
	{
		for (int i = 0; i < tagList.size(); i++) {
			Tags tag = tagList.get(i);
			if (tag.getId() == id) {
				return tag;
			}
			
		}
		
		return null;
		
	}


}
