/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.keidoshafukushiyogutaiyokakuninshinseisho;

import jp.co.ndensan.reams.db.dba.definition.reportid.ReportIdDBA;
import jp.co.ndensan.reams.db.dba.entity.report.keidoshafukushiyogutaiyokakuninshinseisho.KeidoshaFukushiYoguTaiyoKakuninShinseishoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * KeidoshaFukushiYoguTaiyoKakuninShinseishoProertyのプロパティです。
 *
 * @reamsid_L DBA-0540-704 lijia
 *
 */
public class KeidoshaFukushiYoguTaiyoKakuninShinseishoProerty extends ReportPropertyBase<KeidoshaFukushiYoguTaiyoKakuninShinseishoReportSource> {

    /**
     * コンストラクタです。
     */
    public KeidoshaFukushiYoguTaiyoKakuninShinseishoProerty() {
        super(SubGyomuCode.DBC介護給付, ReportIdDBA.DBC800014.getReportId());
    }
}
