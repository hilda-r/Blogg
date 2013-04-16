import blog.Author;
import blog.BlogPosts;
import blog.Category;
import blog.Post;


public class MainClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Author a = new Author();
		Category c = new Category();
		Post p = new Post();
		BlogPosts bp = new BlogPosts();
		
		a.setEmail("aa@aa.com");
		a.setName("Hilda");
		c.setCategory("category");
		p.setTitle("New title");
		p.setContent("Lorem ipsum dolor sit amet");
		p.authorList.add(a);
		p.categoryList.add(c);
		bp.items.add(p);
		
		Author a1 = new Author();
		Category c1 = new Category();
		Post p1 = new Post();
		
		a1.setEmail("bb@bb.com");
		a1.setName("John");
		c1.setCategory("other");
		p1.setTitle("Cool title");
		p1.setContent("Lorem ipsum dolor sit amet");
		p1.authorList.add(a1);
		p1.categoryList.add(c1);
		bp.items.add(p1);
		
		bp.PrintList();
		
	}

}
