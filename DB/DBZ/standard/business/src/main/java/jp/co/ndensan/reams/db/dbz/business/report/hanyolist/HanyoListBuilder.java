/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.report.hanyolist;

import jp.co.ndensan.reams.db.dbz.entity.report.hanyolist.HanyoListReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 汎用リストのBuilderです。
 *
 * @reamsid_L DBZ-4570-020 jinge
 */
public class HanyoListBuilder implements IHanyoListBuilder {

    private final IHanyoListEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editorImpl {@link IHanyoListEditor}
     */
    HanyoListBuilder(IHanyoListEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link HanyoListReportSource}
     */
    @Override
    public HanyoListReportSource build() {
        return ReportEditorJoiner.from(new HanyoListReportSource()).join(editor).buildSource();
    }

}
