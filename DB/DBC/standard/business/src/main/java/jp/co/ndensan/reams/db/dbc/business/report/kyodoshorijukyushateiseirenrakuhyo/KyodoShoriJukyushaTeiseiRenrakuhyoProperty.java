/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kyodoshorijukyushateiseirenrakuhyo;

import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.report.source.kyodoshorijukyushateiseirenrakuhyo.KyodoShoriJukyushaTeiseiRenrakuhyoSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 帳票設計_DBCMN81004_共同処理用受給者訂正連絡票（紙媒体）Propertyのインターフェースクラスです。
 *
 * @reamsid_L DBC-1951-060 chenaoqi
 */
public class KyodoShoriJukyushaTeiseiRenrakuhyoProperty extends ReportPropertyBase<KyodoShoriJukyushaTeiseiRenrakuhyoSource> {

    /**
     * コンストラクタです。
     */
    public KyodoShoriJukyushaTeiseiRenrakuhyoProperty() {
        super(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100016.getReportId());
    }

}
