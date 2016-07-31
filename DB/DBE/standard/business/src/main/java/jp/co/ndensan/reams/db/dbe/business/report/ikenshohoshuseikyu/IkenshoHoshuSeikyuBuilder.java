/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ikenshohoshuseikyu;

import jp.co.ndensan.reams.db.dbe.entity.report.source.ikenshohoshuseikyu.IkenshoHoshuSeikyuReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票設計_DBE621004_主治医意見書作成報酬請求書のIkenshoHoshuSeikyuBuilderです。
 *
 * @reamsid_L DBE-1980-042 xuyongchao
 */
public class IkenshoHoshuSeikyuBuilder implements IIkenshoHoshuSeikyuBuilder {

    private final IIkenshoHoshuSeikyuEditor editor;
    private final IIkenshoHoshuSeikyuBodyEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param editor editor
     * @param bodyEditor bodyEditor
     */
    public IkenshoHoshuSeikyuBuilder(IIkenshoHoshuSeikyuEditor editor, IIkenshoHoshuSeikyuBodyEditor bodyEditor) {
        this.editor = editor;
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link IkenshoHoshuSeikyuReportSource}
     */
    @Override
    public IkenshoHoshuSeikyuReportSource build() {
        return ReportEditorJoiner.from(new IkenshoHoshuSeikyuReportSource()).join(editor).join(bodyEditor).buildSource();
    }

}
