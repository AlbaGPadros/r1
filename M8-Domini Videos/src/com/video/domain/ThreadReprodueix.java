package com.video.domain;

public class ThreadReprodueix extends Thread {


private Video video; 
private int duradaRep = 0; 
private String estatRep;
private boolean stop = false; 

public ThreadReprodueix(Video video) {
	this.video = video; 
	}
	
	@Override
	public void run() {
		reproduccio();
		}

	public void reproduccio() {
		stop = false;
		int hor = 0, min = 0, seg = 0, duradaRep=0; 
		estatRep = video.getEstatReproduccio().name();
		do {
			estatRep = video.getEstatReproduccio().name();
			int duradaVid = video.duradaInt(video.getDuradaString());
			if(estatRep.equals("PLAY")) {
				for (int i = duradaRep; i<=duradaVid; i++) { 
					imprimeixCrono(hor, min, seg);
					seg ++; 
					duradaRep++; 
					try{Thread.sleep(1000);} catch(Exception e) {}
					estatRep = video.getEstatReproduccio().name();
					if(estatRep.equals("STOP")) {
						stop = true;
						break; 
					}
					if(estatRep.equals("PAUSE")) {
						break; 
					}}
				if ((duradaRep) >= duradaVid) {
					stop = true; 
					video.stopVideo();
				}
			}
			else if (estatRep.equals("PAUSE")) {
			} 
			else if (estatRep.equals("STOP")) {
				stop = true; 
			} 
		} while(!stop);
	}

	
	public void stopVideo() {
		video.stopVideo();
	}
//IMPRIMEIX CRONO EN FORMAT ADEQUAT
	public void imprimeixCrono(int hor, int min, int seg) {
		if (seg == 60) {
			seg = 0; 
			min++; 
			}
		if (min == 60) {
			min = 0; 
			hor++; 
		}
		System.out.printf("%02d",hor);
		System.out.print(":");
		System.out.printf("%02d",min);
		System.out.print(":");
		System.out.printf("%02d",seg);
		System.out.print("\n");
		}
	}

