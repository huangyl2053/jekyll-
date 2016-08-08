/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd550004;

import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd550004.YokaigoNinteiTorikeshiTshuchishoSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * {@link YokaigoNinteiTorikeshiTshuchishoSource}のプロパティです。
 *
 * @reamsid_L DBD-1440-010 liuyl
 */
public class YokaigoNinteiTorikeshiTshuchishoProperty extends ReportPropertyBase<YokaigoNinteiTorikeshiTshuchishoSource> {

    /**
     * コンストラクタです。
     */
    public YokaigoNinteiTorikeshiTshuchishoProperty() {
        super(SubGyomuCode.DBD介護受給, ReportIdDBD.DBD550004.getReportId());
    }
}
