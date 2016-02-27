/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.dbbmn35003.dbb100011;

import jp.co.ndensan.reams.db.dbb.entity.report.dbbmn35003.dbb100011.KarisanteiHenkoTsuchishoA4TateReportSource;


/**
 * 仮算定額変更【A4縦タイプ】Builderクラスです。
 */
class KarisanteiHenkoTsuchishoA4TateHeaderEditor implements IKarisanteiHenkoTsuchishoA4TateEditor {

    private final KarisanteiHenkoTsuchishoA4TateItem item;

    public KarisanteiHenkoTsuchishoA4TateHeaderEditor(KarisanteiHenkoTsuchishoA4TateItem item) {
        this.item = item;
    }

    @Override
    public KarisanteiHenkoTsuchishoA4TateReportSource edit(KarisanteiHenkoTsuchishoA4TateReportSource source) {
        return headerEdit(source);
    }

    private KarisanteiHenkoTsuchishoA4TateReportSource headerEdit(KarisanteiHenkoTsuchishoA4TateReportSource source) {
        source.bunshoNo = item.getBunshoNo();
        return source;
    }

}
