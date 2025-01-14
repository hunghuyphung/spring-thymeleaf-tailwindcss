package vn.java.springthymeleaftailwindcss.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Status {
    ALL("Tất cả"),
    ACTIVE("Hoạt động"),
    LOCK("Khóa");

    private final String vnName;
}
