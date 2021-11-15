package com.saraya.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.saraya.model.Fan;

@Service //-> stereotype annotation and there are 4 : Controller, Repository, Service and Component
public class FanService {

	private static ArrayList<Fan> fans=new ArrayList<Fan>();
	private static int count=10;
	
	static {
		fans.add(new Fan(1,2019,"Rowenta Turbo","VU56","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTEu9QSGtu85vxYRIWgvG-i1qHRWZDFEiVisA&usqp=CAU"));
		fans.add(new Fan(2,2017,"HoneyWell","HYF290","https://m.media-amazon.com/images/I/71QUwh-B67L._AC_SX466_.jpg"));
		fans.add(new Fan(3,2021,"Rowenta Turbo Silence","VU26","https://images.unsplash.com/photo-1559536207-e64933d5798b?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=580&q=80"));
		fans.add(new Fan(4,2021,"HoneyWell HT","900E","https://www.biofloral.com//img/product/40052-Z.jpg"));
		fans.add(new Fan(5,2021,"Bestron","30W","https://img.directindustry.fr/images_di/photo-g/69014-15041089.jpg"));
		fans.add(new Fan(6,2020,"Bestron AS","V45Z","https://www.sodishop.com/media/2019/02/Fan-Syinix-2batterie.jpg"));
		fans.add(new Fan(7,2020,"Turbo-Silence","Extrem","https://i2.wp.com/aven-electronics.com/wp-content/uploads/2018/08/MIXEUR-BLENDEUR1-8.png?resize=400%2C400&ssl=1"));
		fans.add(new Fan(8,2020,"Taurus Alpatech","Babel-RC","https://homedepot.scene7.com/is/image/homedepotcanada/p_1000682449.jpg?wid=1000&hei=1000&op_sharpen=1"));
		fans.add(new Fan(9,2020,"STAND-Extrem","GF200","https://sc01.alicdn.com/kf/HTB1sRJDHFXXXXXoXpXXq6xXFXXX9/223114555/HTB1sRJDHFXXXXXoXpXXq6xXFXXX9.jpg_.webp"));
		fans.add(new Fan(10,2020,"CecoTech","1010Extrem","https://sn.jumia.is/unsafe/fit-in/300x300/filters:fill(white)/product/64/8711/1.jpg?3297"));
	}
	
	public List<Fan> getAllFans(){
		return fans;
	}
	public void addFan(int year, String make, String model,String image) {
		fans.add(new Fan(++count,year,make,model,image));
	}
	public void deleteFan(int id) {
		Iterator<Fan> iterate=fans.iterator();
		while(iterate.hasNext()) {
			Fan car=iterate.next();
			if(car.getId()==id) {
				iterate.remove();
	}
	
}
}
	public Fan findById(int id) {
	for(Fan c:fans) {
		if(c.getId()==id) {
			return c;
		}
	}
	return null;
}
	public void updateByFan(Fan f) {
		fans.remove(f);
		fans.add(f);
	}
}