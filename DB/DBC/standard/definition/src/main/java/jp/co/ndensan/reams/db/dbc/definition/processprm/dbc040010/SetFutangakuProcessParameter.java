/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.dbc040010;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc040010.SetFutangakuMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * ビジネス設計_DBCMN62006_自己負担額計算（一括）のプロセスパラメタークラスです。
 *
 * @reamsid_L DBC-2060-050 liuyang
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class SetFutangakuProcessParameter implements IBatchProcessParameter {

    private boolean 事業分フラグ;
    private RString 出力対象区分;

    /**
     * DBC020080ProcessParameterのコンストラクタです。
     */
    public SetFutangakuProcessParameter() {
    }

    /**
     * InsShiharaihohoHenkoTempBeforeProcessParameterのコンストラクタです。
     *
     * @param 事業分フラグ boolean
     * @param 出力対象区分 RString
     */
    public SetFutangakuProcessParameter(boolean 事業分フラグ, RString 出力対象区分) {
        this.事業分フラグ = 事業分フラグ;
        this.出力対象区分 = 出力対象区分;
    }

    /**
     * toSetFutangakuMyBatisParameterのコンストラクタです
     *
     * @return SetFutangakuMyBatisParameter
     */
    public SetFutangakuMyBatisParameter toSetFutangakuMyBatisParameter() {
        return new SetFutangakuMyBatisParameter(this.事業分フラグ);
    }
}
