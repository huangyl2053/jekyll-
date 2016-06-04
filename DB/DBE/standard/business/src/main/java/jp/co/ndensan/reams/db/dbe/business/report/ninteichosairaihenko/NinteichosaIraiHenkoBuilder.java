/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ninteichosairaihenko;

import jp.co.ndensan.reams.db.dbe.entity.report.source.ninteichosairaihenko.NinteichosaIraiHenkoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 認定調査依頼先変更者一覧表Builderクラスです。
 *
 * @reamsid_L DBE-1390-120 dongyabin
 */
class NinteichosaIraiHenkoBuilder implements INinteichosaIraiHenkoBuilder {

    private final INinteichosaIraiHenkoEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link INinteichosaIraiHenkoEditor}
     */
    public NinteichosaIraiHenkoBuilder(INinteichosaIraiHenkoEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link NinteichosaIraiHenkoReportSource}
     */
    @Override
    public NinteichosaIraiHenkoReportSource build() {
        return ReportEditorJoiner.from(new NinteichosaIraiHenkoReportSource()).join(editor).buildSource();
    }
}
