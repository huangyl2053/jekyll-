/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.tokkitext2a4;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.db.tokkitext1a4.TokkiTextEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.tokkitext2a4.TokkiText2A4Entity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.tokkitext2a4.TokkiText2ReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 特記事項ののReportです。
 *
 * @reamsid_L DBE-0230-080 lizhuoxuan
 */
public class TokkiText2A4Report extends Report<TokkiText2ReportSource> {

    private final TokkiText2A4Entity entity;
    private static final int 連番 = 30;

    /**
     * インスタンスを生成します。
     *
     * @param entity 特記事項Entity
     */
    public TokkiText2A4Report(TokkiText2A4Entity entity) {
        this.entity = entity;
    }

    /**
     * 特記事項を生成します。
     *
     * @param reportSourceWriter 帳票Writer
     */
    @Override
    public void writeBy(ReportSourceWriter<TokkiText2ReportSource> reportSourceWriter) {
        List<RString> list = new ArrayList();
        int count = 0;
        if (entity.get特記事項番号リスト() != null && !entity.get特記事項番号リスト().isEmpty()) {
            count = 連番;
            for (TokkiTextEntity tokki : entity.get特記事項番号リスト()) {
                list.add(tokki.get特記事項番号());
                list.add(tokki.get特記事項名称());
            }
        }
        if (entity.get特記事項イメージリスト() != null && !entity.get特記事項イメージリスト().isEmpty()) {
            count = 連番;
            for (TokkiTextEntity tokki : entity.get特記事項イメージリスト()) {
                list.add(tokki.get特記事項番号());
                list.add(tokki.get特記事項名称());
            }
        }
        if (entity.get特記事項リスト() != null && !entity.get特記事項リスト().isEmpty()) {
            count = 1;
        }
        if (entity.get特記事項イメージ() != null && !entity.get特記事項イメージ().isEmpty()) {
            count = 1;
        }
        for (int index = 0; index < count; index++) {
            ITokkiText2A4Editor editor = new TokkiText2A4Editor(entity, list, index);
            ITokkiText2A4Builder buildera = new TokkiText2A4Builder(editor);
            reportSourceWriter.writeLine(buildera);
        }
    }
}
