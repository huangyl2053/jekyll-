/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.nenreitotatsukakuninlist;

import jp.co.ndensan.reams.db.dba.definition.reportid.ReportIdDBA;
import jp.co.ndensan.reams.db.dba.entity.report.nenreitotatsukakuninlist.NenreitotatsuKakuninListReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * {@link NenreitotatsuKakuninListReportSource}のプロパティです。
 *
 * @author n3423
 */
public class NenreitotatsuKakuninListProperty extends ReportPropertyBase<NenreitotatsuKakuninListReportSource> {

    /**
     * コンストラクタです。
     */
    public NenreitotatsuKakuninListProperty() {
        super(SubGyomuCode.DBA介護資格, ReportIdDBA.DBA200008.getReportId());
    }

}
