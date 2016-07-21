/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd100022;

import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd100022.TokubChiiKasRiysFutGengKakuninshoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * {@link TokubChiiKasRiysFutGengKakuninshoReportSource}のプロパティです。
 *
 * @reamsid_L DBD-3540-120 wangchao
 */
public class TokubchiiKasHomKaigRiysFutGengKakuninshoProerty extends ReportPropertyBase<TokubChiiKasRiysFutGengKakuninshoReportSource> {

    /**
     * コンストラクタです。
     */
    public TokubchiiKasHomKaigRiysFutGengKakuninshoProerty() {
        super(SubGyomuCode.DBD介護受給, ReportIdDBD.DBD100022.getReportId());
    }
}
