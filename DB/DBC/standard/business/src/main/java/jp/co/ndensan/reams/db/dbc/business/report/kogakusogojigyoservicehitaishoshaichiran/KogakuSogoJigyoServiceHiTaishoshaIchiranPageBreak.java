/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakusogojigyoservicehitaishoshaichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.report.kogakusogojigyoservicehitaishoshaichiran.KogakuSogoJigyoServiceHiTaishoshaIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * 高額総合事業サービス費対象者一覧表PageBreak
 *
 * @reamsid_L DBC-2010-040 chenaoqi
 */
public class KogakuSogoJigyoServiceHiTaishoshaIchiranPageBreak extends PageBreaker<KogakuSogoJigyoServiceHiTaishoshaIchiranSource> {

    private final List<RString> breakKeysList;

    /**
     *
     * @param breakKeys List<RString>
     */
    public KogakuSogoJigyoServiceHiTaishoshaIchiranPageBreak(List<RString> breakKeys) {
        this.breakKeysList = breakKeys;
    }

    @Override
    public List<RString> breakKeys() {
        return breakKeysList;
    }

    @Override
    public boolean isBreak(ReportLineRecord<KogakuSogoJigyoServiceHiTaishoshaIchiranSource> currentSource,
            ReportLineRecord<KogakuSogoJigyoServiceHiTaishoshaIchiranSource> nextSource) {
        boolean flg = false;
        if (this.breakKeysList.contains(KogakuSogoJigyoServiceHiTaishoshaIchiranOutput.BreakerFieldsEnum.被保険者番号.get項目ID())
                && !currentSource.getSource().listTaishoshaIchiran_2.equals(nextSource.getSource().listTaishoshaIchiran_2)) {
            flg = true;
        } else if (this.breakKeysList.contains(KogakuSogoJigyoServiceHiTaishoshaIchiranOutput.BreakerFieldsEnum.サービス年月.get項目ID())
                && !currentSource.getSource().listTaishoshaIchiran_3.equals(nextSource.getSource().listTaishoshaIchiran_3)) {
            flg = true;
        } else if (this.breakKeysList.contains(KogakuSogoJigyoServiceHiTaishoshaIchiranOutput.BreakerFieldsEnum.要介護度.get項目ID())
                && !currentSource.getSource().listTaishoshaIchiran_5.equals(nextSource.getSource().listTaishoshaIchiran_5)) {
            flg = true;
        }
        return flg;
    }
}
