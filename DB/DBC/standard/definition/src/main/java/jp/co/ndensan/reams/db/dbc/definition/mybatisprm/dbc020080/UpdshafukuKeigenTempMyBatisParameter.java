/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc020080;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;

/**
 * ビジネス設計_DBCMN62006_自己負担額計算（一括）のMyBatisパラメタークラスです。
 *
 * @reamsid_L DBC-2060-050 liuyang
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class UpdshafukuKeigenTempMyBatisParameter implements IMyBatisParameter {

    private boolean 事業者フラグ;

    /**
     * UpdshafukuKeigenTempMyBatisParameter のコンストラクタです。
     */
    public UpdshafukuKeigenTempMyBatisParameter() {
    }

    /**
     * UpdshafukuKeigenTempMyBatisParameter のコンストラクタです。
     *
     * @param 事業者フラグ boolean
     */
    public UpdshafukuKeigenTempMyBatisParameter(boolean 事業者フラグ) {
        this.事業者フラグ = 事業者フラグ;
    }
}
