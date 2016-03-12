/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.yokaigoyoshienshinseiichiran;

import jp.co.ndensan.reams.db.dbe.definition.core.reportId.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.entity.report.source.yokaigoyoshienshinseiichiran.YokaigoYoshienShinseiIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 *
 * 要介護認定・要支援認定等申請者一覧表のプロパティです。
 */
public class YokaigoYoshienShinseiIchiranProperty extends ReportPropertyBase<YokaigoYoshienShinseiIchiranReportSource> {

    /**
     * インスタンスを生成します。
     */
    public YokaigoYoshienShinseiIchiranProperty() {
        super(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE011001.getReportId());
    }
}
