package tech.przybysz.pms.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import tech.przybysz.pms.web.rest.TestUtil;

public class ImageUrlTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(ImageUrl.class);
        ImageUrl imageUrl1 = new ImageUrl();
        imageUrl1.setId(1L);
        ImageUrl imageUrl2 = new ImageUrl();
        imageUrl2.setId(imageUrl1.getId());
        assertThat(imageUrl1).isEqualTo(imageUrl2);
        imageUrl2.setId(2L);
        assertThat(imageUrl1).isNotEqualTo(imageUrl2);
        imageUrl1.setId(null);
        assertThat(imageUrl1).isNotEqualTo(imageUrl2);
    }
}
