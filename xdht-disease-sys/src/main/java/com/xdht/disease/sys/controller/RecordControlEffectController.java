package com.xdht.disease.sys.controller;

import com.xdht.disease.common.authorization.annotation.CurrentUser;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.common.core.Result;
import com.xdht.disease.common.model.User;
import com.xdht.disease.sys.model.RecordControlEffect;
import com.xdht.disease.sys.service.RecordControlEffectService;
import com.xdht.disease.sys.vo.request.RecordControlEffectRequest;
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
@RequestMapping(value = "/api/v1/recordControlEffect")
public class RecordControlEffectController {

    @Autowired
    private RecordControlEffectService recordControlEffectService;

    @RequestMapping(value = "/recordList", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "查询列表")
    public  ResponseEntity<Result<List<RecordControlEffect>>> recordList(@CurrentUser User user, @RequestBody RecordControlEffectRequest recordControlEffectRequest) {
        return new ResponseEntity<>(Result.ok(recordControlEffectService.queryList(recordControlEffectRequest)), HttpStatus.OK);
    }
    @RequestMapping(value = "/recordPage", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "分页查询")
    public ResponseEntity<Result<PageResult<RecordControlEffect>>> recordPage(@CurrentUser User user, @RequestBody RecordControlEffectRequest recordControlEffectRequest,@RequestParam Integer pageNum,@RequestParam Integer pageSize) {
        return new ResponseEntity<>(Result.ok(recordControlEffectService.queryListPage(recordControlEffectRequest,pageNum,pageSize)), HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "添加")
    public ResponseEntity<Result<RecordControlEffect>> addRecordControlEffect(@CurrentUser User user, @RequestBody RecordControlEffect recordControlEffect) {
        return new ResponseEntity<>(Result.ok(recordControlEffectService.addRecordControlEffect(recordControlEffect)), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "删除")
    public ResponseEntity<Result<RecordControlEffect>> deleteRecordControlEffect(@CurrentUser User user, @RequestParam Long id) {
        return new ResponseEntity<>(Result.ok(recordControlEffectService.deleteRecordControlEffect(id)), HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "修改")
    public ResponseEntity<Result<RecordControlEffect>> updateRecordControlEffect(@CurrentUser User user, @RequestBody RecordControlEffect recordControlEffect) {
        return new ResponseEntity<>(Result.ok(recordControlEffectService.updateRecordControlEffect(recordControlEffect)), HttpStatus.OK);
    }



}
