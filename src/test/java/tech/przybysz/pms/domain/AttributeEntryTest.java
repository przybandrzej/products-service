package tech.przybysz.pms.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import tech.przybysz.pms.web.rest.TestUtil;

public class AttributeEntryTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(AttributeEntry.class);
        AttributeEntry attributeEntry1 = new AttributeEntry();
        attributeEntry1.setId(1L);
        AttributeEntry attributeEntry2 = new AttributeEntry();
        attributeEntry2.setId(attributeEntry1.getId());
        assertThat(attributeEntry1).isEqualTo(attributeEntry2);
        attributeEntry2.setId(2L);
        assertThat(attributeEntry1).isNotEqualTo(attributeEntry2);
        attributeEntry1.setId(null);
        assertThat(attributeEntry1).isNotEqualTo(attributeEntry2);
    }
}
