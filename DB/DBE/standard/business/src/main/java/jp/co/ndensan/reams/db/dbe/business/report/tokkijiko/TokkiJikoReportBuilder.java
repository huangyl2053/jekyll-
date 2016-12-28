/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.tokkijiko;

import jp.co.ndensan.reams.db.dbe.entity.report.source.tokkijiko.TokkiJikoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 特記事項帳票のReportBuilderクラスです。
 */
public class TokkiJikoReportBuilder implements ITokkiJikoReportBuilder {

    private final ITokkiJikoReportEditor editor;
    private final ITokkiJikoReportListFieldEditor listEditor;

    /**
     * コンストラクタです。
     *
     * @param editor {@link ITokkiJikoReportEditor}
     * @param listEditor {@link ITokkiJikoReportListFieldEditor}
     */
    public TokkiJikoReportBuilder(ITokkiJikoReportEditor editor, ITokkiJikoReportListFieldEditor listEditor) {
        this.editor = editor;
        this.listEditor = listEditor;
    }

    /**
     * コンストラクタです。
     *
     * @param editor {@link ITokkiJikoReportEditor}
     */
    public TokkiJikoReportBuilder(ITokkiJikoReportEditor editor) {
        this.editor = editor;
        this.listEditor = null;
    }

    @Override
    public TokkiJikoReportSource build() {
        if (listEditor != null) {
            return ReportEditorJoiner.from(new TokkiJikoReportSource()).join(editor).join(listEditor).buildSource();
        }
        return ReportEditorJoiner.from(new TokkiJikoReportSource()).join(editor).buildSource();
    }

}
