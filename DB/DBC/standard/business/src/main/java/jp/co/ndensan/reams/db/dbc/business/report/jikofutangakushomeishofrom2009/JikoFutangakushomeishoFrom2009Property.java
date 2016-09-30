/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.jikofutangakushomeishofrom2009;

import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.report.source.jikofutangakushomeishofrom2009.JikoFutangakushomeishoFrom2009ReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 帳票設計_DBC100051_自己負担証明書_2009年以降 Propertyクラスです。
 *
 * @reamsid_L DBC-4810-040 kanghongsong
 */
public class JikoFutangakushomeishoFrom2009Property extends ReportPropertyBase<JikoFutangakushomeishoFrom2009ReportSource> {

    /**
     * コンストラクタです。
     *
     */
    public JikoFutangakushomeishoFrom2009Property() {
        super(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100051.getReportId());
    }

}
