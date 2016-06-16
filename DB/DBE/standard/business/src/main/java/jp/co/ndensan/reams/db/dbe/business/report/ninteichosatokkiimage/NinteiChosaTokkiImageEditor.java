/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ninteichosatokkiimage;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.db.ninteichosatokkiimage.NinteiChosaTokkiImageEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ninteichosatokkiimage.NinteiChosaTokkiImageReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 * 特記事項のEditorです。
 *
 * @reamsid_L DBE-0230-080 lizhuoxuan
 */
public class NinteiChosaTokkiImageEditor implements INinteiChosaTokkiImageEditor {

    private final NinteiChosaTokkiImageEntity item;
    private final int index;
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
    private static final int 連番_16 = 16;
    private static final int 連番_17 = 17;
    private static final int 連番_18 = 18;
    private static final int 連番_19 = 19;
    private static final int 連番_20 = 20;
    private static final int 連番_21 = 21;
    private static final int 連番_22 = 22;
    private static final int 連番_23 = 23;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link NinteiChosaTokkiImageEntity}
     * @param index Index
     */
    protected NinteiChosaTokkiImageEditor(NinteiChosaTokkiImageEntity item, int index) {
        this.item = item;
        this.index = index;
    }

    @Override
    public NinteiChosaTokkiImageReportSource edit(NinteiChosaTokkiImageReportSource source) {
        return editSource(source);
    }

    private NinteiChosaTokkiImageReportSource editSource(NinteiChosaTokkiImageReportSource source) {
        source.hokenshaNo = item.get保険者番号();
        source.hihokenshaNo = item.get被保険者番号();
        source.hihokenshaName = item.get被保険者氏名();
        source.shinseiGengo = item.get申請日_元号();
        source.shinseiYY = item.get申請日_年();
        source.shinseiMM = item.get申請日_月();
        source.shinseiDD = item.get申請日_日();
        source.sakuseiGengo = item.get作成日_元号();
        source.sakuseiYY = item.get作成日_年();
        source.sakuseiMM = item.get作成日_月();
        source.sakuseiDD = item.get作成日_日();
        source.chosaGengo = item.get調査日_元号();
        source.chosaYY = item.get調査日_年();
        source.chosaMM = item.get調査日_月();
        source.chosaDD = item.get調査日_日();
        source.shinsaGengo = item.get審査日_元号();
        source.shinsaYY = item.get審査日_年();
        source.shinsaMM = item.get審査日_月();
        source.shinsaDD = item.get審査日_日();
        source.tokkiPageNo = item.get現ページ();
        source.tokkiPageMax = item.get総ページ数();
        if (index < item.get特記事項リスト1().size()) {
            source.listChosa_1 = item.get特記事項リスト1().get(index);
        }
        if (index < item.get特記事項リスト2().size()) {
            source.listChosa_2 = item.get特記事項リスト2().get(index);
        }
        if (index < item.get特記事項リスト3().size()) {
            source.listChosa_3 = item.get特記事項リスト3().get(index);
        }
        if (index < item.get特記事項リスト4().size()) {
            source.listChosa_4 = item.get特記事項リスト4().get(index);
        }
        if (index < item.get特記事項リスト5().size()) {
            source.listChosa_5 = item.get特記事項リスト5().get(index);
        }
        if (index < item.get特記事項リスト6().size()) {
            source.listChosa_6 = item.get特記事項リスト6().get(index);
        }
        List<RString> inList = new ArrayList<>();
        List<RString> outList = new ArrayList<>();
        inList.addAll(item.get特記事項リスト1());
        inList.addAll(item.get特記事項リスト3());
        inList.addAll(item.get特記事項リスト5());
        RString old特記事項番号 = RString.EMPTY;
        int i = 1;
        for (RString 特記事項番号 : inList) {
            RString new特記事項番号 = 特記事項番号;
            if (i == 1 || new特記事項番号.equals(old特記事項番号)) {
                RStringBuilder builder = new RStringBuilder();
                builder.append(item.get特記事項イメージ1());
                builder.append("-");
                builder.append(i);
                builder.append(".png");
                i = i + 1;
                outList.add(builder.toRString());
            } else {
                i = 1;
                RStringBuilder builder = new RStringBuilder();
                builder.append(item.get特記事項イメージ1());
                builder.append("-");
                builder.append(i);
                builder.append(".png");
                outList.add(builder.toRString());
            }
            old特記事項番号 = new特記事項番号;
        }
        source.tokki1 = outList.get(連番_0);
        source.tokki2 = outList.get(連番_1);
        source.tokki3 = outList.get(連番_2);
        source.tokki4 = outList.get(連番_3);
        source.tokki5 = outList.get(連番_4);
        source.tokki6 = outList.get(連番_5);
        source.tokki7 = outList.get(連番_6);
        source.tokki8 = outList.get(連番_7);
        source.tokki9 = outList.get(連番_8);
        source.tokki10 = outList.get(連番_9);
        source.tokki11 = outList.get(連番_10);
        source.tokki12 = outList.get(連番_11);
        source.tokki13 = outList.get(連番_12);
        source.tokki14 = outList.get(連番_13);
        source.tokki15 = outList.get(連番_14);
        source.tokki16 = outList.get(連番_15);
        source.tokki17 = outList.get(連番_16);
        source.tokki18 = outList.get(連番_17);
        source.tokki19 = outList.get(連番_18);
        source.tokki20 = outList.get(連番_19);
        source.tokki21 = outList.get(連番_20);
        source.tokki22 = outList.get(連番_21);
        source.tokki23 = outList.get(連番_22);
        source.tokki24 = outList.get(連番_23);
        return source;
    }

}
