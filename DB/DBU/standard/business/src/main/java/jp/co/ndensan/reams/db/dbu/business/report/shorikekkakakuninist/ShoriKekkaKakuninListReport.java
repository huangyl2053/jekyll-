/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.shorikekkakakuninist;

import jp.co.ndensan.reams.db.dbu.entity.db.relate.shorikekkakakuninlist.ShoriKekkaKakuninListEntity;
import jp.co.ndensan.reams.db.dbu.entity.report.shorikekkakakuninlist.ShoriKekkaKakuninListReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 処理確認リストのReportです。
 *
 * @reamsid_L DBU-5590-040 wanghuafeng
 */
public class ShoriKekkaKakuninListReport extends Report<ShoriKekkaKakuninListReportSource> {

    private final ShoriKekkaKakuninListEntity entity;

    /**
     * インスタンスを生成します。
     *
     * @param entity ShoriKekkaKakuninListEntity
     */
    public ShoriKekkaKakuninListReport(ShoriKekkaKakuninListEntity entity) {
        this.entity = entity;
    }

    @Override
    public void writeBy(ReportSourceWriter<ShoriKekkaKakuninListReportSource> writer) {
        IShoriKekkaKakuninListEditor headerEditor = new ShoriKekkaKakuninListEditor(entity);
        IShoriKekkaKakuninListBuidler builder = new ShoriKekkaKakuninListBuilder(headerEditor);
        writer.writeLine(builder);
    }

}
