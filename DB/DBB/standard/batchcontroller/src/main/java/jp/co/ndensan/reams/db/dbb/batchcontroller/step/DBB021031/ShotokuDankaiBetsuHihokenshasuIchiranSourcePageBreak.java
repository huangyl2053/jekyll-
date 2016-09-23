/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB021031;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.entity.report.shotokudankaibetsuhihokenshasuichiran.ShotokuDankaiBetsuHihokenshasuIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * 改ページ条件。
 *
 * @reamsid_L DBB-1820-040 dingminghao
 */
public class ShotokuDankaiBetsuHihokenshasuIchiranSourcePageBreak extends PageBreaker<ShotokuDankaiBetsuHihokenshasuIchiranSource> {

    private final List<RString> breakKeysList;

    /**
     *
     * @param breakKeys ページングキー
     */
    public ShotokuDankaiBetsuHihokenshasuIchiranSourcePageBreak(List<RString> breakKeys) {
        this.breakKeysList = Collections.unmodifiableList(breakKeys);
    }

    @Override
    public List<RString> breakKeys() {
        return breakKeysList;
    }

    @Override
    public boolean isBreak(ReportLineRecord<ShotokuDankaiBetsuHihokenshasuIchiranSource> currentSource,
            ReportLineRecord<ShotokuDankaiBetsuHihokenshasuIchiranSource> nextSource) {
        boolean flag = false;
        if (!currentSource.getSource().hokenshaNo.equals(nextSource.getSource().hokenshaNo)) {
            flag = true;
        }
        return flag;
    }
}
