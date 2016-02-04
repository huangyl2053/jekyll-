/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.kyufuhikashitsukekinshokankigen;

import jp.co.ndensan.reams.db.dba.definition.reportId.ReportIdDBA;
import jp.co.ndensan.reams.db.dba.entity.report.kyufuhikashitsukekinshokankigen.KyufuKashitsukekinShokanKigenEnchoShinseishoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * KyufuhiKashitsukekinShokankigenEnchoShinseishoProertyのプロパティです。
 *
 */
public class KyufuhiKashitsukekinShokankigenEnchoShinseishoProerty extends
        ReportPropertyBase<KyufuKashitsukekinShokanKigenEnchoShinseishoReportSource> {

    /**
     * コンストラクタです。
     */
    public KyufuhiKashitsukekinShokankigenEnchoShinseishoProerty() {
        super(SubGyomuCode.DBA介護資格, ReportIdDBA.DBC800019.getReportId());
    }

}
