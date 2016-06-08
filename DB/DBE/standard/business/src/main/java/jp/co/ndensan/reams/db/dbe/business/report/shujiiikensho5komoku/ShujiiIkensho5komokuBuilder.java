/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shujiiikensho5komoku;

import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiiikensho5komoku.ShujiiIkensho5komokuReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 主治医意見書5項目確認一覧表Builderクラスです。
 *
 * @reamsid_L DBE-1390-170 suguangjun
 */
class ShujiiIkensho5komokuBuilder implements IShujiiIkensho5komokuBuilder {

    private final IShujiiIkensho5komokuEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IShujiiIkensho5komokuEditor}
     */
    public ShujiiIkensho5komokuBuilder(IShujiiIkensho5komokuEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link ShujiiIkensho5komokuReportSource}
     */
    @Override
    public ShujiiIkensho5komokuReportSource build() {
        return ReportEditorJoiner.from(new ShujiiIkensho5komokuReportSource()).join(editor).buildSource();
    }
}
