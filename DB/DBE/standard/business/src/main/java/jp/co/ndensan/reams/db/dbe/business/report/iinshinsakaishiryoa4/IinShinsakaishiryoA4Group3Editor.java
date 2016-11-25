/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.iinshinsakaishiryoa4;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.TokkiText1A4Business;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.iinshinsakaishiryoa4.IinShinsakaishiryoA4ReportSource;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.tokkitexta4.TokkiA4Entity;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.TokkijikoTextImageKubun;
import jp.co.ndensan.reams.db.dbz.entity.report.saichekkuhyo.Layouts;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FillTypeFormatted;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 特記事項A4版Editorです。
 *
 * @reamsid_L DBE-0150-200 lishengli
 */
public class IinShinsakaishiryoA4Group3Editor implements IIinShinsakaishiryoA4Editor {

    private static final RString 全面 = new RString("1");
    private static final RString 短冊 = new RString("2");
    private static final int INT_3 = 3;
    private static final int INT_4 = 4;
    private static final int INT_5 = 5;
    private static final int INT_6 = 6;
    private static final int INT_7 = 7;
    private static final int INT_8 = 8;
    private static final int INT_9 = 9;
    private static final int INT_10 = 10;
    private static final int INT_11 = 11;
    private static final int INT_12 = 12;
    private static final int INT_13 = 13;
    private static final int INT_14 = 14;
    private final List<TokkiA4Entity> 短冊情報リスト;
    private final TokkiText1A4Business item;
    private final List<RString> 短冊リスト;
    private final List<RString> テキスト全面List;
    private final List<RString> イメージ全面List;
    private final int index;

    /**
     * インスタンスを生成します。
     *
     * @param item TokkiText1A4Entity
     * @param 短冊情報リスト List<TokkiA4Entity>
     * @param 短冊リスト List<RString>
     * @param テキスト全面List List<RString>
     * @param イメージ全面List List<RString>
     * @param index Index
     */
    protected IinShinsakaishiryoA4Group3Editor(TokkiText1A4Business item, List<TokkiA4Entity> 短冊情報リスト,
            List<RString> 短冊リスト, List<RString> テキスト全面List, List<RString> イメージ全面List, int index) {
        this.item = item;
        this.index = index;
        this.短冊情報リスト = 短冊情報リスト;
        this.短冊リスト = 短冊リスト;
        this.テキスト全面List = テキスト全面List;
        this.イメージ全面List = イメージ全面List;
    }

    @Override
    public IinShinsakaishiryoA4ReportSource edit(IinShinsakaishiryoA4ReportSource source) {
        return editSource(source);
    }

