/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.jimukyokuyouichijihanteikekkahyoa4;

import jp.co.ndensan.reams.db.dbe.entity.report.source.ichijihanteikekkahyoa4.IchijihanteikekkahyoA4Entity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.jimukyokuyouichijihanteikekkahyo.IchijihanteikekkahyoA4ReportSource;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FillTypeFormatted;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;

/**
 * 事務局用一次判定結果票A4のEditorです。
 *
 * @reamsid_L DBE-0150-400 lishengli
 */
public class IchijihanteikekkahyoA4Editor implements IIchijihanteikekkahyoA4Editor {

    private static final int INT_4 = 4;
    private final IchijihanteikekkahyoA4Entity item;
    private final int index;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link IchijihanteikekkahyoA4Entity}
     * @param index int
     */
    protected IchijihanteikekkahyoA4Editor(IchijihanteikekkahyoA4Entity item, int index) {
        this.item = item;
        this.index = index;
    }

    @Override
    public IchijihanteikekkahyoA4ReportSource edit(IchijihanteikekkahyoA4ReportSource source) {
        return editSource(source);
    }

    private IchijihanteikekkahyoA4ReportSource editSource(IchijihanteikekkahyoA4ReportSource source) {
        source.title = new RString("認定情報（事務局用）");
        source.gogitaiNo = item.get合議体番号();
        source.shinseiCount = item.get審査順();
        source.hihokenshaKubun = item.get被保険者区分();
        source.shinseiKubun = item.get申請区分();
        source.age = get年齢(item.get年齢());
        source.seibetsu = item.get性別();
        source.shisetsuriyo = item.get現在の状況();
        source.zenZenkaiNijihanteikekka = item.get前々回要介護度();
        source.zenzenkaiYukokikan = item.get前々回認定有効期間();
        source.zZenkaiNijiKaishiYMD = パターン17(item.get前々回認定有効期間開始年月日());
        source.zZenkaiNijishuryoYMD = パターン17(item.get前々回認定有効期間終了年月日());
        source.zenkaiNijihanteikekka = item.get前回要介護度();
        source.zenkaiYukokikan = item.get前回認定有効期間();
        source.zenkaiNijiKaishiYMD = パターン17(item.get前回認定有効期間開始年月日());
        source.zenkaiNijishuryoYMD = パターン17(item.get前回認定有効期間終了年月日());
        source.zenkaiNijihanteiDATE = パターン17(item.get前回認定日());
        source.zenkaiJotaizo = item.get前回状態像();
        source.kanriNo = item.get管理番号();
        source.sakuseiGengo = get元号(item.get審査会資料作成年月日());
        source.sakuseiYY = get年(item.get審査会資料作成年月日());
        source.sakuseiMM = get月(item.get審査会資料作成年月日());
        source.sakuseiDD = get日(item.get審査会資料作成年月日());
        source.shinseiGengo = get元号(item.get今回認定申請年月日());
        source.shinseiYY = get年(item.get今回認定申請年月日());
        source.shinseiMM = get月(item.get今回認定申請年月日());
        source.shinseiDD = get日(item.get今回認定申請年月日());
        source.chosaGengo = get元号(item.get今回認定調査実施年月日());
        source.chosaYY = get年(item.get今回認定調査実施年月日());
        source.chosaMM = get月(item.get今回認定調査実施年月日());
        source.chosaDD = get日(item.get今回認定調査実施年月日());
        source.shinsaGengo = get元号(item.get今回認定審査年月日());
        source.shinsaYY = get年(item.get今回認定審査年月日());
        source.shinsaMM = get月(item.get今回認定審査年月日());
        source.shinsaDD = get日(item.get今回認定審査年月日());
        source.hihokenshaName = item.get被保険者氏名();
        source.hihokenshaNo = item.get被保険者番号();
        source.hokenshaNo = item.get保険者番号();
        source.shozokuName = item.get支所名();
        source.shichosonName = item.get市町村名();
        source.chosaItakusakiNo = item.get事業者番号();
        source.chosaItakusakiName = item.get事業者名();
        source.chosainNo = item.get認定調査員番号();
        source.chosainName = item.get認定調査員氏名();
        source.chosainShikaku = item.get調査員資格();
        source.iryokikanNo = item.get医療機関番号();
        source.iryokikanName = item.get医療機関名称();
        source.ishiNo = item.get主治医番号();
        source.ishiName = item.get主治医氏名();
        source.ichijiHanteiKekka = item.get一次判定結果();
        source.nijiHanteiKekka = RString.EMPTY;
        source.ｙukokikan = RString.EMPTY;
        source.nijihanteiKaishiYMD = RString.EMPTY;
        source.nijihanteishuryoYMD = RString.EMPTY;
        source.tokuteishippeiName = item.get特定疾病名();
        source.jotaizo = item.get状態像名称();
        source.kijunGokeiTime = item.get要介護認定等基準時間();
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
        source.ikenNinchishoJiritsudo = item.get意見書認知症高齢者自立度();
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
        if (index < item.get中間評価リスト().size()) {
            source.listChukanhyoka_1 = item.get中間評価リスト().get(index).get第1群();
            source.listChukanhyoka_2 = item.get中間評価リスト().get(index).get第2群();
            source.listChukanhyoka_3 = item.get中間評価リスト().get(index).get第3群();
            source.listChukanhyoka_4 = item.get中間評価リスト().get(index).get第4群();
            source.listChukanhyoka_5 = item.get中間評価リスト().get(index).get第5群();
        }
        source.shikibetuCode = ShikibetsuCode.EMPTY;
        if (item.get申請書管理番号() != null) {
            source.shinseishoKanriNo = new ExpandedInformation(new Code("0001"), new RString("申請書管理番号"), item.get申請書管理番号());
        }
        return editSource1(source);
    }

    private IchijihanteikekkahyoA4ReportSource editSource1(IchijihanteikekkahyoA4ReportSource source) {
        if (index < item.get生活自立度_特記事項有無_リスト().size()) {
            source.listTokki8_1 = item.get生活自立度_特記事項有無_リスト().get(index);
        }
        if (index < item.get日常生活自立度リスト().size()) {
            source.ｌistNichijoseikatsujiritsudo_1 = item.get日常生活自立度リスト().get(index);
        }
        if (index < item.get特記リスト１().size()) {
            source.listTokki1_1 = item.get特記リスト１().get(index);
        }
        if (index < item.get特記リスト２().size()) {
            source.listTokki2_1 = item.get特記リスト２().get(index);
        }
        if (index < item.get特記リスト３().size()) {
            source.listTokki3_1 = item.get特記リスト３().get(index);
        }
        if (index < item.get特記リスト４().size()) {
            source.listTokki4_1 = item.get特記リスト４().get(index);
        }
        if (index < item.get特記リスト５().size()) {
            source.listTokki5_1 = item.get特記リスト５().get(index);
        }
        if (index < item.get特記リスト６().size()) {
            source.listTokki6_1 = item.get特記リスト６().get(index);
        }
        if (index < item.get特記リスト７().size()) {
            source.listTokki7_1 = item.get特記リスト７().get(index);
        }
        if (index < item.get第１群リスト().size()) {
            source.listIchigun_1 = item.get第１群リスト().get(index).get前回結果();
            source.listIchigun_2 = item.get第１群リスト().get(index).get段階改善フラグ();
            source.listIchigun_3 = item.get第１群リスト().get(index).get段階改善値();
            source.listIchigun_4 = item.get第１群リスト().get(index).get調査結果();
        }
        if (index < item.get第２群リスト().size()) {
            source.listNigun_1 = item.get第２群リスト().get(index).get前回結果();
            source.listNigun_2 = item.get第２群リスト().get(index).get段階改善フラグ();
            source.listNigun_3 = item.get第２群リスト().get(index).get段階改善値();
            source.listNigun_4 = item.get第２群リスト().get(index).get調査結果();
        }
        if (index < item.get第３群リスト().size()) {
            source.listSangun_1 = item.get第３群リスト().get(index).get前回結果();
            source.listSangun_2 = item.get第３群リスト().get(index).get段階改善フラグ();
            source.listSangun_3 = item.get第３群リスト().get(index).get段階改善値();
            source.listSangun_4 = item.get第３群リスト().get(index).get調査結果();
        }
        if (index < item.get第４群リスト().size()) {
            source.listYongun_1 = item.get第４群リスト().get(index).get前回結果();
            source.listYongun_2 = item.get第４群リスト().get(index).get段階改善フラグ();
            source.listYongun_3 = item.get第４群リスト().get(index).get段階改善値();
            source.listYongun_4 = item.get第４群リスト().get(index).get調査結果();
        }
        if (index < item.get第５群リスト().size()) {
            source.listGogun_1 = item.get第５群リスト().get(index).get前回結果();
            source.listGogun_2 = item.get第５群リスト().get(index).get段階改善フラグ();
            source.listGogun_3 = item.get第５群リスト().get(index).get段階改善値();
            source.listGogun_4 = item.get第５群リスト().get(index).get調査結果();
        }
        if (index < item.get第５群リスト().size()) {
            source.listGogun_1 = item.get第５群リスト().get(index).get前回結果();
            source.listGogun_2 = item.get第５群リスト().get(index).get段階改善フラグ();
            source.listGogun_3 = item.get第５群リスト().get(index).get段階改善値();
            source.listGogun_4 = item.get第５群リスト().get(index).get調査結果();
        }
        if (index < item.get特別な医療リスト１().size()) {
            source.listTokubetsunaIryo1_1 = item.get特別な医療リスト１().get(index).get調査結果();
            source.listTokubetsunaIryo1_2 = item.get特別な医療リスト１().get(index).get段階改善フラグ();
        }
        if (index < item.get特別な医療リスト２().size()) {
            source.listTokubetsunaIryo2_1 = item.get特別な医療リスト２().get(index).get調査結果();
            source.listTokubetsunaIryo2_2 = item.get特別な医療リスト２().get(index).get段階改善フラグ();
        }
        if (index < item.get主治医意見書().size()) {
            source.listshujiiikensho_1 = item.get特別な医療リスト２().get(index).get調査結果();
            source.listshujiiikensho_2 = item.get特別な医療リスト２().get(index).get段階改善フラグ();
            source.listshujiiikensho_3 = item.get特別な医療リスト２().get(index).get段階改善値();
            source.listshujiiikensho_4 = item.get特別な医療リスト２().get(index).get前回結果();
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

    private RString get元号(FlexibleDate 年月日) {
        if (年月日 != null && !年月日.isEmpty()) {
            return パターン12(年月日).getEra();
        }
        return RString.EMPTY;
    }

    private RString get年(FlexibleDate 年月日) {
        if (年月日 != null && !年月日.isEmpty()) {
            return パターン12(年月日).toDateString().substring(2, INT_4);
        }
        return RString.EMPTY;
    }

    private RString get月(FlexibleDate 年月日) {
        if (年月日 != null && !年月日.isEmpty()) {
            return new RString(年月日.getMonthValue());
        }
        return RString.EMPTY;
    }

    private RString get日(FlexibleDate 年月日) {
        if (年月日 != null && !年月日.isEmpty()) {
            return new RString(年月日.getDayValue());
        }
        return RString.EMPTY;
    }

    private FillTypeFormatted パターン12(FlexibleDate 年月日) {
        return 年月日.wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                .fillType(FillType.BLANK);
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
