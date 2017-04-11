/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.futanwariaisho;

import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.report.source.futanwariaisho.FutanWariaiShoSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 帳票設計_DBC100065_負担割合証Property
 *
 * @reamsid_L DBC-5010-030 surun
 */
public class FutanWariaiShoProperty extends
        ReportPropertyBase<FutanWariaiShoSource> {

    private static final ReportId ID = ReportIdDBD.DBD100065.getReportId();

    /**
     * コンストラクタです。
     */
    public FutanWariaiShoProperty() {
        super(SubGyomuCode.DBC介護給付, ID);
    }
}
