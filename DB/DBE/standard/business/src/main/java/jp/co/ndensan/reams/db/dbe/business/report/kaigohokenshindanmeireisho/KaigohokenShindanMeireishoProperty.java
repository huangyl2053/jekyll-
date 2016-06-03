/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.kaigohokenshindanmeireisho;

import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.entity.report.source.kaigohokenshindanmeireisho.KaigohokenShindanMeireishoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 介護保険診断命令書のReport}のプロパティです。
 *
 * @reamsid_L DBE-0080-070 wangxiaodong
 */
public class KaigohokenShindanMeireishoProperty extends ReportPropertyBase<KaigohokenShindanMeireishoReportSource> {

    /**
     * インスタンスを生成します。
     */
    public KaigohokenShindanMeireishoProperty() {
        super(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE235001.getReportId());
    }

}
