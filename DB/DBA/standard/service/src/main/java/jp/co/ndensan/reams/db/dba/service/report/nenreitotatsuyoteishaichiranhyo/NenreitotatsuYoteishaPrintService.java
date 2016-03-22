/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.report.nenreitotatsuyoteishaichiranhyo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.report.nenreitotatsuyoteishaichiranhyo.NenreitotatsuYoteishaIchiranhyoProperty;
import jp.co.ndensan.reams.db.dba.business.report.nenreitotatsuyoteishaichiranhyo.NenreitotatsuYoteishaIchiranhyoReport;
import jp.co.ndensan.reams.db.dba.business.report.nenreitotatsuyoteishaichiranhyo.NenreitotatsuYoteishaIchiranhyoReportJoho;
import jp.co.ndensan.reams.db.dba.entity.report.nenreitotatsuyoteishaichiranhyo.NenreitotatsuYoteishaIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 *
 * 年齢到達予定者一覧表Printクラスです。
 */
public class NenreitotatsuYoteishaPrintService {

    /**
     * 年齢到達予定者一覧表Printします。
     *
     * @param reportJoho 年齢到達予定者一覧表作成_帳票クラスパラメータ
     * @return 年齢到達予定者一覧表作成_帳票
     */
    public SourceDataCollection print(NenreitotatsuYoteishaIchiranhyoReportJoho reportJoho) {
        NenreitotatsuYoteishaIchiranhyoProperty property = new NenreitotatsuYoteishaIchiranhyoProperty();
        return new Printer<NenreitotatsuYoteishaIchiranhyoReportSource>().spool(property, toReports(reportJoho));
    }

    private static List<NenreitotatsuYoteishaIchiranhyoReport> toReports(NenreitotatsuYoteishaIchiranhyoReportJoho reportJoho) {
        List<NenreitotatsuYoteishaIchiranhyoReport> list = new ArrayList<>();
        list.add(NenreitotatsuYoteishaIchiranhyoReport.createFrom(reportJoho.getHeadItem(), reportJoho.getBodyItemList()));

        return list;

    }
}
