package com.kingroot.RushRoot;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.AssetManager;

public class ak {
	public static boolean a;
	public static final String b = a ? "http://wuptest.cs0309.3g.qq.com"
			: "http://www.kingroot.net/proxy.php";
	private static String cpkgChannel;
	private static int dVersionCode;
	private static String eVersionName;

	public static String agetChannel() {
		return cpkgChannel;
	}

	public static String bgetVersionName() {
		return eVersionName;
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
			cpkgChannel = prop.getProperty("channel");
			
			if (strParam1 != null) {				
				cpkgChannel = strParam1;
			}
			if (input != null) {
				input.close();
			}
			//goto_1		
		} catch (IOException e) {
			// catch_0
			c = "0";			
			//goto_1
		} finally {
			if (input != null) {
				input.close();
			}
		}
		//goto_1
		try {
			PackageManager pkgmng = context.getPackageManager();
			String pkgName = context.getPackageName();
			PackageInfo pkginfo = pkgmng.getPackageInfo(pkgName, 0);
			eVersionName = pkginfo.versionName;
			dVersionCode = pkginfo.versionCode;
			if (strParam2 != null) {
				eVersionName = strParam2;
			}
		} catch (NameNotFoundException ex) {
			//catch_2
			eVersionName = "1.0.0";
			dVersionCode = 0xb;
		}
	}
}
