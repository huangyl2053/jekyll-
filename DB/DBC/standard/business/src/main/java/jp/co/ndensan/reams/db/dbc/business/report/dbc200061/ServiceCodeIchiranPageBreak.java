/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.dbc200061;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.report.dbc200061.ServiceCodeIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * サービスコード一覧表のPageBreakクラスです。
 *
 * @reamsid_L DBC-3310-030 chenyadong
 */
public class ServiceCodeIchiranPageBreak extends PageBreaker<ServiceCodeIchiranSource> {

    private final List<RString> breakKeysList;

    /**
     * コンストラクタです。
     *
     * @param breakKeys List<RString>
     */
    public ServiceCodeIchiranPageBreak(List<RString> breakKeys) {
        this.breakKeysList = Collections.unmodifiableList(breakKeys);
    }

    @Override
    public List<RString> breakKeys() {
        return breakKeysList;
    }

    @Override
    public boolean isBreak(ReportLineRecord<ServiceCodeIchiranSource> currentSource,
            ReportLineRecord<ServiceCodeIchiranSource> nextSource) {
        boolean flag = false;
        if (currentSource.getSource().List1_1 != null
                && !currentSource.getSource().List1_1.equals(nextSource.getSource().List1_1)) {
            flag = true;
        }
        return flag;
    }
}
