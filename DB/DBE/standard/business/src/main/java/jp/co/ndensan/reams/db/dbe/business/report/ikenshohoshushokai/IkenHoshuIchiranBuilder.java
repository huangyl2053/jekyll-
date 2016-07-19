/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ikenshohoshushokai;

import jp.co.ndensan.reams.db.dbe.entity.report.ikenhoshuichiran.IkenHoshuIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 主治医意見書作成報酬実績集計表Builderクラスです。
 *
 * @reamsid_L DBE-1930-010 chenxiangyu
 */
class IkenHoshuIchiranBuilder implements IIkenHoshuIchiranBuilder {

    private final IIkenHoshuIchiranEditor bodyEditor;
    private final IIkenHoshuIchiranEditor headEditor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IkenHoshuIchiranBodyEditor}
     * @param editor {@link IkenHoshuIchiranHeadEditor}
     */
    public IkenHoshuIchiranBuilder(IIkenHoshuIchiranEditor bodyEditor, IIkenHoshuIchiranEditor headEditor) {
        this.bodyEditor = bodyEditor;
        this.headEditor = headEditor;
    }

    @Override
    public IkenHoshuIchiranReportSource build() {
        return ReportEditorJoiner.from(new IkenHoshuIchiranReportSource()).join(headEditor).join(bodyEditor).buildSource();
    }
}
