/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.hokenryononyutsuchishobook;

import jp.co.ndensan.reams.db.dbb.entity.report.hokenryononyutsuchishobook.KarisanteiNonyuTsuchishoBookFuriKaeNashiRenchoCoverSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 *
 * 保険料納入通知書（仮算定）【ブックタイプ】（口振依頼なし）通知書_連帳
 *
 * @reamsid_L DBB-9110-040 wangjie2
 */
public class KarisanteiNonyuTsuchishoBookFuriKaeNashiRenchoCoverReport
        extends Report<KarisanteiNonyuTsuchishoBookFuriKaeNashiRenchoCoverSource> {

    private final HokenryoNonyuTsuchishoBookItem item;

    /**
     * コンストラクタです。
     *
     * @param item HokenryoNonyuTsuchishoBookItem
     */
    protected KarisanteiNonyuTsuchishoBookFuriKaeNashiRenchoCoverReport(HokenryoNonyuTsuchishoBookItem item) {
        this.item = item;
    }

    /**
     *
     * @param item HokenryoNonyuTsuchishoBookItem
     * @return KarisanteiNonyuTsuchishoBookFuriKaeNashiRenchoCoverReport
     * @throws NullPointerException 引数が{@code null}の時
     */
    public static KarisanteiNonyuTsuchishoBookFuriKaeNashiRenchoCoverReport createFrom(@NonNull HokenryoNonyuTsuchishoBookItem item) {
        return new KarisanteiNonyuTsuchishoBookFuriKaeNashiRenchoCoverReport(item);
    }

    @Override
    public void writeBy(ReportSourceWriter<KarisanteiNonyuTsuchishoBookFuriKaeNashiRenchoCoverSource> writer) {
        IKarisanteiNonyuTsuchishoBookFuriKaeNashiRenchoCoverEditor editor
                = new KarisanteiNonyuTsuchishoBookFuriKaeNashiRenchoCoverEditor(item, null, 1);
        IKarisanteiNonyuTsuchishoBookFuriKaeNashiRenchoCoverBuilder builder = new KarisanteiNonyuTsuchishoBookFuriKaeNashiRenchoCoverBuilder(editor);
        writer.writeLine(builder);
    }

//    @Override
//    public List<NonyuTsuchisho> devidedByPage() {
//        List<NonyuTsuchisho> reportList = new ArrayList<>();
//        reportList.add(this);
//        return reportList;
//    }
}
