/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.gemgengnintskettsucskobthakko.riysfutggengmenjnintsho;

import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.report.riysfutggengmenjnintsho.RiyoshaFutangakuGengakuMenjoNinteishoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * {@link RiyoshaFutangakuGengakuMenjoNinteishoReportSource}のプロパティです。
 *
 * @reamsid_L DBD-3540-060 wangchao
 */
public class RiysFutgGengMenjNintshoProerty extends ReportPropertyBase<RiyoshaFutangakuGengakuMenjoNinteishoReportSource> {

    /**
     * コンストラクタです。
     */
    public RiysFutgGengMenjNintshoProerty() {
        super(SubGyomuCode.DBD介護受給, ReportIdDBD.DBD100015.getReportId());
    }
}
