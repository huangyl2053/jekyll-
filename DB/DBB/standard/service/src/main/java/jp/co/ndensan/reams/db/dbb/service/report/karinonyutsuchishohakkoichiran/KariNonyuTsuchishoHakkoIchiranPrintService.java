/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.report.karinonyutsuchishohakkoichiran;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.karinonyutsuchishohakkoichiran.KariNonyuTsuchishoHakkoIchiranProperty;
import jp.co.ndensan.reams.db.dbb.business.report.karinonyutsuchishohakkoichiran.KariNonyuTsuchishoHakkoIchiranReport;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.KariSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.report.karinonyutsuchishohakkoichiran.KariNonyuTsuchishoHakkoIchiranSource;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 保険料納入通知書（仮算定）発行一覧表帳票クラスです。
 *
 * @reamsid_L DBB-0710-050 yebangqiang
 */
public class KariNonyuTsuchishoHakkoIchiranPrintService {

    /**
     * printメソッド
     *
     * @param entityList List<KariSanteiNonyuTsuchiShoJoho>
     * @param 出力順ID Long
     * @param 帳票作成日時 YMDHMS
     * @param 出力期 int
     * @return SourceDataCollection
     */
    public SourceDataCollection print(List<KariSanteiNonyuTsuchiShoJoho> entityList, Long 出力順ID, YMDHMS 帳票作成日時,
            int 出力期) {
        KariNonyuTsuchishoHakkoIchiranProperty property = new KariNonyuTsuchishoHakkoIchiranProperty();
        List<RString> 並び順List = get出力順(出力順ID);
        return new Printer<KariNonyuTsuchishoHakkoIchiranSource>().spool(property,
                new KariNonyuTsuchishoHakkoIchiranReport(entityList, 並び順List, 帳票作成日時, 出力期));
    }

    private List<RString> get出力順(Long 出力順ID) {
        IOutputOrder 並び順 = ChohyoShutsuryokujunFinderFactory.createInstance()
                .get出力順(SubGyomuCode.DBB介護賦課, ReportIdDBB.DBB200007.getReportId(), 出力順ID);
        List<RString> 並び順List = new ArrayList<>();
        if (並び順 != null) {
            for (ISetSortItem item : 並び順.get設定項目リスト()) {
                並び順List.add(item.get項目名());
            }
        }
        return 並び順List;
    }
}
