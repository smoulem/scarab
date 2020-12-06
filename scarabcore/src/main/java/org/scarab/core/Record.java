package org.scarab.core;

public interface Record {

	int fieldCount();

	Object getFieldValue(int fieldIndex);

	void setFieldValue(int fieldIndex, Object fieldValue);
}
