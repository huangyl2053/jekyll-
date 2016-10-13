/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.dbc180050;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * バッチ設計_DBCMNK4001_更正対象給付実績一覧(処理結果確認リスト作成ProcessParameter)
 *
 * @reamsid_L DBC-4960-030 dengwei
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShoriKekkaKakuninListProcessParameter implements IBatchProcessParameter {

    private RDateTime 作成日時;

    public ShoriKekkaKakuninListProcessParameter(RDateTime 作成日時) {
        this.作成日時 = 作成日時;
    }
}
