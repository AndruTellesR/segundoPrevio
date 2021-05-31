package com.util;

import java.io.Serializable;

public class Variable implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String NAME_BD = "elecciones";  //mnjgxshj
	public static final String USER_BD = "root"; //mnjgxshj

	public static final String PASSWORD_BD = ""; //Uzjqo00sxV0W9OzPEB1q3wpoVvGMbbUV
	public static final String DRIVER_BD = "com.mysql.jdbc.Driver"; //org.postgresql.Driver
	public static final String URL_SERVLET = "jdbc:mysql://localhost:3306/"; //jdbc:postgresql://queenie.db.elephantsql.com:5432/

	public static final String URL_ONE = URL_SERVLET + NAME_BD;
}