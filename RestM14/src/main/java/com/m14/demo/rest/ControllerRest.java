package com.m14.demo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.m14.demo.dao.PaintingsDao;
import com.m14.demo.dao.ShopsDao;
import com.m14.demo.models.Painting;
import com.m14.demo.models.Shop;

@RestController
@RequestMapping("/whitecollar")
public class ControllerRest {
	@Autowired 
	private ShopsDao shopsDao;
	@Autowired 
	private PaintingsDao paintingsDao;

	
	// CREAR BOTIGA
	@PostMapping("shops")
		public ResponseEntity<Shop> crearShop(@RequestBody Shop shop) {
			Shop newShop = shopsDao.save(shop);
		return ResponseEntity.ok(newShop);
		}
	
	//LLISTAR BOTIGUES 
	@GetMapping("shops") 
		public ResponseEntity<List<Shop>> getShops() {
			List<Shop> shops = shopsDao.findAll();
		return ResponseEntity.ok(shops);
		}
	//CREAR PAINTING
	@PostMapping(value="shops/{shopid}/pictures")
		public ResponseEntity<Painting> crearPainting(@RequestBody Painting painting, @PathVariable("shopid") Integer shopid) {
			painting.setShopId(shopid);
			Painting newPainting = paintingsDao.save(painting);
		return ResponseEntity.ok(newPainting);
	}
	//LLISTAR PAINTINGS PER BOTIGA
	@GetMapping(value="shops/{shopid}/pictures")
		public ResponseEntity<List<Painting>> getPaintingShop(@PathVariable("shopid") Integer shopid){
		List<Painting> paintingsShop = new ArrayList <Painting>(); 
		paintingsShop = paintingsDao.findAllByShopid(shopid);
		return ResponseEntity.ok(paintingsShop);
	}
	
	//LLISTAR PAINTINGS
	@GetMapping(value="pictures")
		public ResponseEntity<List<Painting>> getPainting(){
		List<Painting> paintingsShop = new ArrayList <Painting>(); 
		paintingsShop = paintingsDao.findAll();
		return ResponseEntity.ok(paintingsShop);
	}
	
	//CREMAR QUADRES
	@DeleteMapping(value="shops/{shopid}/pictures") 
		@Transactional
		public ResponseEntity<Void> burnPaintings(@PathVariable("shopid") Integer shopid) {
			paintingsDao.deleteAllByShopid(shopid);
			return ResponseEntity.ok(null);
		}
}
