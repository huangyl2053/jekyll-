/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd200018;

import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd200018.ShakaiFukushiHojinKeigenHakkoIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * {@link ShakaiFukushiHojinKeigenHakkoIchiranReportSource}のプロパティです。
 *
 * @reamsid_L DBD-3981-070 b_liuyang2
 */
public class ShakaiFukushiHojinKeigenHakkoIchiranProerty extends ReportPropertyBase<ShakaiFukushiHojinKeigenHakkoIchiranReportSource> {

    /**
     * コンストラクタです。
     */
    public ShakaiFukushiHojinKeigenHakkoIchiranProerty() {
        super(SubGyomuCode.DBD介護受給, ReportIdDBD.DBD200018.getReportId());
    }
}
