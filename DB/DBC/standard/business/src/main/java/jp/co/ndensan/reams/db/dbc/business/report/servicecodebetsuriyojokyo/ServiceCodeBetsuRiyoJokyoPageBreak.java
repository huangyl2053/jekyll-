/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.servicecodebetsuriyojokyo;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.report.source.servicecodebetsuriyojokyo.ServiceCodeBetsuRiyoJokyoSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * サービスコード別利用状況作成PageBreakクラスです。
 *
 * @reamsid_L DBC-3340-030 jiangxiaolong
 */
public class ServiceCodeBetsuRiyoJokyoPageBreak extends PageBreaker<ServiceCodeBetsuRiyoJokyoSource> {

    private final List<RString> breakKeysList;

    /**
     *
     * @param breakKeys ページングキー
     */
    public ServiceCodeBetsuRiyoJokyoPageBreak(List<RString> breakKeys) {
        this.breakKeysList = Collections.unmodifiableList(breakKeys);
    }

    @Override
    public List<RString> breakKeys() {
        return breakKeysList;
    }

    @Override
    public boolean isBreak(ReportLineRecord<ServiceCodeBetsuRiyoJokyoSource> currentSource,
            ReportLineRecord<ServiceCodeBetsuRiyoJokyoSource> nextSource) {
        return !currentSource.getSource().List1_1.equals(nextSource.getSource().List1_1);
    }
}
