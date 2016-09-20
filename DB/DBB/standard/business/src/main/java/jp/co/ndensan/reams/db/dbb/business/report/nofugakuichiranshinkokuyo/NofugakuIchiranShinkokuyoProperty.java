/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.nofugakuichiranshinkokuyo;

import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.report.source.nofugakuichiranshinkokuyo.NofugakuIchiranShinkokuyoSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 帳票設計_DBBRP91003-1_納付額一覧表（確定申告用） のPropertyクラスです。
 *
 * @reamsid_L DBB-1890-040 qinzhen
 */
public class NofugakuIchiranShinkokuyoProperty extends
        ReportPropertyBase<NofugakuIchiranShinkokuyoSource> {

    /**
     * コンストラクタです。
     */
    public NofugakuIchiranShinkokuyoProperty() {

        super(SubGyomuCode.DBB介護賦課, ReportIdDBB.DBB300005.getReportId());
    }
}
