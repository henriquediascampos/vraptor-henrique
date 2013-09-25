/***
 * Copyright (c) 2009 Caelum - www.caelum.com.br/opensource
 * All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package br.com.caelum.vraptor.converter;

import static br.com.caelum.vraptor.VRaptorMatchers.hasMessage;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import org.junit.Before;
import org.junit.Test;


public class PrimitiveIntConverterTest {

	private PrimitiveIntConverter converter;

	@Before
	public void setup() {
        this.converter = new PrimitiveIntConverter();
	}

	@Test
	public void shouldBeAbleToConvertNumbers() {
		assertThat(converter.convert("2", int.class), is(equalTo(2)));
	}

	@Test
	public void shouldComplainAboutInvalidNumber() {
		try {
			converter.convert("---", int.class);
		} catch (ConversionException e) {
			assertThat(e.getValidationMessage(), hasMessage("--- is not a valid integer."));
		}
	}

	@Test
	public void shouldConvertToZeroWhenNull() {
		assertThat(converter.convert(null, int.class), is(equalTo(0)));
	}

	@Test
	public void shouldConvertToZeroWhenEmpty() {
		assertThat(converter.convert("", int.class), is(equalTo(0)));
	}

}
