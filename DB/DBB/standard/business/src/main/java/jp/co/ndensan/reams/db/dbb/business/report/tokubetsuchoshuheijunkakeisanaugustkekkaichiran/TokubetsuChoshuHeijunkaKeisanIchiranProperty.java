/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshuheijunkakeisanaugustkekkaichiran;

import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshuheijunkakeisanaugustkekkaichiran.TokubetsuChoshuHeijunkaKeisanIchiranSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 帳票設計_DBBPR35002_特別徴収平準化計算（特別徴収8月分）結果一覧表 Propertyクラスです。
 *
 * @reamsid_L DBB-0860-060 lijian
 */
public class TokubetsuChoshuHeijunkaKeisanIchiranProperty
        extends ReportPropertyBase<TokubetsuChoshuHeijunkaKeisanIchiranSource> {

    /**
     * コンストラクタです。
     *
     */
    public TokubetsuChoshuHeijunkaKeisanIchiranProperty() {
        super(SubGyomuCode.DBB介護賦課, ReportIdDBB.DBB200005.getReportId());
    }
}
