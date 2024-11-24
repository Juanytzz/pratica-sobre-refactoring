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
        int points = 1; // Inicializa com 1 ponto

    // Adiciona bônus para lançamentos novos com mais de 1 dia de locação
    if (getMovie().getPriceCode() == Movie.NEW_RELEASE && getDaysRented() > 1) {
        points = 2;
    }

    return points;
     }
 }