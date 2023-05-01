package com.duck.go2ductor.controller;

import com.duck.go2ductor.dao.ApiResponse;
import com.duck.go2ductor.entity.Room;
import com.duck.go2ductor.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author DucTN
 * @project go2ductor
 * @on 4/29/2023
 */
@RestController
@RequestMapping("/api/room")
public class RoomController {
    @Autowired
    private RoomService roomService;
    @GetMapping("/get-all")
    public List<Room> getAll(){
        return roomService.getAll();
    }
    @PostMapping("/add")
    public ApiResponse add(@RequestBody Room room){
        return roomService.addRoom(room);
    }
    @PutMapping("/update")
    public ApiResponse update(@RequestBody Room room){
        return roomService.editRoom(room);
    }
    @DeleteMapping("/delete")
    public ApiResponse delete(@RequestBody Long roomID){
        return roomService.deleteRoom(roomID);
    }
}
