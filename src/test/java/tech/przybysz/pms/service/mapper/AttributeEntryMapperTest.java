package tech.przybysz.pms.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class AttributeEntryMapperTest {

    private AttributeEntryMapper attributeEntryMapper;

    @BeforeEach
    public void setUp() {
        attributeEntryMapper = new AttributeEntryMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(attributeEntryMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(attributeEntryMapper.fromId(null)).isNull();
    }
}
