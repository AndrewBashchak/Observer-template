class Broker implements Observer {
    private String name;

    public Broker(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public void update(String stockName, double newPrice) {
        System.out.println("Broker " + name + " notified: Stock " + stockName + " is now worth " + newPrice);
    }
}
