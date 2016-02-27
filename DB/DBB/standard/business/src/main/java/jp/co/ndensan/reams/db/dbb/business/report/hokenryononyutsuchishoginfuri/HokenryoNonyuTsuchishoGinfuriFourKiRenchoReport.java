/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.hokenryononyutsuchishoginfuri;

import jp.co.ndensan.reams.db.dbb.entity.report.hokenryononyutsuchishoginfuri.HokenryoNonyuTsuchishoGinfuriFourKiRenchoSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 *
 * 保険料納入通知書（本算定）【銀振タイプ】帳票項目定義_4期_連帳
 */
public class HokenryoNonyuTsuchishoGinfuriFourKiRenchoReport extends Report<HokenryoNonyuTsuchishoGinfuriFourKiRenchoSource> {

    private final HokenryoNonyuTsuchishoGinfuriItem item;

    /**
     * コンストラクタです。
     *
     * @param item HokenryoNonyuTsuchishoGinfuriItem
     */
    protected HokenryoNonyuTsuchishoGinfuriFourKiRenchoReport(HokenryoNonyuTsuchishoGinfuriItem item) {
        this.item = item;
    }

    /**
     *
     * @param item HokenryoNonyuTsuchishoGinfuriItem
     * @return HokenryoNonyuTsuchishoGinfuriFourKiRenchoReport
     * @throws NullPointerException 引数が{@code null}の時
     */
    public static HokenryoNonyuTsuchishoGinfuriFourKiRenchoReport createFrom(HokenryoNonyuTsuchishoGinfuriItem item) {
        return new HokenryoNonyuTsuchishoGinfuriFourKiRenchoReport(item);
    }

    @Override
    public void writeBy(ReportSourceWriter<HokenryoNonyuTsuchishoGinfuriFourKiRenchoSource> writer) {
        IHokenryoNonyuTsuchishoGinfuriFourKiRenchoEditor editor = new HokenryoNonyuTsuchishoGinfuriFourKiRenchoEditor();
        item.get本算定納入通知書情報();
        IHokenryoNonyuTsuchishoGinfuriFourKiRenchoBuilder builder = new HokenryoNonyuTsuchishoGinfuriFourKiRenchoBuilder(editor);
        writer.writeLine(builder);
    }

}
