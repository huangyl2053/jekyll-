/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosahoshumeisai;

import jp.co.ndensan.reams.db.dbe.entity.report.source.chosahoshumeisai.ChosaHoshumeisaiReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 認定調査報酬支払明細書Builderクラスです。
 *
 * @reamsid_L DBE-1980-045 suguangjun
 */
class ChosaHoshumeisaiBuilder implements IChosaHoshumeisaiBuilder {

    private final IChosaHoshumeisaiEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IChosaHoshumeisaiEditor}
     */
    public ChosaHoshumeisaiBuilder(IChosaHoshumeisaiEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link ChosaHoshumeisaiReportSource}
     */
    @Override
    public ChosaHoshumeisaiReportSource build() {
        return ReportEditorJoiner.from(new ChosaHoshumeisaiReportSource()).join(editor).buildSource();
    }
}
