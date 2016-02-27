/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.hokenryononyutsuchishoginfuri;

import jp.co.ndensan.reams.db.dbb.entity.report.hokenryononyutsuchishoginfuri.HokenryoNonyuTsuchishoGinfuriFiveKiRenchoSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 *
 * 保険料納入通知書（本算定）【銀振タイプ】帳票項目定義_5期_連帳
 */
public class HokenryoNonyuTsuchishoGinfuriFiveKiRenchoReport extends Report<HokenryoNonyuTsuchishoGinfuriFiveKiRenchoSource> {

    private final HokenryoNonyuTsuchishoGinfuriItem item;

    /**
     * コンストラクタです。
     *
     * @param item HokenryoNonyuTsuchishoGinfuriItem
     */
    protected HokenryoNonyuTsuchishoGinfuriFiveKiRenchoReport(HokenryoNonyuTsuchishoGinfuriItem item) {
        this.item = item;
    }

    /**
     *
     * @param item HokenryoNonyuTsuchishoGinfuriItem
     * @return HokenryoNonyuTsuchishoGinfuriFiveKiRenchoReport
     * @throws NullPointerException 引数が{@code null}の時
     */
    public static HokenryoNonyuTsuchishoGinfuriFiveKiRenchoReport createFrom(HokenryoNonyuTsuchishoGinfuriItem item) {
        return new HokenryoNonyuTsuchishoGinfuriFiveKiRenchoReport(item);
    }

    @Override
    public void writeBy(ReportSourceWriter<HokenryoNonyuTsuchishoGinfuriFiveKiRenchoSource> writer) {
        IHokenryoNonyuTsuchishoGinfuriFiveKiRenchoEditor editor = new HokenryoNonyuTsuchishoGinfuriFiveKiRenchoEditor();
        item.get本算定納入通知書情報();
        IHokenryoNonyuTsuchishoGinfuriFiveKiRenchoBuilder builder = new HokenryoNonyuTsuchishoGinfuriFiveKiRenchoBuilder(editor);
        writer.writeLine(builder);
    }

}
