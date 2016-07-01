/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shujiiikenshoa4;

import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiiikensho1a4.ShujiiikenshoA4ReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 事務局用主治医意見書のBuilderクラスです。
 *
 * @reamsid_L DBE-0150-090 wangrenze
 */
public class ShujiiikenshoA4Builder implements IShujiiikenshoA4Builder {

    private final IShujiiikenshoA4Editor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IShujiiikenshoA4Editor}
     */
    public ShujiiikenshoA4Builder(IShujiiikenshoA4Editor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link ShujiiikenshoA4ReportSource}
     */
    @Override
    public ShujiiikenshoA4ReportSource build() {
        return ReportEditorJoiner.from(new ShujiiikenshoA4ReportSource()).join(editor).buildSource();
    }
}
