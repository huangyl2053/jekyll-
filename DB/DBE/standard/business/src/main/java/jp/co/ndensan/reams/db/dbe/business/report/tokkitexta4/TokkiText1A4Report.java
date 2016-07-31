/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.tokkitexta4;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.tokkitexta4.TokkiA4Entity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.tokkitexta4.TokkiText1A4Entity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.tokkitexta4.TokkiText1A4ReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 特記事項（A4版）のReportです。
 *
 * @reamsid_L DBE-0150-340 wangrenze
 */
public class TokkiText1A4Report extends Report<TokkiText1A4ReportSource> {

    private final TokkiText1A4Entity date;
    private static final int ZERO = 0;
    private static final int MAXCOUNT = 30;

    /**
     * インスタンスを生成します。
     *
     * @param date 申請に関する帳票発行のdata
     */
    public TokkiText1A4Report(TokkiText1A4Entity date) {
        this.date = date;
    }

    @Override
    public void writeBy(ReportSourceWriter<TokkiText1A4ReportSource> reportSourceWriter) {
        List<RString> bodyList = getBodyList();
        for (int i = ZERO; i < MAXCOUNT; i++) {
            ITokkiText1A4Editor editor = new TokkiText1A4Editor(date, bodyList, i);
            ITokkiText1A4Builder builder = new TokkiText1A4Builder(editor);
            reportSourceWriter.writeLine(builder);
        }
    }

    private List<RString> getBodyList() {
        List<RString> bodyList = new ArrayList<>();
        if (!date.get短冊イメージ情報リスト().isEmpty()) {
            for (TokkiA4Entity entity : date.get短冊イメージ情報リスト()) {
                bodyList.add(entity.get事項番号());
                bodyList.add(entity.get項目名称());
            }
        }

        if (!date.get短冊テキスト情報リスト().isEmpty()) {
            for (TokkiA4Entity entity : date.get短冊イメージ情報リスト()) {
                bodyList.add(entity.get事項番号());
                bodyList.add(entity.get項目名称());
            }
        }
        return bodyList;
    }

}
