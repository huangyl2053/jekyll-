/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.report.shinsakaishukeihyo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaishukeihyo.Shinsakaishukeihyo;
import jp.co.ndensan.reams.db.dbe.business.report.shinsakaishukeihyo.ShinsakaishukeihyoProperty;
import jp.co.ndensan.reams.db.dbe.business.report.shinsakaishukeihyo.ShinsakaishukeihyoReport;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaishukeihyo.ShinsakaishukeihyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 審査判定の変更状況Printクラスです。
 *
 * @reamsid_L DBE-1450-060 dongyabin
 */
public class ShinsakaishukeihyoPrintService {

    /**
     * 審査判定の変更状況Printします。
     *
     * @param reportJoho 審査判定の変更状況作成_帳票クラスパラメータ
     * @return 審査判定の変更状況作成_帳票
     */
    public SourceDataCollection print(Shinsakaishukeihyo reportJoho) {
        ShinsakaishukeihyoProperty property = new ShinsakaishukeihyoProperty();
        return new Printer<ShinsakaishukeihyoReportSource>().spool(property, toReports(reportJoho));
    }

    private static List<ShinsakaishukeihyoReport> toReports(Shinsakaishukeihyo reportJoho) {
        List<ShinsakaishukeihyoReport> list = new ArrayList<>();
        list.add(new ShinsakaishukeihyoReport(reportJoho));
        return list;

    }

}
