/*
 * Copyright 2012-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.boot.autoconfigure.data.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

/**
 * A specialized {@link RepositoryRestMvcConfiguration} that applies configuration items
 * from the {@code spring.data.rest} namespace.
 * <p>
 *
 * @author Stephane Nicoll
 * @since 1.2.2
 */
@Configuration
class SpringBootRepositoryRestMvcConfiguration extends RepositoryRestMvcConfiguration {

	@Autowired
	private RepositoryRestProperties properties;

	@Bean
	@Override
	public RepositoryRestConfiguration config() {
		RepositoryRestConfiguration config = super.config();
		this.properties.applyTo(config);
		return config;
	}

}