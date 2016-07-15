/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosahoshushiharai;

import jp.co.ndensan.reams.db.dbe.entity.report.source.chosahoshushiharai.ChosaHoshuShiharaiReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票設計_DBE621003_認定調査報酬支払通知書のChosaHoshuShiharaiBuilderです。
 *
 * @reamsid_L DBE-1980-041 xuyongchao
 */
public class ChosaHoshuShiharaiBuilder implements IChosaHoshuShiharaiBuilder {

    private final IChosaHoshuShiharaiEditor editor;
    private final IChosaHoshuShiharaiBodyEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param editor editor
     * @param bodyEditor bodyEditor
     */
    public ChosaHoshuShiharaiBuilder(IChosaHoshuShiharaiEditor editor, IChosaHoshuShiharaiBodyEditor bodyEditor) {
        this.editor = editor;
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link ChosaHoshuShiharaiReportSource}
     */
    @Override
    public ChosaHoshuShiharaiReportSource build() {
        return ReportEditorJoiner.from(new ChosaHoshuShiharaiReportSource()).join(editor).join(bodyEditor).buildSource();
    }
}
