/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.kyufutsuchigenmenhosei;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kyufutsuchigenmenhosei.KyufuTsuchiGenmenHoseiMapperParameter;
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
    private RString 市町村コード;
    private RString 証記載保険者番号;
    private RString 市町村名称;
    private long 帳票出力順ID;

    /**
     * コンストラクタ
     *
     * @param サービス開始年月 FlexibleYearMonth
     * @param サービス終了年月 FlexibleYearMonth
     * @param 市町村コード RString
     * @param 証記載保険者番号 RString
     * @param 市町村名称 RString
     * @param 帳票出力順ID long
     */
    public KyufuTsuchiGenmenHoseiProcessParameter(
            FlexibleYearMonth サービス開始年月, FlexibleYearMonth サービス終了年月,
            RString 市町村コード, RString 証記載保険者番号, RString 市町村名称, long 帳票出力順ID) {
        this.サービス開始年月 = サービス開始年月;
        this.サービス終了年月 = サービス終了年月;
        this.市町村コード = 市町村コード;
        this.証記載保険者番号 = 証記載保険者番号;
        this.市町村名称 = 市町村名称;
        this.帳票出力順ID = 帳票出力順ID;
    }

    /**
     * プロセスパラメータを作成します。
     *
     * @param 出力順 出力順
     * @param is広域保険者 is広域保険者
     * @return プロセスパラメータ
     */
    public KyufuTsuchiGenmenHoseiMapperParameter toMapperParameter(RString 出力順, boolean is広域保険者) {
        return new KyufuTsuchiGenmenHoseiMapperParameter(サービス開始年月, サービス終了年月, 証記載保険者番号, 出力順, is広域保険者);
    }
}
