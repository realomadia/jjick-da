package app.jjickda.api.admin.controller;


import app.jjickda.api.admin.dto.request.AddExamDto;
import app.jjickda.api.admin.dto.request.AddMainCategoryDto;
import app.jjickda.api.admin.dto.request.AddSubCategoryDto;
import app.jjickda.api.admin.dto.request.AddSubjectDto;
import app.jjickda.api.admin.dto.response.*;
import app.jjickda.api.admin.service.AdminService;
import app.jjickda.domain.common.dto.response.DefaultResultDto;
import app.jjickda.domain.role.Role;
import app.jjickda.global.annotation.LoginCheck;
import app.jjickda.global.config.exception.Type;
import app.jjickda.global.config.model.ApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Api(tags = "어드민 관련 API")
@RequestMapping("/api/admin")
public class AdminRestController {
    private final AdminService adminService;

    public AdminRestController(AdminService adminService) {
        this.adminService = adminService;
    }

    @ApiOperation("메인카테고리 등록 API")
    @LoginCheck(auth = Role.ADMIN, type = Type.API)
    @PostMapping("/regist-main")
    public ResponseEntity<ApiResponse<DefaultResultDto>> registerMain(@Validated @RequestBody AddMainCategoryDto main_question) {
        return ResponseEntity.ok(new ApiResponse<>(adminService.registMain(main_question)));
    }

    @ApiOperation("서브카테고리 등록 API")
    @LoginCheck(auth = Role.ADMIN, type = Type.API)
    @PostMapping("/regist-sub")
    public ResponseEntity<ApiResponse<DefaultResultDto>> registerSub(@Validated @RequestBody AddSubCategoryDto sub_question) {
        return ResponseEntity.ok(new ApiResponse<>(adminService.registSub(sub_question)));
    }

    @ApiOperation("서브등록(datalist) 메인등록(list) 에서 쓰일 Main_ctg_getList API")
    @LoginCheck(auth = Role.ADMIN, type = Type.API)
    @PostMapping("/get-main-category")
    public ResponseEntity<ApiResponse<List<GetMainCategoryDto>>> getMainList(@RequestBody SearchDto searchDto) {
        List<GetMainCategoryDto> questionList = adminService.getMainList(searchDto);
        return ResponseEntity.ok(new ApiResponse<>(questionList));
    }

    @ApiOperation("문항등록(datalist) 에 쓰일 서브 카테고리 리스트 API")
    @LoginCheck(auth = Role.ADMIN, type = Type.API)
    @PostMapping("/get-sub-list")
    public ResponseEntity<ApiResponse<List<GetSubCategoryDto>>> getSubList(@RequestBody SearchDto searchDto) {
        List<GetSubCategoryDto> questionList = adminService.getSubList(searchDto);
        return ResponseEntity.ok(new ApiResponse<>(questionList));
    }

    @ApiOperation("문항등록(datalist) 에 쓰일 서브 카테고리 리스트 API")
    @LoginCheck(auth = Role.ADMIN, type = Type.API)
    @PostMapping("/get-sub-category")
    public ResponseEntity<ApiResponse<List<GetSubCategoryDto>>> getSubCategory(@RequestBody long mainIdx) {
        List<GetSubCategoryDto> questionList = adminService.getSubList(mainIdx);
        return ResponseEntity.ok(new ApiResponse<>(questionList));
    }

    @ApiOperation("문항등록(datalist) 에 쓰일 서브 카테고리 리스트 API")
    @LoginCheck(auth = Role.ADMIN, type = Type.API)
    @PostMapping("/get-subject-category")
    public ResponseEntity<ApiResponse<List<GetSubjectDto>>> getSubjectCategory(@RequestBody long subIdx) {
        List<GetSubjectDto> subjectList = adminService.getSubjectCategory(subIdx);
        System.out.println(subjectList);
        return ResponseEntity.ok(new ApiResponse<>(subjectList));
    }

    @ApiOperation("과목등록에 쓰일 Sub detail API")
    @LoginCheck(auth = Role.ADMIN, type = Type.API)
    @PostMapping("/get-sub-detail")
    public ResponseEntity<ApiResponse<GetSubCategoryDto>> getSubDetail(@RequestBody long subIdx) {
        GetSubCategoryDto subDetail = adminService.getSubDetail(subIdx);
        return ResponseEntity.ok(new ApiResponse<>(subDetail));
    }

    @ApiOperation("서브카테고리 등록 API")
    @LoginCheck(auth = Role.ADMIN, type = Type.API)
    @PostMapping("/regist-subject")
    public ResponseEntity<ApiResponse<DefaultResultDto>> registerSubject(@Validated @RequestBody AddSubjectDto subject) {
        return ResponseEntity.ok(new ApiResponse<>(adminService.registSubject(subject)));
    }

    @ApiOperation("문항 등록 API")
    @LoginCheck(auth = Role.ADMIN, type = Type.API)
    @PostMapping("/add-exam")
    public ResponseEntity<ApiResponse<DefaultResultDto>> addExam(@Validated @RequestBody AddExamDto addExamDto) {
        return ResponseEntity.ok(new ApiResponse<>(adminService.addExam(addExamDto)));
    }
    @ApiOperation("문항 등록 페이지에서 쓰일 시험 정보 API")
    @LoginCheck(auth = Role.ADMIN, type = Type.API)
    @PostMapping("/get-exam-information")
    public ResponseEntity<ApiResponse<ExamInformationDto>> getExamInformation(@RequestBody long subIdx) {
        ExamInformationDto examInfo = adminService.getExamInformation(subIdx);
        return ResponseEntity.ok(new ApiResponse<>(examInfo));
    }

    @ApiOperation("시험 결재 대기중인 시험 정보 가져오는 API")
    @LoginCheck(auth = Role.ADMIN, type = Type.API)
    @PostMapping("/getUnconfirmedExamData")
    public ResponseEntity<ApiResponse<List<UnconfirmedExamDto>>> unconfirmedExamData(@RequestBody SearchDto searchDto) {
        List<UnconfirmedExamDto> unconfirmedExamDataList = adminService.getUnconfirmedExamData(searchDto);
        return ResponseEntity.ok(new ApiResponse<>(unconfirmedExamDataList));
    }

    @ApiOperation("시험 결재 API")
    @LoginCheck(auth = Role.ADMIN, type = Type.API)
    @PostMapping("/confirmExam")
    public ResponseEntity<ApiResponse<DefaultResultDto>> confirmExam(@RequestBody List<Long> examIdx) {
        DefaultResultDto response = adminService.confirmExam(examIdx);
        return ResponseEntity.ok(new ApiResponse<DefaultResultDto>(response));
    }

}

