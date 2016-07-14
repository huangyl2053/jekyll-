/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.gemgengnintskettsucskobthakko.shakfukushojriysfutkeigkettsuchisho;

import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.report.shakfukushojriysfutkeigkettsuchisho.ShakaiFukushiHojinRiyoshaFutanKeigenKetteiTsuchishoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * {@link ShakaiFukushiHojinRiyoshaFutanKeigenKetteiTsuchishoReportSource}のプロパティです。
 *
 * @reamsid_L DBD-3540-110 wangchao
 */
public class ShakFukusHojRiysFutKeigTaisKetTsuchishoProerty extends ReportPropertyBase<ShakaiFukushiHojinRiyoshaFutanKeigenKetteiTsuchishoReportSource> {

    /**
     * コンストラクタです。
     */
    public ShakFukusHojRiysFutKeigTaisKetTsuchishoProerty() {
        super(SubGyomuCode.DBD介護受給, ReportIdDBD.DBD100012.getReportId());
    }
}
