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

import java.util.HashMap;
import java.util.List;

public class Database implements DatabaseHelper {

	public static DatabaseHelper databaseHelper;
	public static HashMap<String, TableHelper> TableList;
	public static String dbType;

	public void connect(String url, String username, String password) {

		databaseHelper.connect(url, username, password);

	}

	@Override
	public void insert(String tableName, List<String> columns,
			List<Value> values) {

		databaseHelper.insert(tableName, columns, values);
	}

	@Override
	public void registerTable(String tableName) {

		databaseHelper.registerTable(tableName);

	}

	@Override
	public int getTotalNoOfRows(String tableName) {

		int noOfRows = 0;
		noOfRows = databaseHelper.getTotalNoOfRows(tableName);
		return noOfRows;
	}

	@Override
	public void deleteAllRows(String tableName) {

		databaseHelper.deleteAllRows(tableName);

	}

	@Override
	public boolean checkExist(String tableName, String value) {

		return databaseHelper.checkExist(tableName, value);
	}

	@Override
	public List<Value> getValue(String tableName,List<Value> values,List<String> dataTypes) {

		return databaseHelper.getValue(tableName,values,dataTypes);
	}
}
