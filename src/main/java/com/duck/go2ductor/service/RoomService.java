package com.duck.go2ductor.service;

import com.duck.go2ductor.dao.ApiResponse;
import com.duck.go2ductor.entity.Room;

import java.util.List;

/**
 * @author DucTN
 * @project go2ductor
 * @on 4/14/2023
 */
public interface RoomService {
    ApiResponse addRoom(Room room);
    ApiResponse editRoom(Room room);
    ApiResponse deleteRoom(Long roomID);
    List<Room> getAll();

}
