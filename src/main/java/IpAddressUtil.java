import java.util.regex.Pattern;
import java.util.stream.Stream;

public class IpAddressUtil {
    private static final int MINIMUM_POSSIBLE_VALUE = 0;
    private static final int MAXIMUM_POSSIBLE_VALUE = 255;
    private static final int VALID_OCTETS_COUNT = 4;
    private static final String OCTET_DELIMITER_PATTERN = ".";

    public static boolean validateIpv4Address(String ip) {
        if (hasNotValidOctets(ip)) return false;
        if (hasNotFourOctets(ip)) return false;
        return true;
    }

    private static String[] getOctets(String ip) {
        return ip.split(Pattern.quote(OCTET_DELIMITER_PATTERN));
    }

    private static boolean hasNotValidOctets(String ip) {
        String[] octets = getOctets(ip);
        return Stream.of(octets).anyMatch(IpAddressUtil::isNotValidOctet);
    }

    private static boolean isNotValidOctet(String octetString) {
        try {
            int octet = Integer.parseInt(octetString);
            if (octet != MINIMUM_POSSIBLE_VALUE && octetString.startsWith(String.valueOf(MINIMUM_POSSIBLE_VALUE))) return false;
            return octet < MINIMUM_POSSIBLE_VALUE || octet > MAXIMUM_POSSIBLE_VALUE;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean hasNotFourOctets(String ip) {
        String[] octets = getOctets(ip);
        return octets.length != VALID_OCTETS_COUNT;
    }

    private static boolean isBroadcastAddress(String ip) {
        return ip.endsWith("." + String.valueOf(MAXIMUM_POSSIBLE_VALUE));
    }

    private static boolean isNetworkAddress(String ip) {
        return ip.endsWith("." + String.valueOf(MINIMUM_POSSIBLE_VALUE));
    }
}
