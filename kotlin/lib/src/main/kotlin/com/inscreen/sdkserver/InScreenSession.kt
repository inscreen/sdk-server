package com.inscreen.sdkserver

import kotlinx.serialization.Serializable
import java.time.Instant

@Serializable
class InScreenSession private constructor(val v: Int, val userId: String, val teamId: String, val timestamp: Long) {
    constructor(userId: String, teamId: String) : this(
        v = 1,
        userId = userId,
        teamId = teamId,
        timestamp = Instant.now().getEpochSecond()
    )

    constructor(userId: String, teamId: String, timestamp: Instant) : this(
        v = 1,
        userId = userId,
        teamId = teamId,
        timestamp = timestamp.getEpochSecond()
    )
}
