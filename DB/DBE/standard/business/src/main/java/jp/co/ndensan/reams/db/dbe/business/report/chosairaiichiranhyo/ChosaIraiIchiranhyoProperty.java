/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosairaiichiranhyo;

import jp.co.ndensan.reams.db.dbe.entity.report.source.chosairaiichiranhyo.ChosaIraiIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 *
 * {@link 認定調査依頼一覧表のReport}のプロパティです。
 */
public class ChosaIraiIchiranhyoProperty extends ReportPropertyBase<ChosaIraiIchiranhyoReportSource> {

    private static final ReportId ID = new ReportId("DBE220002");

    /**
     * インスタンスを生成します。
     */
    public ChosaIraiIchiranhyoProperty() {
        super(SubGyomuCode.DBE認定支援, ID);
    }
}
