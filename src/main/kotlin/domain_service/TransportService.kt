package domain_service

class TransportService {
    fun transport(from: PhysicalDistributionBase, to: PhysicalDistributionBase, baggage: Baggage) {
        val shippedBaggage = from.ship(baggage)
        to.receive(shippedBaggage)
    }
}
