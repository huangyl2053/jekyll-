/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd100018;

import jp.co.ndensan.reams.db.dbd.entity.report.dbd100018.ShakfukusRiysFutKeigTaisKakuninshoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * {@link ShakaiFukushiHojinRiyoshaFutanKeigenKetteiTsuchishoReportSource}のプロパティです。
 *
 * @reamsid_L DBD-3540-100 wangchao
 */
public class ShakfukusRiysFutKeigTaisKakuninshoProerty extends ReportPropertyBase<ShakfukusRiysFutKeigTaisKakuninshoReportSource> {

    /**
     * コンストラクタです。
     *
     * @param reportId ReportId
     */
    public ShakfukusRiysFutKeigTaisKakuninshoProerty(ReportId reportId) {
        super(SubGyomuCode.DBD介護受給, reportId);
    }
}
