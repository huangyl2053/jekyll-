/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC120080;

import jp.co.ndensan.reams.db.dbc.definition.core.saishori.SaiShoriKubun;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;

/**
 * 高額サービス費決定情報取込みのパラメータ
 *
 * @reamsid_L DBC-0980-390 lijunjun
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBC120080_KogakuKyufuKetteiInParameter extends BatchParameterBase {

    private static final String KEY_SHORIYM = "shoriYM";
    private static final String NAME_SHORIYM = "処理年月";
    private static final String KEY_SAISHORIKUBUN = "saishoriKubun";
    private static final String NAME_SAISHORIKUBUN = "再処理区分";
    private static final String KEY_SHUTSURYOKUJUNID = "shutsuryokujunId";
    private static final String NAME_SHUTSURYOKUJUNID = "出力順ID";

    @BatchParameter(key = KEY_SHORIYM, name = NAME_SHORIYM)
    private FlexibleYearMonth shoriYM;
    @BatchParameter(key = KEY_SAISHORIKUBUN, name = NAME_SAISHORIKUBUN)
    private SaiShoriKubun saishoriKubun;
    @BatchParameter(key = KEY_SHUTSURYOKUJUNID, name = NAME_SHUTSURYOKUJUNID)
    private Long shutsuryokujunId;
}
