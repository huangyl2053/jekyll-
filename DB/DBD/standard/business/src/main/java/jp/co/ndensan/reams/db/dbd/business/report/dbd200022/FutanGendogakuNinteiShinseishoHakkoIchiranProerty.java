/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd200022;

import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd200022.FutanGendogakuNinteiShinseishoHakkoIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * {@link FutanGendogakuNinteiShinseishoHakkoIchiranReportSource}のプロパティです。
 *
 * @reamsid_L DBD-3530-090 b_liuyang2
 */
public class FutanGendogakuNinteiShinseishoHakkoIchiranProerty extends
        ReportPropertyBase<FutanGendogakuNinteiShinseishoHakkoIchiranReportSource> {

    /**
     * コンストラクタです。
     */
    public FutanGendogakuNinteiShinseishoHakkoIchiranProerty() {
        super(SubGyomuCode.DBD介護受給, ReportIdDBD.DBD200022.getReportId());
    }
}
