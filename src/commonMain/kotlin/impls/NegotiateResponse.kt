package signalr.kt.impls

import signalr.enum.TransportType

internal class NegotiateResponse(
    val connectionId: String,
    val connectionToken: String,
    val availableTransports: Set<String> = HashSet(),
    val redirectUrl: String,
    val accessToken: String,
    val error: String,
    val finalUrl: String,
    val version: String,
    val chosenTransport: TransportType,
) {
}