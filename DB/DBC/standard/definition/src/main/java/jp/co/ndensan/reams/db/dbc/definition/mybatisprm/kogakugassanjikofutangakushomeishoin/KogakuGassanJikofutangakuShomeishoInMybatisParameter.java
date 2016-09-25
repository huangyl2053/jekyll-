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
import lombok.Setter;

/**
 * 高額合算自己負担額証明書情報取込のバッチ用パラメータクラスです。
 *
 * @reamsid_L DBC-2640-010 zhengshenlei
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class KogakuGassanJikofutangakuShomeishoInMybatisParameter implements IMyBatisParameter {

    private FlexibleYearMonth shoriYm;
    private SaiShoriKubun saisyorikubunn;
    private Long syutsuryokuID;

    /**
     * コンストラクタです。
     *
     * @param shoriYm FlexibleYearMonth
     * @param syutsuryokuID SaiShoriKubun
     * @param saisyorikubunn Long
     */
    public KogakuGassanJikofutangakuShomeishoInMybatisParameter(FlexibleYearMonth shoriYm, SaiShoriKubun saisyorikubunn, Long syutsuryokuID) {
        this.shoriYm = shoriYm;
        this.saisyorikubunn = saisyorikubunn;
        this.syutsuryokuID = syutsuryokuID;
    }
}
