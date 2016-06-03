/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.fuchokarisanteifuka;

import jp.co.ndensan.reams.db.dbb.definition.batchprm.fuchokarisanteitsuchishohakko.BatchFuchoKariSanteiEntity;

/**
 * バッチ出力帳票一覧Entityクラスです。
 *
 * @reamsid_L DBB-0710-020 gongliang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class BatchFuchoKariSanteiResult {

    private BatchFuchoKariSanteiEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity entity
     */
    public BatchFuchoKariSanteiResult(BatchFuchoKariSanteiEntity entity) {
        this.entity = entity;
    }
}
