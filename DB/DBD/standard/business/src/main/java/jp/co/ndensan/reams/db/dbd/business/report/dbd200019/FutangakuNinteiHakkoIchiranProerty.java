/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd200019;

import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd200019.FutangakuNinteiHakkoIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * {@link FutangakuNinteiHakkoIchiranReportSource}のプロパティです。
 *
 * @reamsid_L DBD-3981-060 b_liuyang2
 */
public class FutangakuNinteiHakkoIchiranProerty extends ReportPropertyBase<FutangakuNinteiHakkoIchiranReportSource> {

    /**
     * コンストラクタです。
     */
    public FutangakuNinteiHakkoIchiranProerty() {
        super(SubGyomuCode.DBD介護受給, ReportIdDBD.DBD200019.getReportId());
    }
}
