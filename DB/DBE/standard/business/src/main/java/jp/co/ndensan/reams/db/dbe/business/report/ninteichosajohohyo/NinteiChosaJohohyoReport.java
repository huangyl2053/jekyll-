/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ninteichosajohohyo;

import jp.co.ndensan.reams.db.dbe.entity.report.source.ninteichosajohohyo.NinteiChosaJohohyoEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ninteichosajohohyo.NinteiChosaJohohyoReportSource;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 認定調査票情報のReportです。
 *
 * @reamsid_L DBE-0230-090 zhangzhiming
 */
public class NinteiChosaJohohyoReport extends Report<NinteiChosaJohohyoReportSource> {

    private final NinteiChosaJohohyoEntity entity;
    private static final int ZERO = 0;

    /**
     * インスタンスを生成します。
     *
     * @param entity 認定調査票情報のItem
     */
    public NinteiChosaJohohyoReport(NinteiChosaJohohyoEntity entity) {
        this.entity = entity;
    }

    /**
     * 認定調査票情報を生成します。
     *
     * @param reportSourceWriter 帳票Writer
     */
    @Override
    public void writeBy(ReportSourceWriter<NinteiChosaJohohyoReportSource> reportSourceWriter) {
        int maxCount = getMaxBreakCount(entity);
        for (int i = ZERO; i < maxCount; i++) {
            INinteiChosaJohohyoEditor editor = new NinteiChosaJohohyoEditor(entity, i);
            INinteiChosaJohohyoBuilder builder = new NinteiChosaJohohyoBuilder(editor);
            reportSourceWriter.writeLine(builder);
        }
    }

    private int getMaxBreakCount(NinteiChosaJohohyoEntity reportJoho) {
        int maxCount = ZERO;
        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード().equals(reportJoho.get厚労省IF識別コード())) {
            maxCount = reportJoho.getサービス区分リスト().size();
        }
        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009.getコード().equals(reportJoho.get厚労省IF識別コード())) {
            maxCount = reportJoho.getサービス区分リスト_22().size();
        }
        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2006_新要介護認定適用区分が未適用.getコード().equals(reportJoho.get厚労省IF識別コード())) {
            maxCount = reportJoho.getサービス区分リスト_32().size();
        }
        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2002.getコード().equals(reportJoho.get厚労省IF識別コード())) {
            maxCount = reportJoho.getサービス区分リスト_42().size();
        }
        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ99.getコード().equals(reportJoho.get厚労省IF識別コード())) {
            maxCount = reportJoho.getサービス区分リスト_52().size();
        }
        return maxCount;
    }
}
