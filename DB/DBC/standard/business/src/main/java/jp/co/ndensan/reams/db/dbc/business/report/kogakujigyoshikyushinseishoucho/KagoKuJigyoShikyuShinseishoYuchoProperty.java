/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakujigyoshikyushinseishoucho;

import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.report.kogakujigyoshikyushinseishoyuchosource.KogakuJigyoShikyuShinseishoYuchoSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 帳票設計_DBC100071_介護保険高額総合事業サービス費支給申請書（ゆうちょ銀行）のプロパティです。
 *
 * @reamsid_L DBC-4770-090 jianglaisheng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KagoKuJigyoShikyuShinseishoYuchoProperty
        extends ReportPropertyBase<KogakuJigyoShikyuShinseishoYuchoSource> {

    /**
     * コンストラクタです。
     *
     */
    public KagoKuJigyoShikyuShinseishoYuchoProperty() {
        super(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100071.getReportId());
    }

}
