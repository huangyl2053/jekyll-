/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shujiiikenshoa3;

import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiiikenshoa3.ShujiiikenshoA3ReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 主治医意見書A3Builderクラスです。
 *
 * @reamsid_L DBE-0150-240 lishengli
 */
class ShujiiikenshoA3Builder implements IShujiiikenshoA3Builder {

    private final IShujiiikenshoA3Editor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IShujiiikenshoA3Editor}
     */
    public ShujiiikenshoA3Builder(IShujiiikenshoA3Editor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link ShujiiikenshoA3ReportSource}
     */
    @Override
    public ShujiiikenshoA3ReportSource build() {
        return ReportEditorJoiner.from(new ShujiiikenshoA3ReportSource()).join(editor).buildSource();
    }

}
