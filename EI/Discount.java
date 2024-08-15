package EI;

import EI.Interface.DiscountStrategy;

class Discount implements DiscountStrategy {
    public double applyDiscount(double percentage) {
        return percentage / 100;
    }
}

class SeasonSale implements DiscountStrategy {
    public double applyDiscount(double percentage) {
        return percentage / 100;
    }
}
