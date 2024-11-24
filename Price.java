public abstract class Price {
    public abstract int getPriceCode();
    public abstract double getCharge(int daysRented);

    private Movie _movie;
    private int _daysRented;

    public int getDaysRented() {
        return _daysRented;
    }

    public Movie getMovie() {
        return _movie;
    }

    public int getFrequentRenterPoints(int daysRented) {
        return 1;
     }
 }