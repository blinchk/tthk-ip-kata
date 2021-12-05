import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IpAddressUtilTests {
    @Test
    public void validateIpWithThreeOctets() {
        Assertions.assertTrue(IpAddressUtil.validateIpv4Address("0.0.0"));
    }
}
