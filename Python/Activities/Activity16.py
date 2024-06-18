class Car:
    def __init__(self, manufacturer, model, make, transmission, color):
        self.manufacturer = manufacturer
        self.model = model
        self.make = make
        self.transmission = transmission
        self.color = color
    
    def accelerate(self):
        print(f"{self.manufacturer} {self.model} is moving")

    def stop(self):
        print(f"{self.manufacturer} {self.model} has stopped")


car1 = Car("Maruti Suzuki", "Baleno", "2016", "Manual", "Blue")
car2 = Car("Hyundai", "Verna", "2020", "Manual", "Black")
car3 = Car("Homda", "City", "2022", "Manual", "White")

car1.accelerate()
car1.stop()

car2.accelerate()
car2.stop()

car3.accelerate()
car3.stop()