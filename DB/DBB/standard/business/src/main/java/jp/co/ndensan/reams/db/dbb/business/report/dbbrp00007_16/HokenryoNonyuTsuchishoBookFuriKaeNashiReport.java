/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.dbbrp00007_16;

import jp.co.ndensan.reams.db.dbb.entity.report.dbbrp00007_16.HokenryoNonyuTsuchishoBookFuriKaeNashiCoverSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 *
 * 保険料納入通知書（本算定過年度）【ブックタイプ】（口振依頼なし）通知書
 */
public class HokenryoNonyuTsuchishoBookFuriKaeNashiReport extends Report<HokenryoNonyuTsuchishoBookFuriKaeNashiCoverSource> {

    //private final NonyuTsuchishoBookItem item;
    /**
     * コンストラクタです。
     *
     */
    protected HokenryoNonyuTsuchishoBookFuriKaeNashiReport() {
        //this.item = item;
    }

    /**
     *
     * @return HokenryoNonyuTsuchishoBookFuriKaeNashiReport
     * @throws NullPointerException 引数が{@code null}の時
     */
    public static HokenryoNonyuTsuchishoBookFuriKaeNashiReport createFrom() {
        return new HokenryoNonyuTsuchishoBookFuriKaeNashiReport();
    }

    @Override
    public void writeBy(ReportSourceWriter<HokenryoNonyuTsuchishoBookFuriKaeNashiCoverSource> writer) {
        IHokenryoNonyuTsuchishoBookFuriKaeNashiEditor editor = new HokenryoNonyuTsuchishoBookFuriKaeNashiEditor();
        IHokenryoNonyuTsuchishoBookFuriKaeNashiBuilder builder = new HokenryoNonyuTsuchishoBookFuriKaeNashiBuilder(editor);
        writer.writeLine(builder);
    }

}
