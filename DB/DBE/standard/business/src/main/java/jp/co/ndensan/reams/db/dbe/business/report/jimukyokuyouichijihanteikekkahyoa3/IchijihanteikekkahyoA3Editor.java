/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.jimukyokuyouichijihanteikekkahyoa3;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteikekkahyo.IchijihanteikekkahyoA3Entity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.jimukyokuyouichijihanteikekkahyo.IchijihanteikekkahyoA3ReportSource;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.TokkijikoTextImageKubun;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;

/**
 * 事務局用一次判定結果票A3のEditorです。
 *
 * @reamsid_L DBE-0150-320 lishengli
 */
public class IchijihanteikekkahyoA3Editor implements IIchijihanteikekkahyoA3Editor {

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
    private final int index;
    private final List<RString> 特記事項List;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link IchijihanteikekkahyoA3Entity item}
     * @param 特記事項List List<RString>
     * @param index int
     */
    protected IchijihanteikekkahyoA3Editor(IchijihanteikekkahyoA3Entity item, List<RString> 特記事項List, int index) {
        this.item = item;
        this.特記事項List = 特記事項List;
        this.index = index;
    }

    @Override
    public IchijihanteikekkahyoA3ReportSource edit(IchijihanteikekkahyoA3ReportSource source) {
        return editSource(source);
    }

    private IchijihanteikekkahyoA3ReportSource editSource(IchijihanteikekkahyoA3ReportSource source) {
        source.shinseiCount = item.get審査人数();
        source.shinseiCountGokei = item.get審査人数合計();
        source.gogitaiNo = item.get合議体番号();
        source.hihokenshaKubun = item.get被保険者区分();
        source.shinseiKubun = item.get申請区分();
        source.age = get年齢(item.get年齢());
        source.seibetsu = item.get性別();
        source.zenZenkaiHanteikekka = item.get前々回要介護度();
        source.zenzenkaiYukokikan = item.get前々回認定有効期間();
        source.zZenkaiNijiKaishiYMD = パターン17(item.get前々回認定有効期間開始年月日());
        source.zZenkaiNijishuryoYMD = パターン17(item.get前々回認定有効期間終了年月日());
        source.zenkaiNijihanteikekka = item.get前回要介護度();
        source.zenkaiYukokikan = item.get前回認定有効期間();
        source.zenkaiNijiKaishiYMD = パターン17(item.get前回認定有効期間開始年月日());
        source.zenkaiNijiShuryoYMD = パターン17(item.get前回認定有効期間終了年月日());
        source.zenkaiNijihanteiDate = パターン17(item.get前回認定日());
        source.zenkaiJotaizo = item.get前回状態像();
        source.kanriNo = item.get管理番号();
        source.sakuseiYMD = パターン16(item.get審査会資料作成年月日());
        source.shinseiYMD = パターン16(item.get今回認定申請年月日());
        source.chosaYMD = パターン16(item.get今回認定調査実施年月日());
        source.shinsaYMD = パターン16(item.get今回認定審査年月日());
        source.hokenshaName = item.get被保険者氏名();
        source.hihokenNo = item.get被保険者番号();
        source.hokenshaNo = item.get保険者番号();
        source.shichosonName = item.get市町村名();
        source.chosaItakusakiNo = item.get事業者番号();
        source.chosaItakusakiName = item.get事業者名();
        source.chosainNo = item.get認定調査員番号();
        source.chosainName = item.get認定調査員氏名();
        source.chosainShikaku = item.get調査員資格();
        source.chosaJisshiDate1 = パターン17(item.get調査日());
        source.chosaJisshiBasho = item.get調査実施場所();
        source.iryokikanNo = item.get医療機関番号();
        source.iryokikanName = item.get医療機関名称();
        source.ishiNo = item.get主治医番号();
        source.ishiName = item.get主治医氏名();
        source.ichijiHanteiKekka = item.get一次判定結果();
        source.tokuteishippeiName = item.get特定疾病名();
        source.kijunGokeiTime = item.get要介護認定等基準時間();
        source.zenkaiKijunGokeiTime = item.get前回要介護認定等基準時間();
        source.gurafuKijunTime = item.get基準時間の積み上げグラフ();
        source.listkijunTime_1 = item.get要介護認定等基準時間_食事();
        source.listkijunTime_2 = item.get要介護認定等基準時間_排泄();
        source.listkijunTime_3 = item.get要介護認定等基準時間_移動();
        source.listkijunTime_4 = item.get要介護認定等基準時間_清潔保持();
        source.listkijunTime_5 = item.get要介護認定等基準時間_間接();
        source.listkijunTime_6 = item.get要介護認定等基準時間_BPSD関連();
        source.listkijunTime_7 = item.get要介護認定等基準時間_機能訓練();
        source.listkijunTime_8 = item.get要介護認定等基準時間_医療関連();
        source.listkijunTime_9 = item.get要介護認定等基準時間_認知症加算();
        source.keikokuNo = item.get警告コード();
        source.chosaNinchishoJiritsudo = item.get認定調査結果認知症高齢者自立度();
        source.ikenNinchiJiritsudo = item.get意見書認知症高齢者自立度();
        source.manzensei = item.get認知症自立度Ⅱ以上の蓋然性();
        source.jotainoanteisei = item.get状態の安定性();
        source.kyufukubun = item.get給付区分();
        source.sabisuKubun = item.getSabisuKubun();
        source.sabisuName1 = item.getSabisuName1();
        source.sabisuName2 = item.getSabisuName2();
        source.sabisuName3 = item.getSabisuName3();
        source.sabisuName4 = item.getSabisuName4();
        source.sabisuName5 = item.getSabisuName5();
        source.sabisuName6 = item.getSabisuName6();
        source.sabisuName7 = item.getSabisuName7();
        source.sabisuName8 = item.getSabisuName8();
        source.sabisuName9 = item.getSabisuName9();
        source.sabisuName10 = item.getSabisuName10();
        source.sabisuName11 = item.getSabisuName11();
        source.sabisuName12 = item.getSabisuName12();
        source.sabisuName13 = item.getSabisuName13();
        source.sabisuName14 = item.getSabisuName14();
        source.sabisuName15 = item.getSabisuName15();
        source.sabisuName16 = item.getSabisuName16();
        source.sabisuName17 = item.getSabisuName17();
        source.sabisuName18 = item.getSabisuName18();
        source.sabisuName19 = item.getSabisuName19();
        source.sabisuName20 = item.getSabisuName20();
        source.sabisuName21 = item.getSabisuName21();
        source.sabisuKaisu1 = item.getSabisuKaisu1();
        source.sabisuKaisu2 = item.getSabisuKaisu2();
        source.sabisuKaisu3 = item.getSabisuKaisu3();
        source.sabisuKaisu4 = item.getSabisuKaisu4();
        source.sabisuKaisu5 = item.getSabisuKaisu5();
        source.sabisuKaisu6 = item.getSabisuKaisu6();
        source.sabisuKaisu7 = item.getSabisuKaisu7();
        source.sabisuKaisu8 = item.getSabisuKaisu8();
        source.sabisuKaisu9 = item.getSabisuKaisu9();
        source.sabisuKaisu10 = item.getSabisuKaisu10();
        source.sabisuKaisu11 = item.getSabisuKaisu11();
        source.sabisuKaisu12 = item.getSabisuKaisu12();
        source.sabisuKaisu13 = item.getSabisuKaisu13();
        source.sabisuKaisu14 = item.getSabisuKaisu14();
        source.sabisuKaisu15 = item.getSabisuKaisu15();
        source.sabisuKaisu16 = item.getSabisuKaisu16();
        source.sabisuKaisu17 = item.getSabisuKaisu17();
        source.sabisuKaisu18 = item.getSabisuKaisu18();
        source.sabisuKaisu19 = item.getSabisuKaisu19();
        source.sabisuKaisu20 = item.getSabisuKaisu20();
        source.sabisuKaisu21 = item.getSabisuKaisu21();
        if (テキスト.equals(item.get概況調査テキスト_イメージ区分())) {
            source.shisetsuNameTxit = item.get施設名テキスト();
            source.shisetsuAddressTxit = item.get住所テキスト();
            source.shisetsuTelTxit = item.get電話番号テキスト();
        } else if (イメージ.equals(item.get概況調査テキスト_イメージ区分())) {
            source.imgShisetsuName = item.get施設名イメージ();
            source.imgShisetsuAddress = item.get住所イメージ();
            source.imgShisetsuTel = item.get電話番号イメージ();
        }
        source.shikibetuCode = ShikibetsuCode.EMPTY;
        if (!RString.isNullOrEmpty(item.get申請書管理番号())) {
            source.shinseishoKanriNo = new ExpandedInformation(new Code("0001"), new RString("申請書管理番号"), item.get申請書管理番号());
        }
        return editSource1(source);
    }

    private IchijihanteikekkahyoA3ReportSource editSource1(IchijihanteikekkahyoA3ReportSource source) {
        if (index < item.get中間評価リスト().size()) {
            source.listChukanhyoka_1 = item.get中間評価リスト().get(index).get第1群();
            source.listChukanhyoka_2 = item.get中間評価リスト().get(index).get第2群();
            source.listChukanhyoka_3 = item.get中間評価リスト().get(index).get第3群();
            source.listChukanhyoka_4 = item.get中間評価リスト().get(index).get第4群();
            source.listChukanhyoka_5 = item.get中間評価リスト().get(index).get第5群();
        }
        if (index < item.get日常生活自立度リスト().size()) {
            source.ｌistSeikatsujiritsu_1 = item.get日常生活自立度リスト().get(index).get認知症高齢者自立度();
            source.ｌistSeikatsujiritsu_2 = item.get日常生活自立度リスト().get(index).get特記事項フラグ();
        }
        if (index < item.get第１群リスト().size()) {
            source.listIchigun_1 = item.get第１群リスト().get(index).get調査結果();
            source.listIchigun_2 = item.get第１群リスト().get(index).get段階改善フラグ();
            source.listIchigun_3 = item.get第１群リスト().get(index).get段階改善値();
            source.listIchigun_4 = item.get第１群リスト().get(index).get前回結果();
            source.listFuseigo1_1 = item.get第１群リスト().get(index).get認定調査と主治医意見書の結果比較();
            source.listFuseigo1_2 = item.get第１群リスト().get(index).get特記事項有無();
        }
        if (index < item.get第２群リスト().size()) {
            source.listNigun_1 = item.get第２群リスト().get(index).get調査結果();
            source.listNigun_2 = item.get第２群リスト().get(index).get段階改善フラグ();
            source.listNigun_3 = item.get第２群リスト().get(index).get段階改善値();
            source.listNigun_4 = item.get第２群リスト().get(index).get前回結果();
            source.listFuseigo2_1 = item.get第２群リスト().get(index).get認定調査と主治医意見書の結果比較();
            source.listFuseigo2_2 = item.get第２群リスト().get(index).get特記事項有無();
        }
        if (index < item.get第３群リスト().size()) {
            source.listSangun_1 = item.get第３群リスト().get(index).get調査結果();
            source.listSangun_2 = item.get第３群リスト().get(index).get段階改善フラグ();
            source.listSangun_3 = item.get第３群リスト().get(index).get段階改善値();
            source.listSangun_4 = item.get第３群リスト().get(index).get前回結果();
            source.listFuseigo3_1 = item.get第３群リスト().get(index).get認定調査と主治医意見書の結果比較();
            source.listFuseigo3_2 = item.get第３群リスト().get(index).get特記事項有無();
        }
        if (index < item.get第４群リスト().size()) {
            source.listYongun_1 = item.get第４群リスト().get(index).get調査結果();
            source.listYongun_2 = item.get第４群リスト().get(index).get段階改善フラグ();
            source.listYongun_3 = item.get第４群リスト().get(index).get段階改善値();
            source.listYongun_4 = item.get第４群リスト().get(index).get前回結果();
            source.listFuseigo4_1 = item.get第４群リスト().get(index).get認定調査と主治医意見書の結果比較();
            source.listFuseigo4_2 = item.get第４群リスト().get(index).get特記事項有無();
        }
        if (index < item.get第５群リスト().size()) {
            source.listGogun_1 = item.get第５群リスト().get(index).get調査結果();
            source.listGogun_2 = item.get第５群リスト().get(index).get段階改善フラグ();
            source.listGogun_3 = item.get第５群リスト().get(index).get段階改善値();
            source.listGogun_4 = item.get第５群リスト().get(index).get前回結果();
            source.listFuseigo5_1 = item.get第５群リスト().get(index).get認定調査と主治医意見書の結果比較();
            source.listFuseigo5_2 = item.get第５群リスト().get(index).get特記事項有無();
        }
        if (index < item.get特別な医療リスト１().size()) {
            source.listtokubetsunaIryo1_1 = item.get特別な医療リスト１().get(index).get調査結果();
            source.listtokubetsunaIryo1_2 = item.get特別な医療リスト１().get(index).get認定調査と主治医意見書の結果比較();
            source.listtokubetsunaIryo1_3 = item.get特別な医療リスト１().get(index).get特記事項有無();
            source.listtokubetsunaIryo1_4 = item.get特別な医療リスト１().get(index).get段階改善フラグ();
        }
        if (index < item.get特別な医療リスト２().size()) {
            source.listtokubetsunaIryo2_1 = item.get特別な医療リスト２().get(index).get調査結果();
            source.listtokubetsunaIryo2_2 = item.get特別な医療リスト２().get(index).get認定調査と主治医意見書の結果比較();
            source.listtokubetsunaIryo2_3 = item.get特別な医療リスト２().get(index).get特記事項有無();
            source.listtokubetsunaIryo2_4 = item.get特別な医療リスト２().get(index).get段階改善フラグ();
        }
        if (index < item.get主治医意見書().size()) {
            source.listshujiiikensho_1 = item.get主治医意見書().get(index).get調査結果();
            source.listshujiiikensho_2 = item.get主治医意見書().get(index).get段階改善フラグ();
            source.listshujiiikensho_3 = item.get主治医意見書().get(index).get段階改善値();
            source.listshujiiikensho_4 = item.get主治医意見書().get(index).get前回結果();
        }
        return editSource2(source);
    }

    private IchijihanteikekkahyoA3ReportSource editSource2(IchijihanteikekkahyoA3ReportSource source) {
        if (テキスト.equals(item.get概況調査テキスト_イメージ区分())) {
            source.gaikyotokkiText = item.get概況特記のテキスト();
        } else if (イメージ.equals(item.get概況調査テキスト_イメージ区分())) {
            source.gaikyotokkiImg = item.get概況特記のイメージ();
        }
        if (TokkijikoTextImageKubun.テキスト.getコード().equals(item.get特記事項テキスト_イメージ区分())) {
            if (全面.equals(item.get特記パターン())) {
                source.tokkiText = item.get特記事項_tokkiText();
            } else if (短冊.equals(item.get特記パターン())) {
                source = set特記事項テキスト連番_名称(source);
            }
        } else if (TokkijikoTextImageKubun.イメージ.getコード().equals(item.get特記事項テキスト_イメージ区分())) {
            if (全面.equals(item.get特記パターン())) {
                source.tokkiImg = item.get特記事項_tokkiImg();
            } else if (短冊.equals(item.get特記パターン())) {
                source = set特記事項イメージ連番_名称(source);
            }
        }
        return source;
    }

    private IchijihanteikekkahyoA3ReportSource set特記事項イメージ連番_名称(IchijihanteikekkahyoA3ReportSource source) {
        if (index < 特記事項List.size()) {
            source.listChosa_1 = 特記事項List.get(index);
        }
        for (int i = 0; i < item.get特記事項_listChosa1().size(); i++) {
            if (i == 0) {
                source.tokkiImg1 = item.get特記事項_listChosa1().get(i).getテキストとイメージ();
            } else if (i == 1) {
                source.tokkiImg2 = item.get特記事項_listChosa1().get(i).getテキストとイメージ();
            } else if (i == 2) {
                source.tokkiImg3 = item.get特記事項_listChosa1().get(i).getテキストとイメージ();
            } else if (i == INT_3) {
                source.tokkiImg4 = item.get特記事項_listChosa1().get(i).getテキストとイメージ();
            } else if (i == INT_4) {
                source.tokkiImg5 = item.get特記事項_listChosa1().get(i).getテキストとイメージ();
            } else if (i == INT_5) {
                source.tokkiImg6 = item.get特記事項_listChosa1().get(i).getテキストとイメージ();
            } else if (i == INT_6) {
                source.tokkiImg7 = item.get特記事項_listChosa1().get(i).getテキストとイメージ();
            } else if (i == INT_7) {
                source.tokkiImg8 = item.get特記事項_listChosa1().get(i).getテキストとイメージ();
            } else if (i == INT_8) {
                source.tokkiImg9 = item.get特記事項_listChosa1().get(i).getテキストとイメージ();
            } else if (i == INT_9) {
                source.tokkiImg10 = item.get特記事項_listChosa1().get(i).getテキストとイメージ();
            } else if (i == INT_10) {
                source.tokkiImg11 = item.get特記事項_listChosa1().get(i).getテキストとイメージ();
            } else if (i == INT_11) {
                source.tokkiImg12 = item.get特記事項_listChosa1().get(i).getテキストとイメージ();
            } else if (i == INT_12) {
                source.tokkiImg13 = item.get特記事項_listChosa1().get(i).getテキストとイメージ();
            } else if (i == INT_13) {
                source.tokkiImg14 = item.get特記事項_listChosa1().get(i).getテキストとイメージ();
            } else if (i == INT_14) {
                source.tokkiImg15 = item.get特記事項_listChosa1().get(i).getテキストとイメージ();
            }
        }
        return source;
    }

    private IchijihanteikekkahyoA3ReportSource set特記事項テキスト連番_名称(IchijihanteikekkahyoA3ReportSource source) {
        if (index < 特記事項List.size()) {
            source.listChosa1_1 = 特記事項List.get(index);
        }
        for (int i = 0; i < item.get特記事項_listChosa1().size(); i++) {
            if (i == 0) {
                source.tokkiText1 = item.get特記事項_listChosa1().get(i).getテキストとイメージ();
            } else if (i == 1) {
                source.tokkiText2 = item.get特記事項_listChosa1().get(i).getテキストとイメージ();
            } else if (i == 2) {
                source.tokkiText3 = item.get特記事項_listChosa1().get(i).getテキストとイメージ();
            } else if (i == INT_3) {
                source.tokkiText4 = item.get特記事項_listChosa1().get(i).getテキストとイメージ();
            } else if (i == INT_4) {
                source.tokkiText5 = item.get特記事項_listChosa1().get(i).getテキストとイメージ();
            } else if (i == INT_5) {
                source.tokkiText6 = item.get特記事項_listChosa1().get(i).getテキストとイメージ();
            } else if (i == INT_6) {
                source.tokkiText7 = item.get特記事項_listChosa1().get(i).getテキストとイメージ();
            } else if (i == INT_7) {
                source.tokkiText8 = item.get特記事項_listChosa1().get(i).getテキストとイメージ();
            } else if (i == INT_8) {
                source.tokkiText9 = item.get特記事項_listChosa1().get(i).getテキストとイメージ();
            } else if (i == INT_9) {
                source.tokkiText10 = item.get特記事項_listChosa1().get(i).getテキストとイメージ();
            } else if (i == INT_10) {
                source.tokkiText11 = item.get特記事項_listChosa1().get(i).getテキストとイメージ();
            } else if (i == INT_11) {
                source.tokkiText12 = item.get特記事項_listChosa1().get(i).getテキストとイメージ();
            } else if (i == INT_12) {
                source.tokkiText13 = item.get特記事項_listChosa1().get(i).getテキストとイメージ();
            } else if (i == INT_13) {
                source.tokkiText14 = item.get特記事項_listChosa1().get(i).getテキストとイメージ();
            } else if (i == INT_14) {
                source.tokkiText15 = item.get特記事項_listChosa1().get(i).getテキストとイメージ();
            }
        }
        return source;
    }

    private RString get年齢(RString 年齢) {
        RStringBuilder 年齢歳 = new RStringBuilder();
        if (!RString.isNullOrEmpty(年齢)) {
            年齢歳.append(年齢);
            年齢歳.append(new RString("歳"));
            return 年齢歳.toRString();
        }
        return RString.EMPTY;
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
