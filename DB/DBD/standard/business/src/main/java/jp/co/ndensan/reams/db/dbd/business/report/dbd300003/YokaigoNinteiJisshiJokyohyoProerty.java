/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd300003;

import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd300003.YokaigoNinteiJisshiJokyohyoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * {@link YokaigoNinteiJisshiJokyohyoReportSource}のプロパティです。
 *
 * @reamsid_L DBD-1771-030 b_liuyang2
 */
public class YokaigoNinteiJisshiJokyohyoProerty extends ReportPropertyBase<YokaigoNinteiJisshiJokyohyoReportSource> {

    /**
     * コンストラクタです。
     */
    public YokaigoNinteiJisshiJokyohyoProerty() {
        super(SubGyomuCode.DBD介護受給, ReportIdDBD.DBD300003.getReportId());
    }
}
