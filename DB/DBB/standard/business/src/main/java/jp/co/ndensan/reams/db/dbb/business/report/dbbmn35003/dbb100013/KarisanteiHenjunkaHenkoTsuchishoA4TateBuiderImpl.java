/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.dbbmn35003.dbb100013;

import jp.co.ndensan.reams.db.dbb.entity.report.dbbmn35003.dbb100013.KarisanteiHenjunkaHenkoTsuchishoA4TateReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 特別徴収平準化【A4縦タイプ】Builderクラスです。
 */
class KarisanteiHenjunkaHenkoTsuchishoA4TateBuiderImpl implements IKarisanteiHenjunkaHenkoTsuchishoA4TateBuilder {

    private final IKarisanteiHenjunkaHenkoTsuchishoA4TateEditor headerEditor;
    private final IKarisanteiHenjunkaHenkoTsuchishoA4TateEditor hyojiBodyEditor;

    public KarisanteiHenjunkaHenkoTsuchishoA4TateBuiderImpl(IKarisanteiHenjunkaHenkoTsuchishoA4TateEditor headerEditor,
            IKarisanteiHenjunkaHenkoTsuchishoA4TateEditor hyojiBodyEditor) {
        this.headerEditor = headerEditor;
        this.hyojiBodyEditor = hyojiBodyEditor;

    }

    @Override
    public KarisanteiHenjunkaHenkoTsuchishoA4TateReportSource build() {
        return ReportEditorJoiner.from(new KarisanteiHenjunkaHenkoTsuchishoA4TateReportSource()).
                join(headerEditor).join(hyojiBodyEditor).buildSource();
    }
}
