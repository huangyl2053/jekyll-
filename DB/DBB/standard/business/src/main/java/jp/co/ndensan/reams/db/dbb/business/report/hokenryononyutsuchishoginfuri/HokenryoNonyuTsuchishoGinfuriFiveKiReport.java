/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.hokenryononyutsuchishoginfuri;

import jp.co.ndensan.reams.db.dbb.entity.report.hokenryononyutsuchishoginfuri.HokenryoNonyuTsuchishoGinfuriFiveKiSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 *
 * 保険料納入通知書（本算定）【銀振タイプ】帳票項目定義_5期
 */
public class HokenryoNonyuTsuchishoGinfuriFiveKiReport extends Report<HokenryoNonyuTsuchishoGinfuriFiveKiSource> {

    private final HokenryoNonyuTsuchishoGinfuriItem item;

    /**
     * コンストラクタです。
     *
     * @param item HokenryoNonyuTsuchishoGinfuriItem
     */
    protected HokenryoNonyuTsuchishoGinfuriFiveKiReport(HokenryoNonyuTsuchishoGinfuriItem item) {
        this.item = item;
    }

    /**
     *
     * @param item HokenryoNonyuTsuchishoGinfuriItem
     * @return HokenryoNonyuTsuchishoGinfuriFiveKiReport
     * @throws NullPointerException 引数が{@code null}の時
     */
    public static HokenryoNonyuTsuchishoGinfuriFiveKiReport createFrom(HokenryoNonyuTsuchishoGinfuriItem item) {
        return new HokenryoNonyuTsuchishoGinfuriFiveKiReport(item);
    }

    @Override
    public void writeBy(ReportSourceWriter<HokenryoNonyuTsuchishoGinfuriFiveKiSource> writer) {
        IHokenryoNonyuTsuchishoGinfuriFiveKiEditor editor = new HokenryoNonyuTsuchishoGinfuriFiveKiEditor();
        item.get本算定納入通知書情報();
        IHokenryoNonyuTsuchishoGinfuriFiveKiBuilder builder = new HokenryoNonyuTsuchishoGinfuriFiveKiBuilder(editor);
        writer.writeLine(builder);
    }

}
