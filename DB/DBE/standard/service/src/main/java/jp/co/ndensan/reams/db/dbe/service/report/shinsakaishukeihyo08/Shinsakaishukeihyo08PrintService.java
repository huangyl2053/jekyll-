/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.report.shinsakaishukeihyo08;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaishukeihyo08.ShinsakaiShukeihyo08;
import jp.co.ndensan.reams.db.dbe.business.report.shinsakaishukeihyo08.Shinsakaishukeihyo08Property;
import jp.co.ndensan.reams.db.dbe.business.report.shinsakaishukeihyo08.Shinsakaishukeihyo08Report;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaishukeihyo08.ShinsakaiShukeihyo08ReportSource;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 介護認定審査会集計表（申請区分別）Printクラスです。
 *
 * @reamsid_L DBE-1450-080 dongyabin
 */
public class Shinsakaishukeihyo08PrintService {

    /**
     * 介護認定審査会集計表（申請区分別）Printします。
     *
     * @param reportJoho 介護認定審査会集計表（申請区分別）作成_帳票クラスパラメータ
     * @return 介護認定審査会集計表（申請区分別）作成_帳票
     */
    public SourceDataCollection print(ShinsakaiShukeihyo08 reportJoho) {
        Shinsakaishukeihyo08Property property = new Shinsakaishukeihyo08Property();
        return new Printer<ShinsakaiShukeihyo08ReportSource>().spool(property, toReports(reportJoho));
    }

    private static List<Shinsakaishukeihyo08Report> toReports(ShinsakaiShukeihyo08 reportJoho) {
        List<Shinsakaishukeihyo08Report> list = new ArrayList<>();
        list.add(new Shinsakaishukeihyo08Report(reportJoho));
        return list;

    }

}
