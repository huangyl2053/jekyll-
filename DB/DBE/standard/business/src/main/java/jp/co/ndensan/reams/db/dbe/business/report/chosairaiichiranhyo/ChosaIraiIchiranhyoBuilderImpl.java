/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosairaiichiranhyo;

import jp.co.ndensan.reams.db.dbe.entity.report.source.chosairaiichiranhyo.ChosaIraiIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 *
 * 認定調査依頼一覧表Builderクラスです。
 */
class ChosaIraiIchiranhyoBuilderImpl implements IChosaIraiIchiranhyoBuilder {

    private final IChosaIraiIchiranhyoEditor headerEditor;
    private final IChosaIraiIchiranhyoEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param headerEditor {@link ChosaIraiIchiranhyoEditor}
     * @param bodyEditor {@link ChosaIraiIchiranhyoEditor}
     */
    public ChosaIraiIchiranhyoBuilderImpl(IChosaIraiIchiranhyoEditor headerEditor, IChosaIraiIchiranhyoEditor bodyEditor) {
        this.headerEditor = headerEditor;
        this.bodyEditor = bodyEditor;
    }

    @Override
    public ChosaIraiIchiranhyoReportSource build() {
        return ReportEditorJoiner.from(new ChosaIraiIchiranhyoReportSource()).join(headerEditor).join(bodyEditor).buildSource();
    }
}
