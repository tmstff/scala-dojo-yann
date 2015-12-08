package specials.monads.motivation;

public class Contract {
    private final Tariff tariff;

    public Contract(Tariff tariff) {
        this.tariff = tariff;
    }

    public Tariff getTariff() {
        return tariff;
    }
}
