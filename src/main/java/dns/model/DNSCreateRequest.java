package dns.model;

import dns.model.request.Request;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Random;

public class DNSCreateRequest {

    private String domain = "medium.com";

    public void createRequest() throws IOException {
        Request request = new Request();

        //   0  1  2  3  4  5  6  7  8  9  0  1  2  3  4  5
        //    +--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+
        //    |                      ID                       |   16bits
        //    +--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+
        //    |QR|   Opcode  |AA|TC|RD|RA|   Z    |   RCODE   |    16 bits
        //    +--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+
        //    |                    QDCOUNT                        |16 bits
        //    +--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+
        //    |                    ANCOUNT                    |16 bits
        //    +--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+
        //    |                    NSCOUNT                    |16 bits
        //    +--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+
        //    |                    ARCOUNT                    |16 bits
        //    +--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+
        String flag = "";
        // QR — A one bit field that specifies whether this message is a
        // query (0), or a response (1).
        flag += '0';

        //OpCode — A four bit field that specifies kind of query in this
        //message. This value is set by the originator of a query
        //and copied into the response.  4 bits
        flag += "0000";

        //AA — Authoritative Answer — this bit is valid in responses,
        //and specifies that the responding name server is an
        //authority for the domain name in question section.

        flag += "0"; // AA

        //TC — TrunCation — specifies that this message was truncated
        //due to length greater than that permitted on the
        //transmission channel.

        flag += "0"; // TC
        //RD — Recursion Desired — this bit may be set in a query and
        //is copied into the response. If RD is set, it directs
        //the name server to pursue the query recursively.
        //Recursive query support is optional.
        flag += "1";
        // RA — Recursion Available — this be is set or cleared in a
        // response, and denotes whether recursive query support is
        // available in the name server.
        flag += "0"; // RA
        flag += "000"; // Z

        flag += "0000"; // RDCODE

        Random random = new Random();
        short ID = (short) random.nextInt(32767);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);


        short requestFlags = Short.parseShort(flag, 2);
        System.out.println(requestFlags);

        ByteBuffer flagsByteBuffer = ByteBuffer.allocate(2).putShort(requestFlags);
        System.out.println(flagsByteBuffer);
        byte[] flagsByteArray = flagsByteBuffer.array();

        short QDCOUNT = 1;
        short ANCOUNT = 0;
        short NSCOUNT = 0;
        short ARCOUNT = 0;
        try {
            dataOutputStream.writeShort(ID);
            dataOutputStream.write(flagsByteArray);
            dataOutputStream.writeShort(QDCOUNT);
            dataOutputStream.writeShort(ANCOUNT);
            dataOutputStream.writeShort(NSCOUNT);
            dataOutputStream.writeShort(ARCOUNT);
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
//      0  1  2  3  4  5  6  7  8  9  0  1  2  3  4  5
//    +--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+
//    |                                               |
//    /                     QNAME                     /
//    /                                               /
//    +--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+
//    |                     QTYPE                     |
//    +--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+
//    |                     QCLASS                    |

        String[] domainParts = domain.split("\\.");
        try {
            for (int i = 0; i < domainParts.length; i++) {
                byte[] domainBytes = domainParts[i].getBytes(StandardCharsets.UTF_8);
                dataOutputStream.writeByte(domainBytes.length);
                dataOutputStream.write(domainBytes);
            }
            dataOutputStream.writeByte(0);   // to show no more parts are there
            dataOutputStream.writeShort(1);//qtype
            dataOutputStream.writeShort(1); //qclass
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        byte[] dnsFrame = byteArrayOutputStream.toByteArray();
        System.out.println("Sending: " + dnsFrame.length + " bytes");

        for (int i = 0; i < dnsFrame.length; i++) {
            System.out.print(String.format("%s", dnsFrame[i]) + " ");
        }
        InetAddress address = InetAddress.getByName("1.1.1.1");
        DatagramSocket socket = new DatagramSocket();
        DatagramPacket packet = new DatagramPacket(dnsFrame, dnsFrame.length, address, 53);

        socket.send(packet);
    }
}
