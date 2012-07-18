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

/*
 * Interface that defines table level sql query functions
 */
package com.venura.sql;

import java.util.List;

public interface TableHelper {

	public void insert(String tableName,List<String> columns,List<Value> values);
	public int getTotalNoOfRows(String tableName);
	public void deleteAllRows(String tableName);
	public boolean checkExist(String tableName,String value);
	public List<Value> getValue(String tableName,List<Value> values,List<String> dataTypes);
	
}
