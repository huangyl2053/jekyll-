/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kyufutsuchigenmenhosei;

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
    private final RString 証記載保険者番号;
    private final RString 出力順;
    private final boolean is広域保険者;

    /**
     * コンストラクタです。
     *
     * @param サービス開始年月 サービス開始年月
     * @param サービス終了年月 サービス終了年月
     * @param 証記載保険者番号 証記載保険者番号
     * @param 出力順 出力順
     * @param is広域保険者 is広域保険者
     */
    public KyufuTsuchiGenmenHoseiMapperParameter(
            FlexibleYearMonth サービス開始年月,
            FlexibleYearMonth サービス終了年月,
            RString 証記載保険者番号,
            RString 出力順,
            boolean is広域保険者) {
        this.サービス開始年月 = サービス開始年月;
        this.サービス終了年月 = サービス終了年月;
        this.証記載保険者番号 = 証記載保険者番号;
        this.出力順 = 出力順;
        this.is広域保険者 = is広域保険者;
    }
}
