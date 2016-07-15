/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shujiihoshushiharai;

import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiihoshushiharai.ShujiiHoshuShiharaiReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票設計_DBE621002_主治医意見書作成報酬支払通知書のShujiiHoshuShiharaiBuilderです。
 *
 * @reamsid_L DBE-1980-040 xuyongchao
 */
public class ShujiiHoshuShiharaiBuilder implements IShujiiHoshuShiharaiBuilder {

    private final IShujiiHoshuShiharaiEditor editor;
    private final IShujiiHoshuShiharaiBodyEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param editor editor
     * @param bodyEditor bodyEditor
     */
    public ShujiiHoshuShiharaiBuilder(IShujiiHoshuShiharaiEditor editor, IShujiiHoshuShiharaiBodyEditor bodyEditor) {
        this.editor = editor;
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link ShujiiHoshuShiharaiReportSource}
     */
    @Override
    public ShujiiHoshuShiharaiReportSource build() {
        return ReportEditorJoiner.from(new ShujiiHoshuShiharaiReportSource()).join(editor).join(bodyEditor).buildSource();
    }
}
