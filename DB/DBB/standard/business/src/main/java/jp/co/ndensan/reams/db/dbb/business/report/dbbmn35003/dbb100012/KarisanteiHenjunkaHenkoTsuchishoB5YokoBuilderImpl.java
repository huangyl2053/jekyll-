/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.dbbmn35003.dbb100012;

import jp.co.ndensan.reams.db.dbb.entity.report.dbbmn35003.dbb100012.KarisanteiHenjunkaHenkoTsuchishoB5YokoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 特別徴収平準化【B5横タイプ】Builderクラスです。
 */
class KarisanteiHenjunkaHenkoTsuchishoB5YokoBuilderImpl implements IKarisanteiHenjunkaHenkoTsuchishoB5YokoBuilder {

    private final IKarisanteiHenjunkaHenkoTsuchishoB5YokoEditor headerEditor;
    private final IKarisanteiHenjunkaHenkoTsuchishoB5YokoEditor hyojiBodyEditor;

    public KarisanteiHenjunkaHenkoTsuchishoB5YokoBuilderImpl(IKarisanteiHenjunkaHenkoTsuchishoB5YokoEditor headerEditor,
            IKarisanteiHenjunkaHenkoTsuchishoB5YokoEditor hyojiBodyEditor) {

        this.headerEditor = headerEditor;
        this.hyojiBodyEditor = hyojiBodyEditor;

    }

    @Override
    public KarisanteiHenjunkaHenkoTsuchishoB5YokoReportSource build() {
        return ReportEditorJoiner.from(new KarisanteiHenjunkaHenkoTsuchishoB5YokoReportSource()).join(headerEditor)
                .join(hyojiBodyEditor).buildSource();
    }

}
