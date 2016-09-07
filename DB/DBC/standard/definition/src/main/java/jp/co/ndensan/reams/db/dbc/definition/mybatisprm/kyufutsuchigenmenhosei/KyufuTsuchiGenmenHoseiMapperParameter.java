/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kyufutsuchigenmenhosei;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;

/**
 * 給付費通知減免補正一覧表のMapper用パラメータです。
 *
 * @reamsid_L DBC-2270-030 lijia
 */
@lombok.Setter
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufuTsuchiGenmenHoseiMapperParameter implements IMyBatisParameter {

    private final FlexibleYearMonth サービス開始年月;
    private final FlexibleYearMonth サービス終了年月;
    private final List<HokenshaNo> 市町村コードList;

    /**
     * コンストラクタです
     *
     * @param サービス開始年月 FlexibleYearMonth
     * @param サービス終了年月 FlexibleYearMonth
     * @param 市町村コードList List<HokenshaNo>
     */
    public KyufuTsuchiGenmenHoseiMapperParameter(
            FlexibleYearMonth サービス開始年月,
            FlexibleYearMonth サービス終了年月,
            List<HokenshaNo> 市町村コードList) {
        this.サービス開始年月 = サービス開始年月;
        this.サービス終了年月 = サービス終了年月;
        this.市町村コードList = 市町村コードList;
    }
}
