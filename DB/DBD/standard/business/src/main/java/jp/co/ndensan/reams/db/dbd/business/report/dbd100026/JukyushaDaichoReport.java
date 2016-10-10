/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd100026;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.tyohyoshuturyokuyojukyushadaicho.TyohyoShutuRyokuYoJukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd100026.JukyushaDaichoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 受給者台帳のReportです。
 *
 * @reamsid_L DBD-1760-040 b_liuyang2
 */
public final class JukyushaDaichoReport extends Report<JukyushaDaichoReportSource> {

    private final TyohyoShutuRyokuYoJukyushaDaichoEntity 帳票出力用受給者台帳;
    private static final int NOCOUNT_5 = 5;
    private static final int NOCOUNT_7 = 7;

    /**
     * インスタンスを生成します。
     *
     * @param 帳票出力用受給者台帳 TyohyoShutuRyokuYoJukyushaDaichoEntity
     * @return 受給者台帳
     */
    public static JukyushaDaichoReport createReport(TyohyoShutuRyokuYoJukyushaDaichoEntity 帳票出力用受給者台帳) {
        return new JukyushaDaichoReport(帳票出力用受給者台帳);
    }

    private JukyushaDaichoReport(TyohyoShutuRyokuYoJukyushaDaichoEntity 帳票出力用受給者台帳) {
        this.帳票出力用受給者台帳 = 帳票出力用受給者台帳;

    }

