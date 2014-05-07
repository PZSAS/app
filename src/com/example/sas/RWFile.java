package com.example.sas;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import android.content.Context;
import android.content.res.AssetManager;

public class RWFile {
	
	public static int[][] read(Context context,String name){
		int[][] signals;
		
		try{
            //Instantiate the file object
            File file = new File(name);
            //Instantiate the input stread
            //InputStream insputStream = new FileInputStream(file);
            int id = context.getResources().getIdentifier(name, "raw", context.getPackageName());
            InputStream insputStream = context.getResources().openRawResource(id);//.openRawResource(R.raw.u000001_2014_04_01);
            
            long length = file.length();
            byte[] bytes = new byte[(int) length];
            
            byte[] FPDM = new byte[4];
            insputStream.read(FPDM);
            byte[] timestamp = new byte[4];
            insputStream.read(timestamp);
            byte[] fileSize = new byte[4];
            insputStream.read(fileSize);
            byte[] signalCount = new byte[2];
            insputStream.read(signalCount);
            byte[] duration = new byte[4];
            insputStream.read(duration);
            byte[] reservedFile = new byte[8];
            insputStream.read(reservedFile);
            
            signals = new int[toUInteger(signalCount,2)][];
            
            for(short j = 0; j < toUInteger(signalCount,2); j++){
            	byte[] DATA = new byte[4];
                insputStream.read(DATA);
                byte[] signalId = new byte[2];
                insputStream.read(signalId);
                byte[] frequency = new byte[2];
                insputStream.read(frequency);
                byte[] probeSize = new byte[2];
                insputStream.read(probeSize);
                byte[] probeCount = new byte[4];
                insputStream.read(probeCount);
                byte[] reservedSignal = new byte[4];
                insputStream.read(reservedSignal);
                
                //byte[][] signals = new byte[toInteger(probeCount)][];
                //int signal[] = new int[toInteger(probeCount)];
                signals[j] = new int[toInteger(probeCount,4)];
                byte[] probe = new byte[toUInteger(probeSize,2)];
                
                for(int i = 0; i < toUInteger(probeCount,4); i++){
                	//signals[i] = new byte[toInteger(probeSize)];
                    //insputStream.read(signals[i]);
                	insputStream.read(probe);
                	//signal[i] = toInteger(probe);
                	signals[j][i] = toInteger(probe,toUInteger(probeSize,2));
                }
                
                byte[] STOP = new byte[4];
                insputStream.read(STOP);
            }
            
            insputStream.close();
            
            //String s = new String(bytes);
            //Print the byte data into string format
            //System.out.println(s);
            
            return signals;
		}catch(Exception e){
            System.out.println("Error is:" + e.getMessage());
            signals = new int[1][];
            signals[0] = new int[1];
            signals[0][0] = -1;
            return signals;
		}
		
		
	}
	
	private static short toUShort(byte[] b, int i){
		short number;
		if(i == 2){
			number = (short)((short)(b[1] << 8) & 0xFF);
			number += (short)b[0] & 0xFF;
		}
		else
			number = (short)((short)b[0] & 0xFF);
		return number;
	}
	
	private static short toShort(byte[] b, int i){
		short number;
		if(i == 2){
			number = (short)(b[1] << 8);
			number += (short)b[0] & 0xFF;
		}
		else
			number = (short)b[0];
		return number;
	}
	
	private static int toInteger(byte[] b,int i){
		int number;
		if(i == 4){
			number = (int)(b[3] << 24);
			number += (int)(b[2] << 16) & 0xFF;
			number += (int)(b[1] << 8) & 0xFF;
			number += (int)b[0] & 0xFF;
		}
		else if(i == 2){
			number = (int)(b[1] << 8);
			number += (int)b[0] & 0xFF;
		}
		else
			number = (int)b[0] & 0xFF;
		return number;
	}
	
	private static int toUInteger(byte[] b,int i){
		int number;
		if(i == 4){
			number = (int)(b[3] << 24) & 0xFF;
			number += (int)(b[2] << 16) & 0xFF;
			number += (int)(b[1] << 8) & 0xFF;
			number += (int)b[0] & 0xFF;
		}
		else if(i == 2){
			number = (int)(b[1] << 8) & 0xFF;
			number += (int)b[0] & 0xFF;
		}
		else
			number = (int)b[0] & 0xFF;
		return number;
	}
	
	private static long toLong(byte[] b){
		int number;
		number = (int)(b[3] << 24) & 0xFF;
		number += (int)(b[2] << 16) & 0xFF;
		number += (int)(b[1] << 8) & 0xFF;
		number += (int)b[0] & 0xFF;
		return number;
	}
	
}
