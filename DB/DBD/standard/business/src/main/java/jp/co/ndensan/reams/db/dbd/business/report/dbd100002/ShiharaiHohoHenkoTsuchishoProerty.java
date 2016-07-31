/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd100002;

import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd100002.ShiharaiHohoHenkoTsuchishoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * {@link ShiharaiHohoHenkoTsuchishoReportSource}のプロパティです。
 *
 * @reamsid_L DBD-3640-090 b_liuyang2
 */
public class ShiharaiHohoHenkoTsuchishoProerty extends ReportPropertyBase<ShiharaiHohoHenkoTsuchishoReportSource> {

    /**
     * コンストラクタです。
     */
    public ShiharaiHohoHenkoTsuchishoProerty() {
        super(SubGyomuCode.DBD介護受給, ReportIdDBD.DBD100002.getReportId());
    }
}
