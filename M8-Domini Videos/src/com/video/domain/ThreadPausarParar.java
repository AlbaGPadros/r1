package com.video.domain;

import java.util.Scanner;

public class ThreadPausarParar extends Thread {
	Scanner entrada2 = new Scanner(System.in);
	String pausarParar; 
	Boolean stop = false; 
	Video video; 
	
public ThreadPausarParar(Video video) {
	this.video = video; 
}
	
	@Override
public void run() {
	do {
	System.out.println("R: PLAY        P: PAUSE       S:STOP");
	pausarParar = entrada2.next();
	if (pausarParar.equalsIgnoreCase("R")) {
		video.playVideo();
		pausarParar = "";
	}
	else if (pausarParar.equalsIgnoreCase("P")) {
		System.out.println("PAUSE");
		video.pausaVideo();
		pausarParar = "";
	}
	else if (pausarParar.equalsIgnoreCase("S")) {
		System.out.println("STOP");
		video.stopVideo();
		stop = true; 
		pausarParar = "";
	}
	} while(!stop);
	}

}