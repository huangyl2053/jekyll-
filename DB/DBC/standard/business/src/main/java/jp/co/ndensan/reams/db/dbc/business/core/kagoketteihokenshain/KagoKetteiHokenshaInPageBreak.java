/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kagoketteihokenshain;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.report.source.kagoketteitbun.KagoKetteitsuchishoTorikomiIchiranHokenshaBunSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * 過誤決定通知書情報取込（保険者分）PageBreak
 *
 * @reamsid_L DBC-0980-300 xupeng
 */
public class KagoKetteiHokenshaInPageBreak extends PageBreaker<KagoKetteitsuchishoTorikomiIchiranHokenshaBunSource> {

    private final List<RString> breakKeysList;

    /**
     *
     * @param breakKeys ページングキー
     */
    public KagoKetteiHokenshaInPageBreak(List<RString> breakKeys) {
        this.breakKeysList = Collections.unmodifiableList(breakKeys);
    }

    @Override
    public List<RString> breakKeys() {
        return breakKeysList;
    }

    @Override
    public boolean isBreak(ReportLineRecord<KagoKetteitsuchishoTorikomiIchiranHokenshaBunSource> currentSource,
            ReportLineRecord<KagoKetteitsuchishoTorikomiIchiranHokenshaBunSource> nextSource) {
        boolean flag = false;
        if (!flag && this.breakKeysList.contains(KagoKetteiHokenshaInOutPutOrder.被保険者番号.get項目ID())) {
            flag = !currentSource.getSource().listLower1_1.equals(nextSource.getSource().listLower1_1);
        }
        if (!flag && this.breakKeysList.contains(KagoKetteiHokenshaInOutPutOrder.事業者番号.get項目ID())) {
            flag = !currentSource.getSource().listUpper_3.equals(nextSource.getSource().listUpper_3);
        }
        return flag;
    }

}
