/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.gassanjigyobunjikofutangakukeisankekkaichiran;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.gassanjigyobunjikofutangakukeisankekkaichiran.GassanJigyobunJikofutangakuKeisanKekkaIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 *
 * 事業高額合算・事業分自己負担額計算結果一覧表のPageBreakクラスです
 *
 * @reamsid_L DBC-4790-040 jiangwenkai
 */
public class GassanJigyobunJikofutangakuKeisanKekkaIchiranPageBreak extends PageBreaker<GassanJigyobunJikofutangakuKeisanKekkaIchiranSource> {

    private final List<RString> breakKeysList;

    /**
     * breakKeysの構造方法です
     *
     * @param breakKeys ページングキー
     */
    public GassanJigyobunJikofutangakuKeisanKekkaIchiranPageBreak(List<RString> breakKeys) {
        this.breakKeysList = Collections.unmodifiableList(breakKeys);
    }

    @Override
    public List<RString> breakKeys() {
        return breakKeysList;
    }

    @Override
    public boolean isBreak(ReportLineRecord<GassanJigyobunJikofutangakuKeisanKekkaIchiranSource> currentSource,
            ReportLineRecord<GassanJigyobunJikofutangakuKeisanKekkaIchiranSource> nextSource) {
        boolean flag = false;
        if (!currentSource.getSource().kaipage1.equals(nextSource.getSource().kaipage1)) {
            flag = true;
        } else if (!currentSource.getSource().kaipage2.equals(nextSource.getSource().kaipage2)) {
            flag = true;
        } else if (!currentSource.getSource().kaipage3.equals(nextSource.getSource().kaipage3)) {
            flag = true;
        } else if (!currentSource.getSource().kaipage4.equals(nextSource.getSource().kaipage4)) {
            flag = true;
        } else if (!currentSource.getSource().kaipage5.equals(nextSource.getSource().kaipage5)) {
            flag = true;
        }
        return flag;
    }
}
