/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tsukibetsusuiihyo;

import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.report.source.tsukibetsusuiihyo.TsukibetsuSuiihyoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 月別推移表のプロパティです。
 *
 * @reamsid_L DBB-0760-050 wangxiaodong
 */
public class TsukibetsuSuiihyoProerty extends ReportPropertyBase<TsukibetsuSuiihyoReportSource> {

    /**
     * コンストラクタです。
     */
    public TsukibetsuSuiihyoProerty() {
        super(SubGyomuCode.DBB介護賦課, ReportIdDBB.DBB300002.getReportId());
    }
}
