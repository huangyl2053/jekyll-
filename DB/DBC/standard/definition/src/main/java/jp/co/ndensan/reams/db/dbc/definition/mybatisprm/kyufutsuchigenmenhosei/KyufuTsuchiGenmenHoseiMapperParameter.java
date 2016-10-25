/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kyufutsuchigenmenhosei;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

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
    private final List<RString> 市町村コードList;
    private final RString 出力順;

    /**
     * コンストラクタです。
     *
     * @param サービス開始年月 サービス開始年月
     * @param サービス終了年月 サービス終了年月
     * @param 市町村コードList 市町村コードList
     * @param 出力順 出力順
     */
    public KyufuTsuchiGenmenHoseiMapperParameter(
            FlexibleYearMonth サービス開始年月,
            FlexibleYearMonth サービス終了年月,
            List<RString> 市町村コードList,
            RString 出力順) {
        this.サービス開始年月 = サービス開始年月;
        this.サービス終了年月 = サービス終了年月;
        this.市町村コードList = 市町村コードList;
        this.出力順 = 出力順;
    }
}
