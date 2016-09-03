/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.mybatisprm.jigyohokokugeppoippan;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import lombok.Getter;

/**
 * 特定入所者管理情報処理のMybatisパラメータクラスです。
 *
 * @reamsid_L DBU-5530-030 wangxiaodong
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class TokuteiNyushoshaJohoSyoriMybatisParameter implements IMyBatisParameter {

    private final FlexibleYearMonth syukeiYM;
    private final Code shukeiNo;

    /**
     * コンストラクタです。
     *
     * @param 集計年月 集計年月
     * @param 集計番号 Code
     */
    public TokuteiNyushoshaJohoSyoriMybatisParameter(FlexibleYearMonth 集計年月, Code 集計番号) {
        this.syukeiYM = 集計年月;
        this.shukeiNo = 集計番号;
    }
}
