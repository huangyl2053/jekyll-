/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kyufukanrihyosokatsuhyo;

import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.report.kyufukanrihyosokatsuhyo.KyufuKanrihyoSokatsuhyoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 給付管理票総括票のプロパティです。
 *
 * @reamsid_L DBC-2840-042 kanghongsong
 */
public class KyufuKanrihyoSokatsuhyoProperty extends ReportPropertyBase<KyufuKanrihyoSokatsuhyoReportSource> {

    private static final ReportId ID = ReportIdDBC.DBC300001.getReportId();

    /**
     * インスタンスを生成します。
     */
    public KyufuKanrihyoSokatsuhyoProperty() {
        super(SubGyomuCode.DBC介護給付, ID);
    }
}
