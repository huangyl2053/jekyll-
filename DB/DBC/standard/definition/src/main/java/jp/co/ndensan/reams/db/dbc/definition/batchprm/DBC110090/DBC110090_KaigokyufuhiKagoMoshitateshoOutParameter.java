/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC110090;

import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;

/**
 * 介護給付費過誤申立書作成のParameter
 *
 * @reamsid_L DBC-3300-130 wangxingpeng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBC110090_KaigokyufuhiKagoMoshitateshoOutParameter extends BatchParameterBase {

    private static final String KEY_処理年月 = "処理年月";
    private static final String KEY_再処理区分 = "再処理区分";
    private static final String KEY_出力順ID = "出力順ID";
    private static final String KEY_送付対象情報のｺｰﾄﾞ = "送付対象情報のｺｰﾄﾞ";
    private static final String KEY_出力順情報 = "出力順情報";
    @BatchParameter(key = KEY_処理年月, name = "処理年月")
    private RYearMonth 処理年月;
    @BatchParameter(key = KEY_再処理区分, name = "再処理区分")
    private RString 再処理区分;
    @BatchParameter(key = KEY_出力順ID, name = "出力順ID")
    private RString 出力順ID;
    @BatchParameter(key = KEY_送付対象情報のｺｰﾄﾞ, name = "送付対象情報のｺｰﾄﾞ")
    private RString 送付対象情報のｺｰﾄﾞ;
    @BatchParameter(key = KEY_出力順情報, name = "出力順情報")
    private RString 出力順情報;
}
