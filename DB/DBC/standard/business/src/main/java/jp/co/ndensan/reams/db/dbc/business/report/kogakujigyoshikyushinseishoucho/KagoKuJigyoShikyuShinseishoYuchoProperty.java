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
 * 過誤決定通知書情報取込一覧表（公費負担者分）帳票のプロパティです。
 *
 * @reamsid_L DBC-0980-510 surun
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
