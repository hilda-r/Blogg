package blog;

public class BlogPost {
	
	private String title;
	private String content;
	private String author;
	private String category;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	
	/*@Override
	public String toString() {
		return "Blog Post \nTitle: " + title + "\nContent: " + content + "\nAuthor: " + author + "\nCategory: " + category + "";
	}*/


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
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}


}
