/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakukaigoservicehikyufutaishoshatoroku;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;

/**
 * 高額介護サービス費給付額算出のバックアップ用MyBatisパラメータクラスです。
 *
 * @reamsid_L DBC-2010-040 wangxingpeng
 */
@lombok.Setter
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class UpdKogakuKokuhorenIFMstMybatisParameter implements IMyBatisParameter {

    private FlexibleYearMonth 処理年月;
    private YMDHMS 処理日時;

    /**
     * コンストラクタです。
     *
     * @param 処理年月 FlexibleYearMonth
     * @param 処理日時 YMDHMS
     */
    public UpdKogakuKokuhorenIFMstMybatisParameter(FlexibleYearMonth 処理年月, YMDHMS 処理日時) {
        this.処理年月 = 処理年月;
        this.処理日時 = 処理日時;
    }
}
