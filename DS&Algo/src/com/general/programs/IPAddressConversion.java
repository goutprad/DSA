package com.general.programs;

public class IPAddressConversion {

	public static void main(String[] args) {
		String ip1 = "192.168.72.25"; //C0A84819
		String ip2 = "127.0.0.1"; //7F000001
		String ip3 = "10.10.45.34"; //0A0A2D22
		String ip4 = "255.255.254.0"; //FFFFFE00
		String ip5 = "192.168.1.102"; //C0A80166

		System.out.println(ipConversion(ip1));
		System.out.println(ipConversion(ip2));
		System.out.println(ipConversion(ip3));
		System.out.println(ipConversion(ip4));
		System.out.println(ipConversion(ip5));
	}

	public static String ipConversion(String ip) {
		String[] ips = ip.split("\\.");
		String output = "";
		for (String str : ips) {
			String val = Integer.toHexString(Integer.parseInt(str)).toUpperCase();
			if (val.length() < 2)
				output += "0" + val;
			else
				output += val;
		}
		return output;
	}

}
