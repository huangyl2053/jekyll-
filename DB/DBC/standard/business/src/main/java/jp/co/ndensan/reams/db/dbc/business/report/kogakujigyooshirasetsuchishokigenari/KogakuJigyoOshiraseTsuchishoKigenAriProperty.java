/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakujigyooshirasetsuchishokigenari;

import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.report.kogakujigyooshirasetsuchisho.KogakuJigyoOshiraseTsuchishoKigenAriSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 高額総合事業サービス費給付お知らせ通知書（提出期限あり）Propertyクラスです。
 *
 * @reamsid_L DBC-4770-100 wangxingpeng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuJigyoOshiraseTsuchishoKigenAriProperty extends ReportPropertyBase<KogakuJigyoOshiraseTsuchishoKigenAriSource> {

    /**
     * コンストラクタです。
     *
     */
    public KogakuJigyoOshiraseTsuchishoKigenAriProperty() {
        super(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100072.getReportId());
    }

}
