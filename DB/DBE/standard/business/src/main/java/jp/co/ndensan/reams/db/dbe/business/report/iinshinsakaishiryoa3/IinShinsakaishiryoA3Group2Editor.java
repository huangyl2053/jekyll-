/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.iinshinsakaishiryoa3;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteikekkahyo.IchijihanteikekkahyoA3Entity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.iinshinsakaishiryoa3.IinShinsakaishiryoA3ReportSource;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.TokkijikoTextImageKubun;
import jp.co.ndensan.reams.db.dbz.entity.report.saichekkuhyo.Layouts;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 委員用特記事項+一次判定結果票（A3版）のEditorです。
 *
 * @reamsid_L DBE-0150-200 zhaoyao
 */
public class IinShinsakaishiryoA3Group2Editor implements IIinShinsakaishiryoA3Editor {

    private static final RString テキスト = new RString("1");
    private static final RString イメージ = new RString("2");
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
    private final IchijihanteikekkahyoA3Entity item;
    private final List<RString> 特記事項List;
    private final int index;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link IchijihanteikekkahyoA3Entity}
     * @param 特記事項List List<RString>
     * @param index int
     */
    protected IinShinsakaishiryoA3Group2Editor(IchijihanteikekkahyoA3Entity item, List<RString> 特記事項List, int index) {
        this.item = item;
        this.特記事項List = 特記事項List;
        this.index = index;
    }

    @Override
    public IinShinsakaishiryoA3ReportSource edit(IinShinsakaishiryoA3ReportSource source) {
        return editSource(source);
    }

    private IinShinsakaishiryoA3ReportSource editSource(IinShinsakaishiryoA3ReportSource source) {
        source.two_shinseiCount = item.get審査人数();
        source.two_shinseiCountGokei = item.get審査人数合計();
        source.two_gogitaiNo = item.get合議体番号();
        source.two_kanriNo = item.get管理番号();
        source.two_hihokenshaKubun = item.get被保険者区分();
        source.two_shinseiKubun = item.get申請区分();
        source.two_age = get年齢(item.get年齢());
        source.two_seibetsu = item.get性別();
        source.two_zenZenkaiHanteikekka = item.get前々回要介護度();
        source.two_zenzenkaiYukokikan = item.get前々回認定有効期間();
        source.two_zZenkaiNijiKaishiYMD = パターン17(item.get前々回認定有効期間開始年月日());
        source.two_zZenkaiNijishuryoYMD = パターン17(item.get前々回認定有効期間終了年月日());
        source.two_zenkaiNijihanteikekka = item.get前回要介護度();
        source.two_zenkaiYukokikan = item.get前回認定有効期間();
        source.two_zenkaiNijiKaishiYMD = パターン17(item.get前回認定有効期間開始年月日());
        source.two_zenkaiNijiShuryoYMD = パターン17(item.get前回認定有効期間終了年月日());
        source.two_zenkaiNijihanteiDate = パターン16(item.get前回認定日());
        source.two_zenkaiJotaizo = item.get前回状態像();
        source.two_sakuseiYMD = パターン16(item.get審査会資料作成年月日());
        source.two_shinseiYMD = パターン16(item.get今回認定申請年月日());
        source.two_chosaYMD = パターン16(item.get今回認定調査実施年月日());
        source.two_shinsaYMD = パターン16(item.get今回認定審査年月日());
        source.two_ichijiHanteiKekka = item.get一次判定結果();
        source.two_chosaJisshiDate1 = パターン17(item.get調査日());
        source.two_chosaJisshiBasho = item.get調査実施場所();
        source.two_tokuteishippeiName = item.get特定疾病名();
        source.two_kijunGokeiTime = item.get要介護認定等基準時間();
        source.two_zenkaiKijunGokeiTime = item.get前回要介護認定等基準時間();
        source.two_gurafuKijunTime = item.get基準時間の積み上げグラフ();
        source.two_listKijunTime_1 = item.get要介護認定等基準時間_食事();
        source.two_listKijunTime_2 = item.get要介護認定等基準時間_排泄();
        source.two_listKijunTime_3 = item.get要介護認定等基準時間_移動();
        source.two_listKijunTime_4 = item.get要介護認定等基準時間_清潔保持();
        source.two_listKijunTime_5 = item.get要介護認定等基準時間_間接();
        source.two_listKijunTime_6 = item.get要介護認定等基準時間_BPSD関連();
        source.two_listKijunTime_7 = item.get要介護認定等基準時間_機能訓練();
        source.two_listKijunTime_8 = item.get要介護認定等基準時間_医療関連();
        source.two_listKijunTime_9 = item.get要介護認定等基準時間_認知症加算();
        source.two_keikokuNo = item.get警告コード();
        source.two_chosaNinchishoJiritsudo = item.get認定調査結果認知症高齢者自立度();
        source.two_ikenNinchiJiritsudo = item.get意見書認知症高齢者自立度();
        source.two_manzensei = item.get認知症自立度Ⅱ以上の蓋然性();
        source.two_jotainoanteisei = item.get状態の安定性();
        source.two_kyufukubun = item.get給付区分();
        source.two_sabisuKubun = item.getSabisuKubun();
        source.two_sabisuName1 = item.getSabisuName1();
        source.two_sabisuName2 = item.getSabisuName2();
        source.two_sabisuName3 = item.getSabisuName3();
        source.two_sabisuName4 = item.getSabisuName4();
        source.two_sabisuName5 = item.getSabisuName5();
        source.two_sabisuName6 = item.getSabisuName6();
        source.two_sabisuName7 = item.getSabisuName7();
        source.two_sabisuName8 = item.getSabisuName8();
        source.two_sabisuName9 = item.getSabisuName9();
        source.two_sabisuName10 = item.getSabisuName10();
        source.two_sabisuName11 = item.getSabisuName11();
        source.two_sabisuName12 = item.getSabisuName12();
        source.two_sabisuName13 = item.getSabisuName13();
        source.two_sabisuName14 = item.getSabisuName14();
        source.two_sabisuName15 = item.getSabisuName15();
        source.two_sabisuName16 = item.getSabisuName16();
        source.two_sabisuName17 = item.getSabisuName17();
        source.two_sabisuName18 = item.getSabisuName18();
        source.two_sabisuName19 = item.getSabisuName19();
        source.two_sabisuName20 = item.getSabisuName20();
        source.two_sabisuName21 = item.getSabisuName21();
        source.two_sabisuKaisu1 = item.getSabisuKaisu1();
        source.two_sabisuKaisu2 = item.getSabisuKaisu2();
        source.two_sabisuKaisu3 = item.getSabisuKaisu3();
        source.two_sabisuKaisu4 = item.getSabisuKaisu4();
        source.two_sabisuKaisu5 = item.getSabisuKaisu5();
        source.two_sabisuKaisu6 = item.getSabisuKaisu6();
        source.two_sabisuKaisu7 = item.getSabisuKaisu7();
        source.two_sabisuKaisu8 = item.getSabisuKaisu8();
        source.two_sabisuKaisu9 = item.getSabisuKaisu9();
        source.two_sabisuKaisu10 = item.getSabisuKaisu10();
        source.two_sabisuKaisu11 = item.getSabisuKaisu11();
        source.two_sabisuKaisu12 = item.getSabisuKaisu12();
        source.two_sabisuKaisu13 = item.getSabisuKaisu13();
        source.two_sabisuKaisu14 = item.getSabisuKaisu14();
        source.two_sabisuKaisu15 = item.getSabisuKaisu15();
        source.two_sabisuKaisu16 = item.getSabisuKaisu16();
        source.two_sabisuKaisu17 = item.getSabisuKaisu17();
        source.two_sabisuKaisu18 = item.getSabisuKaisu18();
        source.two_sabisuKaisu19 = item.getSabisuKaisu19();
        source.two_sabisuKaisu20 = item.getSabisuKaisu20();
        source.two_sabisuKaisu21 = item.getSabisuKaisu21();
        source = editSource1(source);
        source.two_shisetsuNameTxit = item.get施設名テキスト();
        source.two_shisetsuAddressTxit = item.get住所テキスト();
        source.two_shisetsuTelTxit = item.get電話番号テキスト();
        source.two_imgShisetsuName = item.get施設名イメージ();
        source.two_imgShisetsuAddress = item.get住所イメージ();
        source.two_imgShisetsuTel = item.get電話番号イメージ();
        source.layout = Layouts.必須;
        return source;
    }

    private IinShinsakaishiryoA3ReportSource editSource1(IinShinsakaishiryoA3ReportSource source) {
        if (index < item.get中間評価リスト().size()) {
            source.two_listChukanhyoka_1 = item.get中間評価リスト().get(index).get第1群();
            source.two_listChukanhyoka_2 = item.get中間評価リスト().get(index).get第2群();
            source.two_listChukanhyoka_3 = item.get中間評価リスト().get(index).get第3群();
            source.two_listChukanhyoka_4 = item.get中間評価リスト().get(index).get第4群();
            source.two_listChukanhyoka_5 = item.get中間評価リスト().get(index).get第5群();
        }
        if (index < item.get日常生活自立度リスト().size()) {
            source.two_ｌistSeikatsujiritsu_1 = item.get日常生活自立度リスト().get(index).get認知症高齢者自立度();
            source.two_ｌistSeikatsujiritsu_2 = item.get日常生活自立度リスト().get(index).get特記事項フラグ();
        }
        if (index < item.get第１群リスト().size()) {
            source.two_listIchigun_1 = item.get第１群リスト().get(index).get調査結果();
            source.two_listIchigun_2 = item.get第１群リスト().get(index).get段階改善フラグ();
            source.two_listIchigun_3 = item.get第１群リスト().get(index).get段階改善値();
            source.two_listIchigun_4 = item.get第１群リスト().get(index).get前回結果();
            source.two_listFuseigo1_1 = item.get第１群リスト().get(index).get認定調査と主治医意見書の結果比較();
            source.two_listFuseigo1_2 = item.get第１群リスト().get(index).get特記事項有無();
        }
        if (index < item.get第２群リスト().size()) {
            source.two_listNigun_1 = item.get第２群リスト().get(index).get調査結果();
            source.two_listNigun_2 = item.get第２群リスト().get(index).get段階改善フラグ();
            source.two_listNigun_3 = item.get第２群リスト().get(index).get段階改善値();
            source.two_listNigun_4 = item.get第２群リスト().get(index).get前回結果();
            source.two_listFuseigo2_1 = item.get第２群リスト().get(index).get認定調査と主治医意見書の結果比較();
            source.two_listFuseigo2_2 = item.get第２群リスト().get(index).get特記事項有無();
        }
        if (index < item.get第３群リスト().size()) {
            source.two_listSangun_1 = item.get第３群リスト().get(index).get調査結果();
            source.two_listSangun_2 = item.get第３群リスト().get(index).get段階改善フラグ();
            source.two_listSangun_3 = item.get第３群リスト().get(index).get段階改善値();
            source.two_listSangun_4 = item.get第３群リスト().get(index).get前回結果();
            source.two_listFuseigo3_1 = item.get第３群リスト().get(index).get認定調査と主治医意見書の結果比較();
            source.two_listFuseigo3_2 = item.get第３群リスト().get(index).get特記事項有無();
        }
        if (index < item.get第４群リスト().size()) {
            source.two_listYongun_1 = item.get第４群リスト().get(index).get調査結果();
            source.two_listYongun_2 = item.get第４群リスト().get(index).get段階改善フラグ();
            source.two_listYongun_3 = item.get第４群リスト().get(index).get段階改善値();
            source.two_listYongun_4 = item.get第４群リスト().get(index).get前回結果();
            source.two_listFuseigo4_1 = item.get第４群リスト().get(index).get認定調査と主治医意見書の結果比較();
            source.two_listFuseigo4_2 = item.get第４群リスト().get(index).get特記事項有無();
        }
        if (index < item.get第５群リスト().size()) {
            source.two_listGogun_1 = item.get第５群リスト().get(index).get調査結果();
            source.two_listGogun_2 = item.get第５群リスト().get(index).get段階改善フラグ();
            source.two_listGogun_3 = item.get第５群リスト().get(index).get段階改善値();
            source.two_listGogun_4 = item.get第５群リスト().get(index).get前回結果();
            source.two_listFuseigo5_1 = item.get第５群リスト().get(index).get認定調査と主治医意見書の結果比較();
            source.two_listFuseigo5_2 = item.get第５群リスト().get(index).get特記事項有無();
        }
        if (index < item.get特別な医療リスト１().size()) {
            source.two_listTokubetsunaIryo1_1 = item.get特別な医療リスト１().get(index).get調査結果();
            source.two_listTokubetsunaIryo1_2 = item.get特別な医療リスト１().get(index).get認定調査と主治医意見書の結果比較();
            source.two_listTokubetsunaIryo1_3 = item.get特別な医療リスト１().get(index).get特記事項有無();
            source.two_listTokubetsunaIryo1_4 = item.get特別な医療リスト１().get(index).get段階改善フラグ();
        }
        if (index < item.get特別な医療リスト２().size()) {
            source.two_listTokubetsunaIryo2_1 = item.get特別な医療リスト２().get(index).get調査結果();
            source.two_listTokubetsunaIryo2_2 = item.get特別な医療リスト２().get(index).get認定調査と主治医意見書の結果比較();
            source.two_listTokubetsunaIryo2_3 = item.get特別な医療リスト２().get(index).get特記事項有無();
            source.two_listTokubetsunaIryo2_4 = item.get特別な医療リスト２().get(index).get段階改善フラグ();
        }
        return editSource2(source);
    }

    private IinShinsakaishiryoA3ReportSource editSource2(IinShinsakaishiryoA3ReportSource source) {
        if (テキスト.equals(item.get概況調査テキスト_イメージ区分())) {
            source.three_gaikyotokkiText = item.get概況特記のテキスト();
        } else if (イメージ.equals(item.get概況調査テキスト_イメージ区分())) {
            source.three_gaikyotokkiImg = item.get概況特記のイメージ();
        }
        if (TokkijikoTextImageKubun.テキスト.getコード().equals(item.get特記事項テキスト_イメージ区分())) {
            if (全面.equals(item.get特記パターン())) {
                source.four_tokkiText = get特記事項_tokkiText(0);
            } else if (短冊.equals(item.get特記パターン())) {
                source = set特記事項テキスト連番_名称(source);
            }
        } else if (TokkijikoTextImageKubun.イメージ.getコード().equals(item.get特記事項テキスト_イメージ区分())) {
            if (全面.equals(item.get特記パターン())) {
                source.four_tokkiImg = get特記事項_tokkiImg(0);
            } else if (短冊.equals(item.get特記パターン())) {
                source = set特記事項イメージ連番_名称(source);
            }
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

    private IinShinsakaishiryoA3ReportSource set特記事項イメージ連番_名称(IinShinsakaishiryoA3ReportSource source) {
        if (index < 特記事項List.size()) {
            source.four_listChosa_1 = 特記事項List.get(index);
        }
        for (int i = 0; i < item.get特記事項_listChosa1().size(); i++) {
            if (i == 0) {
                source.four_tokkiImg1 = item.get特記事項_listChosa1().get(i).getテキストとイメージ();
            } else if (i == 1) {
                source.four_tokkiImg2 = item.get特記事項_listChosa1().get(i).getテキストとイメージ();
            } else if (i == 2) {
                source.four_tokkiImg3 = item.get特記事項_listChosa1().get(i).getテキストとイメージ();
            } else if (i == INT_3) {
                source.four_tokkiImg4 = item.get特記事項_listChosa1().get(i).getテキストとイメージ();
            } else if (i == INT_4) {
                source.four_tokkiImg5 = item.get特記事項_listChosa1().get(i).getテキストとイメージ();
            } else if (i == INT_5) {
                source.four_tokkiImg6 = item.get特記事項_listChosa1().get(i).getテキストとイメージ();
            } else if (i == INT_6) {
                source.four_tokkiImg7 = item.get特記事項_listChosa1().get(i).getテキストとイメージ();
            } else if (i == INT_7) {
                source.four_tokkiImg8 = item.get特記事項_listChosa1().get(i).getテキストとイメージ();
            } else if (i == INT_8) {
                source.four_tokkiImg9 = item.get特記事項_listChosa1().get(i).getテキストとイメージ();
            } else if (i == INT_9) {
                source.four_tokkiImg10 = item.get特記事項_listChosa1().get(i).getテキストとイメージ();
            } else if (i == INT_10) {
                source.four_tokkiImg11 = item.get特記事項_listChosa1().get(i).getテキストとイメージ();
            } else if (i == INT_11) {
                source.four_tokkiImg12 = item.get特記事項_listChosa1().get(i).getテキストとイメージ();
            } else if (i == INT_12) {
                source.four_tokkiImg13 = item.get特記事項_listChosa1().get(i).getテキストとイメージ();
            } else if (i == INT_13) {
                source.four_tokkiImg14 = item.get特記事項_listChosa1().get(i).getテキストとイメージ();
            } else if (i == INT_14) {
                source.four_tokkiImg15 = item.get特記事項_listChosa1().get(i).getテキストとイメージ();
            }
        }
        return source;
    }

    private IinShinsakaishiryoA3ReportSource set特記事項テキスト連番_名称(IinShinsakaishiryoA3ReportSource source) {
        if (index < 特記事項List.size()) {
            source.four_listChosa1_1 = 特記事項List.get(index);
        }
        for (int i = 0; i < item.get特記事項_listChosa1().size(); i++) {
            if (i == 0) {
                source.four_tokkiText1 = item.get特記事項_listChosa1().get(i).getテキストとイメージ();
            } else if (i == 1) {
                source.four_tokkiText2 = item.get特記事項_listChosa1().get(i).getテキストとイメージ();
            } else if (i == 2) {
                source.four_tokkiText3 = item.get特記事項_listChosa1().get(i).getテキストとイメージ();
            } else if (i == INT_3) {
                source.four_tokkiText4 = item.get特記事項_listChosa1().get(i).getテキストとイメージ();
            } else if (i == INT_4) {
                source.four_tokkiText5 = item.get特記事項_listChosa1().get(i).getテキストとイメージ();
            } else if (i == INT_5) {
                source.four_tokkiText6 = item.get特記事項_listChosa1().get(i).getテキストとイメージ();
            } else if (i == INT_6) {
                source.four_tokkiText7 = item.get特記事項_listChosa1().get(i).getテキストとイメージ();
            } else if (i == INT_7) {
                source.four_tokkiText8 = item.get特記事項_listChosa1().get(i).getテキストとイメージ();
            } else if (i == INT_8) {
                source.four_tokkiText9 = item.get特記事項_listChosa1().get(i).getテキストとイメージ();
            } else if (i == INT_9) {
                source.four_tokkiText10 = item.get特記事項_listChosa1().get(i).getテキストとイメージ();
            } else if (i == INT_10) {
                source.four_tokkiText11 = item.get特記事項_listChosa1().get(i).getテキストとイメージ();
            } else if (i == INT_11) {
                source.four_tokkiText12 = item.get特記事項_listChosa1().get(i).getテキストとイメージ();
            } else if (i == INT_12) {
                source.four_tokkiText13 = item.get特記事項_listChosa1().get(i).getテキストとイメージ();
            } else if (i == INT_13) {
                source.four_tokkiText14 = item.get特記事項_listChosa1().get(i).getテキストとイメージ();
            } else if (i == INT_14) {
                source.four_tokkiText15 = item.get特記事項_listChosa1().get(i).getテキストとイメージ();
            }
        }
        return source;
    }

    private RString get年齢(RString 年齢) {
        RStringBuilder 年齢歳 = new RStringBuilder();
        年齢歳.append(年齢);
        年齢歳.append(new RString("歳"));
        return 年齢歳.toRString();
    }

    private RString パターン16(FlexibleDate 年月日) {
        if (年月日 == null || 年月日.isEmpty()) {
            return RString.EMPTY;
        }
        return 年月日.wareki().eraType(EraType.ALPHABET)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD)
                .fillType(FillType.BLANK).toDateString();
    }

    private RString パターン17(FlexibleDate 年月日) {
        if (年月日 == null || 年月日.isEmpty()) {
            return RString.EMPTY;
        }
        return 年月日.wareki().eraType(EraType.ALPHABET)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.SLASH)
                .fillType(FillType.BLANK).toDateString();
    }
}
