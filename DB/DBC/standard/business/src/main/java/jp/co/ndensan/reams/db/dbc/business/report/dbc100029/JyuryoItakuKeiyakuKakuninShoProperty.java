/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.dbc100029;

import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.report.dbc100029.JyuryoItakuKeiyakuKakuninShoSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 帳票設計_DBCMN32002_介護保険受領委任契約承認（不承認）確認書（利用者向け）のPropertyです。
 *
 * @reamsid_L DBC-1980-030 yuqingzhang
 */
public class JyuryoItakuKeiyakuKakuninShoProperty extends
        ReportPropertyBase<JyuryoItakuKeiyakuKakuninShoSource> {

    /**
     * コンストラクタです。
     */
    public JyuryoItakuKeiyakuKakuninShoProperty() {
        super(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100029.getReportId());
    }
}
