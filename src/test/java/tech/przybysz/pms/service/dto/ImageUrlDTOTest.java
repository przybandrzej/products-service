package tech.przybysz.pms.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import tech.przybysz.pms.web.rest.TestUtil;

public class ImageUrlDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(ImageUrlDTO.class);
        ImageUrlDTO imageUrlDTO1 = new ImageUrlDTO();
        imageUrlDTO1.setId(1L);
        ImageUrlDTO imageUrlDTO2 = new ImageUrlDTO();
        assertThat(imageUrlDTO1).isNotEqualTo(imageUrlDTO2);
        imageUrlDTO2.setId(imageUrlDTO1.getId());
        assertThat(imageUrlDTO1).isEqualTo(imageUrlDTO2);
        imageUrlDTO2.setId(2L);
        assertThat(imageUrlDTO1).isNotEqualTo(imageUrlDTO2);
        imageUrlDTO1.setId(null);
        assertThat(imageUrlDTO1).isNotEqualTo(imageUrlDTO2);
    }
}
