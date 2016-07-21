/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd200007;

import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd200007.ShiharaiHohoHenkoKanriIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 支払方法変更管理リストのプロパティです。
 *
 * @reamsid_L DBD-3630-050 liangbc
 */
public class ShiharaiHohoHenkoKanriIchiranProperty extends
        ReportPropertyBase<ShiharaiHohoHenkoKanriIchiranReportSource> {

    /**
     * インスタンスを生成します。
     */
    public ShiharaiHohoHenkoKanriIchiranProperty() {
        super(SubGyomuCode.DBD介護受給, ReportIdDBD.DBD200007.getReportId());
    }
}
