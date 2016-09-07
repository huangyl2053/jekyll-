/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ikenshoirairirekiichiran;

import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ikenshoirairirekiichiran.IkenshoirairirekiIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * DBE230004_主治医意見書作成依頼履歴一覧表のプロパティクラスです。
 *
 * @reamsid_L DBE-1590-032 zuotao
 */
public class IkenshoirairirekiIchiranProperty extends ReportPropertyBase<IkenshoirairirekiIchiranReportSource> {

    /**
     * インスタンスを生成します。
     */
    public IkenshoirairirekiIchiranProperty() {
        super(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE230004.getReportId());
    }

}
