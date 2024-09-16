package server.modules;
public class Book {
    private int id;
    private String name,author;
    public Book(){

    }
    public Book(int id,String name, String author){
        this.id = id;
        this.name = name;
        this.author = author;
    }

    public int getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public String getAuthor(){
        return this.author;
    }

    public boolean setId(int id){
        try{
            this.id = id;
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public boolean setName(String name){
        try{
            this.name = name;
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public boolean setAuthor(String author){
        try{
            this.author = author;
            return true;
        }catch(Exception e){
            return false;
        }
    }

    @Override
    public String toString() {
        return "Book{" + "id = " + this.id + ", name = " + this.name + ", author = " + this.author + '}';

    }
}
