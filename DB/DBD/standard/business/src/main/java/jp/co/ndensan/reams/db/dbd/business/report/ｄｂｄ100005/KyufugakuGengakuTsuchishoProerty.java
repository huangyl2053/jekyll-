/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.ｄｂｄ100005;

import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.report.ｄｂｄ100005.KyufugakuGengakuTsuchishoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * {@link KyufugakuGengakuTsuchishoReportSource}のプロパティです。
 *
 * @reamsid_L DBD-3640-060 b_liuyang2
 */
public class KyufugakuGengakuTsuchishoProerty extends ReportPropertyBase<KyufugakuGengakuTsuchishoReportSource> {

    /**
     * コンストラクタです。
     */
    public KyufugakuGengakuTsuchishoProerty() {
        super(SubGyomuCode.DBD介護受給, ReportIdDBD.DBD100005.getReportId());
    }
}
