/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.seguridad;

//import pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.auditoria.LoggerAnnotation;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * @author I301324
 */
public class SeguridadUtil {

    private static InetAddress ip;

//    @LoggerAnnotation(modulo="seguridad")
    public static String getIPLocal() throws UnknownHostException {
        ip = InetAddress.getLocalHost();
        
        String ipString=  ip.getHostAddress();
        return ipString;
    }

    public static String getMACAddress() {
        StringBuilder sb = new StringBuilder();

        try {
            NetworkInterface network = NetworkInterface.getByInetAddress(ip);
            byte[] mac = network.getHardwareAddress();

            for (int i = 0; i < mac.length; i++) {
                sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static String getOsName() {
        String OS = null;
        if (OS == null) {
            OS = System.getProperty("os.name");
        }
        return OS;
    }

}
