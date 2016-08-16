/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.processprm.dbd8100202;

import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd8100202.NenkinNoCheckListMybatisprmParamter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import lombok.Getter;
import lombok.Setter;

/**
 * 年金番号チェックリスト一時_processパラメタークラスです．
 *
 * @reamsid_L DBD-4910-040 x_tongxf
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NenkinNoCheckListProcessParmeter implements IBatchProcessParameter {

    private FlexibleYear 年度;

    /**
     * コンストラクタです。
     *
     * @param 年度 年度
     */
    public NenkinNoCheckListProcessParmeter(FlexibleYear 年度) {
        this.年度 = 年度;
    }

    /**
     * 年金番号チェックリスト一時SQLのパラメータを返却します．
     *
     * @return 年金番号チェックリスト一時SQLのパラメータ
     */
    public NenkinNoCheckListMybatisprmParamter toNenkinNoCheckListMybatisprmParamter() {
        return new NenkinNoCheckListMybatisprmParamter(年度);
    }
}
