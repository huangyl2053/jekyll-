/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd100019;

import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd100019.ShafukuRiysFutKeigTaisKakuninshoShoNoAriReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * {@link ShafukuRiysFutKeigTaisKakuninshoShoNoAriReportSource}のプロパティです。
 *
 * @reamsid_L DBD-3540-100 wangchao
 */
public class ShafukuRiysFutKeigTaisKakuninshoShoNoAriProerty extends ReportPropertyBase<ShafukuRiysFutKeigTaisKakuninshoShoNoAriReportSource> {

    /**
     * コンストラクタです。
     */
    public ShafukuRiysFutKeigTaisKakuninshoShoNoAriProerty() {
        super(SubGyomuCode.DBD介護受給, ReportIdDBD.DBD100019.getReportId());
    }
}
