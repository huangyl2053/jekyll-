/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.mybatisprm.jigyohokokugeppoippan;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import lombok.Getter;

/**
 * 世帯情報処理のMybatisパラメータクラスです。
 *
 * @reamsid_L DBU-5530-030 wangxiaodong
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class SyotaiJohoSyoriMybatisParameter implements IMyBatisParameter {

    private final FlexibleYearMonth syukeiYM;

    /**
     * コンストラクタです。
     *
     * @param 集計年月 集計年月
     */
    public SyotaiJohoSyoriMybatisParameter(FlexibleYearMonth 集計年月) {
        this.syukeiYM = 集計年月;
    }
}
