/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.iintokkitext;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteikekkahyo.TokkiJikou;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.jimutokkitext.JimuTokkiTextA3Entity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.iintokkitext.IinTokkiTextA3ReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 委員用特記事項A3版のReportクラスです。
 *
 * @reamsid_L DBE-0150-200 lishengli
 */
public class IinTokkiTextA3Report extends Report<IinTokkiTextA3ReportSource> {

    private final JimuTokkiTextA3Entity data;
    private static final int MAXCOUNT = 30;
    private static final int PAGETWO_MAXCOUNT = 34;

    /**
     * インスタンスを生成します。
     *
     * @param data 一次判定特+記事項A3版のEntityクラス
     */
    public IinTokkiTextA3Report(JimuTokkiTextA3Entity data) {
        this.data = data;
    }

    @Override
    public void writeBy(ReportSourceWriter<IinTokkiTextA3ReportSource> reportSourceWriter) {
        List<TokkiJikou> 短冊情報リスト = data.get特記事項_listChosa1();
        List<RString> 短冊リスト = get短冊リスト(短冊情報リスト);
        int a = 短冊情報リスト.size();
        int totalPages = (int) Math.ceil((double) a / PAGETWO_MAXCOUNT);
        for (int i = 0; i < MAXCOUNT; i++) {
            IIinTokkiTextA3Editor editor = new IinTokkiTextPage1A3Editor(data, 短冊リスト, i);
            IIinTokkiTextA3Builder builder = new IinTokkiTextA3Builder(editor);
            reportSourceWriter.writeLine(builder);
        }
        if (MAXCOUNT < 短冊リスト.size()) {
            for (int i = 0; i < 短冊リスト.size(); i++) {
                int page = (i + PAGETWO_MAXCOUNT) / PAGETWO_MAXCOUNT + 1;
                if (page <= totalPages) {
                    IIinTokkiTextA3Editor editor = new IinTokkiTextPage2A3Editor(data, 短冊リスト, i, page);
                    IIinTokkiTextA3Builder builder = new IinTokkiTextA3Builder(editor);
                    reportSourceWriter.writeLine(builder);
                }
            }
        }
    }

    private List<RString> get短冊リスト(List<TokkiJikou> 短冊情報リスト) {
        List<RString> bodyList = new ArrayList<>();
        if (!短冊情報リスト.isEmpty()) {
            for (TokkiJikou entity : 短冊情報リスト) {
                bodyList.add(entity.get事項番号());
                bodyList.add(entity.get項目名称());
            }
        }
        return bodyList;
    }

}
