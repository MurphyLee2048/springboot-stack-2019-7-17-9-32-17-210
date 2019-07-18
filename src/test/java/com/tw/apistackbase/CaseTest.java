package com.tw.apistackbase;

import com.tw.apistackbase.model.CriminalCase;
import com.tw.apistackbase.model.CriminalElement;
import com.tw.apistackbase.repository.CaseRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@ExtendWith(SpringExtension.class)
public class CaseTest {
    @Autowired
    private CaseRepository caseRepository;

    @Test
    void should_find_Case_ById() {
        CriminalCase criminalCase = new CriminalCase();
        criminalCase.setCaseName("a");
        criminalCase.setTimeMillis(1111);
        CriminalElement criminalElement = new CriminalElement();
        criminalElement.setObjectiveDescription("xxx");
        criminalElement.setSubjectiveDescription("yyy");
        criminalCase.setCriminalElement(criminalElement);
        caseRepository.save(criminalCase);

        CriminalCase fetchedCriminalCase = caseRepository.findById(criminalCase.getCaseId()).get();

        assertThat(fetchedCriminalCase.getCaseName()).isEqualTo("a");
        assertThat(fetchedCriminalCase.getTimeMillis()).isEqualTo(1111);
        assertThat(fetchedCriminalCase.getCriminalElement()).isEqualTo(criminalElement);
    }
}
