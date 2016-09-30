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
 * 高額介護サービス費給付対象者取込みPageBreak
 *
 * @reamsid_L DBC-0980-360 chenaoqi
 */
public class KogakuKyufuTaishoshaInPageBreak extends PageBreaker<KogakuKyufuTaishoshaIchiranSource> {

    private final List<RString> breakKeysList;
    private ReportLineRecord<KogakuKyufuTaishoshaIchiranSource> nowSource;

    /**
     *
     * @param breakKeys breakKeys
     */
    public KogakuKyufuTaishoshaInPageBreak(List<RString> breakKeys) {
        this.breakKeysList = new ArrayList<>();
        this.breakKeysList.addAll(breakKeys);
    }

    @Override
    public List<RString> breakKeys() {
        return breakKeysList;
    }

    @Override
    public boolean isBreak(ReportLineRecord<KogakuKyufuTaishoshaIchiranSource> currentSource,
            ReportLineRecord<KogakuKyufuTaishoshaIchiranSource> nextSource) {
        if (!currentSource.getSource().shoKisaiHokenshaNo.equals(nextSource.getSource().shoKisaiHokenshaNo)) {
            return true;
        }
        if (null == nowSource) {
            nowSource = currentSource;
        } else if (!currentSource.getSource().listUpper_2.isEmpty()
                && !nowSource.getSource().listUpper_2.equals(currentSource.getSource().listUpper_2)) {
            nowSource = currentSource;
        }
        if (null == breakKeysList || breakKeysList.isEmpty()) {
            return false;
        } else if (KogakuKyufuTaishoshaInOutPutOrder.被保険者番号.get項目ID().equals(breakKeysList.get(0))
                && !nowSource.getSource().listUpper_2.equals(nextSource.getSource().listUpper_2)
                && !nextSource.getSource().listUpper_2.isEmpty()) {
            return true;
        }
        return false;
    }

}
