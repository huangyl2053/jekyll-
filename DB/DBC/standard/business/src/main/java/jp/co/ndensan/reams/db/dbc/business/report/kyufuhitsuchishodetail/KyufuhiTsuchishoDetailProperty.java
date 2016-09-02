/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kyufuhitsuchishodetail;

import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.report.kyufuhitsuchishodetail.KyufuhiTsuchishoDetailReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 介護保険給付費通知書(２ページ目以降)のプロパティです。
 *
 * @reamsid_L DBC-2280-050 lizhuoxuan
 */
public class KyufuhiTsuchishoDetailProperty extends ReportPropertyBase<KyufuhiTsuchishoDetailReportSource> {

    /**
     * コンストラクタです。
     */
    public KyufuhiTsuchishoDetailProperty() {
        super(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100041.getReportId());
    }

}
