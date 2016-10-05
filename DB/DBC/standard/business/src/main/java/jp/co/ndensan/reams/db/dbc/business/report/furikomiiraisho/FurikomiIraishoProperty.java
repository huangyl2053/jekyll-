/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.furikomiiraisho;

import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.report.furikomiiraisho.FurikomiIraishoSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 帳票設計_DBC100059_事業合算・事業分振込明細書作成（一括） Propertyクラスです。
 *
 * @reamsid_L DBC-4870-040 lijian
 */
public class FurikomiIraishoProperty extends ReportPropertyBase<FurikomiIraishoSource> {

    /**
     * コンストラクタです。
     *
     */
    public FurikomiIraishoProperty() {

        super(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100059.getReportId());
    }
}
