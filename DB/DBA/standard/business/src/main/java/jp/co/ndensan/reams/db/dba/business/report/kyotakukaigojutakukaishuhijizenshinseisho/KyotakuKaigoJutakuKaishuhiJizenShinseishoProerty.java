/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.kyotakukaigojutakukaishuhijizenshinseisho;

import jp.co.ndensan.reams.db.dba.definition.reportId.ReportIdDBA;
import jp.co.ndensan.reams.db.dba.entity.report.kyotakukaigojutakukaishuhijizenshinseisho.JutakuKaishuhiJizenShinseishoJuryoIninHaraiReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * KyotakuKaigoJutakuKaishuhiJizenShinseishoProertyのプロパティです。
 *
 */
public class KyotakuKaigoJutakuKaishuhiJizenShinseishoProerty extends ReportPropertyBase<JutakuKaishuhiJizenShinseishoJuryoIninHaraiReportSource> {

    /**
     * コンストラクタです。
     */
    public KyotakuKaigoJutakuKaishuhiJizenShinseishoProerty() {
        super(SubGyomuCode.DBA介護資格, ReportIdDBA.DBC800011.getReportId());
    }
}
