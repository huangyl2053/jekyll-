/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kagoketteitbun;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.report.source.kagoketteitbun.KagoKetteitsuchishoTorikomiIchiranHokenshaBunSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * 過誤決定通知書情報取込一覧表（保険者分）帳票PageBreakです。
 *
 * @reamsid_L DBC-0980-470 lijunjun
 */
public class KagoKetteitsuchishoTorikomiIchiranHokenshaBunPageBreak
        extends PageBreaker<KagoKetteitsuchishoTorikomiIchiranHokenshaBunSource> {

    private final List<RString> breakKeysList;

    /**
     *
     * @param breakKeys ページングキー
     */
    public KagoKetteitsuchishoTorikomiIchiranHokenshaBunPageBreak(List<RString> breakKeys) {
        this.breakKeysList = Collections.unmodifiableList(breakKeys);
    }

    @Override
    public List<RString> breakKeys() {
        return breakKeysList;
    }

    @Override
    public boolean isBreak(ReportLineRecord<KagoKetteitsuchishoTorikomiIchiranHokenshaBunSource> currentSource,
            ReportLineRecord<KagoKetteitsuchishoTorikomiIchiranHokenshaBunSource> nextSource) {
        return !currentSource.getSource().shoKisaiHokenshaNo.equals(nextSource.getSource().shoKisaiHokenshaNo);
    }
}
