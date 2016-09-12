/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kyodoshoriyojukyushaidorenrakuhyo;

import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.report.source.kyodoshorijukyushaidorenrakuhyo.KyodoShoriJukyushaIdoRenrakuhyoSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 帳票設計_DBCMN81003_共同処理用受給者異動連絡票（紙媒体）Propertyのインターフェースクラスです。
 *
 * @reamsid_L DBC-1950-050 chenaoqi
 */
public class KyodoShoriJukyushaIdoRenrakuhyoProperty extends ReportPropertyBase<KyodoShoriJukyushaIdoRenrakuhyoSource> {

    /**
     * コンストラクタです。
     */
    public KyodoShoriJukyushaIdoRenrakuhyoProperty() {
        super(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100015.getReportId());
    }

}
