/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.basic.honsanteifuka;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.honsanteifuka.BatchTyouhyouEntity;

/**
 * バッチ出力帳票一覧のクラスです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class BatchTyouhyouResult implements Serializable {

    private BatchTyouhyouEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity entity
     */
    public BatchTyouhyouResult(BatchTyouhyouEntity entity) {
        this.entity = entity;
    }
}
