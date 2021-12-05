import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IpAddressUtilTests {
    @Test
    public void validateAnyIp() {
        Assertions.assertTrue(IpAddressUtil.validateIpv4Address("1.1.1.1"));
    }
}
