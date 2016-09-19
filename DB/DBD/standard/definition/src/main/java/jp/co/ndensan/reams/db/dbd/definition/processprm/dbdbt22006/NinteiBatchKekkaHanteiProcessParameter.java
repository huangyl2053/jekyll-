/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.processprm.dbdbt22006;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import lombok.Getter;
import lombok.Setter;

/**
 * 負担限度額認定申請一括承認（バッチ）_一括認定結果反映のProcessパラメータクラスです。
 *
 * @reamsid_L DBD-3710-070 chenxin
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinteiBatchKekkaHanteiProcessParameter implements IBatchProcessParameter {

    private boolean テスト処理;

    /**
     * コンストラクタです。
     *
     * @param テスト処理
     */
    public NinteiBatchKekkaHanteiProcessParameter(boolean テスト処理) {
        this.テスト処理 = テスト処理;
    }
}
