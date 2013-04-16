package blog;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import blog.Author;
import blog.BlogPosts;
import blog.Category;
import blog.Post;
import blog.Tags;

public class BlogFactory {
	static BlogPost getBlogPost(int id) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		String url = "jdbc:mysql://localhost/blog";
		String user = "root";
		String password = "";

		try {
			con = DriverManager.getConnection(
					url, user, password);
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM post WHERE id="	+ id + " INNER JOIN author ON post.author = author.id INNER JOIN category ON post.category = category.id");

			if (rs.next()) {
				BlogPost blogPost = new BlogPost();
				blogPost.setTitle(rs
						.getString("title"));
				blogPost.setContent(rs
						.getString("content"));
				blogPost.setAuthor(rs
						.getString("author.author"));
				blogPost.setCategory(rs
						.getString("category.category"));

				return blogPost;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	static List<Post> getBlogPosts(BlogPosts blogPosts) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		List<Post> ret = new ArrayList<Post>();

		String url = "jdbc:mysql://localhost/blog";
		String user = "root";
		String password = ""; 

		try {
			con = DriverManager.getConnection(
					url, user, password);
			st = con.createStatement();
//			rs = st.executeQuery("SELECT * FROM post INNER JOIN author ON post.author = author.id INNER JOIN category ON post.category = category.id INNER JOIN tags ON post.id = tags.post_id");
			rs = st.executeQuery("SELECT * FROM post INNER JOIN author ON post.author = author.id INNER JOIN category ON post.category = category.id");

			while (rs.next()) {
				Post blogPost = new Post();
				blogPost.setTitle(rs
						.getString("title"));
				blogPost.setContent(rs
						.getString("content"));
				blogPost.setId(rs.getInt("post.id"));
				
				Author aut = new Author();
				aut.setName(rs.getString("author.author"));
				blogPost.authorList.add(aut);
				
				Category cat = new Category();
				cat.setCategory(rs.getString("category.category"));
				blogPost.categoryList.add(cat);
				
				setTagsOnPost(blogPost, blogPosts);
				ret.add(blogPost);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ret;
	}
	
	public static void setTagsOnPost(Post post, BlogPosts blogPosts)
	{
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		List<Tags> ret = new ArrayList<Tags>();

		String url = "jdbc:mysql://localhost/blog";
		String user = "root";
		String password = ""; 

		try {
			con = DriverManager.getConnection(
					url, user, password);
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM tagsconnections WHERE postId = " + post.getId());

			while (rs.next()) {
				Tags tag = blogPosts.getTag(rs.getInt("tagId"));
				
				if ( tag != null)
				{
					post.tagList.add(tag);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public static List<Tags> getBlogTags(BlogPosts blogPosts) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		List<Tags> ret = new ArrayList<Tags>();

		String url = "jdbc:mysql://localhost/blog";
		String user = "root";
		String password = ""; 

		try {
			con = DriverManager.getConnection(
					url, user, password);
			st = con.createStatement();
//			rs = st.executeQuery("SELECT * FROM post INNER JOIN author ON post.author = author.id INNER JOIN category ON post.category = category.id INNER JOIN tags ON post.id = tags.post_id");
			rs = st.executeQuery("SELECT * FROM tags");

			while (rs.next()) {
				Tags tag = new Tags();
				tag.setTag(rs.getString("tags.tag"));
				tag.setId(rs.getInt("tags.id"));
				ret.add(tag);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ret;
	}

	
	
	public static void createPost() {
		Connection con = null;

		String url = "jdbc:mysql://localhost/";
		String user = "root";
		String password = "";
		
		BlogPosts blogPosts = new BlogPosts();
		String title = "";
		String content = "";
		
		for(int i = 0; i < blogPosts.items.size(); i++) { 
			title = blogPosts.items.get(i).getTitle();
			content = blogPosts.items.get(i).getContent();
		}
		
	
		try {
			con = DriverManager.getConnection(url, user, password);

			PreparedStatement prepStmt = (PreparedStatement) con.prepareStatement("INSERT INTO post (id, title, content, author, category) VALUES (NULL, ?, ?, 0, 0)");
			prepStmt.setString(1, title);
			prepStmt.setString(2,  content);

			System.out.println(prepStmt.toString());
			prepStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
