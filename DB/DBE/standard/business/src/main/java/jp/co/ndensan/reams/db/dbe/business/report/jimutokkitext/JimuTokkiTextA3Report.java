/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.jimutokkitext;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteikekkahyo.IchijihanteikekkahyoA3Entity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteikekkahyo.TokkiJikou;
import jp.co.ndensan.reams.db.dbe.entity.report.source.jimutokkitext.JimuTokkiTextA3ReportSource;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.TokkijikoTextImageKubun;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 事務局用一次判定+特記事項A3版のReportクラスです。
 *
 * @reamsid_L DBE-0150-320 lishengli
 */
public class JimuTokkiTextA3Report extends Report<JimuTokkiTextA3ReportSource> {

    private static final RString テキスト全面イメージ = new RString("1");
    private static final int PAGECOUN = 15;
    private static final int MAXCOUNT = 30;
    private static final int PAGETWO_MAXCOUNT = 34;
    private final IchijihanteikekkahyoA3Entity data;

    /**
     * インスタンスを生成します。
     *
     * @param data 一次判定+特記事項A3版のEntityクラス
     */
    public JimuTokkiTextA3Report(IchijihanteikekkahyoA3Entity data) {
        this.data = data;
    }

    @Override
    public void writeBy(ReportSourceWriter<JimuTokkiTextA3ReportSource> reportSourceWriter) {
        List<TokkiJikou> 短冊情報リスト = data.get特記事項_listChosa1();
        List<RString> 短冊リスト = get短冊リスト(短冊情報リスト);
        List<RString> テキスト全面List = data.get特記事項_tokkiText();
        List<RString> イメージ全面List = data.get特記事項_tokkiImg();
        for (int i = 0; i < MAXCOUNT; i++) {
            IJimuTokkiTextA3Editor editor = new JimuTokkiTextPage1A3Editor(data, 短冊リスト, i);
            IJimuTokkiTextA3Builder builder = new JimuTokkiTextA3Builder(editor);
            reportSourceWriter.writeLine(builder);
        }
        if (テキスト全面イメージ.equals(data.get特記パターン())) {
            if (TokkijikoTextImageKubun.テキスト.getコード().equals(data.get特記事項テキスト_イメージ区分())) {
                set全面テキスト(reportSourceWriter, テキスト全面List, 短冊リスト);
            } else {
                set全面イメージ(reportSourceWriter, イメージ全面List, 短冊リスト);
            }
        } else if (MAXCOUNT < 短冊リスト.size()) {
            int totalPages = (int) Math.ceil((double) (短冊情報リスト.size() - PAGECOUN) / PAGETWO_MAXCOUNT) + 1;
            for (int i = 0; i < 短冊リスト.size(); i++) {
                int page = (i + PAGETWO_MAXCOUNT) / PAGETWO_MAXCOUNT + 1;
                if (page <= totalPages) {
                    IJimuTokkiTextA3Editor editor = new JimuTokkiTextPage2A3Editor(data, 短冊リスト, i, page);
                    IJimuTokkiTextA3Builder builder = new JimuTokkiTextA3Builder(editor);
                    reportSourceWriter.writeLine(builder);
                }
            }
        }
    }

    private List<RString> get短冊リスト(List<TokkiJikou> 短冊情報リスト) {
        List<RString> bodyList = new ArrayList<>();
        if (短冊情報リスト != null && !短冊情報リスト.isEmpty()) {
            for (TokkiJikou entity : 短冊情報リスト) {
                bodyList.add(entity.get事項番号());
                bodyList.add(entity.get項目名称());
            }
        }
        return bodyList;
    }

    private void set全面テキスト(ReportSourceWriter<JimuTokkiTextA3ReportSource> reportSourceWriter,
            List<RString> テキスト全面List, List<RString> 短冊リスト) {
        int totalPages = (int) Math.ceil((double) (テキスト全面List.size() - 1) / 2) + 1;
        for (int i = 0; i < テキスト全面List.size(); i++) {
            if ((i + 2) <= totalPages) {
                IJimuTokkiTextA3Editor editor = new JimuTokkiTextPage2A3Editor(data, 短冊リスト, i + 2, i + 2);
                IJimuTokkiTextA3Builder builder = new JimuTokkiTextA3Builder(editor);
                reportSourceWriter.writeLine(builder);
            }
        }
    }

    private void set全面イメージ(ReportSourceWriter<JimuTokkiTextA3ReportSource> reportSourceWriter,
            List<RString> イメージ全面List, List<RString> 短冊リスト) {
        int totalPages = (int) Math.ceil((double) (イメージ全面List.size() - 1) / 2) + 1;
        for (int i = 0; i < イメージ全面List.size(); i++) {
            if ((i + 2) <= totalPages) {
                IJimuTokkiTextA3Editor editor = new JimuTokkiTextPage2A3Editor(data, 短冊リスト, i + 2, i + 2);
                IJimuTokkiTextA3Builder builder = new JimuTokkiTextA3Builder(editor);
                reportSourceWriter.writeLine(builder);
            }
        }
    }
}
