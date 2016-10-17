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
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 受給者台帳のReportです。
 *
 * @reamsid_L DBD-1760-040 b_liuyang2
 */
public final class JukyushaDaichoReport extends Report<JukyushaDaichoReportSource> {

    private final TyohyoShutuRyokuYoJukyushaDaichoEntity 帳票出力用受給者台帳;
    private final RString 出力オプション;
    private static final int NOCOUNT_5 = 5;
    private static final int NOCOUNT_7 = 7;
    private static final RString ZERO = new RString("0");
    private static final RString ONE = new RString("1");

    /**
     * インスタンスを生成します。
     *
     * @param 帳票出力用受給者台帳 TyohyoShutuRyokuYoJukyushaDaichoEntity
     * @param 出力オプション RString
     *
     */
    public JukyushaDaichoReport(TyohyoShutuRyokuYoJukyushaDaichoEntity 帳票出力用受給者台帳, RString 出力オプション) {
        this.帳票出力用受給者台帳 = 帳票出力用受給者台帳;
        this.出力オプション = 出力オプション;

    }

    /**
     * writeBy
     *
     * @param writer ReportSourceWriter
     */
    @Override
    public void writeBy(ReportSourceWriter<JukyushaDaichoReportSource> writer) {
        if (this.出力オプション.equals(ZERO)) {
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

            int size1 = this.帳票出力用受給者台帳.get要介護認定情報EntityList().size();
            if (size1 % NOCOUNT_7 == 0) {
                page1 = this.帳票出力用受給者台帳.get要介護認定情報EntityList().size() / NOCOUNT_7;
            } else {
                page1 = this.帳票出力用受給者台帳.get要介護認定情報EntityList().size() / NOCOUNT_7 + 1;
            }

            int size2 = this.帳票出力用受給者台帳.get負担限度額認定情報EntityList().size();
            if (size2 % NOCOUNT_5 == 0) {
                page2 = this.帳票出力用受給者台帳.get負担限度額認定情報EntityList().size() / NOCOUNT_5;
            } else {
                page2 = this.帳票出力用受給者台帳.get負担限度額認定情報EntityList().size() / NOCOUNT_5 + 1;
            }

            int size3 = this.帳票出力用受給者台帳.get社福法人軽減情報EntityList().size();
            if (size3 % NOCOUNT_5 == 0) {
                page3 = this.帳票出力用受給者台帳.get社福法人軽減情報EntityList().size() / NOCOUNT_5;
            } else {
                page3 = this.帳票出力用受給者台帳.get社福法人軽減情報EntityList().size() / NOCOUNT_5 + 1;
            }

            int size4 = this.帳票出力用受給者台帳.get利用者負担減免情報EntityList().size();
            if (size4 % NOCOUNT_5 == 0) {
                page4 = this.帳票出力用受給者台帳.get利用者負担減免情報EntityList().size() / NOCOUNT_5;
            } else {
                page4 = this.帳票出力用受給者台帳.get利用者負担減免情報EntityList().size() / NOCOUNT_5 + 1;
            }

            int size5 = this.帳票出力用受給者台帳.get訪問介護等減額情報EntityList().size();
            if (size5 % NOCOUNT_5 == 0) {
                page5 = this.帳票出力用受給者台帳.get訪問介護等減額情報EntityList().size() / NOCOUNT_5;
            } else {
                page5 = this.帳票出力用受給者台帳.get訪問介護等減額情報EntityList().size() / NOCOUNT_5 + 1;
            }

            int size6 = this.帳票出力用受給者台帳.get標準負担減額情報EntityList().size();
            if (size6 % NOCOUNT_5 == 0) {
                page6 = this.帳票出力用受給者台帳.get標準負担減額情報EntityList().size() / NOCOUNT_5;
            } else {
                page6 = this.帳票出力用受給者台帳.get標準負担減額情報EntityList().size() / NOCOUNT_5 + 1;
            }

            int size7 = this.帳票出力用受給者台帳.get特別地域加算減免情報EntityList().size();
            if (size7 % NOCOUNT_5 == 0) {
                page7 = this.帳票出力用受給者台帳.get特別地域加算減免情報EntityList().size() / NOCOUNT_5;
            } else {
                page7 = this.帳票出力用受給者台帳.get特別地域加算減免情報EntityList().size() / NOCOUNT_5 + 1;
            }

            int size8 = this.帳票出力用受給者台帳.get施設入退所情報EntityList().size();
            if (size8 % NOCOUNT_5 == 0) {
                page8 = this.帳票出力用受給者台帳.get施設入退所情報EntityList().size() / NOCOUNT_5;
            } else {
                page8 = this.帳票出力用受給者台帳.get施設入退所情報EntityList().size() / NOCOUNT_5 + 1;
            }

            int size9 = this.帳票出力用受給者台帳.get居宅計画届出情報EntityList().size();
            if (size9 % NOCOUNT_5 == 0) {
                page9 = this.帳票出力用受給者台帳.get居宅計画届出情報EntityList().size() / NOCOUNT_5;
            } else {
                page9 = this.帳票出力用受給者台帳.get居宅計画届出情報EntityList().size() / NOCOUNT_5 + 1;
            }

            int size10 = this.帳票出力用受給者台帳.get特例施設入退所情報EntityList().size();
            if (size10 % NOCOUNT_5 == 0) {
                page10 = this.帳票出力用受給者台帳.get特例施設入退所情報EntityList().size() / NOCOUNT_5;
            } else {
                page10 = this.帳票出力用受給者台帳.get特例施設入退所情報EntityList().size() / NOCOUNT_5 + 1;
            }

            int size11 = this.帳票出力用受給者台帳.get支払方法変更情報EntityList().size();
            if (size11 % NOCOUNT_5 == 0) {
                page11 = this.帳票出力用受給者台帳.get支払方法変更情報EntityList().size() / NOCOUNT_5;
            } else {
                page11 = this.帳票出力用受給者台帳.get支払方法変更情報EntityList().size() / NOCOUNT_5 + 1;
            }

            int size12 = this.帳票出力用受給者台帳.get給付額減額情報EntityList().size();
            if (size12 % NOCOUNT_5 == 0) {
                page12 = this.帳票出力用受給者台帳.get給付額減額情報EntityList().size() / NOCOUNT_5;
            } else {
                page12 = this.帳票出力用受給者台帳.get給付額減額情報EntityList().size() / NOCOUNT_5 + 1;
            }

            int size13 = this.帳票出力用受給者台帳.get資格情報EntityList().size();
            if (size13 % NOCOUNT_5 == 0) {
                page13 = this.帳票出力用受給者台帳.get資格情報EntityList().size() / NOCOUNT_5;
            } else {
                page13 = this.帳票出力用受給者台帳.get資格情報EntityList().size() / NOCOUNT_5 + 1;
            }

            int size14 = this.帳票出力用受給者台帳.get老齢福祉年金情報EntityList().size();
            if (size14 % NOCOUNT_5 == 0) {
                page14 = this.帳票出力用受給者台帳.get老齢福祉年金情報EntityList().size() / NOCOUNT_5;
            } else {
                page14 = this.帳票出力用受給者台帳.get老齢福祉年金情報EntityList().size() / NOCOUNT_5 + 1;
            }

            int size15 = this.帳票出力用受給者台帳.get生活保護情報EntityList().size();
            if (size15 % NOCOUNT_5 == 0) {
                page15 = this.帳票出力用受給者台帳.get生活保護情報EntityList().size() / NOCOUNT_5;
            } else {
                page15 = this.帳票出力用受給者台帳.get生活保護情報EntityList().size() / NOCOUNT_5 + 1;
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
            get帳票出力用情報(writer, pageList);
        } else if (this.出力オプション.equals(ONE)) {
            int page = 1;
            int pageMax = 1;
            for (int index = 0; index < NOCOUNT_7; index++) {
                IJukyushaDaichoEditor bodyEditor = new JukyushaDaichoEditor(帳票出力用受給者台帳, index, page, pageMax);
                IJukyushaDaichoBuilder builder = new JukyushaDaichoBuilder(bodyEditor);
                writer.writeLine(builder);
            }
        }

    }

    private void get帳票出力用情報(ReportSourceWriter<JukyushaDaichoReportSource> writer, List<Integer> pageList) {

        int pageMax = Integer.MIN_VALUE;
        for (int i = 0; i < pageList.size(); i++) {
            int page = pageList.get(i);
            if (page > pageMax) {
                pageMax = page;
            }
        }

        for (int page = 1; page < pageMax; page++) {
            for (int index = page * (page - 1); index < NOCOUNT_7 * page; index++) {
                IJukyushaDaichoEditor bodyEditor = new JukyushaDaichoEditor(帳票出力用受給者台帳, index, page, pageMax);
                IJukyushaDaichoBuilder builder = new JukyushaDaichoBuilder(bodyEditor);
                writer.writeLine(builder);
            }
        }

    }
}
