/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.hihokenshadaicho;

import jp.co.ndensan.reams.db.dba.entity.db.relate.hihokenshadaichosakusei.RoreiFukushiNenkinJukyushaDivisionEntity;
import jp.co.ndensan.reams.db.dba.entity.report.hihokenshadaicho.HihokenshaDaichoReportSource;

/**
 * 被保険者台帳_老齢福祉Editorです。
 *
 * @reamsid_L DBA-0500-040 zuotao
 */
public class HihokenshaDaichoRoreiFukushiEditor implements IHihokenshaDaichoEditor {

    private final RoreiFukushiNenkinJukyushaDivisionEntity entity;
    private final int index;

    /**
     * コンストラクタです。
     *
     * @param entity 老齢福祉のエンティティクラス
     * @param index Index
     */
    public HihokenshaDaichoRoreiFukushiEditor(RoreiFukushiNenkinJukyushaDivisionEntity entity, int index) {
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
        if (entity == null || HihokenshaDaichoEditor.getMaxIndex(entity.get老齢福祉No()) <= index) {
            return source;
        }
        return editBody(source);
    }

    private HihokenshaDaichoReportSource editBody(HihokenshaDaichoReportSource source) {
        source.listRoreiFukushi_1 = entity.get老齢福祉No().get(index);
        source.listRoreiFukushi_2 = HihokenshaDaichoEditor.getIndexValue(entity.get老齢福祉受給開始日(), index);
        source.listRoreiFukushi_3 = HihokenshaDaichoEditor.getIndexValue(entity.get老齢福祉受給終了日(), index);
        return source;
    }
}
