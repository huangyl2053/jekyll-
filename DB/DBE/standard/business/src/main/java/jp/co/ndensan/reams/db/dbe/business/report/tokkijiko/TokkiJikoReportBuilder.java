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

    /**
     * コンストラクタです。
     *
     * @param editor {@link ITokkiJikoReportEditor}
     */
    public TokkiJikoReportBuilder(ITokkiJikoReportEditor editor) {
        this.editor = editor;
    }

    @Override
    public TokkiJikoReportSource build() {
        return ReportEditorJoiner.from(new TokkiJikoReportSource()).join(editor).buildSource();
    }

}
