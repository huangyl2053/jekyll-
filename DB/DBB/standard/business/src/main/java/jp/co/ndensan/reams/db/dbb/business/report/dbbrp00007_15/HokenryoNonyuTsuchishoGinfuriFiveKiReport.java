/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.dbbrp00007_15;

import jp.co.ndensan.reams.db.dbb.entity.report.dbbrp00007_15.HokenryoNonyuTsuchishoGinfuriFiveKiSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 *
 * 保険料納入通知書（本算定過年度）【銀振タイプ】帳票項目定義_5期
 */
public class HokenryoNonyuTsuchishoGinfuriFiveKiReport extends Report<HokenryoNonyuTsuchishoGinfuriFiveKiSource> {

    //private final HokenryoNonyuTsuchishoGinfuriFiveKiRenchoItem item;
    /**
     * コンストラクタです。
     *
     */
    protected HokenryoNonyuTsuchishoGinfuriFiveKiReport() {
        //this.item = item;
    }

    /**
     *
     * @return HokenryoNonyuTsuchishoGinfuriFiveKiReport
     * @throws NullPointerException 引数が{@code null}の時
     */
    public static HokenryoNonyuTsuchishoGinfuriFiveKiReport createFrom() {
        return new HokenryoNonyuTsuchishoGinfuriFiveKiReport();
    }

    @Override
    public void writeBy(ReportSourceWriter<HokenryoNonyuTsuchishoGinfuriFiveKiSource> writer) {
        IHokenryoNonyuTsuchishoGinfuriFiveKiEditor editor = new HokenryoNonyuTsuchishoGinfuriFiveKiEditor();
        IHokenryoNonyuTsuchishoGinfuriFiveKiBuilder builder = new HokenryoNonyuTsuchishoGinfuriFiveKiBuilder(editor);
        writer.writeLine(builder);
    }

}
