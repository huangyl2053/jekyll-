/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shujiihoshumeisai;

import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiihoshumeisai.ShujiiHoshumeisaiReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票設計_DBE622001_主治医意見書作成報酬支払明細書のShujiiHoshumeisaiBuilderです。
 *
 * @reamsid_L DBE-1980-044 xuyongchao
 */
public class ShujiiHoshumeisaiBuilder implements IShujiiHoshumeisaiBuilder {

    private final IShujiiHoshumeisaiEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor editor
     */
    public ShujiiHoshumeisaiBuilder(IShujiiHoshumeisaiEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link ShujiiHoshumeisaiReportSource}
     */
    @Override
    public ShujiiHoshumeisaiReportSource build() {
        return ReportEditorJoiner.from(new ShujiiHoshumeisaiReportSource()).join(editor).buildSource();
    }

}
