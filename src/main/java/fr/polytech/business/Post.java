package fr.polytech.business;

public class Post {
    private String content;

    public Post(String content) {
        this.content = content;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Post{" +
                "content='" + content + '\'' +
                '}';
    }
}
