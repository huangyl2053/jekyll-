/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.hihokenshadaicho;

import jp.co.ndensan.reams.db.dba.business.core.hihokenshadaichosakusei.HihokenshaDaichoSakusei;
import jp.co.ndensan.reams.db.dba.entity.db.hihokenshadaichosakusei.SetaiLeftEntity;
import jp.co.ndensan.reams.db.dba.entity.report.hihokenshadaicho.HihokenshaDaichoReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 被保険者台帳_老齢福祉Editorです。
 *
 * @reamsid_L DBA-0500-040 zuotao
 */
public class HihokenshaDaichoSetaiLeftEditor implements IHihokenshaDaichoEditor {

    private final HihokenshaDaichoSakusei joho;
    private final int index;
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int THREE = 3;
    private static final int FOUR = 4;

    /**
     * コンストラクタです。
     *
     * @param joho 被保険者台帳
     * @param index Index
     */
    public HihokenshaDaichoSetaiLeftEditor(HihokenshaDaichoSakusei joho, int index) {
        this.joho = joho;
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
        if (joho.get世帯左情報() == null || joho.get世帯左情報().get世帯左No().size() < index) {
            return source;
        }
        return editBody(source);
    }

    private HihokenshaDaichoReportSource editBody(HihokenshaDaichoReportSource source) {
        SetaiLeftEntity 世帯左情報 = joho.get世帯左情報();
        source.listSetaiLeft_1 = 世帯左情報.get世帯左No().get(index);
        source.listSetaiLeft_2 = 世帯左情報.get世帯左識別コード().get(index) == null
                ? RString.EMPTY : 世帯左情報.get世帯左識別コード().get(index).value();
        if (index == ZERO) {
            source.setaiinShimei1 = joho.get世帯氏名1();
        } else if (index == ONE) {
            source.setaiinShimei2 = joho.get世帯氏名2();
        } else if (index == TWO) {
            source.setaiinShimei3 = joho.get世帯氏名3();
        } else if (index == THREE) {
            source.setaiinShimei4 = joho.get世帯氏名4();
        } else if (index == FOUR) {
            source.setaiinShimei5 = joho.get世帯氏名5();
        }
        return source;
    }
}
