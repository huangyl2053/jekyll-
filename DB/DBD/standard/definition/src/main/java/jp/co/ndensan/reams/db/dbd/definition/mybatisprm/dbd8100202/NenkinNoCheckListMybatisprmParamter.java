/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd8100202;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 年金番号チェックリスト一時SQLのパラメータクラスです．
 *
 * @reamsid_L DBD-4910-040 x_tongxf
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NenkinNoCheckListMybatisprmParamter implements IMyBatisParameter {

    private FlexibleYear 年度;

    /**
     * コンストラクタです。
     *
     * @param 年度 年度
     */
    public NenkinNoCheckListMybatisprmParamter(FlexibleYear 年度) {
        int year = 年度.getYearValue();
        year = year - 2;
        RString str = new RString(year);
        this.年度 = new FlexibleYear(str);
    }
}
