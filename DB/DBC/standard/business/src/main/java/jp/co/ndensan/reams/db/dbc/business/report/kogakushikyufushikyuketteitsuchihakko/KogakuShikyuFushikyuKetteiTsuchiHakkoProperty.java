/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakushikyufushikyuketteitsuchihakko;

import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.report.kogakushikyufushikyuketteitsuchihakkoichiran.KogakuShikyuFushikyuKetteiTsuchiHakkoSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 高額介護サービス費支給（不支給）決定通知一覧表Propertyクラスです。
 *
 * @reamsid_L DBC-2000-080 wangxingpeng
 *
 */
public class KogakuShikyuFushikyuKetteiTsuchiHakkoProperty
        extends ReportPropertyBase<KogakuShikyuFushikyuKetteiTsuchiHakkoSource> {

    /**
     * コンストラクタです。
     */
    public KogakuShikyuFushikyuKetteiTsuchiHakkoProperty() {
        super(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200020.getReportId());

    }

}
