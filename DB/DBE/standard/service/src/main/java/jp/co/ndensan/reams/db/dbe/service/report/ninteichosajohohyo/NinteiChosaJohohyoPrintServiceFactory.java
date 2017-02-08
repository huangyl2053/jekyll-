/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.report.ninteichosajohohyo;

import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;

/**
 * 認定調査情報票のPrinterのファクトリークラスです。
 *
 * @author N3212 竹内 和紀
 */
public final class NinteiChosaJohohyoPrintServiceFactory {

    private static final RString 総合事業未実施 = new RString("1");
    private static final RString 総合事業実施済 = new RString("2");

    private NinteiChosaJohohyoPrintServiceFactory() {
    }

    /**
     * 認定調査情報票のPrinterクラスを生成します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @param 総合事業開始区分 総合事業開始区分
     * @param reportManager ReportManager
     * @return INinteiChosaJohohyoPrintService
     */
    public static INinteiChosaJohohyoPrintService create(RString 厚労省IF識別コード, RString 総合事業開始区分, ReportManager reportManager) {
        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード().equals(厚労省IF識別コード)) {
            if (総合事業実施済.equals(総合事業開始区分)) {
                return new NinteiChosaJohohyo09BSogojigyoPrintService(reportManager);
            } else if (総合事業未実施.equals(総合事業開始区分)) {
                return new NinteiChosaJohohyo09BPrintService(reportManager);
            }
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009.getコード().equals(厚労省IF識別コード)) {
            return new NinteiChosaJohohyo09APrintService(reportManager);
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2006_新要介護認定適用区分が未適用.getコード().equals(厚労省IF識別コード)) {
            return new NinteiChosaJohohyo06APrintService(reportManager);
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2002.getコード().equals(厚労省IF識別コード)) {
            return new NinteiChosaJohohyo02APrintService(reportManager);
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ99.getコード().equals(厚労省IF識別コード)) {
            return new NinteiChosaJohohyo99APrintService(reportManager);
        }
        return null;
    }
}
