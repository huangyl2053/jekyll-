/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.dbbmn35003.dbb100013;

import jp.co.ndensan.reams.db.dbb.entity.report.dbbmn35003.dbb100013.KarisanteiHenjunkaHenkoTsuchishoA4TateReportSource;


/**
 * 特別徴収平準化【A4縦タイプ】ヘッダEditorです。
 */
class KarisanteiHenjunkaHenkoTsuchishoA4TateHeaderEditor implements IKarisanteiHenjunkaHenkoTsuchishoA4TateEditor {

    private KarisanteiHenjunkaHenkoTsuchishoA4TateItem item;

    public KarisanteiHenjunkaHenkoTsuchishoA4TateHeaderEditor(KarisanteiHenjunkaHenkoTsuchishoA4TateItem item) {
        this.item = item;

    }

    @Override
    public KarisanteiHenjunkaHenkoTsuchishoA4TateReportSource edit(KarisanteiHenjunkaHenkoTsuchishoA4TateReportSource source) {
        return editHeader(source);
    }

    private KarisanteiHenjunkaHenkoTsuchishoA4TateReportSource editHeader(KarisanteiHenjunkaHenkoTsuchishoA4TateReportSource source) {
        return source;
    }

}
