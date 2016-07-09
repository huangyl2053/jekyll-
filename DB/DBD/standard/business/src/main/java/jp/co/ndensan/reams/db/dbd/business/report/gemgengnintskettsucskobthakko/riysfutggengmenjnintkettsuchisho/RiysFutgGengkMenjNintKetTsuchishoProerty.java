/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.gemgengnintskettsucskobthakko.riysfutggengmenjnintkettsuchisho;

import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.report.riysfutggengmenjnintkettsuchisho.RiyoshaFutangakuGengakuMenjoKetteiTsuchishoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * {@link RiyoshaFutangakuGengakuMenjoKetteiTsuchishoReportSource}のプロパティです。
 *
 * @reamsid_L DBD-3540-070 wangchao
 */
public class RiysFutgGengkMenjNintKetTsuchishoProerty extends ReportPropertyBase<RiyoshaFutangakuGengakuMenjoKetteiTsuchishoReportSource> {

    /**
     * コンストラクタです。
     */
    public RiysFutgGengkMenjNintKetTsuchishoProerty() {
        super(SubGyomuCode.DBD介護受給, ReportIdDBD.DBD100009.getReportId());
    }
}
