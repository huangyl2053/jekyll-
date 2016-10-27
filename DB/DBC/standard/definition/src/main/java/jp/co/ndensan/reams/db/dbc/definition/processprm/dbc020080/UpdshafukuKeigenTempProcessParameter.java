/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.dbc020080;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc020080.UpdshafukuKeigenTempMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;

/**
 * ビジネス設計_DBCMN62006_自己負担額計算（一括）のプロセスパラメタークラスです。
 *
 * @reamsid_L DBC-2060-050 liuyang
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class UpdshafukuKeigenTempProcessParameter implements IBatchProcessParameter {

    private boolean 事業分フラグ;

    /**
     * UpdshafukuKeigenTempProcessParameterのコンストラクタです。
     */
    public UpdshafukuKeigenTempProcessParameter() {
    }

    /**
     * UpdshafukuKeigenTempProcessParameterのコンストラクタです。
     *
     * @param 事業分フラグ boolean
     */
    public UpdshafukuKeigenTempProcessParameter(boolean 事業分フラグ) {
        this.事業分フラグ = 事業分フラグ;
    }

    /**
     * toUpdshafukuKeigenTempMyBatisParameterのコンストラクタです
     *
     * @return UpdshafukuKeigenTempMyBatisParameter
     */
    public UpdshafukuKeigenTempMyBatisParameter toUpdshafukuKeigenTempMyBatisParameter() {
        return new UpdshafukuKeigenTempMyBatisParameter(事業分フラグ);
    }
}
