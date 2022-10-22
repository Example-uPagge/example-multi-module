package dev.strichkov.filmorate.domain.page;

import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Getter
@Builder
public class Sheet<T> {

    private List<T> content;
    private Long totalElements;
    private Integer totalPage;
    private Integer pageSize;
    private Integer pageNumber;

    public <D> Sheet<D> map(Function<T, D> mapping) {
        return Sheet.<D>builder()
                .totalElements(totalElements)
                .totalPage(totalPage)
                .pageNumber(pageNumber)
                .pageSize(pageSize)
                .content(content.stream().map(mapping).collect(Collectors.toList())                )
                .build();
    }
}
