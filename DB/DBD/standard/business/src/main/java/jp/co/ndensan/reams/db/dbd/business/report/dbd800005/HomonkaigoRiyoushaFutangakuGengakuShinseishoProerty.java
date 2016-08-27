/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd800005;

import jp.co.ndensan.reams.db.dbd.entity.report.dbd800005.HomonKaigoRiyoshaFutangakuGengakuShinseishoReportSource;
import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * HomonkaigoRiyoushaFutangakuGengakuShinseishoProertyのプロパティです。
 *
 * @reamsid_L DBA-0540-701 zhengshukai
 */
public class HomonkaigoRiyoushaFutangakuGengakuShinseishoProerty extends ReportPropertyBase<HomonKaigoRiyoshaFutangakuGengakuShinseishoReportSource> {

    /**
     * コンストラクタです。
     */
    public HomonkaigoRiyoushaFutangakuGengakuShinseishoProerty() {
        super(SubGyomuCode.DBD介護受給, ReportIdDBD.DBD800005.getReportId());
    }
}
