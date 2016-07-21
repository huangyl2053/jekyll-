/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.report.ninteichosahyogaikyotokki;

import jp.co.ndensan.reams.db.dbe.business.report.ninteichosahyogaikyotokki.GaikyotokkiA4Property;
import jp.co.ndensan.reams.db.dbe.business.report.ninteichosahyogaikyotokki.GaikyotokkiA4Report;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosahyogaikyotokki.GaikyotokkiA4Entity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ninteichosahyogaikyotokki.GaikyotokkiA4ReportSource;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 要介護認定調査票（概況特記）Printerクラスです。
 *
 * @reamsid_L DBE-0080-190 xuyannan
 */
public class GaikyotokkiA4PrintService {

    /**
     * 要介護認定調査票（概況特記）を印刷します。
     *
     * @param entity 要介護認定調査票（概況特記）パラメータクラス。
     * @return {@link GaikyotokkiA4Report}
     */
    public SourceDataCollection print(GaikyotokkiA4Entity entity) {
        GaikyotokkiA4Property property = new GaikyotokkiA4Property();
        return new Printer<GaikyotokkiA4ReportSource>().spool(property, new GaikyotokkiA4Report(entity));
    }
}
