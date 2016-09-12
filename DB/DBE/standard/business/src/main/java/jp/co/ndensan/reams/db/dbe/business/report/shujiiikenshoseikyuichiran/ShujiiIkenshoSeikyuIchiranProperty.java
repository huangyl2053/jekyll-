/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shujiiikenshoseikyuichiran;

import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiiikenshoseikyuichiran.ShujiiIkenshoSeikyuIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 主治医意見書作成料請求一覧表のプロパティです。
 *
 * @reamsid_L DBE-1390-180 suguangjun
 */
public class ShujiiIkenshoSeikyuIchiranProperty extends ReportPropertyBase<ShujiiIkenshoSeikyuIchiranReportSource> {

    /**
     * インスタンスを生成します。
     */
    public ShujiiIkenshoSeikyuIchiranProperty() {
        super(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE013006.getReportId());
    }
}
