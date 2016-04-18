/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.hihokenshadaicho;

import jp.co.ndensan.reams.db.dba.entity.report.hihokenshadaicho.HihokenshaDaichoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 被保険者台帳Builderクラスです。
 *
 * @reamsid_L DBA-0500-040 zuotao
 */
public final class HihokenshaDaichoBuilder implements IHihokenshaDaichoBuilder {

    private final IHihokenshaDaichoEditor joho;
    private final IHihokenshaDaichoEditor 老齢福祉;
    private final IHihokenshaDaichoEditor 生活保護;
    private final IHihokenshaDaichoEditor 世帯左;
    private final IHihokenshaDaichoEditor 世帯右;
    private final IHihokenshaDaichoEditor 資格移動情報;
    private final IHihokenshaDaichoEditor 被保険者証発行履歴情報1;
    private final IHihokenshaDaichoEditor 被保険者証発行履歴情報2;

    /**
     * コンストラクタです。
     *
     * @param joho 被保険者台帳
     * @param 老齢福祉 老齢福祉情報
     * @param 生活保護 生活保護情報
     * @param 世帯左 世帯左情報
     * @param 世帯右 世帯右情報
     * @param 資格移動情報 資格移動情報
     * @param 被保険者証発行履歴情報1 被保険者証発行履歴情報1
     * @param 被保険者証発行履歴情報2 被保険者証発行履歴情報2
     */
    public HihokenshaDaichoBuilder(IHihokenshaDaichoEditor joho, IHihokenshaDaichoEditor 老齢福祉, IHihokenshaDaichoEditor 生活保護,
            IHihokenshaDaichoEditor 世帯左, IHihokenshaDaichoEditor 世帯右, IHihokenshaDaichoEditor 資格移動情報,
            IHihokenshaDaichoEditor 被保険者証発行履歴情報1, IHihokenshaDaichoEditor 被保険者証発行履歴情報2) {
        this.joho = joho;
        this.老齢福祉 = 老齢福祉;
        this.生活保護 = 生活保護;
        this.世帯左 = 世帯左;
        this.世帯右 = 世帯右;
        this.資格移動情報 = 資格移動情報;
        this.被保険者証発行履歴情報1 = 被保険者証発行履歴情報1;
        this.被保険者証発行履歴情報2 = 被保険者証発行履歴情報2;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link HihokenshaDaichoReportSource}
     */
    @Override
    public HihokenshaDaichoReportSource build() {
        return ReportEditorJoiner.from(new HihokenshaDaichoReportSource()).join(joho).join(老齢福祉).join(生活保護).join(世帯左).
                join(世帯右).join(資格移動情報).join(被保険者証発行履歴情報1).join(被保険者証発行履歴情報2).buildSource();
    }
}
