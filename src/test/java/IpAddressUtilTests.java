import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IpAddressUtilTests {
    @Test
    public void validateIpWithThreeOctetsIsInvalid() {
        Assertions.assertFalse(IpAddressUtil.validateIpv4Address("10.0.1"));
    }

    @Test
    public void validateNetworkAddressIsInvalid() {
        Assertions.assertFalse(IpAddressUtil.validateIpv4Address("1.1.1.0"));
    }

    @Test
    public void validateBroadcastAddressIsInvalid() {
        Assertions.assertFalse(IpAddressUtil.validateIpv4Address("255.255.255.255"));
    }
}
