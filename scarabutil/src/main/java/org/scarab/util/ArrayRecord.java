package org.scarab.util;

import org.scarab.core.Record;

public class ArrayRecord implements Record {

	private Object[] fields;

	public ArrayRecord(Object[] fields) {
		this.fields = fields;
	}

	@Override
	public int fieldCount() {
		return fields.length;
	}

	@Override
	public Object getFieldValue(int fieldIndex) {
		return this.fields[fieldIndex];
	}

	@Override
	public void setFieldValue(int fieldIndex, Object fieldValue) {
		this.fields[fieldIndex] = fieldValue;
	}
}
