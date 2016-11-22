/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC120150;

import jp.co.ndensan.reams.db.dbc.definition.core.saishori.SaiShoriKubun;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額合算給付実績取込のバッチ用パラメータクラスを作成する。
 *
 * @reamsid_L DBC-2700-010 wangxingpeng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBC120150_KogakuGassanKyufuJissekiInParameter extends BatchParameterBase {

    private static final String KEY_処理年月 = "処理年月";
    private static final String KEY_再処理区分 = "再処理区分";
    private static final String KEY_出力順ID = "出力順ID";
    private static final String KEY_処理区分 = "処理区分";

    @BatchParameter(key = KEY_処理年月, name = "処理年月")
    private FlexibleYearMonth 処理年月;
    @BatchParameter(key = KEY_再処理区分, name = "再処理区分")
    private SaiShoriKubun 再処理区分;
    @BatchParameter(key = KEY_出力順ID, name = "出力順ID")
    private RString 出力順ID;
    @BatchParameter(key = KEY_処理区分, name = "処理区分")
    private RString 処理区分;
    @BatchParameter(key = "loginUserId", name = "loginUserId")
    private RString loginUserId;

}
