/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinsakaikaisaioshirasetsuchi;

import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaikaisaioshirasetsuchi.ShinsakaiKaisaiOshiraseTsuchiReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * {@link 介護認定審査会開催のお知らせのReport}のプロパティです。
 *
 * @reamsid_L DBE-0150-110 lishengli
 */
public class ShinsakaiKaisaiOshiraseTsuchiProperty extends ReportPropertyBase<ShinsakaiKaisaiOshiraseTsuchiReportSource> {

    /**
     * インスタンスを生成します。
     */
    public ShinsakaiKaisaiOshiraseTsuchiProperty() {
        super(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE515001.getReportId());
    }
}
