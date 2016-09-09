/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakugassanjikofutangakushomeishoin;

import jp.co.ndensan.reams.db.dbc.definition.core.saishori.SaiShoriKubun;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import lombok.Getter;

/**
 * 高額合算自己負担額証明書情報取込のバッチ用パラメータクラスです。
 *
 * @reamsid_L DBC-2640-010 zhengshenlei
 */
@Getter
public class KogakuGassanJikofutangakuShomeishoInMybatisParameter implements IMyBatisParameter {

    private final FlexibleYearMonth shoriYm;
    private final SaiShoriKubun saisyorikubunn;
    private final Long syutsuryokuID;

    /**
     * コンストラクタです。
     *
     * @param shoriYm 処理年月
     * @param syutsuryokuID 再処理区分
     * @param saisyorikubunn 出力順ID
     */
    public KogakuGassanJikofutangakuShomeishoInMybatisParameter(FlexibleYearMonth shoriYm, SaiShoriKubun saisyorikubunn, Long syutsuryokuID) {
        this.shoriYm = shoriYm;
        this.saisyorikubunn = saisyorikubunn;
        this.syutsuryokuID = syutsuryokuID;
    }
}
