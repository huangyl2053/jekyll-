/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd800002;

import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd800002.RiyoshaFutangakuGengakuMenjyoShinseishoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * {@link RiyoshaFutangakuGengakuMenjyoShinseishoReportSource}のプロパティです。
 *
 * @reamsid_L DBA-0540-691 suguangjun
 */
public class RiyoshaFutangakuGengakuMenjyoShinseishoProerty extends ReportPropertyBase<RiyoshaFutangakuGengakuMenjyoShinseishoReportSource> {

    /**
     * コンストラクタです。
     */
    public RiyoshaFutangakuGengakuMenjyoShinseishoProerty() {
        super(SubGyomuCode.DBD介護受給, ReportIdDBD.DBD800002.getReportId());
    }
}
