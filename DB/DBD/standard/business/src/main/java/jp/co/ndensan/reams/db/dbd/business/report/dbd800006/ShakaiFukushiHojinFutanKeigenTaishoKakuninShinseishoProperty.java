/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd800006;

import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd800006.ShakaiFukushiHojinFutanKeigenTaishoKakuninShinseishoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * {@link 社会福祉法人等利用者負担軽減対象確認申請書}のプロパティです。
 *
 * @reamsid_L DBA-0540-698 zhangguopeng
 */
public class ShakaiFukushiHojinFutanKeigenTaishoKakuninShinseishoProperty extends
        ReportPropertyBase<ShakaiFukushiHojinFutanKeigenTaishoKakuninShinseishoReportSource> {

    /**
     * インスタンスを生成します。
     */
    public ShakaiFukushiHojinFutanKeigenTaishoKakuninShinseishoProperty() {
        super(SubGyomuCode.DBD介護受給, ReportIdDBD.DBD800006.getReportId());
    }

}
