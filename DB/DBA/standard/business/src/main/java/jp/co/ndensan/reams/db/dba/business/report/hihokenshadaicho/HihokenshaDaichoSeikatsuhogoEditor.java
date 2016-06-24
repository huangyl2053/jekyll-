/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.hihokenshadaicho;

import jp.co.ndensan.reams.db.dbz.entity.db.relate.hihokenshadaichosakusei.SeikatsuHogoJukyushaDivisionEntity;
import jp.co.ndensan.reams.db.dba.entity.report.hihokenshadaicho.HihokenshaDaichoReportSource;

/**
 * 被保険者台帳_生活保護Editorです。
 *
 * @reamsid_L DBA-0500-040 zuotao
 */
public class HihokenshaDaichoSeikatsuhogoEditor implements IHihokenshaDaichoEditor {

    private final SeikatsuHogoJukyushaDivisionEntity entity;
    private final int index;

    /**
     * コンストラクタです。
     *
     * @param entity 生活保護のエンティティクラス
     * @param index Index
     */
    public HihokenshaDaichoSeikatsuhogoEditor(SeikatsuHogoJukyushaDivisionEntity entity, int index) {
        this.entity = entity;
        this.index = index;
    }

    /**
     * 被保険者台帳ReportSourceを作成します。
     *
     * @param source 被保険者台帳ReportSource
     * @return 被保険者台帳ReportSource
     */
    @Override
    public HihokenshaDaichoReportSource edit(HihokenshaDaichoReportSource source) {
        if (entity == null || HihokenshaDaichoEditor.getMaxIndex(entity.get生活保護No()) <= index) {
            return source;
        }
        return editBody(source);
    }

    private HihokenshaDaichoReportSource editBody(HihokenshaDaichoReportSource source) {
        source.listSeikatsuhogo_1 = entity.get生活保護No().get(index);
        source.listSeikatsuhogo_2 = HihokenshaDaichoEditor.getIndexValue(entity.get受給開始日(), index);
        source.listSeikatsuhogo_3 = HihokenshaDaichoEditor.getIndexValue(entity.get受給廃止日(), index);
        source.listSeikatsuhogo_4 = HihokenshaDaichoEditor.getIndexValue(entity.get全額停止開始日(), index);
        source.listSeikatsuhogo_5 = HihokenshaDaichoEditor.getIndexValue(entity.get全額停止終了日(), index);
        source.listSeikatsuhogo_6 = HihokenshaDaichoEditor.getIndexValue(entity.get扶助種類(), index);
        return source;
    }
}
