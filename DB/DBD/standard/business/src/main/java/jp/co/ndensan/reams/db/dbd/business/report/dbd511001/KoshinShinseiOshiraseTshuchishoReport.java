/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd511001;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd511002.RenZhengzheEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd511001.KoshinShinseiOshiraseTshuchishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 認定更新お知らせ通知書ReportSourceです。
 *
 * @reamsid_L DBD-2030-030 donghj
 */
public final class KoshinShinseiOshiraseTshuchishoReport extends Report<KoshinShinseiOshiraseTshuchishoReportSource> {

    private final List<RenZhengzheEntity> 認定更新お知らせ通知書Entityリスト;

    /**
     * インスタンスを生成します。
     *
     * @param 認定更新お知らせ通知書Entityリスト List<RenZhengzheEntity>
     * @return 認定更新お知らせ通知書
     */
    public static KoshinShinseiOshiraseTshuchishoReport createReport(List<RenZhengzheEntity> 認定更新お知らせ通知書Entityリスト) {
        return new KoshinShinseiOshiraseTshuchishoReport(認定更新お知らせ通知書Entityリスト);
    }

    private KoshinShinseiOshiraseTshuchishoReport(List<RenZhengzheEntity> 認定更新お知らせ通知書Entityリスト) {
        this.認定更新お知らせ通知書Entityリスト = 認定更新お知らせ通知書Entityリスト;
    }

    /**
     * writeBy
     *
     * @param writer ReportSourceWriter
     */
    @Override
    public void writeBy(ReportSourceWriter<KoshinShinseiOshiraseTshuchishoReportSource> writer) {
        for (int index = 0; index < 認定更新お知らせ通知書Entityリスト.size(); index++) {
            IKoshinShinseiOshiraseTshuchishoEditor editor = new KoshinShinseiOshiraseTshuchishoEditor(
                    認定更新お知らせ通知書Entityリスト, index);
            IKoshinShinseiOshiraseTshuchishoBuilder builder = new KoshinShinseiOshiraseTshuchishoBuilder(editor);
            writer.writeLine(builder);
        }
    }

}
