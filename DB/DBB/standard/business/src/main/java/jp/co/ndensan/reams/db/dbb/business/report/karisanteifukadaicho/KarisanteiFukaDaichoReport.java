/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.karisanteifukadaicho;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.entity.report.karisanteifukadaicho.KarisanteiFukaDaichoSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 * 帳票設計_DBBRP00006_2_賦課台帳（仮算定）
 */
public class KarisanteiFukaDaichoReport extends Report<KarisanteiFukaDaichoSource> {

    private final List<KarisanteiFukaDaichoItem> targets;

    /**
     * コンストラクタです。
     *
     * @param targets List<KarisanteiFukaDaichoReport>
     */
    protected KarisanteiFukaDaichoReport(List<KarisanteiFukaDaichoItem> targets) {
        this.targets = targets;
    }

    /**
     * createFormメソッド
     *
     * @param fukadaichoItem List<KarisanteiFukaDaichoReport>
     * @return KarisanteiFukaDaichoReport
     */
    public static KarisanteiFukaDaichoReport createFrom(@NonNull List<KarisanteiFukaDaichoItem> fukadaichoItem) {
        return new KarisanteiFukaDaichoReport(fukadaichoItem);
    }

    /**
     *
     * @param reportSourceWriter reportSourceWriter
     */
    @Override
    public void writeBy(ReportSourceWriter<KarisanteiFukaDaichoSource> reportSourceWriter) {
        for (KarisanteiFukaDaichoItem target : targets) {
            IKarisanteiFukaDaichoEditor headerEditor = new HeaderEditor(target);
            IKarisanteiFukaDaichoEditor hyojiIchiranEditor = new BodyEditor(target);
            IKarisanteiFukaDaichouilder builder = new KarisanteiFukaDaichoBuilder(headerEditor, hyojiIchiranEditor);
            reportSourceWriter.writeLine(builder);
        }
    }
}
