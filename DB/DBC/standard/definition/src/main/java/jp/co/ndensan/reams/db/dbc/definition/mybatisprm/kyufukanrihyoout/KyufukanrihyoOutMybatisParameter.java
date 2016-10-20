/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kyufukanrihyoout;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付管理票作成のMYBATIS用パラメータクラスです。
 *
 * @reamsid_L DBC-2840-030 yaoyahui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class KyufukanrihyoOutMybatisParameter implements IMyBatisParameter {

    private final FlexibleYearMonth 処理年月;
    private final boolean is再処理区分;
    private final RString 出力順ID;
    private final FlexibleDate 最終更新年月日;
    private RString 制度改正施行日支給限度額一本化の年月;
    private RString 居宅サービス区分短期入所のコード;
    private RString 出力順;

    /**
     * コンストラクタです。
     *
     * @param 処理年月 処理年月
     * @param is再処理区分 is再処理区分
     * @param 出力順ID 出力順ID
     * @param 最終更新年月日 最終更新年月日
     */
    public KyufukanrihyoOutMybatisParameter(
            FlexibleYearMonth 処理年月, boolean is再処理区分, RString 出力順ID, FlexibleDate 最終更新年月日) {
        this.処理年月 = 処理年月;
        this.is再処理区分 = is再処理区分;
        this.出力順ID = 出力順ID;
        this.最終更新年月日 = 最終更新年月日;

    }
}
