/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.kogakugassanjikofutangakushomeishoin;

import jp.co.ndensan.reams.db.dbc.definition.core.saishori.SaiShoriKubun;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakugassanjikofutangakushomeishoin.KogakuGassanJikofutangakuShomeishoInMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
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
public class KogakuGassanJikofutangakuShomeishoInProcessParameter implements IBatchProcessParameter {

    private FlexibleYearMonth shoriYm;
    private SaiShoriKubun saisyorikubunn;
    private Long syutsuryokuID;

    /**
     * コンストラクタです。
     *
     * @param shoriYm 処理年月
     * @param syutsuryokuID 再処理区分
     * @param saisyorikubunn 出力順ID
     */
    public KogakuGassanJikofutangakuShomeishoInProcessParameter(FlexibleYearMonth shoriYm, SaiShoriKubun saisyorikubunn, Long syutsuryokuID) {
        this.shoriYm = shoriYm;
        this.saisyorikubunn = saisyorikubunn;
        this.syutsuryokuID = syutsuryokuID;
    }

    /**
     * MYBATIS用パラメータを作成します。
     *
     * @return MYBATIS用パラメータ
     */
    public KogakuGassanJikofutangakuShomeishoInMybatisParameter toMybatisParamter() {
        return new KogakuGassanJikofutangakuShomeishoInMybatisParameter(shoriYm, saisyorikubunn, syutsuryokuID);
    }
}
