/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.fuchokarisanteifuka;

import jp.co.ndensan.reams.uz.uza.biz.ReportId;

/**
 * バッチ出力帳票一覧Entityクラスです。
 *
 * @reamsid_L DBB-0710-020 gongliang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class BatchFuchoKariSanteiResult {

    private ReportId 帳票ID;
    private long 出力順ID;

    /**
     * コンストラクタです。
     *
     * @param 帳票ID ReportId
     * @param 出力順ID long
     */
    public BatchFuchoKariSanteiResult(ReportId 帳票ID,
            long 出力順ID) {
        this.帳票ID = 帳票ID;
        this.出力順ID = 出力順ID;
    }
}
