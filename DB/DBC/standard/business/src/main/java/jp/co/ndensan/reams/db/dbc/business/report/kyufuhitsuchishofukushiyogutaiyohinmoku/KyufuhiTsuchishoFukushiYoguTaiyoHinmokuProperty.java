/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kyufuhitsuchishofukushiyogutaiyohinmoku;

import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.report.kyufuhitsuchishofukushiyogutaiyohinmoku.KyufuhiTsuchishoFukushiYoguTaiyoHinmokuReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 帳票設計_DBC100043_介護保険給付費通知書（福祉用具貸与品目）のプロパティです。
 *
 * @reamsid_L DBC-2280-060 lizhuoxuan
 */
public class KyufuhiTsuchishoFukushiYoguTaiyoHinmokuProperty extends ReportPropertyBase<KyufuhiTsuchishoFukushiYoguTaiyoHinmokuReportSource> {

    /**
     * コンストラクタです。
     */
    public KyufuhiTsuchishoFukushiYoguTaiyoHinmokuProperty() {
        super(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100043.getReportId());
    }
}
