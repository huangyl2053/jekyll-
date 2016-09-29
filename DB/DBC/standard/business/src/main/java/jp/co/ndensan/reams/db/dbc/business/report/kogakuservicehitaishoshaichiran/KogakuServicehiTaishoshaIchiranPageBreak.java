/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakuservicehitaishoshaichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.report.kogakuservicehitaishoshaichiran.KogakuServicehiTaishoshaIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * 高額介護サービス費対象者一覧表PageBreak
 *
 * @reamsid_L DBC-2010-040 chenaoqi
 */
public class KogakuServicehiTaishoshaIchiranPageBreak extends PageBreaker<KogakuServicehiTaishoshaIchiranSource> {

    private final List<RString> breakKeysList;

    /**
     *
     * @param breakKeys List<RString>
     */
    public KogakuServicehiTaishoshaIchiranPageBreak(List<RString> breakKeys) {
        this.breakKeysList = breakKeys;
    }

    @Override
    public List<RString> breakKeys() {
        return breakKeysList;
    }

    @Override
    public boolean isBreak(ReportLineRecord<KogakuServicehiTaishoshaIchiranSource> currentSource,
            ReportLineRecord<KogakuServicehiTaishoshaIchiranSource> nextSource) {
        boolean flg = false;
        if (this.breakKeysList.contains(KogakuServicehiTaishoshaIchiranOutput.BreakerFieldsEnum.被保険者番号.get項目ID())
                && !currentSource.getSource().listTaishosha_2.equals(nextSource.getSource().listTaishosha_2)) {
            flg = true;
        } else if (this.breakKeysList.contains(KogakuServicehiTaishoshaIchiranOutput.BreakerFieldsEnum.サービス年月.get項目ID())
                && !currentSource.getSource().listTaishosha_3.equals(nextSource.getSource().listTaishosha_3)) {
            flg = true;
        } else if (this.breakKeysList.contains(KogakuServicehiTaishoshaIchiranOutput.BreakerFieldsEnum.要介護度.get項目ID())
                && !currentSource.getSource().listTaishosha_6.equals(nextSource.getSource().listTaishosha_6)) {
            flg = true;
        }
        return flg;
    }

}
