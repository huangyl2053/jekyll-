/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.hakkogoidotaishoshaichiran;

import jp.co.ndensan.reams.db.dbb.entity.report.hakkogoidotaishoshaichiran.HakkogoIdoTaishoshaIchiranSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 通知書発行後異動把握帳票HakkogoIdoTaishoshaIchiranBuilder
 *
 * @reamsid_L DBB-0690-030 surun
 */
public class HakkogoIdoTaishoshaIchiranBuilder implements IHakkogoIdoTaishoshaIchiranBuilder {

    private final IHakkogoIdoTaishoshaIchiranEditor headerEditor;
    private final IHakkogoIdoTaishoshaIchiranEditor bodyEditor;

    /**
     * コンストラクタです
     *
     * @param headerEditor IHakkogoIdoTaishoshaIchiranEditor
     * @param bodyEditor IHakkogoIdoTaishoshaIchiranEditor
     */
    public HakkogoIdoTaishoshaIchiranBuilder(
            IHakkogoIdoTaishoshaIchiranEditor headerEditor,
            IHakkogoIdoTaishoshaIchiranEditor bodyEditor) {
        this.headerEditor = headerEditor;
        this.bodyEditor = bodyEditor;
    }

    @Override
    public HakkogoIdoTaishoshaIchiranSource build() {
        return ReportEditorJoiner.from(new HakkogoIdoTaishoshaIchiranSource()).join(headerEditor).join(bodyEditor).buildSource();
    }
}
