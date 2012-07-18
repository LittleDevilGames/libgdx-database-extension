/*******************************************************************************
 * Copyright 2012 A A D V S Abeysinghe
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/

package com.venura.sql;

import java.util.ArrayList;
import java.util.List;

/*This class is for performance gains in large database transactions
 * 
 */

public class ValuePool {

	private int poolSize = 0;
	private List<Value> valueList = new ArrayList<Value>();

	public ValuePool(int poolSize) {

		this.poolSize = poolSize;
		initialize();
	}

	/*
	 * Creates the value pool for reuse
	 */
	public void initialize() {

		for (int i = 0; i < poolSize; i++) {

			valueList.add(new Value());
		}

	}

	public List<Value> getValues() {

		return valueList;
	}

	public int getSize() {

		return poolSize;
	}

}
