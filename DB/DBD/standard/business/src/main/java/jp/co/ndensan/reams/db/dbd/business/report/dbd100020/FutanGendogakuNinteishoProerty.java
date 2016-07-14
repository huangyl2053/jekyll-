/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd100020;

import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd100020.FutanGendogakuNinteishoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * {@link FutanGendogakuNinteishoReportSource}のプロパティです。
 *
 * @reamsid_L DBD-3540-040 wangchao
 */
public class FutanGendogakuNinteishoProerty extends ReportPropertyBase<FutanGendogakuNinteishoReportSource> {

    /**
     * コンストラクタです。
     */
    public FutanGendogakuNinteishoProerty() {
        super(SubGyomuCode.DBD介護受給, ReportIdDBD.DBD100020.getReportId());
    }
}
