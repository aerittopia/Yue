package com.aeritt.yue.core.database.entity.person;

import com.aeritt.yue.core.database.entity.Language;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "yue_user_languages")
@Getter
@Setter
@NoArgsConstructor
@IdClass(PersonAdditionalLanguageId.class)
public class PersonAdditionalLanguage {
	@Id
	@Column(name = "user_id")
	private String personId;

	@Id
	@Column(name = "language_id", length = 100)
	private int languageId;

	@ManyToOne
	@JoinColumn(name = "user_id", insertable = false, updatable = false)
	private Person person;

	@ManyToOne
	@JoinColumn(name = "language_id", insertable = false, updatable = false)
	private Language language;
}