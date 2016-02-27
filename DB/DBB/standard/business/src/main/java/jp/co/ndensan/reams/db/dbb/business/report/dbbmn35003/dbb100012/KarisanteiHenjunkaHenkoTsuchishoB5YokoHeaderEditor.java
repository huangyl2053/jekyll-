/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.dbbmn35003.dbb100012;

import jp.co.ndensan.reams.db.dbb.entity.report.dbbmn35003.dbb100012.KarisanteiHenjunkaHenkoTsuchishoB5YokoReportSource;

/**
 * 特別徴収平準化【B5横タイプ】Builderクラスです。
 */
class KarisanteiHenjunkaHenkoTsuchishoB5YokoHeaderEditor implements IKarisanteiHenjunkaHenkoTsuchishoB5YokoEditor {

    private final KarisanteiHenjunkaHenkoTsuchishoB5YokoItem item;

    public KarisanteiHenjunkaHenkoTsuchishoB5YokoHeaderEditor(KarisanteiHenjunkaHenkoTsuchishoB5YokoItem item) {

        this.item = item;

    }

    @Override
    public KarisanteiHenjunkaHenkoTsuchishoB5YokoReportSource edit(KarisanteiHenjunkaHenkoTsuchishoB5YokoReportSource source) {
        return editHeader(source);
    }

    private KarisanteiHenjunkaHenkoTsuchishoB5YokoReportSource editHeader(KarisanteiHenjunkaHenkoTsuchishoB5YokoReportSource source) {
        source.bunshoNo = item.getBunshoNo();
        return source;
    }

}
