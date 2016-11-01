/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kyufukanrihyoout;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.report.source.kyufukanrihyosofuichiran.KyufuKanrihyoSofuIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 *
 * @author soft863
 */
public class KyufukanrihyoOutPageBreak extends PageBreaker<KyufuKanrihyoSofuIchiranReportSource> {

    private final List<RString> breakKeysList;

    /**
     *
     * @param breakKeys ページングキー
     */
    public KyufukanrihyoOutPageBreak(List<RString> breakKeys) {
        this.breakKeysList = Collections.unmodifiableList(breakKeys);
    }

    @Override
    public List<RString> breakKeys() {
        return breakKeysList;
    }

    @Override
    public boolean isBreak(ReportLineRecord<KyufuKanrihyoSofuIchiranReportSource> currentSource,
            ReportLineRecord<KyufuKanrihyoSofuIchiranReportSource> nextSource) {
        boolean flag = false;
        if (this.breakKeysList.contains(KyufukanrihyoOutOrder.保険者番号.get項目ID())
                && !currentSource.getSource().hokenshaNo.equals(nextSource.getSource().hokenshaNo)) {
            flag = true;
        } else if (this.breakKeysList.contains(KyufukanrihyoOutOrder.被保険者番号.get項目ID())
                && !currentSource.getSource().listUpper_4.equals(nextSource.getSource().listUpper_4)) {
            flag = true;
        } else if (this.breakKeysList.contains(KyufukanrihyoOutOrder.要介護状態区分.get項目ID())
                && !currentSource.getSource().listUpper_2.equals(nextSource.getSource().listUpper_2)) {
            flag = true;
        } else if (this.breakKeysList.contains(KyufukanrihyoOutOrder.郵便番号.get項目ID())
                && !currentSource.getSource().listUpper_6.equals(nextSource.getSource().listUpper_6)) {
            flag = true;
        }
        return flag;
    }
}
