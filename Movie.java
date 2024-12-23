public class Movie {

    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String _title;
    private Price _price;

    private Movie _movie;
    private int _daysRented;

     public int getPriceCode() {
        return _price.getPriceCode();
     }

    public void setPriceCode(int arg) {
      switch (arg) {
         case REGULAR:
            _price = new RegularPrice();
            break;
         case CHILDRENS:
            _price = new ChildrensPrice();
            break;
         case NEW_RELEASE:
            _price = new NewReleasePrice();
            break;
         default:
            throw new IllegalArgumentException("Incorrect Price Code");
      }
   }

    public String getTitle() {
        return _title;
    }

    public int getDaysRented() {
        return _daysRented;
    }

    public Movie getMovie() {
        return _movie;
    }

   public double getCharge(int daysRented){
    double thisAmount = 0;
    switch (getMovie().getPriceCode()) {
        case Movie.REGULAR:
            thisAmount += 2;
            if (getDaysRented() > 2)
                thisAmount += (getDaysRented() - 2) * 1.5;
            break;
        case Movie.NEW_RELEASE:
            thisAmount += getDaysRented() * 3;
            break;
        case Movie.CHILDRENS:
            thisAmount += 1.5;
            if (getDaysRented() > 3)
                thisAmount += (getDaysRented() - 3) * 1.5;
            break;
    }
    return thisAmount;
   }

   public int getFrequentRenterPoints(int daysRented){
    return _price.getFrequentRenterPoints(daysRented);
}
}