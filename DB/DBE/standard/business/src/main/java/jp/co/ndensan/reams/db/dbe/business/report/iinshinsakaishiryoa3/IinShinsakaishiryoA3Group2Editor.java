/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.iinshinsakaishiryoa3;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.IchijihanteikekkahyoA3Business;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsakaishiryo.IinShinsakaiShiryoA3Layouts;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteikekkahyo.IchijihanteikekkahyoA3Entity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.iinshinsakaishiryoa3.IinShinsakaishiryoA3ReportSource;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ServiceKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.TokkijikoTextImageKubun;
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
    private static final RString サービス区分コード1 = new RString("1");
    private static final RString サービス区分コード2 = new RString("2");
    private static final RString 特記事項テキスト_イメージ区分1 = new RString("1");
    private static final RString 特記事項テキスト_イメージ区分2 = new RString("2");
    private static final RString 特記パターン1 = new RString("1");
    private static final RString 特記パターン2 = new RString("2");
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
    private final IchijihanteikekkahyoA3Business item;
    private final List<RString> 特記事項List;
    private final int index;
    private final int 審査番号;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link IchijihanteikekkahyoA3Entity}
     * @param 特記事項List List<RString>
     * @param index int
     * @param 審査番号 int
     */
    protected IinShinsakaishiryoA3Group2Editor(IchijihanteikekkahyoA3Business item, List<RString> 特記事項List, int index, int 審査番号) {
        this.item = item;
        this.特記事項List = 特記事項List;
        this.index = index;
        this.審査番号 = 審査番号;
    }

    @Override
    public IinShinsakaishiryoA3ReportSource edit(IinShinsakaishiryoA3ReportSource source) {
        return editSource(source);
    }

    private IinShinsakaishiryoA3ReportSource editSource(IinShinsakaishiryoA3ReportSource source) {
        source.shinseiCount = new RString(審査番号);
        source.shinseiCountGokei = item.get審査人数合計();
        source.shinsakaiOrder = item.get審査人数();
        source.gogitaiNo = item.get合議体番号();
        source.kanriNo = item.get管理番号();
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
        source.zenkaiNijihanteiDate = パターン16(item.get前回認定日());
        source.zenkaiJotaizo = item.get前回状態像();
        source.shinseiGengo = get元号(item.get今回認定申請年月日());
        source.shinseiYY = get年(item.get今回認定申請年月日());
        source.shinseiMM = get月(item.get今回認定申請年月日());
        source.shinseiDD = get日(item.get今回認定申請年月日());
        source.sakuseiGengo = get元号(item.get審査会資料作成年月日());
        source.sakuseiYY = get年(item.get審査会資料作成年月日());
        source.sakuseiMM = get月(item.get審査会資料作成年月日());
        source.sakuseiDD = get日(item.get審査会資料作成年月日());
        source.chosaGengo = get元号(item.get今回認定調査実施年月日());
        source.chosaYY = get年(item.get今回認定調査実施年月日());
        source.chosaMM = get月(item.get今回認定調査実施年月日());
        source.chosaDD = get日(item.get今回認定調査実施年月日());
        source.shinsaGengo = get元号(item.get今回認定審査年月日());
        source.shinsaYY = get年(item.get今回認定審査年月日());
        source.shinsaMM = get月(item.get今回認定審査年月日());
        source.shinsaDD = get日(item.get今回認定審査年月日());
        source.ichijiHanteiKekka = item.get一次判定結果();
        source.chosaJisshiDate1 = パターン17(item.get調査日());
        source.chosaJisshiBasho = item.get調査実施場所();
        source.tokuteishippeiName = item.get特定疾病名();
        source.kijunGokeiTime = item.get要介護認定等基準時間();
        source.zenkaiKijunGokeiTime = item.get前回要介護認定等基準時間();
        source.gurafuKijunTime = item.get基準時間の積み上げグラフ();
        source.listKijunTime_1 = item.get要介護認定等基準時間_食事();
        source.listKijunTime_2 = item.get要介護認定等基準時間_排泄();
        source.listKijunTime_3 = item.get要介護認定等基準時間_移動();
        source.listKijunTime_4 = item.get要介護認定等基準時間_清潔保持();
        source.listKijunTime_5 = item.get要介護認定等基準時間_間接();
        source.listKijunTime_6 = item.get要介護認定等基準時間_BPSD関連();
        source.listKijunTime_7 = item.get要介護認定等基準時間_機能訓練();
        source.listKijunTime_8 = item.get要介護認定等基準時間_医療関連();
        source.listKijunTime_9 = item.get要介護認定等基準時間_認知症加算();
        source.keikokuNo = item.get警告コード();
        source.chosaNinchishoJiritsudo = item.get認定調査結果認知症高齢者自立度();
        source.ikenNinchiJiritsudo = item.get意見書認知症高齢者自立度();
        source.manzensei = item.get認知症自立度Ⅱ以上の蓋然性();
        source.jotainoanteisei = item.get状態の安定性();
        source.kyufukubun = item.get給付区分();
        source.sabisuKubun = item.getSabisuKubun();
        source.sabisuName1 = item.getサービス名称1();
        source.sabisuName2 = item.getサービス名称2();
        source.sabisuName3 = item.getサービス名称3();
        source.sabisuName4 = item.getサービス名称4();
        source.sabisuName5 = item.getサービス名称5();
        source.sabisuName6 = item.getサービス名称6();
        source.sabisuName7 = item.getサービス名称7();
        source.sabisuName8 = item.getサービス名称8();
        source.sabisuName9 = item.getサービス名称9();
        source.sabisuName10 = item.getサービス名称10();
        source.sabisuName11 = item.getサービス名称11();
        source.sabisuName12 = item.getサービス名称12();
        source.sabisuName13 = item.getサービス名称13();
        source.sabisuName14 = item.getサービス名称14();
        source.sabisuName15 = item.getサービス名称15();
        source.sabisuName16 = item.getサービス名称16();
        source.sabisuName17 = item.getサービス名称17();
        source.sabisuName18 = item.getサービス名称18();
        source.sabisuName19 = item.getサービス名称19();
        source.sabisuName20 = item.getサービス名称20();
        source.sabisuName21 = item.getサービス名称21();
        source.sabisuKaisu1 = item.getサービス回数1();
        source.sabisuKaisu2 = item.getサービス回数2();
        source.sabisuKaisu3 = item.getサービス回数3();
        source.sabisuKaisu4 = item.getサービス回数4();
        source.sabisuKaisu5 = item.getサービス回数5();
        source.sabisuKaisu6 = item.getサービス回数6();
        source.sabisuKaisu7 = item.getサービス回数7();
        source.sabisuKaisu8 = item.getサービス回数8();
        source.sabisuKaisu9 = item.getサービス回数9();
        source.sabisuKaisu10 = item.getサービス回数10();
        source.sabisuKaisu11 = item.getサービス回数11();
        source.sabisuKaisu12 = item.getサービス回数12();
        source.sabisuKaisu13 = item.getサービス回数13();
        source.sabisuKaisu14 = item.getサービス回数14();
        source.sabisuKaisu15 = item.getサービス回数15();
        source.sabisuKaisu16 = item.getサービス回数16();
        source.sabisuKaisu17 = item.getサービス回数17();
        source.sabisuKaisu18 = item.getサービス回数18();
        source.sabisuKaisu19 = item.getサービス回数19();
        source.sabisuKaisu20 = item.getサービス回数20();
        source.sabisuKaisu21 = item.getサービス回数21();
        source = editSource1(source);
        source.shisetsuType = item.get利用施設種類();
        source.shisetsuNameTxit = item.get施設名テキスト();
        source.shisetsuAddressTxit = item.get住所テキスト();
        source.shisetsuTelTxit = item.get電話番号テキスト();
        source.imgShisetsuName = item.get施設名イメージ();
        source.imgShisetsuAddress = item.get住所イメージ();
        source.imgShisetsuTel = item.get電話番号イメージ();
        source.shisetsuName = new RString("施設名　：");
        source.jusho = new RString("住所　〒");
        source.telNo = new RString("TEL");
        source.notes1 = item.get凡例1();
        source.notes2 = item.get凡例2();
        source.notes3 = item.get凡例3();
        source.notes4 = item.get凡例4();
        source.notes5 = item.get凡例5();
        source.notes6 = item.get凡例6();
        source.oldVersion = item.get前回結果バージョン記号();
//        ToDo:
//        組み合わせ帳票はサービス区分ごとにlayoutを切り替えなくても、サービス区分『なし』のフォームの組み合わせで
//        すべて賄うことができるため、条件分けしない。
//        if (サービス区分コード1.equals(item.getSabisuKubun())) {
//            setLayout1(source);
//        } else if (サービス区分コード2.equals(item.getSabisuKubun())) {
//            setLayout2(source);
//        } else {
        setLayout3(source);
//        }
        return source;
    }

    private void setLayout1(IinShinsakaishiryoA3ReportSource source) {
        if (特記事項テキスト_イメージ区分1.equals(item.get特記事項テキスト_イメージ区分())
                && 特記パターン1.equals(item.get特記パターン())) {
            source.layout = IinShinsakaiShiryoA3Layouts.委員用一次判定結果票_予防給付_テキスト.index();
        } else if (特記事項テキスト_イメージ区分1.equals(item.get特記事項テキスト_イメージ区分())
                && 特記パターン2.equals(item.get特記パターン())) {
            source.layout = IinShinsakaiShiryoA3Layouts.委員用一次判定結果票_予防給付_短冊テキスト.index();
        } else if (特記事項テキスト_イメージ区分2.equals(item.get特記事項テキスト_イメージ区分())
                && 特記パターン1.equals(item.get特記パターン())) {
            source.layout = IinShinsakaiShiryoA3Layouts.委員用一次判定結果票_予防給付_全イメージ.index();
        } else if (特記事項テキスト_イメージ区分2.equals(item.get特記事項テキスト_イメージ区分())
                && 特記パターン2.equals(item.get特記パターン())) {
            source.layout = IinShinsakaiShiryoA3Layouts.委員用一次判定結果票_予防給付_短冊イメージ.index();
        }
    }

    private void setLayout2(IinShinsakaishiryoA3ReportSource source) {
        if (特記事項テキスト_イメージ区分1.equals(item.get特記事項テキスト_イメージ区分())
                && 特記パターン1.equals(item.get特記パターン())) {
            source.layout = IinShinsakaiShiryoA3Layouts.委員用一次判定結果票_介護給付_テキスト.index();
        } else if (特記事項テキスト_イメージ区分1.equals(item.get特記事項テキスト_イメージ区分())
                && 特記パターン2.equals(item.get特記パターン())) {
            source.layout = IinShinsakaiShiryoA3Layouts.委員用一次判定結果票_介護給付_短冊テキスト.index();
        } else if (特記事項テキスト_イメージ区分2.equals(item.get特記事項テキスト_イメージ区分())
                && 特記パターン1.equals(item.get特記パターン())) {
            source.layout = IinShinsakaiShiryoA3Layouts.委員用一次判定結果票_介護給付_全イメージ.index();
        } else if (特記事項テキスト_イメージ区分2.equals(item.get特記事項テキスト_イメージ区分())
                && 特記パターン2.equals(item.get特記パターン())) {
            source.layout = IinShinsakaiShiryoA3Layouts.委員用一次判定結果票_介護給付_短冊イメージ.index();
        }
    }

    private void setLayout3(IinShinsakaishiryoA3ReportSource source) {
        if (特記事項テキスト_イメージ区分1.equals(item.get特記事項テキスト_イメージ区分())
                && 特記パターン1.equals(item.get特記パターン())) {
            source.layout = IinShinsakaiShiryoA3Layouts.委員用一次判定結果票_テキスト.index();
        } else if (特記事項テキスト_イメージ区分1.equals(item.get特記事項テキスト_イメージ区分())
                && 特記パターン2.equals(item.get特記パターン())) {
            source.layout = IinShinsakaiShiryoA3Layouts.委員用一次判定結果票_短冊テキスト.index();
        } else if (特記事項テキスト_イメージ区分2.equals(item.get特記事項テキスト_イメージ区分())
                && 特記パターン1.equals(item.get特記パターン())) {
            source.layout = IinShinsakaiShiryoA3Layouts.委員用一次判定結果票_全イメージ.index();
        } else if (特記事項テキスト_イメージ区分2.equals(item.get特記事項テキスト_イメージ区分())
                && 特記パターン2.equals(item.get特記パターン())) {
            source.layout = IinShinsakaiShiryoA3Layouts.委員用一次判定結果票_短冊イメージ.index();
        }
    }

    private IinShinsakaishiryoA3ReportSource editSource1(IinShinsakaishiryoA3ReportSource source) {
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

    private IinShinsakaishiryoA3ReportSource editSource2(IinShinsakaishiryoA3ReportSource source) {
        if (テキスト.equals(item.get概況調査テキスト_イメージ区分())) {
            source.gaikyotokkiText = item.get概況特記のテキスト();
        } else if (イメージ.equals(item.get概況調査テキスト_イメージ区分())) {
            source.gaikyotokkiImg = item.get概況特記のイメージ();
        }
        if (TokkijikoTextImageKubun.テキスト.getコード().equals(item.get特記事項テキスト_イメージ区分())) {
            if (全面.equals(item.get特記パターン())) {
                source.tokkiText = get特記事項_tokkiText(0);
            } else if (短冊.equals(item.get特記パターン())) {
                source = set特記事項テキスト連番_名称(source);
            }
        } else if (TokkijikoTextImageKubun.イメージ.getコード().equals(item.get特記事項テキスト_イメージ区分())) {
            if (全面.equals(item.get特記パターン())) {
                source.tokkiImg = get特記事項_tokkiImg(0);
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

    private IinShinsakaishiryoA3ReportSource set特記事項テキスト連番_名称(IinShinsakaishiryoA3ReportSource source) {
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
        年齢歳.append(年齢);
        年齢歳.append(new RString("歳"));
        return 年齢歳.toRString();
    }

    private RString get元号(FlexibleDate 年月日) {
        if (年月日 != null && !年月日.isEmpty()) {
            return パターン12(年月日).substring(0, 2);
        }
        return RString.EMPTY;
    }

    private RString get年(FlexibleDate 年月日) {
        if (年月日 != null && !年月日.isEmpty()) {
            return パターン12(年月日).substring(2, INT_4);
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

    private RString パターン12(FlexibleDate 年月日) {
        return 年月日.wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                .fillType(FillType.BLANK).toDateString();
    }

    private RString パターン16(FlexibleDate 年月日) {
        if (年月日 == null || 年月日.isEmpty()) {
            return RString.EMPTY;
        }
        return 年月日.wareki().eraType(EraType.ALPHABET)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD)
                .fillType(FillType.ZERO).toDateString();
    }

    private RString パターン17(FlexibleDate 年月日) {
        if (年月日 == null || 年月日.isEmpty()) {
            return RString.EMPTY;
        }
        return 年月日.wareki().eraType(EraType.ALPHABET)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD)
                .fillType(FillType.ZERO).toDateString();
    }
}
