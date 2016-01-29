/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dba.service.report.hihokenshashohakkoichiranhyo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.report.hihokenshashohakkoichiranhyo.HihokenshashoHakkoIchiranHyoItem;
import jp.co.ndensan.reams.db.dba.business.report.hihokenshashohakkoichiranhyo.HihokenshashoHakkoIchiranHyoProerty;
import jp.co.ndensan.reams.db.dba.business.report.hihokenshashohakkoichiranhyo.HihokenshashoHakkoIchiranHyoReport;
import jp.co.ndensan.reams.db.dba.entity.report.hihokenshashohakkoichiranhyo.HihokenshashoHakkoIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 *
 * 被保険者証発行一覧表Printクラスです。
 */
public class HihokenshashoHakkoIchiranHyoPrintService {
    
    /**
     * 被保険者証発行一覧表Printします。
     * @param items 被保険者証発行一覧表作成_帳票クラスパラメータ
     * @return 被保険者証発行一覧表作成_帳票
     */
    public SourceDataCollection print(List<HihokenshashoHakkoIchiranHyoItem> items) {
        HihokenshashoHakkoIchiranHyoProerty proerty = new HihokenshashoHakkoIchiranHyoProerty();
        return new Printer<HihokenshashoHakkoIchiranhyoReportSource>().spool(proerty, toReports(items));
    }
    
    private static List<HihokenshashoHakkoIchiranHyoReport> toReports(List<HihokenshashoHakkoIchiranHyoItem> items) {
        List<HihokenshashoHakkoIchiranHyoReport> list = new ArrayList<>();
        list.add(HihokenshashoHakkoIchiranHyoReport.createReport(items));
        return list;
    }
    
}
