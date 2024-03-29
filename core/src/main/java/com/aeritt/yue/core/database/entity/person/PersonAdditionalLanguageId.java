package com.aeritt.yue.core.database.entity.person;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
public class PersonAdditionalLanguageId implements Serializable {
	private String personId;
	private int languageId;
}
