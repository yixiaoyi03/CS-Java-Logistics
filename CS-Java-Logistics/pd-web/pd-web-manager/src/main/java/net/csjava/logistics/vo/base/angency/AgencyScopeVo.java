package net.csjava.logistics.vo.base.angency;

import net.csjava.logistics.vo.base.AreaSimpleVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@ApiModel(value = "机构业务范围信息")
public class AgencyScopeVo implements Serializable {
    private static final long serialVersionUID = -7364866310440069186L;
    @ApiModelProperty(value = "机构信息")
    private AgencyVo agency;
    @ApiModelProperty(value = "业务范围")
    private List<AreaSimpleVo> areas;
}
