import java.util.Enumeration;

public abstract class Statement {
    
    public String value(Customer aCustomer) {
        String result = getHeader(aCustomer);
        Enumeration rentals = aCustomer.getRentals();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += getRentalLine(each);
        }
        result += getFooter(aCustomer);
        return result;
    }

    protected abstract String getHeader(Customer aCustomer);
    protected abstract String getRentalLine(Rental each);
    protected abstract String getFooter(Customer aCustomer);
}
