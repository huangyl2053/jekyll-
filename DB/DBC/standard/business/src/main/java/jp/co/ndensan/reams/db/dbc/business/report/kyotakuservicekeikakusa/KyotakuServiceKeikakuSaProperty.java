/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kyotakuservicekeikakusa;

import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.report.kyotakuservicekeikakusakusei.KyotakuServiceKeikakuSakuseiSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 計画届出状況チェックリストPropertyクラスです。
 *
 * @reamsid_L DBC-1960-040 wangxingpeng
 */
public class KyotakuServiceKeikakuSaProperty extends ReportPropertyBase<KyotakuServiceKeikakuSakuseiSource> {

    /**
     * コンストラクタです。
     */
    public KyotakuServiceKeikakuSaProperty() {
        super(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200060.getReportId());
    }

}
