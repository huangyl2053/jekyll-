/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.dbc020080;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * ビジネス設計_DBCMN62006_自己負担額計算（一括）のプロセスパラメタークラスです。
 *
 * @reamsid_L DBC-2060-050 liuyang
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class UpdJIssekiFutangakuTempAfterProcessParameter implements IBatchProcessParameter {

    private RString 処理区分;
    private RDateTime 処理日時;

    /**
     * UpdJIssekiFutangakuTempAfterProcessParameterのコンストラクタです。
     */
    public UpdJIssekiFutangakuTempAfterProcessParameter() {
    }

    /**
     * UpdJIssekiFutangakuTempAfterProcessParameterのコンストラクタです。
     *
     * @param 処理区分 RString
     * @param 処理日時 RDateTime
     */
    public UpdJIssekiFutangakuTempAfterProcessParameter(RString 処理区分, RDateTime 処理日時) {
        this.処理区分 = 処理区分;
        this.処理日時 = 処理日時;
    }

}
