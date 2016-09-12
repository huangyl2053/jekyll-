/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shujiiikenshomiirai;

import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiiikenshomiirai.ShujiiIkenshoMiIraiReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 主治医意見書依頼未処理者一覧表Builderクラスです。
 *
 * @reamsid_L DBE-1390-130 suguangjun
 */
class ShujiiIkenshoMiIraiBuilder implements IShujiiIkenshoMiIraiBuilder {

    private final IShujiiIkenshoMiIraiEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IShujiiIkenshoMiIraiEditor}
     */
    public ShujiiIkenshoMiIraiBuilder(IShujiiIkenshoMiIraiEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link ShujiiIkenshoMiIraiReportSource}
     */
    @Override
    public ShujiiIkenshoMiIraiReportSource build() {
        return ReportEditorJoiner.from(new ShujiiIkenshoMiIraiReportSource()).join(editor).buildSource();
    }
}
