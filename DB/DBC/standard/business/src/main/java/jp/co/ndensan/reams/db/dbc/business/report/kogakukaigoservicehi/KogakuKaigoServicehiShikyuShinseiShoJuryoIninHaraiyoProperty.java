/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakukaigoservicehi;

import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.report.kogakukaigoservicehi.KogakuKaigoServicehiShikyuShinseiShoJuryoIninHaraiyoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 介護保険高額介護（予防）サービス費支給（受領委任払）申請書のプロパティです。
 *
 * @reamsid_L DBA-0540-711 lishengli
 */
public class KogakuKaigoServicehiShikyuShinseiShoJuryoIninHaraiyoProperty
        extends ReportPropertyBase<KogakuKaigoServicehiShikyuShinseiShoJuryoIninHaraiyoReportSource> {

    private static final ReportId ID = ReportIdDBC.DBC800015.getReportId();

    /**
     * インスタンスを生成します。
     */
    public KogakuKaigoServicehiShikyuShinseiShoJuryoIninHaraiyoProperty() {
        super(SubGyomuCode.DBC介護給付, ID);
    }
}
