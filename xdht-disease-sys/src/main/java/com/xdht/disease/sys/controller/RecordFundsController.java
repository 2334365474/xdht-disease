package com.xdht.disease.sys.controller;

import com.xdht.disease.common.authorization.annotation.CurrentUser;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.common.core.Result;
import com.xdht.disease.common.model.User;
import com.xdht.disease.sys.model.RecordEquipment;
import com.xdht.disease.sys.model.RecordFunds;
import com.xdht.disease.sys.service.RecordEquipmentService;
import com.xdht.disease.sys.service.RecordFundsService;
import com.xdht.disease.sys.vo.request.RecordEquipmentRequest;
import com.xdht.disease.sys.vo.request.RecordFundsRequest;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by L on 2018/5/30.
 */
@Log4j
@RestController
@RequestMapping(value = "/api/v1/recordFunds")
public class RecordFundsController {

    @Autowired
    private RecordFundsService recordFundsService;

    @RequestMapping(value = "/recordList", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "查询列表")
    public  ResponseEntity<Result<List<RecordFunds>>> recordList(@CurrentUser User user, @RequestBody RecordFundsRequest recordFundsRequest) {
        return new ResponseEntity<>(Result.ok(recordFundsService.queryList(recordFundsRequest)), HttpStatus.OK);
    }
    @RequestMapping(value = "/recordPage", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "分页查询")
    public ResponseEntity<Result<PageResult<RecordFunds>>> recordPage(@CurrentUser User user, @RequestBody RecordFundsRequest recordFundsRequest, @RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        return new ResponseEntity<>(Result.ok(recordFundsService.queryListPage(recordFundsRequest,pageNum,pageSize)), HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "添加")
    public ResponseEntity<Result<RecordFunds>> add(@CurrentUser User user, @RequestBody RecordFunds recordFunds) {
        return new ResponseEntity<>(Result.ok(recordFundsService.add(recordFunds)), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "删除")
    public ResponseEntity<Result<RecordFunds>> delete(@CurrentUser User user, @RequestParam Long id) {
        return new ResponseEntity<>(Result.ok(recordFundsService.delete(id)), HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "修改")
    public ResponseEntity<Result<RecordFunds>> update(@CurrentUser User user, @RequestBody RecordFunds recordFunds) {
        return new ResponseEntity<>(Result.ok(recordFundsService.update(recordFunds)), HttpStatus.OK);
    }



}