    private IinShinsakaishiryoA4ReportSource editSource(IinShinsakaishiryoA4ReportSource source) {
        if (item.is委員用()) {
            source.two_hokenshaNo = RString.EMPTY;
            source.two_hihokenshaNo = RString.EMPTY;
            source.two_hihokenshaName = RString.EMPTY;
        } else {
            source.two_hokenshaNo = item.get保険者番号();
            source.two_hihokenshaNo = item.get被保険者番号();
            source.two_hihokenshaName = item.get名前();
        }
        source.two_shinseiGengo = get元号(item.get認定申請年月日());
        source.two_shinseiYY = get年(item.get認定申請年月日()).replace(get元号(item.get認定申請年月日()), RString.EMPTY)
                .replace(new RString("年"), RString.EMPTY);
        source.two_shinseiMM = new RString(item.get認定申請年月日().getMonthValue());
        source.two_shinseiDD = new RString(item.get認定申請年月日().getDayValue());
        FlexibleDate システム日付 = FlexibleDate.getNowDate();
        source.two_sakuseiGengo = get元号(システム日付);
        source.two_sakuseiYY = get年(システム日付).replace(get元号(システム日付), RString.EMPTY)
                .replace(new RString("年"), RString.EMPTY);
        source.two_sakuseiMM = new RString(システム日付.getMonthValue());
        source.two_sakuseiDD = new RString(システム日付.getDayValue());
        source.two_chosaGengo = get元号(item.get認定調査実施年月日());
        source.two_chosaYY = get年(item.get認定調査実施年月日()).replace(get元号(item.get認定調査実施年月日()),
                RString.EMPTY).replace(new RString("年"), RString.EMPTY);
        source.two_chosaMM = new RString(item.get認定調査実施年月日().getMonthValue());
        source.two_chosaDD = new RString(item.get認定調査実施年月日().getDayValue());
        source.two_shinsaGengo = get元号(item.get介護認定審査会開催年月日());
        source.two_shinsaYY = get年(item.get介護認定審査会開催年月日()).replace(get元号(item.get介護認定審査会開催年月日()),
                RString.EMPTY).replace(new RString("年"), RString.EMPTY);
        source.two_shinsaMM = new RString(item.get介護認定審査会開催年月日().getMonthValue());
        source.two_shinsaDD = new RString(item.get介護認定審査会開催年月日().getDayValue());

        if (TokkijikoTextImageKubun.テキスト.getコード().equals(item.get概況特記テキスト_イメージ区分())) {
            source.two_gaikyotokkiText = item.get概況調査の特記事項テキスト();
        }

        if (TokkijikoTextImageKubun.イメージ.getコード().equals(item.get概況特記テキスト_イメージ区分())) {
            source.two_gaikyotokkiImg = item.get概況調査の特記事項イメージ();
        }
        if (TokkijikoTextImageKubun.テキスト.getコード().equals(item.get特記事項テキスト_イメージ区分())
                && 全面.equals(item.get特記パターン()) && index < テキスト全面List.size()) {
            source.two_tokkiText = テキスト全面List.get(index);
        }
        if (TokkijikoTextImageKubun.テキスト.getコード().equals(item.get特記事項テキスト_イメージ区分())
                && 短冊.equals(item.get特記パターン())) {
            editテキスト(source, 短冊リスト);
            set特記事項テキスト(source);
        }
        if (TokkijikoTextImageKubun.イメージ.getコード().equals(item.get特記事項テキスト_イメージ区分())
                && 全面.equals(item.get特記パターン()) && index < イメージ全面List.size()) {
            source.two_tokkiImg = イメージ全面List.get(index);
        }
        if (TokkijikoTextImageKubun.イメージ.getコード().equals(item.get特記事項テキスト_イメージ区分())
                && 短冊.equals(item.get特記パターン())) {
            editイメージ(source, 短冊リスト);
            set特記事項イメージ(source);
        }
        source.layout = Layouts.任意;
        return source;
    }

    private IinShinsakaishiryoA4ReportSource set特記事項テキスト(IinShinsakaishiryoA4ReportSource source) {
        for (int i = 0; i < 短冊情報リスト.size(); i++) {
            if (i == 0) {
                source.two_tokkiText1 = 短冊情報リスト.get(i).get特記事項テキスト_イメージ();
            } else if (i == 1) {
                source.two_tokkiText2 = 短冊情報リスト.get(i).get特記事項テキスト_イメージ();
            } else if (i == 2) {
                source.two_tokkiText3 = 短冊情報リスト.get(i).get特記事項テキスト_イメージ();
            } else if (i == INT_3) {
                source.two_tokkiText4 = 短冊情報リスト.get(i).get特記事項テキスト_イメージ();
            } else if (i == INT_4) {
                source.two_tokkiText5 = 短冊情報リスト.get(i).get特記事項テキスト_イメージ();
            } else if (i == INT_5) {
                source.two_tokkiText6 = 短冊情報リスト.get(i).get特記事項テキスト_イメージ();
            } else if (i == INT_6) {
                source.two_tokkiText7 = 短冊情報リスト.get(i).get特記事項テキスト_イメージ();
            } else if (i == INT_7) {
                source.two_tokkiText8 = 短冊情報リスト.get(i).get特記事項テキスト_イメージ();
            } else if (i == INT_8) {
                source.two_tokkiText9 = 短冊情報リスト.get(i).get特記事項テキスト_イメージ();
            } else if (i == INT_9) {
                source.two_tokkiText10 = 短冊情報リスト.get(i).get特記事項テキスト_イメージ();
            } else if (i == INT_10) {
                source.two_tokkiText11 = 短冊情報リスト.get(i).get特記事項テキスト_イメージ();
            } else if (i == INT_11) {
                source.two_tokkiText12 = 短冊情報リスト.get(i).get特記事項テキスト_イメージ();
            } else if (i == INT_12) {
                source.two_tokkiText13 = 短冊情報リスト.get(i).get特記事項テキスト_イメージ();
            } else if (i == INT_13) {
                source.two_tokkiText14 = 短冊情報リスト.get(i).get特記事項テキスト_イメージ();
            } else if (i == INT_14) {
                source.two_tokkiText15 = 短冊情報リスト.get(i).get特記事項テキスト_イメージ();
            }
        }
        return source;
    }

