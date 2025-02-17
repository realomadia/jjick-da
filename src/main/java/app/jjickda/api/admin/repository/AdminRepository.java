package app.jjickda.api.admin.repository;

import app.jjickda.api.admin.dto.request.*;
import app.jjickda.api.admin.dto.response.*;
import app.jjickda.domain.user.dto.response.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminRepository {
    int registMain(AddMainCategoryDto mainQuestion, User user);

    List<GetMainCategoryDto> getMainList(SearchDto searchDto);

    int registSub(AddSubCategoryDto subQuestion, User user);

    List<GetSubCategoryDto> selectSubCategoryListBySearch(String search, String sort);

    List<GetSubCategoryDto> selectSubCategoryListByMainIdx(long mainIdx);

    GetSubCategoryDto getSubDetail(long idx);

    int registSubject(AddSubjectDto subject, User user);

    List<GetSubjectDto> getSubjectCategory(long subIdx);

    // 시험 정보 등록
    void insertExamInfo(ExamInfo examInfo, User user);

    // 시험문항 등록
    void insertExamQuestions(ExamInfo examInfo, Question question);

    void insertExamOptions(Question question, List<Options> options);

    int getOptionsCnt(long subIdx);

    List<SubjectInformationDto> getSubjectInfo(long subIdx);

    List<UnconfirmedExamDto> getUnconfirmedExamData(String search);

    int confirmExam(long examIdx);
}
