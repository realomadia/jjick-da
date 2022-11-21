package app.jjickda.api.admin.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter
@Alias("examInfo")
public class ExamInfo {

    @ApiModelProperty(hidden = true)
    private long examIdx;

    @ApiModelProperty(value = "메인카테고리IDX", example = "1", required = true)
    private long mainCategoryIdx;

    @ApiModelProperty(value = "서브카테고리IDX", example = "1", required = true)
    private long subCategoryIdx;

    @Length(max = 128)
    @ApiModelProperty(value = "시험명", example = "2022년 3회차 정보처리기사(필기)", required = true)
    private String examName;

    @Max(value = 5)
    @ApiModelProperty(value = "선지개수", example = "5", required = true)
    private int optionCnt;

    @Max(value = 200)
    @ApiModelProperty(value = "문항개수", example = "100", required = true)
    private int questionCnt;

    @Positive
    @NotNull
    @ApiModelProperty(value = "시험합격점수", example = "5", required = true)
    private float examCutOffScore;

}
