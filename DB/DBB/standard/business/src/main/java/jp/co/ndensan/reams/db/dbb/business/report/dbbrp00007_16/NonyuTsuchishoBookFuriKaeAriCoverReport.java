/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.dbbrp00007_16;

import jp.co.ndensan.reams.db.dbb.entity.report.dbbrp00007_16.NonyuTsuchishoBookFuriKaeAriCoverSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 *
 * 保険料納入通知書（本算定過年度）【ブックタイプ】（口振依頼あり）通知書
 */
public class NonyuTsuchishoBookFuriKaeAriCoverReport extends Report<NonyuTsuchishoBookFuriKaeAriCoverSource> {

    //private final NonyuTsuchishoBookItem item;
    /**
     * コンストラクタです。
     *
     */
    protected NonyuTsuchishoBookFuriKaeAriCoverReport() {
        //this.item = item;
    }

    /**
     *
     * @return NonyuTsuchishoBookFuriKaeAriCoverReport
     * @throws NullPointerException 引数が{@code null}の時
     */
    public static NonyuTsuchishoBookFuriKaeAriCoverReport createFrom() {
        return new NonyuTsuchishoBookFuriKaeAriCoverReport();
    }

    @Override
    public void writeBy(ReportSourceWriter<NonyuTsuchishoBookFuriKaeAriCoverSource> writer) {
        INonyuTsuchishoBookFuriKaeAriCoverEditor editor = new NonyuTsuchishoBookFuriKaeAriCoverEditor();
        INonyuTsuchishoBookFuriKaeAriCoverBuilder builder = new NonyuTsuchishoBookFuriKaeAriCoverBuilder(editor);
        writer.writeLine(builder);
    }

}
