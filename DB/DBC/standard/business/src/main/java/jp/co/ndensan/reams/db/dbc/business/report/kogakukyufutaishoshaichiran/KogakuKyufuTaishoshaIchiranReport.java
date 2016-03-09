/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakukyufutaishoshaichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.report.source.kogakukyufutaishoshaichiran.KogakuKyufuTaishoshaIchiranSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 * 高額介護サービス費給付対象者一覧表帳票Report
 */
public class KogakuKyufuTaishoshaIchiranReport extends Report<KogakuKyufuTaishoshaIchiranSource> {

    private final List<KogakuKyufuTaishoshaIchiranItem> targets;

    /**
     * コンストラクタです
     *
     * @param targets List<KogakuKyufuTaishoshaIchiranItem>
     */
    protected KogakuKyufuTaishoshaIchiranReport(List<KogakuKyufuTaishoshaIchiranItem> targets) {
        this.targets = targets;
    }

    /**
     * createFormメソッド
     *
     * @param targets List<KogakuKyufuTaishoshaIchiranItem> targets
     * @return KogakuKyufuTaishoshaIchiranReport
     */
    public static KogakuKyufuTaishoshaIchiranReport createForm(
            @NonNull List<KogakuKyufuTaishoshaIchiranItem> targets) {
        return new KogakuKyufuTaishoshaIchiranReport(targets);
    }

    @Override
    public void writeBy(ReportSourceWriter<KogakuKyufuTaishoshaIchiranSource> writer) {
        for (KogakuKyufuTaishoshaIchiranItem target : targets) {
            IKogakuKyufuTaishoshaIchiranEditor headerEditor = new HeaderEditor(target);
            IKogakuKyufuTaishoshaIchiranEditor bodyEditor = new BodyEditor(target);
            IKogakuKyufuTaishoshaIchiranBuilder builder = new KogakuKyufuTaishoshaIchiranBuilder(headerEditor, bodyEditor);
            writer.writeLine(builder);
        }
    }

}
