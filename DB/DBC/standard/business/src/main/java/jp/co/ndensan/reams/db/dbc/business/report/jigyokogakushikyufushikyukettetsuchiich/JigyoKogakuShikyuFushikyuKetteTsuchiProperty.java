/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.jigyokogakushikyufushikyukettetsuchiich;

import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.report.jigyokogakushikyufushikyukettetsuchiichiran.JigyoKogakuShikyuFushikyuKetteTsuchiSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 事業高額支給不支給決定通知一覧表Propertyクラスです。
 *
 * @reamsid_L DBC-2000-110 wangxingpeng
 */
public class JigyoKogakuShikyuFushikyuKetteTsuchiProperty
        extends ReportPropertyBase<JigyoKogakuShikyuFushikyuKetteTsuchiSource> {

    /**
     * コンストラクタです。
     */
    public JigyoKogakuShikyuFushikyuKetteTsuchiProperty() {
        super(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200078.getReportId());
    }

}
