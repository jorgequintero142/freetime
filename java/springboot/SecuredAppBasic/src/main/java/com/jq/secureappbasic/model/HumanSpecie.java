package com.jq.secureappbasic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HumanSpecie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idSpecie;
	@Column(name = "nameHumanSpecie", unique = true)
	private String nameHumanSpecie;
	private String descriptionHumanSpecie;

	public HumanSpecie() {
		super();
	}

	public HumanSpecie(String nameHumanSpecie, String descriptionHumanSpecie) {
		super();
		this.nameHumanSpecie = nameHumanSpecie;
		this.descriptionHumanSpecie = descriptionHumanSpecie;
	}

	public Long getIdSpecie() {
		return idSpecie;
	}

	public void setIdSpecie(Long idSpecie) {
		this.idSpecie = idSpecie;
	}

	public String getNameHumanSpecie() {
		return nameHumanSpecie;
	}

	public void setNameHumanSpecie(String nameHumanSpecie) {
		this.nameHumanSpecie = nameHumanSpecie;
	}

	public String getDescriptionHumanSpecie() {
		return descriptionHumanSpecie;
	}

	public void setDescriptionHumanSpecie(String descriptionHumanSpecie) {
		this.descriptionHumanSpecie = descriptionHumanSpecie;
	}
}
