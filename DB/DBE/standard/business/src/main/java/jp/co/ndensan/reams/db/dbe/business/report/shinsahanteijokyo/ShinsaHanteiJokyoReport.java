/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinsahanteijokyo;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.report.shinsahanteijokyo.ShinsaHanteiJokyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBE701001_介護認定審査会判定状況表クラスです。
 *
 * @reamsid_L DBE-1450-030 wanghui
 */
public class ShinsaHanteiJokyoReport extends Report<ShinsaHanteiJokyoReportSource> {

    private final List<ShinsaHanteiJokyoItem> itemList;

    /**
     * インスタンスを生成します。
     *
     * @param itemList 介護認定審査会スケジュール表かがみのItem
     * @return 介護認定審査会スケジュール表かがみのReport
     */
    public static ShinsaHanteiJokyoReport createFrom(List<ShinsaHanteiJokyoItem> itemList) {
        return new ShinsaHanteiJokyoReport(itemList);
    }

    /**
     * インスタンスを生成します。
     *
     * @param itemList 介護認定審査会スケジュール表かがみのItem
     */
    protected ShinsaHanteiJokyoReport(List<ShinsaHanteiJokyoItem> itemList) {
        this.itemList = itemList;
    }

    /**
     * 介護認定審査会スケジュール表かがみを生成します。
     *
     * @param reportSourceWriter 帳票Writer
     */
    @Override
    public void writeBy(ReportSourceWriter<ShinsaHanteiJokyoReportSource> reportSourceWriter) {
        for (ShinsaHanteiJokyoItem item : itemList) {
            IShinsaHanteiJokyoEditor editor = new ShinsaHanteiJokyoEditorImpl(item);
            IShinsaHanteiJokyoBuilder builder = new ShinsaHanteiJokyoBuilderImpl(editor);
            reportSourceWriter.writeLine(builder);
        }
    }
}
