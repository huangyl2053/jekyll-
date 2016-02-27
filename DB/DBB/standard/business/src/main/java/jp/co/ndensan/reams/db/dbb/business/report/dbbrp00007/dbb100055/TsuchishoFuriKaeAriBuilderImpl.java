/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.dbbrp00007.dbb100055;

import jp.co.ndensan.reams.db.dbb.entity.report.dbbrp00007.dbb100055.TsuchishoFuriKaeAriReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 口振依頼あり通知書Builderクラスです。
 */
class TsuchishoFuriKaeAriBuilderImpl implements ITsuchishoFuriKaeAriBuilder {

    private final ITsuchishoFuriKaeAriEditor headerEditor;
    private final ITsuchishoFuriKaeAriEditor hyojiBodyEditor;

    public TsuchishoFuriKaeAriBuilderImpl(ITsuchishoFuriKaeAriEditor headerEditor, ITsuchishoFuriKaeAriEditor hyojiBodyEditor) {
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
    public TsuchishoFuriKaeAriReportSource build() {
        return ReportEditorJoiner.from(new TsuchishoFuriKaeAriReportSource()).join(headerEditor).join(hyojiBodyEditor).buildSource();
    }

}
