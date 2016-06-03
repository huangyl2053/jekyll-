/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.hihokenshadaicho;

import jp.co.ndensan.reams.db.dba.entity.db.relate.hihokenshadaichosakusei.ShoKofuKaishuDivisionSumEntity;
import jp.co.ndensan.reams.db.dba.entity.report.hihokenshadaicho.HihokenshaDaichoReportSource;

/**
 * 被保険者台帳_被保険者証発行履歴情報Editorです。
 *
 * @reamsid_L DBA-0500-040 zuotao
 */
public class HihokenshaDaichoShoRireki1Editor implements IHihokenshaDaichoEditor {

    private final ShoKofuKaishuDivisionSumEntity entity;
    private final int index;

    /**
     * コンストラクタです。
     *
     * @param entity 被保険者証発行履歴情報のエンティティクラス
     * @param index Index
     */
    public HihokenshaDaichoShoRireki1Editor(ShoKofuKaishuDivisionSumEntity entity, int index) {
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
        if (entity == null || HihokenshaDaichoEditor.getMaxIndex(entity.get証履歴No1()) <= index) {
            return source;
        }
        return editBody(source);
    }

    private HihokenshaDaichoReportSource editBody(HihokenshaDaichoReportSource source) {
        source.listShoRireki1_1 = entity.get証履歴No1().get(index);
        source.listShoRireki1_2 = HihokenshaDaichoEditor.getIndexValue(entity.get証履歴発行日1(), index);
        source.listShoRireki1_3 = HihokenshaDaichoEditor.getIndexValue(entity.get証履歴事由名称1(), index);
        source.listShoRireki1_4 = HihokenshaDaichoEditor.getIndexValue(entity.get証履歴回収日1(), index);
        return source;
    }
}
