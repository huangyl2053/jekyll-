/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.jimushinsakaishiryoa3;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteikekkahyo.IchijihanteikekkahyoA3Entity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.jimushinsakaishiryoa3.JimuShinsakaishiryoA3ReportSource;
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
 * 特記事項2枚目以降A3版Editorです。
 *
 * @reamsid_L DBE-0150-200 lishengli
 */
public class JimuShinsakaishiryoA3Group3Editor implements IJimuShinsakaishiryoA3Editor {

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
    private static final int INT_15 = 15;
    private static final int INT_16 = 16;
    private static final int INT_17 = 17;
    private static final int INT_18 = 18;
    private static final int INT_19 = 19;
    private static final int INT_20 = 20;
    private static final int INT_21 = 21;
    private static final int INT_22 = 22;
    private static final int INT_23 = 23;
    private static final int INT_24 = 24;
    private static final int INT_25 = 25;
    private static final int INT_26 = 26;
    private static final int INT_27 = 27;
    private static final int INT_28 = 28;
    private static final int INT_29 = 29;
    private static final int INT_30 = 30;
    private static final int INT_31 = 31;
    private static final int INT_32 = 32;
    private static final int INT_33 = 33;
    private static final int PAGE1COUNT = 15;
    private static final int PAGE2COUNT = 34;
    private static final int PAGE1連番名称COUNT = 30;
    private static final int PAGE2連番名称COUNT = 34;
    private final IchijihanteikekkahyoA3Entity item;
    private final int index;
    private final int page;
    private final List<RString> 特記事項List;
    private final RString reportId;

    /**
     * インスタンスを生成します。
     *
     * @param item IchijihanteikekkahyoA3Entity
     * @param 特記事項List List<RString>
     * @param index int
     * @param page int
     * @param reportId 帳票ＩＤ
     */
    protected JimuShinsakaishiryoA3Group3Editor(IchijihanteikekkahyoA3Entity item, List<RString> 特記事項List, int index, int page, RString reportId) {
        this.item = item;
        this.特記事項List = 特記事項List;
        this.index = index;
        this.page = page;
        this.reportId = reportId;
    }

    @Override
    public JimuShinsakaishiryoA3ReportSource edit(JimuShinsakaishiryoA3ReportSource source) {
        return editSource(source);
    }

    private JimuShinsakaishiryoA3ReportSource editSource(JimuShinsakaishiryoA3ReportSource source) {
        source.two_hokenshaNo = item.get特記事項保険者番号();
        source.two_hihokenshaNo = item.get特記事項被保険者番号();
        source.two_hihokenshaName = item.get名前();
        source.two_sakuseiGengo = get元号(item.get認定申請年月日());
        source.two_sakuseiYY = get年(item.get認定申請年月日()).replace(get元号(item.get認定申請年月日()),
                RString.EMPTY).replace(new RString("年"), RString.EMPTY);
        source.two_sakuseiMM = new RString(item.get認定申請年月日().getMonthValue());
        source.two_sakuseiDD = new RString(item.get認定申請年月日().getDayValue());
        FlexibleDate システム日付 = FlexibleDate.getNowDate();
        source.two_chosaGengo = get元号(システム日付);
        source.two_chosaYY = get年(システム日付).replace(get元号(システム日付), RString.EMPTY)
                .replace(new RString("年"), RString.EMPTY);
        source.two_chosaMM = new RString(システム日付.getMonthValue());
        source.two_chosaDD = new RString(システム日付.getDayValue());
        source.two_shinseiGengo = get元号(item.get認定調査実施年月日());
        source.two_shinseiYY = get年(item.get認定調査実施年月日()).replace(get元号(item.get認定調査実施年月日()),
                RString.EMPTY).replace(new RString("年"), RString.EMPTY);
        source.two_shinseiMM = new RString(item.get認定調査実施年月日().getMonthValue());
        source.two_shinseiDD = new RString(item.get認定調査実施年月日().getDayValue());
        source.two_shinsaGengo = get元号(item.get介護認定審査会開催年月日());
        source.two_shinsaYY = get年(item.get介護認定審査会開催年月日()).replace(get元号(item.get介護認定審査会開催年月日()),
                RString.EMPTY).replace(new RString("年"), RString.EMPTY);
        source.two_shinsaMM = new RString(item.get介護認定審査会開催年月日().getMonthValue());
        source.two_shinsaDD = new RString(item.get介護認定審査会開催年月日().getDayValue());
        if (TokkijikoTextImageKubun.テキスト.getコード().equals(item.get特記事項テキスト_イメージ区分())) {
            if (全面.equals(item.get特記パターン())) {
                source.two_tokkiText1 = get特記事項_tokkiText((page - 1) * 2 - 1);
                source.two_tokkiText2 = get特記事項_tokkiText((page - 1) * 2);
            } else if (短冊.equals(item.get特記パターン())) {
                source = set特記事項テキスト連番_名称(source);
                source = set特記事項テキスト(source);
            }
        } else if (TokkijikoTextImageKubun.イメージ.getコード().equals(item.get特記事項テキスト_イメージ区分())) {
            if (全面.equals(item.get特記パターン())) {
                source.two_tokkiImg1 = get特記事項_tokkiImg((page - 1) * 2 - 1);
                source.two_tokkiImg2 = get特記事項_tokkiImg((page - 1) * 2);
            } else if (短冊.equals(item.get特記パターン())) {
                source = set特記事項イメージ連番_名称(source);
                source = set特記事項イメージ(source);
            }
        }
        if (ReportIdDBE.DBE517902.getReportId().value().equals(reportId)) {
            source.layout = Layouts.四頁目;
        } else {
            source.layout = Layouts.任意;
        }
        return source;
    }

