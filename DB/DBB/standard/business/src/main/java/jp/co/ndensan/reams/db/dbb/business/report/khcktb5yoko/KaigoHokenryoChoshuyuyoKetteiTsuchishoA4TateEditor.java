/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.khcktb5yoko;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.choshuyuyo.KibetsuChoshyuYuyoKikan;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HyojiCodes;
import jp.co.ndensan.reams.db.dbb.entity.db.report.khcktb5yoko.KaigoHokenryoChoshuyuyoKetteiTsuchishoA4TateSource;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.FuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.Kitsuki;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.KitsukiList;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.TokuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.definition.core.fucho.FuchokiJohoTsukiShoriKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.Tsuki;
import jp.co.ndensan.reams.db.dbz.business.report.parts.kaigotoiawasesaki.CompKaigoToiawasesakiSource;
import jp.co.ndensan.reams.db.dbz.business.report.parts.kaigotoiawasesaki.IKaigoToiawasesakiSourceBuilder;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedAtesaki;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.ChoshuHohoKibetsu;
import jp.co.ndensan.reams.ur.urz.business.core.date.DateEditor;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.entity.report.sofubutsuatesaki.SofubutsuAtesakiSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 介護保険料徴収猶予決定通知書A4縦タイプ帳票Editor
 *
 * @reamsid_L DBB-0740-040 sunhui
 */
