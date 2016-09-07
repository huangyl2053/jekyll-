/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.sogojigyohiseikyugakutsuchishokeikasochi;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.report.source.sogojigyohiseidoichiranhyosakusei.SogojigyohiSeikyugakuTsuchishoKeikaSochiSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * 総合事業費（経過措置）請求額通知書一覧表帳票のPageBreakクラスです。
 *
 * @reamsid_L DBC-2480-031 jiangxiaolong
 */
public class SogojigyohiSeikyugakuTsuchishoKeikaSochiPageBreak extends PageBreaker<SogojigyohiSeikyugakuTsuchishoKeikaSochiSource> {

    private final List<RString> breakKeysList;

    /**
     *
     * @param breakKeys ページングキー
     */
    public SogojigyohiSeikyugakuTsuchishoKeikaSochiPageBreak(List<RString> breakKeys) {
        this.breakKeysList = Collections.unmodifiableList(breakKeys);
    }

    @Override
    public List<RString> breakKeys() {
        return breakKeysList;
    }

    @Override
    public boolean isBreak(ReportLineRecord<SogojigyohiSeikyugakuTsuchishoKeikaSochiSource> currentSource,
            ReportLineRecord<SogojigyohiSeikyugakuTsuchishoKeikaSochiSource> nextSource) {
        boolean flag = false;
        if (!currentSource.getSource().shoKisaiHokenshaNo.equals(nextSource.getSource().shoKisaiHokenshaNo)) {
            flag = true;
        } else if (!currentSource.getSource().kanCode.equals(nextSource.getSource().kanCode)) {
            flag = true;
        } else if (!currentSource.getSource().kouCode.equals(nextSource.getSource().kouCode)) {
            flag = true;
        }
        return flag;
    }
}
