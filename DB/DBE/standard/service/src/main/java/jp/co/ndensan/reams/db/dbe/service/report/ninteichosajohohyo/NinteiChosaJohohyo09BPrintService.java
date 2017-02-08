/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.report.ninteichosajohohyo;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyochosaitem.NinteichosahyoChosaItem;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyokinyuitem.NinteichosahyoKinyuItem;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyoservicejokyo.NinteichosahyoServiceJokyo;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyoservicejokyoflag.NinteichosahyoServiceJokyoFlag;
import jp.co.ndensan.reams.db.dbe.business.core.yokaigoninteijohoteikyo.YokaigoNinteiJohoTeikyoBusiness;
import jp.co.ndensan.reams.db.dbe.business.report.ninteichosajohohyo12.NinteiChosaJohohyo09BProperty;
import jp.co.ndensan.reams.db.dbe.business.report.ninteichosajohohyo12.NinteiChosaJohohyo12EntityEditor;
import jp.co.ndensan.reams.db.dbe.business.report.ninteichosajohohyo12.NinteiChosaJohohyo12Report;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ninteichosajohohyo.NinteiChosaJohohyo12ReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;

/**
 * 認定調査票情報_09BのPrinterクラスです。
 *
 * @author N3212 竹内 和紀
 */
public class NinteiChosaJohohyo09BPrintService implements INinteiChosaJohohyoPrintService {

    private final ReportManager reportManager;

    /**
     * コンストラクタです。
     *
     * @param reportManager
     */
    public NinteiChosaJohohyo09BPrintService(ReportManager reportManager) {
        this.reportManager = reportManager;
    }

    @Override
    public void print(YokaigoNinteiJohoTeikyoBusiness business,
            RDateTime イメージ共有ファイルID,
            List<NinteichosahyoServiceJokyo> 認定調査票サービス状況List,
            List<NinteichosahyoServiceJokyoFlag> 認定調査票サービス状況フラグList,
            List<NinteichosahyoChosaItem> 認定調査票調査項目List,
            List<NinteichosahyoKinyuItem> 認定調査票記入項目List,
            RString 認定調査票マスキング区分,
            RString 特記事項マスキング区分,
            RString 主治医意見書マスキング区分) {
        NinteiChosaJohohyo09BProperty property = new NinteiChosaJohohyo09BProperty();
        new Printer<NinteiChosaJohohyo12ReportSource>().spool(property,
                new NinteiChosaJohohyo12Report(NinteiChosaJohohyo12EntityEditor.edit(business.toEntity(), 認定調査票サービス状況List,
                                認定調査票サービス状況フラグList, 認定調査票調査項目List, 認定調査票記入項目List, イメージ共有ファイルID,
                                認定調査票マスキング区分, 主治医意見書マスキング区分)));
    }
}
