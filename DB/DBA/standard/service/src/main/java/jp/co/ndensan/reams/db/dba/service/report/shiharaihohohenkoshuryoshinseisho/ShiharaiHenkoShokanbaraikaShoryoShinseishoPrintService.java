/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.report.shiharaihohohenkoshuryoshinseisho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.report.shiharaihohohenkoshuryoshinseisho.ShiharaiHenkoShokanbaraikaShoryoShinseishoProperty;
import jp.co.ndensan.reams.db.dba.business.report.shiharaihohohenkoshuryoshinseisho.ShiharaiHenkoShokanbaraikaShoryoShinseishoReport;
import jp.co.ndensan.reams.db.dba.business.report.shiharaihohohenkoshuryoshinseisho.ShiharaiHenkoShokanbaraikaShoryoShinseishoReportJoho;
import jp.co.ndensan.reams.db.dba.entity.report.shiharaihohohenkoshuryoshinseisho.ShiharaiHenkoShokanbaraikaShoryoShinseishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 支払方法変更（償還払い化）終了申請書Printerです。
 */
public class ShiharaiHenkoShokanbaraikaShoryoShinseishoPrintService {

    /**
     * 支払方法変更（償還払い化）終了申請書を印刷します。
     *
     * @param reportJoho 支払方法変更（償還払い化）終了申請書クラスパラメータクラス
     * @return {@link SourceDataCollection}
     */
    public SourceDataCollection print(ShiharaiHenkoShokanbaraikaShoryoShinseishoReportJoho reportJoho) {
        ShiharaiHenkoShokanbaraikaShoryoShinseishoProperty property = new ShiharaiHenkoShokanbaraikaShoryoShinseishoProperty();
        return new Printer<ShiharaiHenkoShokanbaraikaShoryoShinseishoReportSource>().spool(property, toReports(reportJoho));
    }

    private static List<ShiharaiHenkoShokanbaraikaShoryoShinseishoReport> toReports(ShiharaiHenkoShokanbaraikaShoryoShinseishoReportJoho reportJoho) {
        List<ShiharaiHenkoShokanbaraikaShoryoShinseishoReport> list = new ArrayList<>();
        list.add(ShiharaiHenkoShokanbaraikaShoryoShinseishoReport.createFrom(
                reportJoho.getHeadItem()));
        return list;
    }
}
