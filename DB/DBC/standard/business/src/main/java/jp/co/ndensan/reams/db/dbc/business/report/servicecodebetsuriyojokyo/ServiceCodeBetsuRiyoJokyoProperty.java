/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.servicecodebetsuriyojokyo;

import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.report.source.servicecodebetsuriyojokyo.ServiceCodeBetsuRiyoJokyoSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 帳票設計_DBC300002_サービスコード別利用状況 のPropertyクラスです。
 *
 * @reamsid_L DBC-3340-040 qinzhen
 */
public class ServiceCodeBetsuRiyoJokyoProperty extends
        ReportPropertyBase<ServiceCodeBetsuRiyoJokyoSource> {

    /**
     * コンストラクタです。
     */
    public ServiceCodeBetsuRiyoJokyoProperty() {

        super(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC300002.getReportId());
    }
}
