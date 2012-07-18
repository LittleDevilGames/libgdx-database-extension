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
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import com.venura.sql.Database;
import com.venura.sql.DatabaseHelper;
import com.venura.sql.Value;
import com.venura.wordshooter.android.MyDatabaseHelper;

public class AndroidSqliteDatabase implements DatabaseHelper {

	/*
	 * SQlLite Database functionalities
	 */

	private MyDatabaseHelper myDatabaseHelper;
	private static AndroidSqlliteTableHelper databaseTable;
	private SQLiteDatabase database;
	private String url = null;
	private String username = null;
	private String password = null;

	public AndroidSqliteDatabase(DatabaseOpenHelper databaseOpenHelper) {

		this.myDatabaseHelper = (MyDatabaseHelper) databaseOpenHelper;
	}

	@Override
	public void connect(String url, String username, String password) {

		if (url == null || username == null || password == null) {
			this.url = url;
			this.username = username;
			this.password = password;
		}

		try {
			database = myDatabaseHelper.getWritableDatabase();
		} catch (SQLiteException e) {

			System.out.println("SQLite Exception thrown.");
		}

	}

	@Override
	public synchronized void insert(String tableName, List<String> columns,
			List<Value> values) {

		registerTable(tableName);
		if (databaseTable != null) {

			checkConnectionAlive();
			databaseTable.setConnection(database);
			databaseTable.insert(tableName, columns, values);

		}

	}

	public void registerTable(String tableName) {

		databaseTable = (AndroidSqlliteTableHelper) Database.TableList
				.get(tableName);
	}

	public void checkConnectionAlive() {

		if (database == null || !database.isOpen()) {

			this.connect(url, username, password);
		}
	}

	@Override
	public synchronized int getTotalNoOfRows(String tableName) {

		int noOfRows = 0;

		registerTable(tableName);

		if (databaseTable != null) {
			checkConnectionAlive();
			databaseTable.setConnection(database);
			noOfRows = databaseTable.getTotalNoOfRows(tableName);
		}
		return noOfRows;
	}

	@Override
	public synchronized void deleteAllRows(String tableName) {

		if (databaseTable != null) {
			checkConnectionAlive();
			databaseTable.setConnection(database);
			databaseTable.deleteAllRows(tableName);
		}
	}

	
	@Override
	public synchronized boolean checkExist(String tableName, String value) {

		registerTable(tableName);

		if (databaseTable != null) {
			checkConnectionAlive();
			databaseTable.setConnection(database);
		}
		return databaseTable.checkExist(tableName, value);
	}

	@Override
	public List<Value> getValue(String tableName,List<Value> values,List<String> dataTypes) {

		registerTable(tableName);

		if (databaseTable != null) {
			checkConnectionAlive();
			databaseTable.setConnection(database);
		}

		return databaseTable.getValue(tableName,values,dataTypes);
	}
}