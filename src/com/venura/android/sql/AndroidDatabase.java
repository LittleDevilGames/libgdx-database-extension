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

package com.venura.android.sql;

import java.util.List;

import com.venura.sql.DatabaseHelper;
import com.venura.sql.Value;

public class AndroidDatabase implements DatabaseHelper {

	public static DatabaseHelper dbHelper;
	private String dbType;
	private DatabaseOpenHelper databaseOpenHelper;

	public AndroidDatabase(String dbType, DatabaseOpenHelper databaseOpenHelper) {

		this.databaseOpenHelper = databaseOpenHelper;
		this.dbType = dbType;
	}

	/*
	 * Creates the android database connection (non-Javadoc)
	 * 
	 * @see com.venura.wordshooter.sql.DatabaseHelper#connect(java.lang.String,
	 * java.lang.String, java.lang.String)
	 */

	@Override
	public void connect(String url, String username, String password) {

		if (dbType.equals(DatabaseHelper.SQLite)) {

			dbHelper = new AndroidSqliteDatabase(databaseOpenHelper);
		}

		dbHelper.connect(url, username, password);

	}

	@Override
	public void insert(String tableName, List<String> columns,
			List<Value> values) {

		dbHelper.insert(tableName, columns, values);
	}

	@Override
	public void registerTable(String tableName) {

		dbHelper.registerTable(tableName);

	}

	@Override
	public int getTotalNoOfRows(String tableName) {

		int noOfRows = 0;
		noOfRows = dbHelper.getTotalNoOfRows(tableName);
		return noOfRows;
	}

	@Override
	public void deleteAllRows(String tableName) {

		dbHelper.deleteAllRows(tableName);
	}


	@Override
	public boolean checkExist(String tableName, String value) {

		return dbHelper.checkExist(tableName, value);
	}

	@Override
	public List<Value> getValue(String tableName,List<Value> values,List<String> dataTypes) {

		return dbHelper.getValue(tableName,values,dataTypes);
	}

}