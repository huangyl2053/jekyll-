/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.shokanfushikyuketteiin;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.report.source.shokanfushikyuketteiin.ShokanbaraiFushikyuKetteishaIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * 償還払不支給決定情報取込みPageBreak
 *
 * @reamsid_L DBC-2590-010 xuhao
 */
public class ShokanFushikyuKetteiInPageBreak extends PageBreaker<ShokanbaraiFushikyuKetteishaIchiranSource> {

    private final List<RString> breakKeysList;

    /**
     *
     * @param breakKeys ページングキー
     */
    public ShokanFushikyuKetteiInPageBreak(List<RString> breakKeys) {
        this.breakKeysList = Collections.unmodifiableList(breakKeys);
    }

    @Override
    public List<RString> breakKeys() {
        return breakKeysList;
    }

    @Override
    public boolean isBreak(ReportLineRecord<ShokanbaraiFushikyuKetteishaIchiranSource> currentSource,
            ReportLineRecord<ShokanbaraiFushikyuKetteishaIchiranSource> nextSource) {
        boolean flag = !currentSource.getSource().shoKisaiHokenshaNo.equals(nextSource.getSource().shoKisaiHokenshaNo);
        if (!flag && this.breakKeysList.contains(ShokanFushikyuKetteiInOutPutOrder.被保険者番号.get項目ID())) {
            flag = !currentSource.getSource().listUpper_2.equals(nextSource.getSource().listUpper_2);
        }
        return flag;
    }

}
