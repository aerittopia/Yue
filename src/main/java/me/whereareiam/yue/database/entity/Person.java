package me.whereareiam.yue.database.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "yue_users")
@Getter
@Setter
@NoArgsConstructor
public class Person {
	@Id
	private int id;
	private String globalName;
	private String name;
}
