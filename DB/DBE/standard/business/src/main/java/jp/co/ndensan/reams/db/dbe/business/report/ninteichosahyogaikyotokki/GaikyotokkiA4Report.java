/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ninteichosahyogaikyotokki;

import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyogaikyotokki.GaikyotokkiA4Business;
import jp.co.ndensan.reams.db.dbe.entity.report.ninteichosahyogaikyotokki.GaikyotokkiA4ReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 要介護認定調査票（概況特記）のReportです。
 *
 * @reamsid_L DBE-0080-190 xuyannan
 */
public class GaikyotokkiA4Report extends Report<GaikyotokkiA4ReportSource> {

    private final GaikyotokkiA4Business business;

    /**
     * インスタンスを生成します。
     *
     * @param business 要介護認定調査票（概況特記）のbusiness
     */
    public GaikyotokkiA4Report(GaikyotokkiA4Business business) {
        this.business = business;
    }

    /**
     * 要介護認定調査票（概況特記）を生成します。
     *
     * @param reportSourceWriter 帳票Writer
     */
    @Override
    public void writeBy(ReportSourceWriter<GaikyotokkiA4ReportSource> reportSourceWriter) {
        IGaikyotokkiA4Editor editor = new GaikyotokkiA4EditorImpl(business);
        IGaikyotokkiA4Builder builder = new GaikyotokkiA4BuilderImpl(editor);
        reportSourceWriter.writeLine(builder);
    }
}
