/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD206010;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd200017.JigyoshoMukeShakaiFukushiHojinKeigenReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * 改ページ条件。
 *
 * @reamsid_L DBD-3810-030 liuwei2
 */
public class TyohyoShutuyukuSourcePageBreak extends PageBreaker<JigyoshoMukeShakaiFukushiHojinKeigenReportSource> {

    private final List<RString> keyLists;

    /**
     *
     * @param pageBreakKeys ページングキー
     */
    public TyohyoShutuyukuSourcePageBreak(List<RString> pageBreakKeys) {
        this.keyLists = Collections.unmodifiableList(pageBreakKeys);
    }

    @Override
    public List<RString> breakKeys() {
        return keyLists;
    }

    @Override
    public boolean isBreak(ReportLineRecord<JigyoshoMukeShakaiFukushiHojinKeigenReportSource> currentSource,
            ReportLineRecord<JigyoshoMukeShakaiFukushiHojinKeigenReportSource> nextSource) {
        boolean flag = false;
        if (super.isBreak(currentSource, nextSource) || (nextSource.getSource().hokenshaNo != null && nextSource.getSource().jigyoshaCd != null
                && 0 < (Long.valueOf(nextSource.getSource().jigyoshaCd.toString())
                - Long.valueOf(nextSource.getSource().hokenshaNo.toString())))) {
            flag = true;
        }
        return flag;
    }
}
