/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.kogakukaigoservicehi;

import jp.co.ndensan.reams.db.dba.entity.report.kogakukaigoservicehi.KogakuKaigoServicehiShikyuShinseiShoJuryoIninHaraiyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 *
 * 介護保険高額介護（予防）サービス費支給（受領委任払）申請書のReportです。
 */
public class KogakuKaigoServicehiShikyuShinseiShoJuryoIninHaraiyoReport
        extends Report<KogakuKaigoServicehiShikyuShinseiShoJuryoIninHaraiyoReportSource> {

    private final KogakuKaigoServicehiShikyuShinseiShoJuryoIninHaraiyoItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item 介護保険高額介護（予防）サービス費支給（受領委任払）申請書のITEM
     * @return 介護保険高額介護（予防）サービス費支給（受領委任払）申請書のReport
     */
    public static KogakuKaigoServicehiShikyuShinseiShoJuryoIninHaraiyoReport createFrom(
            KogakuKaigoServicehiShikyuShinseiShoJuryoIninHaraiyoItem item) {

        return new KogakuKaigoServicehiShikyuShinseiShoJuryoIninHaraiyoReport(item);
    }

    /**
     * インスタンスを生成します。
     *
     * @param item 介護保険高額介護（予防）サービス費支給（受領委任払）申請書のITEM
     */
    protected KogakuKaigoServicehiShikyuShinseiShoJuryoIninHaraiyoReport(
            KogakuKaigoServicehiShikyuShinseiShoJuryoIninHaraiyoItem item) {

        this.item = item;
    }

    @Override
    public void writeBy(ReportSourceWriter<KogakuKaigoServicehiShikyuShinseiShoJuryoIninHaraiyoReportSource> reportSourceWriter) {
        IKogakuKaigoServicehiShikyuShinseiShoJuryoIninHaraiyoEditor editor
                = new KogakuKaigoServicehiShikyuShinseiShoJuryoIninHaraiyoItemEditor(item);
        IKogakuKaigoServicehiShikyuShinseiShoJuryoIninHaraiyoBuilder builder
                = new KogakuKaigoServicehiShikyuShinseiShoJuryoIninHaraiyoItemBuilder(editor);
        reportSourceWriter.writeLine(builder);
    }
}
