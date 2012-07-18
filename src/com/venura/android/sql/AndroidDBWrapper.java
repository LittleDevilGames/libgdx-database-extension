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

import android.view.View;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.venura.sql.Database;

public class AndroidDBWrapper extends AndroidApplication {

	/*
	 * Wrapper class for the Android. This wrapper creates the link between
	 * android database functionalities and libgdx
	 */

	public void initializeDBApplication(ApplicationListener listener,
			boolean useGL2IfAvailable, String dbType,
			DatabaseOpenHelper databaseOpenHelper) {

		Database.databaseHelper = new AndroidDatabase(dbType,
				databaseOpenHelper);
		initialize(listener, useGL2IfAvailable);
	}

	public void initializeDBApplication(ApplicationListener listener,
			AndroidApplicationConfiguration arg1, String dbType,
			DatabaseOpenHelper databaseOpenHelper) {

		Database.databaseHelper = new AndroidDatabase(dbType,
				databaseOpenHelper);
		initialize(listener, arg1);
	}

	public View initializeDBAppForView(ApplicationListener listener,
			boolean useGL2IfAvailable, String dbType,
			DatabaseOpenHelper databaseOpenHelper) {

		View view = null;
		
		Database.databaseHelper = new AndroidDatabase(dbType,
				databaseOpenHelper);
		view = initializeForView(listener, useGL2IfAvailable);
		return view;
	}

	public View initializeDBAppForView(ApplicationListener listener,
			AndroidApplicationConfiguration arg1, String dbType,
			DatabaseOpenHelper databaseOpenHelper) {

		View view = null;

		Database.databaseHelper = new AndroidDatabase(dbType,
				databaseOpenHelper);
		view = initializeForView(listener, arg1);
		return view;
	}
}
