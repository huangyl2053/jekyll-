/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd200008;

import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd200008.KyufuGengakuHaakuIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 給付額減額把握リストのプロパティです。
 *
 * @reamsid_L DBD-3610-060 b_liuyang2
 */
public class KyufuGengakuHaakuIchiranProerty extends ReportPropertyBase<KyufuGengakuHaakuIchiranReportSource> {

    /**
     * インスタンスを生成します。
     */
    public KyufuGengakuHaakuIchiranProerty() {
        super(SubGyomuCode.DBD介護受給, ReportIdDBD.DBD200008.getReportId());
    }
}
