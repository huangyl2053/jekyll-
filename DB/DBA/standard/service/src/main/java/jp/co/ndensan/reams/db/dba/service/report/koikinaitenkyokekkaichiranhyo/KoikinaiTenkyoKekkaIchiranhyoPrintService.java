/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.report.koikinaitenkyokekkaichiranhyo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.report.koikinaitenkyokekkaichiranhyo.KoikinaiTenkyoKekkaIchiranhyoProperty;
import jp.co.ndensan.reams.db.dba.business.report.koikinaitenkyokekkaichiranhyo.KoikinaiTenkyoKekkaIchiranhyoReport;
import jp.co.ndensan.reams.db.dba.business.report.koikinaitenkyokekkaichiranhyo.KoikinaiTenkyoKekkaIchiranhyoReportJoho;
import jp.co.ndensan.reams.db.dba.entity.report.koikinaitenkyokekkaichiranhyo.KoikinaiTenkyoKekkaIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 広域内転居結果一覧表Printerクラスです。
 */
public class KoikinaiTenkyoKekkaIchiranhyoPrintService {

    /**
     * 広域内転居結果一覧表を印刷します。
     *
     * @param reportJoho 広域内転居結果一覧表作成_帳票パラメータクラス。
     * @return {@link KoikinaiTenkyoKekkaIchiranhyoReport}
     */
    public SourceDataCollection print(KoikinaiTenkyoKekkaIchiranhyoReportJoho reportJoho) {
        KoikinaiTenkyoKekkaIchiranhyoProperty property = new KoikinaiTenkyoKekkaIchiranhyoProperty();
        return new Printer<KoikinaiTenkyoKekkaIchiranhyoReportSource>().spool(property, toReports(reportJoho));
    }

    private static List<KoikinaiTenkyoKekkaIchiranhyoReport> toReports(KoikinaiTenkyoKekkaIchiranhyoReportJoho reportJoho) {
        List<KoikinaiTenkyoKekkaIchiranhyoReport> list = new ArrayList<>();
        list.add(KoikinaiTenkyoKekkaIchiranhyoReport.createFrom(
                reportJoho.getHeadItem(),
                reportJoho.getBodyItemList()));
        return list;
    }
}
