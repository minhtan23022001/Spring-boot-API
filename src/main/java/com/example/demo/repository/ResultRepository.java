package com.example.demo.repository;

import com.example.demo.entity.result.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface ResultRepository extends JpaRepository<Result, Long> {

}