public class KaigoHokenryoChoshuyuyoKetteiTsuchishoA4TateEditor
        implements IKaigoHokenryoChoshuyuyoKetteiTsuchishoA4TateEditor {

    private final RString 文書番号;
    private final KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoJoho 徴収猶予決定通知書情報;
    private final RString 通知書定型文;
    private final IKaigoToiawasesakiSourceBuilder 介護問合せ先ソースビルダー;
    private final NinshoshaSource sourceBuilder;
    private final HyojiCodes 表示コード;
    private final int index;

    private static final int ONE = 1;
    private static final int ZERO = 0;
    private static final int TEN = 10;
    private static final RString RSTR_0 = new RString("　");
    private static final RString 随時 = new RString("随時");
    private static final RString 波線 = new RString("～");
    private static final RString 期_1 = new RString("01");
    private static final RString 期_2 = new RString("02");
    private static final RString 期_3 = new RString("03");
    private static final RString 期_4 = new RString("04");
    private static final RString 期_5 = new RString("05");
    private static final RString 期_6 = new RString("06");
    private static final RString 普徴期_4 = new RString("_4月");
    private static final RString 普徴期_5 = new RString("_5月");
    private static final RString 普徴期_6 = new RString("_6月");
    private static final RString 普徴期_7 = new RString("_7月");
    private static final RString 普徴期_8 = new RString("_8月");
    private static final RString 普徴期_9 = new RString("_9月");
    private static final RString 普徴期_10 = new RString("_10月");
    private static final RString 普徴期_11 = new RString("_11月");
    private static final RString 普徴期_12 = new RString("_12月");
    private static final RString 普徴期_1 = new RString("_1月");
    private static final RString 普徴期_2 = new RString("_2月");
    private static final RString 普徴期_3 = new RString("_3月");
    private static final RString 普徴期翌年度_4 = new RString("翌年度4月");
    private static final RString 普徴期翌年度_5 = new RString("翌年度5月");

    /**
     * コンストラクタです
     *
     * @param 文書番号 文書番号
     * @param 徴収猶予決定通知書情報 徴収猶予決定通知書情報
     * @param 通知書定型文 通知書定型文
     * @param 介護問合せ先ソースビルダー 介護問合せ先ソースビルダー
     * @param sourceBuilder sourceBuilder
     * @param 表示コード 表示コード
     * @param index index
     */
    public KaigoHokenryoChoshuyuyoKetteiTsuchishoA4TateEditor(RString 文書番号,
            KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoJoho 徴収猶予決定通知書情報,
            RString 通知書定型文, IKaigoToiawasesakiSourceBuilder 介護問合せ先ソースビルダー,
            NinshoshaSource sourceBuilder, HyojiCodes 表示コード, int index) {
        this.文書番号 = 文書番号;
        this.徴収猶予決定通知書情報 = 徴収猶予決定通知書情報;
        this.通知書定型文 = 通知書定型文;
        this.介護問合せ先ソースビルダー = 介護問合せ先ソースビルダー;
        this.sourceBuilder = sourceBuilder;
        this.表示コード = 表示コード;
        this.index = index;
    }

    @Override
    public KaigoHokenryoChoshuyuyoKetteiTsuchishoA4TateSource edit(
            KaigoHokenryoChoshuyuyoKetteiTsuchishoA4TateSource source) {

        KitsukiList 期月リスト_特徴;
        KitsukiList 期月リスト_普徴;
        TokuchoKiUtil 月期対応取得_特徴 = new TokuchoKiUtil();
        期月リスト_特徴 = 月期対応取得_特徴.get期月リスト();
        FuchoKiUtil 月期対応取得_普徴 = new FuchoKiUtil();
        期月リスト_普徴 = 月期対応取得_普徴.get期月リスト();
        List<KibetsuChoshyuYuyoKikan> 期別徴収猶予期間List = get期別徴収猶予期間リストを生成する(
                徴収猶予決定通知書情報, 期月リスト_特徴, 期月リスト_普徴, index);
        List<RString> 随時リスト = get随時リストを生成する(期月リスト_普徴, index);

        source.bunshoNo = 文書番号;
        source.choteiNendo = 徴収猶予決定通知書情報.get徴収猶予の情報().get調定年度();
        source.fukaNendo = 徴収猶予決定通知書情報.get徴収猶予の情報().get調定年度();
        source.ketteiKekka = 徴収猶予決定通知書情報.get徴収猶予の情報().get徴収猶予状態区分();
        source.hyojicodeName1 = 表示コード.get表示コード名１();
        source.hyojicodeName2 = 表示コード.get表示コード名２();
        source.hyojicodeName3 = 表示コード.get表示コード名３();
        source.hyojicode1 = 表示コード.get表示コード１();
        source.hyojicode2 = 表示コード.get表示コード２();
        source.hyojicode3 = 表示コード.get表示コード３();
        source.tsuchishoNo = 徴収猶予決定通知書情報.get徴収猶予の情報().get通知書番号();
        source.setaiCode = 徴収猶予決定通知書情報.get徴収猶予の情報().get世帯コード();
        source.hihokenshaNo = 徴収猶予決定通知書情報.get徴収猶予の情報().get被保険者番号();
        source.shikibetsuCode = 徴収猶予決定通知書情報.get徴収猶予の情報().get識別コード();
        source.ketteiYMD = 徴収猶予決定通知書情報.get徴収猶予の情報().get徴収猶予決定日();
        source.ketteiRiyu1 = 徴収猶予決定通知書情報.get徴収猶予の情報().get徴収猶予種類();
        source.ketteiRiyu2 = 徴収猶予決定通知書情報.get徴収猶予の情報().get徴収猶予取消事由();
        source.listKibetsu_1 = 期別徴収猶予期間List.get(0).get特徴期();
        source.listKibetsu_2 = 期別徴収猶予期間List.get(0).get特徴月();
        source.listKibetsu_3 = 期別徴収猶予期間List.get(0).get特徴期別金額();
        source.listKibetsu_4 = 期別徴収猶予期間List.get(0).get普徴期();
        source.listKibetsu_5 = 期別徴収猶予期間List.get(0).get普徴月();
        source.listKibetsu_6 = 期別徴収猶予期間List.get(0).get普徴期別金額();
        source.listKibetsu_7 = 期別徴収猶予期間List.get(0).get徴収猶予期間();
        source.listZuiji_1 = 随時リスト.get(0);
        source.bikoTitle = 通知書定型文;
        source.biko = 通知書定型文;

        source.hakkoYMD = sourceBuilder.hakkoYMD;
        source.denshiKoin = sourceBuilder.denshiKoin;
        source.ninshoshaYakushokuMei = sourceBuilder.ninshoshaYakushokuMei;
        source.koinMojiretsu = sourceBuilder.koinMojiretsu;
        source.ninshoshaShimeiKakenai = sourceBuilder.ninshoshaShimeiKakenai;
        source.ninshoshaShimeiKakeru = sourceBuilder.ninshoshaShimeiKakeru;
        source.koinShoryaku = sourceBuilder.koinShoryaku;

        CompKaigoToiawasesakiSource buildSource = 介護問合せ先ソースビルダー.buildSource();
        source.yubinBango = buildSource.yubinBango;
        source.shozaichi = buildSource.shozaichi;
        source.choshaBushoName = buildSource.choshaBushoName;
        source.tantoName = buildSource.tantoName;
        source.telNo = buildSource.telNo;
        source.naisenLabel = buildSource.naisenLabel;
        source.naisenNo = buildSource.naisenNo;

        // TODO
        EditedAtesaki 編集後宛先 = new EditedAtesaki(徴収猶予決定通知書情報.get宛先(),
                徴収猶予決定通知書情報.get地方公共団体(), 徴収猶予決定通知書情報.get帳票制御共通(),
                get送付物宛先ソース(), null, true, null, null, null, null);

        SofubutsuAtesakiSource sofuSource = 編集後宛先.getSofubutsuAtesakiSource().get送付物宛先ソース();

        source.yubinNo = sofuSource.yubinNo;
        source.gyoseiku = sofuSource.gyoseiku;
        source.jusho3 = sofuSource.jusho3;
        source.jushoText = sofuSource.jushoText;
        source.jusho1 = sofuSource.jusho1;
        source.jusho2 = sofuSource.jusho2;
        source.katagakiText = sofuSource.katagakiText;
        source.katagaki2 = sofuSource.katagaki2;
        source.katagakiSmall2 = sofuSource.katagakiSmall2;
        source.katagaki1 = sofuSource.katagaki1;
        source.katagakiSmall1 = sofuSource.katagakiSmall1;
        source.kakkoRight2 = sofuSource.kakkoRight2;
        source.kakkoRight1 = sofuSource.kakkoRight1;
        source.shimei2 = sofuSource.shimei2;
        source.shimeiSmall2 = sofuSource.shimeiSmall2;
        source.shimeiText = sofuSource.shimeiText;
        source.meishoFuyo2 = sofuSource.meishoFuyo2;
        source.shimeiSmall1 = sofuSource.shimeiSmall1;
        source.dainoKubunMei = sofuSource.dainoKubunMei;
        source.shimei1 = sofuSource.shimei1;
        source.meishoFuyo1 = sofuSource.meishoFuyo1;
        source.samabunShimeiText = sofuSource.samabunShimeiText;
        source.samabunShimeiSmall2 = sofuSource.samabunShimeiSmall2;
        source.samaBun2 = sofuSource.samaBun2;
        source.kakkoLeft2 = sofuSource.kakkoLeft2;
        source.samabunShimei2 = sofuSource.samabunShimei2;
        source.kakkoLeft1 = sofuSource.kakkoLeft1;
        source.samabunShimei1 = sofuSource.samabunShimei1;
        source.samaBun1 = sofuSource.samaBun1;
        source.samabunShimeiSmall1 = sofuSource.samabunShimeiSmall1;
        source.customerBarCode = sofuSource.customerBarCode;
        // TODO QA:581
//        source.setainusimei = sofuSource.setainusimei;
//        source.samaKata = sofuSource.samaKata;
        return source;
    }

    private List<KibetsuChoshyuYuyoKikan> get期別徴収猶予期間リストを生成する(
            KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoJoho 徴収猶予決定通知書情報,
            KitsukiList 期月リスト_特徴, KitsukiList 期月リスト_普徴, int index) {

        List<KibetsuChoshyuYuyoKikan> 期別徴収猶予期間List = new ArrayList<>();
        KibetsuChoshyuYuyoKikan 期別徴収猶予期間 = new KibetsuChoshyuYuyoKikan();
        Kitsuki 特徴期月 = 期月リスト_特徴.get期の最初月(index);
        Kitsuki 普徴期月 = 期月リスト_普徴.get期の最初月(index);
        if (特徴期月.isPresent()) {
            期別徴収猶予期間.set特徴期(edit2桁文字列(特徴期月.get期()));
            期別徴収猶予期間.set特徴月(editInt2桁文字列(特徴期月.get月AsInt()));
            期別徴収猶予期間.set特徴期別金額(DecimalFormatter
                    .toコンマ区切りRString(get期と特徴期別金額の対応(徴収猶予決定通知書情報, 特徴期月.get期()), 0));
        } else {
            期別徴収猶予期間.set特徴期(RString.EMPTY);
            期別徴収猶予期間.set特徴月(RString.EMPTY);
            期別徴収猶予期間.set特徴期別金額(RString.EMPTY);
        }

        if (普徴期月.isPresent()) {
            期別徴収猶予期間.set普徴期(edit2桁文字列(普徴期月.get期()));
            期別徴収猶予期間.set普徴月(editInt2桁文字列(普徴期月.get月AsInt()));
            期別徴収猶予期間.set普徴期別金額(DecimalFormatter
                    .toコンマ区切りRString(get月と普徴期別金額の対応(徴収猶予決定通知書情報, 普徴期月.get月()), 0));
            期別徴収猶予期間.set徴収猶予期間(get徴収猶予期間(徴収猶予決定通知書情報, 普徴期月));
        } else {
            期別徴収猶予期間.set普徴期(RString.EMPTY);
            期別徴収猶予期間.set普徴月(RString.EMPTY);
            期別徴収猶予期間.set普徴期別金額(RString.EMPTY);
            期別徴収猶予期間.set徴収猶予期間(RString.EMPTY);
        }
        期別徴収猶予期間List.add(期別徴収猶予期間);
        return 期別徴収猶予期間List;
    }

    private List<RString> get随時リストを生成する(KitsukiList 期月リスト_普徴, int index) {

        List<RString> 随時リスト = new ArrayList<>();
        Kitsuki 普徴期月 = 期月リスト_普徴.get期の最初月(index);
        if (FuchokiJohoTsukiShoriKubun.随時.equals(普徴期月.get月処理区分())
                || FuchokiJohoTsukiShoriKubun.現年随時.equals(普徴期月.get月処理区分())) {
            随時リスト.add(随時);
        } else {
            随時リスト.add(RString.EMPTY);
        }
        return 随時リスト;
    }

    private RString edit2桁文字列(RString 期) {
        if (ONE == 期.length()) {
            期 = new RString(RSTR_0 + 期.toString());
        }
        return 期;
    }

    private RString editInt2桁文字列(int 月) {
        RString 月AsInt = new RString(String.valueOf(月));
        if (月 < TEN && 月 >= ZERO) {
            月AsInt = new RString(RSTR_0 + String.valueOf(月));
        }
        return 月AsInt;
    }

    private Decimal get期と特徴期別金額の対応(
            KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoJoho 徴収猶予決定通知書情報, RString 期) {

        if (期_1.equals(期)) {
            return 徴収猶予決定通知書情報.get徴収猶予の情報().get特徴期別金額01();
        } else if (期_2.equals(期)) {
            return 徴収猶予決定通知書情報.get徴収猶予の情報().get特徴期別金額02();
        } else if (期_3.equals(期)) {
            return 徴収猶予決定通知書情報.get徴収猶予の情報().get特徴期別金額03();
        } else if (期_4.equals(期)) {
            return 徴収猶予決定通知書情報.get徴収猶予の情報().get特徴期別金額04();
        } else if (期_5.equals(期)) {
            return 徴収猶予決定通知書情報.get徴収猶予の情報().get特徴期別金額05();
        } else if (期_6.equals(期)) {
            return 徴収猶予決定通知書情報.get徴収猶予の情報().get特徴期別金額06();
        } else {
            return Decimal.ZERO;
        }
    }

    private Decimal get月と普徴期別金額の対応(
            KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoJoho 徴収猶予決定通知書情報, Tsuki 月) {

        RString 普徴月 = new RString(月.toString());
        if (普徴期_4.equals(普徴月)) {
            return 徴収猶予決定通知書情報.get徴収猶予の情報().get普徴期別金額01();
        } else if (普徴期_5.equals(普徴月)) {
            return 徴収猶予決定通知書情報.get徴収猶予の情報().get普徴期別金額02();
        } else if (普徴期_6.equals(普徴月)) {
            return 徴収猶予決定通知書情報.get徴収猶予の情報().get普徴期別金額03();
        } else if (普徴期_7.equals(普徴月)) {
            return 徴収猶予決定通知書情報.get徴収猶予の情報().get普徴期別金額04();
        } else if (普徴期_8.equals(普徴月)) {
            return 徴収猶予決定通知書情報.get徴収猶予の情報().get普徴期別金額05();
        } else if (普徴期_9.equals(普徴月)) {
            return 徴収猶予決定通知書情報.get徴収猶予の情報().get普徴期別金額06();
        } else if (普徴期_10.equals(普徴月)) {
            return 徴収猶予決定通知書情報.get徴収猶予の情報().get普徴期別金額07();
        } else if (普徴期_11.equals(普徴月)) {
            return 徴収猶予決定通知書情報.get徴収猶予の情報().get普徴期別金額08();
        } else if (普徴期_12.equals(普徴月)) {
            return 徴収猶予決定通知書情報.get徴収猶予の情報().get普徴期別金額09();
        } else if (普徴期_1.equals(普徴月)) {
            return 徴収猶予決定通知書情報.get徴収猶予の情報().get普徴期別金額10();
        } else if (普徴期_2.equals(普徴月)) {
            return 徴収猶予決定通知書情報.get徴収猶予の情報().get普徴期別金額11();
        } else if (普徴期_3.equals(普徴月)) {
            return 徴収猶予決定通知書情報.get徴収猶予の情報().get普徴期別金額12();
        } else if (普徴期翌年度_4.equals(普徴月)) {
            return 徴収猶予決定通知書情報.get徴収猶予の情報().get普徴期別金額13();
        } else if (普徴期翌年度_5.equals(普徴月)) {
            return 徴収猶予決定通知書情報.get徴収猶予の情報().get普徴期別金額14();
        } else {
            return Decimal.ZERO;
        }
    }

    private RString get徴収猶予期間(KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoJoho 徴収猶予決定通知書情報, Kitsuki 普徴期月) {

        RString 徴収猶予期間 = RString.EMPTY;
        ChoshuYuyoJoho choshuYuyoJoho = 徴収猶予決定通知書情報.get徴収猶予の情報();
        if (choshuYuyoJoho == null) {
            return 徴収猶予期間;
        }
        RString 徴収方法 = choshuYuyoJoho.get介護期別徴収猶予().getChoshuHoho();
        RString 期 = new RString(String.valueOf(choshuYuyoJoho.get介護期別徴収猶予().getKi()));
        if (ChoshuHohoKibetsu.普通徴収.code().equals(徴収方法) && 普徴期月.get期().equals(期)) {
            徴収猶予期間 = new RString(DateEditor.to西暦(choshuYuyoJoho.get介護期別徴収猶予().getYuyoStartYMD()).toString()
                    + 波線.toString() + DateEditor.to西暦(choshuYuyoJoho.get介護期別徴収猶予().getYuyoEndYMD()).toString());
        }
        return 徴収猶予期間;
    }

    private SofubutsuAtesakiSource get送付物宛先ソース() {
        SofubutsuAtesakiSource 送付物宛先ソース = new SofubutsuAtesakiSource();
        送付物宛先ソース.yubinNo = new RString("1");
        送付物宛先ソース.gyoseiku = new RString("1");
        送付物宛先ソース.jusho3 = new RString("2");
        送付物宛先ソース.jushoText = new RString("3");
        送付物宛先ソース.jusho1 = new RString("4");
        送付物宛先ソース.jusho2 = new RString("5");
        送付物宛先ソース.katagakiText = new RString("6");
        送付物宛先ソース.katagaki2 = new RString("7");
        送付物宛先ソース.katagakiSmall2 = new RString("8");
        送付物宛先ソース.katagaki1 = new RString("9");
        送付物宛先ソース.katagakiSmall1 = new RString("10");
        送付物宛先ソース.shimei2 = new RString("11");
        送付物宛先ソース.shimeiSmall2 = new RString("12");
        送付物宛先ソース.shimeiText = new RString("13");
        送付物宛先ソース.meishoFuyo2 = new RString("14");
        送付物宛先ソース.shimeiSmall1 = new RString("15");
        送付物宛先ソース.dainoKubunMei = new RString("16");
        送付物宛先ソース.shimei1 = new RString("17");
        送付物宛先ソース.meishoFuyo1 = new RString("18");
        送付物宛先ソース.samabunShimeiText = new RString("19");
        送付物宛先ソース.kakkoLeft2 = new RString("20");
        送付物宛先ソース.samabunShimei2 = new RString("21");
        送付物宛先ソース.samaBun2 = new RString("22");
        送付物宛先ソース.kakkoRight2 = new RString("23");
        送付物宛先ソース.kakkoLeft1 = new RString("24");
        送付物宛先ソース.samabunShimei1 = new RString("25");
        送付物宛先ソース.samaBun1 = new RString("26");
        送付物宛先ソース.kakkoRight1 = new RString("27");
        送付物宛先ソース.samabunShimeiSmall1 = new RString("28");
        送付物宛先ソース.customerBarCode = new RString("29");
        return 送付物宛先ソース;
    }

}
