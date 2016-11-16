/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.iinshinsakaishiryoa3;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteikekkahyo.IchijihanteikekkahyoA3Entity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.iinshinsakaishiryoa3.IinShinsakaishiryoA3ReportSource;
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
 * @reamsid_L DBE-0150-200 zhaoyao
 */
public class IinShinsakaishiryoA3Group3Editor implements IIinShinsakaishiryoA3Editor {

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
     * @param reportId 帳票ＩＤ
     * @param index int
     * @param page int
     */
    protected IinShinsakaishiryoA3Group3Editor(IchijihanteikekkahyoA3Entity item,
            List<RString> 特記事項List, RString reportId, int index, int page) {
        this.item = item;
        this.特記事項List = 特記事項List;
        this.reportId = reportId;
        this.index = index;
        this.page = page;
    }

    @Override
    public IinShinsakaishiryoA3ReportSource edit(IinShinsakaishiryoA3ReportSource source) {
        return editSource(source);
    }

    private IinShinsakaishiryoA3ReportSource editSource(IinShinsakaishiryoA3ReportSource source) {
        source.six_hokenshaNo = RString.EMPTY;
        source.six_hihokenshaNo = RString.EMPTY;
        source.six_hihokenshaName = RString.EMPTY;
        source.six_sakuseiGengo = get元号(item.get認定申請年月日());
        source.six_sakuseiYY = get年(item.get認定申請年月日()).replace(get元号(item.get認定申請年月日()),
                RString.EMPTY).replace(new RString("年"), RString.EMPTY);
        source.six_sakuseiMM = new RString(item.get認定申請年月日().getMonthValue());
        source.six_sakuseiDD = new RString(item.get認定申請年月日().getDayValue());
        FlexibleDate システム日付 = FlexibleDate.getNowDate();
        source.six_chosaGengo = get元号(システム日付);
        source.six_chosaYY = get年(システム日付).replace(get元号(システム日付), RString.EMPTY)
                .replace(new RString("年"), RString.EMPTY);
        source.six_chosaMM = new RString(システム日付.getMonthValue());
        source.six_chosaDD = new RString(システム日付.getDayValue());
        source.six_shinseiGengo = get元号(item.get認定調査実施年月日());
        source.six_shinseiYY = get年(item.get認定調査実施年月日());
        source.six_shinseiMM = new RString(item.get認定調査実施年月日().getMonthValue());
        source.six_shinseiDD = new RString(item.get認定調査実施年月日().getDayValue());
        source.six_shinsaGengo = get元号(item.get介護認定審査会開催年月日());
        source.six_shinsaYY = get年(item.get介護認定審査会開催年月日()).replace(get元号(item.get介護認定審査会開催年月日()),
                RString.EMPTY).replace(new RString("年"), RString.EMPTY);
        source.six_shinsaMM = new RString(item.get介護認定審査会開催年月日().getMonthValue());
        source.six_shinsaDD = new RString(item.get介護認定審査会開催年月日().getDayValue());
        if (TokkijikoTextImageKubun.テキスト.getコード().equals(item.get特記事項テキスト_イメージ区分())) {
            if (全面.equals(item.get特記パターン())) {
                source.six_tokkiText1 = get特記事項_tokkiText((page - 1) * 2 - 1);
                source.six_tokkiText2 = get特記事項_tokkiText((page - 1) * 2);
            } else if (短冊.equals(item.get特記パターン())) {
                source = set特記事項テキスト連番_名称(source);
                source = set特記事項テキスト(source);
            }
        } else if (TokkijikoTextImageKubun.イメージ.getコード().equals(item.get特記事項テキスト_イメージ区分())) {
            if (全面.equals(item.get特記パターン())) {
                source.six_tokkiImg1 = get特記事項_tokkiImg((page - 1) * 2 - 1);
                source.six_tokkiImg2 = get特記事項_tokkiImg((page - 1) * 2);
            } else if (短冊.equals(item.get特記パターン())) {
                source = set特記事項イメージ連番_名称(source);
                source = set特記事項イメージ(source);
            }
        }
        if (ReportIdDBE.DBE517915.getReportId().value().equals(reportId)) {
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

    private IinShinsakaishiryoA3ReportSource set特記事項テキスト(IinShinsakaishiryoA3ReportSource source) {
        for (int i = 0; i < item.get特記事項_listChosa1().size(); i++) {
            if (i == 0) {
                source.six_tokkiText3 = get特記事項テキスト_イメージ(i);
            }
            if (i == 1) {
                source.six_tokkiText4 = get特記事項テキスト_イメージ(i);
            }
            if (i == 2) {
                source.six_tokkiText5 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_3) {
                source.six_tokkiText6 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_4) {
                source.six_tokkiText7 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_5) {
                source.six_tokkiText8 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_6) {
                source.six_tokkiText9 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_7) {
                source.six_tokkiText10 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_8) {
                source.six_tokkiText11 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_9) {
                source.six_tokkiText12 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_10) {
                source.six_tokkiText13 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_11) {
                source.six_tokkiText14 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_12) {
                source.six_tokkiText15 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_13) {
                source.six_tokkiText16 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_14) {
                source.six_tokkiText17 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_15) {
                source.six_tokkiText18 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_16) {
                source.six_tokkiText19 = get特記事項テキスト_イメージ(i);
            }
        }
        source = set特記事項テキスト2(source);
        return source;
    }

    private IinShinsakaishiryoA3ReportSource set特記事項テキスト2(IinShinsakaishiryoA3ReportSource source) {
        for (int i = 0; i < item.get特記事項_listChosa1().size(); i++) {
            if (i == INT_17) {
                source.six_tokkiText20 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_18) {
                source.six_tokkiText21 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_19) {
                source.six_tokkiText22 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_20) {
                source.six_tokkiText23 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_21) {
                source.six_tokkiText24 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_22) {
                source.six_tokkiText25 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_23) {
                source.six_tokkiText26 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_24) {
                source.six_tokkiText27 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_25) {
                source.six_tokkiText28 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_26) {
                source.six_tokkiText29 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_27) {
                source.six_tokkiText30 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_28) {
                source.six_tokkiText31 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_29) {
                source.six_tokkiText32 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_30) {
                source.six_tokkiText33 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_31) {
                source.six_tokkiText34 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_32) {
                source.six_tokkiText35 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_33) {
                source.six_tokkiText36 = get特記事項テキスト_イメージ(i);
            }
        }
        return source;
    }

    private IinShinsakaishiryoA3ReportSource set特記事項イメージ(IinShinsakaishiryoA3ReportSource source) {
        for (int i = 0; i < item.get特記事項_listChosa1().size(); i++) {
            if (i == 0) {
                source.six_tokkiImg3 = get特記事項テキスト_イメージ(i);
            }
            if (i == 1) {
                source.six_tokkiImg4 = get特記事項テキスト_イメージ(i);
            }
            if (i == 2) {
                source.six_tokkiImg5 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_3) {
                source.six_tokkiImg6 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_4) {
                source.six_tokkiImg7 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_5) {
                source.six_tokkiImg8 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_6) {
                source.six_tokkiImg9 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_7) {
                source.six_tokkiImg10 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_8) {
                source.six_tokkiImg11 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_9) {
                source.six_tokkiImg12 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_10) {
                source.six_tokkiImg13 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_11) {
                source.six_tokkiImg14 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_12) {
                source.six_tokkiImg15 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_13) {
                source.six_tokkiImg16 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_14) {
                source.six_tokkiImg17 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_15) {
                source.six_tokkiImg18 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_16) {
                source.six_tokkiImg19 = get特記事項テキスト_イメージ(i);
            }
        }
        source = set特記事項イメージ2(source);
        return source;
    }

    private IinShinsakaishiryoA3ReportSource set特記事項イメージ2(IinShinsakaishiryoA3ReportSource source) {
        for (int i = 0; i < item.get特記事項_listChosa1().size(); i++) {
            if (i == INT_17) {
                source.six_tokkiImg20 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_18) {
                source.six_tokkiImg21 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_19) {
                source.six_tokkiImg22 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_20) {
                source.six_tokkiImg23 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_21) {
                source.six_tokkiImg24 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_22) {
                source.six_tokkiImg25 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_23) {
                source.six_tokkiImg26 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_24) {
                source.six_tokkiImg27 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_25) {
                source.six_tokkiImg28 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_26) {
                source.six_tokkiImg29 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_27) {
                source.six_tokkiImg30 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_28) {
                source.six_tokkiImg31 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_29) {
                source.six_tokkiImg32 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_30) {
                source.six_tokkiImg33 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_31) {
                source.six_tokkiImg34 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_32) {
                source.six_tokkiImg35 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_33) {
                source.six_tokkiImg36 = get特記事項テキスト_イメージ(i);
            }
        }
        return source;
    }

    private IinShinsakaishiryoA3ReportSource set特記事項テキスト連番_名称(IinShinsakaishiryoA3ReportSource source) {
        if ((PAGE2連番名称COUNT * (page - 2) + PAGE1連番名称COUNT + index) < 特記事項List.size()) {
            source.six_listChosa2_1 = 特記事項List.get(PAGE2連番名称COUNT * (page - 2) + PAGE1連番名称COUNT + index);
        }
        if ((PAGE2連番名称COUNT * (page - 2) + PAGE2連番名称COUNT + PAGE1連番名称COUNT + index) < 特記事項List.size()) {
            source.six_listChosa3_1 = 特記事項List.get(PAGE2連番名称COUNT * (page - 2) + PAGE2連番名称COUNT + PAGE1連番名称COUNT + index);
        }
        return source;
    }

    private IinShinsakaishiryoA3ReportSource set特記事項イメージ連番_名称(IinShinsakaishiryoA3ReportSource source) {
        if ((PAGE2連番名称COUNT * (page - 2) + PAGE1連番名称COUNT + index) < 特記事項List.size()) {
            source.six_listChosa_1 = 特記事項List.get(PAGE2連番名称COUNT * (page - 2) + PAGE1COUNT + index);
        }
        if ((PAGE2連番名称COUNT * (page - 2) + PAGE2連番名称COUNT + PAGE1連番名称COUNT + index) < 特記事項List.size()) {
            source.six_listChosa1_1 = 特記事項List.get(PAGE2連番名称COUNT * (page - 2) + PAGE2連番名称COUNT + PAGE1COUNT + index);
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
