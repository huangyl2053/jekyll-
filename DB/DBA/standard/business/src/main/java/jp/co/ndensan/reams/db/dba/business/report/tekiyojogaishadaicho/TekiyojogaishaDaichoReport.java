/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.tekiyojogaishadaicho;

import java.util.List;
import jp.co.ndensan.reams.db.dba.entity.report.source.tekiyojogaishadaicho.TekiyojogaishaDaichoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 適用除外者台帳のReportです。
 *
 * @reamsid_L DBE-3000-140 lishengli
 */
public class TekiyojogaishaDaichoReport extends Report<TekiyojogaishaDaichoReportSource> {

    private final List<TekiyojogaishaDaichoBodyItem> bodyItemList;
    private final TekiyojogaishaDaichoHeadItem headItem;

    /**
     * インスタンスを生成します。
     *
     * @param headItem 適用除外者台帳ヘッダのITEM
     * @param itemList 適用除外者台帳ボディのITEMリスト
     * @return 適用除外者台帳のReport
     */
    public static TekiyojogaishaDaichoReport createFrom(
            TekiyojogaishaDaichoHeadItem headItem,
            List<TekiyojogaishaDaichoBodyItem> itemList) {

        return new TekiyojogaishaDaichoReport(
                headItem,
                itemList);
    }

    /**
     * インスタンスを生成します。
     *
     * @param headItem 適用除外者台帳ヘッダのITEM
     * @param itemList 適用除外者台帳のITEMリスト
     */
    protected TekiyojogaishaDaichoReport(
            TekiyojogaishaDaichoHeadItem headItem,
            List<TekiyojogaishaDaichoBodyItem> itemList) {

        this.headItem = headItem;
        this.bodyItemList = itemList;
    }

    /**
     *
     * @param reportSourceWriter reportSourceWriter
     */
    @Override
    public void writeBy(ReportSourceWriter<TekiyojogaishaDaichoReportSource> reportSourceWriter) {
        for (TekiyojogaishaDaichoBodyItem bodyItem : bodyItemList) {
            ITekiyojogaishaDaichoEditor headerEditor = new TekiyojogaishaDaichoHeaderEditor(headItem);
            ITekiyojogaishaDaichoEditor bodyEditor = new TekiyojogaishaDaichoBodyEditor(bodyItem);
            ITekiyojogaishaDaichoBuilder builder = new TekiyojogaishaDaichoBuilderImpl(headerEditor, bodyEditor);
            reportSourceWriter.writeLine(builder);
        }
    }
}
