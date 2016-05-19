/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.report.shinsakaishukeihyoshinsei;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaishukeihyoshinsei.ShinsakaiShukeihyoShinsei;
import jp.co.ndensan.reams.db.dbe.business.report.shinsakaishukeihyoshinsei.ShinsakaishukeihyoShinseiProperty;
import jp.co.ndensan.reams.db.dbe.business.report.shinsakaishukeihyoshinsei.ShinsakaishukeihyoShinseiReport;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaishukeihyoshinsei.ShinsakaiShukeihyoShinseiReportSource;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 介護認定審査会集計表（申請区分別）Printクラスです。
 *
 * @reamsid_L DBE-1450-080 dongyabin
 */
public class ShinsakaishukeihyoShinseiPrintService {

    /**
     * 介護認定審査会集計表（申請区分別）Printします。
     *
     * @param reportJoho 介護認定審査会集計表（申請区分別）作成_帳票クラスパラメータ
     * @return 介護認定審査会集計表（申請区分別）作成_帳票
     */
    public SourceDataCollection print(ShinsakaiShukeihyoShinsei reportJoho) {
        ShinsakaishukeihyoShinseiProperty property = new ShinsakaishukeihyoShinseiProperty();
        return new Printer<ShinsakaiShukeihyoShinseiReportSource>().spool(property, toReports(reportJoho));
    }

    private static List<ShinsakaishukeihyoShinseiReport> toReports(ShinsakaiShukeihyoShinsei reportJoho) {
        List<ShinsakaishukeihyoShinseiReport> list = new ArrayList<>();
        list.add(new ShinsakaishukeihyoShinseiReport(reportJoho));
        return list;

    }

}
