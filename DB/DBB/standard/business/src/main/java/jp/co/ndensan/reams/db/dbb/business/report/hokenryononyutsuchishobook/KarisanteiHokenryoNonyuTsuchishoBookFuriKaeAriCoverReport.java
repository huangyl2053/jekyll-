/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.hokenryononyutsuchishobook;

import jp.co.ndensan.reams.db.dbb.entity.report.hokenryononyutsuchishobook.KarisanteiHokenryoNonyuTsuchishoBookFuriKaeAriCoverSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 *
 * 保険料納入通知書（仮算定）【ブックタイプ】（口振依頼あり）通知書
 *
 * @reamsid_L DBB-9110-040 wangjie2
 */
public class KarisanteiHokenryoNonyuTsuchishoBookFuriKaeAriCoverReport
        extends Report<KarisanteiHokenryoNonyuTsuchishoBookFuriKaeAriCoverSource> {

    private final HokenryoNonyuTsuchishoBookItem item;

    /**
     * コンストラクタです。
     *
     * @param item HokenryoNonyuTsuchishoBookItem
     */
    protected KarisanteiHokenryoNonyuTsuchishoBookFuriKaeAriCoverReport(HokenryoNonyuTsuchishoBookItem item) {
        this.item = item;
    }

    /**
     *
     * @param item HokenryoNonyuTsuchishoBookItem
     * @return KarisanteiHokenryoNonyuTsuchishoBookFuriKaeAriCoverReport
     * @throws NullPointerException 引数が{@code null}の時
     */
    public static KarisanteiHokenryoNonyuTsuchishoBookFuriKaeAriCoverReport createFrom(@NonNull HokenryoNonyuTsuchishoBookItem item) {
        return new KarisanteiHokenryoNonyuTsuchishoBookFuriKaeAriCoverReport(item);
    }

    @Override
    public void writeBy(ReportSourceWriter<KarisanteiHokenryoNonyuTsuchishoBookFuriKaeAriCoverSource> writer) {
        IKarisanteiHokenryoNonyuTsuchishoBookFuriKaeAriCoverEditor editor
                = new KarisanteiHokenryoNonyuTsuchishoBookFuriKaeAriCoverEditor(item, null, 1);
        IKarisanteiHokenryoNonyuTsuchishoBookFuriKaeAriCoverBuilder builder = new KarisanteiHokenryoNonyuTsuchishoBookFuriKaeAriCoverBuilder(editor);
        writer.writeLine(builder);
    }

}
