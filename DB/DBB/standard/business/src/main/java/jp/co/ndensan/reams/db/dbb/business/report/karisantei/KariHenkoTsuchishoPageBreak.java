/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.karisantei;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.entity.report.dbbmn35003.dbb200014.KariSanteigakuHenkoTsuchishoHakkoIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * 仮算定額変更通知書発行一覧表の改頁クラスです。
 *
 * @reamsid_L DBB-0890-030 xicongwang
 */
public class KariHenkoTsuchishoPageBreak extends PageBreaker<KariSanteigakuHenkoTsuchishoHakkoIchiranReportSource> {

    private final List<RString> breakKeysList;

    /**
     * コンストラクタです。
     *
     * @param breakKeys List<RString>
     */
    public KariHenkoTsuchishoPageBreak(List<RString> breakKeys) {
        this.breakKeysList = Collections.unmodifiableList(breakKeys);
    }

    @Override
    public List<RString> breakKeys() {
        return breakKeysList;
    }

    @Override
    public boolean isBreak(ReportLineRecord<KariSanteigakuHenkoTsuchishoHakkoIchiranReportSource> currentSource,
            ReportLineRecord<KariSanteigakuHenkoTsuchishoHakkoIchiranReportSource> nextSource) {
        boolean flag = false;
        //QA971 保留中
        if (this.breakKeysList.contains(KariHenkoTsuchishoOutPutOrder.郵便番号.get項目ID())
                && !currentSource.getSource().listUpper_2.equals(nextSource.getSource().listUpper_2)) {
            flag = true;
        }
        return flag;
    }
}
