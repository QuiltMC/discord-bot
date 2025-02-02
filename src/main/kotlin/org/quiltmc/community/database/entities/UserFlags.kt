/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

@file:Suppress("DataClassShouldBeImmutable", "DataClassContainsFunctions")  // Well, yes, but actually no.

package org.quiltmc.community.database.entities

import dev.kord.common.entity.Snowflake
import dev.kordex.core.utils.getKoin
import kotlinx.serialization.Serializable
import org.quiltmc.community.database.Entity
import org.quiltmc.community.database.collections.UserFlagsCollection

@Serializable
data class UserFlags(
	override val _id: Snowflake,

	var autoPublish: Boolean = true,
	var syncNicks: Boolean = true,
	var usePKFronter: Boolean = false,
) : Entity<Snowflake> {
	suspend fun save() {
		val collection = getKoin().get<UserFlagsCollection>()

		collection.set(this)
	}
}
