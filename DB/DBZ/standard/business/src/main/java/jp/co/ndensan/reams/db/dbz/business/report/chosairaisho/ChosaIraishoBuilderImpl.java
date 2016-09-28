/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.report.chosairaisho;

import jp.co.ndensan.reams.db.dbz.entity.report.chosairaisho.ChosaIraishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 要介護認定調査依頼書Builderクラスです。
 *
 * @reamsid_L DBE-0010-020 lishengli
 */
class ChosaIraishoBuilderImpl implements IChosaIraishoBuilder {

    private final IChosaIraishoEditor headerEditor;

    /**
     * インスタンスを生成します。
     *
     * @param headerEditor {@link IChosaIraishoEditor}
     */
    public ChosaIraishoBuilderImpl(IChosaIraishoEditor headerEditor) {
        this.headerEditor = headerEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link ChosaIraishoReportSource}
     */
    @Override
    public ChosaIraishoReportSource build() {
        return ReportEditorJoiner.from(new ChosaIraishoReportSource()).join(headerEditor).buildSource();
    }
}
