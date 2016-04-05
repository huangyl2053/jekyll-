/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.hihokenshadaicho;

import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.hihokenshadaichosakusei.HihokenshaDaichoSakusei;
import jp.co.ndensan.reams.db.dba.entity.report.hihokenshadaicho.HihokenshaDaichoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 * 被保険者台帳作成します。
 */
public final class HihokenshaDaichoReport extends Report<HihokenshaDaichoReportSource> {

    private final List<HihokenshaDaichoSakusei> items;
    private static final int ZERO = 0;
    private static final int FIVE = 5;

    private HihokenshaDaichoReport(List<HihokenshaDaichoSakusei> items) {
        this.items = items;
    }

    /**
     * インスタンスを生成します。
     *
     * @param items 一覧表証発行者Entityリスト
     * @return HihokenshashoHakkoIchiranHyoReport
     */
    public static HihokenshaDaichoReport createReport(@NonNull List<HihokenshaDaichoSakusei> items) {
        return new HihokenshaDaichoReport(items);
    }

    @Override
    protected void writeBy(ReportSourceWriter<HihokenshaDaichoReportSource> writer) {
        for (HihokenshaDaichoSakusei item : items) {
            writeChohyo(item, writer);
        }
    }

    private void writeChohyo(HihokenshaDaichoSakusei item, ReportSourceWriter<HihokenshaDaichoReportSource> writer) {
        IHihokenshaDaichoEditor joho = new HihokenshaDaichoEditor(item);
        for (int i = ZERO; i < FIVE; i++) {
            IHihokenshaDaichoEditor 老齢福祉 = new HihokenshaDaichoRoreiFukushiEditor(item.get老齢福祉情報(), i);
            IHihokenshaDaichoEditor 生活保護 = new HihokenshaDaichoSeikatsuhogoEditor(item.get生活保護情報(), i);
            IHihokenshaDaichoEditor 世帯左 = new HihokenshaDaichoSetaiLeftEditor(item, i);
            IHihokenshaDaichoEditor 世帯右 = new HihokenshaDaichoSetaiRightEditor(item.get世帯右情報(), i);
            IHihokenshaDaichoEditor 資格移動情報 = new HihokenshaDaichoShikakuIdoEditor(item.get資格異動情報(), i);
            IHihokenshaDaichoEditor 被保険者証発行履歴情報1 = new HihokenshaDaichoShoRireki1Editor(item.get被保険者証発行履歴情報１(), i);
            IHihokenshaDaichoEditor 被保険者証発行履歴情報2 = new HihokenshaDaichoShoRireki2Editor(item.get被保険者証発行履歴情報2(), i);
            IHihokenshaDaichoBuilder builder = new HihokenshaDaichoBuilder(joho, 老齢福祉,
                    生活保護, 世帯左, 世帯右, 資格移動情報, 被保険者証発行履歴情報1, 被保険者証発行履歴情報2);
            writer.writeLine(builder);
        }
    }
}
