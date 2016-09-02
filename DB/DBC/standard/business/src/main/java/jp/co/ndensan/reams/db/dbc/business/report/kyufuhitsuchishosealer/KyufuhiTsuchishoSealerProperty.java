/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kyufuhitsuchishosealer;

import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.report.kyufuhitsuchishosealer.KyufuhiTsuchishoSealerReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 帳票設計_DBC100042_介護保険給付費通知書(ｼｰﾗﾀｲﾌﾟ)のプロパティです。
 *
 * @reamsid_L DBC-2280-070 lizhuoxuan
 */
public class KyufuhiTsuchishoSealerProperty extends ReportPropertyBase<KyufuhiTsuchishoSealerReportSource> {

    /**
     * コンストラクタです。
     */
    public KyufuhiTsuchishoSealerProperty() {
        super(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100042.getReportId());
    }
}
