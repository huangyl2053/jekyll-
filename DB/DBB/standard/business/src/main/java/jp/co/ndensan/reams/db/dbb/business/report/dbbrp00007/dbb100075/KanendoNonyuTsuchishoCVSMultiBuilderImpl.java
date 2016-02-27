/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.dbbrp00007.dbb100075;

import jp.co.ndensan.reams.db.dbb.entity.report.dbbrp00007.dbb100075.KanendoNonyuTsuchishoCVSMultiReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 保険料納入通知書（本算定過年度）【コンビニマルチ収納タイプ通知書】Builderクラスです。
 */
class KanendoNonyuTsuchishoCVSMultiBuilderImpl implements IKanendoNonyuTsuchishoCVSMultiBuilder {

    private final IKanendoNonyuTsuchishoCVSMultiEditor headerEditor;
    private final IKanendoNonyuTsuchishoCVSMultiEditor hyojiBodyEditor;

    public KanendoNonyuTsuchishoCVSMultiBuilderImpl(IKanendoNonyuTsuchishoCVSMultiEditor headerEditor,
            IKanendoNonyuTsuchishoCVSMultiEditor hyojiBodyEditor) {
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
    public KanendoNonyuTsuchishoCVSMultiReportSource build() {
        return ReportEditorJoiner.from(new KanendoNonyuTsuchishoCVSMultiReportSource()).join(headerEditor).join(hyojiBodyEditor).buildSource();
    }

}
