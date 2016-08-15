/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakujigyoshikyushinseisho;

import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.report.source.kogakujigyoshikyushinseisho.KogakuJigyoShikyuShinseishoSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 帳票設計_DBC100070_介護保険高額総合事業サービス費支給申請書のプロパティです。
 *
 * @reamsid_L DBC-4770-080 jianglaisheng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuJigyoShikyuShinseishoProperty
        extends ReportPropertyBase<KogakuJigyoShikyuShinseishoSource> {

    /**
     * コンストラクタです。
     *
     */
    public KogakuJigyoShikyuShinseishoProperty() {
        super(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100070.getReportId());
    }
}
