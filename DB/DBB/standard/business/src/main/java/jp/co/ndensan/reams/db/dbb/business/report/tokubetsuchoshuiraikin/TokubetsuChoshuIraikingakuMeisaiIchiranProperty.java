/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshuiraikin;

import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshuiraikin.TokubetsuChoshuIraikingakuMeisaiIchiranSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 帳票設計_DBBRP44002_特別徴収依頼金額明細一覧表のプロパティです。
 *
 * @reamsid_L DBB-0880-080 zhangrui
 *
 */
public class TokubetsuChoshuIraikingakuMeisaiIchiranProperty
        extends ReportPropertyBase<TokubetsuChoshuIraikingakuMeisaiIchiranSource> {

    /**
     * コンストラクタです。
     *
     */
    public TokubetsuChoshuIraikingakuMeisaiIchiranProperty() {
        super(SubGyomuCode.DBB介護賦課, ReportIdDBB.DBB200023.getReportId());
    }
}
