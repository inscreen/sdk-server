package com.inscreen.sdkserver

import kotlinx.serialization.Serializable
import java.time.Instant

@Serializable
class InScreenSession private constructor(
    val v: Int,
    val userId: String,
    val teamId: String,
    val timestamp: Long,
    val additionalTeamIds: Array<String>? = null,
    val additionalTeamLinks: Array<String>? = null
) {
    constructor(userId: String, teamId: String, additionalTeamIds: Array<String>? = null, additionalTeamLinks: Array<String>? = null) : this(
        v = 1,
        userId = userId,
        teamId = teamId,
        timestamp = Instant.now().getEpochSecond(),
        additionalTeamIds = additionalTeamIds,
        additionalTeamLinks = additionalTeamLinks
    )

    constructor(userId: String, teamId: String, timestamp: Instant, additionalTeamIds: Array<String>? = null, additionalTeamLinks: Array<String>? = null) : this(
        v = 1,
        userId = userId,
        teamId = teamId,
        timestamp = timestamp.getEpochSecond(),
        additionalTeamIds = additionalTeamIds,
        additionalTeamLinks = additionalTeamLinks
    )
}
