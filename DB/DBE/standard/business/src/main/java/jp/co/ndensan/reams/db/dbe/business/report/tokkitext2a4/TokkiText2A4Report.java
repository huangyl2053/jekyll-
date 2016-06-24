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
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 特記事項ののReportです。
 *
 * @reamsid_L DBE-0230-080 lizhuoxuan
 */
public class TokkiText2A4Report extends Report<TokkiText2ReportSource> {

    private final TokkiText2A4Entity entity;

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

        List<TokkiTextEntity> entityList = entity.get特記事項リスト();
        List<TokkiTextEntity> newEntityList = new ArrayList<>();
        int 特記事項List = entityList.size() / 2;
        for (int i = 0; i < 特記事項List; i++) {
            newEntityList.add(entityList.get(i));
            newEntityList.add(entityList.get(i + 特記事項List));
        }
        newEntityList.add(entityList.get(特記事項List));
        if (entityList.size() % 2 == 0) {
            newEntityList.add(entityList.get(特記事項List * 2 - 1));
        }
        List<RString> itemList = new ArrayList<>();
        RString tokukijikoNo = RString.EMPTY;
        RStringBuilder builder = new RStringBuilder();
        int index = 1;
        for (TokkiTextEntity textEntity : newEntityList) {
            if (tokukijikoNo.equals(textEntity.get特記事項())) {
                index++;
            } else {
                index = 1;
            }
            if (tokukijikoNo.equals(textEntity.get特記事項())) {
                itemList.add(builder.toRString());
                index = 1;
                builder = new RStringBuilder();
                builder.append(textEntity.get特記事項番号());
                builder.append("-");
                builder.append(index);
                builder.append(textEntity.get特記事項名称());
                builder.append("　　");
                builder.append(textEntity.get特記事項());
                builder.append("\n");
            }

            tokukijikoNo = textEntity.get特記事項();
        }
        RStringBuilder builder1 = new RStringBuilder();
        for (int i = 0; i < itemList.size() - 1; i++) {
            builder1.append(itemList.get(i));
        }
        builder1.append(itemList.get(itemList.size() - 1));

        ITokkiText2A4Editor editor = new TokkiText2A4Editor(entity);
        ITokkiText2A4Builder buildera = new TokkiText2A4Builder(editor);
        reportSourceWriter.writeLine(buildera);
    }
}
