/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.tokkitext2a4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.tokkitext1a4.TokkiTextEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.tokkitext2a4.TokkiText2A4Entity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.tokkitext2a4.TokkiText2ReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 * 特記事項のEditorです。
 *
 * @reamsid_L DBE-0230-080 lizhuoxuan
 */
public class TokkiText2A4Editor implements ITokkiText2A4Editor {

    private final TokkiText2A4Entity entity;
    private final List<RString> list;
    private final int count;
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

    /**
     * インスタンスを生成します。
     *
     * @param entity TokkiText2A4Entity
     * @param list List<RString>
     * @param count int
     */
    protected TokkiText2A4Editor(TokkiText2A4Entity entity, List<RString> list, int count) {
        this.entity = entity;
        this.list = list;
        this.count = count;
    }

    @Override
    public TokkiText2ReportSource edit(TokkiText2ReportSource source) {
        return editSource(source);
    }

    private TokkiText2ReportSource editSource(TokkiText2ReportSource source) {
        source.tokkiImg = entity.get特記事項イメージ();
        if (entity.get特記事項リスト() != null && !entity.get特記事項リスト().isEmpty()) {
            RStringBuilder builder = new RStringBuilder();
            for (TokkiTextEntity tokkiTextEntity : entity.get特記事項リスト()) {
                builder.append(tokkiTextEntity.get特記事項番号());
                builder.append("-");
                builder.append(tokkiTextEntity.get特記事項連番());
                builder.append(tokkiTextEntity.get特記事項名称());
                builder.append("　　");
                builder.append(tokkiTextEntity.get特記事項());
                builder.append(System.lineSeparator());
            }
            source.tokkiText = builder.toRString();
        }
        if (entity.get特記事項イメージリスト() != null && !entity.get特記事項イメージリスト().isEmpty()) {
            source.listChosa_1 = getイメージ01();
            source.tokkiImg1 = getイメージ03(entity.get特記事項イメージリスト(), 連番_0);
            source.tokkiImg2 = getイメージ03(entity.get特記事項イメージリスト(), 連番_1);
            source.tokkiImg3 = getイメージ03(entity.get特記事項イメージリスト(), 連番_2);
            source.tokkiImg4 = getイメージ03(entity.get特記事項イメージリスト(), 連番_3);
            source.tokkiImg5 = getイメージ03(entity.get特記事項イメージリスト(), 連番_4);
            source.tokkiImg6 = getイメージ03(entity.get特記事項イメージリスト(), 連番_5);
            source.tokkiImg7 = getイメージ03(entity.get特記事項イメージリスト(), 連番_6);
            source.tokkiImg8 = getイメージ03(entity.get特記事項イメージリスト(), 連番_7);
            source.tokkiImg9 = getイメージ03(entity.get特記事項イメージリスト(), 連番_8);
            source.tokkiImg10 = getイメージ03(entity.get特記事項イメージリスト(), 連番_9);
            source.tokkiImg11 = getイメージ03(entity.get特記事項イメージリスト(), 連番_10);
            source.tokkiImg12 = getイメージ03(entity.get特記事項イメージリスト(), 連番_11);
            source.tokkiImg13 = getイメージ03(entity.get特記事項イメージリスト(), 連番_12);
            source.tokkiImg14 = getイメージ03(entity.get特記事項イメージリスト(), 連番_13);
            source.tokkiImg15 = getイメージ03(entity.get特記事項イメージリスト(), 連番_14);
        }
        if (entity.get特記事項番号リスト() != null && !entity.get特記事項番号リスト().isEmpty()) {
            source.listChosa1_1 = getイメージ02();
        }
        List<RString> 特記事項 = new ArrayList<>();
        RStringBuilder 特記事項builder = new RStringBuilder();
        RString new番号 = RString.EMPTY;
        RString old番号 = RString.EMPTY;
        int index = 0;
        for (TokkiTextEntity tokkiTextEntity : entity.get特記事項番号リスト()) {
            new番号 = tokkiTextEntity.get特記事項番号();
            if (!new番号.equals(old番号)) {
                if (!RString.isNullOrEmpty(特記事項builder.toRString())) {
                    特記事項.add(特記事項builder.toRString());
                }
                特記事項builder = new RStringBuilder();
                特記事項builder.append(tokkiTextEntity.get特記事項());
            } else {
                特記事項builder.append(System.lineSeparator());
                特記事項builder.append(tokkiTextEntity.get特記事項());
            }
            old番号 = new番号;
        }
        if (new番号.equals(old番号)) {
            特記事項.add(特記事項builder.toRString());
        }
        for (RString 事項 : 特記事項) {
            set特記事項List(事項, index, source);
            index = index + 1;
        }
        return source;
    }

    private void set特記事項List(RString item, int index, TokkiText2ReportSource source) {

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
    }

    private RString getイメージ01() {
        if (count < list.size()) {
            return list.get(count);
        }
        return RString.EMPTY;
    }

    private RString getイメージ02() {
        List<RString> result = new ArrayList<>();
        for (RString rString : list) {
            if (Collections.frequency(result, rString) < 1) {
                result.add(rString);
            }
        }
        if (count < result.size()) {
            return result.get(count);
        }
        return RString.EMPTY;
    }

    private RString getイメージ03(List<TokkiTextEntity> 特記事項イメージリスト, int 連番) {
        if (連番 < 特記事項イメージリスト.size()) {
            return 特記事項イメージリスト.get(連番).get特記事項イメージ();
        }
        return RString.EMPTY;
    }
}
