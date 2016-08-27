/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.kyufutsuchigenmenhosei;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kyufutsuchigenmenhosei.KyufuTsuchiGenmenHoseiMapperParameter;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付費通知減免補正一覧表のProcess用パラメータです。
 *
 * @reamsid_L DBC-2270-030 lijia
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufuTsuchiGenmenHoseiProcessParameter implements IBatchProcessParameter {

    private FlexibleYearMonth サービス開始年月;
    private FlexibleYearMonth サービス終了年月;
    private List<HokenshaNo> 市町村コードList;
    private RString 帳票出力順ID;

    /**
     * コンストラクタ
     *
     * @param サービス開始年月 FlexibleYearMonth
     * @param サービス終了年月 FlexibleYearMonth
     * @param 市町村コードList List<HokenshaNo>
     * @param 帳票出力順ID RString
     */
    public KyufuTsuchiGenmenHoseiProcessParameter(
            FlexibleYearMonth サービス開始年月, FlexibleYearMonth サービス終了年月,
            List<HokenshaNo> 市町村コードList, RString 帳票出力順ID) {
        this.サービス開始年月 = サービス開始年月;
        this.サービス終了年月 = サービス終了年月;
        this.市町村コードList = 市町村コードList;
        this.帳票出力順ID = 帳票出力順ID;
    }

    /**
     * プロセスパラメータを作成します。
     *
     * @return プロセスパラメータ
     */
    public KyufuTsuchiGenmenHoseiMapperParameter toMapperParameter() {
        return new KyufuTsuchiGenmenHoseiMapperParameter(サービス開始年月, サービス終了年月, 市町村コードList);
    }

}
