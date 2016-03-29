/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kogakukyufutaishoshain;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.report.source.kogakukyufutaishoshaichiran.KogakuKyufuTaishoshaIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 *
 * 高額介護サービス費給付対象者取込みPageBreak
 */
public class KogakuKyufuTaishoshaInPageBreak extends PageBreaker<KogakuKyufuTaishoshaIchiranSource> {

    private final List<RString> breakKeys;
    private ReportLineRecord<KogakuKyufuTaishoshaIchiranSource> nowSource;

    /**
     *
     * @param breakKeys breakKeys
     */
    public KogakuKyufuTaishoshaInPageBreak(List<RString> breakKeys) {
        this.breakKeys = new ArrayList<>();
        this.breakKeys.addAll(breakKeys);
    }

    @Override
    public List<RString> breakKeys() {
        return breakKeys;
    }

    @Override
    public boolean isBreak(ReportLineRecord<KogakuKyufuTaishoshaIchiranSource> currentSource,
            ReportLineRecord<KogakuKyufuTaishoshaIchiranSource> nextSource) {
        if (!currentSource.getSource().hokenshaNo.equals(nextSource.getSource().hokenshaNo)) {
            return true;
        }
        if (null == nowSource) {
            nowSource = currentSource;
        } else if (!currentSource.getSource().listUpper_2.isEmpty()
                && !nowSource.getSource().listUpper_2.equals(currentSource.getSource().listUpper_2)) {
            nowSource = currentSource;
        }
        if (null == breakKeys || breakKeys.isEmpty()) {
            return false;
        } else if (KogakuKyufuTaishoshaInOutPutOrder.被保険者番号.get項目ID().equals(breakKeys.get(0))) {
            if (!nowSource.getSource().listUpper_2.equals(nextSource.getSource().listUpper_2)
                    && !nextSource.getSource().listUpper_2.isEmpty()) {
                return true;
            }
        }
        return false;
    }

}
