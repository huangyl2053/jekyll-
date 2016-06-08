/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.juryoininharaikeiyakushinseisho;

import jp.co.ndensan.reams.db.dba.definition.reportid.ReportIdDBA;
import jp.co.ndensan.reams.db.dba.entity.report.juryoininharaikeiyakushinseisho.JuryoIninharaiKeiyakuShinseishoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * {@link HihokenshashoHakkoIchiranHyoProerty}のプロパティです。
 *
 * @reamsid_L DBA-0540-683 dongyabin
 */
public class JuryoIninharaiKeiyakuShinseishoProerty extends ReportPropertyBase<JuryoIninharaiKeiyakuShinseishoReportSource> {

    /**
     * コンストラクタです。
     */
    public JuryoIninharaiKeiyakuShinseishoProerty() {
        super(SubGyomuCode.DBC介護給付, ReportIdDBA.DBC800002.getReportId());
    }
}
