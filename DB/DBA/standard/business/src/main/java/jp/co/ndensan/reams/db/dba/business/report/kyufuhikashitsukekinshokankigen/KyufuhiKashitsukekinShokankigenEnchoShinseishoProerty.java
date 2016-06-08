/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.kyufuhikashitsukekinshokankigen;

import jp.co.ndensan.reams.db.dba.definition.reportid.ReportIdDBA;
import jp.co.ndensan.reams.db.dba.entity.report.kyufuhikashitsukekinshokankigen.KyufuKashitsukekinShokanKigenEnchoShinseishoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * KyufuhiKashitsukekinShokankigenEnchoShinseishoProertyのプロパティです。
 *
 * @reamsid_L DBA-0540-702 lijia
 *
 */
public class KyufuhiKashitsukekinShokankigenEnchoShinseishoProerty extends
        ReportPropertyBase<KyufuKashitsukekinShokanKigenEnchoShinseishoReportSource> {

    /**
     * コンストラクタです。
     */
    public KyufuhiKashitsukekinShokankigenEnchoShinseishoProerty() {
        super(SubGyomuCode.DBC介護給付, ReportIdDBA.DBC800019.getReportId());
    }

}
