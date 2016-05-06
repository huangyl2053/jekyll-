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
 *
 * @reamsid_L DBA-0500-040 zuotao
 */
public final class HihokenshaDaichoReport extends Report<HihokenshaDaichoReportSource> {

    private final List<HihokenshaDaichoSakusei> items;
    private static final int ZERO = 0;

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
    public void writeBy(ReportSourceWriter<HihokenshaDaichoReportSource> writer) {
        for (HihokenshaDaichoSakusei item : items) {
            writeChohyo(item, writer);
        }
    }

    private void writeChohyo(HihokenshaDaichoSakusei item, ReportSourceWriter<HihokenshaDaichoReportSource> writer) {
        IHihokenshaDaichoEditor joho = new HihokenshaDaichoEditor(item);

        int maxCount = getMaxBreakCount(item);
        for (int i = ZERO; i < maxCount; i++) {
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

    private int getMaxBreakCount(HihokenshaDaichoSakusei item) {
        int maxCount = item.get老齢福祉情報() == null ? ZERO : item.get老齢福祉情報().get老齢福祉No().size();
        if (item.get生活保護情報() != null && maxCount < HihokenshaDaichoEditor.getMaxIndex(item.get生活保護情報().get生活保護No())) {
            maxCount = item.get生活保護情報().get生活保護No().size();
        }
        if (item.get世帯左情報() != null && maxCount < HihokenshaDaichoEditor.getMaxIndex(item.get世帯左情報().get世帯左No())) {
            maxCount = item.get世帯左情報().get世帯左No().size();
        }
        if (item.get世帯右情報() != null && item.get世帯右情報().get世帯右被保険者番号() != null
                && maxCount < item.get世帯右情報().get世帯右被保険者番号().size()) {
            maxCount = item.get世帯右情報().get世帯右被保険者番号().size();
        }
        if (item.get資格異動情報() != null
                && maxCount < HihokenshaDaichoEditor.getMaxIndex(item.get資格異動情報().get資格異動No())) {
            maxCount = item.get資格異動情報().get資格異動No().size();
        }
        if (item.get被保険者証発行履歴情報１() != null
                && maxCount < HihokenshaDaichoEditor.getMaxIndex(item.get被保険者証発行履歴情報１().get証履歴No1())) {
            maxCount = item.get被保険者証発行履歴情報１().get証履歴No1().size();
        }
        if (item.get被保険者証発行履歴情報2() != null
                && maxCount < HihokenshaDaichoEditor.getMaxIndex(item.get被保険者証発行履歴情報2().get証履歴No2())) {
            maxCount = item.get被保険者証発行履歴情報2().get証履歴No2().size();
        }
        return maxCount;
    }
}
