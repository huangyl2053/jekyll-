/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.report.kaigohokenshindanmeireisho;

import jp.co.ndensan.reams.db.dbz.entity.report.source.shujiiikenshoteishutsuiraisho.ShujiiIkenshoTeishutsuIraishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 介護保険指定医依頼兼主治医意見書提出依頼書Builderクラスです。
 *
 * @reamsid_L DBE-0080-080 duanzhanli
 */
class ShujiiIkenshoTeishutsuIraishoBuilderImpl implements IShujiiIkenshoTeishutsuIraishoBuilder {

    private final ShujiiIkenshoTeishutsuIraishoEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param Editor {@link ShujiiIkenshoTeishutsuIraishoEditor}
     */
    public ShujiiIkenshoTeishutsuIraishoBuilderImpl(ShujiiIkenshoTeishutsuIraishoEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link ShujiiIkenshoTeishutsuIraishoReportSource}
     */
    @Override
    public ShujiiIkenshoTeishutsuIraishoReportSource build() {
        return ReportEditorJoiner.from(new ShujiiIkenshoTeishutsuIraishoReportSource()).join(editor).buildSource();
    }
}
