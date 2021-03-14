package tech.przybysz.pms.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import tech.przybysz.pms.web.rest.TestUtil;

public class AttributeEntryDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(AttributeEntryDTO.class);
        AttributeEntryDTO attributeEntryDTO1 = new AttributeEntryDTO();
        attributeEntryDTO1.setId(1L);
        AttributeEntryDTO attributeEntryDTO2 = new AttributeEntryDTO();
        assertThat(attributeEntryDTO1).isNotEqualTo(attributeEntryDTO2);
        attributeEntryDTO2.setId(attributeEntryDTO1.getId());
        assertThat(attributeEntryDTO1).isEqualTo(attributeEntryDTO2);
        attributeEntryDTO2.setId(2L);
        assertThat(attributeEntryDTO1).isNotEqualTo(attributeEntryDTO2);
        attributeEntryDTO1.setId(null);
        assertThat(attributeEntryDTO1).isNotEqualTo(attributeEntryDTO2);
    }
}
