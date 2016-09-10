/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.report.shujiiikensho;

import jp.co.ndensan.reams.db.dbz.entity.report.shujiiikensho.ShujiiIkenshoSakuseiIraishoReportSource;

/**
 * 主治医意見書作成依頼書Builderクラスです。
 *
 * @reamsid_L DBE-0050-020 sunhaidi
 */
public class ShujiiIkenshoSakuseiIraishoBuilder implements IShujiiIkenshoSakuseiIraishoBuilder {

    private final IShujiiIkenshoSakuseiIraishoEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IShujiiIkenshoSakuseiIraishoEditor}
     */
    protected ShujiiIkenshoSakuseiIraishoBuilder(IShujiiIkenshoSakuseiIraishoEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link ShujiiIkenshoSakuseiIraishoItem}
     */
    @Override
    public ShujiiIkenshoSakuseiIraishoReportSource build() {
        return editor.edit(new ShujiiIkenshoSakuseiIraishoReportSource());
    }
}
