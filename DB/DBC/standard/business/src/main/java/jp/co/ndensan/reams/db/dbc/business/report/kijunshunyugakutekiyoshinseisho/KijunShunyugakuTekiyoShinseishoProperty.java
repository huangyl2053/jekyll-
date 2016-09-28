/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kijunshunyugakutekiyoshinseisho;

import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.report.kijunshunyugakutekiyoshinseisho.KijunShunyugakuTekiyoShinseishoSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 帳票設計_DBC100064_基準収入額適用申請書 Propertyクラスです。
 *
 * @reamsid_L DBC-4640-040 lijian
 */
public class KijunShunyugakuTekiyoShinseishoProperty extends ReportPropertyBase<KijunShunyugakuTekiyoShinseishoSource> {

    /**
     * コンストラクタです。
     *
     */
    public KijunShunyugakuTekiyoShinseishoProperty() {
        super(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100064.getReportId());
    }

}
