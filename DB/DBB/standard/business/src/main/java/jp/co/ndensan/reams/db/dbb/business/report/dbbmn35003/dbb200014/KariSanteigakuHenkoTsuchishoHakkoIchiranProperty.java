package jp.co.ndensan.reams.db.dbb.business.report.dbbmn35003.dbb200014;

import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.report.dbbmn35003.dbb200014.KariSanteigakuHenkoTsuchishoHakkoIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 仮算定額変更通知書発行一覧表のプロパティです。
 *
 * @reamsid_L DBB-0820-060 xuyue
 */
public class KariSanteigakuHenkoTsuchishoHakkoIchiranProperty extends ReportPropertyBase<KariSanteigakuHenkoTsuchishoHakkoIchiranReportSource> {

    /**
     * コンストラクタです。
     */
    public KariSanteigakuHenkoTsuchishoHakkoIchiranProperty() {
        super(SubGyomuCode.DBB介護賦課, ReportIdDBB.DBB200014.getReportId());
    }

}
