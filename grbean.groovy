class Car {
    int numberOfDoors
    String model
    String brand
    boolean automatic
    double price
    final double speed //now you can't use the setSpeed method (final makes it read-only)
    private String color

    Car()
    {
        speed = 240.0
    }

    public void setBrand(brand)
    {
        this.brand = brand + '( set via setter method) '
    }

    /*still public get/set methods are generated!!*/
    protected void setColor(color)
    {
        this.color = color
    }

    String toString() {
        "[Car details => brand: '${brand}', model: '${model}', \
        #doors: '${numberOfDoors}', automatic: '${automatic}', \
        price: '${price}' , speed: ${speed} , color: ${color} ]"
	} 
}


/*everything here is set through set methods*/
Car ford = new Car(brand: 'Ford', model: 'Focus', numberOfDoors: 4,
                   automatic: false, price: 24995, color:'red')

println ford.brand

/*bypassing set methods by  .@ operator*/
ford.@brand = 'FORD ROCKS'

/*get method is implicitly called*/
println ford.brand

/*bypassing the get method*/
println ford.@brand

/*Groovy automatically generates set/get methods */
ford.setNumberOfDoors(3)
ford.setModel("A3")
ford.setBrand("AUDI")
ford.setPrice(32010)
ford.setColor('blue')



println ford
