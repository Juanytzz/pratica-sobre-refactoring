public class Movie {

    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String _title;
    private Price _price;

    private Movie _movie;
    private int _daysRented;

    public class RegularPrice extends Price {
        public int getPriceCode() {
            return Movie.REGULAR;
        }
     }

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
    return _price.getCharge(daysRented);
   }

   public int getFrequentRenterPoints(int daysRented){
    int points = 1; // Inicializa com 1 ponto

    // Adiciona bônus para lançamentos novos com mais de 1 dia de locação
    if (getMovie().getPriceCode() == Movie.NEW_RELEASE && getDaysRented() > 1) {
        points = 2;
    }

    return points;
}
}