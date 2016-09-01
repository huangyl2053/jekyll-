/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.sogojigyohishikakushogohyokeikasochi;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.report.sogojigyohishikakushogohyokeikasochi.SogojigyohiShikakuShogohyoKeikaSochiSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * 総合事業費（経過措置）資格照合表情報取込のPageBreakクラスです。
 *
 * @reamsid_L DBC-2890-011 wangxingpeng
 */
public class SogojigyohiShikakuShogohyoKeikaSochiPageBreak extends
        PageBreaker<SogojigyohiShikakuShogohyoKeikaSochiSource> {

    private final List<RString> breakKeyList;

    /**
     * コンストラクタです。
     *
     * @param breakKeys List<RString>
     */
    public SogojigyohiShikakuShogohyoKeikaSochiPageBreak(List<RString> breakKeys) {
        this.breakKeyList = Collections.unmodifiableList(breakKeys);
    }

    @Override
    public List<RString> breakKeys() {
        return breakKeyList;
    }

    @Override
    public boolean isBreak(ReportLineRecord<SogojigyohiShikakuShogohyoKeikaSochiSource> currentSource,
            ReportLineRecord<SogojigyohiShikakuShogohyoKeikaSochiSource> nextSource) {
        boolean flag = false;
        if (currentSource.getSource().hokenshaNo != null
                && !currentSource.getSource().hokenshaNo.equals(nextSource.getSource().hokenshaNo)) {
            flag = true;
        }
        return flag;
    }
}
