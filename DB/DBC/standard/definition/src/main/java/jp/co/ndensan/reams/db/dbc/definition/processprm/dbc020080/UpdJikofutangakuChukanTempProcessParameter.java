/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.dbc020080;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;

/**
 * ビジネス設計_DBCMN62006_自己負担額計算（一括）のプロセスパラメタークラスです。
 *
 * @reamsid_L DBC-2060-050 liuyang
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class UpdJikofutangakuChukanTempProcessParameter implements IBatchProcessParameter {

    private RDateTime 処理日時;

    /**
     * DBC020080ProcessParameterのコンストラクタです。
     */
    public UpdJikofutangakuChukanTempProcessParameter() {
    }

    /**
     * DBC020080ProcessParameterのコンストラクタです。
     *
     * @param 処理日時 RDateTime
     */
    public UpdJikofutangakuChukanTempProcessParameter(RDateTime 処理日時) {
        this.処理日時 = 処理日時;
    }
}
