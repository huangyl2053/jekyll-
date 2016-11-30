/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.tokkitext1a4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.tokkitext1a4.TokkiText1A4Entity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.tokkitext1a4.TokkiTextEntity;
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
    private static final int フォームインデックス_判定用 = 30;
    private static final int 連番_計算用 = 15;

    /**
     * インスタンスを生成します。
     *
     * @param entity TokkiText1A4Entity
     * @param list List<RString>
     * @param count int
     */
    protected TokkiText1A4Editor(TokkiText1A4Entity entity, List<RString> list, int count) {
        this.entity = entity;
        this.list = list;
        this.count = count;
    }

    @Override
    public TokkiText1ReportSource edit(TokkiText1ReportSource source) {
        return editSource(source);
    }

    private TokkiText1ReportSource editSource(TokkiText1ReportSource source) {
        source.hokenshaNo = entity.get保険者番号();
        source.hihokenshaNo = entity.get被保険者番号();
        source.hihokenshaName = entity.get被保険者氏名();
        source.shinseiGengo = entity.get申請日_元号();
        source.shinseiYY = !RString.isNullOrEmpty(entity.get申請日_年()) ? entity.get申請日_年().substring(2) : RString.EMPTY;
        source.shinseiMM = entity.get申請日_月();
        source.shinseiDD = entity.get申請日_日();
        source.sakuseiGengo = entity.get作成日_元号();
        source.sakuseiYY = !RString.isNullOrEmpty(entity.get作成日_年()) ? entity.get作成日_年().substring(2) : RString.EMPTY;
        source.sakuseiMM = entity.get作成日_月();
        source.sakuseiDD = entity.get作成日_日();
        source.chosaGengo = entity.get調査日_元号();
        source.chosaYY = !RString.isNullOrEmpty(entity.get調査日_年()) ? entity.get調査日_年().substring(2) : RString.EMPTY;
        source.chosaMM = entity.get調査日_月();
        source.chosaDD = entity.get調査日_日();
        source.shinsaGengo = entity.get審査日_元号();
        source.shinsaYY = !RString.isNullOrEmpty(entity.get審査日_年()) ? entity.get審査日_年().substring(2) : RString.EMPTY;
        source.shinsaMM = entity.get審査日_月();
        source.shinsaDD = entity.get審査日_日();
        source.tokkiImg = entity.get特記事項イメージ();
        source.gaikyotokkiText = entity.get概況調査特記事項();
        source.gaikyotokkiImg = entity.get概況調査特記事項イメージ();
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
        set特記事項リスト(特記事項, source);
        if (count < フォームインデックス_判定用) {
            source.layoutBreakItem = 1;
        } else {
            source.layoutBreakItem = 2;
        }
        return source;
    }

    private void set特記事項リスト(List<RString> 特記事項, TokkiText1ReportSource source) {
        int tokkijikoIndex = count / フォームインデックス_判定用;
        int setIndex = 0;
        if (0 < tokkijikoIndex) {
            setIndex = tokkijikoIndex * 連番_計算用;
        }
        for (int num = 0; num < 連番_計算用; num++) {
            if (setIndex + num < 特記事項.size()) {
                set特記事項List(特記事項.get(setIndex + num), num, source);
            } else {
                break;
            }
        }
    }

    private void set特記事項List(RString item, int index, TokkiText1ReportSource source) {
        int remban = index % 連番_計算用;
        if (remban == 連番_0) {
            source.tokkiText1 = item;
        }
        if (remban == 連番_1) {
            source.tokkiText2 = item;
        }
        if (remban == 連番_2) {
            source.tokkiText3 = item;
        }
        if (remban == 連番_3) {
            source.tokkiText4 = item;
        }
        if (remban == 連番_4) {
            source.tokkiText5 = item;
        }
        if (remban == 連番_5) {
            source.tokkiText6 = item;
        }
        if (remban == 連番_6) {
            source.tokkiText7 = item;
        }
        if (remban == 連番_7) {
            source.tokkiText8 = item;
        }
        if (remban == 連番_8) {
            source.tokkiText9 = item;
        }
        if (remban == 連番_9) {
            source.tokkiText10 = item;
        }
        if (remban == 連番_10) {
            source.tokkiText11 = item;
        }
        if (remban == 連番_11) {
            source.tokkiText12 = item;
        }
        if (remban == 連番_12) {
            source.tokkiText13 = item;
        }
        if (remban == 連番_13) {
            source.tokkiText14 = item;
        }
        if (remban == 連番_14) {
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
