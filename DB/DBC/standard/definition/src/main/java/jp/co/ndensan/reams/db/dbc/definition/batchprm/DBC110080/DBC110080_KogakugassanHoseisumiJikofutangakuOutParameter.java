/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC110080;

import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakugassan.KogakugassanProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額合算補正済自己負担額情報作成のバッチパラメータです。
 *
 * @reamsid_L DBC-2660-030 gongliang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBC110080_KogakugassanHoseisumiJikofutangakuOutParameter extends BatchParameterBase {

    private static final String KEY_SHORIYM = "shoriYM";
    private static final String NAME_SHORIYM = "処理年月";
    private static final String KEY_SAISHORIKUBUN = "saishoriKubun";
    private static final String NAME_SAISHORIKUBUN = "再処理区分";
    private static final String KEY_SHUTSURYOKUJUNID = "shutsuryokujunId";
    private static final String NAME_SHUTSURYOKUJUNID = "出力順ID";
    private static final String KEY_SHORIKUNBUN = "shoriKunbun";
    private static final String NAME_SHORIKUNBUN = "処理区分";

    @BatchParameter(key = KEY_SHORIYM, name = NAME_SHORIYM)
    private FlexibleYearMonth shoriYM;
    @BatchParameter(key = KEY_SAISHORIKUBUN, name = NAME_SAISHORIKUBUN)
    private RString saishoriKubun;
    @BatchParameter(key = KEY_SHUTSURYOKUJUNID, name = NAME_SHUTSURYOKUJUNID)
    private RString shutsuryokujunId;
    @BatchParameter(key = KEY_SHORIKUNBUN, name = NAME_SHORIKUNBUN)
    private RString shoriKunbun;

    /**
     * Processパラメータ作成メソッドです。
     *
     * @param now YMDHMS
     * @return Processパラメータ
     */
    public KogakugassanProcessParameter toKogakugassanProcessParameter(YMDHMS now) {
        return new KogakugassanProcessParameter(shoriYM, saishoriKubun, shutsuryokujunId, now, shoriKunbun);
    }

}
