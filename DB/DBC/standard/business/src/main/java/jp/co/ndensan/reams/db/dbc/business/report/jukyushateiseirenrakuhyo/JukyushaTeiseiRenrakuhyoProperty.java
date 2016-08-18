/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.jukyushateiseirenrakuhyo;

import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.report.jukyushateiseirenrakuhyo.JukyushaTeiseiRenrakuhyoSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 帳票設計_DBCMN81002_受給者訂正連絡票（紙媒体）Propertyクラスです。
 *
 * @reamsid_L DBC-2101-060 lijian
 */
public class JukyushaTeiseiRenrakuhyoProperty extends
        ReportPropertyBase<JukyushaTeiseiRenrakuhyoSource> {

    /**
     * コンストラクタです。
     *
     */
    public JukyushaTeiseiRenrakuhyoProperty() {
        super(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100014.getReportId());
    }

}
