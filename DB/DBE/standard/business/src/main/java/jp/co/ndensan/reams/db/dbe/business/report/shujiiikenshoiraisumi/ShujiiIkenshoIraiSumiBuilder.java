/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shujiiikenshoiraisumi;

import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiiikenshoiraisumi.ShujiiIkenshoIraiSumiReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 主治医意見書依頼済み一覧表Builderクラスです。
 *
 * @reamsid_L DBE-1390-160 suguangjun
 */
class ShujiiIkenshoIraiSumiBuilder implements IShujiiIkenshoIraiSumiBuilder {

    private final IShujiiIkenshoIraiSumiEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IShujiiIkenshoIraiSumiEditor}
     */
    public ShujiiIkenshoIraiSumiBuilder(IShujiiIkenshoIraiSumiEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link ShujiiIkenshoIraiSumiReportSource}
     */
    @Override
    public ShujiiIkenshoIraiSumiReportSource build() {
        return ReportEditorJoiner.from(new ShujiiIkenshoIraiSumiReportSource()).join(editor).buildSource();
    }
}
