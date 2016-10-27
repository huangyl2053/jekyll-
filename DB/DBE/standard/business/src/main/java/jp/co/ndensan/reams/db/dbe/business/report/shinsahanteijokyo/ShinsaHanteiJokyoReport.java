/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinsahanteijokyo;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteischedule.shinsahanteijokyo.ShinsaHanteiJokyoEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.shinsahanteijokyo.ShinsaHanteiJokyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBE701001_介護認定審査会判定状況表クラスです。
 *
 * @reamsid_L DBE-1450-030 wanghui
 */
public class ShinsaHanteiJokyoReport extends Report<ShinsaHanteiJokyoReportSource> {

    private ShinsaHanteiJokyoEntity item;
    private List<ShinsaHanteiJokyoEntity> itemList;

    /**
     * インスタンスを生成します。
     *
     * @param item ShinsaHanteiJokyoEntity
     */
    protected ShinsaHanteiJokyoReport(ShinsaHanteiJokyoEntity item) {
        this.item = item;
    }

    /**
     * インスタンスを生成します。
     *
     * @param itemList 介護認定審査会スケジュール表かがみのItem
     */
    public ShinsaHanteiJokyoReport(List<ShinsaHanteiJokyoEntity> itemList) {
        this.itemList = itemList;
    }

    /**
     * 介護認定審査会判定状況表を生成します。
     *
     * @param reportSourceWriter 帳票Writer
     */
    @Override
    public void writeBy(ReportSourceWriter<ShinsaHanteiJokyoReportSource> reportSourceWriter) {
        for (ShinsaHanteiJokyoEntity dataBody : itemList) {
            ShinsaHanteiJokyoEditorImpl editor = new ShinsaHanteiJokyoEditorImpl(dataBody);
            IShinsaHanteiJokyoBuilder builder = new ShinsaHanteiJokyoBuilderImpl(editor);
            reportSourceWriter.writeLine(builder);
        }
        if (item != null) {
            ShinsaHanteiJokyoEntity entity = new ShinsaHanteiJokyoEntity();
            ShinsaHanteiJokyoEditorImpl editor = new ShinsaHanteiJokyoEditorImpl(entity);
            IShinsaHanteiJokyoBuilder builder = new ShinsaHanteiJokyoBuilderImpl(editor);
            reportSourceWriter.writeLine(builder);
        }
    }
}
