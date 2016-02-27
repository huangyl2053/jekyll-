/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.dbbmn35003.dbb100010;

import jp.co.ndensan.reams.db.dbb.entity.report.dbbmn35003.dbb100010.KarisanteiHenkoTsuchishoB5YokoReportSource;


/**
 * 仮算定額変更【B5横タイプ】ヘッダEditorです。
 */
class KarisanteiHenkoTsuchishoB5YokoHeaderEditor implements IKarisanteiHenkoTsuchishoB5YokoEditor {

    private final KarisanteiHenkoTsuchishoB5YokoItem item;

    public KarisanteiHenkoTsuchishoB5YokoHeaderEditor(KarisanteiHenkoTsuchishoB5YokoItem item) {
        this.item = item;
    }

    @Override
    public KarisanteiHenkoTsuchishoB5YokoReportSource edit(KarisanteiHenkoTsuchishoB5YokoReportSource source) {
        return editHeader(source);
    }

    private KarisanteiHenkoTsuchishoB5YokoReportSource editHeader(KarisanteiHenkoTsuchishoB5YokoReportSource source) {
        source.bunshoNo = item.getBunshoNo();
        return source;
    }

}
