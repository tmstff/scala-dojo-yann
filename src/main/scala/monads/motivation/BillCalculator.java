package monads.motivation;

@SuppressWarnings("unused")
public class BillCalculator {

    // Oh no! What if any object is null!?
    public int calculateBillForUser(User user) {
        return user.getContract().getTariff().basicFee();
    }

    // Let's check all the objects in out getter chain
    // Hmmm... Looks familiar in our java world
    // but weird and boiler plated
    public int calculateBillForUser_3(User user) {
        if(user != null) {
            Contract contract = user.getContract();
            if(contract != null) {
                Tariff tariff = contract.getTariff();
                if (tariff != null) {
                    return tariff.basicFee();
                }
            }
        }

        return 0;
    }

    // Let's make in more in a return early style.
    // Pfuh... Many ifs. Many braces. 12 lines of
    // code only because this stuff can be null!?
    public int calculateBillForUser_2(User user) {
        if (user == null) {
            return 0;
        }

        Contract contract = user.getContract();
        if (contract == null) {
            return 0;
        }

        Tariff tariff = contract.getTariff();
        if(tariff == null) {
            return 0;
        }

        return tariff.basicFee();
    }
}
