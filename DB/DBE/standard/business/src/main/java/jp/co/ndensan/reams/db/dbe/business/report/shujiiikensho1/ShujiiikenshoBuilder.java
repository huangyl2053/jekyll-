/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shujiiikensho1;

import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiiikensho1.ShujiiikenshoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 主治医意見書Builderクラスです。
 *
 * @reamsid_L DBE-0230-070 lizhuoxuan
 */
class ShujiiikenshoBuilder implements IShujiiikenshoBuilder {

    private final IShujiiikenshoEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IShujiiikenshoEditor}
     */
    public ShujiiikenshoBuilder(IShujiiikenshoEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link ShujiiikenshoReportSource}
     */
    @Override
    public ShujiiikenshoReportSource build() {
        return ReportEditorJoiner.from(new ShujiiikenshoReportSource()).join(editor).buildSource();
    }

}
