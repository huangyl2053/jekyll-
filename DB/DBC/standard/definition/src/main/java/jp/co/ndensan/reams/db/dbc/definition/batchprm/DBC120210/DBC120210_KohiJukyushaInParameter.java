/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC120210;

import jp.co.ndensan.reams.db.dbc.definition.core.saishori.SaiShoriKubun;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 介護給付費公費受給者別一覧表情報取込のバッチ用パラメータクラスです。
 *
 * @reamsid_L DBC-2800-010 duanzhanli
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBC120210_KohiJukyushaInParameter extends BatchParameterBase {

    private static final String KEY_SYORINENGETSU = "処理年月";
    private static final String KEY_SAISYORIKUBUN = "再処理区分";
    private static final String KEY_SHUTSURYOKUJUNID = "出力順ID";

    @BatchParameter(key = KEY_SYORINENGETSU, name = "処理年月")
    private FlexibleYearMonth 処理年月;
    @BatchParameter(key = KEY_SAISYORIKUBUN, name = "再処理区分")
    private SaiShoriKubun 再処理区分;
    @BatchParameter(key = KEY_SHUTSURYOKUJUNID, name = "出力順ID")
    private long 出力順ID;
    @BatchParameter(key = "loginUserId", name = "loginUserId")
    private RString loginUserId;

}
