/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.gassanjigyobunkeisankekkarenrakuhyo;

import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.report.gassanjigyobunkeisankekkarenrakuhyo.GassanJigyobunKeisanKekkaRenrakuhyoSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 事業分計算結果連絡票Propertyクラスです。
 *
 * @reamsid_L DBC-4840-030 wangxingpeng
 */
public class GassanJigyobunKeisanKekkaRenrakuhyoProperty extends
        ReportPropertyBase<GassanJigyobunKeisanKekkaRenrakuhyoSource> {

    /**
     * コンストラクタです。
     */
    public GassanJigyobunKeisanKekkaRenrakuhyoProperty() {
        super(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100204.getReportId());
    }

}
