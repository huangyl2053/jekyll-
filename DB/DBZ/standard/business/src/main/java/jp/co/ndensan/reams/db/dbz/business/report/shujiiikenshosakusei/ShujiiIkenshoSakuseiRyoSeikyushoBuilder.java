/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.report.shujiiikenshosakusei;

import jp.co.ndensan.reams.db.dbz.entity.report.shujiiikenshosakusei.ShujiiIkenshoSakuseiRyoSeikyushoReportSource;

/**
 *
 * 主治医意見書作成料請求書Builderクラスです。
 *
 * @reamsid_L DBE-0050-040 sunhaidi
 */
public class ShujiiIkenshoSakuseiRyoSeikyushoBuilder implements IShujiiIkenshoSakuseiRyoSeikyushoBuilder {

    private final IShujiiIkenshoSakuseiRyoSeikyushoEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IShujiiIkenshoSakuseiRyoSeikyushoEditor}
     */
    protected ShujiiIkenshoSakuseiRyoSeikyushoBuilder(IShujiiIkenshoSakuseiRyoSeikyushoEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link ShujiiIkenshoSakuseiRyoSeikyushoReportSource}
     */
    @Override
    public ShujiiIkenshoSakuseiRyoSeikyushoReportSource build() {
        return editor.edit(new ShujiiIkenshoSakuseiRyoSeikyushoReportSource());
    }
}
