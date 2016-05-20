/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchishokarihakkoichiran;

import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchishokarihakkoichiran.TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 特別徴収開始通知書（仮算定）発行一覧表Propertyクラスです。
 *
 * @reamsid_L DBB-0790-060 surun
 */
public class Property extends
        ReportPropertyBase<TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource> {

    private static final ReportId ID = ReportIdDBB.DBB200001.getReportId();

    /**
     * コンストラクタです。
     */
    public Property() {
        super(SubGyomuCode.DBB介護賦課, ID);
    }
}
