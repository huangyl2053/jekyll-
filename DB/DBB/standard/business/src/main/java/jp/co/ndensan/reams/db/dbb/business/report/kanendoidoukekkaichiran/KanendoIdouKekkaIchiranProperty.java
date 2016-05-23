/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.kanendoidoukekkaichiran;

import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.report.kanendoidoukekkaichiran.KanendoIdouKekkaIchiranSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 帳票設計_DBBRP45001_2_本算定異動（過年度）結果一覧表のプロパティです。
 *
 * @reamsid_L DBB-0910-030 zhangrui
 *
 */
public class KanendoIdouKekkaIchiranProperty extends ReportPropertyBase<KanendoIdouKekkaIchiranSource> {

    /**
     * コンストラクタです。
     *
     */
    public KanendoIdouKekkaIchiranProperty() {
        super(SubGyomuCode.DBB介護賦課, ReportIdDBB.DBB200027.getReportId());
    }

}
