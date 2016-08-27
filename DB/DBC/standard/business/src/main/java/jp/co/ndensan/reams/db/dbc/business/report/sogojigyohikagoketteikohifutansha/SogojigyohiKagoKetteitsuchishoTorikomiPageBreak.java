/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.sogojigyohikagoketteikohifutansha;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.report.source.sogojigyohikagoketteikohifutansha.SogojigyohiKagoKetteitsuchishoTorikomiIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * 総合事業費過誤決定通知書情報取込（公費負担者分）一覧表帳票のPageBreakクラスです。
 *
 * @reamsid_L DBC-2810-030 chenjie
 */
public class SogojigyohiKagoKetteitsuchishoTorikomiPageBreak extends PageBreaker<SogojigyohiKagoKetteitsuchishoTorikomiIchiranSource> {

    private final List<RString> breakKeysList;

    /**
     *
     * @param breakKeys ページングキー
     */
    public SogojigyohiKagoKetteitsuchishoTorikomiPageBreak(List<RString> breakKeys) {
        this.breakKeysList = Collections.unmodifiableList(breakKeys);
    }

    @Override
    public List<RString> breakKeys() {
        return breakKeysList;
    }

    @Override
    public boolean isBreak(ReportLineRecord<SogojigyohiKagoKetteitsuchishoTorikomiIchiranSource> currentSource,
            ReportLineRecord<SogojigyohiKagoKetteitsuchishoTorikomiIchiranSource> nextSource) {
        boolean flag = false;
        if (this.breakKeysList.contains(SogojigyohiKagoKetteitsuchishoTorikomiOutPutOrder.公費負担者番号.get項目ID())
                && !currentSource.getSource().kohiFutanshaNo.equals(nextSource.getSource().kohiFutanshaNo)) {
            flag = true;
        }
        return flag;
    }

}
