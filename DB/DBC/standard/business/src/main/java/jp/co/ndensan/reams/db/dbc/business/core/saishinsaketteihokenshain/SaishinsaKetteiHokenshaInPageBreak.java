/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.saishinsaketteihokenshain;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.report.source.saishinsaketteihokenshain.SaishinsaKetteitsuchishoTorikomiIchiranHokenshaBunSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * 再審査決定通知書情報取込PageBreak
 *
 * @reamsid_L DBC-2520-010 chenaoqi
 */
public class SaishinsaKetteiHokenshaInPageBreak extends PageBreaker<SaishinsaKetteitsuchishoTorikomiIchiranHokenshaBunSource> {

    private final List<RString> breakKeysList;

    /**
     *
     * @param breakKeys ページングキー
     */
    public SaishinsaKetteiHokenshaInPageBreak(List<RString> breakKeys) {
        this.breakKeysList = Collections.unmodifiableList(breakKeys);
    }

    @Override
    public List<RString> breakKeys() {
        return breakKeysList;
    }

    @Override
    public boolean isBreak(ReportLineRecord<SaishinsaKetteitsuchishoTorikomiIchiranHokenshaBunSource> currentSource,
            ReportLineRecord<SaishinsaKetteitsuchishoTorikomiIchiranHokenshaBunSource> nextSource) {
        boolean flag = false;
        if (!flag && this.breakKeysList.contains(SaishinsaKetteiHokenshaInOutPutOrder.被保険者番号.get項目ID())) {
            flag = !currentSource.getSource().listUpper_2.equals(nextSource.getSource().listUpper_2);
        }
        return flag;
    }
}
