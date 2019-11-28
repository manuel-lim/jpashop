package jpabook.jpashop.service;

import jpabook.jpashop.ItemDto;
import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// 위임만 하는 클래스
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository repository;

    @Transactional
    public void saveItem(Item item) {
        repository.save(item);
    }

    public List<Item> findItems() {
        return repository.findAll();
    }

    public Item findOne(Long itemId) {
        return repository.findOne(itemId);
    }

    @Transactional
    public void updateItem(ItemDto dto) {
        Book item = (Book)this.findOne(dto.getId());
        item.setId(dto.getId());
        item.setIsbn(dto.getIsbn());
        item.setAuthor(dto.getAuthor());
        item.setStockQuantity(dto.getStockQuantity());
        item.setPrice(dto.getPrice());
        item.setName(dto.getName());
    }
}
