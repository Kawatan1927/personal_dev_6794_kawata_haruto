package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.ItemImage;

public interface ItemImagesRepository extends JpaRepository<ItemImage, Integer> {
	List<ItemImage> findByItemId(Integer itemId);

}
