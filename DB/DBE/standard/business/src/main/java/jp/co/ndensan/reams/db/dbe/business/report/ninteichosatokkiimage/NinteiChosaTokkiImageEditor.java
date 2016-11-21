/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ninteichosatokkiimage;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosatokkiimage.NinteiChosaTokkiImageEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ninteichosatokkiimage.NinteiChosaTokkiImageReportSource;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;

/**
 * 特記事項のEditorです。
 *
 * @reamsid_L DBE-0230-080 lizhuoxuan
 */
public class NinteiChosaTokkiImageEditor implements INinteiChosaTokkiImageEditor {

    private final NinteiChosaTokkiImageEntity item;
    private final int indexpage;
    private final int index;
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
    private static final int 連番_24 = 24;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link NinteiChosaTokkiImageEntity}
     * @param index int
     * @param indexpage indexpage
     */
    protected NinteiChosaTokkiImageEditor(NinteiChosaTokkiImageEntity item, int index, int indexpage) {
        this.item = item;
        this.index = index;
        this.indexpage = indexpage;
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
        source.shinseiYY = !RString.isNullOrEmpty(item.get申請日_年()) ? item.get申請日_年().substring(2) : RString.EMPTY;
        source.shinseiMM = item.get申請日_月();
        source.shinseiDD = item.get申請日_日();
        source.sakuseiGengo = item.get作成日_元号();
        source.sakuseiYY = !RString.isNullOrEmpty(item.get作成日_年()) ? item.get作成日_年().substring(2) : RString.EMPTY;
        source.sakuseiMM = item.get作成日_月();
        source.sakuseiDD = item.get作成日_日();
        source.chosaGengo = item.get調査日_元号();
        source.chosaYY = !RString.isNullOrEmpty(item.get調査日_年()) ? item.get調査日_年().substring(2) : RString.EMPTY;
        source.chosaMM = item.get調査日_月();
        source.chosaDD = item.get調査日_日();
        source.shinsaGengo = item.get審査日_元号();
        source.shinsaYY = !RString.isNullOrEmpty(item.get審査日_年()) ? item.get審査日_年().substring(2) : RString.EMPTY;
        source.shinsaMM = item.get審査日_月();
        source.shinsaDD = item.get審査日_日();
        source.tokkiPageNo = new RString(String.valueOf(indexpage));
        source.tokkiPageMax = item.get総ページ数();
        source.listChosa_1 = getイメージ(item.get特記事項リスト番号());
        source.listChosa_2 = getイメージ(item.get特記事項リスト名称());
        source.listChosa_3 = getイメージ01(item.get特記事項リスト番号());
        source.listChosa_4 = getイメージ01(item.get特記事項リスト名称());
        source.listChosa_5 = getイメージ02(item.get特記事項リスト番号());
        source.listChosa_6 = getイメージ02(item.get特記事項リスト名称());
        source.tokki1 = getイメージ03(item.get特記事項リストイメージ(), 連番_1);
        source.tokki2 = getイメージ03(item.get特記事項リストイメージ(), 連番_2);
        source.tokki3 = getイメージ03(item.get特記事項リストイメージ(), 連番_3);
        source.tokki4 = getイメージ03(item.get特記事項リストイメージ(), 連番_4);
        source.tokki5 = getイメージ03(item.get特記事項リストイメージ(), 連番_5);
        source.tokki6 = getイメージ03(item.get特記事項リストイメージ(), 連番_6);
        source.tokki7 = getイメージ03(item.get特記事項リストイメージ(), 連番_7);
        source.tokki8 = getイメージ03(item.get特記事項リストイメージ(), 連番_8);
        source.tokki9 = getイメージ03(item.get特記事項リストイメージ(), 連番_9);
        source.tokki10 = getイメージ03(item.get特記事項リストイメージ(), 連番_10);
        source.tokki11 = getイメージ03(item.get特記事項リストイメージ(), 連番_11);
        source.tokki12 = getイメージ03(item.get特記事項リストイメージ(), 連番_12);
        source.tokki13 = getイメージ03(item.get特記事項リストイメージ(), 連番_13);
        source.tokki14 = getイメージ03(item.get特記事項リストイメージ(), 連番_14);
        source.tokki15 = getイメージ03(item.get特記事項リストイメージ(), 連番_15);
        source.tokki16 = getイメージ03(item.get特記事項リストイメージ(), 連番_16);
        source.tokki17 = getイメージ03(item.get特記事項リストイメージ(), 連番_17);
        source.tokki18 = getイメージ03(item.get特記事項リストイメージ(), 連番_18);
        source.tokki19 = getイメージ03(item.get特記事項リストイメージ(), 連番_19);
        source.tokki20 = getイメージ03(item.get特記事項リストイメージ(), 連番_20);
        source.tokki21 = getイメージ03(item.get特記事項リストイメージ(), 連番_21);
        source.tokki22 = getイメージ03(item.get特記事項リストイメージ(), 連番_22);
        source.tokki23 = getイメージ03(item.get特記事項リストイメージ(), 連番_23);
        source.tokki24 = getイメージ03(item.get特記事項リストイメージ(), 連番_24);
        source.shikibetuCode = ShikibetsuCode.EMPTY;
        source.hihokennshaNo = new ExpandedInformation(new Code("100"), new RString("被保険者番号"), item.get被保険者番号());
        return source;
    }

    private RString getイメージ(List<RString> 区分) {
        if (index + 連番_24 * (indexpage - 1) < item.get特記事項リストイメージ().size()) {
            return 区分.get(index + 連番_24 * (indexpage - 1));
        }
        return RString.EMPTY;
    }

    private RString getイメージ01(List<RString> 区分) {
        if (index + 連番_8 + 連番_24 * (indexpage - 1) < item.get特記事項リストイメージ().size()) {
            return 区分.get(index + 連番_8 + 連番_24 * (indexpage - 1));
        }
        return RString.EMPTY;
    }

    private RString getイメージ02(List<RString> 区分) {
        if (index + 連番_16 + 連番_24 * (indexpage - 1) < item.get特記事項リストイメージ().size()) {
            return 区分.get(index + 連番_16 + 連番_24 * (indexpage - 1));
        }
        return RString.EMPTY;
    }

    private RString getイメージ03(List<RString> 区分, int 連番) {
        if (連番 - 1 + 連番_24 * (indexpage - 1) < item.get特記事項リストイメージ().size()) {
            return 区分.get(連番 - 1 + 連番_24 * (indexpage - 1));
        }
        return RString.EMPTY;
    }
}
