/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC110010;

import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;

/**
 * 給付管理票作成のParameter
 *
 * @reamsid_L DBC-3300-120 wangxingpeng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBC110010_KyufukanrihyoOutParameter extends BatchParameterBase {

    private static final String KEY_処理年月 = "処理年月";
    private static final String KEY_再処理区分 = "再処理区分";
    private static final String KEY_出力順ID = "出力順ID";
    private static final String KEY_最終更新年月日 = "最終更新年月日";
    @BatchParameter(key = KEY_処理年月, name = "処理年月")
    private RYearMonth 処理年月;
    @BatchParameter(key = KEY_再処理区分, name = "再処理区分")
    private RString 再処理区分;
    @BatchParameter(key = KEY_出力順ID, name = "出力順ID")
    private RString 出力順ID;
    @BatchParameter(key = KEY_最終更新年月日, name = "最終更新年月日")
    private RDate 最終更新年月日;
}
