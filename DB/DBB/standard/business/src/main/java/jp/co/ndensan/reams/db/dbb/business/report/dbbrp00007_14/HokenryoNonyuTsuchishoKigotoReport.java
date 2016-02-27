/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.dbbrp00007_14;

import jp.co.ndensan.reams.db.dbb.entity.report.dbbrp00007_14.HokenryoNonyuTsuchishoKigotoSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 *
 * 保険料納入通知書（本算定過年度）【期毎タイプ】
 */
public class HokenryoNonyuTsuchishoKigotoReport extends Report<HokenryoNonyuTsuchishoKigotoSource> {

    //private final HokenryoNonyuTsuchishoKigotoItem item;
    /**
     * コンストラクタです。
     *
     */
    protected HokenryoNonyuTsuchishoKigotoReport() {
        //this.item = item;
    }

    /**
     *
     * @param item HokenryoNonyuTsuchishoKigotoItem
     * @return HokenryoNonyuTsuchishoKigotoReport
     * @throws NullPointerException 引数が{@code null}の時
     */
    public static HokenryoNonyuTsuchishoKigotoReport createFrom(HokenryoNonyuTsuchishoKigotoItem item) {
        return new HokenryoNonyuTsuchishoKigotoReport();
    }

    @Override
    public void writeBy(ReportSourceWriter<HokenryoNonyuTsuchishoKigotoSource> writer) {
        IHokenryoNonyuTsuchishoKigotoEditor editor = new HokenryoNonyuTsuchishoKigotoEditor();
        IHokenryoNonyuTsuchishoKigotoBuilder builder = new HokenryoNonyuTsuchishoKigotoBuilder(editor);
        writer.writeLine(builder);
    }

}
