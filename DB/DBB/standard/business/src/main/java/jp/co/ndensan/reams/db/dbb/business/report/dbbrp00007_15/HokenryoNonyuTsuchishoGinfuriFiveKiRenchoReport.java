/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.dbbrp00007_15;

import jp.co.ndensan.reams.db.dbb.entity.report.dbbrp00007_15.HokenryoNonyuTsuchishoGinfuriFiveKiRenchoSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 *
 * 保険料納入通知書（本算定過年度）【銀振タイプ】帳票項目定義_5期_連帳
 */
public class HokenryoNonyuTsuchishoGinfuriFiveKiRenchoReport extends Report<HokenryoNonyuTsuchishoGinfuriFiveKiRenchoSource> {

    //private final HokenryoNonyuTsuchishoGinfuriFiveKiRenchoItem item;
    /**
     * コンストラクタです。
     *
     */
    protected HokenryoNonyuTsuchishoGinfuriFiveKiRenchoReport() {
        //this.item = item;
    }

    /**
     *
     * @return HokenryoNonyuTsuchishoGinfuriFiveKiRenchoReport
     * @throws NullPointerException 引数が{@code null}の時
     */
    public static HokenryoNonyuTsuchishoGinfuriFiveKiRenchoReport createFrom() {
        return new HokenryoNonyuTsuchishoGinfuriFiveKiRenchoReport();
    }

    @Override
    public void writeBy(ReportSourceWriter<HokenryoNonyuTsuchishoGinfuriFiveKiRenchoSource> writer) {
        IHokenryoNonyuTsuchishoGinfuriFiveKiRenchoEditor editor = new HokenryoNonyuTsuchishoGinfuriFiveKiRenchoEditor();
        HokenryoNonyuTsuchishoGinfuriFiveKiRenchoBuilder builder = new HokenryoNonyuTsuchishoGinfuriFiveKiRenchoBuilder(editor);
        writer.writeLine(builder);
    }

}
