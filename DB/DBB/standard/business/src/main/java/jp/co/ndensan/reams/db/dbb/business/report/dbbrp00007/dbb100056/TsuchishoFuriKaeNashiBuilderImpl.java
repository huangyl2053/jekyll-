/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.dbbrp00007.dbb100056;

import jp.co.ndensan.reams.db.dbb.entity.report.dbbrp00007.dbb100056.TsuchishoFuriKaeNashiReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 口振依頼なし通知書Builderクラスです。
 */
class TsuchishoFuriKaeNashiBuilderImpl implements ITsuchishoFuriKaeNashiBuilder {

    private final ITsuchishoFuriKaeNashiEditor headerEditor;
    private final ITsuchishoFuriKaeNashiEditor hyojiBodyEditor;

    public TsuchishoFuriKaeNashiBuilderImpl(ITsuchishoFuriKaeNashiEditor headerEditor, ITsuchishoFuriKaeNashiEditor hyojiBodyEditor) {
        this.headerEditor = headerEditor;
        this.hyojiBodyEditor = hyojiBodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link     public KarisanteiHenkoTsuchishoB5YokoReportSource build() {
     * }
     */
    @Override
    public TsuchishoFuriKaeNashiReportSource build() {
        return ReportEditorJoiner.from(new TsuchishoFuriKaeNashiReportSource()).join(headerEditor).join(hyojiBodyEditor).buildSource();
    }

}
