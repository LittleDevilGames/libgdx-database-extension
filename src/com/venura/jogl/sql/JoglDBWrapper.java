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

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.jogl.JoglApplication;
import com.venura.sql.Database;

public class JoglDBWrapper {
	/*
	 * Database wrapper for windows Desktop version
	 */

	public JoglDBWrapper(ApplicationListener applicationListener, String title,
			int height, int width, boolean is2GLAvailable, String dbType) {

		Database.databaseHelper = new JoglDatabase(dbType);
		new JoglApplication(applicationListener, title, height, width,
				is2GLAvailable);

	}

}