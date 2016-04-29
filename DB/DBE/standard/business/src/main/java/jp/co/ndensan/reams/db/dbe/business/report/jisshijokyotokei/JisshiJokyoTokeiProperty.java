/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.jisshijokyotokei;

import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.entity.report.source.jisshijokyotokei.JisshiJokyoTokeiReportSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 要介護認定実施状況統計のプロパティです。
 *
 * @reamsid_L DBE-1450-040 dongyabin
 */
public class JisshiJokyoTokeiProperty extends ReportPropertyBase<JisshiJokyoTokeiReportSource> {

    private static final ReportId ID = ReportIdDBE.DBE701003.getReportId();

    /**
     * インスタンスを生成します。
     */
    public JisshiJokyoTokeiProperty() {
        super(SubGyomuCode.DBE認定支援, ID);
    }
}