    /**
     * writeBy
     *
     * @param writer ReportSourceWriter
     */
    @Override
    public void writeBy(ReportSourceWriter<JukyushaDaichoReportSource> writer) {
        int page1 = 0;
        int page2 = 0;
        int page3 = 0;
        int page4 = 0;
        int page5 = 0;
        int page6 = 0;
        int page7 = 0;
        int page8 = 0;
        int page9 = 0;
        int page10 = 0;
        int page11 = 0;
        int page12 = 0;
        int page13 = 0;
        int page14 = 0;
        int page15 = 0;
        int size = this.帳票出力用受給者台帳.get要介護認定情報EntityList().size();
        if (size % NOCOUNT_7 == 0) {
            page1 = this.帳票出力用受給者台帳.get要介護認定情報EntityList().size() / NOCOUNT_7;
        } else {
            page1 = this.帳票出力用受給者台帳.get要介護認定情報EntityList().size() / NOCOUNT_7 + 1;
        }
        if (size % NOCOUNT_5 == 0) {
            page2 = this.帳票出力用受給者台帳.get要介護認定情報EntityList().size() / NOCOUNT_5;
        } else {
            page2 = this.帳票出力用受給者台帳.get要介護認定情報EntityList().size() / NOCOUNT_5 + 1;
        }
        if (size % NOCOUNT_5 == 0) {
            page3 = this.帳票出力用受給者台帳.get要介護認定情報EntityList().size() / NOCOUNT_5;
        } else {
            page3 = this.帳票出力用受給者台帳.get要介護認定情報EntityList().size() / NOCOUNT_5 + 1;
        }
        if (size % NOCOUNT_5 == 0) {
            page4 = this.帳票出力用受給者台帳.get要介護認定情報EntityList().size() / NOCOUNT_5;
        } else {
            page4 = this.帳票出力用受給者台帳.get要介護認定情報EntityList().size() / NOCOUNT_5 + 1;
        }
        if (size % NOCOUNT_5 == 0) {
            page5 = this.帳票出力用受給者台帳.get要介護認定情報EntityList().size() / NOCOUNT_5;
        } else {
            page5 = this.帳票出力用受給者台帳.get要介護認定情報EntityList().size() / NOCOUNT_5 + 1;
        }
        if (size % NOCOUNT_5 == 0) {
            page6 = this.帳票出力用受給者台帳.get要介護認定情報EntityList().size() / NOCOUNT_5;
        } else {
            page6 = this.帳票出力用受給者台帳.get要介護認定情報EntityList().size() / NOCOUNT_5 + 1;
        }
        if (size % NOCOUNT_5 == 0) {
            page7 = this.帳票出力用受給者台帳.get要介護認定情報EntityList().size() / NOCOUNT_5;
        } else {
            page7 = this.帳票出力用受給者台帳.get要介護認定情報EntityList().size() / NOCOUNT_5 + 1;
        }
        if (size % NOCOUNT_5 == 0) {
            page8 = this.帳票出力用受給者台帳.get要介護認定情報EntityList().size() / NOCOUNT_5;
        } else {
            page8 = this.帳票出力用受給者台帳.get要介護認定情報EntityList().size() / NOCOUNT_5 + 1;
        }
        if (size % NOCOUNT_5 == 0) {
            page9 = this.帳票出力用受給者台帳.get要介護認定情報EntityList().size() / NOCOUNT_5;
        } else {
            page9 = this.帳票出力用受給者台帳.get要介護認定情報EntityList().size() / NOCOUNT_5 + 1;
        }
        if (size % NOCOUNT_5 == 0) {
            page10 = this.帳票出力用受給者台帳.get要介護認定情報EntityList().size() / NOCOUNT_5;
        } else {
            page10 = this.帳票出力用受給者台帳.get要介護認定情報EntityList().size() / NOCOUNT_5 + 1;
        }
        if (size % NOCOUNT_5 == 0) {
            page11 = this.帳票出力用受給者台帳.get要介護認定情報EntityList().size() / NOCOUNT_5;
        } else {
            page11 = this.帳票出力用受給者台帳.get要介護認定情報EntityList().size() / NOCOUNT_5 + 1;
        }
        if (size % NOCOUNT_5 == 0) {
            page12 = this.帳票出力用受給者台帳.get要介護認定情報EntityList().size() / NOCOUNT_5;
        } else {
            page12 = this.帳票出力用受給者台帳.get要介護認定情報EntityList().size() / NOCOUNT_5 + 1;
        }
        if (size % NOCOUNT_5 == 0) {
            page13 = this.帳票出力用受給者台帳.get要介護認定情報EntityList().size() / NOCOUNT_5;
        } else {
            page13 = this.帳票出力用受給者台帳.get要介護認定情報EntityList().size() / NOCOUNT_5 + 1;
        }
        if (size % NOCOUNT_5 == 0) {
            page14 = this.帳票出力用受給者台帳.get要介護認定情報EntityList().size() / NOCOUNT_5;
        } else {
            page14 = this.帳票出力用受給者台帳.get要介護認定情報EntityList().size() / NOCOUNT_5 + 1;
        }
        if (size % NOCOUNT_5 == 0) {
            page15 = this.帳票出力用受給者台帳.get要介護認定情報EntityList().size() / NOCOUNT_5;
        } else {
            page15 = this.帳票出力用受給者台帳.get要介護認定情報EntityList().size() / NOCOUNT_5 + 1;
        }
        List<Integer> pageList = new ArrayList<>();
        pageList.add(page1);
        pageList.add(page2);
        pageList.add(page3);
        pageList.add(page4);
        pageList.add(page5);
        pageList.add(page6);
        pageList.add(page7);
        pageList.add(page8);
        pageList.add(page9);
        pageList.add(page10);
        pageList.add(page11);
        pageList.add(page12);
        pageList.add(page13);
        pageList.add(page14);
        pageList.add(page15);

        int pageMax = Integer.MIN_VALUE;
        for (int i = 0; i < pageList.size(); i++) {
            int pege = pageList.get(i);
            if (pege > pageMax) {
                pageMax = pege;
            }
        }
        int page = 1;
        for (int index = 0; index < NOCOUNT_7 * pageMax; index++) {
            IJukyushaDaichoEditor bodyEditor = new JukyushaDaichoEditor(帳票出力用受給者台帳, index, page);
            IJukyushaDaichoBuilder builder = new JukyushaDaichoBuilder(bodyEditor);
            writer.writeLine(builder);
            page++;
        }
    }
}
