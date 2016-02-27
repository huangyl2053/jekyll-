/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.dbbrp00007_15;

import jp.co.ndensan.reams.db.dbb.entity.report.dbbrp00007_15.HokenryoNonyuTsuchishoGinfuriFourKiSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 *
 * 保険料納入通知書（本算定過年度）【銀振タイプ】帳票項目定義_4期
 */
public class HokenryoNonyuTsuchishoGinfuriFourKiReport extends Report<HokenryoNonyuTsuchishoGinfuriFourKiSource> {

    //private final HokenryoNonyuTsuchishoGinfuriFiveKiRenchoItem item;
    /**
     * コンストラクタです。
     *
     */
    protected HokenryoNonyuTsuchishoGinfuriFourKiReport() {
        // this.item = item;
    }

    /**
     *
     * @return HokenryoNonyuTsuchishoGinfuriFourKiReport
     * @throws NullPointerException 引数が{@code null}の時
     */
    public static HokenryoNonyuTsuchishoGinfuriFourKiReport createFrom() {
        return new HokenryoNonyuTsuchishoGinfuriFourKiReport();
    }

    @Override
    public void writeBy(ReportSourceWriter<HokenryoNonyuTsuchishoGinfuriFourKiSource> writer) {
        IHokenryoNonyuTsuchishoGinfuriFourKiEditor editor = new HokenryoNonyuTsuchishoGinfuriFourKiEditor();
        IHokenryoNonyuTsuchishoGinfuriFourKiBuilder builder = new HokenryoNonyuTsuchishoGinfuriFourKiBuilder(editor);
        writer.writeLine(builder);
    }

}
