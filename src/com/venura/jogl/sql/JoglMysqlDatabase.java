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

package com.venura.jogl.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import com.venura.sql.Database;
import com.venura.sql.DatabaseHelper;
import com.venura.sql.Value;

public class JoglMysqlDatabase implements DatabaseHelper {

	/*
	 * MySQL specific implementations
	 */

	private static JoglMysqlTableHelper databaseTable;
	private static Connection connection = null;
	private String url = null;
	private String username = null;
	private String password = null;

	@Override
	public void connect(String url, String username, String password) {

		if (url == null || username == null || password == null) {
			this.url = url;
			this.username = username;
			this.password = password;
		}

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, username, password);

		} catch (SQLException e) {

		} catch (ClassNotFoundException e) {

		}

	}

	@Override
	public synchronized void insert(String tableName, List<String> columns,
			List<Value> values) {

		registerTable(tableName);

		if (databaseTable != null) {

			checkConnectionAlive();
			databaseTable.setConnection(connection);

			databaseTable.insert(tableName, columns, values);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.venura.wordshooter.sql.DatabaseHelper#registerTable(java.lang.String)
	 * Register the table to refer when executing sql queries
	 */
	public void registerTable(String tableName) {

		databaseTable = (JoglMysqlTableHelper) Database.TableList
				.get(tableName);
	}

	public void checkConnectionAlive() {

		try {
			if (connection == null || connection.isClosed()) {

				this.connect(url, username, password);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	@Override
	public synchronized int getTotalNoOfRows(String tableName) {

		int noOfRows = 0;

		registerTable(tableName);

		if (databaseTable != null) {
			checkConnectionAlive();
			databaseTable.setConnection(connection);
			noOfRows = databaseTable.getTotalNoOfRows(tableName);
		}
		return noOfRows;
	}

	@Override
	public synchronized void deleteAllRows(String tableName) {

		registerTable(tableName);

		if (databaseTable != null) {
			checkConnectionAlive();
			databaseTable.setConnection(connection);
			databaseTable.deleteAllRows(tableName);
		}
	}


	@Override
	public synchronized boolean checkExist(String tableName, String value) {

		registerTable(tableName);

		if (databaseTable != null) {
			checkConnectionAlive();
			databaseTable.setConnection(connection);
		}
		return databaseTable.checkExist(tableName, value);
	}

	@Override
	public List<Value> getValue(String tableName,List<Value> values,List<String> dataTypes) {

		registerTable(tableName);

		if (databaseTable != null) {
			checkConnectionAlive();
			databaseTable.setConnection(connection);
		}
		return databaseTable.getValue(tableName,values,dataTypes);
	}

}
