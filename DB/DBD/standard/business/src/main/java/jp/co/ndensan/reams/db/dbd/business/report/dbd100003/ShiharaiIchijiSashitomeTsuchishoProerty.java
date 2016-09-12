/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd100003;

import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd100003.ShiharaiIchijiSashitomeTsuchishoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * {@link ShiharaiIchijiSashitomeTsuchishoReportSource}のプロパティです。
 *
 * @reamsid_L DBD-3640-100 b_liuyang2
 */
public class ShiharaiIchijiSashitomeTsuchishoProerty extends ReportPropertyBase<ShiharaiIchijiSashitomeTsuchishoReportSource> {

    /**
     * コンストラクタです。
     */
    public ShiharaiIchijiSashitomeTsuchishoProerty() {
        super(SubGyomuCode.DBD介護受給, ReportIdDBD.DBD100003.getReportId());
    }
}
