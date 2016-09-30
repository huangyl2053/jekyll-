/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.jukyushajyufujissekidaicho;

import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.report.source.jukyushajyufujissekidaicho.JukyushaKyufuJissekidaichoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 受給者給付実績台帳 のPropertyです。
 *
 * @reamsid_L DBC-3080-040 dangjingjing
 */
public class JukyushaKyufuJissekidaichoProperty extends ReportPropertyBase<JukyushaKyufuJissekidaichoReportSource> {

    /**
     * コンストラクタです。
     */
    public JukyushaKyufuJissekidaichoProperty() {
        super(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100055.getReportId());
    }
}
