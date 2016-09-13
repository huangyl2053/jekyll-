/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.sogojigyohiseikyugakutsuchishokohi;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.report.source.sogojigyohiseikyugakutsuchishokohi.SogojigyohiSeikyugakuTsuchishoKohiSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * 総合事業費等請求額通知書（公費負担者分）のPageBreakクラスです。
 *
 * @reamsid_L DBC-4700-030 qinzhen
 */
public class SogojigyohiSeikyugakuTsuchishoKohiPageBreak
        extends PageBreaker<SogojigyohiSeikyugakuTsuchishoKohiSource> {

    private final List<RString> breakKeysList;

    /**
     * コンストラクタです。
     *
     * @param breakKeys ページングキー
     */
    public SogojigyohiSeikyugakuTsuchishoKohiPageBreak(List<RString> breakKeys) {
        this.breakKeysList = Collections.unmodifiableList(breakKeys);
    }

    @Override
    public List<RString> breakKeys() {
        return breakKeysList;
    }

    @Override
    public boolean isBreak(ReportLineRecord<SogojigyohiSeikyugakuTsuchishoKohiSource> currentSource,
            ReportLineRecord<SogojigyohiSeikyugakuTsuchishoKohiSource> nextSource) {
        boolean flag = false;
        if (!currentSource.getSource().kohiFutanshaNo.equals(nextSource.getSource().kohiFutanshaNo)) {
            flag = true;
        } else if (!currentSource.getSource().kanCode.equals(nextSource.getSource().kanCode)) {
            flag = true;
        } else if (!currentSource.getSource().kouCode.equals(nextSource.getSource().kouCode)) {
            flag = true;
        }
        return flag;
    }
}
