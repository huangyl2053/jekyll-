/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.nofugakuichirancodefumei;

import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.report.source.nofugakuichirancodefumei.NofugakuIchiranCodeFumeiSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 帳票設計_DBBRP91003-2_納付額一覧表（識別コード不明分） のPropertyクラスです。
 *
 * @reamsid_L DBB-1890-050 qinzhen
 */
public class NofugakuIchiranCodeFumeiProperty extends
        ReportPropertyBase<NofugakuIchiranCodeFumeiSource> {

    /**
     * コンストラクタです。
     */
    public NofugakuIchiranCodeFumeiProperty() {

        super(SubGyomuCode.DBB介護賦課, ReportIdDBB.DBB300006.getReportId());
    }
}
