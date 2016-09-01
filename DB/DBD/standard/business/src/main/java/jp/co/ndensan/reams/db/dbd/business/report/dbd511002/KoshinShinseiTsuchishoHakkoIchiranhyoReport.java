/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd511002;

import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd511002.TongzhiShuEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd511002.TongzhiShufaxingEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd511002.KoshinShinseiTsuchishoHakkoIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 更新申請のお知らせ通知書発行一覧表Builderのインターフェースです。
 *
 * @reamsid_L DBD-2030-040 donghj
 */
public final class KoshinShinseiTsuchishoHakkoIchiranhyoReport extends Report<KoshinShinseiTsuchishoHakkoIchiranhyoReportSource> {

    private final TongzhiShufaxingEntity entity1;
    private final TongzhiShuEntity entity2;

    /**
     * インスタンスを生成します。
     *
     * @param entity1 TongzhiShufaxingEntity
     * @param entity2 TongzhiShuEntity
     */
    public KoshinShinseiTsuchishoHakkoIchiranhyoReport(TongzhiShufaxingEntity entity1, TongzhiShuEntity entity2) {
        this.entity1 = entity1;
        this.entity2 = entity2;
    }

    @Override
    public void writeBy(ReportSourceWriter<KoshinShinseiTsuchishoHakkoIchiranhyoReportSource> writer) {
        IKoshinShinseiTsuchishoHakkoIchiranhyoEditor editor = new KoshinShinseiTsuchishoHakkoIchiranhyoEditor(entity1, entity2);
        IKoshinShinseiTsuchishoHakkoIchiranhyoBuilder builder = new KoshinShinseiTsuchishoHakkoIchiranhyoBuilder(editor);
        writer.writeLine(builder);
    }

}
