/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.dbbrp00007_16;

import jp.co.ndensan.reams.db.dbb.entity.report.dbbrp00007_16.HokenryoNonyuTsuchishoBookFuriKaeNashiRenchoCoverSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 *
 * 保険料納入通知書（本算定過年度）【ブックタイプ】（口振依頼なし）通知書_連帳
 */
public class HokenryoNonyuTsuchishoBookFuriKaeNashiRenchoCoverReport extends Report<HokenryoNonyuTsuchishoBookFuriKaeNashiRenchoCoverSource> {

    //private final NonyuTsuchishoBookItem item;
    /**
     * コンストラクタです。
     *
     */
    protected HokenryoNonyuTsuchishoBookFuriKaeNashiRenchoCoverReport() {
        //this.item = item;
    }

    /**
     *
     * @return HokenryoNonyuTsuchishoBookFuriKaeNashiRenchoCoverReport
     * @throws NullPointerException 引数が{@code null}の時
     */
    public static HokenryoNonyuTsuchishoBookFuriKaeNashiRenchoCoverReport createFrom() {
        return new HokenryoNonyuTsuchishoBookFuriKaeNashiRenchoCoverReport();
    }

    @Override
    public void writeBy(ReportSourceWriter<HokenryoNonyuTsuchishoBookFuriKaeNashiRenchoCoverSource> writer) {
        IHokenryoNonyuTsuchishoBookFuriKaeNashiRenchoCoverEditor editor = new HokenryoNonyuTsuchishoBookFuriKaeNashiRenchoCoverEditor();
        IHokenryoNonyuTsuchishoBookFuriKaeNashiRenchoCoverBuilder builder = new HokenryoNonyuTsuchishoBookFuriKaeNashiRenchoCoverBuilder(editor);
        writer.writeLine(builder);
    }

}
