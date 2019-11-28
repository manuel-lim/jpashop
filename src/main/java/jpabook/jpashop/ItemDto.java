package jpabook.jpashop;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemDto {
    private Long id;
    private String name;
    private int price;
    private String author;
    private String isbn;
    private int stockQuantity;
}
