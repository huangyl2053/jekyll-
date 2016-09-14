/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.riyojokyotokeihyo;

import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.report.source.riyojokyotokeihyo.RiyoJokyoTokeihyoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 利用状況統計表のプロパティです。
 *
 * @reamsid_L DBC-3500-050 jinjue
 */
public class RiyoJokyoTokeihyoProperty extends ReportPropertyBase<RiyoJokyoTokeihyoReportSource> {

    /**
     * コンストラクタです。
     */
    public RiyoJokyoTokeihyoProperty() {
        super(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC300005.getReportId());
    }
}
