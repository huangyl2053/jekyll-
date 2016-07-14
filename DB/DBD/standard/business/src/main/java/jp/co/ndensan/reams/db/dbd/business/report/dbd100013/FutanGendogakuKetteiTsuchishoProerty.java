/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd100013;

import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd100013.FutanGendogakuKetteiTsuchishoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * {@link FutanGendogakuKetteiTsuchishoReportSource}のプロパティです。
 *
 * @reamsid_L DBD-3540-050 wangchao
 */
public class FutanGendogakuKetteiTsuchishoProerty extends ReportPropertyBase<FutanGendogakuKetteiTsuchishoReportSource> {

    /**
     * コンストラクタです。
     */
    public FutanGendogakuKetteiTsuchishoProerty() {
        super(SubGyomuCode.DBD介護受給, ReportIdDBD.DBD100013.getReportId());
    }
}
