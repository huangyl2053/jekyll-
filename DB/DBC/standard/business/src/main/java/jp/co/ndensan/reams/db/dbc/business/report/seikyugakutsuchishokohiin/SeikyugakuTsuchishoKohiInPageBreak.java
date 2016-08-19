/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.seikyugakutsuchishokohiin;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.report.seikyugakutsuchishokohifutanshabun.SeikyugakuTsuchishoKohifutanshabunSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * バッチ設計_DBCMNF2002-631_介護給付費等請求額通知書情報（公費）取込のPageBreak
 *
 * @reamsid_L DBC-2790-010 surun
 */
public class SeikyugakuTsuchishoKohiInPageBreak extends PageBreaker<SeikyugakuTsuchishoKohifutanshabunSource> {

    private final List<RString> breakKeysList = Collections.unmodifiableList(Arrays.asList(
            new RString(SeikyugakuTsuchishoKohifutanshabunSource.DBC200067SeikyugakuTsuchishoKohifutanshabunFields.kohiFutanshaNo.name()),
            new RString(SeikyugakuTsuchishoKohifutanshabunSource.DBC200067SeikyugakuTsuchishoKohifutanshabunFields.kanName.name()),
            new RString(SeikyugakuTsuchishoKohifutanshabunSource.DBC200067SeikyugakuTsuchishoKohifutanshabunFields.kouName.name())
    ));

    @Override
    public List<RString> breakKeys() {
        return breakKeysList;
    }

    /**
     * isBreak
     *
     * @param currentSource ReportLineRecord<SeikyugakuTsuchishoKohifutanshabunSource>
     * @param nextSource ReportLineRecord<SeikyugakuTsuchishoKohifutanshabunSource>
     * @return boolean
     */
    @Override
    public boolean isBreak(ReportLineRecord<SeikyugakuTsuchishoKohifutanshabunSource> currentSource,
            ReportLineRecord<SeikyugakuTsuchishoKohifutanshabunSource> nextSource) {
        boolean flag = false;
        if (!currentSource.getSource().kohiFutanshaNo.equals(nextSource.getSource().kohiFutanshaNo)
                || !currentSource.getSource().kanName.equals(nextSource.getSource().kanName)
                || !currentSource.getSource().kouName.equals(nextSource.getSource().kouName)) {
            flag = true;
        }
        return flag;
    }

}
