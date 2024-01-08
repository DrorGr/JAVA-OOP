/**
 * DATE Class MAMAN 12.1.
 *
 * Dror Granot
 * 305144842
 */
public class Date
{
    private int _day; 
    private int _month;

    private int _year;

    private static final int DEFAULT_DAY = 1;
    private static final int DEFAULT_MONTH = 1;
    private static final int DEFAULT_YEAR = 2000;

    private static final int MAX_DAYS_FEB = 28;
    private static final int MAX_DAYS_LEAP_FEB = 29;
    private static final int MAX_DAYS_APR_JUN_SPT_NOV = 30;
    private static final int MAX_DAYS_JAN_MAR_MAY_JUL_AUG_OCT_DEC = 31;

    /**
     * Constructor given detailed values for a date
     * @param day Day value for a date
     * @param month Month value for date
     * @param year Year value for date
     */

    public Date(int day, int month, int year){

        if(isDateValid(day, month ,year)){

            this._day = day;
            this._month = month;
            this._year = year;

        }else{

            this._day = DEFAULT_DAY;
            this._month = DEFAULT_MONTH;
            this._year = DEFAULT_YEAR;

        }

    }

    /**
     * Copy constructor given exicting date values for a date
     * @param other Date value to copy
     */
    public Date (Date other){

        if(isDateValid (other.getDay(), other.getMonth() ,other.getYear() )){

            this._day = other.getDay();
            this._month = other.getMonth();
            this._year = other.getYear();

        }else{

            this._day = DEFAULT_DAY;
            this._month = DEFAULT_MONTH;
            this._year = DEFAULT_YEAR;

        }

    }

    /**
     * Get the day of the date;
     * @return the dates' day value;
     */
    public int getDay(){
        return _day;
    }

    /**
     * Get the month of the date;
     * @return the dates' month value;
     */
    public int getMonth(){
        return _month;
    }

    /**
     * Get the year of the date;
     * @return the dates' year value;
     */
    public int getYear(){
        return _year;
    }

     /**
     * Set the day of the date;
     * @param the dates' new day value;
     */
    public void setDay(int dayToSet){
        this._day = dayToSet;
    }

       /**
     * Set the month of the date;
     * @param the dates' new month value;
     */
    public void setMonth(int monthToSet){
        this._month = monthToSet;
    }

      /**
     * Set the year of the date;
     * @param the dates' new year value;
     */
    public void setYear(int yearToSet){
        this._year = yearToSet;
    }

      /**
     * Checks if the Day passed is the same as the current Date;
     * @param the date to check;
     * @return T/F whether the dates are the same or not; 
     */
    public boolean equals (Date other){

        int otherDay = other.getDay();
        int otherMonth = other.getMonth();
        int otherYear = other.getYear();

        if(this._year == otherYear && this._month == otherMonth && this._year == otherYear) return true;

        return false;
    }

    /**
     * Copy constructor given exicting date values for a date
     * @param other Date value to copy
     */
    public boolean before (Date other){

        int otherDay = other.getDay();
        int otherMonth = other.getMonth();
        int otherYear = other.getYear();

        if(otherYear > this._year ){
            return true;
        }
        if(otherYear == this._year && otherMonth > this._month){
            return true;
        }
        if(otherYear == this._year && otherMonth == this._month && otherDay > this._day){
            return true;
        }
        return false;
    }

    /**
     * Copy constructor given exicting date values for a date
     * @param other Date value to copy
     */
    public boolean after (Date other) {
        return !before(other); 
    }

    /**
     * Copy constructor given exicting date values for a date
     * @param other Date value to copy
     */
    public int difference (Date other) {

        return Math.abs(calculateDate(_day,_month,_year) - calculateDate(other.getDay(),other.getMonth(),other.getYear()));

    }

    /**
     * Copy constructor given exicting date values for a date
     * @param other Date value to copy
     */
    public String toString() {

        String day = _day < 10 ? "0" + String.valueOf(_day) : String.valueOf(_day);
        String month = _month < 10 ? "0" + String.valueOf(_month) : String.valueOf(_month);

        return day + "/" + month + "/" + _year;
    }

    /**
     * Copy constructor given exicting date values for a date
     * @param other Date value to copy
     */
    public Date addYearsToDate(int num){

        int newYear = this._year + num;
        int newDay = isLeapYear(newYear) && _month == 2 && _day == 28? 29 : _day;

        Date newDate = new Date( newDay ,_month, newYear);

        return  newDate ;
    }

    /**
     * Copy constructor given exicting date values for a date
     * @param other Date value to copy
     */
    // computes the day number since the beginning of the Christian counting of years
    private int calculateDate ( int day, int month, int year)
    {
        if (month < 3) {
            year--;
            month = month + 12;
        }
        return 365 * year + year/4 - year/100 + year/400 + ((month+1) * 306)/10 + (day - 62);
    } 

    /**
     * Copy constructor given exicting date values for a date
     * @param other Date value to copy
     */
    // checks if the year is a leap year
    private boolean isLeapYear (int y)
    {
        return (y%4==0 && y%100!=0) || (y%400==0) ? true : false;
    } 

    /**
     * Copy constructor given exicting date values for a date
     * @param other Date value to copy
     */
    private boolean isDateValid( int day, int month, int year){

        if(year > 0 && month < 13 && month > 0 && day > 0  ){

            if(month == 2 ){

                if(isLeapYear(year)){

                    return day > 0 && day < MAX_DAYS_LEAP_FEB;
                }else {
                    return day > 0 && day < MAX_DAYS_FEB;
                }

            }else if ( month == 4 || month == 6 || month == 9 || month == 11 ){

                return day < MAX_DAYS_APR_JUN_SPT_NOV ;
            }
            else{

                return day < MAX_DAYS_JAN_MAR_MAY_JUL_AUG_OCT_DEC;
            }
        }else{

            return false;
        }
    }

}
