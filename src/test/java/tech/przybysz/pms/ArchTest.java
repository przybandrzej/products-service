package tech.przybysz.pms;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {

        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("tech.przybysz.pms");

        noClasses()
            .that()
                .resideInAnyPackage("tech.przybysz.pms.service..")
            .or()
                .resideInAnyPackage("tech.przybysz.pms.repository..")
            .should().dependOnClassesThat()
                .resideInAnyPackage("..tech.przybysz.pms.web..")
        .because("Services and repositories should not depend on web layer")
        .check(importedClasses);
    }
}
