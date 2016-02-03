/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.shiharaihohohenkoshuryoshinseisho;

import jp.co.ndensan.reams.db.dba.entity.report.shiharaihohohenkoshuryoshinseisho.ShiharaiHenkoShokanbaraikaShoryoShinseishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 支払方法変更（償還払い化）終了申請書のReportです。
 */
public class ShiharaiHenkoShokanbaraikaShoryoShinseishoReport extends Report<ShiharaiHenkoShokanbaraikaShoryoShinseishoReportSource> {

    private final ShiharaiHenkoShokanbaraikaShoryoShinseishoHeadItem headItem;

    /**
     * インスタンスを生成します。
     *
     * @param headItem 支払方法変更（償還払い化）終了申請書ヘッダのITEM
     * @return 支払方法変更（償還払い化）終了申請書のReport
     */
    public static ShiharaiHenkoShokanbaraikaShoryoShinseishoReport createFrom(
            ShiharaiHenkoShokanbaraikaShoryoShinseishoHeadItem headItem) {

        return new ShiharaiHenkoShokanbaraikaShoryoShinseishoReport(
                headItem);
    }

    /**
     * インスタンスを生成します。
     *
     * @param headItem 支払方法変更（償還払い化）終了申請書ヘッダのITEM
     */
    protected ShiharaiHenkoShokanbaraikaShoryoShinseishoReport(
            ShiharaiHenkoShokanbaraikaShoryoShinseishoHeadItem headItem) {
        this.headItem = headItem;
    }

    /**
     *
     * @param reportSourceWriter reportSourceWriter
     */
    @Override
    public void writeBy(ReportSourceWriter<ShiharaiHenkoShokanbaraikaShoryoShinseishoReportSource> reportSourceWriter) {
        ShiharaiHenkoShokanbaraikaShoryoShinseishoHeaderEditor headerEditor = new ShiharaiHenkoShokanbaraikaShoryoShinseishoHeaderEditor(headItem);
        IShiharaiHenkoShokanbaraikaShoryoShinseishoBuilder builder = new ShiharaiHenkoShokanbaraikaShoryoShinseishoBuilderImpl(headerEditor);
        reportSourceWriter.writeLine(builder);
    }
}
