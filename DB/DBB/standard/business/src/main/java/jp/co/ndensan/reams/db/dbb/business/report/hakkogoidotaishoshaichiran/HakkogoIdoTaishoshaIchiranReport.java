/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.hakkogoidotaishoshaichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.entity.report.hakkogoidotaishoshaichiran.HakkogoIdoTaishoshaIchiranSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 * 通知書発行後異動把握帳票HakkogoIdoTaishoshaIchiranReport
 *
 * @reamsid_L DBB-0690-030 surun
 */
public class HakkogoIdoTaishoshaIchiranReport extends Report<HakkogoIdoTaishoshaIchiranSource> {

    private final List<HakkogoIdoTaishoshaIchiranItem> targets;

    /**
     * コンストラクタです。
     *
     * @param targets List<HakkogoIdoTaishoshaIchiranItem>
     */
    protected HakkogoIdoTaishoshaIchiranReport(List<HakkogoIdoTaishoshaIchiranItem> targets) {
        this.targets = targets;
    }

    /**
     * createFormメソッド
     *
     * @param items List<HakkogoIdoTaishoshaIchiranItem>
     * @return HakkogoIdoTaishoshaIchiranReport
     */
    public static HakkogoIdoTaishoshaIchiranReport createForm(@NonNull List<HakkogoIdoTaishoshaIchiranItem> items) {
        return new HakkogoIdoTaishoshaIchiranReport(items);
    }

    @Override
    public void writeBy(ReportSourceWriter<HakkogoIdoTaishoshaIchiranSource> writer) {
        for (HakkogoIdoTaishoshaIchiranItem target : targets) {
            IHakkogoIdoTaishoshaIchiranEditor headerEditor = new HakkogoIdoTaishoshaIchiranHeaderEditor(target);
            IHakkogoIdoTaishoshaIchiranEditor bodyEditor = new HakkogoIdoTaishoshaIchiranBodyEditor(target);
            IHakkogoIdoTaishoshaIchiranBuilder builder = new HakkogoIdoTaishoshaIchiranBuilder(headerEditor, bodyEditor);
            writer.writeLine(builder);
        }
    }

}
