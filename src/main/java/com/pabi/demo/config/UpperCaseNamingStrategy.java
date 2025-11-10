package com.pabi.demo.config;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategy;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

public class UpperCaseNamingStrategy implements PhysicalNamingStrategy {

	@Override
	public Identifier toPhysicalTableName(Identifier logicalName, JdbcEnvironment jdbcEnvironment) {
		//return Identifier.toIdentifier("\"" + logicalName.getText().toUpperCase() + "\"");
		return Identifier.toIdentifier(logicalName.getText());
		//return null;
	}

	@Override
	public Identifier toPhysicalColumnName(Identifier name, JdbcEnvironment jdbcEnvironment) {
		//return Identifier.toIdentifier("\"" + name.getText() + "\"");
		return Identifier.toIdentifier( name.getText() );
	}

	@Override
	public Identifier toPhysicalCatalogName(Identifier logicalName, JdbcEnvironment jdbcEnvironment) {
		return null;
	}

	@Override
	public Identifier toPhysicalSchemaName(Identifier logicalName, JdbcEnvironment jdbcEnvironment) {
		//System.out.println("logicalName:: "+ logicalName + "  jdbcEnvironment::- "+ jdbcEnvironment.getCurrentSchema());
		return Identifier.toIdentifier("\"" + jdbcEnvironment.getCurrentSchema().getText().toUpperCase() + "\"");
		//return null;
	}

	@Override
	public Identifier toPhysicalSequenceName(Identifier logicalName, JdbcEnvironment jdbcEnvironment) {
		// TODO Auto-generated method stub
		return null;
	}
}
