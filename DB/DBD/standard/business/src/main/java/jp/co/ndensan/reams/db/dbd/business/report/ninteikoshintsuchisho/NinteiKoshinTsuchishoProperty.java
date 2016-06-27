/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.ninteikoshintsuchisho;

import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.report.ninteikoshintsuchisho.NinteiKoshinTsuchisho;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * {@link NinteiKoshinTsuchisho}のプロパティです。
 *
 * @reamsid_L DBD-3570-040 liangbc
 */
public class NinteiKoshinTsuchishoProperty extends ReportPropertyBase<NinteiKoshinTsuchisho> {

    private static final ReportId ID = ReportIdDBD.DBDPR12002_1_1.getReportId();

    /**
     * インスタンスを生成します。
     */
    public NinteiKoshinTsuchishoProperty() {
        super(SubGyomuCode.DBD介護受給, ID);
    }
}
