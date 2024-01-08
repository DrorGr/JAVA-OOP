/**
 * Write a description of class Date here.
 *
 * Dror Granot
 * 305144842
 */
public class Person 
{
    private String _name;
    private String _id;
    private Date _dateOfBirth;

    public Person (String name, int day, int month, int year, String id){

        if( name.length() <= 0){
            this._name = "Someone";
        }
        else{
            this._name = name;
        }

        if( id.length() < 9 ){
            this._id =  "000000000"; 
        }else{
            this._id = id;
        }

        this._dateOfBirth = new Date(day,month,year);

    }

    public Person (Person other){
        
        this._name =  other.getName();
        this._id = other.getId();
        this._dateOfBirth = other.getDateOfBirth();
    }

    public  String getName(){
        return this._name;
    }

    public String getId(){
        return this._id;
    }

    public Date getDateOfBirth(){
        return this._dateOfBirth;
    }

    public void setName (String name){

        if(name.length() > 0)  this._name = name;
    }

    public void setId (String id){
        
        if(id.length() == 9) this._id = id;

    }

    public void setDateOfBirth (Date d ) {
        
        this._dateOfBirth = new Date(d);
    }

    public String toString(){
        
        return "Name: "+ _name+"\nID: "+_id +"\nDate of birth: "+_dateOfBirth; 

    }

    public boolean equals (Person other){
        
        return other.getId() ==_id && other.equals(_dateOfBirth) && other.getName()==_name;
    }

    public int compareTo(Person other){
        
        if(_dateOfBirth.before(other.getDateOfBirth())){
            
            return 1;
        }else if( _dateOfBirth.equals(other.getDateOfBirth())){
            
            return -1;
        }
        return 0;
    }
}
