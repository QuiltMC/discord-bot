/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

plugins {
	`api-module`
	`cozy-module`
	`published-module`
	testing
}

dependencies {
	detektPlugins(libs.detekt)
	detektPlugins(libs.detekt.libraries)

	ksp(libs.kordex.annotationProcessor)

	implementation(libs.kordex.annotations)
	implementation(libs.kordex.core)
	implementation(libs.kordex.unsafe)

	// Optional for bots that don't need it
	compileOnly(libs.kordex.pluralkit)

	implementation(libs.autolink)
	implementation(libs.flexver)
	implementation(libs.jsoup)
	implementation(libs.kaml)
	implementation(libs.logging)
	implementation(libs.semver)

	implementation(platform(libs.kotlin.bom))
	implementation(libs.kotlin.stdlib)
}
