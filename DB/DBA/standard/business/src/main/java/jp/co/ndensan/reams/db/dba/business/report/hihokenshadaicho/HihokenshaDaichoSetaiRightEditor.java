/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.hihokenshadaicho;

import jp.co.ndensan.reams.db.dba.entity.db.relate.hihokenshadaichosakusei.SetaiRightEntity;
import jp.co.ndensan.reams.db.dba.entity.report.hihokenshadaicho.HihokenshaDaichoReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 被保険者台帳_老齢福祉Editorです。
 *
 * @reamsid_L DBA-0500-040 zuotao
 */
public class HihokenshaDaichoSetaiRightEditor implements IHihokenshaDaichoEditor {

    private final SetaiRightEntity entity;
    private final int index;

    /**
     * コンストラクタです。
     *
     * @param entity 世帯右情報
     * @param index Index
     */
    public HihokenshaDaichoSetaiRightEditor(SetaiRightEntity entity, int index) {
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
        if (entity == null || entity.get世帯右被保険者番号() == null
                || entity.get世帯右被保険者番号().isEmpty() || entity.get世帯右被保険者番号().size() <= index) {
            return source;
        }
        return editBody(source);
    }

    private HihokenshaDaichoReportSource editBody(HihokenshaDaichoReportSource source) {
        source.listSetaiRight_1 = HihokenshaDaichoEditor.getIndexValue(entity.get世帯右性別(), index);
        source.listSetaiRight_2 = HihokenshaDaichoEditor.getIndexValue(entity.get世帯右生年月日(), index);
        source.listSetaiRight_3 = HihokenshaDaichoEditor.getIndexValue(entity.get世帯右続柄(), index);
        source.listSetaiRight_4 = entity.get世帯右被保険者番号().isEmpty() || entity.get世帯右被保険者番号().get(index) == null
                ? RString.EMPTY : entity.get世帯右被保険者番号().get(index).value();
        return source;
    }
}
