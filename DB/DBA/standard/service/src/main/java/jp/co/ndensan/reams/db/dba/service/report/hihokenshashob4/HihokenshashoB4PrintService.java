/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dba.service.report.hihokenshashob4;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.report.hihokenshashob4.HihokenshashoB4Item;
import jp.co.ndensan.reams.db.dba.business.report.hihokenshashob4.HihokenshashoB4Proerty;
import jp.co.ndensan.reams.db.dba.business.report.hihokenshashob4.HihokenshashoB4Report;
import jp.co.ndensan.reams.db.dba.entity.report.hihokenshashob4.HihokenshashoB4ReportSource;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 *
 * 被保険者証発行一覧表Printクラスです。
 */
public class HihokenshashoB4PrintService {
    
    /**
     * 被保険者証発行一覧表Printします。
     * @param items 被保険者証発行一覧表作成_帳票クラスパラメータ
     * @return 被保険者証発行一覧表作成_帳票
     */
    public SourceDataCollection print(List<HihokenshashoB4Item> items) {
        HihokenshashoB4Proerty proerty = new HihokenshashoB4Proerty();
        return new Printer<HihokenshashoB4ReportSource>().spool(proerty, toReports(items));
    }
    
    private static List<HihokenshashoB4Report> toReports(List<HihokenshashoB4Item> items) {
        List<HihokenshashoB4Report> list = new ArrayList<>();
        list.add(HihokenshashoB4Report.createReport(items));
        return list;
    }
    
}
