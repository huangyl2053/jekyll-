/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.dbc020080;

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
public class UpdJIssekiFutangakuTempProcessParameter implements IBatchProcessParameter {

    private boolean 事業分フラグ;
    private RString 処理区分;

    /**
     * UpdJIssekiFutangakuTempProcessParameterのコンストラクタです。
     *
     * @param 事業分フラグ boolean
     * @param 処理区分 RString
     */
    public UpdJIssekiFutangakuTempProcessParameter(boolean 事業分フラグ, RString 処理区分) {
        this.事業分フラグ = 事業分フラグ;
        this.処理区分 = 処理区分;
    }

}
