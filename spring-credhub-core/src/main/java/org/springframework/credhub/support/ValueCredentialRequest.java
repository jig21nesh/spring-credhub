/*
 * Copyright 2016-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.credhub.support;

import org.springframework.util.Assert;

import static org.springframework.credhub.support.ValueType.VALUE;

/**
 * The details of a request to write a new or update an existing value credential in CredHub.
 *
 * @author Scott Frederick
 */
public class ValueCredentialRequest extends CredentialRequest<ValueCredential> {
	/**
	 * Create a builder that provides a fluent API for providing the values required
	 * to construct a {@link ValueCredentialRequest}.
	 *
	 * @return a builder
	 */
	public static ValueCredentialRequestBuilder builder() {
		return new ValueCredentialRequestBuilder();
	}

	/**
	 * A builder that provides a fluent API for constructing {@link ValueCredentialRequest}s.
	 */
	public static class ValueCredentialRequestBuilder
			extends CredentialRequestBuilder<ValueCredential, ValueCredentialRequest, ValueCredentialRequestBuilder> {
		@Override
		protected ValueCredentialRequest createTarget() {
			return new ValueCredentialRequest();
		}

		@Override
		protected ValueCredentialRequestBuilder createBuilder() {
			return this;
		}

		/**
		 * Set the value of a {@literal value} credential.
		 *
		 * @param value the credential value; must not be {@literal null}
		 * @return the builder
		 */
		public ValueCredentialRequestBuilder value(ValueCredential value) {
			Assert.notNull(value, "value must not be null");
			targetObj.setType(VALUE);
			targetObj.setValue(value);
			return this;
		}

		/**
		 * Set the value of a {@literal value} credential. 
		 *
		 * @param value the credential value; must not be {@literal null}
		 * @return the builder
		 */
		public ValueCredentialRequestBuilder value(String value) {
			Assert.notNull(value, "value must not be null");
			targetObj.setType(VALUE);
			targetObj.setValue(new ValueCredential(value));
			return this;
		}
	}

}