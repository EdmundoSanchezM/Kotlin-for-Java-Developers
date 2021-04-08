package taxipark

/*
 * Task #1. Find all the drivers who performed no trips.
 */
fun TaxiPark.findFakeDrivers(): Set<Driver> =
    this.allDrivers - this.trips.map { it.driver }.toSet()

/*
 * Task #2. Find all the clients who completed at least the given number of trips.
 */
fun TaxiPark.findFaithfulPassengers(minTrips: Int): Set<Passenger> =
    if (minTrips == 0) this.allPassengers else
        this.trips.flatMap { it.passengers }.groupingBy { it }.eachCount().filter {
            it.value >= minTrips
    }.keys

/*
 * Task #3. Find all the passengers, who were taken by a given driver more than once.
 */
fun TaxiPark.findFrequentPassengers(driver: Driver): Set<Passenger> =
    this.trips.filter { it.driver == driver }.flatMap { it.passengers }.groupingBy { it }.eachCount().filter { it.value > 1 }.keys

/*
 * Task #4. Find the passengers who had a discount for majority of their trips.
 */
fun TaxiPark.findSmartPassengers(): Set<Passenger> = this.trips.flatMap {
    it.passengers.map { passenger -> Pair(passenger, it) }
}.groupBy { it.first }.filter {
    it.value.count { (_, trip) -> trip.discount != null } >
            it.value.count { (_, trip) -> trip.discount == null }
}.keys
/*
 * Task #5. Find the most frequent trip duration among minute periods 0..9, 10..19, 20..29, and so on.
 * Return any period if many are the most frequent, return `null` if there're no trips.
 */
fun TaxiPark.findTheMostFrequentTripDurationPeriod(): IntRange? = this.trips.map {
    (it.duration - (it.duration % 10))..(it.duration + 9 - (it.duration % 10))
}.groupingBy { it }.eachCount().maxBy { it.value }?.key
/*
 * Task #6.
 * Check whether 20% of the drivers contribute 80% of the income.
 */
fun TaxiPark.checkParetoPrinciple(): Boolean {
    val driversByIncome = this.trips.groupBy { it.driver }.mapValues {
        it.value.sumByDouble { trip -> trip.cost }
    }
    val pct80totalIncome = driversByIncome.values.sum() * 0.8
    val pct20totalDrivers = this.allDrivers.size * 0.2
    var currentIncome = 0.0
    print("\n------\ntrips=$driversByIncome\n\n")
    driversByIncome.toList().sortedByDescending { it.second }.forEachIndexed { index, it ->
        if (index >= pct20totalDrivers) return (currentIncome >= pct80totalIncome) && (currentIncome != 0.0)
        currentIncome += it.second
        print("currentIncome = $currentIncome index=$index pct80totalIncome=$pct80totalIncome pct20totalDrivers=$pct20totalDrivers\n")
    }
    return false
}