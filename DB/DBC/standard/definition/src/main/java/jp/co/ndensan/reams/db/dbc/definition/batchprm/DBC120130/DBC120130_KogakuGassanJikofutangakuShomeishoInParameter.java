/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC120130;

import jp.co.ndensan.reams.db.dbc.definition.core.saishori.SaiShoriKubun;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakugassanjikofutangakushomeishoin.KogakuGassanJikofutangakuShomeishoInProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 高額合算自己負担額証明書情報取込のバッチ用パラメータクラスです。
 *
 * @reamsid_L DBC-2640-010 zhengshenlei
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBC120130_KogakuGassanJikofutangakuShomeishoInParameter extends BatchParameterBase {

    private static final long serialVersionUID = 1L;

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
    @BatchParameter(key = "loginUserId", name = "loginUserId")
    private RString loginUserId;

    /**
     * プロセスパラメータを作成します。
     *
     * @return プロセスパラメータ
     */
    public KogakuGassanJikofutangakuShomeishoInProcessParameter toProcessParameter() {
        return new KogakuGassanJikofutangakuShomeishoInProcessParameter(shoriYM, saishoriKubun, shutsuryokujunId);
    }

}
