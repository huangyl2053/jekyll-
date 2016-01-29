/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.report.koikinaijushochitokureishaichiranhyo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.report.koikinaijushochitokureishaichiranhyo.KoikinaiJushochitokureishaIchiranhyoProperty;
import jp.co.ndensan.reams.db.dba.business.report.koikinaijushochitokureishaichiranhyo.KoikinaiJushochitokureishaIchiranhyoReport;
import jp.co.ndensan.reams.db.dba.business.report.koikinaijushochitokureishaichiranhyo.KoikinaiJushochitokureishaIchiranhyoReportJoho;
import jp.co.ndensan.reams.db.dba.entity.report.koikinaijushochitokureishaichiranhyo.KoikinaiJushochitokureishaIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 広域内住所地特例者一覧表Printerクラスです。
 */
public class KoikinaiJushochitokureishaIchiranhyoPrintService {

    /**
     * 広域内住所地特例者一覧表を印刷します。
     *
     * @param reportJoho 広域内住所地特例者一覧表作成_帳票パラメータクラス。
     * @return {@link KoikinaiJushochitokureishaIchiranhyoReport}
     */
    public SourceDataCollection print(KoikinaiJushochitokureishaIchiranhyoReportJoho reportJoho) {
        KoikinaiJushochitokureishaIchiranhyoProperty property = new KoikinaiJushochitokureishaIchiranhyoProperty();
        return new Printer<KoikinaiJushochitokureishaIchiranhyoReportSource>().spool(property, toReports(reportJoho));
    }

    private static List<KoikinaiJushochitokureishaIchiranhyoReport> toReports(KoikinaiJushochitokureishaIchiranhyoReportJoho reportJoho) {
        List<KoikinaiJushochitokureishaIchiranhyoReport> list = new ArrayList<>();
        list.add(KoikinaiJushochitokureishaIchiranhyoReport.createFrom(
                reportJoho.getHeadItem(),
                reportJoho.getBodyItemList()));
        return list;
    }
}
