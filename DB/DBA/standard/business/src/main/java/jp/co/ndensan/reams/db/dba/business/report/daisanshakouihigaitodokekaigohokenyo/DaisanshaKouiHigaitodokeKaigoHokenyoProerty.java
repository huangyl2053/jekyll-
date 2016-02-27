/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.daisanshakouihigaitodokekaigohokenyo;

import jp.co.ndensan.reams.db.dba.definition.reportId.ReportIdDBA;
import jp.co.ndensan.reams.db.dba.entity.report.daisanshakouihigaitodokekaigohokenyo.DaisanshaKouiHigaitodokeKaigoHokenyoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 *
 * {@link DaisanshaKouiHigaitodokeKaigoHokenyoProerty}のプロパティです。
 */
public class DaisanshaKouiHigaitodokeKaigoHokenyoProerty extends ReportPropertyBase<DaisanshaKouiHigaitodokeKaigoHokenyoReportSource> {

    /**
     * コンストラクタです。
     */
    public DaisanshaKouiHigaitodokeKaigoHokenyoProerty() {
        super(SubGyomuCode.DBA介護資格, ReportIdDBA.DBC800020.getReportId());
    }
}
