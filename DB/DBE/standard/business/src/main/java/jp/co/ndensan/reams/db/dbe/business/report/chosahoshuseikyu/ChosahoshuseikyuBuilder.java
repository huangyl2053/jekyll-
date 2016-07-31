/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosahoshuseikyu;

import jp.co.ndensan.reams.db.dbe.entity.report.source.chosahoshuseikyu.ChosahoshuseikyuReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 認定調査報酬請求書Builderクラスです。
 *
 * @reamsid_L DBE-1980-043 suguangjun
 */
class ChosahoshuseikyuBuilder implements IChosahoshuseikyuBuilder {

    private final IChosahoshuseikyuEditor editor;
    private final IChosahoshuseikyuBodyEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IChosahoshuseikyuEditor}
     */
    public ChosahoshuseikyuBuilder(IChosahoshuseikyuEditor editor,
            IChosahoshuseikyuBodyEditor bodyEditor) {
        this.editor = editor;
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link ChosahoshuseikyuReportSource}
     */
    @Override
    public ChosahoshuseikyuReportSource build() {
        return ReportEditorJoiner.from(new ChosahoshuseikyuReportSource()).join(editor).join(bodyEditor).buildSource();
    }
}
