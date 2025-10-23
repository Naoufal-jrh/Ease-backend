package com.demo.trellolite.Controller;

import com.demo.trellolite.Dto.ColumnDto;
import com.demo.trellolite.Service.ColumnService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/column")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class ColumnController {
    private final ColumnService columnService;


    @PostMapping
    public ColumnDto addColumn(@RequestBody ColumnDto column, @PathParam("") Long boardId) {
        return columnService.addColumn(boardId, column);
    }

    @PutMapping("/toBoard/{boardId}")
    public List<ColumnDto> addColumns(@PathVariable Long boardId, @RequestBody List<ColumnDto> columns) {
        return columnService.addColumns(boardId, columns);
    }


}
