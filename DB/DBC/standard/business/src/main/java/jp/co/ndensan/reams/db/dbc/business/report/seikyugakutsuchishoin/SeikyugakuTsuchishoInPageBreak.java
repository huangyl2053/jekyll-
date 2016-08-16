/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.seikyugakutsuchishoin;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.seikyugakutsuchishoin.SeikyugakuTsuchishoSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * 介護給付費等請求額通知書一覧表帳票のPageBreakクラスです。
 *
 * @reamsid_L DBC-2480-030 jiangwenkai
 */
public class SeikyugakuTsuchishoInPageBreak extends PageBreaker<SeikyugakuTsuchishoSource> {

    private final List<RString> breakKeysList;

    /**
     * breakKeysの構造方法です
     *
     * @param breakKeys ページングキー
     */
    public SeikyugakuTsuchishoInPageBreak(List<RString> breakKeys) {
        this.breakKeysList = Collections.unmodifiableList(breakKeys);
    }

    @Override
    public List<RString> breakKeys() {
        return breakKeysList;
    }

    @Override
    public boolean isBreak(ReportLineRecord<SeikyugakuTsuchishoSource> currentSource,
            ReportLineRecord<SeikyugakuTsuchishoSource> nextSource) {
        boolean flag = false;
        if (!currentSource.getSource().shoKisaiHokenshaNo.equals(nextSource.getSource().shoKisaiHokenshaNo)) {
            flag = true;
            // TODO QA 内部番号 1241
        } else if (!currentSource.getSource().kanName.equals(nextSource.getSource().kanName)) {
            flag = true;
        } else if (!currentSource.getSource().kouName.equals(nextSource.getSource().kouName)) {
            flag = true;
        }
        return flag;
    }
}
