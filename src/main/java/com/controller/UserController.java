package com.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.alibaba.fastjson.JSON;
import com.common.Result;
import com.entity.User;
import com.service.UserService;

/**
 * 首页
 * @author lixiong
 *
 */
@RestController
@RequestMapping("/user")
@Api(value="UserController", description="用户接口")
public class UserController {
	
	public static String build(Object obj) {
		return JSON.toJSONString(obj);
	}
	
	@Autowired
	private UserService userService;

    /**
     * 获得用户列表
     *
     * @param userName
     * @return
     */
    @RequestMapping(value = "/getList", method = RequestMethod.GET)
    @ApiOperation(value = "获得用户列表", code = 200, produces = "application/json")
    @ApiResponses({@ApiResponse(code = 200, message = "成功"), @ApiResponse(code = 500, message = "服务器内部错误")})
    public String getList(@RequestParam @ApiParam(name = "pageNo", value = "页码", required = true)Integer pageNo, 
    		@RequestParam @ApiParam(name = "pageSize", value = "每页显示条数", required = true) Integer pageSize) {
    	Result result = userService.getList(pageNo, pageSize);
    	return build(result);
    }

    /**
     * 获得详细信息
     *
     * @param userName
     * @return
     */
    @RequestMapping(value = "/getDetail", method = RequestMethod.GET)
    @ApiOperation(value = "获得详细信息", notes = "参数描述", code = 200, produces = "application/json")
    @ApiResponses({@ApiResponse(code = 200, message = "成功"), @ApiResponse(code = 500, message = "服务器内部错误")})
    public String getDetail(@RequestParam @ApiParam(name = "id", value = "编号", required = true) Integer id) {
    	
    	Result result = userService.detail(id);
    	return build(result);
    }

    /**
     * 添加信息
     *
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ApiOperation(value = "添加信息", notes = "接受对象", code = 200, produces = "application/json")
    @ApiResponses({@ApiResponse(code = 200, message = "成功"), @ApiResponse(code = 500, message = "服务器内部错误")})
    public String save(@RequestParam @ApiParam(name = "id", value = "编号", required = true) Integer id, 
    		@RequestParam @ApiParam(name = "name", value = "名称", required = true) String name, 
    		@RequestParam @ApiParam(name = "age", value = "年龄", required = true) Integer age) {
    	
    	User user = new User(id, name, age);
    	Result result = userService.save(user);
    	return build(result);
    }
    
    /**
     * 删除信息
     * @param content
     * @return
     */
    //@ApiIgnore //使用这个注解忽略这个接口
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ApiOperation(value="删除信息", notes="删除信息", code=200, produces = "application/json")
    @ApiResponses({@ApiResponse(code = 200, message = "成功"), @ApiResponse(code = 500, message = "服务器内部错误")})
    public String delete(@ApiParam(name = "id", value = "编号", required = true) @RequestParam Integer id) {
    	Result result = userService.delete(id);
    	return build(result);
    }
}