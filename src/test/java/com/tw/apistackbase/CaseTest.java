package com.tw.apistackbase;

import com.tw.apistackbase.model.CriminalCase;
import com.tw.apistackbase.model.CriminalElement;
import com.tw.apistackbase.repository.CaseRepository;
import com.tw.apistackbase.repository.ElementRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@ExtendWith(SpringExtension.class)
public class CaseTest {
    @Autowired
    private CaseRepository caseRepository;
    @Autowired
    private ElementRepository elementRepository;

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

    @Test
    void should_find_All_Cases() {
        CriminalCase criminalCase1 = new CriminalCase();
        criminalCase1.setCaseName("a");
        criminalCase1.setTimeMillis(1111);
        CriminalElement criminalElement1 = new CriminalElement();
        criminalElement1.setObjectiveDescription("xxx");
        criminalElement1.setSubjectiveDescription("yyy");
        criminalCase1.setCriminalElement(criminalElement1);
        caseRepository.save(criminalCase1);

        CriminalCase criminalCase2 = new CriminalCase();
        criminalCase2.setCaseName("b");
        criminalCase2.setTimeMillis(1111);
        CriminalElement criminalElement2 = new CriminalElement();
        criminalElement2.setObjectiveDescription("xxx");
        criminalElement2.setSubjectiveDescription("yyy");
        criminalCase2.setCriminalElement(criminalElement2);
        caseRepository.save(criminalCase2);

        List<CriminalCase> fetchedAllCriminalCase = caseRepository.findAll();

        assertThat(fetchedAllCriminalCase.get(0).getCaseName()).isEqualTo("a");
        assertThat(fetchedAllCriminalCase.get(1).getCaseName()).isEqualTo("b");
    }

    @Test
    void should_find_All_Cases_And_Sorted_ByTime() {
        CriminalCase criminalCase1 = new CriminalCase();
        criminalCase1.setCaseName("a");
        criminalCase1.setTimeMillis(19700208);
        CriminalElement criminalElement1 = new CriminalElement();
        criminalElement1.setObjectiveDescription("xxx");
        criminalElement1.setSubjectiveDescription("yyy");
        criminalCase1.setCriminalElement(criminalElement1);
        caseRepository.save(criminalCase1);

        CriminalCase criminalCase2 = new CriminalCase();
        criminalCase2.setCaseName("b");
        criminalCase2.setTimeMillis(19700209);
        CriminalElement criminalElement2 = new CriminalElement();
        criminalElement2.setObjectiveDescription("xxx");
        criminalElement2.setSubjectiveDescription("yyy");
        criminalCase2.setCriminalElement(criminalElement2);
        caseRepository.save(criminalCase2);

        List<CriminalCase> fetchedAllCriminalCase = caseRepository.findAllByOrderByTimeMillisDesc();


        assertThat(fetchedAllCriminalCase.get(0).getTimeMillis()).isEqualTo(19700209);
        assertThat(fetchedAllCriminalCase.get(1).getTimeMillis()).isEqualTo(19700208);
    }

    @Test
    void delete_Case_ById() {
        CriminalCase criminalCase1 = new CriminalCase();
        criminalCase1.setCaseName("a");
        criminalCase1.setTimeMillis(1111);
        CriminalElement criminalElement1 = new CriminalElement();
        criminalElement1.setObjectiveDescription("xxx");
        criminalElement1.setSubjectiveDescription("yyy");
        criminalCase1.setCriminalElement(criminalElement1);
        caseRepository.save(criminalCase1);

        CriminalCase criminalCase2 = new CriminalCase();
        criminalCase2.setCaseName("b");
        criminalCase2.setTimeMillis(1111);
        CriminalElement criminalElement2 = new CriminalElement();
        criminalElement2.setObjectiveDescription("xxx");
        criminalElement2.setSubjectiveDescription("yyy");
        criminalCase2.setCriminalElement(criminalElement2);
        caseRepository.save(criminalCase2);

        caseRepository.deleteById(criminalCase1.getCaseId());

        assertThat(caseRepository.findAll()).doesNotContain(criminalCase1);
    }


    @Test
    void find_Criminal_Element_ByElemetId() {
        CriminalElement criminalElement1 = new CriminalElement();
        criminalElement1.setObjectiveDescription("xxx");
        criminalElement1.setSubjectiveDescription("yyy");
        elementRepository.save(criminalElement1);

        CriminalElement criminalElement = elementRepository
                .findById(criminalElement1
                .getElementId()).get();

        assertThat(criminalElement).isEqualTo(criminalElement1);
    }


}
