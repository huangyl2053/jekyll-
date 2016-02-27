/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.hokenryononyutsuchishobook;

import jp.co.ndensan.reams.db.dbb.entity.report.hokenryononyutsuchishobook.KarisanteiNonyuTsuchishoBookFuriKaeAriRenchoCoverSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 *
 * 保険料納入通知書（仮算定）【ブックタイプ】納付書連帳 （口振依頼あり）通知書_連帳
 */
public class KarisanteiNonyuTsuchishoBookFuriKaeAriRenchoCoverReport extends Report<KarisanteiNonyuTsuchishoBookFuriKaeAriRenchoCoverSource> {

    private final HokenryoNonyuTsuchishoBookItem item;

    /**
     * コンストラクタです。
     *
     * @param item HokenryoNonyuTsuchishoBookItem
     */
    protected KarisanteiNonyuTsuchishoBookFuriKaeAriRenchoCoverReport(HokenryoNonyuTsuchishoBookItem item) {
        this.item = item;
    }

    /**
     *
     * @param item
     * @return KarisanteiNonyuTsuchishoBookFuriKaeAriRenchoCoverReport
     * @throws NullPointerException 引数が{@code null}の時
     */
    public static KarisanteiNonyuTsuchishoBookFuriKaeAriRenchoCoverReport createFrom(HokenryoNonyuTsuchishoBookItem item) {
        return new KarisanteiNonyuTsuchishoBookFuriKaeAriRenchoCoverReport(item);
    }

    @Override
    public void writeBy(ReportSourceWriter<KarisanteiNonyuTsuchishoBookFuriKaeAriRenchoCoverSource> writer) {
        IKarisanteiNonyuTsuchishoBookFuriKaeAriRenchoCoverEditor editor
                = new KarisanteiNonyuTsuchishoBookFuriKaeAriRenchoCoverEditor(item, null, 1, null, null);
        IKarisanteiNonyuTsuchishoBookFuriKaeAriRenchoCoverBuilder builder = new KarisanteiNonyuTsuchishoBookFuriKaeAriRenchoCoverBuilder(editor);
        writer.writeLine(builder);
    }

}
