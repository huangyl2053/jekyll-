/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC120880;

import jp.co.ndensan.reams.db.dbc.definition.core.saishori.SaiShoriKubun;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 総合事業費資格照合表情報取込のバッチパラメータです。
 *
 * @reamsid_L DBC-2890-012 wangxue
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBC120880_SogojigyohiShikakuShogohyoInParameter extends BatchParameterBase {

    private static final String KEY_SHORIYM = "shoriYM";
    private static final String KEY_SAISHORIKUBUN = "saishorikubun";
    private static final String KEY_SHUTSURYOKUJUNID = "shutsuryokujunID";

    @BatchParameter(key = KEY_SHORIYM, name = "処理年月")
    private FlexibleYearMonth shoriYM;
    @BatchParameter(key = KEY_SAISHORIKUBUN, name = "再処理区分")
    private SaiShoriKubun saishorikubun;
    @BatchParameter(key = KEY_SHUTSURYOKUJUNID, name = "出力順ID")
    private Long shutsuryokujunID;
    @BatchParameter(key = "loginUserId", name = "loginUserId")
    private RString loginUserId;

}
