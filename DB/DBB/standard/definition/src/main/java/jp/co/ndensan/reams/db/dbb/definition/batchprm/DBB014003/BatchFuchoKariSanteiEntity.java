/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB014003;

import jp.co.ndensan.reams.uz.uza.biz.ReportId;

/**
 * バッチ出力帳票一覧Entityクラスです。
 *
 * @reamsid_L DBB-0710-030 gongliang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class BatchFuchoKariSanteiEntity {

    private ReportId 帳票分類ID;
    private ReportId 帳票ID;
    private long 出力順ID;

    /**
     * コンストラクタです。
     *
     * @param 帳票分類ID ReportId
     * @param 帳票ID ReportId
     * @param 出力順ID long
     */
    public BatchFuchoKariSanteiEntity(ReportId 帳票分類ID,
            ReportId 帳票ID,
            long 出力順ID) {
        this.帳票分類ID = 帳票分類ID;
        this.帳票ID = 帳票ID;
        this.出力順ID = 出力順ID;
    }
}
