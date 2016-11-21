/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC120020;

import jp.co.ndensan.reams.db.dbc.definition.core.saishori.SaiShoriKubun;
import jp.co.ndensan.reams.db.dbc.definition.processprm.henreihoryuin.HenreiHoryuInProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 請求明細・給付管理票返戻（保留）一覧表取込のバッチパラメータです。
 *
 * @reamsid_L DBC-2830-010 yaodongsheng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBC120020_HenreiHoryuInParameter extends BatchParameterBase {

    private static final String KEY_SHORIYM = "shoriYM";
    private static final String NAME_SHORIYM = "処理年月";
    private static final String KEY_SHORIKUBUN = "shoriKubun";
    private static final String NAME_SHORIKUBUN = "再処理区分";
    private static final String KEY_SHUTSURYOKUJUNID = "shutsuryokuJunID";
    private static final String NAME_SHUTSURYOKUJUNID = "出力順ID";

    @BatchParameter(key = KEY_SHORIYM, name = NAME_SHORIYM)
    private FlexibleYearMonth shoriYM;
    @BatchParameter(key = KEY_SHORIKUBUN, name = NAME_SHORIKUBUN)
    private SaiShoriKubun shoriKubun;
    @BatchParameter(key = KEY_SHUTSURYOKUJUNID, name = NAME_SHUTSURYOKUJUNID)
    private Long shutsuryokuJunID;
    @BatchParameter(key = "loginUserId", name = "loginUserId")
    private RString loginUserId;

    /**
     * HenreiHoryuInProcessParameterの取得です。
     *
     * @return HenreiHoryuInProcessParameter
     */
    public HenreiHoryuInProcessParameter toHenreiHoryuInProcessParameter() {
        return new HenreiHoryuInProcessParameter(shoriYM, shoriKubun, shutsuryokuJunID);
    }
}
