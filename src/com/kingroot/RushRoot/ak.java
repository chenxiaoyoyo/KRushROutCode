package com.kingroot.RushRoot;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import android.content.Context;
import android.content.res.AssetManager;

public class ak {
	public static boolean a;
	public static final String b = a ? "http://wuptest.cs0309.3g.qq.com"
			: "http://www.kingroot.net/proxy.php";
	private static String c;
	private static int d;
	private static String e;

	public static String a() {
		return c;
	}

	public static String b() {
		return e;
	}

	static void a(Context context, String strParam1, String strParam2) {
		AssetManager assetMng = context.getAssets();
		InputStream input = null;
		try {
			input = assetMng.open("config.properties");
			byte[] arrayb = new byte[1024];
			ByteArrayOutputStream output = new ByteArrayOutputStream();

			int len = 0;
			while ((len = input.read(arrayb)) > 0) {
				output.write(arrayb, 0, len);
			}
			// cond_2
			byte[] outCyrbyte = Cryptor.y(context, output.toByteArray());
			output.close();

			Properties prop = new Properties();
			ByteArrayInputStream inputStream = new ByteArrayInputStream(
					outCyrbyte);
			prop.load(inputStream);
			c = prop.getProperty("channel");
			
			if (strParam1 != null) {				
				c = strParam1;
			}
			
			
		} catch (IOException e) {
			// catch_0
			c = "0";
			if (input != null) {
				input.close();
			}
		}

	}
}
