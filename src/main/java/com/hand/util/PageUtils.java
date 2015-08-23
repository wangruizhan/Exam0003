package com.hand.util;

public class PageUtils {
	private static long size = 2;
	
	public static long checkTotalcount(long totalcount){
	long totalpage =(totalcount/size);
	if(totalcount%size!=0){
		totalpage++;
		return totalpage;
			}
	return totalpage;
	}
	
	public static long checkpage(long page,long totalpage){
		if(page<=1){   
			page=1;
			return page;
		}
	
		if(page>totalpage){
			page=totalpage;
			return page;
		}
		return page;
	}
	
	public static long checksize(){
		return size;
	}
}
