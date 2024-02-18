package me.whereareiam.yue.core.database.repository;

import jakarta.transaction.Transactional;
import me.whereareiam.yue.core.database.entity.PersonAdditionalLanguage;
import me.whereareiam.yue.core.database.entity.PersonAdditionalLanguageId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonAdditionalLanguageRepository extends JpaRepository<PersonAdditionalLanguage, PersonAdditionalLanguageId> {
	List<PersonAdditionalLanguage> findByPersonId(String personId);

	@Modifying
	@Transactional
	void deleteByPersonIdAndLanguageId(String personId, int languageId);
}

