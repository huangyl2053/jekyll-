/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.kyotakukaigojutakukaishuhijizenshinseisho;

import jp.co.ndensan.reams.db.dba.definition.reportid.ReportIdDBA;
import jp.co.ndensan.reams.db.dba.entity.report.kyotakukaigojutakukaishuhijizenshinseisho.JutakuKaishuhiJizenShinseishoJuryoIninHaraiReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * KyotakuKaigoJutakuKaishuhiJizenShinseishoProertyのプロパティです。
 *
 * @reamsid_L DBA-0540-703 lijia
 *
 */
public class KyotakuKaigoJutakuKaishuhiJizenShinseishoProerty extends ReportPropertyBase<JutakuKaishuhiJizenShinseishoJuryoIninHaraiReportSource> {

    /**
     * コンストラクタです。
     */
    public KyotakuKaigoJutakuKaishuhiJizenShinseishoProerty() {
        super(SubGyomuCode.DBC介護給付, ReportIdDBA.DBC800011.getReportId());
    }
}
