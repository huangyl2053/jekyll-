/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.shiharaiHohoHenkoYokokuTsuchisho;

import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.report.shiharaiHohoHenkoYokokuTsuchisho.ShiharaiHohoHenkoYokokuTsuchishoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * {@link ShiharaiHohoHenkoYokokuTsuchishoReportSource}のプロパティです。
 *
 * @reamsid_L DBD-3640-040 b_liuyang2
 */
public class ShiharaiHohoHenkoYokokuTsuchishoProerty extends ReportPropertyBase<ShiharaiHohoHenkoYokokuTsuchishoReportSource> {

    /**
     * コンストラクタです。
     */
    public ShiharaiHohoHenkoYokokuTsuchishoProerty() {
        //有问题，括号里的
        super(SubGyomuCode.DBD介護受給, ReportIdDBD.DBD800001.getReportId());
    }
}
