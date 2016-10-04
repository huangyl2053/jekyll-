/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC170010;

import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc170010.ServicecodeIdoRenrakuhyoOutProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;

/**
 * 総合事業分サービスコード異動連絡票作成バッチ用パラメータクラスです。
 *
 * @reamsid_L DBC-4740-030 zhaowei
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBC170010_ServicecodeIdoRenrakuhyoOutParameter extends BatchParameterBase {

    private static final String KEY_処理年月 = "処理年月";
    private static final String KEY_再処理区分 = "再処理区分";
    private static final String KEY_出力順ID = "出力順ID";
    private static final String KEY_出力対象区分 = "出力対象区分";
    private static final String KEY_処理選択区分 = "処理選択区分";
    @BatchParameter(key = KEY_処理年月, name = "処理年月")
    private RYearMonth 処理年月;
    @BatchParameter(key = KEY_再処理区分, name = "再処理区分")
    private RString 再処理区分;
    @BatchParameter(key = KEY_出力順ID, name = "出力順ID")
    private RString 出力順ID;
    @BatchParameter(key = KEY_出力対象区分, name = "出力対象区分")
    private RString 出力対象区分;
    @BatchParameter(key = KEY_処理選択区分, name = "処理選択区分")
    private RString 処理選択区分;

    /**
     * processのパラメータを生成します。
     *
     * @return ServicecodeIdoRenrakuhyoOutProcessParameter
     */
    public ServicecodeIdoRenrakuhyoOutProcessParameter toProcessParameter() {
        return new ServicecodeIdoRenrakuhyoOutProcessParameter(
                処理年月,
                再処理区分,
                出力順ID,
                出力対象区分,
                処理選択区分);
    }
}
