/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.shokanfushikyuketteiin;

import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 償還払不支給決定情報取込 のバッチパラメータです。
 *
 * @reamsid_L DBC-2590-010 xuhao
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBC120100_ShokanFushikyuKetteiInBatchParameter extends BatchParameterBase {

    private static final String KEY_SHORI_YEARMONTH = "shoriYearMonth";
    private static final String KEY_SAISHORI_KUBUN = "saishoriKubun";
    private static final String KEY_SHUTSURYO_KUJUN = "shutsuryokujun";

    @BatchParameter(key = KEY_SHORI_YEARMONTH, name = "処理年月")
    private FlexibleYearMonth shoriYearMonth;
    @BatchParameter(key = KEY_SAISHORI_KUBUN, name = "再処理区分")
    private RString saishoriKubun;
    @BatchParameter(key = KEY_SHUTSURYO_KUJUN, name = "出力順")
    private Long shutsuryokujun;

}
