/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd100026;

import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd100026.JukyushaDaichoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * {@link JukyushaDaichoReportSource}のプロパティです。
 *
 * @reamsid_L DBD-1760-040 b_liuyang2
 */
public class JukyushaDaichoProerty extends ReportPropertyBase<JukyushaDaichoReportSource> {

    /**
     * コンストラクタです。
     */
    public JukyushaDaichoProerty() {
        super(SubGyomuCode.DBD介護受給, ReportIdDBD.DBD100026.getReportId());
    }
}
