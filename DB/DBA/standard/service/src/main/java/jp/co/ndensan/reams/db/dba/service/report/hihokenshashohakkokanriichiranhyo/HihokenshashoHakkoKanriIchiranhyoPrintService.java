/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.report.hihokenshashohakkokanriichiranhyo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.report.hihokenshashohakkokanriichiranhyo.HihokenshashoHakkoKanriIchiranhyoProperty;
import jp.co.ndensan.reams.db.dba.business.report.hihokenshashohakkokanriichiranhyo.HihokenshashoHakkoKanriIchiranhyoReport;
import jp.co.ndensan.reams.db.dba.business.report.hihokenshashohakkokanriichiranhyo.HihokenshashoHakkoKanriIchiranhyoReportJoho;
import jp.co.ndensan.reams.db.dba.entity.report.source.hihokenshashohakkokanriichiranhyo.HihokenshashoHakkoKanriIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 被保険者証発行管理一覧表PrintServiceです。
 */
public class HihokenshashoHakkoKanriIchiranhyoPrintService {

    /**
     * 被保険者証発行管理一覧表を印刷します。
     *
     * @param ichiranReportJoho 被保険者証発行管理一覧表_帳票クラスパラメータクラス
     * @return {@link SourceDataCollection}
     */
    public SourceDataCollection print(HihokenshashoHakkoKanriIchiranhyoReportJoho ichiranReportJoho) {
        HihokenshashoHakkoKanriIchiranhyoProperty property = new HihokenshashoHakkoKanriIchiranhyoProperty();
        return new Printer<HihokenshashoHakkoKanriIchiranhyoReportSource>().spool(property, toReports(ichiranReportJoho));
    }

    private static List<HihokenshashoHakkoKanriIchiranhyoReport> toReports(HihokenshashoHakkoKanriIchiranhyoReportJoho reportJoho) {
        List<HihokenshashoHakkoKanriIchiranhyoReport> list = new ArrayList<>();
        list.add(HihokenshashoHakkoKanriIchiranhyoReport.createFrom(
                reportJoho.getHeadItem(),
                reportJoho.getBodyItemList()));
        return list;
    }
}
