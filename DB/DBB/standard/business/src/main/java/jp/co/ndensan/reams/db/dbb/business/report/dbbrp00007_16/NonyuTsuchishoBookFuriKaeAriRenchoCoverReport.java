/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.dbbrp00007_16;

import jp.co.ndensan.reams.db.dbb.entity.report.dbbrp00007_16.NonyuTsuchishoBookFuriKaeAriRenchoCoverSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 *
 * 保険料納入通知書（本算定過年度）【ブックタイプ】（口振依頼あり）通知書_連帳
 */
public class NonyuTsuchishoBookFuriKaeAriRenchoCoverReport extends Report<NonyuTsuchishoBookFuriKaeAriRenchoCoverSource> {

    //private final NonyuTsuchishoBookItem item;
    /**
     * コンストラクタです。
     *
     */
    protected NonyuTsuchishoBookFuriKaeAriRenchoCoverReport() {
        //this.item = item;
    }

    /**
     *
     * @return NonyuTsuchishoBookFuriKaeAriRenchoCoverReport
     * @throws NullPointerException 引数が{@code null}の時
     */
    public static NonyuTsuchishoBookFuriKaeAriRenchoCoverReport createFrom() {
        return new NonyuTsuchishoBookFuriKaeAriRenchoCoverReport();
    }

    @Override
    public void writeBy(ReportSourceWriter<NonyuTsuchishoBookFuriKaeAriRenchoCoverSource> writer) {
        INonyuTsuchishoBookFuriKaeAriRenchoCoverEditor editor = new NonyuTsuchishoBookFuriKaeAriRenchoCoverEditor();
        INonyuTsuchishoBookFuriKaeAriRenchoCoverBuilder builder = new NonyuTsuchishoBookFuriKaeAriRenchoCoverBuilder(editor);
        writer.writeLine(builder);
    }

}