    private IinShinsakaishiryoA4ReportSource set特記事項イメージ(IinShinsakaishiryoA4ReportSource source) {
        for (int i = 0; i < 短冊情報リスト.size(); i++) {
            if (i == 0) {
                source.two_tokkiImg1 = 短冊情報リスト.get(i).get特記事項テキスト_イメージ();
            } else if (i == 1) {
                source.two_tokkiImg2 = 短冊情報リスト.get(i).get特記事項テキスト_イメージ();
            } else if (i == 2) {
                source.two_tokkiImg3 = 短冊情報リスト.get(i).get特記事項テキスト_イメージ();
            } else if (i == INT_3) {
                source.two_tokkiImg4 = 短冊情報リスト.get(i).get特記事項テキスト_イメージ();
            } else if (i == INT_4) {
                source.two_tokkiImg5 = 短冊情報リスト.get(i).get特記事項テキスト_イメージ();
            } else if (i == INT_5) {
                source.two_tokkiImg6 = 短冊情報リスト.get(i).get特記事項テキスト_イメージ();
            } else if (i == INT_6) {
                source.two_tokkiImg7 = 短冊情報リスト.get(i).get特記事項テキスト_イメージ();
            } else if (i == INT_7) {
                source.two_tokkiImg8 = 短冊情報リスト.get(i).get特記事項テキスト_イメージ();
            } else if (i == INT_8) {
                source.two_tokkiImg9 = 短冊情報リスト.get(i).get特記事項テキスト_イメージ();
            } else if (i == INT_9) {
                source.two_tokkiImg10 = 短冊情報リスト.get(i).get特記事項テキスト_イメージ();
            } else if (i == INT_10) {
                source.two_tokkiImg11 = 短冊情報リスト.get(i).get特記事項テキスト_イメージ();
            } else if (i == INT_11) {
                source.two_tokkiImg12 = 短冊情報リスト.get(i).get特記事項テキスト_イメージ();
            } else if (i == INT_12) {
                source.two_tokkiImg13 = 短冊情報リスト.get(i).get特記事項テキスト_イメージ();
            } else if (i == INT_13) {
                source.two_tokkiImg14 = 短冊情報リスト.get(i).get特記事項テキスト_イメージ();
            } else if (i == INT_14) {
                source.two_tokkiImg15 = 短冊情報リスト.get(i).get特記事項テキスト_イメージ();
            }
        }
        return source;
    }

    private void editテキスト(IinShinsakaishiryoA4ReportSource source, List<RString> 特記事項List) {
        if (index < 特記事項List.size()) {
            source.two_listChosa1_1 = 特記事項List.get(index);
        }

    }

    private void editイメージ(IinShinsakaishiryoA4ReportSource source, List<RString> 特記事項List) {
        if (index < 特記事項List.size()) {
            source.two_listChosa_1 = 特記事項List.get(index);
        }
    }

    private RString get元号(FlexibleDate 年月日) {

        return パターン12(年月日).getEra();
    }

    private RString get年(FlexibleDate 年月日) {

        return パターン12(年月日).getYear();
    }

    private FillTypeFormatted パターン12(FlexibleDate 年月日) {

        return 年月日.wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                .fillType(FillType.BLANK);
    }
}
