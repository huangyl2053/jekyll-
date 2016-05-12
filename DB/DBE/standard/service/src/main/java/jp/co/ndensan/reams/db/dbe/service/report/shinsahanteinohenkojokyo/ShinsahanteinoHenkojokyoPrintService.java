/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.report.shinsahanteinohenkojokyo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shinsahanteinohenkojokyo.ShinsahanteinoHenkojokyo;
import jp.co.ndensan.reams.db.dbe.business.report.shinsahanteinohenkojokyo.ShinsahanteinoHenkojokyoProperty;
import jp.co.ndensan.reams.db.dbe.business.report.shinsahanteinohenkojokyo.ShinsahanteinoHenkojokyoReport;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsahanteinohenkojokyo.ShinsahanteinoHenkojokyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 審査判定の変更状況Printクラスです。
 *
 * @reamsid_L DBE-1450-060 dongyabin
 */
public class ShinsahanteinoHenkojokyoPrintService {

    /**
     * 審査判定の変更状況Printします。
     *
     * @param reportJoho 審査判定の変更状況作成_帳票クラスパラメータ
     * @return 審査判定の変更状況作成_帳票
     */
    public SourceDataCollection print(ShinsahanteinoHenkojokyo reportJoho) {
        ShinsahanteinoHenkojokyoProperty property = new ShinsahanteinoHenkojokyoProperty();
        return new Printer<ShinsahanteinoHenkojokyoReportSource>().spool(property, toReports(reportJoho));
    }

    private static List<ShinsahanteinoHenkojokyoReport> toReports(ShinsahanteinoHenkojokyo reportJoho) {
        List<ShinsahanteinoHenkojokyoReport> list = new ArrayList<>();
        list.add(new ShinsahanteinoHenkojokyoReport(reportJoho));
        return list;

    }

}
