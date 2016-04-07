/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.hihokenshadaicho;

import jp.co.ndensan.reams.db.dba.entity.db.hihokenshadaichosakusei.SeikatsuHogoJukyushaDivisionEntity;
import jp.co.ndensan.reams.db.dba.entity.report.hihokenshadaicho.HihokenshaDaichoReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;

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
        if (entity == null || entity.get生活保護No().size() < index) {
            return source;
        }
        return editBody(source);
    }

    private HihokenshaDaichoReportSource editBody(HihokenshaDaichoReportSource source) {
        source.listSeikatsuhogo_1 = entity.get生活保護No().get(index);
        source.listSeikatsuhogo_2 = entity.get受給開始日().get(index) == null
                ? RString.EMPTY : new RString(entity.get受給開始日().get(index).toString());
        source.listSeikatsuhogo_3 = entity.get受給廃止日().get(index) == null
                ? RString.EMPTY : new RString(entity.get受給廃止日().get(index).toString());
        source.listSeikatsuhogo_4 = entity.get全額停止開始日().get(index) == null
                ? RString.EMPTY : new RString(entity.get全額停止開始日().get(index).toString());
        source.listSeikatsuhogo_5 = entity.get全額停止終了日().get(index) == null
                ? RString.EMPTY : new RString(entity.get全額停止終了日().get(index).toString());
        source.listSeikatsuhogo_6 = entity.get扶助種類().get(index);
        return source;
    }
}
