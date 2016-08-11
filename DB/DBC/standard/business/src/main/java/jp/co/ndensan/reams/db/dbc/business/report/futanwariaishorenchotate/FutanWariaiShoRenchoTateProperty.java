/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.futanwariaishorenchotate;

import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.report.futanwariaishorenchotate.FutanWariaiShoRenchoTateSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 帳票設計_DBC100066_負担割合証（連帳・縦） Property
 *
 * @reamsid_L DBC-4990-050 pengxingyi
 */
public class FutanWariaiShoRenchoTateProperty extends ReportPropertyBase<FutanWariaiShoRenchoTateSource> {

    /**
     * インスタンスを生成します。
     */
    public FutanWariaiShoRenchoTateProperty() {
        super(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100066.getReportId());
    }
}
