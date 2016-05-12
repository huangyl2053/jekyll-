/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinsahanteinohenkojokyo;

import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsahanteinohenkojokyo.ShinsahanteinoHenkojokyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 審査判定の変更状況Builderクラスです。
 *
 * @reamsid_L DBE-1450-060 dongyabin
 */
class ShinsahanteinoHenkojokyoBuilder implements IShinsahanteinoHenkojokyoBuilder {

    private final IShinsahanteinoHenkojokyoEditor editor;
    private final IShinsahanteinoHenkojokyoBodyEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IJohoTeikyoShiryoEditor}
     */
    public ShinsahanteinoHenkojokyoBuilder(IShinsahanteinoHenkojokyoEditor editor,
            IShinsahanteinoHenkojokyoBodyEditor bodyEditor) {
        this.editor = editor;
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link ShinsahanteinoHenkojokyoReportSource}
     */
    @Override
    public ShinsahanteinoHenkojokyoReportSource build() {
        return ReportEditorJoiner.from(new ShinsahanteinoHenkojokyoReportSource()).join(editor).join(bodyEditor).buildSource();
    }
}