    private RString get特記事項_tokkiText(int index) {
        if (index < item.get特記事項_tokkiText().size()) {
            return item.get特記事項_tokkiText().get(index);
        }
        return RString.EMPTY;
    }

    private RString get特記事項_tokkiImg(int index) {
        if (index < item.get特記事項_tokkiImg().size()) {
            return item.get特記事項_tokkiImg().get(index);
        }
        return RString.EMPTY;
    }

    private RString get特記事項テキスト_イメージ(int index) {
        if ((PAGE2COUNT * (page - 2) + PAGE1COUNT + index) < item.get特記事項_listChosa1().size()) {
            return item.get特記事項_listChosa1().get(PAGE2COUNT * (page - 2) + PAGE1COUNT + index).getテキストとイメージ();
        }
        return RString.EMPTY;
    }

    private JimuShinsakaishiryoA3ReportSource set特記事項テキスト(JimuShinsakaishiryoA3ReportSource source) {
        for (int i = 0; i < item.get特記事項_listChosa1().size(); i++) {
            if (i == 0) {
                source.two_tokkiText3 = get特記事項テキスト_イメージ(i);
            }
            if (i == 1) {
                source.two_tokkiText4 = get特記事項テキスト_イメージ(i);
            }
            if (i == 2) {
                source.two_tokkiText5 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_3) {
                source.two_tokkiText6 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_4) {
                source.two_tokkiText7 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_5) {
                source.two_tokkiText8 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_6) {
                source.two_tokkiText9 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_7) {
                source.two_tokkiText10 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_8) {
                source.two_tokkiText11 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_9) {
                source.two_tokkiText12 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_10) {
                source.two_tokkiText13 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_11) {
                source.two_tokkiText14 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_12) {
                source.two_tokkiText15 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_13) {
                source.two_tokkiText16 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_14) {
                source.two_tokkiText17 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_15) {
                source.two_tokkiText18 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_16) {
                source.two_tokkiText19 = get特記事項テキスト_イメージ(i);
            }
        }
        source = set特記事項テキスト2(source);
        return source;
    }

    private JimuShinsakaishiryoA3ReportSource set特記事項テキスト2(JimuShinsakaishiryoA3ReportSource source) {
        for (int i = 0; i < item.get特記事項_listChosa1().size(); i++) {
            if (i == INT_17) {
                source.two_tokkiText20 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_18) {
                source.two_tokkiText21 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_19) {
                source.two_tokkiText22 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_20) {
                source.two_tokkiText23 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_21) {
                source.two_tokkiText24 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_22) {
                source.two_tokkiText25 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_23) {
                source.two_tokkiText26 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_24) {
                source.two_tokkiText27 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_25) {
                source.two_tokkiText28 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_26) {
                source.two_tokkiText29 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_27) {
                source.two_tokkiText30 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_28) {
                source.two_tokkiText31 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_29) {
                source.two_tokkiText32 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_30) {
                source.two_tokkiText33 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_31) {
                source.two_tokkiText34 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_32) {
                source.two_tokkiText35 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_33) {
                source.two_tokkiText36 = get特記事項テキスト_イメージ(i);
            }
        }
        return source;
    }

