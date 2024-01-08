/**
 * Write a description of class Date here.
 *
 * Dror Granot
 * 305144842
 */
public class Apartment
{

    private int _noOfRooms;
    private double _area;
    private double _price;
    private Person _tenant;
    private Date _rentalStartDate;
    private Date _rentalEndDate;
    
     /**
     * Constructor given detailed values for colors
     * @param red Red value for pixel
     * @param green Green value for pixel
     * @param blue Blue value for pixel
     */

    public Apartment( int noOfRooms, double area, double price, Person tenant, int startDay, int startMonth, int startYear, int endDay, int endMonth, int endYear){
        
        this._noOfRooms = noOfRooms > 0 ? noOfRooms : 3;
        this._area = area > 0 ? area : 80.0;
        this._price = price > 0 ? price: 5000;
        this._tenant = tenant;
        this._rentalStartDate = new Date(startDay, startMonth ,startYear);
        this._rentalEndDate =  new Date( endDay ,  endMonth ,endYear);
        
        if(_rentalStartDate.after(_rentalEndDate) || _rentalStartDate.equals(_rentalEndDate) ){
            this._rentalEndDate = new Date(startDay, startMonth ,startYear + 1);
        }

    }

    public Apartment(Apartment other){
        
        this._noOfRooms =  other.getNoOfRooms();
        this._area = other.getArea();
        this._price = other.getPrice();
        this._tenant = other.getTenant();
        this._rentalStartDate = other.getRentalStartDate();
        this._rentalEndDate = other.getRentalEndDate();
    }

    public int getNoOfRooms(){
        
        return _noOfRooms;
    }

    public double getArea(){
        
        return _area;
    }

    public double getPrice(){
        
        return _price;
    }

    public Person getTenant(){
        
        return _tenant;
    }

    public Date getRentalStartDate(){
        
        return _rentalStartDate;
    }

    public Date getRentalEndDate(){
        
        return _rentalEndDate;
    }

    public void setNoOfRooms(int num){
        
        if( num > 0 ) this._noOfRooms = num;
    }

    void setArea(double area){
        
        if( area > 0 ) this._area = area;
    }

    void setPrice(double price){
        
        if ( price > 0) this._price = price;
    }

    void setTenant(Person p){
        
        this._tenant = new Person(p);
    }

    void setRentalStartDate(Date d){
        
        this._rentalStartDate = new Date(d);
    }

    void setRentalEndDate(Date d){
        
        this._rentalEndDate = new Date(d);
    }

    public boolean equals(Apartment other){
        
        return(this._noOfRooms == other.getNoOfRooms() && this._area == other.getArea() && this._price == other.getPrice() && this._rentalStartDate.equals(other.getRentalStartDate())&& this._rentalEndDate.equals(other.getRentalEndDate()));
    }

    public String toString(){
        
        return "Number of rooms: " +_noOfRooms + "\nArea: " + _area + "\nPrice: " + _price + " NIS" + "\nTenant name: " + _tenant.getName() + "\nRental start date: " + this._rentalStartDate.toString() + "\nRental end date: "+ this._rentalEndDate.toString() +"\n";
    }

    public void extendRentalPeriod( int years ){
        
        if( years > 0 ) this._rentalEndDate.setYear( _rentalEndDate.getYear() + years );
    }

    public int daysLeft( Date d ){
        
        return this._rentalEndDate.after(d) ?  this._rentalEndDate.difference(d) : -1 ;
    }

    public boolean changeTenant( Date startDate, Person p, double price){

        if(this._tenant.getDateOfBirth().before(p.getDateOfBirth())){

            if(price >= this._price ){

                if(this._rentalEndDate.difference(startDate) <= 90){

                    setTenant(p);
                    setPrice(price);
                    setRentalStartDate(startDate);
                    setRentalEndDate(startDate.addYearsToDate(1));

                    return true;

                }
            }
        }
        return false;

    }

}
