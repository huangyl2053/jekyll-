/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC110010;

import jp.co.ndensan.reams.db.dbc.definition.processprm.kyufukanrihyoout.KyufukanrihyoOutProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付管理票作成のParameter
 *
 * @reamsid_L DBC-2840-030 yaoyahui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBC110010_KyufukanrihyoOutParameter extends BatchParameterBase {

    private static final String KEY_処理年月 = "処理年月";
    private static final String KEY_再処理区分 = "再処理区分";
    private static final String KEY_出力順ID = "出力順ID";
    private static final String KEY_最終更新年月日 = "最終更新年月日";
    private static final String KEY_連番 = "連番";
    @BatchParameter(key = KEY_処理年月, name = "処理年月")
    private FlexibleYearMonth 処理年月;
    @BatchParameter(key = KEY_再処理区分, name = "再処理区分")
    private RString 再処理区分;
    @BatchParameter(key = KEY_出力順ID, name = "出力順ID")
    private RString 出力順ID;
    @BatchParameter(key = KEY_最終更新年月日, name = "最終更新年月日")
    private FlexibleDate 最終更新年月日;
    @BatchParameter(key = KEY_連番, name = "連番")
    private int 連番;
    private RString 帳票ID;

    /**
     * プロセスパラメータを作成します。
     *
     * @return KyufukanrihyoOutProcessParameter
     */
    public KyufukanrihyoOutProcessParameter toKyufukanrihyoOutProcessParameter() {
        return new KyufukanrihyoOutProcessParameter(処理年月, 再処理区分, 出力順ID, 最終更新年月日, 連番);
    }
}
