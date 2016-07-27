/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.tokkia4;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.tokkia4.TokkiText2A4Entity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.tokkia4.TokkiTextEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.tokkia4.TokkiText2A4ReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 特記事項2枚目以降（A4版）のReportです。
 *
 * @reamsid_L DBE-0150-350 wangrenze
 */
public class TokkiText2A4Report extends Report<TokkiText2A4ReportSource> {

    private final TokkiText2A4Entity date;
    private static final int ZERO = 0;
    private static final int MAXCOUNT = 30;

    /**
     * インスタンスを生成します。
     *
     * @param entity 特記事項2枚目以降（A4版）Entity
     */
    public TokkiText2A4Report(TokkiText2A4Entity entity) {
        this.date = entity;
    }

    /**
     * 特記事項2枚目以降（A4版）を生成します。
     *
     * @param reportSourceWriter 帳票Writer
     */
    @Override
    public void writeBy(ReportSourceWriter<TokkiText2A4ReportSource> reportSourceWriter) {
        List<RString> bodyList = getBodyList();
        for (int i = ZERO; i < MAXCOUNT; i++) {
            ITokkiText2A4Editor editor = new TokkiText2A4Editor(date, bodyList, i);
            ITokkiText2A4Builder buildera = new TokkiText2A4Builder(editor);
            reportSourceWriter.writeLine(buildera);
        }
    }

    private List<RString> getBodyList() {
        List<RString> bodyList = new ArrayList<>();
        if (!date.get短冊イメージ情報リスト().isEmpty()) {
            for (TokkiTextEntity entity : date.get短冊イメージ情報リスト()) {
                bodyList.add(entity.get事項番号());
                bodyList.add(entity.get項目名称());
            }
        }

        if (!date.get短冊テキスト情報リスト().isEmpty()) {
            for (TokkiTextEntity entity : date.get短冊イメージ情報リスト()) {
                bodyList.add(entity.get事項番号());
                bodyList.add(entity.get項目名称());
            }
        }
        return bodyList;
    }
}
