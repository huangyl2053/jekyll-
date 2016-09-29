/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakukaigoservicehikyufutaishoshatoroku;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額介護サービス費給付額算出のバックアップ用MyBatisパラメータクラスです。
 *
 * @reamsid_L DBC-2010-040 chenaoqi
 */
@lombok.Setter
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufuJissekiKihonKogakuMybatisParameter implements IMyBatisParameter {

    private RString 出力順;
    private FlexibleYearMonth 処理年月;
    private FlexibleDate 処理年月日;
    private FlexibleYearMonth 最古のサービス提供年月;
    private FlexibleYearMonth 最新のサービス提供年月;
    private FlexibleYear 続柄コード参照年;
}
