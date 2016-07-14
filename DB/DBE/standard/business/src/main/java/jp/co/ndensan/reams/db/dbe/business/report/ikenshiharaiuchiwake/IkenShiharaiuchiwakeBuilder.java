/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ikenshiharaiuchiwake;

import jp.co.ndensan.reams.db.dbe.entity.report.source.ikenshiharaiuchiwake.IkenShiharaiuchiwakeReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票設計_DBE622004_主治医意見書作成料支払内訳確認書のIkenShiharaiuchiwakeBuilderです。
 *
 * @reamsid_L DBE-1980-047 xuyongchao
 */
public class IkenShiharaiuchiwakeBuilder implements IIkenShiharaiuchiwakeBuilder {

    private final IIkenShiharaiuchiwakeEditor editor;
    private final IIkenShiharaiuchiwakeEditor detailEditor;

    /**
     * インスタンスを生成します。
     *
     * @param editor editor
     * @param detailEditor detailEditor
     */
    public IkenShiharaiuchiwakeBuilder(IIkenShiharaiuchiwakeEditor editor, IIkenShiharaiuchiwakeEditor detailEditor) {
        this.editor = editor;
        this.detailEditor = detailEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link IkenShiharaiuchiwakeReportSource}
     */
    @Override
    public IkenShiharaiuchiwakeReportSource build() {
        return ReportEditorJoiner.from(new IkenShiharaiuchiwakeReportSource()).join(editor).join(detailEditor).buildSource();
    }

}
