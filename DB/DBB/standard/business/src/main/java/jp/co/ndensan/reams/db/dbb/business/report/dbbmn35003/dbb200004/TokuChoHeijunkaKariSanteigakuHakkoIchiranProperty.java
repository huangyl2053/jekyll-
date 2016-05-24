package jp.co.ndensan.reams.db.dbb.business.report.dbbmn35003.dbb200004;

import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.report.dbbmn35003.dbb200004.TokuChoHeijunkaKariSanteigakuHakkoIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 特別徴収平準化_仮算定額変更通知書_発行一覧表のプロパティです。
 *
 * @reamsid_L DBB-0820-060 xuyue
 */
public class TokuChoHeijunkaKariSanteigakuHakkoIchiranProperty extends ReportPropertyBase<TokuChoHeijunkaKariSanteigakuHakkoIchiranReportSource> {

    /**
     * コンストラクタです。
     */
    public TokuChoHeijunkaKariSanteigakuHakkoIchiranProperty() {
        super(SubGyomuCode.DBB介護賦課, ReportIdDBB.DBB200004.getReportId());
    }

}
