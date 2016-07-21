/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd800001;

import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd800001.FutangendogakuNinteiShinseishoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * {@link FutangendogakuNinteiShinseishoReportSource}のプロパティです。
 *
 * @reamsid_L DBA-0540-690 suguangjun
 */
public class FutangendogakuNinteiShinseishoProerty extends ReportPropertyBase<FutangendogakuNinteiShinseishoReportSource> {

    /**
     * コンストラクタです。
     */
    public FutangendogakuNinteiShinseishoProerty() {
        super(SubGyomuCode.DBD介護受給, ReportIdDBD.DBD800001.getReportId());
    }
}
