/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shujiiikensho2a4;

import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiiikenshoa3.Shujiiikensho2A4ReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 主治医意見書A4Builderクラスです。
 *
 * @reamsid_L DBE-0150-390 lishengli
 */
class Shujiiikensho2A4Builder implements IShujiiikensho2A4Builder {

    private final IShujiiikensho2A4Editor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IShujiiikensho2A4Editor}
     */
    public Shujiiikensho2A4Builder(IShujiiikensho2A4Editor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link Shujiiikensho2A4ReportSource}
     */
    @Override
    public Shujiiikensho2A4ReportSource build() {
        return ReportEditorJoiner.from(new Shujiiikensho2A4ReportSource()).join(editor).buildSource();
    }

}
