/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kyufuhitsuchishocover;

import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.report.kyufuhitsuchishocover.KyufuhiTsuchishoCoverReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 帳票設計_DBC100041_介護保険給付費通知書のプロパティです。
 *
 * @reamsid_L DBC-2280-040 lizhuoxuan
 */
public class KyufuhiTsuchishoCoverProperty extends ReportPropertyBase<KyufuhiTsuchishoCoverReportSource> {

    /**
     * コンストラクタです。
     */
    public KyufuhiTsuchishoCoverProperty() {
        super(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100041.getReportId());
    }
}
