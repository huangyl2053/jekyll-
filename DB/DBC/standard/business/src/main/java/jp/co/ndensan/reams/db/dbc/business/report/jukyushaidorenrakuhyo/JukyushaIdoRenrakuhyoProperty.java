/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.jukyushaidorenrakuhyo;

import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.report.source.jukyushaidorenrakuhyo.JukyushaIdoRenrakuhyoSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 帳票設計_DBCMN81001_受給者異動連絡票紙媒体Property
 *
 * @reamsid_L DBC-2100-040 jiangzongyue
 */
public class JukyushaIdoRenrakuhyoProperty extends
        ReportPropertyBase<JukyushaIdoRenrakuhyoSource> {

    private static final ReportId ID = ReportIdDBC.DBC100013.getReportId();

    /**
     * コンストラクタです。
     */
    public JukyushaIdoRenrakuhyoProperty() {
        super(SubGyomuCode.DBC介護給付, ID);
    }
}
