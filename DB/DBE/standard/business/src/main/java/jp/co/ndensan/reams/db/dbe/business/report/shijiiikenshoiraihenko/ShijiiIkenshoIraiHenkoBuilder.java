/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shijiiikenshoiraihenko;

import jp.co.ndensan.reams.db.dbe.entity.report.source.shijiiikenshoiraihenko.ShijiiIkenshoIraiHenkoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 主治医意見書作成依頼変更者一覧表Builderクラスです。
 *
 * @reamsid_L DBE-1390-140 suguangjun
 */
class ShijiiIkenshoIraiHenkoBuilder implements IShijiiIkenshoIraiHenkoBuilder {

    private final IShijiiIkenshoIraiHenkoEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IShijiiIkenshoIraiHenkoEditor}
     */
    public ShijiiIkenshoIraiHenkoBuilder(IShijiiIkenshoIraiHenkoEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link ShijiiIkenshoIraiHenkoReportSource}
     */
    @Override
    public ShijiiIkenshoIraiHenkoReportSource build() {
        return ReportEditorJoiner.from(new ShijiiIkenshoIraiHenkoReportSource()).join(editor).buildSource();
    }
}
