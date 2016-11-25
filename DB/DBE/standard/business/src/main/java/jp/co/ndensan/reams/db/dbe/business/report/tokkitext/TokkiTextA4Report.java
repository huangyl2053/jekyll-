/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.tokkitext;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.TokkiText1A4Business;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.tokkitexta4.TokkiA4Entity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.tokkitext.TokkiTextA4ReportSource;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.TokkijikoTextImageKubun;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 特記事項A4版のReportです。
 *
 * @reamsid_L DBE-0150-340 lishengli
 */
public class TokkiTextA4Report extends Report<TokkiTextA4ReportSource> {

    private static final int MAXCOUNT = 30;
    private static final RString テキスト全面イメージ = new RString("1");
    private final TokkiText1A4Business data;

    /**
     * インスタンスを生成します。
     *
     * @param data 委員用特記事項の編集クラス
     */
    public TokkiTextA4Report(TokkiText1A4Business data) {
        this.data = data;
    }

    @Override
    public void writeBy(ReportSourceWriter<TokkiTextA4ReportSource> reportSourceWriter) {
        List<TokkiA4Entity> 短冊情報リスト = data.get短冊情報リスト();
        List<RString> 短冊リスト = get短冊リスト(短冊情報リスト);
        List<RString> テキスト全面List = data.getTokkiText();
        List<RString> イメージ全面List = data.getTokkiImg();
        if (テキスト全面イメージ.equals(data.get特記パターン())) {
            if (TokkijikoTextImageKubun.テキスト.getコード().equals(data.get特記事項テキスト_イメージ区分())) {
                set全面テキスト(reportSourceWriter, 短冊情報リスト, 短冊リスト, テキスト全面List, イメージ全面List);
            } else {
                set全面イメージ(reportSourceWriter, 短冊情報リスト, 短冊リスト, テキスト全面List, イメージ全面List);
            }
        } else {
            for (int i = 0; i < 短冊リスト.size(); i++) {
                if (i < MAXCOUNT) {
                    ITokkiTextA4Editor editor1 = new TokkiTextPage1A4Editor(data, 短冊情報リスト, 短冊リスト, テキスト全面List, イメージ全面List, i);
                    ITokkiTextA4Builder builder = new TokkiTextA4Builder(editor1);
                    reportSourceWriter.writeLine(builder);
                } else {
                    int page = (i + MAXCOUNT) / MAXCOUNT;
                    ITokkiTextA4Editor editor2 = new TokkiTextPage2A4Editor(data,
                            短冊情報リスト, 短冊リスト, テキスト全面List, イメージ全面List, i, page);
                    ITokkiTextA4Builder builder2 = new TokkiTextA4Builder(editor2);
                    reportSourceWriter.writeLine(builder2);
                }
            }
        }
    }

    private List<RString> get短冊リスト(List<TokkiA4Entity> 短冊情報リスト) {
        List<RString> bodyList = new ArrayList<>();
        if (短冊情報リスト != null && !短冊情報リスト.isEmpty()) {
            for (TokkiA4Entity entity : 短冊情報リスト) {
                bodyList.add(entity.get事項番号());
                bodyList.add(entity.get項目名称());
            }
        }
        return bodyList;
    }

    private void set全面テキスト(ReportSourceWriter<TokkiTextA4ReportSource> reportSourceWriter,
            List<TokkiA4Entity> 短冊情報リスト, List<RString> 短冊リスト, List<RString> テキスト全面List, List<RString> イメージ全面List) {
        for (int i = 0; i < テキスト全面List.size(); i++) {
            if (i == 0) {
                ITokkiTextA4Editor editor1 = new TokkiTextPage1A4Editor(data, 短冊情報リスト, 短冊リスト, テキスト全面List, イメージ全面List, i);
                ITokkiTextA4Builder builder = new TokkiTextA4Builder(editor1);
                reportSourceWriter.writeLine(builder);
            } else {
                ITokkiTextA4Editor editor2 = new TokkiTextPage2A4Editor(data,
                        短冊情報リスト, 短冊リスト, テキスト全面List, イメージ全面List, i, i + 1);
                ITokkiTextA4Builder builder2 = new TokkiTextA4Builder(editor2);
                reportSourceWriter.writeLine(builder2);
            }
        }
    }

    private void set全面イメージ(ReportSourceWriter<TokkiTextA4ReportSource> reportSourceWriter,
            List<TokkiA4Entity> 短冊情報リスト, List<RString> 短冊リスト, List<RString> テキスト全面List, List<RString> イメージ全面List) {
        for (int i = 0; i < イメージ全面List.size(); i++) {
            if (i == 0) {
                ITokkiTextA4Editor editor1 = new TokkiTextPage1A4Editor(data, 短冊情報リスト, 短冊リスト, テキスト全面List, イメージ全面List, i);
                ITokkiTextA4Builder builder = new TokkiTextA4Builder(editor1);
                reportSourceWriter.writeLine(builder);
            } else {
                ITokkiTextA4Editor editor2 = new TokkiTextPage2A4Editor(data,
                        短冊情報リスト, 短冊リスト, テキスト全面List, イメージ全面List, i, i + 1);
                ITokkiTextA4Builder builder2 = new TokkiTextA4Builder(editor2);
                reportSourceWriter.writeLine(builder2);
            }
        }
    }
}
