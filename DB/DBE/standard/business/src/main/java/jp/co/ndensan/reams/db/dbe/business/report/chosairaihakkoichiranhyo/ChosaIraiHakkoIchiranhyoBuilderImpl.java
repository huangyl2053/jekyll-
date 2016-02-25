/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosairaihakkoichiranhyo;

import jp.co.ndensan.reams.db.dbe.entity.report.source.chosairaihakkoichiranhyo.ChosaIraiHakkoIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 認定調査依頼発行一覧表Builderクラスです。
 */
class ChosaIraiHakkoIchiranhyoBuilderImpl implements ChosaIraiHakkoIchiranhyoBuilder {

    private final ChosaIraiHakkoIchiranhyoHeaderEditor headerEditor;
    private final ChosaIraiHakkoIchiranhyoBodyEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param headerEditor {@link ChosaIraiHakkoIchiranhyoHeaderEditor}
     * @param hyojiIchiranEditor {@link ChosaIraiHakkoIchiranhyoBodyEditor}
     */
    public ChosaIraiHakkoIchiranhyoBuilderImpl(ChosaIraiHakkoIchiranhyoHeaderEditor headerEditor, ChosaIraiHakkoIchiranhyoBodyEditor bodyEditor) {
        this.headerEditor = headerEditor;
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link ChosaIraiHakkoIchiranhyoReportSource}
     */
    @Override
    public ChosaIraiHakkoIchiranhyoReportSource build() {
        return ReportEditorJoiner.from(new ChosaIraiHakkoIchiranhyoReportSource()).join(headerEditor).join(bodyEditor).buildSource();
    }
}
