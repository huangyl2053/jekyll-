/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.shokanfushikyuketteiin;

import java.util.ArrayList;
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
    private ReportLineRecord<ShokanbaraiFushikyuKetteishaIchiranSource> nowSource;

    /**
     *
     * @param breakKeys ページングキー
     */
    public ShokanFushikyuKetteiInPageBreak(List<RString> breakKeys) {
        this.breakKeysList = new ArrayList<>();
        this.breakKeysList.addAll(breakKeys);
    }

    @Override
    public List<RString> breakKeys() {
        return breakKeysList;
    }

    @Override
    public boolean isBreak(ReportLineRecord<ShokanbaraiFushikyuKetteishaIchiranSource> currentSource,
            ReportLineRecord<ShokanbaraiFushikyuKetteishaIchiranSource> nextSource) {
        return !currentSource.getSource().hokenshaNo.equals(nextSource.getSource().hokenshaNo);
    }

}
