/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.tokkitext1a4;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.db.tokkitext1a4.TokkiText1A4Entity;
import jp.co.ndensan.reams.db.dbe.entity.db.tokkitext1a4.TokkiTextEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.tokkitext1a4.TokkiText1ReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 * 特記事項のEditorです。
 *
 * @reamsid_L DBE-0230-080 lizhuoxuan
 */
public class TokkiText1A4Editor implements ITokkiText1A4Editor {

    private final TokkiText1A4Entity entity;
    private static final int 連番_0 = 0;
    private static final int 連番_1 = 1;
    private static final int 連番_2 = 2;
    private static final int 連番_3 = 3;
    private static final int 連番_4 = 4;
    private static final int 連番_5 = 5;
    private static final int 連番_6 = 6;
    private static final int 連番_7 = 7;
    private static final int 連番_8 = 8;
    private static final int 連番_9 = 9;
    private static final int 連番_10 = 10;
    private static final int 連番_11 = 11;
    private static final int 連番_12 = 12;
    private static final int 連番_13 = 13;
    private static final int 連番_14 = 14;
    private static final int 連番_15 = 15;

    /**
     * インスタンスを生成します。
     *
     * @param entity TokkiText1A4Entity
     */
    protected TokkiText1A4Editor(TokkiText1A4Entity entity) {
        this.entity = entity;
    }

    @Override
    public TokkiText1ReportSource edit(TokkiText1ReportSource source) {
        return editSource(source);
    }

    private TokkiText1ReportSource editSource(TokkiText1ReportSource source) {

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
        source.tokkiText = builder1.toRString();

        tokukijikoNo = RString.EMPTY;
        List<RString> sb = new ArrayList<>();
        RStringBuilder rsb = new RStringBuilder();
        for (int i = 0; i < entityList.size(); i++) {
            TokkiTextEntity textEntity = entityList.get(i);
            if (tokukijikoNo.equals(textEntity.get特記事項())) {
                rsb.append(RString.EMPTY.padRight(RString.HALF_SPACE, 連番_15));
                rsb.append(textEntity.get特記事項());
            } else {
                sb.add(rsb.toRString());
                rsb = new RStringBuilder();
                rsb.append(textEntity.get特記事項番号().padRight(RString.HALF_SPACE, 連番_15));
                rsb.append(textEntity.get特記事項());
                rsb.append(System.lineSeparator());
                rsb.append(textEntity.get特記事項名称().padRight(RString.HALF_SPACE, 連番_15));
            }
        }
        if (!RString.isNullOrEmpty(rsb.toRString())) {
            sb.add(rsb.toRString());
        }
        for (int i = 0; i < sb.size(); i++) {
            setList(sb.get(i), i, source);
        }
        return source;

    }

    private TokkiText1ReportSource setList(RString item, int index, TokkiText1ReportSource source) {

        if (index == 連番_0) {
            source.tokkiText1 = item;
        }
        if (index == 連番_1) {
            source.tokkiText2 = item;
        }
        if (index == 連番_2) {
            source.tokkiText3 = item;
        }
        if (index == 連番_3) {
            source.tokkiText4 = item;
        }
        if (index == 連番_4) {
            source.tokkiText5 = item;
        }
        if (index == 連番_5) {
            source.tokkiText6 = item;
        }
        if (index == 連番_6) {
            source.tokkiText7 = item;
        }
        if (index == 連番_7) {
            source.tokkiText8 = item;
        }
        if (index == 連番_8) {
            source.tokkiText9 = item;
        }
        if (index == 連番_9) {
            source.tokkiText10 = item;
        }
        if (index == 連番_10) {
            source.tokkiText11 = item;
        }
        if (index == 連番_11) {
            source.tokkiText12 = item;
        }
        if (index == 連番_12) {
            source.tokkiText13 = item;
        }
        if (index == 連番_13) {
            source.tokkiText14 = item;
        }
        if (index == 連番_14) {
            source.tokkiText15 = item;
        }
        return source;
    }
}
