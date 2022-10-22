package dev.strichkov.filmorate.domain.page;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Pagination {

    private Integer pageNumber;
    private Integer pageSize;

}
