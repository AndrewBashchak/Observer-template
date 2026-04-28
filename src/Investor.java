class Investor implements Observer {
    private String name;

    public Investor(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public void update(String stockName, double newPrice) {
        System.out.println("Investor " + name + " notified: Stock " + stockName + " changed price to " + newPrice);
    }
}
