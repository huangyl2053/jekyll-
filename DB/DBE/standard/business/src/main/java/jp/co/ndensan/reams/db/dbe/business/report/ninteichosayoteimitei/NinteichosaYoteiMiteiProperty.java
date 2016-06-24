/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ninteichosayoteimitei;

import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ninteichosayoteimitei.NinteichosaYoteiMiteiReportSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 認定調査予定未定者一覧表のプロパティです。
 *
 * @reamsid_L DBE-1390-110 dongyabin
 */
public class NinteichosaYoteiMiteiProperty extends ReportPropertyBase<NinteichosaYoteiMiteiReportSource> {

    private static final ReportId ID = ReportIdDBE.DBE012001.getReportId();

    /**
     * インスタンスを生成します。
     */
    public NinteichosaYoteiMiteiProperty() {
        super(SubGyomuCode.DBE認定支援, ID);
    }
}
