/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.hokenryononyutsuchishobook;

import jp.co.ndensan.reams.db.dbb.entity.report.hokenryononyutsuchishobook.KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 *
 * 保険料納入通知書（仮算定）【ブックタイプ】（口振依頼なし）通知書
 */
public class KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverReport
        extends Report<KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverSource> {

    private final HokenryoNonyuTsuchishoBookItem item;

    /**
     * コンストラクタです。
     *
     * @param item HokenryoNonyuTsuchishoBookItem
     */
    protected KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverReport(HokenryoNonyuTsuchishoBookItem item) {
        this.item = item;
    }

    /**
     *
     * @param item HokenryoNonyuTsuchishoBookItem
     * @return KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverReport
     * @throws NullPointerException 引数が{@code null}の時
     */
    public static KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverReport createFrom(HokenryoNonyuTsuchishoBookItem item) {
        return new KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverReport(item);
    }

    @Override
    public void writeBy(ReportSourceWriter<KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverSource> writer) {
        IKarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverEditor editor
                = new KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverEditor(item, null, 1, null, null);
        IKarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverBuilder builder
                = new KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverBuilder(editor);
        writer.writeLine(builder);
    }

}
