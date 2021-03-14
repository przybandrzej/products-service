package tech.przybysz.pms.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ImageUrlMapperTest {

    private ImageUrlMapper imageUrlMapper;

    @BeforeEach
    public void setUp() {
        imageUrlMapper = new ImageUrlMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(imageUrlMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(imageUrlMapper.fromId(null)).isNull();
    }
}
