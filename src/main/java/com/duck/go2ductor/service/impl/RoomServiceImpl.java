package com.duck.go2ductor.service.impl;

import com.duck.go2ductor.dao.ApiResponse;
import com.duck.go2ductor.entity.Review;
import com.duck.go2ductor.entity.Room;
import com.duck.go2ductor.repository.RoomRepository;
import com.duck.go2ductor.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author DucTN
 * @project go2ductor
 * @on 4/29/2023
 */
@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomRepository roomRepository;
    @Override
    public ApiResponse addRoom(Room room) {
        try{
            Room savedReview = roomRepository.save(room);
            return new ApiResponse(true,"Add review successfully", HttpStatus.CREATED);
        }catch (Exception e){
            return new ApiResponse(false,"Add review failed", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ApiResponse editRoom(Room room) {
        try{
            Room savedReview = roomRepository.save(room);
            return new ApiResponse(true,"Add review successfully", HttpStatus.CREATED);
        }catch (Exception e){
            return new ApiResponse(false,"Add review failed", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ApiResponse deleteRoom(Long roomID) {
        try{
            roomRepository.deleteById(roomID);
            return new ApiResponse(true,"Add review successfully", HttpStatus.CREATED);
        }catch (Exception e){
            return new ApiResponse(false,"Add review failed", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public List<Room> getAll() {
        return roomRepository.findAll();
    }
}
