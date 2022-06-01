package net.csjava.logistics.vo.base.businessHall;

import net.csjava.logistics.vo.base.AreaSimpleVo;
import net.csjava.logistics.vo.base.userCenter.SysUserVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@ApiModel(value = "快递员业务范围信息")
public class CourierScopeVo implements Serializable {
    private static final long serialVersionUID = 3637191452582035005L;
    @ApiModelProperty(value = "快递员信息")
    private SysUserVo courier;
    @ApiModelProperty(value = "业务范围")
    private List<AreaSimpleVo> areas;
    @ApiModelProperty(value = "可选业务范围")
    private List<AreaSimpleVo> optionAreas;
}
