/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shujiiikensho1a4;

import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiiikenshoa3.Shujiiikensho1A4ReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 主治医意見書A4Builderクラスです。
 *
 * @reamsid_L DBE-0150-380 lishengli
 */
class Shujiiikensho1A4Builder implements IShujiiikensho1A4Builder {

    private final IShujiiikensho1A4Editor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IShujiiikensho1A4Editor}
     */
    public Shujiiikensho1A4Builder(IShujiiikensho1A4Editor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link Shujiiikensho1A4ReportSource}
     */
    @Override
    public Shujiiikensho1A4ReportSource build() {
        return ReportEditorJoiner.from(new Shujiiikensho1A4ReportSource()).join(editor).buildSource();
    }

}
