/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.kogakukaigoservicehikyufutaishoshatoroku;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakukaigoservicehikyufutaishoshatoroku.KyufuJissekiKihonKogakuMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * バッチ設計_DBCMN41002_高額介護サービス費給付対象者登録パラメータです。
 *
 * @reamsid_L DBC-2010-040 chenaoqi
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufuJissekiKihonKogakuProcessParameter implements IBatchProcessParameter {

    private FlexibleYearMonth 審査年月From;
    private FlexibleYearMonth 審査年月To;
    private RString 出力順ID;
    private FlexibleYearMonth 処理年月;
    private FlexibleDate 処理年月日;
    private RString 処理状態区分;
    private FlexibleYear 最小続柄コード参照年;
    private FlexibleYear 最大続柄コード参照年;
    private FlexibleYearMonth 最古のサービス高額提供年月;
    private FlexibleYearMonth 最新のサービス高額提供年月;
    private FlexibleYear 続柄コード参照年;

    /**
     * toMybatisParameterのメソッドです。
     *
     * @return KyufuJissekiKihonKogakuMybatisParameter
     */
    public KyufuJissekiKihonKogakuMybatisParameter toMybatisParameter() {
        KyufuJissekiKihonKogakuMybatisParameter parameter = new KyufuJissekiKihonKogakuMybatisParameter();
        parameter.set出力順(出力順ID);
        parameter.set処理年月(処理年月);
        parameter.set処理年月日(処理年月日);
        parameter.set続柄コード参照年(続柄コード参照年);
        return parameter;
    }
}
