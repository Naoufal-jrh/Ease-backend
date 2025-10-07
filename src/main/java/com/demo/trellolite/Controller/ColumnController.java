package com.demo.trellolite.Controller;

import com.demo.trellolite.Dto.CardDto;
import com.demo.trellolite.Dto.ColumnDto;
import com.demo.trellolite.Service.ColumnService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/column")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class ColumnController {
    private final ColumnService columnService;

    @PostMapping("/{columnId}")
    public ColumnDto addCardToColumn(@PathVariable Long columnId, @RequestBody CardDto card) {
        return columnService.addCardToColumn(columnId, card);
    }

    @PatchMapping("/{columnId}")
    public ColumnDto updateCardFields(@PathVariable Long columnId, @RequestBody ColumnDto column) {
        return columnService.updateColumnFields(columnId, column);
    }


}
