/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.mybatisprm.jigyohokokugeppoippan;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import lombok.Getter;
import lombok.Setter;

/**
 * 被保台帳生年月日情報処理のMybatisパラメータクラスです。
 *
 * @reamsid_L DBU-5530-030 wangxiaodong
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class RiyoshaFutangakuKanriJohoSyoriMybatisParameter implements IMyBatisParameter {

    private FlexibleYearMonth syukeiYM;
    private FlexibleDate kyuSochishaYMD;
    private Code shukeiNo;

    /**
     * コンストラクタです。
     *
     * @param 集計年月 FlexibleYearMonth
     * @param 集計番号 Code
     */
    public RiyoshaFutangakuKanriJohoSyoriMybatisParameter(FlexibleYearMonth 集計年月, Code 集計番号) {
        this.syukeiYM = 集計年月;
        this.shukeiNo = 集計番号;
    }
}
