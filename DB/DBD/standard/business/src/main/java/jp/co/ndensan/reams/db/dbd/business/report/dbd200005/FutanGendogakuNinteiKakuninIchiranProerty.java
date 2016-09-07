/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd200005;

import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd200005.FutanGendogakuNinteiKakuninIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * {@link FutanGendogakuNinteiKakuninIchiranReportSource}のプロパティです。
 *
 * @reamsid_L DBD-3710-100 b_liuyang2
 */
public class FutanGendogakuNinteiKakuninIchiranProerty extends ReportPropertyBase<FutanGendogakuNinteiKakuninIchiranReportSource> {

    /**
     * コンストラクタです。
     */
    public FutanGendogakuNinteiKakuninIchiranProerty() {
        super(SubGyomuCode.DBD介護受給, ReportIdDBD.DBD200005.getReportId());
    }
}
