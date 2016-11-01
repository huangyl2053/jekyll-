/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC110130;

import jp.co.ndensan.reams.db.dbc.definition.processprm.hokenshakyufujisseki.HokenshaKyufujissekiProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 保険者保有給付実績情報作成のバッチパラメータです。
 *
 * @reamsid_L DBC-2460-010 gongliang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBC110130_HokenshaKyufujissekiOutParameter extends BatchParameterBase {

    private static final String KEY_SHORIYM = "shoriYM";
    private static final String NAME_SHORIYM = "処理年月";
    private static final String KEY_SAISHORIKUBUN = "saishoriKubun";
    private static final String NAME_SAISHORIKUBUN = "再処理区分";
    private static final String KEY_SHUTSURYOKUJUNID = "shutsuryokujunId";
    private static final String NAME_SHUTSURYOKUJUNID = "出力順ID";

    @BatchParameter(key = KEY_SHORIYM, name = NAME_SHORIYM)
    private FlexibleYearMonth shoriYM;
    @BatchParameter(key = KEY_SAISHORIKUBUN, name = NAME_SAISHORIKUBUN)
    private RString saishoriKubun;
    @BatchParameter(key = KEY_SHUTSURYOKUJUNID, name = NAME_SHUTSURYOKUJUNID)
    private RString shutsuryokujunId;

    /**
     * Processパラメータ作成メソッドです。
     *
     * @param now YMDHMS
     * @return Processパラメータ
     */
    public HokenshaKyufujissekiProcessParameter toHokenshaKyufujissekiProcessParameter(YMDHMS now) {
        return new HokenshaKyufujissekiProcessParameter(shoriYM, saishoriKubun, shutsuryokujunId, now);
    }
}
