/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.johoteikyoshiryo;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.report.johoteikyoshiryo.JohoTeikyoShiryoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 * 要介護認定結果情報提供票（主治医）のReportです。
 */
public class JohoTeikyoShiryoReport extends Report<JohoTeikyoShiryoReportSource> {

    private final List<JohoTeikyoShiryoItem> itemList;

    /**
     * インスタンスを生成します。
     *
     * @param itemlist 要介護認定結果情報提供票（主治医）のitemlist
     * @return 要介護認定結果情報提供票（主治医）のReport
     */
    public static JohoTeikyoShiryoReport createFrom(@NonNull List<JohoTeikyoShiryoItem>  itemlist) {
        return new JohoTeikyoShiryoReport(itemlist);
    }

    /**
     * インスタンスを生成します。
     *
     * @param itemlist 要介護認定結果情報提供票（主治医）のitemlist
     */
    protected JohoTeikyoShiryoReport(List<JohoTeikyoShiryoItem> itemlist) {
        this.itemList = itemlist;
    }

    @Override
    public void writeBy(ReportSourceWriter<JohoTeikyoShiryoReportSource> reportSourceWriter) {
        for (JohoTeikyoShiryoItem item : itemList) {
            IJohoTeikyoShiryoEditor editor = new JohoTeikyoShiryoEditor(item);
            IJohoTeikyoShiryoBuilder builder = new JohoTeikyoShiryoBuilder(editor);
            reportSourceWriter.writeLine(builder);
        }
    }
}
