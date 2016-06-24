/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.keidoshafukushiyogutaiyokakuninshinseisho2;

import jp.co.ndensan.reams.db.dba.definition.reportid.ReportIdDBA;
import jp.co.ndensan.reams.db.dba.entity.report.keidoshafukushiyogutaiyokakuninshinseisho2.KeidoshaFukushiYoguTaiyoKakuninShinseisho2ReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * KeidoshaFukushiYoguTaiyoKakuninShinseisho2Proertyのプロパティです。
 *
 * @reamsid_L DBA-0540-705 lijia
 *
 */
public class KeidoshaFukushiYoguTaiyoKakuninShinseisho2Proerty extends ReportPropertyBase<KeidoshaFukushiYoguTaiyoKakuninShinseisho2ReportSource> {

    /**
     * コンストラクタです。
     */
    public KeidoshaFukushiYoguTaiyoKakuninShinseisho2Proerty() {
        super(SubGyomuCode.DBC介護給付, ReportIdDBA.DBC800021.getReportId());
    }
}
