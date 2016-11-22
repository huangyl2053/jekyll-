/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC120090;

import jp.co.ndensan.reams.db.dbc.definition.processprm.shokanshikyuketteiin.ShokanShikyuKetteiInProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 取り込み処理のバッチ用パラメータクラスです。
 *
 * @reamsid_L DBC-0980-330 gongliang
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBC120090_ShokanShikyuKetteiInParameter extends BatchParameterBase {

    private static final long serialVersionUID = 1L;

    private static final String KEY_SHORI_YEARMONTH = "shoriYearMonth";
    private static final String KEY_SAISHORI_KUBUN = "saishoriKubun";
    private static final String KEY_SHUTSURYO_KUJUN = "shutsuryokujun";

    @BatchParameter(key = KEY_SHORI_YEARMONTH, name = "処理年月")
    private RDate shoriYearMonth;
    @BatchParameter(key = KEY_SAISHORI_KUBUN, name = "再処理区分")
    private RString saishoriKubun;
    @BatchParameter(key = KEY_SHUTSURYO_KUJUN, name = "出力順")
    private RString shutsuryokujun;
    @BatchParameter(key = "loginUserId", name = "loginUserId")
    private RString loginUserId;
    /**
     *
     * @return プロセス用パラメータ。
     */
    public ShokanShikyuKetteiInProcessParameter toDBC120090_ShokanShikyuKetteiInProcessParameter() {
        return new ShokanShikyuKetteiInProcessParameter(shoriYearMonth, saishoriKubun, shutsuryokujun,
                null, null, null, null, null);
    }
}