    private JimuShinsakaishiryoA3ReportSource set特記事項イメージ(JimuShinsakaishiryoA3ReportSource source) {
        for (int i = 0; i < item.get特記事項_listChosa1().size(); i++) {
            if (i == 0) {
                source.two_tokkiImg3 = get特記事項テキスト_イメージ(i);
            }
            if (i == 1) {
                source.two_tokkiImg4 = get特記事項テキスト_イメージ(i);
            }
            if (i == 2) {
                source.two_tokkiImg5 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_3) {
                source.two_tokkiImg6 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_4) {
                source.two_tokkiImg7 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_5) {
                source.two_tokkiImg8 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_6) {
                source.two_tokkiImg9 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_7) {
                source.two_tokkiImg10 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_8) {
                source.two_tokkiImg11 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_9) {
                source.two_tokkiImg12 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_10) {
                source.two_tokkiImg13 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_11) {
                source.two_tokkiImg14 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_12) {
                source.two_tokkiImg15 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_13) {
                source.two_tokkiImg16 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_14) {
                source.two_tokkiImg17 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_15) {
                source.two_tokkiImg18 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_16) {
                source.two_tokkiImg19 = get特記事項テキスト_イメージ(i);
            }
        }
        source = set特記事項イメージ2(source);
        return source;
    }

    private JimuShinsakaishiryoA3ReportSource set特記事項イメージ2(JimuShinsakaishiryoA3ReportSource source) {
        for (int i = 0; i < item.get特記事項_listChosa1().size(); i++) {
            if (i == INT_17) {
                source.two_tokkiImg20 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_18) {
                source.two_tokkiImg21 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_19) {
                source.two_tokkiImg22 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_20) {
                source.two_tokkiImg23 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_21) {
                source.two_tokkiImg24 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_22) {
                source.two_tokkiImg25 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_23) {
                source.two_tokkiImg26 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_24) {
                source.two_tokkiImg27 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_25) {
                source.two_tokkiImg28 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_26) {
                source.two_tokkiImg29 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_27) {
                source.two_tokkiImg30 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_28) {
                source.two_tokkiImg31 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_29) {
                source.two_tokkiImg32 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_30) {
                source.two_tokkiImg33 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_31) {
                source.two_tokkiImg34 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_32) {
                source.two_tokkiImg35 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_33) {
                source.two_tokkiImg36 = get特記事項テキスト_イメージ(i);
            }
        }
        return source;
    }

    private JimuShinsakaishiryoA3ReportSource set特記事項テキスト連番_名称(JimuShinsakaishiryoA3ReportSource source) {
        if ((PAGE2連番名称COUNT * (page - 2) + PAGE1連番名称COUNT + index) < 特記事項List.size()) {
            source.two_listChosa2_1 = 特記事項List.get(PAGE2連番名称COUNT * (page - 2) + PAGE1連番名称COUNT + index);
        }
        if ((PAGE2連番名称COUNT * (page - 2) + PAGE2連番名称COUNT + PAGE1連番名称COUNT + index) < 特記事項List.size()) {
            source.two_listChosa3_1 = 特記事項List.get(PAGE2連番名称COUNT * (page - 2) + PAGE2連番名称COUNT + PAGE1連番名称COUNT + index);
        }
        return source;
    }

    private JimuShinsakaishiryoA3ReportSource set特記事項イメージ連番_名称(JimuShinsakaishiryoA3ReportSource source) {
        if ((PAGE2連番名称COUNT * (page - 2) + PAGE1連番名称COUNT + index) < 特記事項List.size()) {
            source.two_listChosa_1 = 特記事項List.get(PAGE2連番名称COUNT * (page - 2) + PAGE1COUNT + index);
        }
        if ((PAGE2連番名称COUNT * (page - 2) + PAGE2連番名称COUNT + PAGE1連番名称COUNT + index) < 特記事項List.size()) {
            source.two_listChosa1_1 = 特記事項List.get(PAGE2連番名称COUNT * (page - 2) + PAGE2連番名称COUNT + PAGE1COUNT + index);
        }
        return source;
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
