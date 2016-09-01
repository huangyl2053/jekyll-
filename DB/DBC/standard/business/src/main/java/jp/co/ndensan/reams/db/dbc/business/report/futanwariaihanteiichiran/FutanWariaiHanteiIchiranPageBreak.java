/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.futanwariaihanteiichiran;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.report.futanwariaihanteiichiran.FutanWariaiHanteiIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * 改頁クラスです。
 *
 * @reamsid_L DBC-4980-040 yuanzhenxia
 */
public class FutanWariaiHanteiIchiranPageBreak extends PageBreaker<FutanWariaiHanteiIchiranSource> {

    private final List<RString> keys;

    /**
     * 指定されたキーのリストを確定します。
     *
     * @param keys キーリスト
     */
    public FutanWariaiHanteiIchiranPageBreak(List<RString> keys) {
        this.keys = Collections.unmodifiableList(keys);
    }

    @Override
    public List<RString> breakKeys() {
        return this.keys;
    }

    @Override
    public boolean isBreak(ReportLineRecord<FutanWariaiHanteiIchiranSource> currentRecord,
            ReportLineRecord<FutanWariaiHanteiIchiranSource> nextRecord) {
        boolean flag = true;
        if (currentRecord.getSource().nendo.equals(nextRecord.getSource().nendo)) {
            flag = false;
        }
        return flag;
    }
}
