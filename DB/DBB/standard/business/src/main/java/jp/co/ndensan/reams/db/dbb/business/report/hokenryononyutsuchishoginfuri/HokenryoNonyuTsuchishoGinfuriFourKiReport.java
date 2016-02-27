/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.hokenryononyutsuchishoginfuri;

import jp.co.ndensan.reams.db.dbb.entity.report.hokenryononyutsuchishoginfuri.HokenryoNonyuTsuchishoGinfuriFourKiSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 *
 * 保険料納入通知書（本算定）【銀振タイプ】帳票項目定義_4期
 */
public class HokenryoNonyuTsuchishoGinfuriFourKiReport extends Report<HokenryoNonyuTsuchishoGinfuriFourKiSource> {

    private final HokenryoNonyuTsuchishoGinfuriItem item;

    /**
     * コンストラクタです。
     *
     * @param item HokenryoNonyuTsuchishoGinfuriItem
     */
    protected HokenryoNonyuTsuchishoGinfuriFourKiReport(HokenryoNonyuTsuchishoGinfuriItem item) {
        this.item = item;
    }

    /**
     *
     * @param item HokenryoNonyuTsuchishoGinfuriItem
     * @return HokenryoNonyuTsuchishoGinfuriFourKiReport
     */
    public static HokenryoNonyuTsuchishoGinfuriFourKiReport createFrom(HokenryoNonyuTsuchishoGinfuriItem item) {
        return new HokenryoNonyuTsuchishoGinfuriFourKiReport(item);
    }

    @Override
    public void writeBy(ReportSourceWriter<HokenryoNonyuTsuchishoGinfuriFourKiSource> writer) {
        IHokenryoNonyuTsuchishoGinfuriFourKiEditor editor = new HokenryoNonyuTsuchishoGinfuriFourKiEditor(item, null);
        IHokenryoNonyuTsuchishoGinfuriFourKiBuilder builder = new HokenryoNonyuTsuchishoGinfuriFourKiBuilder(editor);
        writer.writeLine(builder);
    }

}
